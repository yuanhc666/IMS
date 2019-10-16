package com.zhdtedu.riverchiefs.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhdtedu.riverchiefs.dao.entity.BasinInfo;
import com.zhdtedu.riverchiefs.dao.entity.BasinInfoExample;
import com.zhdtedu.riverchiefs.dao.entity.TreeNode;
import com.zhdtedu.riverchiefs.dao.mapper.BasinInfoMapper;
import com.zhdtedu.util.ExceptionUtil;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class BasinInfoServiceImpl implements BasinInfoService {
    @Autowired
    private BasinInfoMapper basinInfoMapper;

    @Transactional(readOnly = true)
    @Override
    public RcsResult getBasinList(Long parentId, int pageNo) {
        List<BasinInfo> basinList = null;
        int pageSize = 5;
        PageModel pageModel = null;
        try {
            PageHelper.startPage(pageNo, pageSize);

            Page<BasinInfo> page = (Page<BasinInfo>) basinInfoMapper.selectByBasinExample(parentId, pageNo, pageSize);
            pageModel = new PageModel(pageNo, (int) page.getTotal(), pageSize);
            pageModel.setList(page.getResult());
            pageModel.setTotalRecords((int) page.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            RcsResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return RcsResult.ok(pageModel);
    }

    @Transactional(readOnly = true)
    @Override
    public int getTotalCount(Long parentId) {
        return basinInfoMapper.getTotalCount(parentId);
    }


    @Override
    public RcsResult saveBasin(BasinInfo basinInfo) {
        try {
            basinInfo.setCreateTime(new Date());
            basinInfo.setUpdateTime(new Date());
            basinInfoMapper.insert(basinInfo);
            //新增子节点同时更新子节点对应的父节点的isParent
            basinInfoMapper.updateParent(basinInfo.getParentId());
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return RcsResult.build(201, "新增成功", null);
    }

    @Transactional(readOnly = true)
    @Override
    public RcsResult getBasinById(Long id) {
        BasinInfo basinInfo = null;
        try {
            basinInfo = basinInfoMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        return RcsResult.ok(basinInfo);
    }

    @Override
    public RcsResult updateBasin(BasinInfo basinInfo) {
        try {
            basinInfo.setUpdateTime(new Date());
            basinInfoMapper.updateByPrimaryKey(basinInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());

        }

        return RcsResult.ok();
    }

    @Override
    public RcsResult deleteBasinById(Long id) {
        try {
            //如果子节点删除成功，判断父节点下是否有子节点，如果有isParent不用更新，否则更新isParent=0
            BasinInfo basinInfo=  basinInfoMapper.selectByPrimaryKey(id);
            Long parentId=basinInfo.getParentId();
            basinInfoMapper.deleteByPrimaryKey(id);
            //根据删除数据的parentId查找是否还有子节点
           if(basinInfoMapper.selectNodesByParentId(parentId)==0) {
               //更新父节点的isParent=0
               basinInfoMapper.updateIsParent(parentId);
           }


        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        return RcsResult.build(204, "删除成功", null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<?> getBasinNodeList(Long parentId) {
        List<BasinInfo> basinList = new ArrayList<>();
        BasinInfoExample example = new BasinInfoExample();
        BasinInfoExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        basinList = basinInfoMapper.selectByExample(example);
        System.out.println(basinList.get(0));
        //创建空的list
        List dataList = new ArrayList<>();
        //循环遍历节点
        for (BasinInfo basinInfo : basinList) {
            //循环创建节点
            TreeNode treeCode = new TreeNode();
            treeCode.setId(basinInfo.getId());
            treeCode.setLabel(basinInfo.getName());
            //如果parentId=0就代表是父节点
            if(basinInfo.getIsParent()==1) {
                //使用递归调用自己本身
                treeCode.setChildren(getBasinNodeList(basinInfo.getId()));
                dataList.add(treeCode);
              } else {
                //子节点设置parentId
                treeCode.setParentId(basinInfo.getParentId());
                //在空的dataList中添加节点
                dataList.add(treeCode);

            }



        }
        return  dataList;
    }
}




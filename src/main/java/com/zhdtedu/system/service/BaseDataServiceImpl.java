package com.zhdtedu.system.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhdtedu.system.dao.entity.BaseData;
import com.zhdtedu.system.dao.entity.BaseDataExample;
import com.zhdtedu.system.dao.mapper.BaseDataMapper;
import com.zhdtedu.util.ExceptionUtil;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import com.zhdtedu.util.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BaseDataServiceImpl implements BaseDataService {
    @Autowired
    private BaseDataMapper baseDataMapper;
    @Transactional(readOnly = true)
    @Override
    public RcsResult getBaseDataList(SearchCondition sc) {
        //获取前端参数
        Map<String,Object> param = sc.getParameter();
        param.put("pageNo",sc.getPageNo());
        param.put("pageSize",sc.getPageSize());
        PageModel pageModel=null;
        try{//分页插件pageHelper进行分页
            PageHelper.startPage(sc.getPageNo(),sc.getPageSize());
            Page<BaseData> page= (Page<BaseData>) baseDataMapper.selectByCondition(param);
            param.put("totalRecords",page.getTotal());
            //调用有参构造获取pageModel对象
            pageModel=new PageModel(sc.getPageNo(),(int)page.getTotal(),sc.getPageSize());
            //完善pageModel属性
            pageModel.setList(page.getResult());
            pageModel.setTotalRecords((int)page.getTotal());

        }catch (Exception e){
            e.printStackTrace();
            RcsResult.build(500,ExceptionUtil.getStackTrace(e));
        }

        return RcsResult.ok(pageModel);
    }

    @Transactional(readOnly = true)
    @Override
    public int getTotalCount(Long parentId) {
        return baseDataMapper.getTotalCount(parentId);
    }

    @Transactional(readOnly = true)
    @Override
    public RcsResult getBaseData(long id) {

        BaseData baseData=new BaseData();
        try {
            baseData = baseDataMapper.selectByPrimaryKey(id);
            System.out.println("baseData.getDESCRIPTION()"+baseData.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
            RcsResult.build(500,e.getMessage());
        } finally {
        }
        return RcsResult.ok(baseData);
    }

    @Override
    public RcsResult updateBaseData(BaseData baseData) {
        //补全字段在mapper中实现
        try {  baseData.setUpdateTime(new Date());
            baseDataMapper.updateByPrimaryKey(baseData);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.ok();
    }

    @Override
    public RcsResult deleteBaseDataById(long id) {

        try {
            baseDataMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.build(200,"删除成功",null);
    }

    @Override
    public RcsResult saveBaseData(BaseData baseData) {
        try { //补全字段
            if(baseData.getCreateTime()==null|| baseData.getUpdateTime()==null){
                baseData.setCreateTime(new Date());
                baseData.setUpdateTime(new Date());
            }
            baseDataMapper.insert(baseData);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500, ExceptionUtil.getStackTrace(e));
        }

        return RcsResult.build(201,"新增成功",null);

    }
    @Transactional(readOnly = true)
    @Override
    public RcsResult getNodeList() {
        List<BaseData> baseDataList =null;
        BaseDataExample example= new BaseDataExample();
        BaseDataExample.Criteria criteria= example.createCriteria();
        try {
            baseDataList = baseDataMapper.selectByExample(example);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.ok(baseDataList);
    }
}

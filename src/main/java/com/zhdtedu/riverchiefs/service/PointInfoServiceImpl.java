package com.zhdtedu.riverchiefs.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhdtedu.riverchiefs.dao.entity.PointInfo;
import com.zhdtedu.riverchiefs.dao.mapper.PointInfoMapper;
import com.zhdtedu.util.ExceptionUtil;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class PointInfoServiceImpl implements PointInfoService {
    @Autowired
    private PointInfoMapper pointInfoMapper;
    @Transactional(readOnly = true)
    @Override
    public RcsResult getPointInfoList(String code, String name,int pageNo) {
        List<PointInfo> pointInfoList= null;
        int pageSize=5;
        PageModel pageModel=null;
        try {
            PageHelper.startPage(pageNo,pageSize);

            Page<PointInfo> page= (Page<PointInfo>) pointInfoMapper.selectByPointExample(code,name,pageNo,pageSize);
            pageModel=new PageModel(pageNo,(int)page.getTotal(),pageSize);
            pageModel.setList(page.getResult());
            pageModel.setTotalRecords((int)page.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            RcsResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return   RcsResult.ok(pageModel);

    }
 /*   @Transactional(readOnly = true)
    @Override
    public int getTotalCount(Long code, String name){
        return pointInfoMapper.getTotalCount(code,name);
    }*/

    @Override
    public RcsResult savePointInfo(PointInfo pointInfo) {
        try{ pointInfo.setUpdateTime(new Date());
            pointInfo.setCreateTime(new Date());
            pointInfoMapper.insert(pointInfo);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.build(201,"新增成功",null);

    }
    @Transactional(readOnly = true)
    @Override
    public RcsResult getPointInfoById(Long id) {
        PointInfo pointInfo =null;
        try{
            pointInfo =   pointInfoMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.ok(pointInfo);

    }

    @Override
    public RcsResult updatePointInfo(PointInfo pointInfo) {

        try{//补全字段
           // pointInfo.setUpdateTime(new Date());
            pointInfoMapper.updateByPrimaryKey(pointInfo);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());

        }

        return RcsResult.ok();
    }

    @Override
    public RcsResult deletePointInfoById(Long id) {
        try{
            pointInfoMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            return   RcsResult.build(500,e.getMessage());
        }
        return  RcsResult.ok();


    }

    @Override
    public RcsResult getAllList() {
        List<PointInfo> pointsList= null;
        try{
            pointsList=  pointInfoMapper.selectAllPoints();
        }catch (Exception e){
            e.printStackTrace();
            return   RcsResult.build(500,e.getMessage());
        }
        return  RcsResult.ok(pointsList);
    }


}

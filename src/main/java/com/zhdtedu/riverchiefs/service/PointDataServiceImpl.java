package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.PointData;
import com.zhdtedu.riverchiefs.dao.mapper.PointDataMapper;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
//@CacheConfig
public class PointDataServiceImpl implements  PointDataService{
    @Autowired
    PointDataMapper pointDataMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public RcsResult insert(PointData pointData) {
        try{
            pointDataMapper.insert(pointData);
            //emptyCache();
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.build(201,"新增成功",null);
    }

    @Override
    public RcsResult deleteById(int id) {
        try{
            pointDataMapper.deleteById(id);
            //emptyCache();
        }catch (Exception e){
            e.printStackTrace();
            return   RcsResult.build(500,e.getMessage());
        }
        return  RcsResult.ok();
    }

    @Override
    public RcsResult updatePointData(PointData pointData) {
        try{
            pointDataMapper.updateById(pointData);
           // emptyCache();
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());

        }
        return RcsResult.ok();

    }

    @Override
    //@Cacheable(value = "pointData",keyGenerator = "keyGenerator")
    public PageModel getPointDataPages(String name, String start_time, String end_time, String  pageIndex, int pageSize) {
        int counts=0;
        List<PointData> pointDataLists=null;
        int  currentPageNo=0;
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
        //获取当前条件下的总条数
        try {
            counts=pointDataMapper.getTotalCount(name,start_time,end_time);
        }catch (Exception e){
            e.printStackTrace();
        }
        //计算当前页，结束页
        PageModel pageModel=  new PageModel(currentPageNo,counts,pageSize);
        //获取当前页的数据
        try {
            pointDataLists= pointDataMapper.getLists(name,start_time,end_time,currentPageNo,pageSize);

        }catch (Exception e){
            e.printStackTrace();
        }
        pageModel.setList(pointDataLists);
        return  pageModel;
    }

    /**
     * 清空pointData相关的缓存
     */
    public  void  emptyCache(){
        String key="pointData::*";
        Set<String> keys = stringRedisTemplate.keys(key);
        if (!CollectionUtils.isEmpty(keys)) {
            stringRedisTemplate.delete(keys);
        }
    }
}

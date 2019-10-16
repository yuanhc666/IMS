package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.dao.entity.PointData;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface PointDataMapper {
    PointData  getPointData();
    int insert(PointData pointData);
    int deleteById(int id);
    int updateById(PointData pointData);
    //获取监测点数据总条数
    int getTotalCount(@Param("name")String  name , @Param("start_time")String  start_time, @Param("end_time")String end_time);
    //获取监测点数据列表
    ArrayList<PointData> getLists(@Param("name")String name, @Param("start_time")String start_time, @Param("end_time")String end_time, @Param("pageIndex")int pageIndex, @Param("pageSize")int pageSize);
}

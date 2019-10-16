package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.PointData;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;

public interface PointDataService {
    //新增监测点数据
    RcsResult insert(PointData pointData);
    //根据监测点ID删除监测点
    RcsResult deleteById(int id);
    //根据监测点ID更新监测点
    RcsResult updatePointData(PointData pointData);
    //根据监测点名，时间，起始页获取监测点数据
    PageModel getPointDataPages(String name, String start_time, String end_time, String pageIndex, int pageSize);
}

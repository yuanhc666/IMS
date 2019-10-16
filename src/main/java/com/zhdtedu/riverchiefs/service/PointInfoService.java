package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.PointInfo;
import com.zhdtedu.util.RcsResult;

public interface PointInfoService {

    //获取基础数据列表
    RcsResult getPointInfoList(String code,String name, int pageNo);
    //获取总记录数
    /* int  getTotalCount(Long code,String name);*/
    //新增流域信息

    RcsResult savePointInfo(PointInfo pointInfo);

    //通过流域编码获取流域信息
    RcsResult getPointInfoById(Long id);
    //获取修改记录更新
    RcsResult updatePointInfo(PointInfo pointInfo);
    //根据流域id删除数据
    RcsResult deletePointInfoById(Long id);
    //增加查询所有的节点数据
    RcsResult getAllList();


}

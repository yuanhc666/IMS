package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.BasinInfo;
import com.zhdtedu.util.RcsResult;

import java.util.List;

public interface BasinInfoService {
    //获取基础数据列表
    RcsResult getBasinList(Long parentId, int pageNo);
    //获取总记录数
    int  getTotalCount(Long parentId);
    //新增流域信息

    RcsResult saveBasin(BasinInfo basinInfo);

    //通过流域编码获取流域信息
    RcsResult getBasinById(Long id);
    //获取修改记录更新
    RcsResult updateBasin(BasinInfo basinInfo);
    //根据流域id删除数据
    RcsResult deleteBasinById(Long id);
    //动态获取流域树节点

    List<?> getBasinNodeList(Long parentId);
}

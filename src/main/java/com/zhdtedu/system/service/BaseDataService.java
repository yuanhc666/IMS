package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.BaseData;
import com.zhdtedu.util.RcsResult;
import com.zhdtedu.util.SearchCondition;


public interface BaseDataService {
    //获取基础数据列表
    RcsResult getBaseDataList(SearchCondition searchCondition);
    //获取总记录数
    int  getTotalCount(Long parentId);
    //根据id获取基础数据
    RcsResult getBaseData(long id);
    //修改数据修改
    RcsResult  updateBaseData(BaseData baseData);
    //根据id删除数据
    RcsResult   deleteBaseDataById(long id);
    //根据传入的记录保存
    RcsResult  saveBaseData(BaseData baseData);
    //获取动态树
    RcsResult  getNodeList();

}

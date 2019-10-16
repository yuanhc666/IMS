package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.bean.RcsArchiveInfoVo;
import com.zhdtedu.riverchiefs.dao.entity.BasinInfo;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.system.dao.entity.BaseData;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RcsArchiveInfoMapper {

    List<RcsArchiveInfo> pageQuery(Map<String,Object> param);

    int count(Map<String,Object> param);

    int deleteByPrimaryKey(Integer id);

    int insert(RcsArchiveInfoVo record);

    int insertSelective(RcsArchiveInfo record);

    RcsArchiveInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RcsArchiveInfo record);

    int updateByPrimaryKey(RcsArchiveInfo record);

    Long selectArchNumMaxCode(String code);

    List<BaseData> findQuestionType();

    List<BaseData> findQuestionFrom();

    List<BasinInfo> findSuosLiuy();
}
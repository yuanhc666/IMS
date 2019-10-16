package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveFlow;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveFlowExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RcsArchiveFlowMapper {
    int countByExample(RcsArchiveFlowExample example);

    int deleteByExample(RcsArchiveFlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcsArchiveFlow record);

    int insertSelective(RcsArchiveFlow record);

    List<RcsArchiveFlow> selectByExample(RcsArchiveFlowExample example);

    RcsArchiveFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcsArchiveFlow record, @Param("example") RcsArchiveFlowExample example);

    int updateByExample(@Param("record") RcsArchiveFlow record, @Param("example") RcsArchiveFlowExample example);

    int updateByPrimaryKeySelective(RcsArchiveFlow record);

    int updateByPrimaryKey(RcsArchiveFlow record);

    List<RcsArchiveFlow> selectByOperNum(String id);

    //根据操作人员id获取姓名
    public String getUserByOperator(RcsArchiveFlow rcsArchiveFlow);
}
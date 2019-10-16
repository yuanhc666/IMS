package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RcsArchiveFlowVoMapper {

    /**
     * 查询待办案卷记录
     * @return
     */
     List<RcsArchiveFlowVo> selectRcsArchiveFlowVoByCondition(RcsArchiveFlowVo rcsArchiveFlowVo);

    /**
     * 查询已办案卷列表
     * @param rcsArchiveFlowVo
     * @return
     */
    List<RcsArchiveFlowVo> selectRcsArchiveFlowVoHandledListByConditon(RcsArchiveFlowVo rcsArchiveFlowVo);


    /**
     * 查询已派案卷列表
     * @param rcsArchiveFlowVo
     * @return
     */
    List<RcsArchiveFlowVo> selectRcsArchiveFlowVoDispatchedListByConditon(RcsArchiveFlowVo rcsArchiveFlowVo);


    /**
     * 查询所有案卷列表
     * @param rcsArchiveFlowVo
     * @return
     */
    List<RcsArchiveFlowVo> selectRcsArchiveFlowVoAllListByConditon(RcsArchiveFlowVo rcsArchiveFlowVo);
}
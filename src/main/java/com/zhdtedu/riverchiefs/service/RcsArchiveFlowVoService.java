package com.zhdtedu.riverchiefs.service;

import com.github.pagehelper.PageInfo;
import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import com.zhdtedu.util.PageModel;

import java.util.List;

public interface RcsArchiveFlowVoService {

    /**
     * 查询待办案卷
     * @param currentPageNo
     * @param pageSize
     * @param rcsArchiveFlowVo
     * @return
     */
    public List<RcsArchiveFlowVo> selectRcsArchiveFlowVoByCondition(int currentPageNo, int pageSize, RcsArchiveFlowVo rcsArchiveFlowVo);

    /**
     * 查询已办列表
     * @param currentPageNo
     * @param pageSize
     * @param rcsArchiveFlowVo
     * @return
     */
    public List<RcsArchiveFlowVo> selectRcsArchiveFlowVoHandledListByConditon(int currentPageNo, int pageSize,RcsArchiveFlowVo rcsArchiveFlowVo);

    /**
     * 查询已派列表
      * @param currentPageNo
     * @param pageSize
     * @param rcsArchiveFlowVo
     * @return
     */
    public List<RcsArchiveFlowVo> selectRcsArchiveFlowVoDispatchedListByConditon(int currentPageNo, int pageSize,RcsArchiveFlowVo rcsArchiveFlowVo);

    /**
     * 查询所有案卷
     * @param currentPageNo
     * @param pageSize
     * @param rcsArchiveFlowVo
     * @return
     */
   public List<RcsArchiveFlowVo> selectRcsArchiveFlowVoAllListByConditon(int currentPageNo, int pageSize,RcsArchiveFlowVo rcsArchiveFlowVo);

}

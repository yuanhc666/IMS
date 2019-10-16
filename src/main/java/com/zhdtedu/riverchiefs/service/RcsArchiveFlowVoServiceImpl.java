package com.zhdtedu.riverchiefs.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import com.zhdtedu.riverchiefs.dao.mapper.RcsArchiveFlowVoMapper;
import com.zhdtedu.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RcsArchiveFlowVoServiceImpl implements RcsArchiveFlowVoService{

    List<RcsArchiveFlowVo>  list;
//    double hour = 0;

    @Autowired
    private RcsArchiveFlowVoMapper rcsArchiveFlowVoMapper;

    @Override
    public  List<RcsArchiveFlowVo> selectRcsArchiveFlowVoByCondition(int currentPageNo, int pageSize, RcsArchiveFlowVo rcsArchiveFlowVo) {
        PageHelper.startPage(currentPageNo, pageSize);
        return rcsArchiveFlowVoMapper.selectRcsArchiveFlowVoByCondition(rcsArchiveFlowVo);
    }

    @Override
    public List<RcsArchiveFlowVo> selectRcsArchiveFlowVoHandledListByConditon(int currentPageNo, int pageSize, RcsArchiveFlowVo rcsArchiveFlowVo) {
        PageHelper.startPage(currentPageNo, pageSize);
        return rcsArchiveFlowVoMapper.selectRcsArchiveFlowVoHandledListByConditon(rcsArchiveFlowVo);
    }

    @Override
    public List<RcsArchiveFlowVo> selectRcsArchiveFlowVoDispatchedListByConditon(int currentPageNo, int pageSize, RcsArchiveFlowVo rcsArchiveFlowVo) {
        PageHelper.startPage(currentPageNo, pageSize);
        return rcsArchiveFlowVoMapper.selectRcsArchiveFlowVoDispatchedListByConditon(rcsArchiveFlowVo);
    }

    @Override
    public List<RcsArchiveFlowVo> selectRcsArchiveFlowVoAllListByConditon(int currentPageNo, int pageSize, RcsArchiveFlowVo rcsArchiveFlowVo) {
        PageHelper.startPage(currentPageNo, pageSize);
        return rcsArchiveFlowVoMapper.selectRcsArchiveFlowVoAllListByConditon(rcsArchiveFlowVo);
    }

    /**
     * 计算历时（小时）
     * @param startTime
     * @param endTime
     * @return
     */
//    public double getDistanceTime(Date startTime, Date endTime) {
//        long time1 = startTime.getTime();
//        long time2 = endTime.getTime();
//        long diff;
//        if (time1 < time2) {
//            diff = time2 - time1;
//        } else {
//            diff = time1 - time2;
//        }
//        hour = (diff / (60 * 60 * 1000));
//        return hour;
//    }
}

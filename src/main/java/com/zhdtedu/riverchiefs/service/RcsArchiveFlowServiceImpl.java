package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveFlow;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.riverchiefs.dao.mapper.RcsArchiveFlowMapper;
import com.zhdtedu.riverchiefs.dao.mapper.RcsArchiveInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RcsArchiveFlowServiceImpl implements RcsArchiveFlowService{

    @Autowired
    private RcsArchiveFlowMapper rcsArchiveFlowMapper;

    @Autowired
    private RcsArchiveInfoMapper rcsArchiveInfoMapper;

    @Override
    public List<RcsArchiveFlow> getRcsArchiveFlowList(String id) {
        return rcsArchiveFlowMapper.selectByOperNum(id);
    }

    @Override
    public String getUserByOperator(RcsArchiveFlow rcsArchiveFlow) {
        return rcsArchiveFlowMapper.getUserByOperator(rcsArchiveFlow);
    }

    @Override
    public void insertRcsArchiveFlow(RcsArchiveFlow rcsArchiveFlow) {
        rcsArchiveFlowMapper.insert(rcsArchiveFlow);
    }

    @Override
    public RcsArchiveInfo queryRcsArchiveInfoById(Integer id) {
        return rcsArchiveInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void modifyRcsArchiveInfo(RcsArchiveInfo rcsArchiveInfo) {
        rcsArchiveInfoMapper.updateByPrimaryKey(rcsArchiveInfo);
    }
}

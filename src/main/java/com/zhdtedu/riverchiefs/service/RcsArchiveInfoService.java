package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.bean.RcsArchiveInfoVo;
import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.controller.RcsArchiveInfoController;
import com.zhdtedu.riverchiefs.dao.entity.BasinInfo;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.system.dao.entity.BaseData;
import com.zhdtedu.util.ReturnMsg;
import com.zhdtedu.util.SearchCondition;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public interface RcsArchiveInfoService {

    public List<RcsArchiveInfo> pageQuery(SearchCondition sc);

    public RcsArchiveInfo getRcsArchiveInfo(Integer id);

    public void addRcsArchiveInfo(RcsArchiveInfoVo rcsArchiveInfo);

    public void modifyRcsArchiveInfo(RcsArchiveInfoVo rcsArchiveInfo);

    public void deleteRcsArchiveInfo(Integer id);

    public  List<BaseData> findQuestionType();

    public  List<BaseData> findQuestionFrom();

    public List<BasinInfo> findSuosLiuy();


}


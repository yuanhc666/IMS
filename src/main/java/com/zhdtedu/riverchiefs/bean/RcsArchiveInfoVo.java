package com.zhdtedu.riverchiefs.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhdtedu.riverchiefs.dao.entity.RcsCoordinateInfo;
import lombok.Data;

import java.util.Date;

@Data
public class RcsArchiveInfoVo {

    private Integer id;

    private String archNum;

    private String questionFrom;

    private String questionType;

    private String questionAddr;

    private String mapLevel;

    private String mapAddr;

    private RcsCoordinateInfo cid;

    private String suosLiuy;

    private String callPhone;

    private String hdzNum;

    private String hdzRealname;

    private String hdzPhone;

    private String jbrRealname;

    private String jbrPhone;

    private String description;

    private int reportId;

    private String reportRealname;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date reportDate;

    private String status;

    private String ext1;

    private String tempID;
}

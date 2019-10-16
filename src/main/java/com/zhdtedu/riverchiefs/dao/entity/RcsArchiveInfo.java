package com.zhdtedu.riverchiefs.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Data
@Table(name="rcs_archive_info")
public class
RcsArchiveInfo {

    @Column(name="ID_",length = 11,isKey = true,type=MySqlTypeConstant.INT,isAutoIncrement =true)
    private Integer id;


    @Column(name="ARCH_NUM_",type =MySqlTypeConstant.VARCHAR,length = 32)
    private String archNum;

    @Column(name="QUESTION_FROM_",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String questionFrom;

    @Column(name="QUESTION_TYPE_",type =MySqlTypeConstant.VARCHAR,length =20)
    private String questionType;

    @Column(name="QUESTION_ADDR_",type =MySqlTypeConstant.VARCHAR,length = 128)
    private String questionAddr;

    @Column(name="MAP_LEVEL_",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String mapLevel;

    @Column(name="COORDINATE_ID_",type =MySqlTypeConstant.INT,length = 11)
    private RcsCoordinateInfo cid;

    @Column(name="MAP_ADDR_",type =MySqlTypeConstant.VARCHAR,length = 30)
    private String mapAddr;

    @Column(name="SUOS_LIUY_",type =MySqlTypeConstant.VARCHAR,length = 64)
    private String suosLiuy;

    @Column(name="CALL_PHONE_",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String callPhone;

    @Column(name="HDZ_NUM_",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String hdzNum;

    @Column(name="HDZ_REALNAME_",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String hdzRealname;

    @Column(name="HDZ_PHONE_",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String hdzPhone;

    @Column(name="JBR_REALNAME_",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String jbrRealname;

    @Column(name="JBR_PHONE_",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String jbrPhone;

    @Column(name="DESCRIPTION_",type =MySqlTypeConstant.VARCHAR)
    private String description;

    @Column(name="REPORT_ID_",type =MySqlTypeConstant.INT,length=11)
    private int reportId;

    @Column(name="REPORT_REALNAME_",type =MySqlTypeConstant.VARCHAR,length = 128)
    private String reportRealname;

    @Column(name="REPORT_DATE_",type =MySqlTypeConstant.DATETIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date reportDate;

    @Column(name="STATUS_",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String status;

    @Column(name="EXT1_",type =MySqlTypeConstant.VARCHAR,length =50)
    private String ext1;



   /* @Override
    public String toString() {
        return "RcsArchiveInfo{" +
                "id=" + id +
                ", archNum='" + archNum + '\'' +
                ", questionFrom='" + questionFrom + '\'' +
                ", questionType='" + questionType + '\'' +
                ", questionAddr='" + questionAddr + '\'' +
                ", mapLevel='" + mapLevel + '\'' +
                ", mapAddr='" + mapAddr + '\'' +
                ", suosLiuy='" + suosLiuy + '\'' +
                ", callPhone='" + callPhone + '\'' +
                ", hdzNum='" + hdzNum + '\'' +
                ", hdzRealname='" + hdzRealname + '\'' +
                ", hdzPhone='" + hdzPhone + '\'' +
                ", jbrRealname='" + jbrRealname + '\'' +
                ", description='" + description + '\'' +
                ", report_id='" + report_id + '\'' +
                ", reportRealname='" + reportRealname + '\'' +
                ", reportDate='" + reportDate + '\'' +
                ", status='" + status + '\'' +
                ", ext1='" + ext1 + '\'' +
                '}';
    }*/
}

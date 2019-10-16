
package com.zhdtedu.riverchiefs.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "案卷代办列表")
@Data
public class RcsArchiveFlowVo implements Serializable {
    //业务id
    private int id;

    @ApiModelProperty(value = "案卷Id")
    private int archId;

    @ApiModelProperty(value = "案卷编号")
    private String archNum;

    @ApiModelProperty(value = "问题来源")
    private String questionFrom;

    @ApiModelProperty(value = "问题类型")
    private String questionType;

    @ApiModelProperty(value = "所属流域")
    private String suosLiuy;

    @ApiModelProperty(value = "状态")
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @ApiModelProperty(value = "处理时间")
    private Date operTime;

    @ApiModelProperty(value = "时限")
    private Integer times;

    @ApiModelProperty(value = "时限单位")
    private String unit;

    @ApiModelProperty(value = "历时小时数")
    private Integer hours;


    @ApiModelProperty(value = "部门ID")
    private String deptId;

    @ApiModelProperty(value = "用户ID")
    private String operator;

    public RcsArchiveFlowVo() {
    }
    public RcsArchiveFlowVo(String archNum, String questionFrom, String questionType, String suosLiuy, String status, String deptId) {
        this.archNum = archNum;
        this.questionFrom = questionFrom;
        this.questionType = questionType;
        this.suosLiuy = suosLiuy;
        this.status = status;
        this.deptId = deptId;
    }

}


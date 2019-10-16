package com.zhdtedu.riverchiefs.dao.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 监测点
 */
@Data
@Table(name = "rcs_point_info")
public class PointInfo implements Serializable {

    @ApiModelProperty(value = "监测点id，自动生成")
    @Column(name = "ID_",type = MySqlTypeConstant.BIGINT,length = 11,isKey = true,isAutoIncrement = true)
    private Long	id;
    @ApiModelProperty(value = "监测点编码")
    @Column(name = "CODE_",type = MySqlTypeConstant.VARCHAR,length = 11)
    private String	code;

    @ApiModelProperty(value = "监测点名称")
    @Column(name = "NAME_",type = MySqlTypeConstant.VARCHAR,length = 200,isNull = false)
    private String     name;

    @ApiModelProperty(value = "地图等级")
    @Column(name = "LEVEL_",type = MySqlTypeConstant.VARCHAR,length = 20,isNull = false)
    private String    level;
    @ApiModelProperty(value = "地图定位")
    @Column(name = "LOCATION_",type = MySqlTypeConstant.VARCHAR,length = 200,isNull = false)
    private String    location;
    @ApiModelProperty(value = "类别id")
    @Column(name = "CATEGORY_ID_",type = MySqlTypeConstant.BIGINT,length = 11,isNull = false)
    private Long    categoryId;

    @ApiModelProperty(value = "地址")
    @Column(name = "ADDRESS_",type = MySqlTypeConstant.VARCHAR,length = 200)
    private String    address;

    @ApiModelProperty(value = "位置描述")
    @Column(name = "DESCRIPTION_",type = MySqlTypeConstant.VARCHAR,length = 200)
    private String    description;

    @ApiModelProperty(value = "省网代码")
    @Column(name = "NETWORK_CODE_",type = MySqlTypeConstant.BIGINT,length = 20)
    private Long    networkCode;

    @ApiModelProperty(value = "主管部门id")
    @Column(name = "MANAGE_DEPT_ID_",type = MySqlTypeConstant.BIGINT,length = 11)
    private Long    manageDeptId;


    @ApiModelProperty(value = "权属部门id")
    @Column(name = "OWERSHIP_ID_",type = MySqlTypeConstant.BIGINT,length = 11)
    private Long    owershipId;

    @ApiModelProperty(value = "附件地址")
    @Column(name = "ATTACH_PATH_",type = MySqlTypeConstant.VARCHAR,length = 200)
    private String    attachPath;

    //创建时间
    @ApiModelProperty(value = "创建时间")
    @Column(name = "CREATE_TIME_",type = MySqlTypeConstant.DATETIME)
    private Date createTime;
    //更新时间
    @ApiModelProperty(value = "更新时间")
    @Column(name = "UPDATE_TIME_",type = MySqlTypeConstant.DATETIME)
    private Date	updateTime;








}

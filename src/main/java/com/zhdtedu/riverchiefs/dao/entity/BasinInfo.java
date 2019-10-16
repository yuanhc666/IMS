package com.zhdtedu.riverchiefs.dao.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "rcs_basin_info")
/**
 * 流域
 */
public class BasinInfo {
    @ApiModelProperty(value = "id，自动生成")
    @Column(name = "ID_",type = MySqlTypeConstant.BIGINT,length = 11,isKey = true,isAutoIncrement = true)
    private Long	id;

    @ApiModelProperty(value = "流域编码id，自动生成")
    @Column(name = "CODE_",type = MySqlTypeConstant.BIGINT,length = 11)
    private Long	code;

    @ApiModelProperty(value = "上级流域id")
    @Column(name = "PARENT_ID_",type = MySqlTypeConstant.BIGINT,length = 11)
    private Long	parentId;
    @ApiModelProperty(value = "是否为父节点,1代表为父节点，0代表为子节点")
    @Column(name = "IS_PARENT",type = MySqlTypeConstant.INT,length = 1,defaultValue = "0")
    private int	isParent;

    @ApiModelProperty(value = "流域类型,1表示市级，2表示镇级，3表示村级")
    @Column(name = "TYPE_",type = MySqlTypeConstant.INT,length = 3,isNull = false)
    private Integer    type;

    @ApiModelProperty(value = "流域名称")
    @Column(name = "NAME_",type = MySqlTypeConstant.VARCHAR,length = 250,isNull = false)
    private String	name;
    @ApiModelProperty(value = "流域描述")
    @Column(name = "DESCRIPTION_",type = MySqlTypeConstant.TEXT)
    private String	description;

    @ApiModelProperty(value = "工作职责")
    @Column(name = "DUTY_",type = MySqlTypeConstant.TEXT)
    private String	duty;

    @ApiModelProperty(value = "协调部门")
    @Column(name = "DEPT_",type = MySqlTypeConstant.TEXT)
    private String	dept;

    @ApiModelProperty(value = "第一河长")
    @Column(name = "FIRST_MANAGER_",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String	firstManager;

    @ApiModelProperty(value = "职务一")
    @Column(name = "FIRST_POST_",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String	firstPost;

    @ApiModelProperty(value = "电话一")
    @Column(name = "FIRST_TEL_",type = MySqlTypeConstant.VARCHAR,length = 11)
    private String	firstTel;

    @ApiModelProperty(value = "第二河长")
    @Column(name = "SECOND_MANAGER_",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String	SecondManager;

    @ApiModelProperty(value = "职务二")
    @Column(name = "SECOND_POST_",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String	secondPost;

    @ApiModelProperty(value = "电话二")
    @Column(name = "SECOND_TEL_",type = MySqlTypeConstant.VARCHAR,length =11 )
    private String	secondTel;
    @ApiModelProperty(value = "地图等级")
    @Column(name = "MAP_LEVEL_",type = MySqlTypeConstant.VARCHAR,length = 100)
    private String	mapLevel;

    @ApiModelProperty(value = "中心点")
    @Column(name = "POINT_",type = MySqlTypeConstant.VARCHAR,length = 100)
    private String	point;

    @ApiModelProperty(value = "描边")
    @Column(name = "OUTLINE_",type = MySqlTypeConstant.VARCHAR,length = 200)
    private String	outline;
    @ApiModelProperty(value = "颜色")
    @Column(name = "COLOR_",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String	color;

   //创建时间
    @ApiModelProperty(value = "创建时间")
    @Column(name = "CREATE_TIME_",type = MySqlTypeConstant.DATETIME)
    private Date createTime;
    //更新时间
    @ApiModelProperty(value = "更新时间")
    @Column(name = "UPDATE_TIME_",type = MySqlTypeConstant.DATETIME)
    private Date	updateTime;





}

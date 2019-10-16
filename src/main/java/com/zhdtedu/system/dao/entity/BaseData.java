package com.zhdtedu.system.dao.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 树节点信息
 */
@Data
@Table(name = "sys_dict_base")
public class BaseData {


    @ApiModelProperty(value = "基础数据id，自动生成")
    @Column(name = "ID_",type = MySqlTypeConstant.BIGINT,length = 11,isKey = true,isAutoIncrement = true)
    private Long	id;

    @ApiModelProperty(value = "分类名称的id")
    @Column(name = "PARENT_ID_",type = MySqlTypeConstant.BIGINT,length = 11)
    private Long	parentId;


    //名称
    @ApiModelProperty(value = "基础数据名称")
    @Column(name = "NAME_",type = MySqlTypeConstant.VARCHAR,length = 111)
    private String	name;
    //备注
    @ApiModelProperty(value = "备注")
    @Column(name = "DESCRIPTION_",type = MySqlTypeConstant.TEXT)
    private String	description;
    @ApiModelProperty(value = "创建时间")
    @Column(name = "CREATE_TIME_",type = MySqlTypeConstant.DATETIME)
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    @Column(name = "UPDATE_TIME_",type = MySqlTypeConstant.DATETIME)
    private Date	updateTime;
    //编码
    @ApiModelProperty(value = "编码")
    @Column(name = "CODE_",type = MySqlTypeConstant.INT,length = 5)
    private Integer	code;
    //是否启用 1代表启用 0代表不启用
    @ApiModelProperty(value = "是否启用 1代表启用 0代表不启用")
    @Column(name = "STATUS_",type = MySqlTypeConstant.INT,length = 5)
    private Integer	status;


}

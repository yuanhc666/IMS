package com.zhdtedu.riverchiefs.dao.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 地图坐标信息
 */
@Data
@Table(name="rcs_coordinate_info")
public class RcsCoordinateInfo {

    @Column(name="ID_",length = 11,isKey = true,type= MySqlTypeConstant.INT,isAutoIncrement =true)
    private Integer id;//主键

    @Column(name="LONGITUDE_",type =MySqlTypeConstant.VARCHAR,length = 32)
    private String longitude;//经度

    @Column(name="LATITUDE_",type =MySqlTypeConstant.VARCHAR,length = 32)
    private String latitude;//纬度

    @Column(name="NAME_",type =MySqlTypeConstant.VARCHAR)
    private String name;//坐标名称

    @Column(name="EXT_",type =MySqlTypeConstant.VARCHAR,length = 128)
    private String ext;//扩展字段

}

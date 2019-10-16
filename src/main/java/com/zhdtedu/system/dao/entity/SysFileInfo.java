package com.zhdtedu.system.dao.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

@Data
@Table(name="sys_file_info")
public class SysFileInfo {

    @Column(name = "ID_",isKey = true,type = MySqlTypeConstant.INT,length = 11,isAutoIncrement = true)
    private int id;

    @Column(name="FILE_CODE_",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String fileCode;//文件新名字

    @Column(name="FILE_NAME_",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String fileName;//文件名称

    @Column(name="FILE_PATH_",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String filePath;//存放路径

    @Column(name="FILE_SIZE_",type = MySqlTypeConstant.INT,length = 11)
    private long fileSize;//文件大小

    @Column(name="UPLOAD_DATE_",type = MySqlTypeConstant.DATETIME)
    private Date uploadDate;//上传时间

    @Column(name="FILE_TYPE_",type = MySqlTypeConstant.VARCHAR,length = 12)
    private String fileType;//文件类型

    @Column(name="TEMP_CODE_",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String tempCode;//零时标记

    @Column(name="URL_",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String url;//访问url

    @Column(name="STATUS_",type = MySqlTypeConstant.VARCHAR,length = 12)
    private String status;//转换状态

    @Column(name="EXT_",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String ext;//备注

    @Column(name="GROUP_NAME_",type = MySqlTypeConstant.VARCHAR,length = 12)
    private String groupName;

    @Column(name="REMOTE_FILE_NAME_",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String remoteFileName;

}

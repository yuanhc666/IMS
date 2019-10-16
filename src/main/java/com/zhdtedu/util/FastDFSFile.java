package com.zhdtedu.util;

import lombok.Data;

@Data
public class FastDFSFile {

    private String name;//文件名称

    private byte[] content;//文件内容二进制流

    private String ext;//文件后缀名

    private String groupName;//分组名

    private String remoteFileName;//服务器上文件名字
}

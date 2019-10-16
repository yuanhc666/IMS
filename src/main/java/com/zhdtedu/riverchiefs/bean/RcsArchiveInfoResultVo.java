package com.zhdtedu.riverchiefs.bean;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.system.dao.entity.SysFileInfo;
import lombok.Data;
import java.util.List;

@Data
public class RcsArchiveInfoResultVo {

    private RcsArchiveInfo info;
    private List<SysFileInfo> flist;
}

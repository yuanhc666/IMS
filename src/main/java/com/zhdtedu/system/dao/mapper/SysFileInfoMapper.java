package com.zhdtedu.system.dao.mapper;

import com.zhdtedu.system.dao.entity.SysFileInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysFileInfoMapper {

    public List<SysFileInfo> selectByFileCode(@Param("fileCode") String fileCode);

    public void insertSelective(SysFileInfo fileInfo);

    public SysFileInfo selectByPrimaryKey(Integer id);

    public void deleteByPrimaryKey(Integer id);

    public void updateFileCode(@Param("oldCode")String oldCode,@Param("nowCode")String nowCode);
}

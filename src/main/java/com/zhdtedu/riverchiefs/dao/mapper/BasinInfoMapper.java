package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.dao.entity.BasinInfo;
import com.zhdtedu.riverchiefs.dao.entity.BasinInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BasinInfoMapper {
    int countByExample(BasinInfoExample example);

    int deleteByExample(BasinInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BasinInfo record);

    //int insertSelective(BasinInfo record);

    List<BasinInfo> selectByExampleWithBLOBs(BasinInfoExample example);

    List<BasinInfo> selectByExample(BasinInfoExample example);

    BasinInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BasinInfo record, @Param("example") BasinInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") BasinInfo record, @Param("example") BasinInfoExample example);

    int updateByExample(@Param("record") BasinInfo record, @Param("example") BasinInfoExample example);

    int updateByPrimaryKeySelective(BasinInfo record);

    int updateByPrimaryKeyWithBLOBs(BasinInfo record);

    int updateByPrimaryKey(BasinInfo record);
    //根据查询条件获取列表
    List<BasinInfo> selectByBasinExample(@Param("parentId") Long parentId,
                                         @Param("pageNo") Integer pageNo,
                                         @Param("pageSize") Integer pageSize);
    int getTotalCount(@Param("parentId") Long parentId);
    //更新父节点的isParent=1
    int  updateParent(@Param("parentId") Long parentId);
    //是否有子节点
    int   selectNodesByParentId(@Param("parentId") Long parentId);
    //更新父节点isParent=0
    int updateIsParent(@Param("parentId") Long parentId);

}

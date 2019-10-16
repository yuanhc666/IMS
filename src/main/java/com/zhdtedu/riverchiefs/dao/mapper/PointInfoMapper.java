package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.dao.entity.PointInfo;
import com.zhdtedu.riverchiefs.dao.entity.PointInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointInfoMapper {
    int countByExample(PointInfoExample example);

    int deleteByExample(PointInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PointInfo record);

    int insertSelective(PointInfo record);

    List<PointInfo> selectByExample(PointInfoExample example);

    PointInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PointInfo record, @Param("example") PointInfoExample example);

    int updateByExample(@Param("record") PointInfo record, @Param("example") PointInfoExample example);

    int updateByPrimaryKeySelective(PointInfo record);

    int updateByPrimaryKey(PointInfo record);
    //根据查询条件获取列表
    List<PointInfo> selectByPointExample(@Param("code") String code,
                                         @Param("name") String name,
                                         @Param("pageNo") Integer pageNo,
                                         @Param("pageSize") Integer pageSize);
    //获取所有监测点数据
    List<PointInfo>  selectAllPoints();

}

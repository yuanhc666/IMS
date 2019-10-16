package com.zhdtedu.system.dao.mapper;

import com.zhdtedu.system.dao.entity.BaseData;
import com.zhdtedu.system.dao.entity.BaseDataExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 持久层实现Mybatis框架中的Mapper接口，声名对数据库的操作方法
 *
 *
 */
@Mapper
public interface BaseDataMapper {
    int countByExample(BaseDataExample example);

    int deleteByExample(BaseDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseData record);

    int insertSelective(BaseData record);

    List<BaseData> selectByExampleWithBLOBs(BaseDataExample example);

    List<BaseData> selectByExample(BaseDataExample example);

        BaseData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseData record, @Param("example") BaseDataExample example);

    int updateByExampleWithBLOBs(@Param("record") BaseData record, @Param("example") BaseDataExample example);

    int updateByExample(@Param("record") BaseData record, @Param("example") BaseDataExample example);

    int updateByPrimaryKeySelective(BaseData record);

    int updateByPrimaryKeyWithBLOBs(BaseData record);
    int  updateByPrimaryKey(BaseData record);


    List<BaseData> selectByExample2(@Param("parentId") Long parentId,
                                    @Param("pageNo") Integer pageNo,
                                    @Param("pageSize") Integer pageSize);
    List<BaseData> selectByCondition(Map<String,Object> params);
    int getTotalCount(@Param("parentId") Long parentId);

}
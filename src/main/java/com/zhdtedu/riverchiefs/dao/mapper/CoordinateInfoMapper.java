package com.zhdtedu.riverchiefs.dao.mapper;


import com.zhdtedu.riverchiefs.dao.entity.RcsCoordinateInfo;

public interface CoordinateInfoMapper {

    public void insert(RcsCoordinateInfo rci);

    public void update(RcsCoordinateInfo rci);

    public RcsCoordinateInfo selectByPrimaryKey(Integer id);

    public void deleteById(Integer id);
}

package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.RcsCoordinateInfo;

public interface CoordinateInfoService {

    public RcsCoordinateInfo add(RcsCoordinateInfo rcif);

    public RcsCoordinateInfo getRcsCoordinateInfo(Integer id);

    public void deleteRcsCoordinateInfo(Integer id);
}

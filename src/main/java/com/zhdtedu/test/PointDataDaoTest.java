package com.zhdtedu.test;

import com.zhdtedu.riverchiefs.dao.entity.PointData;
import com.zhdtedu.riverchiefs.dao.mapper.PointDataMapper;
import com.zhdtedu.system.bean.BaseDaoTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
public class PointDataDaoTest extends BaseDaoTest {
    @Autowired
    PointDataMapper PointDataMapper;
    /**
     * 测试dao层 删除方法
     */
    @Test
    public  void deletePointData(){
        PointDataMapper.deleteById(3);
    }
    /**
     * 测试dao层，更新监测点数据方法
     */
    @Test
    @Transactional
    public  void  updatePointData(){
        PointData pointData=new PointData( 3, "好1111", new Date(), 1, 2, "合格", "达标", 3,2L);
        PointDataMapper.updateById(pointData);
        System.out.println("利用事务测试不影响正常的数据");
    }

    /**
     * 测试Dao层，添加方法
     */
    @Test
    public  void  addPointData(){
        PointData pointData=new PointData( 3, "好1111", new Date(), 1, 2, "合格", "达标", 3,2L);
        PointDataMapper.insert(pointData);
    }

    /**
     * 测试dao层，获取数据方法
     */
    @Test
    public  void  getPointDatas(){
        ArrayList<PointData> pointDatas= PointDataMapper.getLists(null,null,null,1,4);
        System.out.println(pointDatas);
    }

}

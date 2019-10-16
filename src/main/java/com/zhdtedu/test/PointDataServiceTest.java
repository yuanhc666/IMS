package com.zhdtedu.test;

import com.zhdtedu.riverchiefs.dao.entity.PointData;
import com.zhdtedu.riverchiefs.service.PointDataService;
import com.zhdtedu.system.bean.BaseDaoTest;
import com.zhdtedu.util.PageModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Date;

public class PointDataServiceTest extends BaseDaoTest {
    @Autowired
    PointDataService pointDataService;
    /**
     * 测试Service层 删除方法
     */
    @Test
    public  void deletePointData(){
        pointDataService.deleteById(1);
    }
    /**
     * 测试Service层，更新监测点数据方法
     */
    @Test
    public  void  updatePointData(){
        PointData pointData=new PointData( 3, "指标指数", new Date(), 1, 2, "不合格", "达标", 3,2L);        pointDataService.updatePointData(pointData);
        System.out.println("利用事务测试不影响正常的数据");
    }

    /**
     * 测试Service层，添加方法
     */
    @Test
    public  void  addPointData(){
        PointData pointData=new PointData( 3, "好1111", new Date(), 1, 2, "合格", "达标", 3,2L);
        pointDataService.insert(pointData);
    }

    /**
     * 测试Service层，获取数据方法
     */
    @Test
    public  void  getPointDatas(){
        PageModel pointDatas= pointDataService.getPointDataPages(null,null,null,"1",4);
        Assert.notEmpty(pointDatas.getList(),"空空如也");
        System.out.println(pointDatas.getList());
    }


}

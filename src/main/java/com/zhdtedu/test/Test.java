package com.zhdtedu.test;

import com.alibaba.fastjson.JSONObject;
import com.zhdtedu.riverchiefs.dao.entity.PointData;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        PointData pointData=new PointData( 3, "好22", new Date(), 1, 2, "合格", "达标", 3,3L);
        String requestJson = JSONObject.toJSONString(pointData);
        System.out.println(requestJson);
    }
}

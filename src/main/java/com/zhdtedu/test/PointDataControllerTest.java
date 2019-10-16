package com.zhdtedu.test;

import com.alibaba.fastjson.JSONObject;
import com.zhdtedu.riverchiefs.dao.entity.PointData;
import com.zhdtedu.system.bean.BaseControllerTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * controller层测试
 */
public class PointDataControllerTest extends BaseControllerTest {
    RequestBuilder request = null;
    @Test
    /**
     * /v1/pointDatas 测试
     */
    public void pointDatas() {

        //路径
        request = get("/v3/pointDatas")
                //参数
                .param("pageIndex", "1")
                .param("start_time","2019-07-20")
                //接受的数据类型
                .accept(MediaType.APPLICATION_JSON);
        try {
            mvc.perform(request)
                    //状态吗是否相等
                    .andExpect(status().isOk())
                    //输出信息
                    .andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * /v1/pointsData/update 测试
     */
    @Test
    public void  update(){
        PointData pointData=new PointData( 3, "监测点指标测试", new Date(), 8, 8, "合格看看", "达标听听", 46,5L);
        String requestJson = JSONObject.toJSONString(pointData);
        //路径
            request = put("/v1/pointsData/update")
                    .content(requestJson)
                    .contentType(MediaType.APPLICATION_JSON);
            try {
                mvc.perform(request)
                        //状态吗是否相等
                        .andExpect(status().isOk())
                        //输出信息
                        .andDo(print());
            } catch (Exception e) {
                e.printStackTrace();
            }


    }

    /**
     * 测试/v1/pointsData/delete/{id}
     *
     */
    @Test
    public void deletePointData(){
        //路径
        request = delete("/v1/pointsData/delete/3")
                //接受的数据类型
                .accept(MediaType.APPLICATION_JSON);
        try {
            mvc.perform(request)
                    //状态吗是否相等
                    .andExpect(status().isOk())
                    //输出信息
                    .andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试v1/pointsData/insert
     */
    @Test
    public void add(){
        PointData pointData=new PointData(null, "新增添加数据", new Date(), 1, 2, "合格", "达标", 3,2L);
        String requestJson = JSONObject.toJSONString(pointData);
        request = post("/v1/pointsData/insert")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON);
        try {
            mvc.perform(request)
                    //状态吗是否相等
                    .andExpect(status().isOk())
                    //输出信息
                    .andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

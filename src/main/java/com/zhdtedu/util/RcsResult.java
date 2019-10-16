package com.zhdtedu.util;

import lombok.Data;

/**
 * 河长制系统自定义响应结构
 */
@Data
public class RcsResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static RcsResult build(Integer status, String msg, Object data) {
        return new RcsResult(status, msg, data);
    }

    public static RcsResult ok(Object data) {
        return new RcsResult(data);
    }

    public static RcsResult ok() {
        return new RcsResult(null);
    }

    public RcsResult() {

    }

    public static RcsResult build(Integer status, String msg) {
        return new RcsResult(status, msg, null);
    }

    public RcsResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public RcsResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }




}

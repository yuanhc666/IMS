package com.zhdtedu.riverchiefs.bean;

import lombok.Data;

@Data
public class BaseVO<T> {


    /**
     * success返回值
     */
    private static final int SUCCESS_CODE = 10000;
    /**
     * 默认返回消息
     */
    private static final String SUCCESS_MSG = "操作成功";

    /**
     * 返回值
     */
    private int code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    /**
     * 无参构造
     */
    public BaseVO() {
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
    }

    /**
     * 构造函数
     *
     * @param msg 返回内容
     */
    public BaseVO(String msg) {
        this.code = SUCCESS_CODE;
        this.msg = msg;
    }

    /**
     * 构造函数
     *
     * @param msg  返回内容
     * @param data 数据
     */
    public BaseVO(String msg, T data) {
        this.code = SUCCESS_CODE;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造函数
     *
     * @param code 返回值
     * @param msg  返回内容
     * @param data 数据
     */
    public BaseVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造函数
     *
     * @param code 返回值
     * @param msg  消息
     */
    public BaseVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

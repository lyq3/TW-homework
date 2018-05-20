package com.lyq3.galaxy.common;

/**
 * 统一响应结果
 * @author 卡卢比
 * @date 2018/5/20
 */
public class Result<T> {
    /**响应code*/
    private int code = 1;
    /**响应信息*/
    private String msg = "SUCCESS";
    /**数据*/
    private T data;

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}

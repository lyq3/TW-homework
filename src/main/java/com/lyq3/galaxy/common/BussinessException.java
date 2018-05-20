package com.lyq3.galaxy.common;

/**
 * 统一的业务异常
 * @author 卡卢比
 * @date 2018/5/20
 */
public class BussinessException extends  RuntimeException{
    /**异常代码*/
    private int code;
    /**异常信息*/
    private String msg;

    public BussinessException(ExceptionEnum exceptionEnum){
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }

    public BussinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BussinessException() {
        super();
    }

    public int getCode() {
        return code;
    }

    public BussinessException setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BussinessException setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}

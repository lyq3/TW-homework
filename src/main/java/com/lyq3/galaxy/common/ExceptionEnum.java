package com.lyq3.galaxy.common;

/**
 * 异常枚举类
 * @author 卡卢比
 * @date 2018/5/20
 */
public enum ExceptionEnum {
    ROMAN_ILLEGAL(2,"非法的罗马数字"),
    NOT_NULL(3,"输入不能为空"),
    FILE_FORMAT_ERROR(4,"文件格式错误,只支持txt"),
    FILE_READ_ERROR(5,"文件读取错误")
    ;

    private int code;
    private String msg;

    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public ExceptionEnum setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ExceptionEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}

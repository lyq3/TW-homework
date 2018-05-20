package com.lyq3.galaxy.common;

import sun.misc.Regexp;

/**
 * 输入行类型枚举
 * @author 卡卢比
 * @date 2018/5/20
 */
public enum  LineEnum {
    CONDITION(1,"条件类型语句，如：glob is I","^([A-Za-z]+) is ([I|V|X|L|C|D|M])$"),
    SPECULATION(2,"需要推测的条件，如：pish pish Iron is 3910 Credits","^([A-Za-z]+)([A-Za-z\\s]*) is ([0-9]+) ([c|C]redits)$"),
    HOWMUCH(3,"howmuch问句，如：how much is pish tegj glob glob ?","^how much is (([A-Za-z\\s])+)\\?$"),
    HOWMANY(4,"how many问句，如：how many Credits is glob prok Silver ?","^how many [c|C]redits is (([A-Za-z\\s])+)\\?$"),
    ERROR(-1,"错误的语句",null)
    ;
    /**类型Code*/
    private int typeCode;
    /**类型说明*/
    private String typeMsg;
    /**类型正则*/
    private String regexp;

    LineEnum(int typeCode, String typeMsg,String regexp) {
        this.typeCode = typeCode;
        this.typeMsg = typeMsg;
        this.regexp = regexp;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public LineEnum setTypeCode(int typeCode) {
        this.typeCode = typeCode;
        return this;
    }

    public String getTypeMsg() {
        return typeMsg;
    }

    public LineEnum setTypeMsg(String typeMsg) {
        this.typeMsg = typeMsg;
        return this;
    }

    public String getRegexp() {
        return regexp;
    }

    public LineEnum setRegexp(String regexp) {
        this.regexp = regexp;
        return this;
    }
}

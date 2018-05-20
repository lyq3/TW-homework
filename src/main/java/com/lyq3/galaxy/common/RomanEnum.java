package com.lyq3.galaxy.common;

/**
 * 罗马数字枚举类
 * @author 卡卢比
 * @date  2018/5/20
 */
public enum RomanEnum {
    I(1,'I') , V(5,'V'), X(10,'X'), L(50,'L'), C(100,'C'), D(500,'D'), M(1000,'M');

    private int value;
    private char roman;

    RomanEnum(int value,char roman)
    {
        this.value = value;
        this.roman = roman;
    }

    public int getValue()
    {
        return this.value;
    }

    public RomanEnum setValue(int value) {
        this.value = value;
        return this;
    }

    public char getRoman() {
        return roman;
    }

    public RomanEnum setRoman(char roman) {
        this.roman = roman;
        return this;
    }
}

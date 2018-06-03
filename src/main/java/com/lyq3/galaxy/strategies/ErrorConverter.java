package com.lyq3.galaxy.strategies;

import com.lyq3.galaxy.common.Tem;

/**
 * 错误语句转换器
 * @author 卡卢比
 * @date 2018/6/3
 */
public class ErrorConverter implements Converter{
    @Override
    public String convert(String line, Tem tem) {
        return "I have no idea what you are talking about</br>";
    }
}

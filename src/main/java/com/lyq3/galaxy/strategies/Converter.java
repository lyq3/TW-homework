package com.lyq3.galaxy.strategies;

import com.lyq3.galaxy.common.Tem;

/**
 * 行转换器接口：
 * 策略模式
 * @author 卡卢比
 * @date 2018/6/3
 */
public interface Converter<T> {
    /**
     * 传入一行语句，返回处理结果
     * @param line
     * @return
     */
    String convert(String line,Tem tem);
}

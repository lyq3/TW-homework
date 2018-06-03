package com.lyq3.galaxy.strategies;

import com.lyq3.galaxy.common.RomanEnum;
import com.lyq3.galaxy.common.Tem;

import java.util.HashMap;
import java.util.Map;

/**
 * 条件语句转换器
 * @author 卡卢比
 * @date 2018/6/3
 */
public class ConditionConverter implements Converter{
    @Override
    public String convert(String line,Tem tem) {
        //按空格拆分prok is V
        String[] splited = line.trim().split("\\s+");
        //并加入到map中
        for(RomanEnum value :RomanEnum.values()){
            if(splited[2].equals(String.valueOf(value.getRoman()))){
                tem.getUnitMap().put(splited[0],value);
            }
        }
        //返回空
        return "";
    }
}

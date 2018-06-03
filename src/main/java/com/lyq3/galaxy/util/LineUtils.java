package com.lyq3.galaxy.util;

import com.lyq3.galaxy.common.LineEnum;
import com.lyq3.galaxy.common.RomanEnum;
import com.lyq3.galaxy.common.Tem;

import java.util.HashMap;

/**
 * 输入内容工具类
 * @author 卡卢比
 * @date 2018/5/20
 */
public class LineUtils {
    /**
     * 获取行的类型
     * @param line
     * @return
     */
    public static LineEnum getLineType(String line){
        if(line.matches(LineEnum.CONDITION.getRegexp())){
            return LineEnum.CONDITION;
        }
        if(line.matches(LineEnum.HOWMANY.getRegexp())){
            return LineEnum.HOWMANY;
        }
        if(line.matches(LineEnum.HOWMUCH.getRegexp())){
            return LineEnum.HOWMUCH;
        }
        if(line.matches(LineEnum.SPECULATION.getRegexp())){
            return LineEnum.SPECULATION;
        }
        return LineEnum.ERROR;
    }
}

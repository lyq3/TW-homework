package com.lyq3.galaxy.factory;

import com.lyq3.galaxy.common.LineEnum;
import com.lyq3.galaxy.strategies.*;

/**
 * 转换器工厂
 * @author 卡卢比
 * @date 2018/6/3
 */
public class ConverterFactory {
    public static Converter build(LineEnum lineEnum) {
        switch (lineEnum) {
            case CONDITION:
                return new ConditionConverter();
            case SPECULATION:
                return new CreditsConverter();
            case HOWMUCH:
                return new HowMuchConverter();
            case HOWMANY:
                return new HowManyConverter();
        }
        return new ErrorConverter();
    }
}

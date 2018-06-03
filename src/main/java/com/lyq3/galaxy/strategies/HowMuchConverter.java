package com.lyq3.galaxy.strategies;

import com.lyq3.galaxy.common.Tem;
import com.lyq3.galaxy.util.RomanUtils;

/**
 * HowMuch语句转换器
 * @author  卡卢比
 * @date 2018/6/3
 */
public class HowMuchConverter  implements  Converter {
    @Override
    public String convert(String line,Tem tem) {
        //获取需计算的语句how much is pish tegj glob glob ? => pish tegj glob glob
        String formatted = line.replace("?","").trim().split("\\sis\\s")[1].trim();
        //再拆成数组
        String keys[] = formatted.split("\\s+");
        //先转为罗马数字
        String roman = "";
        for(String key : keys){
            roman += tem.getUnitMap().get(key).getRoman();
        }
        //再将罗马数字转为十进制数字
        int number = RomanUtils.getNumberFormRoman(roman);
        return formatted + " is "+number + "</br>";
    }
}

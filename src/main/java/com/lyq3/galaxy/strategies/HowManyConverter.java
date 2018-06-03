package com.lyq3.galaxy.strategies;

import com.lyq3.galaxy.common.Tem;
import com.lyq3.galaxy.util.RomanUtils;

/**
 * HowMany语句转换器
 * @author 卡卢比
 * @date 2018/6/3
 */
public class HowManyConverter implements Converter{
    @Override
    public String convert(String line,Tem tem) {
        //获取需计算的语句how many Credits is glob prok Silver ? ? => glob prok Silver
        String formatted = line.replace("?","").trim().split("(\\sis\\s)")[1];
        //拆分
        String[] keys = formatted.split("\\s");
        //遍历前面的单价
        String roman = "";
        for(int i = 0 ; i < keys.length -1 ; i++){
            roman += tem.getUnitMap().get(keys[i]).getRoman();
        }
        //罗马数字转换成十进制
        int number =  RomanUtils.getNumberFormRoman(roman);
        //商品
        String commodity = keys[keys.length-1];
        //计算价格
        double res = number * tem.getPriceMap().get(commodity);

        return formatted + " is "+ res + " Credits " + "</br>";
    }
}

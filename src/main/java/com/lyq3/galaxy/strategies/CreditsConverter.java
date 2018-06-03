package com.lyq3.galaxy.strategies;

import com.lyq3.galaxy.common.Tem;
import com.lyq3.galaxy.util.RomanUtils;


/**
 * 积分语句转换器
 * @author  卡卢比
 * @date 2018/6/3
 */
public class CreditsConverter implements Converter{
    @Override
    public String convert(String line,Tem tem) {
        //变成glob glob Silver 34
        String formatted = line.replaceAll("(is\\s+)|([c|C]redits\\s*)","").trim();
        //再按空格拆分
        String[] keys = formatted.split("\\s");
        //需要计算的单词 Silver
        String compute = keys[keys.length-2];
        //和 34
        double product = Double.valueOf(keys[keys.length-1]);
        //将单词转换为罗马数字如：glob glob = II
        String roman="";
        for(int i=0;i<keys.length-2;i++)
        {
            roman += tem.getUnitMap().get(keys[i]).getRoman();
        }
        //计算Silver价格
        double price = product/RomanUtils.getNumberFormRoman(roman);
        //将银的单价加入map中
        tem.getPriceMap().put(compute,price);
        //返回空
        return "";
    }
}

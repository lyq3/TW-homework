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
    //全局变量存入ThreadLocal中避免线程安全问题
    public static ThreadLocal<Tem<String,String,RomanEnum,Double>> threadLocal = new ThreadLocal<Tem<String,String,RomanEnum,Double>>();

    /**
     * 初始化全局变量
     */
    public static void init(){
        LineUtils.threadLocal.set(new Tem<String,String,RomanEnum,Double>());
        LineUtils.threadLocal.get().setUnitMap(new HashMap<String,RomanEnum>());
        LineUtils.threadLocal.get().setPriceMap(new HashMap<String,Double>());
    }

    /**
     * 获取线程安全的全局变量
     * @return
     */
    public static Tem<String,String,RomanEnum,Double>  getTem(){
        return LineUtils.threadLocal.get();
    }

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

    /**
     * 转换条件语句，prok is V 转换为{"prok",5}
     * @param line
     */
    public static void convertCondition(String line){
        //按空格拆分prok is V
        String[] splited = line.trim().split("\\s+");
        switch (splited[2]) {
            case "I" : getTem().getUnitMap().put(splited[0],RomanEnum.I);
                break;
            case "V" : getTem().getUnitMap().put(splited[0], RomanEnum.V);
                break;
            case "X" : getTem().getUnitMap().put(splited[0], RomanEnum.X);
                break;
            case "L" : getTem().getUnitMap().put(splited[0], RomanEnum.L);
                break;
            case "C" : getTem().getUnitMap().put(splited[0], RomanEnum.C);
                break;
            case "D" : getTem().getUnitMap().put(splited[0], RomanEnum.D);
                break;
            case "M" : getTem().getUnitMap().put(splited[0], RomanEnum.M);
        }
    }

    /**
     * 转换带有Credits的条件，如：glob glob Silver is 34 Credits
     * @param line
     */
    public static void convertCredits(String line) {
        //变成glob glob Silver 34
        String formatted = line.replaceAll("(is\\s+)|([c|C]redits\\s*)","").trim();
        //再按空格拆分
        String[] keys = formatted.split("\\s");
        //需要计算的单词 Silver
        String Compute = keys[keys.length-2];
        //和 34
        double product = Double.valueOf(keys[keys.length-1]);
        //将单词转换为罗马数字如：glob glob = II
        String roman="";
        for(int i=0;i<keys.length-2;i++)
        {
            roman += getTem().getUnitMap().get(keys[i]).getRoman();
        }
        //计算Silver价格
        double price = product/RomanUtils.getNumberFormRoman(roman);
        //将银的单价加入map中
        getTem().getPriceMap().put(Compute,price);

    }

    /**
     * 处理howMuch语句
     * @param line
     * @return
     */
    public static String howMuch(String line) {
        //获取需计算的语句how much is pish tegj glob glob ? => pish tegj glob glob
        String formatted = line.replace("?","").trim().split("\\sis\\s")[1].trim();
        //再拆成数组
        String keys[] = formatted.split("\\s+");
        //先转为罗马数字
        String roman = "";
        for(String key : keys){
            roman += getTem().getUnitMap().get(key).getRoman();
        }
        //再将罗马数字转为十进制数字
        int number = RomanUtils.getNumberFormRoman(roman);
        return formatted + " is "+number + "</br>";
    }

    /**
     * 处理how many 语句
     * @param line
     * @return
     */
    public static String howMany(String line) {
        //获取需计算的语句how many Credits is glob prok Silver ? ? => glob prok Silver
        String formatted = line.replace("?","").trim().split("(\\sis\\s)")[1];
        //拆分
        String[] keys = formatted.split("\\s");
        //遍历前面的单价
        String roman = "";
        for(int i = 0 ; i < keys.length -1 ; i++){
            roman += getTem().getUnitMap().get(keys[i]).getRoman();
        }
        //罗马数字转换成十进制
        int number =  RomanUtils.getNumberFormRoman(roman);
        //商品
        String commodity = keys[keys.length-1];
        //计算价格
        double res = number * getTem().getPriceMap().get(commodity);

        return formatted + " is "+ res + " Credits " + "</br>";
    }
}

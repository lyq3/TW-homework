package com.lyq3.galaxy.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 中间变量类，该类用于存放单位转换期间的中间变量，多为map
 * @author 卡卢比
 * @date 2018/5/20
 */
public class Tem {
    /**用于存放读取的内容行*/
    private String[] lineArray;
    /**用于存放换算单位，如：prok is V 则{"prok":5}*/
    private Map<String,RomanEnum> unitMap = new HashMap<>();
    /**存放矿石单价的map*/
    private Map<String,Double> priceMap = new HashMap<>();

    public String[] getLineArray() {
        return lineArray;
    }

    public Tem setLineArray(String[] lineArray) {
        this.lineArray = lineArray;
        return this;
    }

    public Map<String, RomanEnum> getUnitMap() {
        return unitMap;
    }

    public Tem setUnitMap(Map<String, RomanEnum> unitMap) {
        this.unitMap = unitMap;
        return this;
    }

    public Map<String, Double> getPriceMap() {
        return priceMap;
    }

    public Tem setPriceMap(Map<String, Double> priceMap) {
        this.priceMap = priceMap;
        return this;
    }
}

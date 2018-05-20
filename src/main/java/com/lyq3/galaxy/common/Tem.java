package com.lyq3.galaxy.common;

import java.util.List;
import java.util.Map;

/**
 * 中间变量类，该类用于存放单位转换期间的中间变量，多为map
 * @author 卡卢比
 * @date 2018/5/20
 */
public class Tem<T,K,V,P> {
    /**用于存放读取的内容行*/
    private T[] lineArray;
    /**用于存放换算单位，如：prok is V 则{"prok":5}*/
    private Map<K,V> unitMap;
    /**存放矿石单价的map*/
    private Map<K,P> priceMap;

    public T[] getLineArray() {
        return lineArray;
    }

    public Tem<T,K,V,P> setLineArray(T[] lineArray) {
        this.lineArray = lineArray;
        return this;
    }

    public Map<K, V> getUnitMap() {
        return unitMap;
    }

    public Tem<T,K,V,P> setUnitMap(Map<K, V> unitMap) {
        this.unitMap = unitMap;
        return this;
    }

    public Map<K, P> getPriceMap() {
        return priceMap;
    }

    public Tem<T, K, V, P> setPriceMap(Map<K, P> priceMap) {
        this.priceMap = priceMap;
        return this;
    }
}

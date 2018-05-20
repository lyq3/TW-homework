package com.lyq3.test.util;

import com.lyq3.galaxy.util.RomanUtils;
import com.lyq3.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;


/**
 * 罗马数字工具测试类
 * @author 卡卢比
 * @date 2018/5/20
 */
public class RomanUtilsTest extends BaseTest {
    @Test
    public void getNumberFormRomanTest(){
        String roman = "MMVI";
        int num = RomanUtils.getNumberFormRoman(roman);
        Assert.assertEquals("RomanUtilsTest.getNumberFormRoman()未通过测试",2006,num);
    }
}

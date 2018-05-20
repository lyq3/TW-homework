package com.lyq3.test.util;

import com.lyq3.galaxy.common.LineEnum;
import com.lyq3.galaxy.common.RomanEnum;
import com.lyq3.galaxy.util.LineUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * LineUtils测试类
 * @author 卡卢比
 */
public class LineUtilsTest {
    @Test
    public void getLineTypeTest(){
        String line = "prok is V";
        LineEnum lineEnum = LineUtils.getLineType(line);
        Assert.assertEquals("LineUtils.getLineType()未通过测试",LineEnum.CONDITION,lineEnum);
    }

    @Test
    public void convertConditionTest(){
        String line = "prok is V";
        LineUtils.init();
        LineUtils.convertCondition(line);
        Assert.assertEquals("LineUtils.convertCondition()未通过测试",RomanEnum.V,LineUtils.getTem().getUnitMap().get("prok"));
    }

    @Test
    public void convertCreditsTest(){
        //TDD
    }

    @Test
    public void howMuchTest(){
        //TDD
    }

    @Test
    public void howManyTest(){
        //TDD
    }
}

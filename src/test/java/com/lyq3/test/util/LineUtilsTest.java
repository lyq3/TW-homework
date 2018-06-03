package com.lyq3.test.util;

import com.lyq3.galaxy.common.LineEnum;
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
}

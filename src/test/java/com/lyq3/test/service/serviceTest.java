package com.lyq3.test.service;

import com.lyq3.galaxy.service.RomanService;
import com.lyq3.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service测试类
 * @author 卡卢比
 */
public class serviceTest extends BaseTest {
    @Autowired
    private RomanService romanService;
    @Test
    public void test(){
        String res = romanService.converter("glob is I\n" +
                "prok is V\n" +
                "pish is X\n" +
                "tegj is L\n" +
                "glob glob Silver is 34 Credits\n" +
                "glob prok Gold is 57800 Credits\n" +
                "pish pish Iron is 3910 Credits\n" +
                "how much is pish tegj glob glob ?\n" +
                "how many Credits is glob prok Silver ?\n" +
                "how many Credits is glob prok Gold ?\n" +
                "how many Credits is glob prok Iron ?\n" +
                "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
        System.out.println(res);

        Assert.assertEquals("未通过测试",
                "pish tegj glob glob is 42</br>glob prok Silver is 68.0 Credits </br>glob prok Gold is 57800.0 Credits </br>glob prok Iron is 782.0 Credits </br>I have no idea what you are talking about</br>"
                ,res);
    }
}

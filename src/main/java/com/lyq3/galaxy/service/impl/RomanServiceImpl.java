package com.lyq3.galaxy.service.impl;

import com.lyq3.galaxy.common.LineEnum;
import com.lyq3.galaxy.service.RomanService;
import com.lyq3.galaxy.util.LineUtils;
import org.springframework.stereotype.Service;


/**
 * 业务实现类，接收输入输出结果
 * @author 卡卢比
 * @date 2018/5/20
 */
@Service
public class RomanServiceImpl implements RomanService {

    @Override
    public String converter(String in) {
        LineUtils.init();
        String res = "";
        String[] strArray = in.split("\n|/n");
        //将拆分的行存入统一收集类中
        LineUtils.getTem().setLineArray(strArray);
        //遍历行
        for(String line : strArray){
            LineEnum lineType = LineUtils.getLineType(line.trim());

            switch (lineType) {
                case CONDITION: LineUtils.convertCondition(line);
                break;
                case SPECULATION:LineUtils.convertCredits(line);
                break;
                case HOWMANY:res += LineUtils.howMany(line);
                break;
                case HOWMUCH: res += LineUtils.howMuch(line);
                break;
                case ERROR:res += "I have no idea what you are talking about</br>";
                break;
            }

        }
        return res;
    }



}

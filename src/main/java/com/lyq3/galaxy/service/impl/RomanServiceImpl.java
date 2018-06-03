package com.lyq3.galaxy.service.impl;

import com.lyq3.galaxy.common.LineEnum;
import com.lyq3.galaxy.common.RomanEnum;
import com.lyq3.galaxy.common.Tem;
import com.lyq3.galaxy.factory.ConverterFactory;
import com.lyq3.galaxy.service.RomanService;
import com.lyq3.galaxy.util.LineUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * 业务实现类，接收输入输出结果
 * @author 卡卢比
 * @date 2018/5/20
 */
@Service
public class RomanServiceImpl implements RomanService {

    @Override
    public String converter(String in) {
        /**用于存放中间处理结果*/
        Tem tem = new Tem();
        /**输出结果*/
        String res = "";
        String[] strArray = in.split("\n|/n");
        //将拆分的行存入统一收集类中
        tem.setLineArray(strArray);
        //遍历行
        for(String line : strArray){
            //判断语句类型
            LineEnum lineType = LineUtils.getLineType(line.trim());
            //创建对应的转换器处理并返回结果
           res += ConverterFactory.build(lineType).convert(line,tem);

        }
        return res;
    }



}

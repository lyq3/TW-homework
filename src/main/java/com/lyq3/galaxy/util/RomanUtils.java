package com.lyq3.galaxy.util;

import com.lyq3.galaxy.common.BussinessException;
import com.lyq3.galaxy.common.ExceptionEnum;
import com.lyq3.galaxy.common.RomanEnum;

/**
 * 罗马数字转换相关工具类
 * @author 卡卢比
 * @date 2018/5/20
 */
public class RomanUtils {
    /**罗马数字检测正则*/
    public static String romanRegexp = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

    /**
     * 根据罗马数字获取十进制数字，并检测其合法性
     * @param roman
     * @return
     */
    public static int getNumberFormRoman(char roman){
        switch(roman)
        {
            case 'I' : return  RomanEnum.I.getValue();

            case 'V' : return RomanEnum.V.getValue();

            case 'X' : return RomanEnum.X.getValue();

            case 'L' : return RomanEnum.L.getValue();

            case 'C' : return RomanEnum.C.getValue();

            case 'D' : return RomanEnum.D.getValue();

            case 'M' : return RomanEnum.M.getValue();


        }
        throw new BussinessException(ExceptionEnum.ROMAN_ILLEGAL) ;
    }

    /**
     * 根据罗马数字字符串获取十进制数字，并检测其合法性
     * @param roman
     * @return
     */
    public static int getNumberFormRoman(String roman){
        if(!validateRomanNumber(roman)) {
            throw new BussinessException(ExceptionEnum.ROMAN_ILLEGAL);
        }
        //最终计算的十进制数
        int number = 0;
        //遍历的上一个数字
        int last = 0;
        //从后往前遍历，数字比上一个数字大则加，比上一个数字小则减
        for(int i = roman.length()-1; i >= 0; i--)
        {
            int num = getNumberFormRoman(roman.charAt(i));
            if(num >= last) {
                number +=num;
            } else {
                number -= num;
            }
            last = num;
        }
        return number;
    }

    /**
     * 检测罗马数字字符串合法性
     * @param roman
     * @return
     */
    private static boolean validateRomanNumber(String roman)
    {
        boolean result = false;

        if(roman.matches(romanRegexp))
        {
            result = true;
        }

        return result;
    }
}

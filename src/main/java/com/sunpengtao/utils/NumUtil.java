package com.sunpengtao.utils;

import java.math.BigDecimal;

public class NumUtil {
    // 获取百分数    小数取2位
    public static double getPercent(double num,double total){
        BigDecimal decimal = new BigDecimal(Double.toString(num / total * 100));
        BigDecimal scale = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return  scale.doubleValue();
    }
    // 是否为数字  （包括小数）
    public static boolean isNumber(String str) {
        String rule="^(\\-|\\+)?\\d+(\\.\\d+)?$";
        return str.matches(rule);
    }
}

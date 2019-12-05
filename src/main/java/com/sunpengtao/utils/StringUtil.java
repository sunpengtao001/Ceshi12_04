package com.sunpengtao.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private static final String CHAR_ARRAY = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
    private static final String NUM = "0123456789";
    //判断源字符串是否有值，空引号也算没值
    public static boolean isEmpty(String str){
        return str!=null && !"".equals(str);
    }
    //判断源字符串是否有值，空引号和空格也算没值
    public static boolean isEmptyAndSpace(String str){
        return str!=null && !"".equals(str.trim());
    }
    //判断是否为手机号码
    public static  boolean isPhone(String str){
        String rule = "^1(3|7|5|8)([0-9]{9})$";
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(str);
        boolean matches = matcher.matches();
//        boolean matches1 = Pattern.matches(rule, str);
//        boolean matches1 = str.matches(rule);
        return matches;
    }
    //判断是否为电子邮箱
    public static  boolean isEmail(String str){
        String rule = "^[a-z\\d]+(\\.[a-z\\d]+)*@([\\da-z](-[\\da-z])?)+(\\.{1,2}[a-z]+)+$";
        return str.matches(rule);
    }
    //判断是否全部为字母
    public static boolean isLetters(String str){
        String rule = "^[a-zA-Z]+$";
        return str.matches(rule);
    }
    //随机数 = Math.random()*(最大值-最小值+1)+最小值
    //获取n位随机英文字符串
    public static String getLetters(Integer length){
        StringBuffer sb = new StringBuffer();
        char[] chars = CHAR_ARRAY.toCharArray();
        for (int i =0;i<length;i++){
            int index = (int)(Math.random()*chars.length);
            char aChar = chars[index];
            sb.append(aChar);
        }
        return sb.toString();
    }
    //获取n位随机英文和数字字符串
    public static String getLettersAndNum(Integer length){
        StringBuffer sb = new StringBuffer();
        char[] chars = (CHAR_ARRAY+NUM).toCharArray();
        for (int i =0;i<length;i++){
            int index = (int)(Math.random()*chars.length);
            char aChar = chars[index];
            sb.append(aChar);
        }
        return sb.toString();
    }
    //获取n个随机中文字符串
    public static String getChina(Integer length){
        StringBuffer sb = new StringBuffer();
        int start = Integer.parseInt("4e00", 16);
        int end = Integer.parseInt("9fa5", 16);
        for (int i =0;i<length;i++){
            int index = (int)(Math.random()*(end-start+1)+start);
            sb.append((char)index);
        }
        return  sb.toString();
    }
    // 验证url地址
    public static boolean isHttpUrl(String str){
        String rule = "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$";
        return str.matches(rule);
    }
}

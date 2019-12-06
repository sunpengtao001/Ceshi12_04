package com.sunpengtao.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    // 根据日期算年龄
    public static int getAge(Calendar target) {
        int age = 0;
        Calendar instance = Calendar.getInstance();
        if(instance.before(target)){
            throw new IllegalArgumentException("参数不正确");
        }
        int now_year = instance.get(Calendar.YEAR);
        int now_month = instance.get(Calendar.MONTH);
        int now_day = instance.get(Calendar.DAY_OF_MONTH);
        int target_year = target.get(Calendar.YEAR);
        int target_month = target.get(Calendar.MONTH);
        int target_day = target.get(Calendar.DAY_OF_MONTH);
        age = now_year-target_year;
        if(now_month<=target_month){
            if(now_month==target_month){
                if(now_day<target_day){
                    age--;
                }
            }
            age--;
        }
        return age+1;
    }
    // 求未来日期离今天还剩的天数
    public static int getFutrueDay(Calendar target){
        int day = 0;
        long time = Calendar.getInstance().getTime().getTime();
        long time1 = target.getTime().getTime();
        if(time-time1>=0){
            throw new IllegalArgumentException("参数不正确");
        }else{
            day = (int)((time1-time)/1000/60/60/24);
        }
        return day;
    }
    // 判断给定的日期是否为今天
    public static boolean dayIsNowDay(Calendar target){
        if (target == null)
            return false;
        Calendar toDay = Calendar.getInstance();
        if (toDay.get(Calendar.YEAR) == target.get(Calendar.YEAR)) {
            if (toDay.get(Calendar.MONTH) == target.get(Calendar.MONTH)) {
                if (toDay.get(Calendar.DAY_OF_MONTH) == target.get(Calendar.DAY_OF_MONTH)) {
                    return true;
                }
            }
        }
        return false;
    }
    // 判断选择的日期是否是本月
    public static boolean dayIsInNowMonth(Calendar target) {
        if (target == null)
            return false;
        Calendar toDay = Calendar.getInstance();
        if (toDay.get(Calendar.YEAR) == target.get(Calendar.YEAR)) {
            if (toDay.get(Calendar.MONTH)== target.get(Calendar.MONTH)) {
                return true;
            }
        }
        return false;
    }
    // 判断给定的日期是否在本周之内   先过周日
    public static boolean dayIsInNowWeek(Calendar target) {
        if (target == null)
            return false;
        Calendar toDay = Calendar.getInstance();
        if(toDay.get(Calendar.WEEK_OF_YEAR)==target.get(Calendar.WEEK_OF_YEAR)){
            return true;
        }
        return false;
    }
    //  给定时间对象，初始化到该月初的1月1日0时0分0秒0毫秒
    public static void initDateTime(Calendar target) {
        // 把target 对象的日  时  分  秒   毫秒  重置
        target.set(Calendar.DAY_OF_MONTH, 1);  //  日为1
        target.set(Calendar.HOUR, 0);  // 时 0
        target.set(Calendar.MINUTE, 0); // 分 0
        target.set(Calendar.SECOND, 0); // 秒 0
        target.set(Calendar.MILLISECOND, 0); // 毫秒 0
    }
    // 判断是否为闰年
    private static boolean isLeapYear(int year) {
        // 闰年规则   年数能被4整除并且不能为 100整除 为闰年
        // 400 的倍数为闰年
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    //时间比较    日期比较 compareTo
    public static int compareDate(Date date1, Date date2) {
        // compareTo 是日期的比较器    直接使用即可
        return date1.compareTo(date2);
        // 大于 1  小于-1
    }
    //给定时间对象，设定到该月最后一天的23时59分59秒999毫秒
    public static void setToLastDateOfMonth(Calendar target) {
        int month = target.get(Calendar.MONTH+1);
        if(month==2){
            if(isLeapYear(target.get(Calendar.YEAR))){
                target.set(Calendar.DATE,29);
            }else {
                target.set(Calendar.DATE, 28);
            }
        }else{
            switch(month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    target.set(Calendar.DATE, 31);
                    break;
                default:
                    target.set(Calendar.DATE, 30);
                    break;
            }
        }
        target.set(Calendar.HOUR_OF_DAY,23);
        target.set(Calendar.MINUTE,59);
        target.set(Calendar.SECOND,59);
        target.set(Calendar.MILLISECOND,999);
    }
    //给定字符串转日期
    public static Date StringToDate(String date,String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date parse = simpleDateFormat.parse(date);
        return parse;
    }
    // 给定天数  计算该天之后的日期
    public static Date getRoundTime(int day) {
        // 得到当前日期然后将随机的天数+当前日期的天数  返回一个新的日期
        // 1：将参数的日期转换为毫秒
        int times=Math.abs(day*24*60*60*1000);
        Date date = new Date(); // 获取当前日期
//		System.out.println(date);
        long time = date.getTime();         // 获取当前日期的毫秒值
        long newTime=time+times; // 新的日期的毫秒值
        System.out.println(time+"=="+times+"=="+newTime);
        return new Date(newTime);
    }

}

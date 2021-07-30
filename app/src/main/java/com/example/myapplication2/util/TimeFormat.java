package com.example.myapplication2.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ChenHuanHuan on 2017/10/25.
 */

public class TimeFormat {
    //显示在UI上的格式
    public final static String ALL_SHOW = "yyyy-MM-dd HH:mm:ss";
    public final static String Y_M_D_H_S_SHOW = "yyyy-MM-dd HH:mm";
    public final static String Y_M_D_H_SHOW = "yyyy-MM-dd HH";
    public final static String Y_M_D_SHOW = "yyyy-MM-dd";
    public final static String Y_M_SHOW = "yyyy-MM";
    public final static String H_S_SHOW = "HH:mm";
    //存储的格式
    public final static String ALL_TIME = "yyyyMMddHHmmssSSS";
    public final static String ALL_SAVE = "yyyyMMddHHmmss";
    public final static String Y_M_D_H_S_SAVE = "yyyyMMddHHmm";
    public final static String Y_M_D_H_SAVE = "yyyyMMddHH";
    public final static String Y_M_D_SAVE = "yyyyMMdd";
    public final static String Y_M_SAVE = "yyyyMM";
    public final static String H_S_SAVE = "HHmm";

    /**
     * 得到14位的当前格式化时间
     */
    public static String getCurrTime() {
        String formatStr = ALL_SAVE;
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(new Date());
    }

    /**
     * 得到14位的当前格式化时间
     */
    public static String getHourTime() {
        String formatStr = "HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(new Date());
    }

    /**
     * 得到当前格式化时间
     */
    public static String getCurrTime(String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(new Date());
    }

    /**
     * 得到当前格式化时间
     */
    public static long getCurrDate(String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return new Date().getTime();
    }
    //string->Date
    public static Calendar timeStrToDate(String time, String type) {
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat sdfStr = new SimpleDateFormat(type);
            Date date = sdfStr.parse(time);
            calendar.setTime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendar;
    }

    //string->Date
    public static String dateToTime(Date date, String type) {
        return new SimpleDateFormat(type).format(date);
    }

    public static Date getCurDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    //时间差
    public static long timePeriod(Date preDate, Date curDate) {
        return (curDate.getTime() - preDate.getTime()) / 1000;
    }


    public static Date timeToDate(String time, String type) {
        try {
            SimpleDateFormat sdfStr = new SimpleDateFormat(type);
            return sdfStr.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //时间范围内
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }

}

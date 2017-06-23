package com.cicinnus.retrofitlib.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Administrator on 2017/1/18.
 */

public class TimeUtil {

    public static String dateYMDHM(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        return format.format(time);
    }

    public static String dateYMD(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return format.format(time);
    }

    public static String dateMD(long time) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd", Locale.CHINA);
        return format.format(time);

    }

    public static String dateMDHSCN(long time) {
        SimpleDateFormat format = new SimpleDateFormat("MM月\tdd日 HH:mm", Locale.CHINA);
        return format.format(time);
    }

    public static String dateMDCN(long time) {
        SimpleDateFormat format = new SimpleDateFormat("MM月\tdd日", Locale.CHINA);
        return format.format(time);
    }

    public static String secondToMinute(int seconds) {
        if (seconds < 60) {
            return String.format("00:%s", seconds);
        } else {
            if (seconds / 60 <= 10) {
                return String.format("0%s:%s", seconds / 60, seconds % 60);
            } else {
                return String.format("%s:%s", seconds / 60, seconds % 60);
            }
        }
    }

    /**
     * 获取当天时间
     * @return 毫秒
     */
    public static long getTodayStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 获取当月第一天
     * @return 毫秒
     */
    public static long getCurrentMonth(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,1);
        return cal.getTimeInMillis();
    }

    /**
     * 获取当天最后时间
     * @return
     */
    public static long getTodayEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }


    /**
     *  7天内时间显示
     * @param time
     * @return
     */
    public static String daysAgo(long time) {
        String ago = dateYMD(time);
        long currentTime = System.currentTimeMillis();
        long second = (currentTime - time) / 10000;
        if (second / 60 > 0) {
            ago = String.format("%s分钟前", second / 60);
            if (second / 360 > 0) {
                ago = String.format("%s小时前", second / 360);
                if (second / (360 * 24) > 0 && second / (360 * 24) < 7) {
                    ago = String.format("%s天前", second / (360 * 24));
                }
            }
        }
        return ago;
    }

    /**
     *  获取当天GMT时间
     * @return
     */
    public static String getCurrentGMT() {
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // 设置时区为GMT
        return sdf.format(cd.getTime());
    }

    /**
     * 判断日期是该星期的第几天
     * @param time
     * @return
     */
    public static int dayForWeek(String time)  {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        try {
            c.setTime(format.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int dayForWeek = 0;

        if (c.get(Calendar.DAY_OF_WEEK) == 1) {

            dayForWeek = 7;

        } else {

            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;

        }

        return dayForWeek;
    }
}

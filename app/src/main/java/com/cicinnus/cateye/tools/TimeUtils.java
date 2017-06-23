package com.cicinnus.cateye.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Administrator on 2017/1/18.
 */

public class TimeUtils {

    public static String dateYMDHM(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
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

    public static long dateToMillions(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        try {
            Date timeDate = format.parse(date);
            return timeDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis();
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

    public static String MinuteToHour(int minute) {

        if (minute / 60 < 24) {
            return String.format("%s:%s", minute / 60 <= 10 ? "0" + minute / 60 : minute / 60, minute % 60 < 10 ? "0" + minute % 60 : minute % 60);
        } else {
            //大于24小时
            minute = minute - 1440;
            return MinuteToHour(minute);
        }
    }


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

    public static String getCurrentGMT() {
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // 设置时区为GMT
        return sdf.format(cd.getTime());
    }

}

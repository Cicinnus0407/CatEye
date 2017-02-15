package com.cicinnus.cateye.tools;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Administrator on 2017/1/18.
 */

public class TimeUtils {

    public static String dateYMDHM(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        return format.format(time);
    }

    public static String dateYMD(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        return format.format(time);
    }

    public static String dateMD(long time) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd", Locale.CHINA);
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

}

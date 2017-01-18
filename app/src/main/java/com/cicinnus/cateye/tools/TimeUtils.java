package com.cicinnus.cateye.tools;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Administrator on 2017/1/18.
 */

public class TimeUtils {

    public static String dateYMDHM(long time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String day = format.format(time);
        return day;
    }
}

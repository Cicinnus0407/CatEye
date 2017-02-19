package com.cicinnus.cateye.tools;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/2/10.
 */

public class StringUtil {

    public static String changeNumToCN(int num) {
        int u = (int) Math.floor(Math.log10(num));
        if (u > 6) {
            return String.format("%s万", num / 6);
        } else return String.format("%s", num);
    }

    public static String changeMillionIntoBillion(int count) {
        DecimalFormat format = new DecimalFormat("0.0");
        int u = (int) Math.floor(Math.log10(count));
        if (u >= 4) {
            return String.format("%s亿", format.format(count / 10000.0));
        } else return String.format("%s万", count);
    }
}

package com.cicinnus.cateye.tools;

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
}

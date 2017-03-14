package com.cicinnus.cateye.tools;

import com.orhanobut.logger.Logger;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/2/10.
 */

public class StringUtil {

    /**
     * 将数字转为带单位(万)
     *
     * @param num
     * @return
     */
    public static String changeNumToCN(int num) {
        int u = (int) Math.floor(Math.log10(num));
        if (u > 6) {
            return String.format("%s万", num / 6);
        } else return String.format("%s", num);
    }


    /**
     * 讲数字转为带单位(亿)
     *
     * @param count
     * @return
     */
    public static String changeMillionIntoBillion(int count) {
        DecimalFormat format = new DecimalFormat("0.0");
        int u = (int) Math.floor(Math.log10(count));
        if (u >= 4) {
            return String.format("%s亿", format.format(count / 10000.0));
        } else return String.format("%s万", count);
    }

    public static String getRealUrl(String url) {
        Logger.d(url);
        if (url.contains("id=")) {
            if(url.contains("&")) {
                String id = url.substring(url.indexOf("id=") + 3, url.indexOf("&"));
                return "http://m.maoyan.com/information/" + id + "?_v_=yes";
            }else {
                String id = url.substring(url.indexOf("id=") + 3);
                return "http://m.maoyan.com/information/" + id + "?_v_=yes";
            }
        }else if(url.contains("ID=")){
            if(url.contains("&")) {
                String id = url.substring(url.indexOf("ID=") + 3, url.indexOf("&"));
                return "http://m.maoyan.com/topic/" + id + "?_v_=yes";
            }else {
                String id = url.substring(url.indexOf("ID=") + 3);
                return "http://m.maoyan.com/topic/" + id + "?_v_=yes";
            }
        }
        return new Exception("Error Url").toString();

    }
}

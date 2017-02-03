package com.cicinnus.cateye.tools;

/**
 * Created by Administrator on 2017/2/3.
 */

public class ImgSizeUtil {

    public static String resetPicUrl(String url, String size){
        return url.replace("/w.h/", "/")+size;
    }
}

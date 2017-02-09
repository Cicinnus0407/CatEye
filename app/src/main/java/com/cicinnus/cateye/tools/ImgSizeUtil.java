package com.cicinnus.cateye.tools;

import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2017/2/3.
 */

public class ImgSizeUtil {

    //部分图片通过拼接url
    public static String resetPicUrl(@NonNull String url, String size){

        return url.replace("/w.h/", "/")+size;
    }

    //通过替换w.h获取图片
    public static String processUrl(@NonNull String url,int width,int height){
        return url.replace("/w.h/","/"+width+"."+height+"/");
    }
}

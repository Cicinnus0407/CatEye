package com.cicinnus.cateye.tools;

import android.content.Context;

/**
 * Created by Administrator on 2017/1/19.
 */

public class UiUtils {
    public static int dp2px(Context context, float dpValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale +0.5f);
    }
}

package com.cicinnus.cateye.tools;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/18.
 */

public class ToastUtil {

    public static void showShort(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}

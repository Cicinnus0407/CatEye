package com.cicinnus.cateye.tools;

import android.widget.Toast;

import com.cicinnus.cateye.application.BaseApplication;

/**
 *
 */

public class ToastUtil {

    private static Toast toast;

    public static void showToast(String errorMsg) {

        if (toast != null) {
            toast.setText(errorMsg);
        }else {
            toast = Toast.makeText(BaseApplication.getInstance(),errorMsg,Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}

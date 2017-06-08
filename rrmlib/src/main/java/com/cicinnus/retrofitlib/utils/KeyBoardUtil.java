package com.cicinnus.retrofitlib.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 软键盘工具类
 */

public class KeyBoardUtil {

    /**
     * 强制隐藏软键盘
     * @param view
     * @param context
     */
    public static void hideKeyBoard(View view, Context context){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
    /**
     * 强制显示软键盘
     * @param view
     * @param context
     */
    public static void showKeyBoard(View view, Context context){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInputFromInputMethod(view.getWindowToken(),0);
    }

    /**
     * 切换软键盘的状态
     * @param view
     * @param context
     */
    public static void toggleSoftInputFromWindow(View view, Context context){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInputFromWindow(view.getWindowToken(),0,InputMethodManager.HIDE_NOT_ALWAYS);
    }
}

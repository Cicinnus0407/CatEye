package com.cicinnus.cateye.application;

import android.app.Application;

/**
 * Created by Administrator on 2017/1/18.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static BaseApplication getInstance() {
        return instance;
    }

}

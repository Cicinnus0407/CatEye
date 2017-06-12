package com.cicinnus.cateye.application;

import android.app.Application;

import com.amap.api.location.AMapLocationClient;
import com.cicinnus.cateye.net.Api;
import com.cicinnus.cateye.net.OkHttpManager;
import com.cicinnus.cateye.net.RetrofitClient;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Administrator on 2017/1/18.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        LeakCanary.install(this);
        RetrofitClient.initClient_BaseUrl(OkHttpManager.getInstance(), Api.BASE_URL);
        AMapLocationClient.setApiKey("979bfef3d3226a0a475200e5dd269a56");
    }

    public static BaseApplication getInstance() {
        return instance;
    }

}

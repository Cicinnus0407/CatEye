package com.cicinnus.cateye.net;

import com.cicinnus.cateye.application.BaseApplication;
import com.cicinnus.cateye.base.Constants;
import com.cicinnus.retrofitlib.utils.SPUtils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 全局请求参数添加,
 */

public class GlobalParameterInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        // 添加新的参数
        HttpUrl.Builder newBuilder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host());
        Request.Builder builder = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body());
        //全部添加ci请求参数,ci为所在地参数
        int ci = SPUtils.getInstance(BaseApplication.getInstance(), Constants.SP_CITY).getInt(Constants.CITY_CODE, 20);
        newBuilder.addQueryParameter("ci", String.valueOf(ci));

        // 新的请求
        Request newRequest = builder.url(newBuilder.build()).build();
        Response response = chain.proceed(newRequest);
        return response;
    }
}

package com.cicinnus.cateye.net;


import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/1/18.
 */

public class RetrofitClient {
    private static RetrofitClient mInstance;
    private static Retrofit retrofit;
    private static String mBaseUrl;

    private RetrofitClient(OkHttpClient okHttpClient, String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient != null ? okHttpClient : new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    /**
     * 配置自定义的OkHttpClient
     *
     * @param okHttpClient
     * @return
     */
    public static RetrofitClient initClient_BaseUrl(OkHttpClient okHttpClient, @NonNull String baseUrl) {
        mBaseUrl = baseUrl;
        if (mInstance == null) {
            synchronized (RetrofitClient.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitClient(okHttpClient, baseUrl);
                }
            }
        }
        return mInstance;
    }


    /**
     * 获取Retrofit的实例
     *
     * @return
     */
    public static RetrofitClient getInstance() {
        if (mBaseUrl == null) {
            throw new RuntimeException("Please initialize Your \"BaseUrl\" in Application before use");
        }
        if (mInstance == null) {
            throw new RuntimeException("Please initialize Your \"RetrofitCoreClient\" in Application before use");
        }
        return mInstance;
    }

    /**
     * 构建请求
     *
     * @param clz 请求接口
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> clz) {
        return retrofit.create(clz);
    }

    public Api api(){
        return getInstance().create(Api.class);
    }

}

package com.cicinnus.retrofitlib.hybrid.wrapper;

/**
 * Java调用Js的回调接口
 */

public interface JavaCallBack {
    //JS给Java的回调数据
    void onJsResponse(String data);
}

package com.cicinnus.retrofitlib.hybrid.wrapper;


import com.cicinnus.retrofitlib.hybrid.jsbridge.CallBackFunction;

/**
 * Js调用本地方法的回调接口
 */

public interface JsCallBack {
    //Js调用本地唤起本地的方法
    void notifyNativeMethod();
    //Js传过来的数据
    void JsData(String data);
    //回调给Js的参数
    void CallBack(CallBackFunction function);
}

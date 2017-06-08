package com.cicinnus.retrofitlib.hybrid.wrapper;


import com.cicinnus.retrofitlib.hybrid.jsbridge.BridgeHandler;
import com.cicinnus.retrofitlib.hybrid.jsbridge.BridgeWebView;
import com.cicinnus.retrofitlib.hybrid.jsbridge.CallBackFunction;

/**
 * 封装JS与Java双向调用的两个方法
 */

public class WebViewTools {

    private BridgeWebView mWebView;

    /**
     * 传入经过重写的WebView
     * @param mWebView BridgeWebView
     */
    public WebViewTools(BridgeWebView mWebView) {
        this.mWebView = mWebView;
    }


    /**
     *  Js调用本地方法
     * @param functionName JS和Java约定的方法名
     * @param jsCallBack Java给JS的回调
     */
    public void registerWebViewFunction(String functionName, final JsCallBack jsCallBack) {
        mWebView.registerHandler(functionName, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                jsCallBack.notifyNativeMethod();
                jsCallBack.JsData(data);
                jsCallBack.CallBack(function);
            }
        });
    }

    /**
     * Java调用Js方法
     * @param functionName JS和Java约定的方法名
     * @param data Java传给JS的数据
     * @param javaCallBack JS给Java的数据回调
     */
    public void callWebFunction(String functionName, String data, final JavaCallBack javaCallBack) {
        mWebView.callHandler(functionName, data, new CallBackFunction() {
            @Override
            public void onCallBack(String data) {
                javaCallBack.onJsResponse(data);
            }
        });
    }


}

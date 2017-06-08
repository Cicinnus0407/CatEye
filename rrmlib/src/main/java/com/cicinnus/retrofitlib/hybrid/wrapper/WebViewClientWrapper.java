package com.cicinnus.retrofitlib.hybrid.wrapper;

import android.annotation.TargetApi;
import android.os.Build;

import com.cicinnus.retrofitlib.hybrid.jsbridge.BridgeWebView;
import com.cicinnus.retrofitlib.hybrid.jsbridge.BridgeWebViewClient;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

/**
 *  WebViewClient包装类，暴露网页加载的状态
 */

public abstract class WebViewClientWrapper extends BridgeWebViewClient {

    private boolean loadError;

    public WebViewClientWrapper(BridgeWebView webView) {
        super(webView);
    }

    @Override
    public void onPageFinished(WebView webView, String s) {
        super.onPageFinished(webView, s);
        if (!loadError) {
            //网页加载成功
            WebLoadSuccess(s);
        }else {
            WebLoadFail(s);
        }

    }




    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if (url.startsWith("http:") || url.startsWith("https:")) {
            WebLoading(url);
            return false;
        } else {
            return super.shouldOverrideUrlLoading(webView, url);
        }
    }


    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        if(errorCode==404){
            WebLoad404();
        }
        loadError = true;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if(webResourceResponse.getStatusCode()==404){
            WebLoad404();
        }
    }

    public boolean isLoadError() {
        return loadError;
    }

    public void setLoadError(boolean loadError) {
        this.loadError = loadError;
    }


    //网页加载成功
    public abstract void WebLoadSuccess(String s);

    //网页加载失败
    public void WebLoadFail(String s) {}

    public void WebLoad404(){}

    //网页正在加载
    public abstract void WebLoading(String url);
}

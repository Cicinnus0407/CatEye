package com.cicinnus.retrofitlib.hybrid.wrapper;

import android.annotation.SuppressLint;
import android.content.Context;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;


/**
 * 配置webViewSetting
 */

public class WebViewSettingUtil {
    @SuppressLint("SetJavaScriptEnabled")
    public static void initWebViewSetting(Context context, WebView webView){
        webView.requestFocusFromTouch();
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
//        webSettings.setBlockNetworkImage(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setSaveFormData(true);
        webSettings.setLoadsImagesAutomatically(true);

        String user_agent = "Mozilla/5.0 (Macintosh; U; PPC Mac OS X; en) AppleWebKit/124 (KHTML, like Gecko) Safari/125.1";
        webSettings.setUserAgentString(user_agent);

        /* Enable zooming */
        webSettings.setSupportZoom(false);
        //webView.setInitialScale(39);//设置 39适应竖屏    57适应横屏
        //缓存机制
        webSettings.setDomStorageEnabled(true);
        //缓存模式，设为无网加载缓存
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setAppCacheMaxSize(15 * 1024 * 1024);
        webSettings.setAppCacheEnabled(true);
        String appCacheDir = context.getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();
        //设置缓存目录
        webSettings.setAppCachePath(appCacheDir);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAppCacheEnabled(true);

        String dir = context.getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();

        webSettings.setGeolocationDatabasePath(dir);
        webSettings.setGeolocationEnabled(true);
    }
}

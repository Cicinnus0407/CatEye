package com.cicinnus.cateye.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class BaseWebViewActivity extends BaseActivity {

    private static final String TARGET_ID = "id";
    private static final String URL = "url";
    private String mUrl;

    public static void start(Context context, int id) {
        Intent starter = new Intent(context, BaseWebViewActivity.class);
        starter.putExtra(TARGET_ID, id);
        context.startActivity(starter);
    }

    public static void start(Context context, String url) {
        Intent starter = new Intent(context, BaseWebViewActivity.class);
        starter.putExtra(URL, url);
        context.startActivity(starter);
    }


    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override
    protected int getLayout() {
        return R.layout.activity_base_webview;
    }

    @Override
    protected void initEventAndData() {
        int id = getIntent().getIntExtra(TARGET_ID, 0);
        mUrl = getIntent().getStringExtra(URL);
        setUpWebView();
        if (id != 0) {
            String url = "http://m.maoyan.com/topic/" + id + "?_v_=yes&f=android";
            webView.loadUrl(url);
        }
        if (mUrl != null) {
            String realUrl = mUrl.substring(mUrl.indexOf("=") + 1);
            Logger.d(realUrl);
            webView.loadUrl(realUrl);
        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setUpWebView() {


        WebSettings webSetting = webView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setSupportZoom(false);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSetting.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSetting.setDomStorageEnabled(true);

        WebViewClient client = new WebViewClient() {
            /**
             * 防止加载网页时调起系统浏览器
             */
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        };
        webView.setWebViewClient(client);
    }

    //返回上一个页面
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick(R.id.ib_back)
    void onClick() {
        finish();
    }
}

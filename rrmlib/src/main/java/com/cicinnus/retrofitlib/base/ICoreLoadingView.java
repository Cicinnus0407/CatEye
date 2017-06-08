package com.cicinnus.retrofitlib.base;

/**
 * 默认的加载接口
 */

public interface ICoreLoadingView {
    void showLoading();
    void showContent();
    void showError(String errorMsg);


}

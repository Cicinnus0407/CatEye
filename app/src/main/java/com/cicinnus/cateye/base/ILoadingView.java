package com.cicinnus.cateye.base;

/**
 * Created by Cicinnus on 2016/9/15.
 */

public interface ILoadingView {
    void showLoading();
    void showContent();
    void showError(String errorMsg);

}

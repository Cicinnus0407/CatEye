package com.cicinnus.cateye.base;

import android.app.Activity;

import com.cicinnus.cateye.tools.ErrorHanding;
import com.cicinnus.cateye.tools.ToastUtil;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2017/1/18.
 */
public class BasePresenter<T> implements IPresenter {
    protected Activity mActivity;
    protected T mView;
    protected CompositeSubscription mCompositeSubscription;

    public BasePresenter(Activity activity, T view) {
        this.mActivity = activity;
        this.mView = view;
    }

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }

    protected void handleError(Throwable throwable) {
        ToastUtil.showShort(mActivity, ErrorHanding.handleError(throwable));
    }

    public void showToast(String msg){
        ToastUtil.showShort(mActivity,msg);
    }

}

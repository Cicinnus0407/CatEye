package com.cicinnus.cateye.module.discover;

import android.app.Activity;

import com.cicinnus.retrofitlib.base.BaseMVPPresenter;
import com.cicinnus.retrofitlib.net.error.ExceptionHandle;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/1/18.
 */

public class DiscoverPresenter extends BaseMVPPresenter<DiscoverContract.IDiscoverView> implements DiscoverContract.IDiscoverPresenter {

    private final DiscoverManager discoverManager;

    public DiscoverPresenter(Activity activity, DiscoverContract.IDiscoverView view) {
        super(activity, view);
        discoverManager = new DiscoverManager();
    }

    @Override
    public void getDiscoverData(int offset, int limit) {
        mView.showLoading();
        addSubscribeUntilDestroy(discoverManager.getDiscoverData(offset, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DiscoverBean>() {
                    @Override
                    public void accept( DiscoverBean discoverBean)  {
                        mView.addDiscoverData(discoverBean.getData().getFeeds());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)  {
                        mView.showError(ExceptionHandle.handleException(throwable));

                    }
                }, new Action() {
                    @Override
                    public void run()  {
                        mView.showContent();
                    }
                }));
    }

    @Override
    public void getDiscoverHeader(String utm_term) {
        addSubscribeUntilDestroy(discoverManager.getDiscoverHeaderData(utm_term)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DiscoverHeaderBean>() {
                    @Override
                    public void accept(@NonNull DiscoverHeaderBean discoverHeaderBean) throws Exception {
                        mView.addDiscoverHeaderData(discoverHeaderBean.getData());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
//                        mView.showError("获取顶部栏目失败");

                    }
                }));
    }
}

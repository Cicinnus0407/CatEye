package com.cicinnus.cateye.module.discover;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/1/18.
 */

public class DiscoverPresenter extends BasePresenter<DiscoverContract.IDiscoverView> implements DiscoverContract.IDiscoverPresenter {

    private final DiscoverManager discoverManager;

    public DiscoverPresenter(Activity activity, DiscoverContract.IDiscoverView view) {
        super(activity, view);
        discoverManager = new DiscoverManager();
    }

    @Override
    public void getDiscoverData(int offset, int limit) {
        mView.showLoading();
        addSubscribe(discoverManager.getDiscoverData(offset, limit)
                .subscribe(new Subscriber<DiscoverBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(DiscoverBean discoverBean) {
                        mView.addDiscoverData(discoverBean.getData().getFeeds());
                    }
                }));
    }
}

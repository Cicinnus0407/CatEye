package com.cicinnus.cateye.module.movie.find_movie.awards_movie.awards_list;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/2/7.
 */

public class AwardsListPresenter extends BasePresenter<AwardsListContract.IAwardsListView> implements AwardsListContract.IAwardsListPresenter {

    private final AwardsListManager awardsListManager;

    public AwardsListPresenter(Activity activity, AwardsListContract.IAwardsListView view) {
        super(activity, view);
        awardsListManager = new AwardsListManager();
    }

    @Override
    public void getAwardsList() {
        mView.showLoading();
        addSubscribe(awardsListManager.getAwardsList()
                .subscribe(new Subscriber<AwardsListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(AwardsListBean awardsListBean) {
                        mView.addAwardsList(awardsListBean.getData());
                    }
                }));
    }
}

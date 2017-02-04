package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.recent_expect;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.tools.ErrorHanding;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/2/4.
 */

public class RecentExpectPresenter extends BasePresenter<RecentExpectMovieContract.IRecentExpectMovieView> implements RecentExpectMovieContract.IRecentExpectMoviePresenter {

    private final RecentExpectMovieManager recentExpectMovieManager;

    public RecentExpectPresenter(Activity activity, RecentExpectMovieContract.IRecentExpectMovieView view) {
        super(activity, view);
        recentExpectMovieManager = new RecentExpectMovieManager();
    }

    @Override
    public void getRecentExpectMovie(int offset) {
        mView.showLoading();
        addSubscribe(recentExpectMovieManager.getRecentExpectMovieList(offset)
        .subscribe(new Subscriber<RecentExpectMovieBean>() {
            @Override
            public void onCompleted() {
                mView.showContent();
            }

            @Override
            public void onError(Throwable e) {
                mView.showError(ErrorHanding.handleError(e));
            }

            @Override
            public void onNext(RecentExpectMovieBean recentExpectBean) {
                mView.addData(recentExpectBean.getData().getContent(),recentExpectBean.getData().getCreated());
                mView.addRecentExpectMovie(recentExpectBean.getData());
            }
        }));
    }
}

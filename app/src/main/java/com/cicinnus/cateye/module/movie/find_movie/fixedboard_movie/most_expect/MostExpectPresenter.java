package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.most_expect;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.tools.ErrorHanding;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/2/4.
 */

public class MostExpectPresenter extends BasePresenter<MostExpectMovieContract.IRecentExpectMovieView> implements MostExpectMovieContract.IRecentExpectMoviePresenter {

    private final MostExpectMovieManager mostExpectMovieManager;

    public MostExpectPresenter(Activity activity, MostExpectMovieContract.IRecentExpectMovieView view) {
        super(activity, view);
        mostExpectMovieManager = new MostExpectMovieManager();
    }

    @Override
    public void getRecentExpectMovie(int offset) {
        mView.showLoading();
        addSubscribe(mostExpectMovieManager.getRecentExpectMovieList(offset)
        .subscribe(new Subscriber<MostExpectMovieBean>() {
            @Override
            public void onCompleted() {
                mView.showContent();
            }

            @Override
            public void onError(Throwable e) {
                mView.showError(ErrorHanding.handleError(e));
            }

            @Override
            public void onNext(MostExpectMovieBean recentExpectBean) {
                mView.addData(recentExpectBean.getData().getContent(),recentExpectBean.getData().getCreated());
                mView.addRecentExpectMovie(recentExpectBean.getData());
            }
        }));
    }
}

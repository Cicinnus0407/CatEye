package com.cicinnus.cateye.module.movie.wait_movie;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;

import rx.Subscriber;

/**
 * Created by Cicinnus on 2017/1/25.
 */

public class WaitMoviePresenter extends BasePresenter<WaitMovieFragmentContract.IWaitMovieView> implements WaitMovieFragmentContract.IWaitMoviePresenter {

    private final WaitMovieManager waitMovieManager;

    public WaitMoviePresenter(Activity activity, WaitMovieFragmentContract.IWaitMovieView view) {
        super(activity, view);
        waitMovieManager = new WaitMovieManager();
    }

    @Override
    public void getTrailerRecommendMovie() {
        addSubscribe(waitMovieManager.getTrailerRecommendMovie()
                .subscribe(new Subscriber<TrailerRecommendBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TrailerRecommendBean trailerRecommendBean) {
                        mView.addWaitMovieList(trailerRecommendBean.getData());
                    }
                }));
    }
}

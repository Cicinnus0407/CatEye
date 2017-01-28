package com.cicinnus.cateye.module.movie.wait_movie;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.wait_movie.bean.RecentExpectBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.cateye.tools.ErrorHanding;

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
                        mView.addTrailerRecommendMovieList(trailerRecommendBean.getData());
                    }
                }));
    }

    @Override
    public void getRecentExpect(int offset, int limit) {
        mView.showLoading();
        addSubscribe(waitMovieManager.getRecentExpectList(offset, limit)
                .subscribe(new Subscriber<RecentExpectBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(ErrorHanding.handleError(e));
                    }

                    @Override
                    public void onNext(RecentExpectBean recentExpectBean) {
                        mView.addRecentExpectMovieList(recentExpectBean.getData().getComing());
                    }
                }));
    }

    @Override
    public void getWaitMovieList(int ci, int limit) {
        mView.showLoading();
        addSubscribe(waitMovieManager.getWaitMovieList(ci, limit)
                .subscribe(new Subscriber<WaitMovieBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(ErrorHanding.handleError(e));
                    }

                    @Override
                    public void onNext(WaitMovieBean waitMovieBean) {
                        mView.addWaitMovieList(waitMovieBean.getData().getComing());
                    }
                }));
    }
}

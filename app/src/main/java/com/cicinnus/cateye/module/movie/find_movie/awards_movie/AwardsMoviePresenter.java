package com.cicinnus.cateye.module.movie.find_movie.awards_movie;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsBean;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsMovieListBean;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/2/6.
 */

public class AwardsMoviePresenter extends BasePresenter<AwardsMovieContract.IAwardsMovieView> implements AwardsMovieContract.IAwardsMoviePresenter {

    private final AwardsMovieManager awardsMovieManager;

    public AwardsMoviePresenter(Activity activity, AwardsMovieContract.IAwardsMovieView view) {
        super(activity, view);
        awardsMovieManager = new AwardsMovieManager();
    }

    @Override
    public void getAwards(int festivalId) {
        mView.showLoading();
        addSubscribe(awardsMovieManager.getAwards(festivalId)
                .subscribe(new Subscriber<AwardsBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(AwardsBean awardsBean) {
                        mView.addAwardTitle(awardsBean.getData());
                    }
                }));
    }

    @Override
    public void getAwardsMovie(int festSessionId, int limit, int offset) {
        mView.showLoading();
        addSubscribe(awardsMovieManager.getAwardsMovie(festSessionId, limit, offset)
                .subscribe(new Subscriber<AwardsMovieListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(AwardsMovieListBean awardsMovieBean) {
                        mView.addAwardsMovie(awardsMovieBean.getData());
                    }
                }));
    }

    @Override
    public void getMoreAwardsMovie(int festSessionId, int limit, int offset) {
        addSubscribe(awardsMovieManager.getAwardsMovie(festSessionId, limit, offset)
                .subscribe(new Subscriber<AwardsMovieListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(AwardsMovieListBean awardsMovieBean) {
                        mView.addMoreAwardsMovie(awardsMovieBean.getData());
                    }
                }));
    }
}

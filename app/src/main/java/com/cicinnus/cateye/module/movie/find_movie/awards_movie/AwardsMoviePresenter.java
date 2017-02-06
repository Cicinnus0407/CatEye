package com.cicinnus.cateye.module.movie.find_movie.awards_movie;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
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
    public void getAwards(String festivalId) {

    }

    @Override
    public void getAwardsMovie(String festSessionId, int offset) {
        mView.showLoading();
        addSubscribe(awardsMovieManager.getAwardsMovie(festSessionId, offset)
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
                        mView.addIAwardsMovie(awardsMovieBean.getData());
                    }
                }));
    }
}

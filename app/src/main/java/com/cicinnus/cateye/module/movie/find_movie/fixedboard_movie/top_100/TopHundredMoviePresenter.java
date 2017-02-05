package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.top_100;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.tools.ErrorHanding;

import rx.Subscriber;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class TopHundredMoviePresenter extends BasePresenter<TopHundredMovieContract.ITopHundredMovieView> implements TopHundredMovieContract.ITopHUndredMoviePresenter {

    private final TopHundredMovieManager topHundredMovieManager;

    public TopHundredMoviePresenter(Activity activity, TopHundredMovieContract.ITopHundredMovieView view) {
        super(activity, view);
        topHundredMovieManager = new TopHundredMovieManager();
    }


    @Override
    public void getTopHundredMovie(int offset) {
        mView.showLoading();
        addSubscribe(topHundredMovieManager.getTopHundredMovie(offset)
                .subscribe(new Subscriber<TopHundredMovieBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(ErrorHanding.handleError(e));
                    }

                    @Override
                    public void onNext(TopHundredMovieBean topHundredMovieBean) {
                        mView.addContent(topHundredMovieBean.getData().getCreated(),topHundredMovieBean.getData().getContent());
                        mView.addTopHundredMovie(topHundredMovieBean.getData().getMovies());
                    }
                }));
    }
}

package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;

import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMoviePresenter extends BasePresenter<OverseaMovieContract.IOverseaMovieView> implements OverseaMovieContract.IOverseaMoviePresenter {

    private final OverseaMovieManager overseaMovieManager;

    public OverseaMoviePresenter(Activity activity, OverseaMovieContract.IOverseaMovieView view) {
        super(activity, view);
        overseaMovieManager = new OverseaMovieManager();
    }

    @Override
    public void getOverseaMovie(final String area) {
        mView.showLoading();
        addSubscribe(overseaMovieManager.getOverseaMovie(area)
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError("解析出错");
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        mView.addOverseaMovie(responseBody);
                    }
                }));

    }
}

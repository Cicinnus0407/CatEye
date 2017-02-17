package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.oversea_movie_total_list;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaComingMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;
import com.orhanobut.logger.Logger;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/2/9.
 */

public class OverseaMovieListPresenter extends BasePresenter<OverseaMovieListContract.IOverseaMovieListView> implements OverseaMovieListContract.IOverseaMovieListPresenter {

    private final OverseaMovieListManager overseaMovieListManager;

    public OverseaMovieListPresenter(Activity activity, OverseaMovieListContract.IOverseaMovieListView view) {
        super(activity, view);
        overseaMovieListManager = new OverseaMovieListManager();
    }


    @Override
    public void getOverseaHotMovieList(String area, int limit, int offset) {
        mView.showLoading();
        addSubscribe(overseaMovieListManager.getOverseaHotMovie(area, limit, offset)
        .subscribe(new Subscriber<OverseaHotMovieBean>() {
            @Override
            public void onCompleted() {
                mView.showContent();
            }

            @Override
            public void onError(Throwable e) {
                Logger.e(e.getMessage());
                mView.showError(e.getMessage());
            }

            @Override
            public void onNext(OverseaHotMovieBean overseaHotMovieBean) {
                mView.addOverseaHotMovieList(overseaHotMovieBean.getData().getHot());
            }
        }));
    }

    @Override
    public void getOverseaComingMovieList(String area, int limit, int offset) {
        mView.showLoading();
        addSubscribe(overseaMovieListManager.getOverseaComingMovie(area, limit, offset)
        .subscribe(new Subscriber<OverseaComingMovieBean>() {
            @Override
            public void onCompleted() {
                mView.showContent();
            }

            @Override
            public void onError(Throwable e) {
                Logger.e(e.getMessage());
                mView.showError(e.getMessage());
            }

            @Override
            public void onNext(OverseaComingMovieBean overseaComingMovieBean) {
                mView.addOverseaComingMovieList(overseaComingMovieBean.getData().getComing());
            }
        }));
    }
}

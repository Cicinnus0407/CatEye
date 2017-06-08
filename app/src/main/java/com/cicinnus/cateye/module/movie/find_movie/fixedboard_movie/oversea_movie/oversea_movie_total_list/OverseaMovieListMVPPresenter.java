package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.oversea_movie_total_list;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaComingMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;
import com.orhanobut.logger.Logger;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Administrator on 2017/2/9.
 */

public class OverseaMovieListMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<OverseaMovieListContract.IOverseaMovieListView> implements OverseaMovieListContract.IOverseaMovieListPresenter {

    private final OverseaMovieListManager overseaMovieListManager;

    public OverseaMovieListMVPPresenter(Activity activity, OverseaMovieListContract.IOverseaMovieListView view) {
        super(activity, view);
        overseaMovieListManager = new OverseaMovieListManager();
    }


    @Override
    public void getOverseaHotMovieList(String area, int limit, int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(overseaMovieListManager.getOverseaHotMovie(area, limit, offset)
        .subscribe(new Consumer<OverseaHotMovieBean>() {
            @Override
            public void accept(@NonNull OverseaHotMovieBean overseaHotMovieBean) throws Exception {
                mView.addOverseaHotMovieList(overseaHotMovieBean.getData().getHot());

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Logger.e(throwable.getMessage());
                mView.showError(throwable.getMessage());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                mView.showContent();
            }
        }));
    }

    @Override
    public void getOverseaComingMovieList(String area, int limit, int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(overseaMovieListManager.getOverseaComingMovie(area, limit, offset)
        .subscribe(new Consumer<OverseaComingMovieBean>() {
            @Override
            public void accept(@NonNull OverseaComingMovieBean overseaComingMovieBean) throws Exception {
                mView.addOverseaComingMovieList(overseaComingMovieBean.getData().getComing());

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Logger.e(throwable.getMessage());
                mView.showError(throwable.getMessage());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                mView.showContent();
            }
        }));
    }
}

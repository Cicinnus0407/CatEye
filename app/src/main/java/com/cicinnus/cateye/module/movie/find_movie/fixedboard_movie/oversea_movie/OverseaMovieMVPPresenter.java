package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaComingMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMovieMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<OverseaMovieContract.IOverseaMovieView> implements OverseaMovieContract.IOverseaMoviePresenter {

    private final OverseaMovieManager overseaMovieManager;

    public OverseaMovieMVPPresenter(Activity activity, OverseaMovieContract.IOverseaMovieView view) {
        super(activity, view);
        overseaMovieManager = new OverseaMovieManager();
    }

    @Override
    public void getOverseaMovie(final String area) {
        mView.showLoading();
        //合并两个请求
        addSubscribeUntilDestroy(Observable.merge(overseaMovieManager.getOverseaHotMovie(area),overseaMovieManager.getOverseaComingMovie(area))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        if(o instanceof OverseaHotMovieBean){
                            mView.addOverseaHotMovie(((OverseaHotMovieBean) o).getData().getHot());
                        }else if(o instanceof OverseaComingMovieBean){
                            mView.addOverseaComingMovie(((OverseaComingMovieBean) o).getData().getComing());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
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

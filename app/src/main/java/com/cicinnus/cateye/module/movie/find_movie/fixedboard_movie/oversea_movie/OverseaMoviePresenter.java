package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaComingMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;
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
        addSubscribe(Observable.merge(overseaMovieManager.getOverseaHotMoie(area),overseaMovieManager.getOverseaComingMovie(area))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError("解析出错");
                    }

                    @Override
                    public void onNext(Object o) {
                        if(o instanceof OverseaHotMovieBean){
                            mView.addOverseaHotMovie(((OverseaHotMovieBean) o).getData().getHot());
                        }else if(o instanceof OverseaComingMovieBean){
                            mView.addOverseaComingMovie(((OverseaComingMovieBean) o).getData().getComing());
                        }
                    }
                }));

    }
}

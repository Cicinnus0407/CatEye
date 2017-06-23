package com.cicinnus.cateye.module.cinema.cinema_detail;

import android.app.Activity;

import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaMovieBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.FoodsBean;
import com.cicinnus.retrofitlib.base.BaseMVPPresenter;
import com.cicinnus.retrofitlib.net.error.ExceptionHandle;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;
import com.orhanobut.logger.Logger;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by Cicinnus on 2017/6/21.
 */

public class CinemaDetailPresenter extends BaseMVPPresenter<CinemaDetailContract.ICinemaDetailView> implements CinemaDetailContract.ICinemaDetailPresenter {

    private final CinemaDetailManager cinemaDetailManager;

    public CinemaDetailPresenter(Activity activity, CinemaDetailContract.ICinemaDetailView view) {
        super(activity, view);
        cinemaDetailManager = new CinemaDetailManager();
    }

    @Override
    public void getCinema(int cinemaId) {
        mView.showLoading();
        addSubscribeUntilDestroy(Observable.mergeDelayError(cinemaDetailManager.getCinemaMovie(cinemaId),
                cinemaDetailManager.getCinemaData(cinemaId),
                cinemaDetailManager.getFoods(cinemaId))
        .compose(SchedulersCompat.applyIoSchedulers())
        .subscribe(new Consumer<Object>() {
            @Override
            public void accept(@NonNull Object o) throws Exception {
                if(o instanceof CinemaMovieBean) {
                    mView.addCinemaMovies(((CinemaMovieBean) o).getData().getMovies());
                }else if(o instanceof CinemaBean){
                    mView.addCinemaData(((CinemaBean) o).getData());
                }else if(o instanceof FoodsBean){
                    mView.addFoods(((FoodsBean) o).getData().getDealList());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Logger.e(throwable.getMessage());
                mView.showError(ExceptionHandle.handleException(throwable));
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                mView.showContent();
            }
        }));
    }
}

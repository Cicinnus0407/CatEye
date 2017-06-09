package com.cicinnus.cateye.module.movie.wait_movie;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.wait_movie.bean.ExpectMovieBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.cateye.tools.ErrorHanding;
import com.orhanobut.logger.Logger;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Cicinnus on 2017/1/25.
 */

public class WaitMovieMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<WaitMovieFragmentContract.IWaitMovieView> implements WaitMovieFragmentContract.IWaitMoviePresenter {

    private final WaitMovieManager waitMovieManager;

    public WaitMovieMVPPresenter(Activity activity, WaitMovieFragmentContract.IWaitMovieView view) {
        super(activity, view);
        waitMovieManager = new WaitMovieManager();
    }

    @Override
    public void getTrailerRecommendMovie() {
        addSubscribeUntilDestroy(waitMovieManager.getTrailerRecommendMovie()
                .subscribe(new Consumer<TrailerRecommendBean>() {
                    @Override
                    public void accept(@NonNull TrailerRecommendBean trailerRecommendBean) throws Exception {
                        mView.addTrailerRecommendMovieList(trailerRecommendBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                }));
    }

    @Override
    public void getRecentExpect(int offset, int limit) {
        mView.showLoading();
        addSubscribeUntilDestroy(waitMovieManager.getRecentExpectList(offset, limit)
                .subscribe(new Consumer<ExpectMovieBean>() {
                    @Override
                    public void accept(@NonNull ExpectMovieBean expectMovieBean) throws Exception {
                        mView.addRecentExpectMovieList(expectMovieBean.getData().getComing());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.showError(ErrorHanding.handleError(throwable));

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        mView.showContent();
                    }
                }));
    }

    @Override
    public void getWaitMovieList( int limit) {
        mView.showLoading();
        addSubscribeUntilDestroy(waitMovieManager.getWaitMovieList(limit)
                .subscribe(new Consumer<WaitMovieBean>() {
                    @Override
                    public void accept(@NonNull WaitMovieBean waitMovieBean) throws Exception {
                        mView.addWaitMovieList(waitMovieBean.getData().getComing());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.showError(ErrorHanding.handleError(throwable));
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        mView.showContent();
                    }
                }));
    }
}

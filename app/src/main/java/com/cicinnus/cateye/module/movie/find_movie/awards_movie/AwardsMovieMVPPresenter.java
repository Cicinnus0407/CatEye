package com.cicinnus.cateye.module.movie.find_movie.awards_movie;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsBean;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsMovieListBean;
import com.cicinnus.cateye.tools.ErrorHanding;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Administrator on 2017/2/6.
 */

public class AwardsMovieMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<AwardsMovieContract.IAwardsMovieView> implements AwardsMovieContract.IAwardsMoviePresenter {

    private final AwardsMovieManager awardsMovieManager;

    public AwardsMovieMVPPresenter(Activity activity, AwardsMovieContract.IAwardsMovieView view) {
        super(activity, view);
        awardsMovieManager = new AwardsMovieManager();
    }

    @Override
    public void getAwards(int festivalId) {
        mView.showLoading();
        addSubscribeUntilDestroy(awardsMovieManager.getAwards(festivalId)
                .subscribe(new Consumer<AwardsBean>() {
                    @Override
                    public void accept(@NonNull AwardsBean awardsBean) throws Exception {
                        mView.addAwardTitle(awardsBean.getData());

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
    public void getAwardsMovie(int festSessionId, int limit, int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(awardsMovieManager.getAwardsMovie(festSessionId, limit, offset)
                .subscribe(new Consumer<AwardsMovieListBean>() {
                    @Override
                    public void accept(@NonNull AwardsMovieListBean awardsMovieListBean) throws Exception {
                        mView.addAwardsMovie(awardsMovieListBean.getData());

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

    @Override
    public void getMoreAwardsMovie(int festSessionId, int limit, int offset) {
        addSubscribeUntilDestroy(awardsMovieManager.getAwardsMovie(festSessionId, limit, offset)
                .subscribe(new Consumer<AwardsMovieListBean>() {
                    @Override
                    public void accept(@NonNull AwardsMovieListBean awardsMovieListBean) throws Exception {
                        mView.addMoreAwardsMovie(awardsMovieListBean.getData());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.showError(throwable.getMessage());

                    }
                }));
    }
}

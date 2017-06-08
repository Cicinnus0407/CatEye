package com.cicinnus.cateye.module.movie.movie_detail.movie_information;

import android.app.Activity;

import com.orhanobut.logger.Logger;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Cicinnus on 2017/2/27.
 */

public class MovieInformationMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<MovieInformationContract.IMovieInformationView> implements MovieInformationContract.IMovieInformationPresenter {

    private final MovieInformationManager movieInformationManager;

    public MovieInformationMVPPresenter(Activity activity, MovieInformationContract.IMovieInformationView view) {
        super(activity, view);
        movieInformationManager = new MovieInformationManager();
    }

    @Override
    public void getMovieInformation(int movieId, int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(movieInformationManager.getMovieInformation(movieId,offset)

                .subscribe(new Consumer<MovieInformationBean>() {
                    @Override
                    public void accept(@NonNull MovieInformationBean movieInformationBean) throws Exception {
                        mView.addMovieInformation(movieInformationBean.getData().getNewsList());
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
    public void getMoreMovieInformation(int movieId, int offset) {
        addSubscribeUntilDestroy(movieInformationManager.getMovieInformation(movieId,offset)
                .subscribe(new Consumer<MovieInformationBean>() {
                    @Override
                    public void accept(@NonNull MovieInformationBean movieInformationBean) throws Exception {
                        mView.addMoreMovieInformation(movieInformationBean.getData().getNewsList());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                        mView.loadMoreError(throwable.getMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        mView.showContent();

                    }
                }));
    }
}

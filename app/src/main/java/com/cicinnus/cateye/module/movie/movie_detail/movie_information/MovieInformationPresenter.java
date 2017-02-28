package com.cicinnus.cateye.module.movie.movie_detail.movie_information;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.orhanobut.logger.Logger;

import rx.Subscriber;

/**
 * Created by Cicinnus on 2017/2/27.
 */

public class MovieInformationPresenter extends BasePresenter<MovieInformationContract.IMovieInformationView> implements MovieInformationContract.IMovieInformationPresenter {

    private final MovieInformationManager movieInformationManager;

    public MovieInformationPresenter(Activity activity, MovieInformationContract.IMovieInformationView view) {
        super(activity, view);
        movieInformationManager = new MovieInformationManager();
    }

    @Override
    public void getMovieInformation(int movieId, int offset) {
        mView.showLoading();
        addSubscribe(movieInformationManager.getMovieInformation(movieId,offset)
                .subscribe(new Subscriber<MovieInformationBean>() {
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
                    public void onNext(MovieInformationBean movieInformationBean) {
                        mView.addMovieInformation(movieInformationBean.getData().getNewsList());
                    }
                }));
    }

    @Override
    public void getMoreMovieInformation(int movieId, int offset) {
        addSubscribe(movieInformationManager.getMovieInformation(movieId,offset)
                .subscribe(new Subscriber<MovieInformationBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.getMessage());
                        mView.loadMoreError(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieInformationBean movieInformationBean) {
                        mView.addMoreMovieInformation(movieInformationBean.getData().getNewsList());
                    }
                }));
    }
}

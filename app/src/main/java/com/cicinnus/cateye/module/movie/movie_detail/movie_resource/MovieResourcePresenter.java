package com.cicinnus.cateye.module.movie.movie_detail.movie_resource;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieTechnicalsBean;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieResourcePresenter extends BasePresenter<MovieResourceContract.IMovieResourceView> implements MovieResourceContract.IMovieResourcePresenter {

    private final MovieResourceManager movieResourceManager;

    public MovieResourcePresenter(Activity activity, MovieResourceContract.IMovieResourceView view) {
        super(activity, view);
        movieResourceManager = new MovieResourceManager();
    }

    @Override
    public void getMovieTechnicals(int movieId) {
        mView.showLoading();
        addSubscribe(movieResourceManager.getMovieTechnicals(movieId)
        .subscribe(new Subscriber<MovieTechnicalsBean>() {
            @Override
            public void onCompleted() {
                mView.showContent();
            }

            @Override
            public void onError(Throwable e) {
                mView.showError(e.getMessage());
            }

            @Override
            public void onNext(MovieTechnicalsBean movieTechnicalsBean) {
                mView.addMovieTechnicals(movieTechnicalsBean.getData());
            }
        }));
    }
}

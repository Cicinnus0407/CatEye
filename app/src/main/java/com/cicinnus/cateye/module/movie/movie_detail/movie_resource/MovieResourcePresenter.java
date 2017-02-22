package com.cicinnus.cateye.module.movie.movie_detail.movie_resource;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieDialoguesBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieHighLightsBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieParentGuidancesBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieRelatedCompanies;
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

    @Override
    public void getMovieDialogues(int movieId) {
        mView.showLoading();
        addSubscribe(movieResourceManager.getMovieDialogues(movieId)
                .subscribe(new Subscriber<MovieDialoguesBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieDialoguesBean movieDialoguesBean) {
                        mView.addMovieDialogues(movieDialoguesBean.getData());
                    }
                }));
    }

    @Override
    public void getMovieRelatedCompanies(int movieId) {
        mView.showLoading();
        addSubscribe(movieResourceManager.getMovieRelatedCompanies(movieId)
                .subscribe(new Subscriber<MovieRelatedCompanies>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieRelatedCompanies movieRelatedCompanies) {
                        mView.addMovieRelatedCompanies(movieRelatedCompanies.getData());
                    }
                }));
    }

    @Override
    public void getMovieParentGuidances(final int movieId) {
        mView.showLoading();
        addSubscribe(movieResourceManager.getMovieParentGuidances(movieId)
                .subscribe(new Subscriber<MovieParentGuidancesBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieParentGuidancesBean movieParentGuidancesBean) {
                        mView.addMovieParentGuidances(movieParentGuidancesBean.getData().getGov());
                    }
                }));
    }

    @Override
    public void getMovieHighLights(int movieId) {
        mView.showLoading();
        addSubscribe(movieResourceManager.getMovieHighLights(movieId)
        .subscribe(new Subscriber<MovieHighLightsBean>() {
            @Override
            public void onCompleted() {
                mView.showContent();
            }

            @Override
            public void onError(Throwable e) {
                mView.showError(e.getMessage());
            }

            @Override
            public void onNext(MovieHighLightsBean movieHighLightsBean) {
                mView.addMovieHighLights(movieHighLightsBean.getData());
            }
        }));
    }
}

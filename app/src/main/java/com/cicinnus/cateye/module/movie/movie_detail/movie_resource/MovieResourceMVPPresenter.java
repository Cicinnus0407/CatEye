package com.cicinnus.cateye.module.movie.movie_detail.movie_resource;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieDialoguesBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieHighLightsBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieParentGuidancesBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieRelatedCompanies;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieTechnicalsBean;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieResourceMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<MovieResourceContract.IMovieResourceView> implements MovieResourceContract.IMovieResourcePresenter {

    private final MovieResourceManager movieResourceManager;

    public MovieResourceMVPPresenter(Activity activity, MovieResourceContract.IMovieResourceView view) {
        super(activity, view);
        movieResourceManager = new MovieResourceManager();
    }

    @Override
    public void getMovieTechnicals(int movieId) {
        mView.showLoading();
        addSubscribeUntilDestroy(movieResourceManager.getMovieTechnicals(movieId)
                .subscribe(new Consumer<MovieTechnicalsBean>() {
                    @Override
                    public void accept(@NonNull MovieTechnicalsBean movieTechnicalsBean) throws Exception {
                        mView.addMovieTechnicals(movieTechnicalsBean.getData());

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
    public void getMovieDialogues(int movieId) {
        mView.showLoading();
        addSubscribeUntilDestroy(movieResourceManager.getMovieDialogues(movieId)
                .subscribe(new Consumer<MovieDialoguesBean>() {
                    @Override
                    public void accept(@NonNull MovieDialoguesBean movieDialoguesBean) throws Exception {
                        mView.addMovieDialogues(movieDialoguesBean.getData());

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
    public void getMovieRelatedCompanies(int movieId) {
        mView.showLoading();
        addSubscribeUntilDestroy(movieResourceManager.getMovieRelatedCompanies(movieId)
                .subscribe(new Consumer<MovieRelatedCompanies>() {
                    @Override
                    public void accept(@NonNull MovieRelatedCompanies movieRelatedCompanies) throws Exception {
                        mView.addMovieRelatedCompanies(movieRelatedCompanies.getData());
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
    public void getMovieParentGuidances(final int movieId) {
        mView.showLoading();
        addSubscribeUntilDestroy(movieResourceManager.getMovieParentGuidances(movieId)
                .subscribe(new Consumer<MovieParentGuidancesBean>() {
                    @Override
                    public void accept(@NonNull MovieParentGuidancesBean movieParentGuidancesBean) throws Exception {
                        mView.addMovieParentGuidances(movieParentGuidancesBean.getData().getGov());

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
    public void getMovieHighLights(int movieId) {
        mView.showLoading();
        addSubscribeUntilDestroy(movieResourceManager.getMovieHighLights(movieId)
        .subscribe(new Consumer<MovieHighLightsBean>() {
            @Override
            public void accept(@NonNull MovieHighLightsBean movieHighLightsBean) throws Exception {
                mView.addMovieHighLights(movieHighLightsBean.getData());

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

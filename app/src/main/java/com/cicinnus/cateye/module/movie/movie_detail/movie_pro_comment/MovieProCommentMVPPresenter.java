package com.cicinnus.cateye.module.movie.movie_detail.movie_pro_comment;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieProCommentBean;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Cicinnus on 2017/3/13.
 */

public class MovieProCommentMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<MovieProCommentContract.IMovieProCommentView> implements MovieProCommentContract.IMovieProCommentPresenter {

    private final MovieProCommentManager movieProCommentManager;

    public MovieProCommentMVPPresenter(Activity activity, MovieProCommentContract.IMovieProCommentView view) {
        super(activity, view);
        movieProCommentManager = new MovieProCommentManager();
    }

    @Override
    public void getMovieProComment(final int movieId, int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(movieProCommentManager.getMovieProComment(movieId, offset)
                .subscribe(new Consumer<MovieProCommentBean>() {
                    @Override
                    public void accept(@NonNull MovieProCommentBean movieProCommentBean) throws Exception {
                        mView.addMovieProComment(movieProCommentBean.getData());
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
    public void getMoreMovieProComment(int movieId, int offset) {
        addSubscribeUntilDestroy(movieProCommentManager.getMovieProComment(movieId, offset)
                .subscribe(new Consumer<MovieProCommentBean>() {
                    @Override
                    public void accept(@NonNull MovieProCommentBean movieProCommentBean) throws Exception {
                        mView.addMovieProComment(movieProCommentBean.getData());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.loadMoreFail(throwable.getMessage());

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        mView.showContent();

                    }
                }));
    }
}

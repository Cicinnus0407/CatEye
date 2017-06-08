package com.cicinnus.cateye.module.movie.movie_detail.movie_long_comment;

import android.app.Activity;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Cicinnus on 2017/3/13.
 */

public class MovieLongCommentMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<MovieLongCommentContract.IMovieLongCommentView> implements MovieLongCommentContract.IMovieLongCommentPresenter {

    private final MovieLongCommentManager movieLongCommentManager;

    public MovieLongCommentMVPPresenter(Activity activity, MovieLongCommentContract.IMovieLongCommentView view) {
        super(activity, view);
        movieLongCommentManager = new MovieLongCommentManager();
    }

    @Override
    public void getMovieLongComment(int movieId, int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(movieLongCommentManager.getMovieLongComment(movieId, offset)
                .subscribe(new Consumer<MovieLongCommentBeanList>() {
                    @Override
                    public void accept(@NonNull MovieLongCommentBeanList movieLongCommentBeanList) throws Exception {
                        mView.addMovieLongComment(movieLongCommentBeanList.getData().getFilmReviews());

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
    public void getMoreMovieLongComment(int movieId, int offset) {
        addSubscribeUntilDestroy(movieLongCommentManager.getMovieLongComment(movieId, offset)
                .subscribe(new Consumer<MovieLongCommentBeanList>() {
                    @Override
                    public void accept(@NonNull MovieLongCommentBeanList movieLongCommentBeanList) throws Exception {
                        mView.addMovieLongComment(movieLongCommentBeanList.getData().getFilmReviews());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
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

package com.cicinnus.cateye.module.movie.movie_detail.movie_long_comment;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;

import rx.Subscriber;

/**
 * Created by Cicinnus on 2017/3/13.
 */

public class MovieLongCommentPresenter extends BasePresenter<MovieLongCommentContract.IMovieLongCommentView> implements MovieLongCommentContract.IMovieLongCommentPresenter {

    private final MovieLongCommentManager movieLongCommentManager;

    public MovieLongCommentPresenter(Activity activity, MovieLongCommentContract.IMovieLongCommentView view) {
        super(activity, view);
        movieLongCommentManager = new MovieLongCommentManager();
    }

    @Override
    public void getMovieLongComment(int movieId, int offset) {
        mView.showLoading();
        addSubscribe(movieLongCommentManager.getMovieLongComment(movieId, offset)
                .subscribe(new Subscriber<MovieLongCommentBeanList>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieLongCommentBeanList movieLongCommentBeanList) {
                        mView.addMovieLongComment(movieLongCommentBeanList.getData().getFilmReviews());
                    }
                }));
    }

    @Override
    public void getMoreMovieLongComment(int movieId, int offset) {
        addSubscribe(movieLongCommentManager.getMovieLongComment(movieId, offset)
                .subscribe(new Subscriber<MovieLongCommentBeanList>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadMoreError(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieLongCommentBeanList movieLongCommentBeanList) {
                        mView.addMovieLongComment(movieLongCommentBeanList.getData().getFilmReviews());
                    }
                }));
    }
}

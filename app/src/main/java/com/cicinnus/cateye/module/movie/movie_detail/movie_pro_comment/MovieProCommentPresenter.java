package com.cicinnus.cateye.module.movie.movie_detail.movie_pro_comment;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieProCommentBean;

import rx.Subscriber;

/**
 * Created by Cicinnus on 2017/3/13.
 */

public class MovieProCommentPresenter extends BasePresenter<MovieProCommentContract.IMovieProCommentView> implements MovieProCommentContract.IMovieProCommentPresenter {

    private final MovieProCommentManager movieProCommentManager;

    public MovieProCommentPresenter(Activity activity, MovieProCommentContract.IMovieProCommentView view) {
        super(activity, view);
        movieProCommentManager = new MovieProCommentManager();
    }

    @Override
    public void getMovieProComment(final int movieId, int offset) {
        mView.showLoading();
        addSubscribe(movieProCommentManager.getMovieProComment(movieId, offset)
                .subscribe(new Subscriber<MovieProCommentBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieProCommentBean movieProCommentBean) {
                        mView.addMovieProComment(movieProCommentBean.getData());
                    }
                }));
    }

    @Override
    public void getMoreMovieProComment(int movieId, int offset) {
        addSubscribe(movieProCommentManager.getMovieProComment(movieId, offset)
                .subscribe(new Subscriber<MovieProCommentBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadMoreFail(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieProCommentBean movieProCommentBean) {
                        mView.addMovieProComment(movieProCommentBean.getData());
                    }
                }));
    }
}

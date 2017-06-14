package com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment.movie_short_comment_detail;

import android.app.Activity;

import com.cicinnus.retrofitlib.base.BaseMVPPresenter;
import com.cicinnus.retrofitlib.net.error.ExceptionHandle;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class MovieShortCommentDetailPresenter extends BaseMVPPresenter<MovieShortCommentDetailContract.IMovieShortCommentDetailView> implements MovieShortCommentDetailContract.IMovieShortCommentDetailPresenter {

    private final MovieShortCommentDetailManager detailManager;

    public MovieShortCommentDetailPresenter(Activity activity, MovieShortCommentDetailContract.IMovieShortCommentDetailView view) {
        super(activity, view);
        detailManager = new MovieShortCommentDetailManager();
    }

    @Override
    public void getShortCommentList(int id, int limit, int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(detailManager.getMovieShortCommentDetail(id, limit, offset)
                .compose(SchedulersCompat.<MovieShortCommentDetailBean>applyIoSchedulers())
                .subscribe(new Consumer<MovieShortCommentDetailBean>() {
                    @Override
                    public void accept(@NonNull MovieShortCommentDetailBean movieShortCommentDetailBean) throws Exception {
                        mView.addShortCommentDetail(movieShortCommentDetailBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.showError(ExceptionHandle.handleException(throwable));
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        mView.showContent();
                    }
                }));
    }
}

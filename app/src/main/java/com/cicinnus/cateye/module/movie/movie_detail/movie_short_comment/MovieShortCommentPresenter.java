package com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieShortCommentBean;
import com.cicinnus.retrofitlib.base.BaseMVPPresenter;
import com.cicinnus.retrofitlib.net.error.ExceptionHandle;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by Cicinnus on 2017/6/12.
 */

public class MovieShortCommentPresenter extends BaseMVPPresenter<MovieShortCommentContract.IMovieShortCommentView> implements MovieShortCommentContract.IMovieShortCommentPresenter {

    private final MovieShortCommentManager movieShortCommentManager;

    public MovieShortCommentPresenter(Activity activity, MovieShortCommentContract.IMovieShortCommentView view) {
        super(activity, view);
        movieShortCommentManager = new MovieShortCommentManager();
    }

    @Override
    public void getCommentShortComment(int movieId,int tag, int limit, int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(Observable.merge(movieShortCommentManager.getMovieCommentTag(movieId),
                movieShortCommentManager.getMovieShortCommentBean(movieId, tag,limit, offset))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        if (o instanceof MovieCommentTagBean) {
                            mView.addMovieShortCommentTag(((MovieCommentTagBean) o).getData());
                        } else if (o instanceof MovieShortCommentBean) {
                            mView.addMovieShortComment(((MovieShortCommentBean) o));
                        }
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

    @Override
    public void getMoreShortComment(int movieId, int tag,int limit, int offset) {
        addSubscribeUntilDestroy(movieShortCommentManager.getMovieShortCommentBean(movieId, tag,limit, offset)
                .compose(SchedulersCompat.<MovieShortCommentBean>applyIoSchedulers())
                .subscribe(new Consumer<MovieShortCommentBean>() {
                    @Override
                    public void accept(@NonNull MovieShortCommentBean movieShortCommentBean) throws Exception {
                        mView.addMoreShortComment(movieShortCommentBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.loadMoreShotCommentFail(ExceptionHandle.handleException(throwable));
                    }
                }));
    }

}

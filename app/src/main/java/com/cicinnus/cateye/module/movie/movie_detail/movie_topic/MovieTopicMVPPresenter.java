package com.cicinnus.cateye.module.movie.movie_detail.movie_topic;

import android.app.Activity;

import com.orhanobut.logger.Logger;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Cicinnus on 2017/2/28.
 */

public class MovieTopicMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<MovieTopicContract.IMovieTopicView> implements MovieTopicContract.IMovieTopicPresenter {

    private final MovieTopicManager topicManager;

    public MovieTopicMVPPresenter(Activity activity, MovieTopicContract.IMovieTopicView view) {
        super(activity, view);
        topicManager = new MovieTopicManager();
    }

    @Override
    public void getMovieTopic(int movieId, int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(topicManager.getMovieTopicList(movieId,offset)
        .subscribe(new Consumer<MovieTopicListBean>() {
            @Override
            public void accept(@NonNull MovieTopicListBean movieTopicListBean) throws Exception {
                mView.addMovieTopic(movieTopicListBean.getData());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Logger.e(throwable.getMessage());
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
    public void getMoreTopic(int movieId, int offset) {
        addSubscribeUntilDestroy(topicManager.getMovieTopicList(movieId,offset)
                .subscribe(new Consumer<MovieTopicListBean>() {
                    @Override
                    public void accept(@NonNull MovieTopicListBean movieTopicListBean) throws Exception {
                        mView.addMoreMovieTopic(movieTopicListBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                        mView.loadMoreTopicError(throwable.getMessage());
                    }
                }));
    }
}

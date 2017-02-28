package com.cicinnus.cateye.module.movie.movie_detail.movie_topic;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.orhanobut.logger.Logger;

import rx.Subscriber;

/**
 * Created by Cicinnus on 2017/2/28.
 */

public class MovieTopicPresenter extends BasePresenter<MovieTopicContract.IMovieTopicView> implements MovieTopicContract.IMovieTopicPresenter {

    private final MovieTopicManager topicManager;

    public MovieTopicPresenter(Activity activity, MovieTopicContract.IMovieTopicView view) {
        super(activity, view);
        topicManager = new MovieTopicManager();
    }

    @Override
    public void getMovieTopic(int movieId, int offset) {
        mView.showLoading();
        addSubscribe(topicManager.getMovieTopicList(movieId,offset)
        .subscribe(new Subscriber<MovieTopicListBean>() {
            @Override
            public void onCompleted() {
                mView.showContent();
            }

            @Override
            public void onError(Throwable e) {
                Logger.e(e.getMessage());
                mView.showError(e.getMessage());
            }

            @Override
            public void onNext(MovieTopicListBean movieTopicListBean) {
                mView.addMovieTopic(movieTopicListBean.getData());
            }
        }));
    }

    @Override
    public void getMoreTopic(int movieId, int offset) {
        addSubscribe(topicManager.getMovieTopicList(movieId,offset)
                .subscribe(new Subscriber<MovieTopicListBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.getMessage());
                        mView.loadMoreTopicError(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieTopicListBean movieTopicListBean) {
                        mView.addMoreMovieTopic(movieTopicListBean.getData());
                    }
                }));
    }
}

package com.cicinnus.cateye.module.movie.movie_video.video_list;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/2/15.
 */

public class VideoListPresenter extends BasePresenter<VideoListContract.IVideoListView> implements VideoListContract.IVideoListPresenter {

    private final VideoListManager videoListManager;

    public VideoListPresenter(Activity activity, VideoListContract.IVideoListView view) {
        super(activity, view);
        videoListManager = new VideoListManager();
    }

    @Override
    public void getVideoList(int movieId, int offset) {
        mView.showLoading();
        addSubscribe(videoListManager.getVideoList(movieId, offset)
                .subscribe(new Subscriber<VideoListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(VideoListBean videoListBean) {
                        mView.addVideoList(videoListBean.getData());
                    }
                }));
    }

    @Override
    public void getVideoMovieInfo(int movieId) {
        mView.showLoading();
        addSubscribe(videoListManager.getVideoMovieInfo(movieId)
                .subscribe(new Subscriber<VideoMovieInfoBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(VideoMovieInfoBean videoMovieInfoBean) {
                        mView.addVideoMovieInfo(videoMovieInfoBean.getData());
                    }
                }));
    }
}

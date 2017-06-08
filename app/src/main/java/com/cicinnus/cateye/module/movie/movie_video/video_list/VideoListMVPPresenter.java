package com.cicinnus.cateye.module.movie.movie_video.video_list;

import android.app.Activity;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Administrator on 2017/2/15.
 */

public class VideoListMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<VideoListContract.IVideoListView> implements VideoListContract.IVideoListPresenter {

    private final VideoListManager videoListManager;

    public VideoListMVPPresenter(Activity activity, VideoListContract.IVideoListView view) {
        super(activity, view);
        videoListManager = new VideoListManager();
    }

    @Override
    public void getVideoList(int movieId, int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(videoListManager.getVideoList(movieId, offset)
                .subscribe(new Consumer<VideoListBean>() {
                    @Override
                    public void accept(@NonNull VideoListBean videoListBean) throws Exception {
                        mView.addTotalCount(videoListBean.getPaging().getTotal());
                        mView.addVideoList(videoListBean.getData());
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
    public void getVideoMovieInfo(int movieId) {
        mView.showLoading();
        addSubscribeUntilDestroy(videoListManager.getVideoMovieInfo(movieId)
                .subscribe(new Consumer<VideoMovieInfoBean>() {
                    @Override
                    public void accept(@NonNull VideoMovieInfoBean videoMovieInfoBean) throws Exception {
                        mView.addVideoMovieInfo(videoMovieInfoBean.getData());
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
    public void getMoreVideo(int movieId, int offset) {
        addSubscribeUntilDestroy(videoListManager.getVideoList(movieId, offset)
                .subscribe(new Consumer<VideoListBean>() {
                    @Override
                    public void accept(@NonNull VideoListBean videoListBean) throws Exception {
                        mView.addVideoMoreList(videoListBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.showLoadMoreError(throwable.getMessage());
                    }
                }));
    }
}

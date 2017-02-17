package com.cicinnus.cateye.module.movie.movie_video.video_comment;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/2/17.
 */

public class VideoCommentListPresenter extends BasePresenter<VideoCommentListContract.IVideoCommentListView> implements VideoCommentListContract.IVideoCommentListPresenter {

    private final VideoCommentListManager videoCommentListManager;

    public VideoCommentListPresenter(Activity activity, VideoCommentListContract.IVideoCommentListView view) {
        super(activity, view);
        videoCommentListManager = new VideoCommentListManager();
    }

    @Override
    public void getVideoCommentList(int movieId, int offset) {
        mView.showLoading();
        addSubscribe(videoCommentListManager.getVideoComment(movieId, offset)
                .subscribe(new Subscriber<VideoCommentListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(VideoCommentListBean videoCommentListBean) {
                        mView.addVideoCommentList(videoCommentListBean.getData().getComments());
                        mView.addVideoCommentCount(videoCommentListBean.getData().getTotal());
                    }
                }));
    }

    @Override
    public void getMoreVideoComment(int movieId, int offset) {
        addSubscribe(videoCommentListManager.getVideoComment(movieId, offset)
                .subscribe(new Subscriber<VideoCommentListBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadMoreError(e.getMessage());
                    }

                    @Override
                    public void onNext(VideoCommentListBean videoCommentListBean) {
                        mView.addMoreVideoComment(videoCommentListBean.getData().getComments());
                    }
                }));
    }
}

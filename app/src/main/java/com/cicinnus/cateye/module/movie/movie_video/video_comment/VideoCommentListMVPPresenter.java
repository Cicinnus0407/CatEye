package com.cicinnus.cateye.module.movie.movie_video.video_comment;

import android.app.Activity;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Administrator on 2017/2/17.
 */

public class VideoCommentListMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<VideoCommentListContract.IVideoCommentListView> implements VideoCommentListContract.IVideoCommentListPresenter {

    private final VideoCommentListManager videoCommentListManager;

    public VideoCommentListMVPPresenter(Activity activity, VideoCommentListContract.IVideoCommentListView view) {
        super(activity, view);
        videoCommentListManager = new VideoCommentListManager();
    }

    @Override
    public void getVideoCommentList(int movieId, int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(videoCommentListManager.getVideoComment(movieId, offset)
                .subscribe(new Consumer<VideoCommentListBean>() {
                    @Override
                    public void accept(@NonNull VideoCommentListBean videoCommentListBean) throws Exception {
                        mView.addVideoCommentList(videoCommentListBean.getData().getComments());
                        mView.addVideoCommentCount(videoCommentListBean.getData().getTotal());
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
    public void getMoreVideoComment(int movieId, int offset) {
        addSubscribeUntilDestroy(videoCommentListManager.getVideoComment(movieId, offset)
                .subscribe(new Consumer<VideoCommentListBean>() {
                    @Override
                    public void accept(@NonNull VideoCommentListBean videoCommentListBean) throws Exception {
                        mView.addMoreVideoComment(videoCommentListBean.getData().getComments());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.loadMoreError(throwable.getMessage());
                    }
                }));
    }
}

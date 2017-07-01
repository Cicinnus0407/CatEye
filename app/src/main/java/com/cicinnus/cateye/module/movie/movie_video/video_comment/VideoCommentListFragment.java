package com.cicinnus.cateye.module.movie.movie_video.video_comment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_video.RxBusPostBean.CommentCountPostBean;
import com.cicinnus.cateye.module.movie.movie_video.RxBusPostBean.CommentPostBean;
import com.cicinnus.cateye.view.ProgressLayout;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;

/**
 *
 */

public class VideoCommentListFragment extends com.cicinnus.retrofitlib.base.BaseMVPFragment<VideoCommentListPresenter> implements VideoCommentListContract.IVideoCommentListView {

    @BindView(R.id.rv_video_comment)
    RecyclerView rvVideoComment;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;


    private VideoCommentAdapter videoCommentAdapter;
    private int offset;


    private static final String VIDEO_ID = "video_id";
    private int mVideoId;

    public static VideoCommentListFragment newInstance(int videoId) {

        Bundle args = new Bundle();
        args.putInt(VIDEO_ID, videoId);
        VideoCommentListFragment fragment = new VideoCommentListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_comment_list;
    }

    @Override
    protected VideoCommentListPresenter getPresenter() {
        return new VideoCommentListPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        RxBus.get().register(this);
        mVideoId = getArguments().getInt(VIDEO_ID, 0);

        videoCommentAdapter = new VideoCommentAdapter();
        rvVideoComment.setLayoutManager(new LinearLayoutManager(mContext));
        rvVideoComment.setAdapter(videoCommentAdapter);


        videoCommentAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMoreVideoComment(mVideoId, offset);
            }
        },rvVideoComment);


        mPresenter.getVideoCommentList(mVideoId, offset);

    }

    @Subscribe
    public void changedCommentList(CommentPostBean postBean) {
        mVideoId = postBean.getVideoId();
        offset = 0;
        mPresenter.getVideoCommentList(mVideoId, offset);

    }

    @Override
    public void addVideoCommentList(List<VideoCommentListBean.DataBean.CommentsBean> comments) {
        offset += 10;
        videoCommentAdapter.setNewData(comments);
    }

    @Override
    public void addVideoCommentCount(int total) {
        RxBus.get().post(new CommentCountPostBean(total));
    }

    @Override
    public void addMoreVideoComment(List<VideoCommentListBean.DataBean.CommentsBean> comments) {
        if (comments.size() > 0) {
            offset+=10;
            videoCommentAdapter.addData(comments);
            videoCommentAdapter.loadMoreComplete();
        }else {
            videoCommentAdapter.loadMoreEnd();
        }
    }

    @Override
    public void loadMoreError(String message) {
        videoCommentAdapter.loadMoreFail();
    }

    @Override
    public void showLoading() {
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showContent() {
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        Logger.d(errorMsg);
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offset = 0;
                mPresenter.getVideoCommentList(mVideoId, offset);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }
}

package com.cicinnus.cateye.module.movie.movie_video.video_comment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_video.RxBusPostBean.CommentPostBean;
import com.cicinnus.cateye.view.ProgressLayout;
import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/15.
 */

public class VideoCommentListMVPFragment extends com.cicinnus.retrofitlib.base.BaseMVPFragment<VideoCommentListMVPPresenter> implements VideoCommentListContract.IVideoCommentListView {

    @BindView(R.id.rv_video_comment)
    RecyclerView rvVideoComment;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;


    private VideoCommentAdapter videoCommentAdapter;
    private int offset;


    private static final String VIDEO_ID = "video_id";
    private int mVideoId;

    public static VideoCommentListMVPFragment newInstance(int videoId) {

        Bundle args = new Bundle();
        args.putInt(VIDEO_ID, videoId);
        VideoCommentListMVPFragment fragment = new VideoCommentListMVPFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_comment_list;
    }

    @Override
    protected VideoCommentListMVPPresenter getPresenter() {
        return new VideoCommentListMVPPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
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

    //TODO 修改评论列表
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
        //TODO 获取总数
//        RxBus.get().post(new CommentCountPostBean(total));
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
    }
}

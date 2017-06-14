package com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment.movie_short_comment_detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;

import butterknife.BindView;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class MovieShortCommentDetailActivity extends BaseActivity<MovieShortCommentDetailPresenter> implements MovieShortCommentDetailContract.IMovieShortCommentDetailView {


    private static final int LIMIT = 20;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_short_comment_list)
    RecyclerView rvShortCommentList;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;

    private int offset;
    private int mId;
    private MyPullToRefreshListener pullToRefreshListener;
    private MovieShortCommentDetailAdapter shortCommentDetailAdapter;

    public static void start(Context context, int id) {
        Intent starter = new Intent(context, MovieShortCommentDetailActivity.class);
        starter.putExtra("id", id);
        context.startActivity(starter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_short_comment_detail;
    }

    @Override
    protected MovieShortCommentDetailPresenter getPresenter() {
        return new MovieShortCommentDetailPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        mId = getIntent().getIntExtra("id", 0);

        initSwipe();
        initRv();
        mPresenter.getShortCommentList(mId, LIMIT, offset);

    }



    private void initSwipe() {
        pullToRefreshListener = new MyPullToRefreshListener(mContext,swipe);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getShortCommentList(mId, LIMIT, offset);
            }
        });
        swipe.setOnPullRefreshListener(pullToRefreshListener);

    }

    private void initRv() {
        shortCommentDetailAdapter = new MovieShortCommentDetailAdapter();
        rvShortCommentList.setLayoutManager(new LinearLayoutManager(mContext));
        rvShortCommentList.setAdapter(shortCommentDetailAdapter);
    }

    @Override
    public void showLoading() {
        if (!progressLayout.isContent()) {
            progressLayout.showLoading();
        }
    }

    @Override
    public void showContent() {
        pullToRefreshListener.refreshDone();
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        pullToRefreshListener.refreshDone();
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getShortCommentList(mId, LIMIT, offset);

            }
        });
    }

    @Override
    public void addShortCommentDetail(MovieShortCommentDetailBean movieShortCommentDetailBean) {
        shortCommentDetailAdapter.setNewData(movieShortCommentDetailBean.getCmts());
    }


}

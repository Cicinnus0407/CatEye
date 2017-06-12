package com.cicinnus.cateye.module.movie.movie_detail.movie_pro_comment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieProCommentBean;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.ProgressLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 专业影评
 */

public class MovieProCommentActivity extends BaseActivity<MovieProCommentPresenter> implements MovieProCommentContract.IMovieProCommentView {


    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.iv_title_right_icon)
    ImageView ivTitleRightIcon;
    @BindView(R.id.rl_right_icon)
    RelativeLayout rlRightIcon;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.divider)
    View divider;
    @BindView(R.id.status_bar_bg)
    View statusBarBg;


    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
    @BindView(R.id.rv_pro_comment)
    RecyclerView rvProComment;

    private int movieId;
    private int offset;
    private MovieProCommentAdapter movieProCommentAdapter;
    private TextView tvMovieName;
    private TextView tvNum;
    private TextView tvScore;
    private double proScore;
    private String movieName;
    private int scrolledDistance;

    public static void start(Context context, int movieId, double proScore, String movieName) {
        Intent starter = new Intent(context, MovieProCommentActivity.class);
        starter.putExtra("movie_id", movieId);
        starter.putExtra("proScore", proScore);
        starter.putExtra("movieName", movieName);
        context.startActivity(starter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_pro_comment;
    }

    @Override
    protected MovieProCommentPresenter getPresenter() {
        return new MovieProCommentPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        initStatusBar();
        movieId = getIntent().getIntExtra("movie_id", 0);
        proScore = getIntent().getDoubleExtra("proScore", 0);
        movieName = getIntent().getStringExtra("movieName");
        tvTitle.setText(String.format("专业评分-%s", movieName));
        setupSwipe(swipe, new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                offset = 0;
                mPresenter.getMovieProComment(movieId, offset);
            }
        });
        iniRv();
        initListener();


        if (proScore != 0) {
            View header = getLayoutInflater().inflate(R.layout.layout_pro_comment_header, (ViewGroup) rvProComment.getParent(), false);
            tvScore = (TextView) header.findViewById(R.id.tv_pro_comment_score);
            tvNum = (TextView) header.findViewById(R.id.tv_pro_comment_count);
            tvMovieName = (TextView) header.findViewById(R.id.tv_pro_comment_movie);
            tvMovieName.setText(String.format("《%s》", movieName));
            tvScore.setText(String.format("%s", proScore));
            movieProCommentAdapter.addHeaderView(header);
        }

        mPresenter.getMovieProComment(movieId, offset);
    }

    private void iniRv() {
        rvProComment.setLayoutManager(new LinearLayoutManager(mContext));
        movieProCommentAdapter = new MovieProCommentAdapter();
        movieProCommentAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMoreMovieProComment(movieId, offset);
            }
        }, rvProComment);
        rvProComment.setAdapter(movieProCommentAdapter);
    }

    private void initListener() {
        final int changedHeight = UiUtils.dp2px(mContext, 180);
        rvProComment.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrolledDistance += dy;
                float scale = (float) scrolledDistance / changedHeight;
                //变化范围0-255 表示从透明到纯色背景
                float alpha = scale * 255 >= 255 ? 255 : scale * 255;

                llTitle.setBackgroundColor(Color.argb((int) alpha, 212, 62, 55));
                tvTitle.setTextColor(Color.argb((int) alpha, 255, 255, 255));
            }
        });
    }

    /**
     * 动态设置statusBarView的高度
     */
    private void initStatusBar() {
        LinearLayout.LayoutParams status_bar_params = (LinearLayout.LayoutParams) statusBarBg.getLayoutParams();
        //获取状态栏的高度
        int height = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
        status_bar_params.height = height;
        statusBarBg.setLayoutParams(status_bar_params);
        FrameLayout.LayoutParams title_params = (FrameLayout.LayoutParams) llTitle.getLayoutParams();
        //将Title布局往上移动状态栏的高度
        title_params.setMargins(0, -height, 0, 0);
        llTitle.setLayoutParams(title_params);

        FrameLayout.LayoutParams progressLayoutParams = (FrameLayout.LayoutParams) progressLayout.getLayoutParams();
        progressLayoutParams.setMargins(0, -height, 0, 0);
        progressLayout.setLayoutParams(progressLayoutParams);
    }


    @OnClick({R.id.rl_back})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
        }
    }

    @Override
    public void addMovieProComment(List<MovieProCommentBean.DataBean> movieProCommentBeanData) {
        if (movieProCommentBeanData.size() > 0) {
            offset += 10;
            movieProCommentAdapter.addData(movieProCommentBeanData);
            movieProCommentAdapter.loadMoreComplete();
        } else {
            movieProCommentAdapter.loadMoreEnd();
        }
    }

    @Override
    public void loadMoreFail(String message) {
        movieProCommentAdapter.loadMoreFail();
    }

    @Override
    public void addMovieData(MovieProCommentBean.PagingBean paging) {
        if (proScore != 0) {
            tvNum.setText(String.format("%s位评委参与评分", paging.getTotal()));
        }
    }


    @Override
    public void showLoading() {
        if (!progressLayout.isContent()) {
            progressLayout.showLoading();
        }
    }

    @Override
    public void showContent() {
        swipe.setRefreshing(false);
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        swipe.setRefreshing(false);
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getMovieProComment(movieId, offset);

            }
        });
    }
}

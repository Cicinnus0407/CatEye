package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.most_expect;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/2/4.
 */

public class MostExpectMovieActivity extends BaseActivity<MostExpectPresenter> implements MostExpectMovieContract.IRecentExpectMovieView {


    private MyPullToRefreshListener pullToRefreshListener;

    public static void start(Context context) {
        Intent starter = new Intent(context, MostExpectMovieActivity.class);
        context.startActivity(starter);
    }

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_recent_expect)
    RecyclerView rvRecentExpect;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;


    private MostExpectMovieAdapter mostExpectMovieAdapter;
    private int offset;
    private TextView tvCreateDate;
    private TextView tvContent;

    @Override
    protected int getLayout() {
        return R.layout.activity_recent_expect_movie;
    }

    @Override
    protected MostExpectPresenter getPresenter() {
        return new MostExpectPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        tvTitle.setText("最受期待榜单");
        mostExpectMovieAdapter = new MostExpectMovieAdapter();
        rvRecentExpect.setLayoutManager(new LinearLayoutManager(mContext));
        rvRecentExpect.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        rvRecentExpect.setAdapter(mostExpectMovieAdapter);

        View headerView = getLayoutInflater().inflate(R.layout.layout_fixboard_header, (ViewGroup) rvRecentExpect.getParent(), false);
        tvContent = (TextView) headerView.findViewById(R.id.tv_content);
        tvCreateDate = (TextView) headerView.findViewById(R.id.tv_createDate);
        mostExpectMovieAdapter.addHeaderView(headerView);

        mostExpectMovieAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getRecentExpectMovie(offset);
            }
        });

        pullToRefreshListener = new MyPullToRefreshListener(mContext, swipe);
        swipe.setOnPullRefreshListener(pullToRefreshListener);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                offset = 0;
                mostExpectMovieAdapter.setNewData(new ArrayList<MostExpectMovieBean.DataBean.MoviesBean>());
                mPresenter.getRecentExpectMovie(offset);
            }
        });

        mPresenter.getRecentExpectMovie(offset);

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
    public void addRecentExpectMovie(MostExpectMovieBean.DataBean data) {
        if (data.getMovies().size()>0) {
            offset += 10;
            mostExpectMovieAdapter.addData(data.getMovies());
            mostExpectMovieAdapter.loadMoreComplete();
        } else {
            mostExpectMovieAdapter.loadMoreEnd();
        }
    }

    @Override
    public void addData(String content, String date) {
        tvContent.setText(content);
        tvCreateDate.setText(date);
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
                offset = 0;
                mPresenter.getRecentExpectMovie(offset);
            }
        });
    }

}

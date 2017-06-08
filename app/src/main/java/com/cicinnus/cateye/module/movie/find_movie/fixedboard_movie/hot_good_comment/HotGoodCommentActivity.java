package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.hot_good_comment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Cicinnus on 2017/2/3.
 */

public class HotGoodCommentActivity extends BaseActivity<HotGoodCommentMVPPresenter> implements HotGoodCommentContract.IHotGoodCommentView {


    private View headerView;
    private MyPullToRefreshListener pull;

    public static void start(Context context) {
        Intent starter = new Intent(context, HotGoodCommentActivity.class);
        context.startActivity(starter);
    }

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_hot_good_comment_list)
    RecyclerView rvHotGoodCommentList;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout pullToRefresh;
    TextView tvCreateDate;
    TextView tvContent;

    private HotGoodCommentAdapter hotGoodCommentAdapter;
    private int offset;

    @Override
    protected int getLayout() {
        return R.layout.activity_hot_good_comment;
    }

    @Override
    protected void initEventAndData() {
        hotGoodCommentAdapter = new HotGoodCommentAdapter();
        rvHotGoodCommentList.setLayoutManager(new LinearLayoutManager(mContext));
        rvHotGoodCommentList.setAdapter(hotGoodCommentAdapter);
        headerView = getLayoutInflater().inflate(R.layout.layout_fixboard_header, (ViewGroup) rvHotGoodCommentList.getParent(), false);
        hotGoodCommentAdapter.addHeaderView(headerView);

        mPresenter.getHotGoodCommentList(offset);
        pull = new MyPullToRefreshListener(mContext, pullToRefresh);
        pullToRefresh.setOnPullRefreshListener(pull);
        pull.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                offset = 0;
                hotGoodCommentAdapter.setNewData(new ArrayList<HotGoodCommentBean.DataBean.MoviesBean>());
                mPresenter.getHotGoodCommentList(offset);
            }
        });
    }

    @Override
    protected HotGoodCommentMVPPresenter getPresenter() {
        return new HotGoodCommentMVPPresenter(mContext, this);
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
    public void addHotGoodCommentList(HotGoodCommentBean data) {
        hotGoodCommentAdapter.setNewData(data.getData().getMovies());
    }

    @Override
    public void addTitle(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void addListHeader(String created, String content) {

        tvCreateDate = (TextView) headerView.findViewById(R.id.tv_createDate);
        tvContent = (TextView) headerView.findViewById(R.id.tv_content);
        tvCreateDate.setText(created);
        tvContent.setText(content);
    }

    @Override
    public void showLoading() {
        if (!progressLayout.isContent()) {
            progressLayout.showLoading();
        }
    }

    @Override
    public void showContent() {
        pull.refreshDone();
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        pull.refreshDone();
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                offset = 0;
                mPresenter.getHotGoodCommentList(offset);
            }
        });
    }

}

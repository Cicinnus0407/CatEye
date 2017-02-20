package com.cicinnus.cateye.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;
import com.orhanobut.logger.Logger;

import butterknife.BindView;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public abstract class BaseRecyclerViewActivity<T extends IPresenter> extends BaseActivity implements ILoadingView {


    @BindView(R.id.rl_back)
    protected RelativeLayout rlBack;
    @BindView(R.id.tv_title)
    protected TextView tvTitle;
    @BindView(R.id.rv_base_recyclerView)
    protected RecyclerView rvBaseRecyclerView;
    @BindView(R.id.swipe)
    protected SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    protected ProgressLayout progressLayout;
    protected MyPullToRefreshListener pullToRefreshListener;

    @Override
    protected int getLayout() {
        return R.layout.activity_base_recyclerview;
    }

    @Override
    protected IPresenter getPresenter() {
        return getMPresenter();
    }

    protected abstract T getMPresenter();

    @Override
    protected void initEventAndData() {
        tvTitle.setText(getTitleText());
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        pullToRefreshListener = new MyPullToRefreshListener(mContext, swipe);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                setPullToRefresh();
            }
        });
        swipe.setOnPullRefreshListener(pullToRefreshListener);
        rvBaseRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    /**
     * 下拉刷新
     */
    protected abstract void setPullToRefresh();

    /**
     * @return 标题
     */
    protected abstract String getTitleText();

    /**
     * 失败重试
     */
    protected abstract void onErrorResetData();

    /**
     * 显示Loading
     */
    @Override
    public void showLoading() {
        if (!progressLayout.isContent()) {
            progressLayout.showLoading();
        }
    }

    /**
     * 显示内容
     */
    @Override
    public void showContent() {
        pullToRefreshListener.refreshDone();
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    /**
     * 错误点击重试
     * @param errorMsg 错误信息
     */
    @Override
    public void showError(String errorMsg) {
        Logger.e(errorMsg);
        pullToRefreshListener.refreshDone();
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onErrorResetData();
            }
        });
    }


}

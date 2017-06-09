package com.cicinnus.cateye.module.discover;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseWebViewActivity;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;
import com.cicinnus.retrofitlib.base.BaseMVPFragment;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/18.
 */

public class DiscoverFragment extends BaseMVPFragment<DiscoverPresenter> implements DiscoverContract.IDiscoverView {


    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.rv_discover)
    RecyclerView rvDiscover;
    private View headerView;
    private boolean isFirst = true;
    private MyPullToRefreshListener pullToRefreshListener;


    public static DiscoverFragment newInstance() {
        return new DiscoverFragment();
    }


    private DiscoverAdapter discoverAdapter;
    private int offset = 0;
    private int limit = 10;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    protected DiscoverPresenter getPresenter() {
        return new DiscoverPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        discoverAdapter = new DiscoverAdapter();
        rvDiscover.setLayoutManager(new LinearLayoutManager(mContext));
        rvDiscover.setAdapter(discoverAdapter);
        //RV头部栏目
        headerView = mContext.getLayoutInflater().inflate(R.layout.item_discover_header, (ViewGroup) rvDiscover.getParent(), false);
        discoverAdapter.addHeaderView(headerView);
        //下拉刷新

        pullToRefreshListener = new MyPullToRefreshListener(mContext,swipe);
        swipe.setOnPullRefreshListener(pullToRefreshListener);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                offset = 0;
                discoverAdapter.setNewData(new ArrayList<DiscoverBean.DataBean.FeedsBean>());
                mPresenter.getDiscoverData(offset, limit);
            }
        });

        discoverAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getDiscoverData(offset, limit);
            }
        },rvDiscover);

    }

    @Override
    protected void lazyLoadEveryTime() {
        if (isFirst) {
            mPresenter.getDiscoverData(offset, limit);
            mPresenter.getDiscoverHeader("7.8.0");
            isFirst = false;
        }
    }

    @Override
    public void addDiscoverData(List<DiscoverBean.DataBean.FeedsBean> feeds) {
        if (feeds.size() > 0) {
            offset += 10;
            discoverAdapter.addData(feeds);
            discoverAdapter.loadMoreComplete();
        } else {
            discoverAdapter.loadMoreEnd();
        }
    }

    @Override
    public void addDiscoverHeaderData(final List<DiscoverHeaderBean.DataBean> data) {
        ImageView[] imageViews = new ImageView[]{((ImageView) headerView.findViewById(R.id.iv_header1)),
                ((ImageView) headerView.findViewById(R.id.iv_header2)),
                ((ImageView) headerView.findViewById(R.id.iv_header3)),
                ((ImageView) headerView.findViewById(R.id.iv_header4))};
        TextView[] tv_content = new TextView[]{((TextView) headerView.findViewById(R.id.tv_header1)),
                ((TextView) headerView.findViewById(R.id.tv_header2)),
                ((TextView) headerView.findViewById(R.id.tv_header3)),
                ((TextView) headerView.findViewById(R.id.tv_header4))};
        for (int i = 0; i < data.size(); i++) {
            GlideManager.loadImage(mContext, data.get(i).getImage().getUrl(), imageViews[i]);
            tv_content[i].setText(data.get(i).getTitle());
            final int finalI = i;
            imageViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BaseWebViewActivity.start(mContext,data.get(finalI).getUrl());
                }
            });
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
        pullToRefreshListener.refreshDone();
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        Logger.e(errorMsg);
        pullToRefreshListener.refreshDone();
        discoverAdapter.loadMoreEnd();
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offset = 0;
                mPresenter.getDiscoverData(offset, limit);
                mPresenter.getDiscoverHeader("7.8.0");
                if (isFirst) {
                    isFirst = false;
                }
            }
        });
    }

}

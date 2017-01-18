package com.cicinnus.cateye.module.discover;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/18.
 */

public class DiscoverFragment extends BaseFragment<DiscoverPresenter> implements DiscoverContract.IDiscoverView, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_discover)
    RecyclerView rvDiscover;


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
        return new DiscoverPresenter(mContext,this);
    }

    @Override
    protected void initEventAndData() {
        discoverAdapter = new DiscoverAdapter();
        rvDiscover.setLayoutManager(new LinearLayoutManager(mContext));
        rvDiscover.setAdapter(discoverAdapter);
        discoverAdapter.setOnLoadMoreListener(this);
        mPresenter.getDiscoverData(offset, limit);
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
    public void showLoading() {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.getDiscoverData(offset, limit);
    }
}

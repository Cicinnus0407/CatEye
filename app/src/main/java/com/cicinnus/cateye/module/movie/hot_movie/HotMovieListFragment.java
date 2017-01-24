package com.cicinnus.cateye.module.movie.hot_movie;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Cicinnus on 2017/1/22.
 */

public class HotMovieListFragment extends BaseFragment<HotMovieListPresenter> implements HotMovieListContract.IHotMovieListView {

    private HotMovieListAdapter hotMovieListAdapter;

    public static HotMovieListFragment newInstance() {

        HotMovieListFragment fragment = new HotMovieListFragment();
        return fragment;
    }

    @BindView(R.id.swipe)
    SwipeRefreshLayout swip;
    @BindView(R.id.rv_hot_movie_list)
    RecyclerView rvHotMovieList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot_movie;
    }

    @Override
    protected HotMovieListPresenter getPresenter() {
        return new HotMovieListPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        hotMovieListAdapter = new HotMovieListAdapter();
        rvHotMovieList.setLayoutManager(new LinearLayoutManager(mContext));
        rvHotMovieList.setAdapter(hotMovieListAdapter);

        View view_search_header = mContext.getLayoutInflater().inflate(R.layout.layout_search, (ViewGroup) rvHotMovieList.getParent(), false);
        ((TextView) view_search_header.findViewById(R.id.tv_search_content)).setText("找影片、影人、影院");
        hotMovieListAdapter.addHeaderView(view_search_header);

        swip.setColorSchemeResources(R.color.colorAccent);
        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swip.setRefreshing(true);
                hotMovieListAdapter.setNewData(new ArrayList<HotMovieListBean.DataBean.HotBean>());
                mPresenter.getHotMovieList(20, 12);
            }
        });
        mPresenter.getHotMovieList(20, 12);

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void addHotMovieList(List<HotMovieListBean.DataBean.HotBean> hotList) {
        hotMovieListAdapter.setNewData(hotList);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {
        swip.setRefreshing(false);
    }

    @Override
    public void showError(String errorMsg) {
        swip.setRefreshing(false);
    }
}

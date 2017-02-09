package com.cicinnus.cateye.module.movie.hot_movie;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Cicinnus on 2017/1/22.
 */

public class HotMovieListFragment extends BaseFragment<HotMovieListPresenter> implements HotMovieListContract.IHotMovieListView {

    private HotMovieListAdapter hotMovieListAdapter;
    private int groupCount;
    private MyPullToRefreshListener pullToRefreshListener;

    public static HotMovieListFragment newInstance() {

        HotMovieListFragment fragment = new HotMovieListFragment();
        return fragment;
    }

    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swip;
    @BindView(R.id.rv_hot_movie)
    RecyclerView rvHotMovieList;

    private List<List<Integer>> mMovieIds;//存放获取更多的集合
    private int mCurrentIndex = 1;//获取更多数据的集合下标

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

        //下拉刷新
        pullToRefreshListener = new MyPullToRefreshListener(mContext,swip);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                mCurrentIndex = 1;
                mPresenter.getHotMovieList(20, 12);
            }
        });
        swip.setOnPullRefreshListener(pullToRefreshListener);

        //获取更多
        hotMovieListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (mCurrentIndex <= groupCount) {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < mMovieIds.get(mCurrentIndex).size(); i++) {
                        if (i < mMovieIds.get(mCurrentIndex).size() - 1) {
                            builder.append(mMovieIds.get(mCurrentIndex).get(i));
                            builder.append(",");
                        } else {
                            builder.append(mMovieIds.get(mCurrentIndex).get(i));
                        }
                    }
                    //ci参数默认为20，headline参数为0
                    mPresenter.getMoreHotMovieList(20, 0, builder.toString());
                } else {
                    hotMovieListAdapter.loadMoreEnd();
                }
            }
        });
        mPresenter.getHotMovieList(20, 12);

    }

    @Override
    protected void lazyLoadEveryTime() {

    }

    @Override
    public void addHotMovieList(List<HotMovieListBean.DataBean.HotBean> hotList) {
        hotMovieListAdapter.setNewData(hotList);
    }

    @Override
    public void addMovieIds(List<Integer> movieIds) {
        //获取热映更多根据Id进行获取，所以需要对movieId进行分组
        groupCount = movieIds.size() / 12;
        int leftCount = movieIds.size() % 12;
        mMovieIds = new ArrayList<>();

        //n组
        for (int i = 0; i < groupCount; i++) {
            List<Integer> integers = new ArrayList<>();
            for (int j = i * 12; j < movieIds.size(); j++) {
                integers.add(movieIds.get(j));
                mMovieIds.add(i, integers);
                if (integers.size() == 12) break;
            }
        }
        //第n+1组
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < leftCount; i++) {
            integers.add(movieIds.get((groupCount) * 12 + i));
            mMovieIds.add(groupCount, integers);
        }

    }

    @Override
    public void addMoreMovieIds(List<HotMovieListBean.DataBean.HotBean> movies) {
        hotMovieListAdapter.addData(movies);
    }

    @Override
    public void loadMoreError() {
        hotMovieListAdapter.loadMoreFail();
    }

    @Override
    public void loadMoreCompleted() {
        mCurrentIndex += 1;
        hotMovieListAdapter.loadMoreComplete();
    }

    @Override
    public void showLoading() {
        if (!progressLayout.isContent()) {
            progressLayout.showLoading();
        }
    }

    @Override
    public void showContent() {
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
        pullToRefreshListener.refreshDone();
    }

    @Override
    public void showError(String errorMsg) {
        pullToRefreshListener.refreshDone();
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getHotMovieList(20, 12);
            }
        });
    }
}

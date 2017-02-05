package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMovieFragment extends BaseFragment<OverseaMoviePresenter> implements OverseaMovieContract.IOverseaMovieView {

    private static final String AREA = "area";
    private String area;
    private MyPullToRefreshListener pullToRefreshListener;

    public static OverseaMovieFragment newInstance(String area) {

        Bundle args = new Bundle();
        args.putString(AREA, area);
        OverseaMovieFragment fragment = new OverseaMovieFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.rv_oversea_movie)
    RecyclerView rvOverseaMovie;

    private OverseaMovieAdapter overseaMovieAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_oversea_movie;
    }

    @Override
    protected OverseaMoviePresenter getPresenter() {
        return new OverseaMoviePresenter(mContext,this);
    }

    @Override
    protected void initEventAndData() {
        area = getArguments().getString(AREA);


        overseaMovieAdapter = new OverseaMovieAdapter();
        rvOverseaMovie.setLayoutManager(new LinearLayoutManager(mContext));
        rvOverseaMovie.setAdapter(overseaMovieAdapter);

        pullToRefreshListener = new MyPullToRefreshListener(mContext,swipe);
        swipe.setOnPullRefreshListener(pullToRefreshListener);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getOverseaMovie(area);
            }
        });
    }

    @Override
    protected void lazyLoadEveryTime() {
        mPresenter.getOverseaMovie(area);
    }

    @Override
    public void addOverseaMovie(List<OverseaMovieBean.DataBeanXXX.HotDataBean.DataBeanXX.HotBean> hotData) {
        overseaMovieAdapter.setNewData(hotData);
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
    }

    @Override
    public void showError(String errorMsg) {

        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getOverseaMovie(area);
            }
        });
    }
}

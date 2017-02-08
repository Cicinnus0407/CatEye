package com.cicinnus.cateye.module.movie.find_movie;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;
import com.cicinnus.cateye.module.movie.find_movie.adapter.AwardsMovieAdapter;
import com.cicinnus.cateye.module.movie.find_movie.adapter.FindMovieGridAdapter;
import com.cicinnus.cateye.module.movie.find_movie.adapter.FindMovieNationAdapter;
import com.cicinnus.cateye.module.movie.find_movie.adapter.FindMoviePeriodAdapter;
import com.cicinnus.cateye.module.movie.find_movie.adapter.FindMovieTypeAdapter;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.awards_list.AwardsListActivity;
import com.cicinnus.cateye.module.movie.find_movie.bean.AwardsMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.GridMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Cicinnus on 2017/1/22.
 */

public class FindMovieFragment extends BaseFragment<FindMoviePresenter> implements FindMovieContract.IFindMovieView {


    private MyPullToRefreshListener pullToRefreshListener;

    public static FindMovieFragment newInstance() {
        FindMovieFragment fragment = new FindMovieFragment();
        return fragment;
    }

    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.tv_search_content)
    TextView tvSearchContent;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.rv_movie_type)
    RecyclerView rvMovieType;
    @BindView(R.id.rv_movie_nation)
    RecyclerView rvMovieNation;
    @BindView(R.id.rv_movie_period)
    RecyclerView rvMoviePeriod;
    @BindView(R.id.rv_find_movie_grid)
    RecyclerView rvFindMovieGrid;//热映口碑
    @BindView(R.id.rv_movie_awards)
    RecyclerView rvMovieAwards;//获奖电影

    private FindMovieTypeAdapter findMovieTypeAdapter;
    private FindMovieNationAdapter findMovieNationAdapter;
    private FindMoviePeriodAdapter findMoviePeriodAdapter;
    private FindMovieGridAdapter findMovieGridAdapter;
    private AwardsMovieAdapter awardsMovieAdapter;

    private boolean isFirst = true;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find_movie;
    }

    @Override
    protected FindMoviePresenter getPresenter() {
        return new FindMoviePresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        tvSearchContent.setText(String.format("%s", "找影片、影人、影院"));
        initMovieTypeList();
        pullToRefreshListener = new MyPullToRefreshListener(mContext, swipe);
        swipe.setOnPullRefreshListener(pullToRefreshListener);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getMovieTypeList();
                mPresenter.getMovieGrid();
                mPresenter.getAwardsMovie();
            }
        });

    }

    @Override
    protected void lazyLoadEveryTime() {
        if (isFirst) {
            mPresenter.getMovieTypeList();
            mPresenter.getMovieGrid();
            mPresenter.getAwardsMovie();
            isFirst = false;
        }

    }

    /**
     * 初始化RecyclerView相关
     */
    private void initMovieTypeList() {
        //电影类型
        findMovieTypeAdapter = new FindMovieTypeAdapter();
        rvMovieType.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rvMovieType.setAdapter(findMovieTypeAdapter);
        View head_type = mContext.getLayoutInflater().inflate(R.layout.layout_normal_tv, (ViewGroup) rvMovieType.getParent(), false);
        ((TextView) head_type.findViewById(R.id.tv_content)).setText("类型");
        findMovieTypeAdapter.addHeaderView(head_type, 0, LinearLayout.HORIZONTAL);

        //地区
        findMovieNationAdapter = new FindMovieNationAdapter();
        rvMovieNation.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rvMovieNation.setAdapter(findMovieNationAdapter);
        View head_nation = mContext.getLayoutInflater().inflate(R.layout.layout_normal_tv, (ViewGroup) rvMovieNation.getParent(), false);
        ((TextView) head_nation.findViewById(R.id.tv_content)).setText("地区");
        findMovieNationAdapter.addHeaderView(head_nation, 0, LinearLayout.HORIZONTAL);
        //年代
        findMoviePeriodAdapter = new FindMoviePeriodAdapter();
        rvMoviePeriod.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rvMoviePeriod.setAdapter(findMoviePeriodAdapter);
        View head_period = mContext.getLayoutInflater().inflate(R.layout.layout_normal_tv, (ViewGroup) rvMoviePeriod.getParent(), false);
        ((TextView) head_period.findViewById(R.id.tv_content)).setText("年代");
        findMoviePeriodAdapter.addHeaderView(head_period, 0, LinearLayout.HORIZONTAL);

        //表格RecyclerView
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        rvFindMovieGrid.setLayoutManager(gridLayoutManager);
        findMovieGridAdapter = new FindMovieGridAdapter();
        rvFindMovieGrid.setAdapter(findMovieGridAdapter);
        rvFindMovieGrid.setNestedScrollingEnabled(false);//禁止滑动

        //获奖电影
        awardsMovieAdapter = new AwardsMovieAdapter();
        rvMovieAwards.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rvMovieAwards.setAdapter(awardsMovieAdapter);


    }

    @OnClick(R.id.tv_all_awards)
    void onClick(View view){
        AwardsListActivity.start(mContext,true);
    }


    @Override
    public void addMovieType(List<MovieTypeBean.DataBean.TagListBean> tagList) {
        findMovieTypeAdapter.setNewData(tagList);
    }

    @Override
    public void addMovieNation(List<MovieTypeBean.DataBean.TagListBean> tagList) {
        findMovieNationAdapter.setNewData(tagList);
    }

    @Override
    public void addMoviePeriod(List<MovieTypeBean.DataBean.TagListBean> tagList) {
        findMoviePeriodAdapter.setNewData(tagList);
    }

    @Override
    public void addMovieGrid(List<GridMovieBean.DataBean> data) {
        findMovieGridAdapter.setNewData(data);
    }

    @Override
    public void addAwardsMovie(List<AwardsMovieBean.DataBean> data) {
        awardsMovieAdapter.setNewData(data);
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
            public void onClick(View view) {
                mPresenter.getMovieTypeList();
                mPresenter.getMovieGrid();
            }
        });
    }
}

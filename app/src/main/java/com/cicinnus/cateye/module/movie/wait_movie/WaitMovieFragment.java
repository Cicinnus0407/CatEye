package com.cicinnus.cateye.module.movie.wait_movie;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;
import com.cicinnus.cateye.module.movie.wait_movie.adapter.RecentExpectAdapter;
import com.cicinnus.cateye.module.movie.wait_movie.adapter.TrailerRecommendAdapter;
import com.cicinnus.cateye.module.movie.wait_movie.adapter.WaitMovieAdapter;
import com.cicinnus.cateye.module.movie.wait_movie.bean.RecentExpectBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.cateye.view.FloatingItemDecoration;
import com.cicinnus.cateye.view.ProgressLayout;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Cicinnus on 2017/1/22.
 * 待映Fragment
 */

public class WaitMovieFragment extends BaseFragment<WaitMoviePresenter> implements WaitMovieFragmentContract.IWaitMovieView {


    private List<WaitMovieBean.DataBean.ComingBean> comingBeanList;

    public static WaitMovieFragment newInstance() {
        WaitMovieFragment fragment = new WaitMovieFragment();
        return fragment;
    }

    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
    @BindView(R.id.rv_wait_movie_list)
    RecyclerView rvWaitMovieList;


    private WaitMovieAdapter waitMovieAdapter;//列表adapter
    private TrailerRecommendAdapter trailerRecommendAdapter;//推荐列表adapter
    private RecentExpectAdapter recentExpectAdapter;//最近受期待
    private HashMap<Integer, String> keys;
    private WaitMovieBean.DataBean dataBean;
    private FloatingItemDecoration floatingItemDecoration;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wait_movie;
    }


    @Override
    protected WaitMoviePresenter getPresenter() {
        return new WaitMoviePresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        swipe.setColorSchemeResources(R.color.colorAccent);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getTrailerRecommendMovie();
                mPresenter.getRecentExpect(0, 50);
                mPresenter.getWaitMovieList(20, 12);
            }
        });

        waitMovieAdapter = new WaitMovieAdapter();
        rvWaitMovieList.setLayoutManager(new LinearLayoutManager(mContext));
        rvWaitMovieList.setAdapter(waitMovieAdapter);
        floatingItemDecoration = new FloatingItemDecoration(mContext);


        //预告片推荐
        View trailerRecommendView = mContext.getLayoutInflater().inflate(R.layout.layout_wait_movie_trailer_recommend, (ViewGroup) rvWaitMovieList.getParent(), false);
        RecyclerView rvTrailerRecommend = (RecyclerView) trailerRecommendView.findViewById(R.id.rv_wait_movie_trailer_recommend);
        trailerRecommendAdapter = new TrailerRecommendAdapter();
        rvTrailerRecommend.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rvTrailerRecommend.setAdapter(trailerRecommendAdapter);
        waitMovieAdapter.addHeaderView(trailerRecommendView);

        //最近受期待

        View recentExpectView = mContext.getLayoutInflater().inflate(R.layout.layout_recent_expect, (ViewGroup) rvWaitMovieList.getParent(), false);
        RecyclerView rvRecentExpect = (RecyclerView) recentExpectView.findViewById(R.id.rv_wait_movie_recent_expect);
        rvRecentExpect.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recentExpectAdapter = new RecentExpectAdapter();
        rvRecentExpect.setAdapter(recentExpectAdapter);
        waitMovieAdapter.addHeaderView(recentExpectView);

    }

    @Override
    protected void lazyLoad() {
        mPresenter.getTrailerRecommendMovie();
        mPresenter.getRecentExpect(0, 50);
        mPresenter.getWaitMovieList(20, 12);
    }

    @Override
    public void addTrailerRecommendMovieList(List<TrailerRecommendBean.DataBean> data) {
        trailerRecommendAdapter.setNewData(data);
    }

    @Override
    public void addRecentExpectMovieList(List<RecentExpectBean.DataBean.ComingBean> coming) {
        recentExpectAdapter.setNewData(coming);
    }

    @Override
    public void addWaitMovieList(final List<WaitMovieBean.DataBean.ComingBean> coming) {
        waitMovieAdapter.setNewData(coming);


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
            public void onClick(View view) {
                mPresenter.getWaitMovieList(20, 12);
            }
        });
    }
}

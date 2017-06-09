package com.cicinnus.cateye.module.movie.wait_movie;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.wait_movie.adapter.RecentExpectAdapter;
import com.cicinnus.cateye.module.movie.wait_movie.adapter.TrailerRecommendAdapter;
import com.cicinnus.cateye.module.movie.wait_movie.adapter.WaitMovieMultiAdapter;
import com.cicinnus.cateye.module.movie.wait_movie.bean.ExpectMovieBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.cateye.view.FloatingItemDecoration;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.retrofitlib.base.BaseMVPFragment;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 *
 * 待映Fragment
 */

public class WaitMovieFragment extends BaseMVPFragment<WaitMovieMVPPresenter> implements WaitMovieFragmentContract.IWaitMovieView {


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


//    private WaitMovieAdapter waitMovieAdapter;//列表adapter
    private TrailerRecommendAdapter trailerRecommendAdapter;//推荐列表adapter
    private RecentExpectAdapter recentExpectAdapter;//最近受期待
    private HashMap<Integer, String> keys;
    private WaitMovieBean.DataBean dataBean;
    private FloatingItemDecoration floatingItemDecoration;
    private WaitMovieMultiAdapter waitMovieMultiAdapter;
    private boolean isFirst = true;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wait_movie;
    }


    @Override
    protected WaitMovieMVPPresenter getPresenter() {
        return new WaitMovieMVPPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        swipe.setColorSchemeResources(R.color.colorAccent);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getTrailerRecommendMovie();
                mPresenter.getRecentExpect(0, 50);
                mPresenter.getWaitMovieList(12);
            }
        });
        waitMovieMultiAdapter = new WaitMovieMultiAdapter();
//        waitMovieAdapter = new WaitMovieAdapter();
        rvWaitMovieList.setLayoutManager(new LinearLayoutManager(mContext));
        rvWaitMovieList.setAdapter(waitMovieMultiAdapter);
        floatingItemDecoration = new FloatingItemDecoration(mContext);


        //预告片推荐
        View trailerRecommendView = mContext.getLayoutInflater().inflate(R.layout.layout_wait_movie_trailer_recommend, (ViewGroup) rvWaitMovieList.getParent(), false);
        RecyclerView rvTrailerRecommend = (RecyclerView) trailerRecommendView.findViewById(R.id.rv_wait_movie_trailer_recommend);
//        trailerRecommendAdapter = new TrailerRecommendAdapter();
        rvTrailerRecommend.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rvTrailerRecommend.setAdapter(trailerRecommendAdapter);
//        waitMovieAdapter.addHeaderView(trailerRecommendView);

        //最近受期待

        View recentExpectView = mContext.getLayoutInflater().inflate(R.layout.layout_recent_expect, (ViewGroup) rvWaitMovieList.getParent(), false);
        RecyclerView rvRecentExpect = (RecyclerView) recentExpectView.findViewById(R.id.rv_wait_movie_recent_expect);
        rvRecentExpect.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
//        recentExpectAdapter = new RecentExpectAdapter();
        rvRecentExpect.setAdapter(recentExpectAdapter);
//        waitMovieAdapter.addHeaderView(recentExpectView);

    }

    @Override
    protected void lazyLoadEveryTime() {
        if(isFirst){
            mPresenter.getTrailerRecommendMovie();
            mPresenter.getRecentExpect(0, 50);
            mPresenter.getWaitMovieList( 12);
            isFirst = false;
        }

    }

    @Override
    public void addTrailerRecommendMovieList(List<TrailerRecommendBean.DataBean> data) {
//        trailerRecommendAdapter.setNewData(data);
        waitMovieMultiAdapter.setTrailer(data);
    }

    @Override
    public void addRecentExpectMovieList(List<ExpectMovieBean.DataBean.ComingBean> coming) {
//        recentExpectAdapter.setNewData(coming);
        waitMovieMultiAdapter.setRecent(coming);
    }

    @Override
    public void addWaitMovieList(final List<WaitMovieBean.DataBean.ComingBean> coming) {


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
                mPresenter.getWaitMovieList( 12);
            }
        });
    }
}

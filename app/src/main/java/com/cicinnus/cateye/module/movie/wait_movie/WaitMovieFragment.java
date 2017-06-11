package com.cicinnus.cateye.module.movie.wait_movie;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.wait_movie.adapter.WaitMovieMultiAdapter;
import com.cicinnus.cateye.module.movie.wait_movie.bean.ExpectMovieBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.FloatingItemDecoration;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;
import com.cicinnus.retrofitlib.base.BaseMVPFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

import static com.cicinnus.cateye.R.id.swipe;

/**
 * 待映Fragment
 */

public class WaitMovieFragment extends BaseMVPFragment<WaitMovieMVPPresenter> implements WaitMovieFragmentContract.IWaitMovieView {


    private List<WaitMovieBean.DataBean.ComingBean> mCurrentData = new ArrayList<>();
    private FloatingItemDecoration floatingItemDecoration;
    private int mCurrentIndex;
    private HashMap<Integer, List<Integer>> mMovieIds;
    private int groupCount;
    private int leftCount;
    private int mIndex;

    public static WaitMovieFragment newInstance() {
        WaitMovieFragment fragment = new WaitMovieFragment();
        return fragment;
    }

    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(swipe)
    SuperSwipeRefreshLayout swip;
    @BindView(R.id.rv_wait_movie_list)
    RecyclerView rvWaitMovieList;

    private MyPullToRefreshListener pullToRefreshListener;

    //    private WaitMovieAdapter waitMovieAdapter;//列表adapter
    private HashMap<Integer, String> keys;
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

        initSwipe();
        initDecoration();
        initRv();


    }
    //下拉刷新

    private void initSwipe() {
        pullToRefreshListener = new MyPullToRefreshListener(mContext, swip);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                mCurrentIndex = 0;
                mPresenter.getWaitMovieList(12, 0, 50);
            }
        });
        swip.setOnPullRefreshListener(pullToRefreshListener);
    }

    private void initDecoration() {
        floatingItemDecoration = new FloatingItemDecoration(mContext, mContext.getResources().getColor(R.color.divider_normal), 100, 1);
        floatingItemDecoration.setmTitleHeight(UiUtils.dp2px(mContext, 27));
        floatingItemDecoration.setShowFloatingHeaderOnScrolling(true);//悬浮
        rvWaitMovieList.addItemDecoration(floatingItemDecoration);
    }

    private void initRv() {
        waitMovieMultiAdapter = new WaitMovieMultiAdapter();
        rvWaitMovieList.setLayoutManager(new LinearLayoutManager(mContext));
        rvWaitMovieList.setAdapter(waitMovieMultiAdapter);
        waitMovieMultiAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (mCurrentIndex + 1 <= groupCount) {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < mMovieIds.get(mCurrentIndex + 1).size(); i++) {
                        if (i < mMovieIds.get(mCurrentIndex + 1).size() - 1) {
                            builder.append(mMovieIds.get(mCurrentIndex + 1).get(i));
                            builder.append(",");
                        } else {
                            builder.append(mMovieIds.get(mCurrentIndex + 1).get(i));
                        }
                    }
                    mPresenter.getMoreWaitMovie(builder.toString());
                } else {
                    waitMovieMultiAdapter.loadMoreEnd();
                }
            }
        }, rvWaitMovieList);
    }

    @Override
    protected void lazyLoadEveryTime() {
        if (isFirst) {
            mPresenter.getWaitMovieList(12, 0, 50);
            isFirst = false;
        }

    }

    @Override
    public void addTrailerRecommendMovieList(List<TrailerRecommendBean.DataBean> data) {
//        trailerRecommendAdapter.setNewData(data);
        WaitMovieBean.DataBean.ComingBean bean0 = new WaitMovieBean.DataBean.ComingBean();
        bean0.setTrailerDataBeanList(data);
        mCurrentData.add(0, bean0);

    }

    @Override
    public void addRecentExpectMovieList(List<ExpectMovieBean.DataBean.ComingBean> coming) {
        WaitMovieBean.DataBean.ComingBean bean0 = new WaitMovieBean.DataBean.ComingBean();
        bean0.setRecentExpectList(coming);
        mCurrentData.add(1, bean0);
        waitMovieMultiAdapter.setNewData(mCurrentData);
        keys = new HashMap<>();
        keys.put(0, "预告片推荐");
        keys.put(1, "近期最受期待");
        keys.put(2, mCurrentData.get(2).getComingTitle());
        //
        for (int i = 2; i < mCurrentData.size(); i++) {
            if (i < mCurrentData.size() - 1) {
                //前后标题不同
                if (!mCurrentData.get(i).getComingTitle().equals(mCurrentData.get(i + 1).getComingTitle())) {
                    mIndex = i + 1;
                    keys.put(mIndex, mCurrentData.get(i + 1).getComingTitle());
                }
            }
        }
        floatingItemDecoration.setKeys(keys);
    }

    @Override
    public void addWaitMovieList(final List<WaitMovieBean.DataBean.ComingBean> coming) {
        mCurrentData.clear();
        mCurrentData.addAll(coming);
    }

    @Override
    public void addIds(List<Integer> movieIds) {
        groupCount = movieIds.size() / 12;
        leftCount = movieIds.size() % 12;
        mMovieIds = new HashMap<>();


        //n组
        for (int i = 0; i < groupCount; i++) {
            List<Integer> integers = new ArrayList<>();
            for (int j = i * 12; j < movieIds.size(); j++) {
                integers.add(movieIds.get(j));
                mMovieIds.put(i, integers);
                if (integers.size() == 12) break;
            }
        }
        //第n+1组
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < leftCount; i++) {
            integers.add(movieIds.get((groupCount) * 12 + i));
            mMovieIds.put(groupCount, integers);
        }

    }

    @Override
    public void addMoreWaitMovie(List<WaitMovieBean.DataBean.ComingBean> coming) {
        mIndex = waitMovieMultiAdapter.getData().size();
        //当上一组的最后一个和当前组的第一个不同
        if(!waitMovieMultiAdapter.getData().get(mIndex-1).getComingTitle().equals(coming.get(0).getComingTitle())){
            keys.put(mIndex,coming.get(0).getComingTitle());
        }
        for (int i = 0; i < coming.size(); i++) {
            if (i < coming.size() - 1) {
                //前后标题不同
                if (!coming.get(i).getComingTitle().equals(coming.get(i + 1).getComingTitle())) {
                    keys.put(mIndex + i + 1, coming.get(i + 1).getComingTitle());
                }
            }
        }
        mCurrentIndex += 1;
        waitMovieMultiAdapter.addData(coming);

        waitMovieMultiAdapter.loadMoreComplete();
        floatingItemDecoration.setKeys(keys);
    }

    @Override
    public void loadMoreFail() {
        waitMovieMultiAdapter.loadMoreFail();
    }

    @Override
    public void loadMoreComplete() {

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
                mPresenter.getWaitMovieList(12, 0, 50);

            }
        });
    }
}

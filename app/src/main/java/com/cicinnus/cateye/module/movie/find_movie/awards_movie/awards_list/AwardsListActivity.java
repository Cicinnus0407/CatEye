package com.cicinnus.cateye.module.movie.find_movie.awards_movie.awards_list;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/7.
 */

public class AwardsListActivity extends BaseActivity<AwardsListPresenter> implements AwardsListContract.IAwardsListView {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_awards_list)
    RecyclerView rvAwardsList;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    private AwardsListAdapter adapter;
    private MyPullToRefreshListener pullListener;


    @Override
    protected int getLayout() {
        return R.layout.activity_awards_list;
    }

    @Override
    protected void initEventAndData() {

        adapter = new AwardsListAdapter();
        rvAwardsList.setLayoutManager(new GridLayoutManager(mContext,2));
        rvAwardsList.setAdapter(adapter);

        pullListener = new MyPullToRefreshListener(mContext,swipe);
        swipe.setOnPullRefreshListener(pullListener);
        pullListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                adapter.setNewData(new ArrayList<AwardsListBean.DataBean.FestivalsBean>());
                mPresenter.getAwardsList();
            }
        });
        mPresenter.getAwardsList();
    }

    @Override
    protected AwardsListPresenter getPresenter() {
        return new AwardsListPresenter(mContext, this);
    }

    @Override
    public void addAwardsList(List<AwardsListBean.DataBean> data) {
        for (int i = 0; i < data.size(); i++) {
            adapter.addData(data.get(i).getFestivals());
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {
        pullListener.refreshDone();
    }

    @Override
    public void showError(String errorMsg) {
        pullListener.refreshDone();
    }

}

package com.cicinnus.cateye.module.movie.movie_detail.movie_topic;

import android.content.Context;
import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.base.BaseRecyclerViewActivity;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/28.
 */

public class MovieTopicActivity extends BaseRecyclerViewActivity<MovieTopicMVPPresenter> implements MovieTopicContract.IMovieTopicView {

    private MovieTopicAdapter movieTopicAdapter;
    private int mGroupId;
    private int offset;

    private static final String MOVIE_ID ="group_id";
    public static void start(Context context,int gruopId) {
        Intent starter = new Intent(context, MovieTopicActivity.class);
        starter.putExtra(MOVIE_ID,gruopId);
        context.startActivity(starter);
    }

    @Override
    protected MovieTopicMVPPresenter getMPresenter() {
        return new MovieTopicMVPPresenter(mContext,this);
    }

    @Override
    protected void initEventAndData() {
        mGroupId = getIntent().getIntExtra(MOVIE_ID,0);
        super.initEventAndData();
        movieTopicAdapter = new MovieTopicAdapter();
        rvBaseRecyclerView.setAdapter(movieTopicAdapter);
        movieTopicAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                ((MovieTopicMVPPresenter) mPresenter).getMoreTopic(mGroupId,offset);
            }
        },rvBaseRecyclerView);

        ((MovieTopicMVPPresenter) mPresenter).getMovieTopic(mGroupId,offset);
    }

    @Override
    protected void setPullToRefresh() {
        offset =0;
        ((MovieTopicMVPPresenter) mPresenter).getMovieTopic(mGroupId,offset);
    }

    @Override
    protected String getTitleText() {
        return "";
    }

    @Override
    protected void onErrorResetData() {
        offset =0;
        ((MovieTopicMVPPresenter) mPresenter).getMovieTopic(mGroupId,offset);
    }

    @Override
    public void addMovieTopic(List<MovieTopicListBean.DataBean> data) {
        offset+=10;
        movieTopicAdapter.setNewData(data);
    }

    @Override
    public void loadMoreTopicError(String message) {
        movieTopicAdapter.loadMoreFail();
    }

    @Override
    public void addMoreMovieTopic(List<MovieTopicListBean.DataBean> data) {
        if (data.size()>0) {
            offset+=10;
            movieTopicAdapter.addData(data);
            movieTopicAdapter.loadMoreComplete();
        }else {
            movieTopicAdapter.loadMoreEnd();
        }
    }
}

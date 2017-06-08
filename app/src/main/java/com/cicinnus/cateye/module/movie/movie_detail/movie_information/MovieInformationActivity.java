package com.cicinnus.cateye.module.movie.movie_detail.movie_information;

import android.content.Context;
import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.base.BaseRecyclerViewActivity;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/27.
 */

public class MovieInformationActivity extends BaseRecyclerViewActivity<MovieInformationMVPPresenter> implements MovieInformationContract.IMovieInformationView {



    private static final String TITLE = "title";
    private static final String MOVIE_ID = "movie_id";
    private String mTitle;
    private int mMovieId;
    private MovieInformationAdapter movieInformationAdapter;
    private int offset;

    public static void start(Context context,int movieId,String title) {
        Intent starter = new Intent(context, MovieInformationActivity.class);
        starter.putExtra(TITLE,title);
        starter.putExtra(MOVIE_ID,movieId);
        context.startActivity(starter);
    }


    @Override
    protected MovieInformationMVPPresenter getMPresenter() {
        return new MovieInformationMVPPresenter(mContext,this);
    }

    @Override
    protected void initEventAndData() {
        mTitle = getIntent().getStringExtra(TITLE);
        mMovieId = getIntent().getIntExtra(MOVIE_ID,0);
        super.initEventAndData();
        movieInformationAdapter = new MovieInformationAdapter();
        rvBaseRecyclerView.setAdapter(movieInformationAdapter);
        movieInformationAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                ((MovieInformationMVPPresenter) mPresenter).getMoreMovieInformation(mMovieId,offset);
            }
        },rvBaseRecyclerView);
        ((MovieInformationMVPPresenter) mPresenter).getMovieInformation(mMovieId,offset);
    }


    @Override
    protected void setPullToRefresh() {
        offset=0;
        ((MovieInformationMVPPresenter) mPresenter).getMovieInformation(mMovieId,offset);
    }

    @Override
    protected String getTitleText() {
        return mTitle;
    }

    @Override
    protected void onErrorResetData() {
        offset = 0;
        ((MovieInformationMVPPresenter) mPresenter).getMovieInformation(mMovieId,offset);
    }

    @Override
    public void addMovieInformation(List<MovieInformationBean.DataBean.NewsListBean> movieInformationBean) {
        offset+=10;
        movieInformationAdapter.setNewData(movieInformationBean);
    }

    @Override
    public void loadMoreError(String message) {
        movieInformationAdapter.loadMoreFail();
    }

    @Override
    public void addMoreMovieInformation(List<MovieInformationBean.DataBean.NewsListBean> newsList) {
        if(newsList.size()>0) {
            offset+=10;
            movieInformationAdapter.addData(newsList);
            movieInformationAdapter.loadMoreComplete();
        }else {
            movieInformationAdapter.loadMoreEnd();
        }
    }
}

package com.cicinnus.cateye.module.movie.movie_detail.movie_long_comment;

import android.content.Context;
import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.base.BaseRecyclerViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 长评列表
 */

public class MovieLongCommentActivity extends BaseRecyclerViewActivity<MovieLongCommentMVPPresenter> implements MovieLongCommentContract.IMovieLongCommentView {


    private static final String MOVIE_ID = "movie_id";
    private static final String TITLE = "title";


    private String mTitle;
    private int movieId;
    private int offset;
    private MovieLongCommentListAdapter movieLongCommentListAdapter;

    public static void start(Context context, int movieId, String title) {
        Intent starter = new Intent(context, MovieLongCommentActivity.class);
        starter.putExtra(MOVIE_ID, movieId);
        starter.putExtra(TITLE, title);
        context.startActivity(starter);
    }


    @Override
    protected void initEventAndData() {
        mTitle = getIntent().getStringExtra(TITLE);
        movieId = getIntent().getIntExtra(MOVIE_ID,0);
        super.initEventAndData();
        movieLongCommentListAdapter = new MovieLongCommentListAdapter();
        movieLongCommentListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                ((MovieLongCommentMVPPresenter) mPresenter).getMoreMovieLongComment(movieId, offset);
            }
        },rvBaseRecyclerView);
        rvBaseRecyclerView.setAdapter(movieLongCommentListAdapter);
        ((MovieLongCommentMVPPresenter) mPresenter).getMovieLongComment(movieId, offset);

    }

    @Override
    public void addMovieLongComment(List<MovieLongCommentBeanList.DataBean.FilmReviewsBean> filmReviews) {
        if (filmReviews.size() > 0) {
            offset += 10;
            movieLongCommentListAdapter.addData(filmReviews);
            movieLongCommentListAdapter.loadMoreComplete();
        } else {
            movieLongCommentListAdapter.loadMoreEnd();
        }
    }

    @Override
    public void loadMoreError(String message) {
        movieLongCommentListAdapter.loadMoreFail();
    }

    @Override
    protected MovieLongCommentMVPPresenter getMPresenter() {
        return new MovieLongCommentMVPPresenter(mContext, this);
    }

    @Override
    protected void setPullToRefresh() {
        offset = 0;
        movieLongCommentListAdapter.setNewData(new ArrayList<MovieLongCommentBeanList.DataBean.FilmReviewsBean>());
        ((MovieLongCommentMVPPresenter) mPresenter).getMovieLongComment(movieId, offset);
    }

    @Override
    protected String getTitleText() {
        return mTitle;
    }



    @Override
    protected void onErrorResetData() {
        offset = 0;
        ((MovieLongCommentMVPPresenter) mPresenter).getMovieLongComment(movieId, offset);
    }
}

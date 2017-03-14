package com.cicinnus.cateye.module.movie.movie_detail.movie_pro_comment;

import android.content.Context;
import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.base.BaseRecyclerViewActivity;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.MovieProCommentAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieProCommentBean;

import java.util.List;

/**
 * 专业影评
 */

public class MovieProCommentActivity extends BaseRecyclerViewActivity<MovieProCommentPresenter> implements MovieProCommentContract.IMovieProCommentView {


    private int movieId;
    private String title;
    private int offset;
    private MovieProCommentAdapter movieProCommentAdapter;

    public static void start(Context context,int movieId,String title) {
        Intent starter = new Intent(context, MovieProCommentActivity.class);
        starter.putExtra("movie_id",movieId);
        starter.putExtra("title",title);
        context.startActivity(starter);
    }

    @Override
    protected void initEventAndData() {
        title = getIntent().getStringExtra("title");
        movieId = getIntent().getIntExtra("movie_id",0);
        super.initEventAndData();
        movieProCommentAdapter = new MovieProCommentAdapter();
        movieProCommentAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                ((MovieProCommentPresenter) mPresenter).getMoreMovieProComment(movieId,offset);
            }
        });
        rvBaseRecyclerView.setAdapter(movieProCommentAdapter);
        ((MovieProCommentPresenter) mPresenter).getMovieProComment(movieId,offset);

    }

    @Override
    public void addMovieProComment(List<MovieProCommentBean.DataBean> movieProCommentBeanData) {
        if (movieProCommentBeanData.size()>0) {
            movieProCommentAdapter.addData(movieProCommentBeanData);
            movieProCommentAdapter.loadMoreComplete();
        }else {
            movieProCommentAdapter.loadMoreEnd();
        }
    }

    @Override
    public void loadMoreFail(String message) {
        movieProCommentAdapter.loadMoreFail();
    }

    @Override
    protected MovieProCommentPresenter getMPresenter() {
        return new MovieProCommentPresenter(mContext,this);
    }

    @Override
    protected void setPullToRefresh() {
        offset =0;
        ((MovieProCommentPresenter) mPresenter).getMovieProComment(movieId,offset);
    }

    @Override
    protected String getTitleText() {
        return title;
    }

    @Override
    protected void onErrorResetData() {
        offset =0;
        ((MovieProCommentPresenter) mPresenter).getMovieProComment(movieId,offset);
    }
}

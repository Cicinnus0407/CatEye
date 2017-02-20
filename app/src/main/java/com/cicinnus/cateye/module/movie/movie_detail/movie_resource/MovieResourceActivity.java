package com.cicinnus.cateye.module.movie.movie_detail.movie_resource;

import android.content.Context;
import android.content.Intent;

import com.cicinnus.cateye.base.BaseRecyclerViewActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieTechnicalsBean;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieResourceActivity extends BaseRecyclerViewActivity<MovieResourcePresenter> implements MovieResourceContract.IMovieResourceView {



    private static final String MOVIE_ID = "movie_id";
    public static void start(Context context,int movieId) {
        Intent starter = new Intent(context, MovieResourceActivity.class);
        starter.putExtra(MOVIE_ID,movieId);
        context.startActivity(starter);
    }

    @Override
    protected MovieResourcePresenter getMPresenter() {
        return new MovieResourcePresenter(mContext,this);
    }

    @Override
    protected void initEventAndData() {
        int movieId = getIntent().getIntExtra(MOVIE_ID,0);
        ((MovieResourcePresenter) mPresenter).getMovieTechnicals(movieId);
        super.initEventAndData();

    }

    @Override
    protected void setPullToRefresh() {

    }

    @Override
    protected String getTitleText() {
        return null;
    }

    @Override
    protected void onErrorResetData() {

    }

    @Override
    public void addMovieTechnicals(MovieTechnicalsBean.DataBean technicalsBeanData) {

    }
}

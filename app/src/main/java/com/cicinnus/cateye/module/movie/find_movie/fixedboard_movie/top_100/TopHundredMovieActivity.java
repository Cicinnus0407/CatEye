package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.top_100;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseRecyclerViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class TopHundredMovieActivity extends BaseRecyclerViewActivity<TopHundredMoviePresenter> implements TopHundredMovieContract.ITopHundredMovieView {


    public static void start(Context context) {
        Intent starter = new Intent(context, TopHundredMovieActivity.class);
        context.startActivity(starter);
    }

    private TopHundredMovieAdapter topHundredMovieAdapter;
    private int offset;
    private TextView tvCreate;
    private TextView tvContent;


    @Override
    protected TopHundredMoviePresenter getMPresenter() {
        return new TopHundredMoviePresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        topHundredMovieAdapter = new TopHundredMovieAdapter();
        rvBaseRecyclerView.setAdapter(topHundredMovieAdapter);
        View headerView = getLayoutInflater().inflate(R.layout.layout_fixboard_header, (ViewGroup) rvBaseRecyclerView.getParent(), false);
        tvContent = (TextView) headerView.findViewById(R.id.tv_content);
        tvCreate = (TextView) headerView.findViewById(R.id.tv_createDate);
        topHundredMovieAdapter.addHeaderView(headerView);
        topHundredMovieAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                ((TopHundredMoviePresenter) mPresenter).getTopHundredMovie(offset);
            }
        });
        ((TopHundredMoviePresenter) mPresenter).getTopHundredMovie(offset);

    }

    @Override
    protected void setRefresh() {
        offset = 0;
        topHundredMovieAdapter.setNewData(new ArrayList<TopHundredMovieBean.DataBean.MoviesBean>());
        ((TopHundredMoviePresenter) mPresenter).getTopHundredMovie(offset);
    }

    @Override
    protected String getTitleText() {
        return "TOP100榜单";
    }

    @Override
    protected void resetData() {
        offset = 0;
        ((TopHundredMoviePresenter) mPresenter).getTopHundredMovie(offset);

    }

    @Override
    public void addTopHundredMovie(List<TopHundredMovieBean.DataBean.MoviesBean> movies) {
        if (movies.size() > 0) {
            offset += 10;
            topHundredMovieAdapter.addData(movies);
            topHundredMovieAdapter.loadMoreComplete();
        } else {
            topHundredMovieAdapter.loadMoreEnd();
        }

    }

    @Override
    public void addContent(String created, String content) {
        tvCreate.setText(created);
        tvContent.setText(content);
    }

}

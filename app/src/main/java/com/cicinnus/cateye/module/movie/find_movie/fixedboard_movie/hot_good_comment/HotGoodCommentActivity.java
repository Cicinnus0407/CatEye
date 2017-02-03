package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.hot_good_comment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.view.ProgressLayout;

import butterknife.BindView;

/**
 * Created by Cicinnus on 2017/2/3.
 */

public class HotGoodCommentActivity extends BaseActivity<HotGoodCommentPresenter> implements HotGoodCommentContract.IHotGoodCommentView {


    public static void start(Context context) {
        Intent starter = new Intent(context, HotGoodCommentActivity.class);
        context.startActivity(starter);
    }

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_hot_good_comment_list)
    RecyclerView rvHotGoodCommentList;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    private HotGoodCommentAdapter hotGoodCommentAdapter;
    private int offset;

    @Override
    protected int getLayout() {
        return R.layout.activity_hot_good_comment;
    }

    @Override
    protected void initEventAndData() {
        hotGoodCommentAdapter = new HotGoodCommentAdapter();
        rvHotGoodCommentList.setLayoutManager(new LinearLayoutManager(mContext));
        rvHotGoodCommentList.setAdapter(hotGoodCommentAdapter);
        mPresenter.getHotGoodCommentList(offset);
    }

    @Override
    protected HotGoodCommentPresenter getPresenter() {
        return new HotGoodCommentPresenter(mContext, this);
    }

    @Override
    public void addHotGoodCommentList(HotGoodCommentBean data) {
        //TODO 头部
        if (data.getData().getMovies().size() > 0) {
            offset += 10;
            hotGoodCommentAdapter.addData(data.getData().getMovies());
            hotGoodCommentAdapter.loadMoreComplete();
        } else {
            hotGoodCommentAdapter.loadMoreEnd();
        }
    }

    @Override
    public void addTitle(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void showLoading() {
        if (!progressLayout.isContent()) {
            progressLayout.showLoading();
        }
    }

    @Override
    public void showContent() {
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                offset =0;
                mPresenter.getHotGoodCommentList(offset);
            }
        });
    }

}

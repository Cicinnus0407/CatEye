package com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.adapter.CinemaCommentAdapter;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.adapter.CinemaFeaturesAdapter;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean.CinemaCommentBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean.CinemaInfoBean;
import com.cicinnus.cateye.tools.ToastUtil;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.RatingBar;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Cicinnus on 2017/6/26.
 */

public class CinemaInfoDetailActivity extends BaseActivity<CinemaInfoPresenter> implements CinemaInfoContract.ICinemaInfoView {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_cinema_name)
    TextView tvCinemaName;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rb_score)
    RatingBar rbScore;
    @BindView(R.id.ll_cinema_feature)
    LinearLayout llCinemaFeature;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.rv_features)
    RecyclerView rvFeatures;
    @BindView(R.id.tv_user_comment)
    TextView tvUserComment;
    @BindView(R.id.rv_comment)
    RecyclerView rvComment;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;

    private int cinemaId;
    private int offset;
    private CinemaFeaturesAdapter cinemaFeaturesAdapter;
    private CinemaCommentAdapter cinemaCommentAdapter;

    public static void start(Context context, int cinemaId) {
        Intent starter = new Intent(context, CinemaInfoDetailActivity.class);
        starter.putExtra("cinemaId", cinemaId);
        context.startActivity(starter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_cinema_info;
    }

    @Override
    protected CinemaInfoPresenter getPresenter() {
        return new CinemaInfoPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        cinemaId = getIntent().getIntExtra("cinemaId", 0);
        initRv();

        mPresenter.getCinemaInfo(cinemaId);
        mPresenter.getCinemaComment(cinemaId, offset);
    }

    private void initRv() {
        cinemaFeaturesAdapter = new CinemaFeaturesAdapter();
        rvFeatures.setLayoutManager(new LinearLayoutManager(mContext));
        rvFeatures.setNestedScrollingEnabled(false);
        rvFeatures.setAdapter(cinemaFeaturesAdapter);


        cinemaCommentAdapter = new CinemaCommentAdapter();
        rvComment.setLayoutManager(new LinearLayoutManager(mContext));
        rvComment.setNestedScrollingEnabled(false);
        rvComment.setAdapter(cinemaCommentAdapter);
        cinemaCommentAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMoreCinemaComment(cinemaId, offset);
            }
        }, rvComment);
    }

    @OnClick({R.id.rl_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
        }
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
        ToastUtil.showToast(errorMsg);
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getCinemaInfo(cinemaId);
                mPresenter.getCinemaComment(cinemaId, offset);
            }
        });
    }

    @Override
    public void addCinemaInfo(CinemaInfoBean.DataBean data) {
        tvCinemaName.setText(String.format("%s", data.getNm()));
        tvAddress.setText(String.format("%s", data.getAddr()));
        float star = ((float) data.getS());
        if (data.getS() - ((float) data.getS()) > 4) {
            star = star + 0.5f;
        }
//        rbScore.setStar(star);
        tvPhone.setText(String.format("%s", data.getTel()));
        addScoresTags(data);
        cinemaFeaturesAdapter.setNewData(data.getFeatureTags());
    }

    private void addScoresTags(CinemaInfoBean.DataBean data) {

    }

    @Override
    public void addCinemaComment(CinemaCommentBean commentBean) {
        offset = 10;
        cinemaCommentAdapter.setNewData(commentBean.getCmts());
    }

    @Override
    public void addMoreCinemaComment(CinemaCommentBean commentBean) {
        if (commentBean.getCmts().size() > 0) {
            offset += 10;
            cinemaCommentAdapter.addData(commentBean.getCmts());
            cinemaCommentAdapter.loadMoreComplete();
        } else {
            cinemaCommentAdapter.loadMoreEnd();
        }
    }

    @Override
    public void addMoreCinemaCommentFail(String s) {
        ToastUtil.showToast(s);
        cinemaCommentAdapter.loadMoreFail();
    }
}

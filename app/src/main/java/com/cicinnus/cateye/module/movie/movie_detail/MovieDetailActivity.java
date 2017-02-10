package com.cicinnus.cateye.module.movie.movie_detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.tools.StringUtil;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.ProgressLayout;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/10.
 */

public class MovieDetailActivity extends BaseActivity<MovieDetailPresenter> implements MovieDetailContract.IMovieDetailView {
    @BindView(R.id.sc_movie_detail)
    NestedScrollView scMovieDetail;
    @BindView(R.id.iv_movie_img)
    ImageView ivMovieImg;
    @BindView(R.id.fl_movie_img)
    FrameLayout flMovieImg;//
    @BindView(R.id.tv_movie_name)
    TextView tvMovieName;//电影名
    @BindView(R.id.iv_win_awards)
    ImageView ivWinAwards;//是否获奖
    @BindView(R.id.tv_movie_english_name)
    TextView tvMovieEnglishName;//英文名
    @BindView(R.id.tv_movie_score)
    TextView tvMovieScore;//评分
    @BindView(R.id.tv_snum)
    TextView tvSnum;//总评价数
    @BindView(R.id.tv_movie_type)
    TextView tvMovieType;
    @BindView(R.id.tv_src_dur)
    TextView tvSrcDur;
    @BindView(R.id.tv_pubDesc)
    TextView tvPubDesc;
    @BindView(R.id.tv_movie_desc)
    TextView tvMovieDesc;
    @BindView(R.id.expand_view)
    ImageView expandView;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
//    @BindView(R.id.rl_back)
//    RelativeLayout rlBack;
//    @BindView(R.id.iv_title_right_icon)
//    ImageView ivTitleRightIcon;
//    @BindView(R.id.rl_right_icon)
//    RelativeLayout rlRightIcon;

//    @BindView(R.id.rl_title)
//    LinearLayout llTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rl_movie_info)
    RelativeLayout rlMovieInfo;
    @BindView(R.id.ll_score)
    LinearLayout ll_score;
//    @BindView(R.id.divider)
//    View divider;

    private static final String MOVIE_ID = "movie_id";
    private int movieId;

    public static void start(Context context, int movieId) {
        Intent starter = new Intent(context, MovieDetailActivity.class);
        starter.putExtra(MOVIE_ID, movieId);
        context.startActivity(starter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected void initEventAndData() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        movieId = getIntent().getIntExtra(MOVIE_ID, 0);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getMovieBasicData(movieId);
            }
        });

        initListener();

        mPresenter.getMovieBasicData(movieId);

    }

    private void initListener() {
        //234为电影信息的layout-title的高度
        final int changedHeight = UiUtils.dp2px(mContext, 234);
        scMovieDetail.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                //v.getScrollY()>需要变化的高度并且大于一定的高度时候开始渐变
                if (v.getScrollY() > changedHeight / 2 && oldScrollY <= changedHeight) {
                    float scale = (float) oldScrollY / changedHeight;
                    float alpha = scale * 255;
                    //外框颜色
                    toolbar.setBackgroundColor(Color.argb((int) alpha, 212, 62, 55));
                } else if (v.getScrollY() > changedHeight) {
//                    rlBack.setBackground(getResources().getDrawable(R.drawable.selector_ic_press));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
//                    divider.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//                    rlBack.setBackground(null);
                }
                //滑动到顶部的时候title栏透明
                if (v.getScrollY() == 0) {
                    toolbar.setBackground(null);
//                    divider.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                }

            }
        });
    }

    /**
     * 标题栏
     *
     * @param movie
     */
    private void initTitle(MovieBasicDataBean.DataBean.MovieBean movie) {
        toolbar.setTitle(movie.getNm());
//        rlBack.setBackgroundColor(Color.argb(0, 0, 0, 0));
    }

    @Override
    protected MovieDetailPresenter getPresenter() {
        return new MovieDetailPresenter(mContext, this);
    }

    @Override
    public void addMovieBasicData(MovieBasicDataBean.DataBean.MovieBean movie) {
        initTitle(movie);

        initMovieInfo(movie);
    }

    private void initMovieInfo(MovieBasicDataBean.DataBean.MovieBean movie) {
        tvMovieName.setText(movie.getNm());
        tvMovieEnglishName.setText(movie.getEnm());
        tvMovieScore.setText(String.format("%s", movie.getSc()));
        tvSnum.setText(StringUtil.changeNumToCN(movie.getSnum()));
        tvMovieType.setText(movie.getCat());
        tvSrcDur.setText(String.format("%s/%s分钟", movie.getSrc(), movie.getDur()));
        tvPubDesc.setText(movie.getPubDesc());
    }

    @Override
    public void showLoading() {
        if (!progressLayout.isContent()) {
            progressLayout.showLoading();
        }
    }

    @Override
    public void showContent() {
        swipe.setRefreshing(false);
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        swipe.setRefreshing(false);
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }
}

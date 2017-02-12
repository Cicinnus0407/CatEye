package com.cicinnus.cateye.module.movie.movie_detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.MoviePhotosAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.MovieStarListAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieMoneyBoxBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MoviePhotosBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieStarBean;
import com.cicinnus.cateye.net.SchedulersCompat;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.StringUtil;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.ExpandTextView;
import com.cicinnus.cateye.view.ProgressLayout;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

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
    @BindView(R.id.expandText_movie_Desc)
    ExpandTextView expandText_movie_Desc;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.iv_title_right_icon)
    ImageView ivTitleRightIcon;
    @BindView(R.id.rl_right_icon)
    RelativeLayout rlRightIcon;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_subTitle)
    TextView tvSubTitle;
    @BindView(R.id.rl_movie_info)
    RelativeLayout rlMovieInfo;
    @BindView(R.id.ll_score)
    LinearLayout ll_score;
    @BindView(R.id.divider)
    View divider;
    @BindView(R.id.status_bar_bg)
    View statusBarBg;
    @BindView(R.id.rv_movie_star)
    RecyclerView rvMovieStar;
    @BindView(R.id.rv_movie_photos)
    RecyclerView rvMoviePhotos;

    /***************电影音乐*****************/
    @BindView(R.id.ll_movie_music)
    LinearLayout llMovieMusic;
    @BindView(R.id.iv_movie_music)
    ImageView ivMovieMusic;
    @BindView(R.id.tv_music_name)
    TextView tvMusicName;
    @BindView(R.id.tv_music_num)
    TextView tvMusicNum;

    /*****************票房*******************/
    @BindView(R.id.tv_lastDayRank)
    TextView tvLastDayRank;
    @BindView(R.id.tv_firstWeekBox)
    TextView tvFirstWeekBox;
    @BindView(R.id.tv_sumBox)
    TextView tvSumBox;

    private static final String MOVIE_ID = "movie_id";
    private int movieId;
    private MovieStarListAdapter movieStarListAdapter;//影星和导演
    private MoviePhotosAdapter moviePhotosAdapter;//视频和照片

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
        movieId = getIntent().getIntExtra(MOVIE_ID, 0);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getMovieBasicData(movieId);
            }
        });
        initSwipe();
        initStatusBar();
        initMovieStar();
        initListener();
        mPresenter.getMovieBasicData(movieId);

    }

    /**
     * 影星列表
     */
    private void initMovieStar() {
        movieStarListAdapter = new MovieStarListAdapter();
        rvMovieStar.setAdapter(movieStarListAdapter);
        rvMovieStar.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
    }

    private void initSwipe() {
        //swipe颜色
        swipe.setColorSchemeResources(R.color.colorPrimary);
        //swipe的滑出和停止距离
        swipe.setProgressViewOffset(false, UiUtils.dp2px(mContext, 20), UiUtils.dp2px(mContext, 80));
    }

    /**
     * 动态设置statusBarView的高度
     */
    private void initStatusBar() {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) statusBarBg.getLayoutParams();
        int height = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
        params.height = height;
        statusBarBg.setLayoutParams(params);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) llTitle.getLayoutParams();
        layoutParams.setMargins(0, -height, 0, 0);
        llTitle.setLayoutParams(layoutParams);
    }

    @OnClick({R.id.rl_back})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
        }
    }


    /**
     * 监听NestedScrollView的滚动动态改变title的颜色
     */
    private void initListener() {
        //214为电影信息的layout-title-状态栏的高度
        final int changedHeight = UiUtils.dp2px(mContext, 214);

        scMovieDetail.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                float scale = (float) v.getScrollY() / changedHeight;
                //变化范围0-255 表示从透明到纯色背景
                float alpha = scale * 255 >= 255 ? 255 : scale * 255;

                llTitle.setBackgroundColor(Color.argb((int) alpha, 212, 62, 55));
                tvTitle.setTextColor(Color.argb((int) alpha, 255, 255, 255));
                tvSubTitle.setTextColor(Color.argb((int) alpha, 255, 255, 255));

            }
        });

    }


    @Override
    protected MovieDetailPresenter getPresenter() {
        return new MovieDetailPresenter(mContext, this);
    }

    @Override
    public void addMovieBasicData(MovieBasicDataBean.DataBean.MovieBean movie) {
        //标题栏
        setTitle(movie);
        //影片内容
        setMovieInfo(movie);
        //影片描述
        expandText_movie_Desc.setText(movie.getDra());
        //设置图片
        setMoviePhoto(movie);
        //设置电影音乐
        setMovieMusic(movie);

    }

    /**
     * 设置电影音乐
     * @param movie
     */
    private void setMovieMusic(MovieBasicDataBean.DataBean.MovieBean movie) {
        if (movie.getMusicNum()!=0) {
            llMovieMusic.setVisibility(View.VISIBLE);
            tvMusicName.setText(movie.getMusicName());
            tvMusicNum.setText(String.format("%s",movie.getMusicNum()));
            GlideManager.loadImage(mContext,movie.getAlbumImg(),ivMovieMusic);
        }
    }

    /**
     * 设置电影图片
     * @param movie
     */
    private void setMoviePhoto(MovieBasicDataBean.DataBean.MovieBean movie) {
        final List<MoviePhotosBean> photosBeanList = new ArrayList<>();
        MoviePhotosBean bean = new MoviePhotosBean();
        bean.setVideo(true);
        bean.setVideoImg(movie.getVideoImg());
        bean.setVideoNum(movie.getVnum());
        photosBeanList.add(bean);
        Observable.from(movie.getPhotos())
                .map(new Func1<String, MoviePhotosBean>() {
                    @Override
                    public MoviePhotosBean call(String s) {
                        MoviePhotosBean bean = new MoviePhotosBean();
                        bean.setVideo(false);
                        bean.setUrl(s);
                        return bean;
                    }
                })
                .toList()
                .compose(SchedulersCompat.<List<MoviePhotosBean>>applyIoSchedulers())
                .subscribe(new Action1<List<MoviePhotosBean>>() {
                    @Override
                    public void call(List<MoviePhotosBean> moviePhotosBeen) {
                        photosBeanList.addAll(moviePhotosBeen);
                        moviePhotosAdapter = new MoviePhotosAdapter();
                        rvMoviePhotos.setAdapter(moviePhotosAdapter);
                        rvMoviePhotos.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
                        Logger.d(photosBeanList.size());
                        moviePhotosAdapter.setNewData(photosBeanList);
                    }
                });


    }

    @Override
    public void addMovieStarList(MovieStarBean movieStarBean) {
        List<MovieStarBean.DataBean> movieStarList = new ArrayList<>();
        //只获取前两个数组,导演和演员
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < movieStarBean.getData().get(i).size(); j++) {
                movieStarList.add(movieStarBean.getData().get(i).get(j));
            }
        }
        movieStarListAdapter.setNewData(movieStarList);
    }

    @Override
    public void addMovieMoneyBox(MovieMoneyBoxBean moneyBoxBean) {
        tvLastDayRank.setText(String.format("%s",moneyBoxBean.getMbox().getLastDayRank()));
        tvSumBox.setText(String.format("%s",moneyBoxBean.getMbox().getSumBox()));
    }


    /**
     * 标题栏
     *
     * @param movie
     */
    private void setTitle(MovieBasicDataBean.DataBean.MovieBean movie) {
        tvTitle.setTextColor(mContext.getResources().getColor(android.R.color.transparent));
        tvSubTitle.setTextColor(mContext.getResources().getColor(android.R.color.transparent));
        tvTitle.setText(movie.getNm());//中文主标题
        tvSubTitle.setText(movie.getEnm());//英文副标题
    }

    /**
     * 显示电影内容
     *
     * @param movie
     */
    private void setMovieInfo(MovieBasicDataBean.DataBean.MovieBean movie) {
        tvMovieName.setText(movie.getNm());//电影名
        tvMovieEnglishName.setText(movie.getEnm());//电影英文名
        tvMovieScore.setText(String.format("%s", movie.getSc()));//评分
        tvSnum.setText(StringUtil.changeNumToCN(movie.getSnum()));//评价人数
        tvMovieType.setText(movie.getCat());//电影类型
        tvSrcDur.setText(String.format("%s/%s分钟", movie.getSrc(), movie.getDur()));//拍摄国家和时长
        tvPubDesc.setText(movie.getPubDesc());//上映日期
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
        Logger.e(errorMsg);
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

package com.cicinnus.cateye.module.movie.movie_detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.base.BaseWebViewActivity;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.MovieAwardsAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.MoviePhotosAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.MovieShortCommentAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.MovieStarListAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.MovieTipsAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.RelatedMovieAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieAwardsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieLongCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieMoneyBoxBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MoviePhotosBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieProCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieRelatedInformationBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieResourceBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieShortCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieStarBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTipsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTopicBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.RelatedMovieBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_information.MovieInformationActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_long_comment.MovieLongCommentActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_long_comment.MovieLongCommentAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.movie_pro_comment.MovieProCommentActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_pro_comment.MovieProCommentAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.MovieResourceActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.adapter.MovieResourceAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment.MovieShortCommentActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment.movie_short_comment_detail.MovieShortCommentDetailActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.MovieSoundTrackActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_topic.MovieTopicActivity;
import com.cicinnus.cateye.module.movie.movie_video.MovieVideoActivity;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;
import com.cicinnus.cateye.tools.StringUtil;
import com.cicinnus.cateye.tools.ToastUtil;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.ExpandTextView;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;
import com.cicinnus.retrofitlib.utils.BlurUtils;
import com.orhanobut.logger.Logger;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * 电影详情页
 */

public class MovieDetailActivity extends BaseActivity<MovieDetailPresenter> implements MovieDetailContract.IMovieDetailView {
    @BindView(R.id.sc_movie_detail)
    NestedScrollView scMovieDetail;
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
    @BindView(R.id.divider)
    View divider;
    @BindView(R.id.status_bar_bg)
    View statusBarBg;
    /*************
     * 电影信息
     *******************/
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
    @BindView(R.id.tv_people_judge)
    TextView tvPeopleJudge;
    @BindView(R.id.tv_snum)
    TextView tvSnum;//总评价数
    @BindView(R.id.tv_pro_judge)
    TextView tvProJudge;
    @BindView(R.id.tv_pro_score)
    TextView tvProScore;
    @BindView(R.id.tv_pro_num)
    TextView tvProNum;
    @BindView(R.id.tv_movie_type)
    TextView tvMovieType;
    @BindView(R.id.tv_src_dur)
    TextView tvSrcDur;
    @BindView(R.id.tv_pubDesc)
    TextView tvPubDesc;
    @BindView(R.id.rl_movie_info)
    RelativeLayout rlMovieInfo;
    @BindView(R.id.iv_blur_bg)
    ImageView ivBlurBg;
    /***************
     * 电影简介
     *****************/
    @BindView(R.id.expandText_movie_Desc)
    ExpandTextView expandText_movie_Desc;
    /******
     * 观影小贴士
     ***********/
    @BindView(R.id.ll_tips)
    LinearLayout llTips;
    @BindView(R.id.rv_movie_tips)
    RecyclerView rvMovieTips;
    /**************
     * 导演,演员
     *****************/
    @BindView(R.id.rv_movie_star)
    RecyclerView rvMovieStar;
    /*************
     * 视频截图,影片截图
     ***********/
    @BindView(R.id.rv_movie_photos)
    RecyclerView rvMoviePhotos;
    /***************
     * 电影音乐
     *****************/
    @BindView(R.id.ll_movie_music)
    LinearLayout llMovieMusic;
    @BindView(R.id.iv_movie_music)
    ImageView ivMovieMusic;
    @BindView(R.id.tv_music_name)
    TextView tvMusicName;
    @BindView(R.id.tv_music_num)
    TextView tvMusicNum;
    /*****************
     * 票房
     *******************/
    @BindView(R.id.rl_money_box)
    RelativeLayout rlMoneyBox;
    @BindView(R.id.ll_money_box)
    LinearLayout llMoneyBox;
    @BindView(R.id.tv_lastDayRank)
    TextView tvLastDayRank;
    @BindView(R.id.tv_firstWeekBox)
    TextView tvFirstWeekBox;
    @BindView(R.id.tv_sumBox)
    TextView tvSumBox;
    @BindView(R.id.tv_sum_box_content)
    TextView tvSumBoxContent;
    /************
     * 电影奖项
     ***********/
    @BindView(R.id.rv_movie_awards)
    RecyclerView rvMovieAwards;
    /************
     * 电影资料
     **********/
    @BindView(R.id.rv_movie_resource)
    RecyclerView rvMovieResource;
    /***
     * 专业评论
     */
    @BindView(R.id.ll_pro_comment)
    LinearLayout llProComment;
    @BindView(R.id.rv_movie_pro_comment)
    RecyclerView rvMovieProComment;
    /*************
     * 评论tag
     **********/
    @BindView(R.id.flowLayout)
    TagFlowLayout tagFlowLayout;

    /**
     * 热门短平
     */
    @BindView(R.id.rv_short_comment)
    RecyclerView rvShortComment;
    @BindView(R.id.tv_no_short_comment)
    TextView tvNoShortComment;
    @BindView(R.id.tv_short_comment)
    TextView tvShortComment;

    /*******
     * 长评
     ************/
    @BindView(R.id.rv_long_comment)
    RecyclerView rvLongComment;
    @BindView(R.id.tv_no_long_comment)
    TextView tvNoLongComment;
    @BindView(R.id.tv_long_comment)
    TextView tvLongComment;
    /********
     * 相关资讯
     *************/
    @BindView(R.id.ll_related_information)
    LinearLayout llRelatedInformation;
    @BindView(R.id.ll_related_information_content)
    LinearLayout llRelatedInformationContent;
    @BindView(R.id.ll_all_related_information)
    LinearLayout llAllRelatedInformation;
    @BindView(R.id.iv_related_information)
    ImageView ivRelatedInformation;
    @BindView(R.id.tv_related_information_title)
    TextView tvRelatedInformationTitle;
    @BindView(R.id.tv_related_information_author)
    TextView tvRelatedInformationAuthor;
    @BindView(R.id.tv_related_information_view_count)
    TextView tvRelatedInformationViewCount;
    @BindView(R.id.tv_related_information_comment_count)
    TextView tvRelatedInformationCommentCount;
    /******
     * 相关电影
     *********/
    @BindView(R.id.ll_related_movie)
    LinearLayout llRelatedMovie;
    @BindView(R.id.rv_related_movie)
    RecyclerView rvRelatedMovie;
    /********
     * 相关话题
     ************/
    @BindView(R.id.ll_related_topic)
    LinearLayout llRelatedTopic;
    @BindView(R.id.ll_all_related_topic)
    LinearLayout llALlRelatedTopic;
    @BindView(R.id.iv_related_topic)
    ImageView ivRelatedTopic;
    @BindView(R.id.tv_related_topic_title)
    TextView tvRelatedTopicTitle;
    @BindView(R.id.tv_related_topic_author)
    TextView tvRelatedTopicAuthor;
    @BindView(R.id.tv_related_topic_view_count)
    TextView tvRelatedTopicViewCount;
    @BindView(R.id.tv_related_topic_comment_count)
    TextView tvRelatedTopicCommentCount;

    private static final String MOVIE_ID = "movie_id";
    private int movieId;//电影Id
    private String mMovieName;
    private String mTitle;
    private MovieBasicDataBean.DataBean.MovieBean mMovieBean;
    private double mProScore;

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
    protected MovieDetailPresenter getPresenter() {
        return new MovieDetailPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        movieId = getIntent().getIntExtra(MOVIE_ID, 0);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getMovieData(movieId);
                mPresenter.getMovieSecondData(movieId);
                mPresenter.getMovieMoreData(movieId);

            }
        });

        initSwipe();
        initStatusBar();
        initListener();
        mPresenter.getMovieData(movieId);
        mPresenter.getMovieSecondData(movieId);
        mPresenter.getMovieMoreData(movieId);
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
        LinearLayout.LayoutParams status_bar_params = (LinearLayout.LayoutParams) statusBarBg.getLayoutParams();
        //获取状态栏的高度
        int height = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
        status_bar_params.height = height;
        statusBarBg.setLayoutParams(status_bar_params);
        FrameLayout.LayoutParams title_params = (FrameLayout.LayoutParams) llTitle.getLayoutParams();
        //将Title布局往上移动状态栏的高度
        title_params.setMargins(0, -height, 0, 0);
        llTitle.setLayoutParams(title_params);

        FrameLayout.LayoutParams progressLayoutParams = (FrameLayout.LayoutParams) progressLayout.getLayoutParams();
        progressLayoutParams.setMargins(0, -height, 0, 0);
        progressLayout.setLayoutParams(progressLayoutParams);
    }

    @OnClick({R.id.rl_back,
                R.id.tv_pro_judge})
        void onClick(View view) {
            switch (view.getId()) {
                case R.id.rl_back:
                    finish();
                    break;
                case R.id.tv_pro_judge:
                    MovieProCommentActivity.start(mContext,movieId,mProScore,mMovieName);
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
     * 观影小贴士
     *
     * @param
     */
    @Override
    public void addMovieTips(final MovieTipsBean.DataBean tips) {
        Observable.just(tips.getTips())
                .flatMap(new Function<List<MovieTipsBean.DataBean.TipsBean>, ObservableSource<MovieTipsBean.DataBean.TipsBean>>() {
                    @Override
                    public ObservableSource<MovieTipsBean.DataBean.TipsBean> apply(@NonNull List<MovieTipsBean.DataBean.TipsBean> tipsBeen) throws Exception {
                        if (tipsBeen != null && tipsBeen.size() > 0) {
                            return Observable.fromIterable(tipsBeen);
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .compose(SchedulersCompat.<MovieTipsBean.DataBean.TipsBean>applyIoSchedulers())
                .toList()
                .subscribe(new Consumer<List<MovieTipsBean.DataBean.TipsBean>>() {
                    @Override
                    public void accept(@NonNull List<MovieTipsBean.DataBean.TipsBean> tipsBeen) throws Exception {
                        MovieTipsAdapter movieTipsAdapter = new MovieTipsAdapter();
                        rvMovieTips.setLayoutManager(new LinearLayoutManager(mContext));
                        rvMovieTips.setNestedScrollingEnabled(false);
                        rvMovieTips.setAdapter(movieTipsAdapter);
                        movieTipsAdapter.setNewData(tipsBeen);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
//                        progressLayout.removeView(llTips);
                        llTips.setVisibility(View.GONE);
                    }
                });
    }

    /**
     * 设置电影音乐
     *
     * @param movie
     */
    private void setMovieMusic(final MovieBasicDataBean.DataBean.MovieBean movie) {
        if (movie.getMusicNum() != 0) {
            llMovieMusic.setVisibility(View.VISIBLE);
            tvMusicName.setText(movie.getMusicName());
            tvMusicNum.setText(String.format("%s", movie.getMusicNum()));
            GlideManager.loadImage(mContext, movie.getAlbumImg(), ivMovieMusic);
            llMovieMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MovieSoundTrackActivity.start(mContext, movie.getId());
                }
            });
        }
    }

    /**
     * 设置电影图片
     *
     * @param movie
     */
    private void setMoviePhoto(MovieBasicDataBean.DataBean.MovieBean movie) {
        final List<MoviePhotosBean> photosBeanList = new ArrayList<>();
        if (movie.getVideoImg() != null) {
            MoviePhotosBean bean = new MoviePhotosBean();
            bean.setVideo(true);
            bean.setVideoImg(movie.getVideoImg());
            bean.setMovieTitle(movie.getNm() + " " + movie.getVideoName());
            bean.setUrl(movie.getVideourl());
            bean.setMovieId(movie.getId());
            bean.setVideoNum(movie.getVnum());
            photosBeanList.add(bean);
        }

        Observable.fromIterable(movie.getPhotos())
                .map(new Function<String, MoviePhotosBean>() {
                    @Override
                    public MoviePhotosBean apply(@NonNull String s) throws Exception {
                        MoviePhotosBean bean = new MoviePhotosBean();
                        bean.setVideo(false);
                        bean.setUrl(s);
                        return bean;
                    }
                })
                .compose(SchedulersCompat.<MoviePhotosBean>applyIoSchedulers())
                .toList()
                .subscribe(new Consumer<List<MoviePhotosBean>>() {
                    @Override
                    public void accept(@NonNull List<MoviePhotosBean> moviePhotosBeen) throws Exception {
                        photosBeanList.addAll(moviePhotosBeen);
                        MoviePhotosAdapter moviePhotosAdapter = new MoviePhotosAdapter();
                        rvMoviePhotos.setAdapter(moviePhotosAdapter);
                        rvMoviePhotos.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                        moviePhotosAdapter.setNewData(photosBeanList);
                    }
                });


    }

    /**
     * 导演和演员
     *
     * @param movieStarBean
     */
    @Override
    public void addMovieStarList(MovieStarBean movieStarBean) {
        Observable.just(movieStarBean.getData())
                .flatMap(new Function<List<List<MovieStarBean.DataBean>>, Observable<List<MovieStarBean.DataBean>>>() {
                    @Override
                    public Observable<List<MovieStarBean.DataBean>> apply(List<List<MovieStarBean.DataBean>> lists) {
                        return Observable.fromIterable(lists);
                    }
                })
                //取前两组数据,如果只有1组就取1组
                .take(2)
                .flatMap(new Function<List<MovieStarBean.DataBean>, Observable<MovieStarBean.DataBean>>() {
                    @Override
                    public Observable<MovieStarBean.DataBean> apply(List<MovieStarBean.DataBean> dataBeen) {
                        return Observable.fromIterable(dataBeen);
                    }
                })
                .compose(SchedulersCompat.<MovieStarBean.DataBean>applyIoSchedulers())
                .toList()
                .subscribe(new Consumer<List<MovieStarBean.DataBean>>() {
                    @Override
                    public void accept(@NonNull List<MovieStarBean.DataBean> dataBeen) throws Exception {
                        MovieStarListAdapter movieStarListAdapter = new MovieStarListAdapter();
                        rvMovieStar.setAdapter(movieStarListAdapter);
                        rvMovieStar.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                        movieStarListAdapter.setNewData(dataBeen);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());

                    }
                });

    }

    /**
     * 票房
     *
     * @param moneyBoxBean
     */
    @Override
    public void addMovieMoneyBox(final MovieMoneyBoxBean moneyBoxBean) {
        rlMoneyBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseWebViewActivity.start(mContext, moneyBoxBean.getUrl(), mMovieName);
            }
        });
        if (moneyBoxBean.getMbox().getFirstWeekBox() == 0
                && moneyBoxBean.getMbox().getFirstWeekOverSeaBox() == 0
                && moneyBoxBean.getMbox().getLastDayRank() == 0
                && moneyBoxBean.getMbox().getSumBox() == 0
                && moneyBoxBean.getMbox().getSumOverSeaBox() == 0) {
            rlMoneyBox.setVisibility(View.GONE);
            llMoneyBox.setVisibility(View.GONE);
        }

        if (moneyBoxBean.getMbox().getFirstWeekBox() == 0) {
            tvFirstWeekBox.setTextColor(mContext.getResources().getColor(R.color.text_gray));
            tvFirstWeekBox.setText("暂无");
        } else {
            tvFirstWeekBox.setText(String.format("%s", moneyBoxBean.getMbox().getFirstWeekBox()));
        }

        tvSumBoxContent.setText(String.format("%s票房(万)", moneyBoxBean.isGlobalRelease() ? "累计" : "点映"));


        tvLastDayRank.setText(String.format("%s", moneyBoxBean.getMbox().getLastDayRank()));
        tvSumBox.setText(String.format("%s", moneyBoxBean.getMbox().getSumBox()));

    }

    /**
     * 电影奖项
     *
     * @param movieAwards
     */
    @Override
    public void addMovieAwards(List<MovieAwardsBean.DataBean> movieAwards) {
        Observable
                .fromIterable(movieAwards)
                .filter(new Predicate<MovieAwardsBean.DataBean>() {
                    @Override
                    public boolean test(@NonNull MovieAwardsBean.DataBean dataBean) throws Exception {
                        return dataBean.getItems().size() > 0;
                    }
                })
                .map(new Function<MovieAwardsBean.DataBean, String>() {
                    @Override
                    public String apply(@NonNull MovieAwardsBean.DataBean dataBean) throws Exception {
                        String awardsName = "";
                        for (int i = 0; i < dataBean.getItems().size(); i++) {
                            awardsName = dataBean.getTitle();
                            awardsName = awardsName + dataBean.getItems().get(i).getTitle();
                        }
                        return awardsName;
                    }
                })
                .compose(SchedulersCompat.<String>applyIoSchedulers())
                .toList()
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(@NonNull List<String> strings) throws Exception {
                        MovieAwardsAdapter movieAwardsAdapter = new MovieAwardsAdapter();
                        rvMovieAwards.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                        rvMovieAwards.setAdapter(movieAwardsAdapter);
                        movieAwardsAdapter.setNewData(strings);
                    }
                });

    }

    /**
     * 电影资料
     *
     * @param movieResources
     */
    @Override
    public void addMovieResource(List<MovieResourceBean.DataBean> movieResources) {
        for (int i = 0; i < movieResources.size(); i++) {
            if (movieResources.get(i).getName().equals("filmMusics")) {
                movieResources.remove(i);
            }
        }
        MovieResourceAdapter movieResourceAdapter = new MovieResourceAdapter();
        movieResourceAdapter.setMovieResourceClickListener(new MovieResourceAdapter.IMovieResourceClickListener() {
            @Override
            public void onClick(String type) {
                switch (type) {
                    case "highlights":
                        MovieResourceActivity.start(mContext, movieId, "highlights");
                        break;
                    case "technicals":
                        MovieResourceActivity.start(mContext, movieId, "technicals");
                        break;
                    case "dialogues":
                        MovieResourceActivity.start(mContext, movieId, "dialogues");
                        break;
                    case "relatedCompanies":
                        MovieResourceActivity.start(mContext, movieId, "relatedCompanies");
                        break;
                    case "parentguidances":
                        MovieResourceActivity.start(mContext, movieId, "parentguidances");
                        break;
                }
            }
        });
        rvMovieResource.setLayoutManager(new GridLayoutManager(mContext, 2));
        rvMovieResource.setAdapter(movieResourceAdapter);
        rvMovieResource.setNestedScrollingEnabled(false);
        movieResourceAdapter.setNewData(movieResources);
    }

    /**
     * 评论标签
     *
     * @param commentTags
     */
    @Override
    public void addMovieCommentTag(final List<MovieCommentTagBean.DataBean> commentTags) {
        commentTags.add(0, new MovieCommentTagBean.DataBean(0, movieId, 0, "全部"));
        final List<String> tags = new ArrayList<>();
        if (commentTags.size() > 1) {
            for (int i = 0; i < commentTags.size(); i++) {
                if (commentTags.get(i).getCount() == 0) {
                    tags.add(commentTags.get(i).getTagName());
                } else {
                    tags.add(commentTags.get(i).getTagName() + " " + commentTags.get(i).getCount());
                }
            }
        }
        tagFlowLayout.setAdapter(new TagAdapter<String>(tags) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) getLayoutInflater().inflate(R.layout.layout_flow_tv, tagFlowLayout, false);
                tv.setText(s);
                return tv;
            }

        });
        tagFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                ToastUtil.showToast(commentTags.get(position).getTag()+"");
                //                MovieShortCommentActivity.start(mContext,movieId,mMovieName,);

                return false;
            }
        });

    }


    /**
     * 短评
     *
     * @param movieShortCommentBean
     */
    @Override
    public void addMovieShortComment(final MovieShortCommentBean movieShortCommentBean) {

        if (movieShortCommentBean.getData().getHcmts().size() > 0) {
            MovieShortCommentAdapter movieShortCommentAdapter = new MovieShortCommentAdapter();
            rvShortComment.setLayoutManager(new LinearLayoutManager(mContext));
            rvShortComment.setAdapter(movieShortCommentAdapter);
            rvShortComment.setNestedScrollingEnabled(false);
            movieShortCommentAdapter.setNewData(movieShortCommentBean.getData().getHcmts().subList(0, 3));
            View footer = getLayoutInflater().inflate(R.layout.item_normal_list_footer, (ViewGroup) rvShortComment.getParent(), false);
            footer.setBackgroundResource(R.color.white);
            ((TextView) footer.findViewById(R.id.tv_footer)).setText(String.format("查看全部%s条短评论", movieShortCommentBean.getPaging().getTotal()));
            footer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MovieShortCommentActivity.start(mContext,movieId,mMovieName,0,0);
                }
            });
            movieShortCommentAdapter.addFooterView(footer);
            movieShortCommentAdapter.setOnShortCommentClickListener(new MovieShortCommentAdapter.OnShortCommentClickListener() {
                @Override
                public void onClick(int id) {
                    MovieShortCommentDetailActivity.start(mContext,id);
                }
            });
        } else {
            tvShortComment.setVisibility(View.INVISIBLE);
            tvNoShortComment.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 长评论
     *
     * @param movieLongComments
     */
    @Override
    public void addMovieLongComment(MovieLongCommentBean.DataBean movieLongComments) {
        if (movieLongComments.getFilmReviews().size() > 0) {
            MovieLongCommentAdapter movieLongCommentAdapter = new MovieLongCommentAdapter();
            rvLongComment.setLayoutManager(new LinearLayoutManager(mContext));
            rvLongComment.setAdapter(movieLongCommentAdapter);
            rvLongComment.setNestedScrollingEnabled(false);
            movieLongCommentAdapter.setNewData(movieLongComments.getFilmReviews());
            View footer = getLayoutInflater().inflate(R.layout.item_normal_list_footer, (ViewGroup) rvLongComment.getParent(), false);
            footer.setBackgroundResource(R.color.white);
            ((TextView) footer.findViewById(R.id.tv_footer)).setText(String.format("查看全部%s条长评论", movieLongComments.getTotal()));
            footer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MovieLongCommentActivity.start(mContext, movieId, mTitle);
                }
            });
            movieLongCommentAdapter.addFooterView(footer);
        } else {
            tvLongComment.setVisibility(View.INVISIBLE);
            tvNoLongComment.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 相关资讯
     *
     * @param newsListBean
     */
    @Override
    public void addMovieRelatedInformation(final List<MovieRelatedInformationBean.DataBean.NewsListBean> newsListBean) {
        if (newsListBean.size() > 0) {
            tvRelatedInformationTitle.setText(newsListBean.get(0).getTitle());
            tvRelatedInformationAuthor.setText(newsListBean.get(0).getSource());
            tvRelatedInformationViewCount.setText(String.format("%s", newsListBean.get(0).getViewCount()));
            tvRelatedInformationCommentCount.setText(String.format("%s", newsListBean.get(0).getCommentCount()));

            GlideManager.loadImage(mContext, newsListBean.get(0).getPreviewImages().get(0).getUrl(), ivRelatedInformation);

            llRelatedInformationContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BaseWebViewActivity.start(mContext, StringUtil.getRealUrl(newsListBean.get(0).getUrl()));
                }
            });
            llAllRelatedInformation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MovieInformationActivity.start(mContext, movieId, mTitle);
                }
            });
        } else {
            llRelatedInformation.setVisibility(View.GONE);

        }

    }

    /**
     * 相关电影
     *
     * @param relatedMovies
     */
    @Override
    public void addRelatedMovie(List<RelatedMovieBean.DataBean> relatedMovies) {
        if (relatedMovies.size() > 0) {
            RelatedMovieAdapter relatedMovieAdapter = new RelatedMovieAdapter();
            rvRelatedMovie.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            rvRelatedMovie.setAdapter(relatedMovieAdapter);
            relatedMovieAdapter.setNewData(relatedMovies.get(0).getItems());
        } else {
            llRelatedMovie.setVisibility(View.GONE);

        }

    }

    /**
     * 相关话题
     *
     * @param movieTopicBean
     */
    @Override
    public void addMovieTopic(final MovieTopicBean.DataBean movieTopicBean) {
        if (movieTopicBean.getTopics().size() > 0) {
            for (int i = 0; i < movieTopicBean.getTopics().size(); i++) {
                if (movieTopicBean.getTopics().get(i).getPreviews().get(0).getUrl() != null) {
                    GlideManager.loadImage(mContext, movieTopicBean.getTopics().get(i).getPreviews().get(0).getUrl(), ivRelatedTopic);
                } else {
                    ivRelatedTopic.setVisibility(View.GONE);
                }
                tvRelatedTopicTitle.setText(movieTopicBean.getTopics().get(i).getTitle());
                tvRelatedTopicAuthor.setText(movieTopicBean.getTopics().get(i).getAuthor().getNickName());
                tvRelatedTopicViewCount.setText(String.format("%s", movieTopicBean.getTopics().get(i).getViewCount()));
                tvRelatedTopicCommentCount.setText(String.format("%s", movieTopicBean.getTopics().get(i).getCommentCount()));
                final int finalI = i;
                llALlRelatedTopic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MovieTopicActivity.start(mContext, movieTopicBean.getTopics().get(finalI).getGroupId());
                    }
                });
            }
        } else {
            llRelatedTopic.setVisibility(View.GONE);

        }

    }

    /**
     * 专业影评
     *
     * @param movieProCommentBean 数据
     */
    @Override
    public void addMovieProComment(MovieProCommentBean movieProCommentBean) {
        if (movieProCommentBean.getData().size() == 0) {
            llProComment.setVisibility(View.GONE);
            return;
        }
        rvMovieProComment.setLayoutManager(new LinearLayoutManager(mContext));
        rvMovieProComment.setNestedScrollingEnabled(false);
        MovieProCommentAdapter movieProCommentAdapter = new MovieProCommentAdapter();
        rvMovieProComment.setAdapter(movieProCommentAdapter);
        View footer = getLayoutInflater().inflate(R.layout.item_normal_list_footer, (ViewGroup) rvLongComment.getParent(), false);
        footer.setBackgroundResource(R.color.white);
        ((TextView) footer.findViewById(R.id.tv_footer)).setText(String.format("查看全部%s条专业评论", movieProCommentBean.getPaging().getTotal()));
        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieProCommentActivity.start(mContext, movieId,mProScore,mMovieName);
            }
        });
        movieProCommentAdapter.addFooterView(footer);
        movieProCommentAdapter.setNewData(movieProCommentBean.getData());
        movieProCommentAdapter.setOnMovieProCommentClickListener(new MovieProCommentAdapter.OnMovieProCommentClickListener() {
            @Override
            public void onClick() {
                MovieProCommentActivity.start(mContext,movieId,mProScore,mMovieName);
            }
        });

    }


    /**
     * 标题栏
     *
     * @param movie
     */
    private void setTitle(MovieBasicDataBean.DataBean.MovieBean movie) {
        tvTitle.setTextColor(mContext.getResources().getColor(android.R.color.transparent));
        tvSubTitle.setTextColor(mContext.getResources().getColor(android.R.color.transparent));
        mTitle = movie.getNm();
        tvTitle.setText(mTitle);//中文主标题
        tvSubTitle.setText(movie.getEnm());//英文副标题
        mMovieName = movie.getNm();
    }

    /**
     * 显示电影内容
     *
     * @param movie
     */
    private void setMovieInfo(final MovieBasicDataBean.DataBean.MovieBean movie) {
        String imgUrl = ImgSizeUtil.resetPicUrl(movie.getImg(), ".webp@321w_447h_1e_1c_1l");

        GlideManager.loadImage(mContext, imgUrl, ivMovieImg);
        flMovieImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieVideoActivity.start(mContext, movie.getId(), 0, movie.getNm() + " " + movie.getVideoName(), movie.getVideourl());
            }
        });
        if (movie.getAwardUrl().equals("")) {
            ivWinAwards.setVisibility(View.GONE);
        }
        tvMovieName.setText(movie.getNm());//电影名
        tvMovieEnglishName.setText(movie.getEnm());//电影英文名
        tvMovieScore.setText(String.format("%s", movie.getSc()));//评分
        tvSnum.setText(String.format("(%s人评)", StringUtil.changeNumToCN(movie.getSnum())));//评价人数
        tvMovieType.setText(movie.getCat());//电影类型
        tvSrcDur.setText(String.format("%s%s", movie.getSrc(), movie.getDur() == 0 ? "" : "/" + movie.getDur() + "分钟"));//拍摄国家和时长
        tvPubDesc.setText(movie.getPubDesc());//上映日期
        if (movie.getSc() == 0) {
            tvSnum.setVisibility(View.GONE);
            tvPeopleJudge.setVisibility(View.GONE);
            tvMovieScore.setText(String.format("%s人想看", movie.getWish()));
        }
        //专业评分
        if (movie.getProScore()!=0) {
            tvProJudge.setVisibility(View.VISIBLE);
            tvProScore.setVisibility(View.VISIBLE);
            tvProNum.setVisibility(View.VISIBLE);
            tvProScore.setText(String.format("%s",movie.getProScore()));
            tvProNum.setText(String.format("(%s人评)",movie.getProScoreNum()));
        }
        mProScore = movie.getProScore();

        Observable
                .just(imgUrl)
                .map(new Function<String, Bitmap>() {
                    @Override
                    public Bitmap apply(String s) {
                        try {
                            URL url = new URL(s);
                            return BitmapFactory.decodeStream(url.openStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                })
                .map(new Function<Bitmap, Bitmap>() {
                    @Override
                    public Bitmap apply(Bitmap bitmap) {
                         return  BlurUtils.with(mContext)
                                .bitmap(bitmap)
                                .radius(14)
                                .blur();
                    }
                })
                .compose(SchedulersCompat.<Bitmap>applyIoSchedulers())
                .subscribe(new Consumer<Bitmap>() {
                    @Override
                    public void accept(@NonNull Bitmap bitmap) throws Exception {
                                ivBlurBg.setImageBitmap(bitmap);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
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
                mPresenter.getMovieData(movieId);
                mPresenter.getMovieMoreData(movieId);
                mPresenter.getMovieSecondData(movieId);
            }
        });
    }

    @Override
    protected void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }
}

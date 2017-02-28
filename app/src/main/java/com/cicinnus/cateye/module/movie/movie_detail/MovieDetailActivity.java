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
import com.cicinnus.cateye.module.movie.movie_detail.adapter.MovieLongCommentAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.MoviePhotosAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.MovieResourceAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.MovieStarListAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.adapter.RelatedMovieAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieAwardsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieLongCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieMoneyBoxBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MoviePhotosBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieRelatedInformationBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieResourceBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieStarBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTipsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTopicBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.RelatedMovieBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_information.MovieInformationActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.MovieResourceActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.MovieSoundTrackActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_topic.MovieTopicActivity;
import com.cicinnus.cateye.module.movie.movie_video.MovieVideoActivity;
import com.cicinnus.cateye.net.SchedulersCompat;
import com.cicinnus.cateye.tools.FastBlurUtil;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;
import com.cicinnus.cateye.tools.StringUtil;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.ExpandTextView;
import com.cicinnus.cateye.view.ProgressLayout;
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
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

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
    @BindView(R.id.ll_score)
    LinearLayout ll_score;
    /***************
     * 电影简介
     *****************/
    @BindView(R.id.expandText_movie_Desc)
    ExpandTextView expandText_movie_Desc;
    /******
     * 观影小贴士
     ***********/
    @BindView(R.id.iv_tips)
    ImageView ivTips;
    @BindView(R.id.tv_tips)
    TextView tvTips;
    @BindView(R.id.ll_tips)
    LinearLayout llTips;
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
    /*************
     * 评论tag
     **********/
    @BindView(R.id.flowLayout)
    TagFlowLayout tagFlowLayout;
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
                mPresenter.getMovieData(movieId);
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
        progressLayoutParams.setMargins(0,-height,0,0);
        progressLayout.setLayoutParams(progressLayoutParams);
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
     * 观影小贴士
     *
     * @param tips
     */
    @Override
    public void addMovieTips(final MovieTipsBean.DataBean tips) {
        Observable.just(tips.getTips())
                .flatMap(new Func1<List<MovieTipsBean.DataBean.TipsBean>, Observable<MovieTipsBean.DataBean.TipsBean>>() {
                    @Override
                    public Observable<MovieTipsBean.DataBean.TipsBean> call(List<MovieTipsBean.DataBean.TipsBean> tipsBeen) {
                        if (tipsBeen != null && tipsBeen.size() > 0) {
                            return Observable.from(tipsBeen);
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .compose(SchedulersCompat.<MovieTipsBean.DataBean.TipsBean>applyIoSchedulers())
                .subscribe(new Subscriber<MovieTipsBean.DataBean.TipsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        llTips.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(MovieTipsBean.DataBean.TipsBean tipsBean) {
                        GlideManager.loadImage(mContext, tipsBean.getTipImg(), ivTips);
                        tvTips.setText(tipsBean.getContent());
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
                    MovieSoundTrackActivity.start(mContext,movie.getId());
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
            bean.setMovieTitle(movie.getNm()+" "+movie.getVideoName());
            bean.setUrl(movie.getVideourl());
            bean.setMovieId(movie.getId());
            bean.setVideoNum(movie.getVnum());
            photosBeanList.add(bean);
        }

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
                .flatMap(new Func1<List<List<MovieStarBean.DataBean>>, Observable<List<MovieStarBean.DataBean>>>() {
                    @Override
                    public Observable<List<MovieStarBean.DataBean>> call(List<List<MovieStarBean.DataBean>> lists) {
                        return Observable.from(lists);
                    }
                })
                //取前两组数据,如果只有1组就取1组
                .limit(2)
                .flatMap(new Func1<List<MovieStarBean.DataBean>, Observable<MovieStarBean.DataBean>>() {
                    @Override
                    public Observable<MovieStarBean.DataBean> call(List<MovieStarBean.DataBean> dataBeen) {
                        return Observable.from(dataBeen);
                    }
                })
                .toList()
                .compose(SchedulersCompat.<List<MovieStarBean.DataBean>>applyIoSchedulers())
                .subscribe(new Subscriber<List<MovieStarBean.DataBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<MovieStarBean.DataBean> dataBeen) {
                        MovieStarListAdapter movieStarListAdapter = new MovieStarListAdapter();
                        rvMovieStar.setAdapter(movieStarListAdapter);
                        rvMovieStar.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                        movieStarListAdapter.setNewData(dataBeen);
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
                BaseWebViewActivity.start(mContext,moneyBoxBean.getUrl(),mMovieName);
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

        if (moneyBoxBean.isGlobalRelease()) {
            tvSumBoxContent.setText("累计票房(万)");
        } else {
            tvSumBoxContent.setText("点映票房(万)");
        }

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
                .from(movieAwards)
                .filter(new Func1<MovieAwardsBean.DataBean, Boolean>() {
                    @Override
                    public Boolean call(MovieAwardsBean.DataBean dataBean) {
                        return dataBean.getItems().size() > 0;
                    }
                })
                .map(new Func1<MovieAwardsBean.DataBean, String>() {
                    @Override
                    public String call(MovieAwardsBean.DataBean dataBean) {
                        String awardsName = "";
                        for (int i = 0; i < dataBean.getItems().size(); i++) {
                            awardsName = dataBean.getTitle();
                            awardsName = awardsName + dataBean.getItems().get(i).getTitle();
                        }
                        return awardsName;
                    }
                })
                .toList()
                .compose(SchedulersCompat.<List<String>>applyIoSchedulers())
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> strings) {
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
            if(movieResources.get(i).getName().equals("filmMusics")){
                movieResources.remove(i);
            }
        }
        MovieResourceAdapter movieResourceAdapter = new MovieResourceAdapter();
        movieResourceAdapter.setMovieResourceClickListener(new MovieResourceAdapter.IMovieResourceClickListener() {
            @Override
            public void onClick(String type) {
                switch (type){
                    case "behindScene":

                        break;
                    case "highlights":
                        MovieResourceActivity.start(mContext,movieId,"highlights");
                        break;
                    case "technicals":
                        MovieResourceActivity.start(mContext,movieId,"technicals");
                        break;
                    case "dialogues":
                        MovieResourceActivity.start(mContext,movieId,"dialogues");
                        break;
                    case "relatedCompanies":
                        MovieResourceActivity.start(mContext,movieId,"relatedCompanies");
                        break;
                    case "parentguidances":
                        MovieResourceActivity.start(mContext,movieId,"parentguidances");
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
    public void addMovieCommentTag(List<MovieCommentTagBean.DataBean> commentTags) {
        commentTags.add(0, new MovieCommentTagBean.DataBean(0, movieId, 0, "全部"));
        Observable
                .just(commentTags)
                .flatMap(new Func1<List<MovieCommentTagBean.DataBean>, Observable<MovieCommentTagBean.DataBean>>() {
                    @Override
                    public Observable<MovieCommentTagBean.DataBean> call(List<MovieCommentTagBean.DataBean> dataBeen) {
                        if (dataBeen.size() > 1) {
                            return Observable.from(dataBeen);
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .map(new Func1<MovieCommentTagBean.DataBean, String>() {
                    @Override
                    public String call(MovieCommentTagBean.DataBean dataBean) {
                        if (dataBean.getCount() == 0) {
                            return dataBean.getTagName();
                        } else {
                            return dataBean.getTagName() + " " + dataBean.getCount();
                        }
                    }
                })
                .toList()
                .compose(SchedulersCompat.<List<String>>applyIoSchedulers())
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> strings) {
                        tagFlowLayout.setAdapter(new TagAdapter<String>(strings) {
                            @Override
                            public View getView(FlowLayout parent, int position, String s) {
                                TextView tv = (TextView) getLayoutInflater().inflate(R.layout.layout_flow_tv, tagFlowLayout, false);
                                tv.setText(s);
                                return tv;
                            }
                        });
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });

    }

    /**
     * 长评论
     *
     * @param movieLongComments
     */
    @Override
    public void addMovieLongComment(MovieLongCommentBean.DataBean movieLongComments) {
        Observable
                .just(movieLongComments)
                .flatMap(new Func1<MovieLongCommentBean.DataBean, Observable<MovieLongCommentBean.DataBean>>() {
                    @Override
                    public Observable<MovieLongCommentBean.DataBean> call(MovieLongCommentBean.DataBean dataBean) {
                        if (dataBean.getFilmReviews().size() > 0) {
                            return Observable.just(dataBean);
                        }
                        return Observable.error(new Exception("empty error"));
                    }
                })
                .compose(SchedulersCompat.<MovieLongCommentBean.DataBean>applyIoSchedulers())
                .subscribe(new Action1<MovieLongCommentBean.DataBean>() {
                    @Override
                    public void call(MovieLongCommentBean.DataBean filmReviewsBean) {
                        MovieLongCommentAdapter movieLongCommentAdapter = new MovieLongCommentAdapter();
                        rvLongComment.setLayoutManager(new LinearLayoutManager(mContext));
                        rvLongComment.setAdapter(movieLongCommentAdapter);
                        rvLongComment.setNestedScrollingEnabled(false);
                        movieLongCommentAdapter.setNewData(filmReviewsBean.getFilmReviews());
                        View footer = getLayoutInflater().inflate(R.layout.item_normal_list_footer, (ViewGroup) rvLongComment.getParent(), false);
                        footer.setBackgroundResource(R.color.white);
                        ((TextView) footer.findViewById(R.id.tv_footer)).setText(String.format("查看全部%s条长评论", filmReviewsBean.getTotal()));
                        movieLongCommentAdapter.addFooterView(footer);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        tvLongComment.setVisibility(View.INVISIBLE);
                        tvNoLongComment.setVisibility(View.VISIBLE);
                    }
                });

    }

    /**
     * 相关资讯
     *
     * @param newsListBean
     */
    @Override
    public void addMovieRelatedInformation(List<MovieRelatedInformationBean.DataBean.NewsListBean> newsListBean) {
        Observable.just(newsListBean)
                .flatMap(new Func1<List<MovieRelatedInformationBean.DataBean.NewsListBean>, Observable<MovieRelatedInformationBean.DataBean.NewsListBean>>() {
                    @Override
                    public Observable<MovieRelatedInformationBean.DataBean.NewsListBean> call(List<MovieRelatedInformationBean.DataBean.NewsListBean> newsListBeen) {
                        if (newsListBeen.size() > 0) {
                            return Observable.from(newsListBeen);
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .limit(1)
                .compose(SchedulersCompat.<MovieRelatedInformationBean.DataBean.NewsListBean>applyIoSchedulers())
                .subscribe(new Action1<MovieRelatedInformationBean.DataBean.NewsListBean>() {
                    @Override
                    public void call(final MovieRelatedInformationBean.DataBean.NewsListBean newsListBean) {
                        tvRelatedInformationTitle.setText(newsListBean.getTitle());
                        tvRelatedInformationAuthor.setText(newsListBean.getSource());
                        tvRelatedInformationViewCount.setText(String.format("%s", newsListBean.getViewCount()));
                        tvRelatedInformationCommentCount.setText(String.format("%s", newsListBean.getCommentCount()));

                        GlideManager.loadImage(mContext, newsListBean.getPreviewImages().get(0).getUrl(), ivRelatedInformation);

                        llRelatedInformationContent.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                BaseWebViewActivity.start(mContext,StringUtil.getRealUrl(newsListBean.getUrl()));
                            }
                        });
                        llAllRelatedInformation.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MovieInformationActivity.start(mContext,movieId,mTitle);
                            }
                        });
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        llRelatedInformation.setVisibility(View.GONE);
                    }
                });

    }

    /**
     * 相关电影
     *
     * @param relatedMovies
     */
    @Override
    public void addRelatedMovie(List<RelatedMovieBean.DataBean> relatedMovies) {
        Observable.just(relatedMovies)
                .flatMap(new Func1<List<RelatedMovieBean.DataBean>, Observable<RelatedMovieBean.DataBean>>() {
                    @Override
                    public Observable<RelatedMovieBean.DataBean> call(List<RelatedMovieBean.DataBean> dataBeen) {
                        if (dataBeen.get(0).getItems().size() > 0) {
                            return Observable.just(dataBeen.get(0));
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .compose(SchedulersCompat.<RelatedMovieBean.DataBean>applyIoSchedulers())
                .subscribe(new Action1<RelatedMovieBean.DataBean>() {
                    @Override
                    public void call(RelatedMovieBean.DataBean dataBean) {
                        RelatedMovieAdapter relatedMovieAdapter = new RelatedMovieAdapter();
                        rvRelatedMovie.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                        rvRelatedMovie.setAdapter(relatedMovieAdapter);
                        relatedMovieAdapter.setNewData(dataBean.getItems());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        llRelatedMovie.setVisibility(View.GONE);
                    }
                });

    }

    /**
     * 相关话题
     *
     * @param movieTopicBean
     */
    @Override
    public void addMovieTopic(final MovieTopicBean.DataBean movieTopicBean) {
        Observable
                .just(movieTopicBean)
                .flatMap(new Func1<MovieTopicBean.DataBean, Observable<MovieTopicBean.DataBean.TopicsBean>>() {
                    @Override
                    public Observable<MovieTopicBean.DataBean.TopicsBean> call(MovieTopicBean.DataBean dataBean) {
                        if (dataBean.getTopics().size() > 0) {
                            return Observable.from(dataBean.getTopics());
                        }
                        return Observable.error(new Exception("empty Data"));
                    }
                })
                .compose(SchedulersCompat.<MovieTopicBean.DataBean.TopicsBean>applyIoSchedulers())
                .subscribe(new Subscriber<MovieTopicBean.DataBean.TopicsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        llRelatedTopic.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(final MovieTopicBean.DataBean.TopicsBean topicsBean) {
                        if (topicsBean.getPreviews().get(0).getUrl() != null) {
                            GlideManager.loadImage(mContext, topicsBean.getPreviews().get(0).getUrl(), ivRelatedTopic);
                        } else {
                            ivRelatedTopic.setVisibility(View.GONE);
                        }
                        tvRelatedTopicTitle.setText(topicsBean.getTitle());
                        tvRelatedTopicAuthor.setText(topicsBean.getAuthor().getNickName());
                        tvRelatedTopicViewCount.setText(String.format("%s", topicsBean.getViewCount()));
                        tvRelatedTopicCommentCount.setText(String.format("%s", topicsBean.getCommentCount()));
                        llALlRelatedTopic.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MovieTopicActivity.start(mContext, topicsBean.getGroupId());
                            }
                        });

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
        String originalUrl = ImgSizeUtil.resetPicUrl(movie.getImg(), "");
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
        //模糊背景图
        Observable
                .just(originalUrl)
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String s) {
                        try {
                            URL url = new URL(s);
                            return BitmapFactory.decodeStream(url.openStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                })
                .map(new Func1<Bitmap, Bitmap>() {
                    @Override
                    public Bitmap call(Bitmap bitmap) {
                        return FastBlurUtil.doBlur(bitmap, 130, false);
                    }
                })
                .compose(SchedulersCompat.<Bitmap>applyIoSchedulers())
                .subscribe(new Subscriber<Bitmap>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.getMessage());
                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        ivBlurBg.setImageBitmap(bitmap);
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

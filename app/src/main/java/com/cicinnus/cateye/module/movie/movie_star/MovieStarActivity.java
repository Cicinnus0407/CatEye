package com.cicinnus.cateye.module.movie.movie_star;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.base.BaseWebViewActivity;
import com.cicinnus.cateye.module.movie.movie_star.adapter.StarMoviesAdapter;
import com.cicinnus.cateye.module.movie.movie_star.adapter.StarPhotosAdapter;
import com.cicinnus.cateye.module.movie.movie_star.adapter.StarRelatedPeopleAdapter;
import com.cicinnus.cateye.module.movie.movie_star.bean.MovieStarHonor;
import com.cicinnus.cateye.module.movie.movie_star.bean.MovieStarInfoBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.RelatedInformationBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.StarMoviesBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.StarRelatedPeople;
import com.cicinnus.cateye.net.SchedulersCompat;
import com.cicinnus.cateye.tools.FastBlurUtil;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;
import com.cicinnus.cateye.tools.StringUtil;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.ProgressLayout;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.net.URL;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by Cicinnus on 2017/2/18.
 */

public class MovieStarActivity extends BaseActivity<MovieStarPresenter> implements MovieStarContract.IMovieStarView {

    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.status_bar_bg)
    View statusBarBg;
    @BindView(R.id.sc_star_detail)
    NestedScrollView scStarDetail;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_subTitle)
    TextView tvSubTitle;

    /***
     * 影人资料
     ***/
    @BindView(R.id.ll_star_name)
    LinearLayout llStarName;
    @BindView(R.id.tv_star_name)
    TextView tvStarName;
    @BindView(R.id.tv_star_english_name)
    TextView tvStarEName;
    @BindView(R.id.iv_star_bg)
    ImageView ivStarBg;
    @BindView(R.id.ll_star_name2)
    LinearLayout llStarName2;
    @BindView(R.id.tv_star_name2)
    TextView tvStarName2;
    @BindView(R.id.tv_star_english_name2)
    TextView tvStarEName2;
    @BindView(R.id.iv_star_avatar)
    ImageView ivStarAvatar;
    /***
     * 排行,票房
     ****/
    @BindView(R.id.tv_star_rank)
    TextView tvStarRank;
    @BindView(R.id.tv_star_fans_count)
    TextView tvFansCount;
    @BindView(R.id.tv_star_major_movie_box)
    TextView tvStarMajorMovieBox;
    /***
     * 个人简介
     ****/
    @BindView(R.id.tv_star_title)
    TextView tvStarTitle;
    @BindView(R.id.tv_star_birthday)
    TextView tvStarBirthday;
    @BindView(R.id.tv_star_info_desc)
    TextView tvStarInfoDesc;
    /*****
     * 参演电影
     *****/
    @BindView(R.id.ll_star_movie)
    LinearLayout llStarMovie;
    @BindView(R.id.tv_star_movies_count)
    TextView tvStarMoviesCount;
    @BindView(R.id.rv_star_movies)
    RecyclerView rvStarMovies;
    /***
     * 照片
     ***/
    @BindView(R.id.ll_star_photos)
    LinearLayout llStarPhotos;
    @BindView(R.id.tv_star_photos_count)
    TextView tvStarPhotosCount;
    @BindView(R.id.rv_star_photos)
    RecyclerView rvStarPhotos;
    /***
     * 荣誉成就
     ****/
    @BindView(R.id.ll_honor)
    LinearLayout llHonor;
    @BindView(R.id.tv_win_award_times)
    TextView tvWinAwardTimes;
    @BindView(R.id.tv_nominate_times)
    TextView tvNominateTimes;
    @BindView(R.id.tv_award_title)
    TextView tvAwardTitle;
    @BindView(R.id.tv_award_content)
    TextView tvAwardContent;

    /*****
     * 相关资讯
     ********/
    @BindView(R.id.ll_related_information)
    LinearLayout llRelatedInformation;
    @BindView(R.id.iv_related_information)
    ImageView ivRelatedInformation;
    @BindView(R.id.tv_related_information_content)
    TextView tvRelatedInformationContent;
    /*******
     * 相关影人
     **********/
    @BindView(R.id.ll_related_stars)
    LinearLayout llRelatedStars;
    @BindView(R.id.rv_related_stars)
    RecyclerView rvRelatedStars;


    private static final String STAR_ID = "star_id";
    private int starId;

    public static void start(Context context, int starId) {
        Intent starter = new Intent(context, MovieStarActivity.class);
        starter.putExtra(STAR_ID, starId);
        context.startActivity(starter);
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_movie_star;
    }

    @Override
    protected MovieStarPresenter getPresenter() {
        return new MovieStarPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        starId = getIntent().getIntExtra(STAR_ID, 0);
        initStatusBar();
        initListener();
        mPresenter.getMovieStarInfo(starId);
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


    /**
     * 监听NestedScrollView的滚动动态改变title的颜色
     */
    private void initListener() {
        final int changedHeight = UiUtils.dp2px(mContext, 214);

        scStarDetail.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
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

    @OnClick({R.id.rl_back})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
        }
    }


    /**
     * 影人资料
     *
     * @param info
     */
    @Override
    public void addMovieStarInfo(MovieStarInfoBean.DataBean info) {
        setTitle(info);
        //顶部照片和姓名
        setStarImg(info);
        //排名&票房
        setStarRankAndBox(info);
        //个人资料
        setStarInfo(info);
        //照片
        setPhotos(info);
    }

    /**
     * 标题栏
     *
     * @param info
     */
    private void setTitle(MovieStarInfoBean.DataBean info) {
        tvTitle.setTextColor(mContext.getResources().getColor(android.R.color.transparent));
        tvSubTitle.setTextColor(mContext.getResources().getColor(android.R.color.transparent));
        tvTitle.setText(info.getCnm());//中文主标题
        tvSubTitle.setText(info.getEnm());//英文副标题
    }

    /**
     * 头部的照片和姓名
     *
     * @param info
     */
    private void setStarImg(MovieStarInfoBean.DataBean info) {
        if (info.getBgImg() != null) {
            tvStarName.setText(info.getCnm());
            tvStarEName.setText(info.getEnm());
            llStarName.setVisibility(View.VISIBLE);
            llStarName2.setVisibility(View.INVISIBLE);
            String imgUrl = ImgSizeUtil.resetPicUrl(info.getBgImg(), "@2250w_1380h_1e_1l");
            GlideManager.loadImage(mContext, imgUrl, ivStarBg);
        } else {
            tvStarName2.setText(info.getCnm());
            tvStarEName2.setText(info.getEnm());
            llStarName2.setVisibility(View.VISIBLE);
            llStarName.setVisibility(View.INVISIBLE);
            String avatarUrl = ImgSizeUtil.resetPicUrl(info.getAvatar(), "");
            GlideManager.loadImage(mContext, avatarUrl, ivStarAvatar);
            Observable.just(avatarUrl)
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
                    .filter(new Func1<Bitmap, Boolean>() {
                        @Override
                        public Boolean call(Bitmap bitmap) {
                            return bitmap != null;
                        }
                    })
                    .map(new Func1<Bitmap, Bitmap>() {
                        @Override
                        public Bitmap call(Bitmap bitmap) {
                            return FastBlurUtil.doBlur(bitmap, 130, false);
                        }
                    })
                    .compose(SchedulersCompat.<Bitmap>applyIoSchedulers())
                    .subscribe(new Action1<Bitmap>() {
                        @Override
                        public void call(Bitmap bitmap) {
                            ivStarBg.setImageBitmap(bitmap);
                        }
                    });

        }
    }

    /**
     * 照片
     */
    private void setPhotos(MovieStarInfoBean.DataBean info) {
        if(info.getPhotos().size()==0){
            llStarPhotos.setVisibility(View.GONE);
        }else {
            tvStarPhotosCount.setText(String.format("全部(%s)", info.getPhotoNum()));
            StarPhotosAdapter starPhotosAdapter = new StarPhotosAdapter();
            rvStarPhotos.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            rvStarPhotos.setAdapter(starPhotosAdapter);
            starPhotosAdapter.setNewData(info.getPhotos());
        }

    }

    /**
     * 个人资料
     *
     * @param info
     */
    private void setStarInfo(MovieStarInfoBean.DataBean info) {
        tvStarTitle.setText(info.getTitles());
        tvStarBirthday.setText(String.format("生日:%s", info.getBirthday().equals("")?"暂无":info.getBirthday()));
        tvStarInfoDesc.setText(String.format("简介:%s", info.getDesc().equals("")?"暂无":info.getDesc()));
    }

    /**
     * 票房和排名
     *
     * @param info
     */
    private void setStarRankAndBox(MovieStarInfoBean.DataBean info) {
        if (info.getSumBox() == 0) {
            tvStarMajorMovieBox.setTextColor(mContext.getResources().getColor(R.color.text_gray));
            tvStarMajorMovieBox.setText("暂无");
        } else {
            tvStarMajorMovieBox.setText(StringUtil.changeMillionIntoBillion(info.getSumBox()));

        }
        tvStarRank.setText(String.format("%s", info.getRank()==-1?"1000+":info.getFollowCount()));
        tvFansCount.setText(String.format("%s", info.getFollowCount()));
    }

    /**
     * 影人荣誉
     *
     * @param honors
     */
    @Override
    public void addMovieStarHonor(MovieStarHonor honors) {
        Observable.just(honors)
                .flatMap(new Func1<MovieStarHonor, Observable<MovieStarHonor.DataBean>>() {
                    @Override
                    public Observable<MovieStarHonor.DataBean> call(MovieStarHonor movieStarHonor) {
                        if (movieStarHonor.getData().getAward() != null) {
                            return Observable.just(movieStarHonor.getData());
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .subscribe(new Action1<MovieStarHonor.DataBean>() {
                    @Override
                    public void call(MovieStarHonor.DataBean dataBean) {
                        tvWinAwardTimes.setText(String.format("%s", dataBean.getAwardCount()));
                        tvNominateTimes.setText(String.format("%s", dataBean.getNomCount()));
                        tvAwardTitle.setText(dataBean.getFestivalName());
                        tvAwardContent.setText(dataBean.getPrizeDesc());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        llHonor.setVisibility(View.GONE);
                    }
                });
    }

    @Override
    public void addStarMovies(StarMoviesBean.DataBean moviesData) {
        if (moviesData.getMovies().size() == 0) {
            llStarMovie.setVisibility(View.GONE);
        } else {
            tvStarMoviesCount.setText(String.format("全部(%s)", moviesData.getPaging().getTotal()));
            rvStarMovies.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            StarMoviesAdapter starMoviesAdapter = new StarMoviesAdapter();
            rvStarMovies.setAdapter(starMoviesAdapter);
            starMoviesAdapter.setNewData(moviesData.getMovies());
        }


    }

    /**
     * 相关资讯
     * @param relatedInformationBean
     */
    @Override
    public void addRelatedInformation(final RelatedInformationBean relatedInformationBean) {

        Observable.just(relatedInformationBean)
                .flatMap(new Func1<RelatedInformationBean, Observable<RelatedInformationBean.DataBean.NewsListBean>>() {
                    @Override
                    public Observable<RelatedInformationBean.DataBean.NewsListBean> call(RelatedInformationBean relatedInformationBean) {
                        if (relatedInformationBean.getData().getNewsList().size() > 0) {
                            return Observable.from(relatedInformationBean.getData().getNewsList());
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .limit(1)
                .subscribe(new Subscriber<RelatedInformationBean.DataBean.NewsListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        llRelatedInformation.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(final RelatedInformationBean.DataBean.NewsListBean newsListBean) {
                        GlideManager.loadImage(mContext, newsListBean.getPreviewImages().get(0).getUrl(), ivRelatedInformation);
                        tvRelatedInformationContent.setText(newsListBean.getTitle());
                        llRelatedInformation.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                BaseWebViewActivity.start(mContext,StringUtil.getRealUrl(newsListBean.getUrl()));
                            }
                        });
                    }
                });
    }

    /**
     * 相关影人
     * @param relatedPeople
     */
    @Override
    public void addStarRelatedPeople(StarRelatedPeople relatedPeople) {
        Observable.just(relatedPeople)
                .flatMap(new Func1<StarRelatedPeople, Observable<StarRelatedPeople.DataBean>>() {
                    @Override
                    public Observable<StarRelatedPeople.DataBean> call(StarRelatedPeople starRelatedPeople) {
                        if (starRelatedPeople.getData().getRelations().size() > 0) {
                            return Observable.just(starRelatedPeople.getData());
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .subscribe(new Action1<StarRelatedPeople.DataBean>() {
                    @Override
                    public void call(StarRelatedPeople.DataBean dataBean) {
                        StarRelatedPeopleAdapter starRelatedPeopleAdapter = new StarRelatedPeopleAdapter();
                        rvRelatedStars.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                        rvRelatedStars.setAdapter(starRelatedPeopleAdapter);
                        starRelatedPeopleAdapter.setNewData(dataBean.getRelations());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        llRelatedStars.setVisibility(View.GONE);
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
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        Logger.d(errorMsg);
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getMovieStarInfo(starId);
            }
        });
    }
}

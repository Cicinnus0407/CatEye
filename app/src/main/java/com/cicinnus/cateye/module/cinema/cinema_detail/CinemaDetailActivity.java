package com.cicinnus.cateye.module.cinema.cinema_detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.module.cinema.cinema_detail.adapter.FoodsAdapter;
import com.cicinnus.cateye.module.cinema.cinema_detail.adapter.MovieDateAdapter;
import com.cicinnus.cateye.module.cinema.cinema_detail.adapter.MoviePicAdapter;
import com.cicinnus.cateye.module.cinema.cinema_detail.adapter.ShowListAdapter;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaMovieBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.FoodsBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.CinemaInfoDetailActivity;
import com.cicinnus.cateye.tools.ImgSizeUtil;
import com.cicinnus.cateye.view.ClipViewPager;
import com.cicinnus.cateye.view.CustomViewPagerTransformer;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;
import com.cicinnus.retrofitlib.utils.BlurUtils;
import com.cicinnus.retrofitlib.utils.UIUtils;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by Cicinnus on 2017/6/21.
 */

public class CinemaDetailActivity extends BaseActivity<CinemaDetailPresenter> implements CinemaDetailContract.ICinemaDetailView {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;

    @BindView(R.id.tv_cinema_name)
    TextView tvCinemaName;
    @BindView(R.id.tv_location)
    TextView tvLocation;

    @BindView(R.id.rl_movies)
    RelativeLayout rlMovies;
    @BindView(R.id.vp_movie)
    ClipViewPager vpMovie;
    @BindView(R.id.iv_blur_bg)
    ImageView ivBlurBg;
    @BindView(R.id.rv_date)
    RecyclerView rvDate;
    @BindView(R.id.ll_cinema_tag)
    LinearLayout llCinemaTag;
    @BindView(R.id.tv_sale_title)
    TextView tvSaleTitle;
    @BindView(R.id.tv_sale_content)
    TextView tvSaleContent;
    @BindView(R.id.rl_sale)
    RelativeLayout rlSale;
    @BindView(R.id.tv_movie_name)
    TextView tvMovieName;
    @BindView(R.id.tv_movie_score)
    TextView tvMovieScore;
    @BindView(R.id.tv_unit)
    TextView tvUnit;
    @BindView(R.id.tv_movie_desc)
    TextView tvMovieDesc;
    @BindView(R.id.rv_time)
    RecyclerView rvShowList;
    @BindView(R.id.rv_foods)
    RecyclerView rvFoods;


    private MoviePicAdapter moviePicAdapter;
    private List<CinemaMovieBean.DataBean.MoviesBean> mCurrentMovies;
    private MovieDateAdapter movieDateAdapter;
    private ShowListAdapter showListAdapter;
    private MyPullToRefreshListener pullToRefreshListener;
    private int cinemaId;
    private FoodsAdapter foodsAdapter;
    private View emptyView;


    public static void start(Context context, int cinemaId, String cinemaName) {
        Intent starter = new Intent(context, CinemaDetailActivity.class);
        starter.putExtra("cinemaId", cinemaId);
        starter.putExtra("cinemaName", cinemaName);
        context.startActivity(starter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_ciname_detail;
    }

    @Override
    protected CinemaDetailPresenter getPresenter() {
        return new CinemaDetailPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        cinemaId = getIntent().getIntExtra("cinemaId", 0);
        String cinemaName = getIntent().getStringExtra("cinemaName");
        tvTitle.setText(cinemaName);
        initSwipe();
        initViewPager();
        initRv();
        mPresenter.getCinema(cinemaId);
    }

    private void initRv() {
        movieDateAdapter = new MovieDateAdapter();
        rvDate.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rvDate.setNestedScrollingEnabled(false);
        rvDate.setAdapter(movieDateAdapter);

        showListAdapter = new ShowListAdapter();
        rvShowList.setLayoutManager(new LinearLayoutManager(mContext));
        rvShowList.setNestedScrollingEnabled(false);
        rvShowList.setAdapter(showListAdapter);
//        emptyView = getLayoutInflater().inflate(R.layout.layout_cinema_movie_sold_out, (ViewGroup) rvShowList.getParent());

        showListAdapter.setEmptyView(R.layout.layout_cinema_movie_sold_out, (ViewGroup) rvShowList.getParent());

        movieDateAdapter.setOnMovieDateClickListener(new MovieDateAdapter.OnMovieDateClickListener() {
            @Override
            public void onClick(CinemaMovieBean.DataBean.MoviesBean.ShowsBean item) {
                if (item.getPreInfoList() != null &&
                        item.getPreInfoList().size() > 0) {
                    //TODO 添加一个头
//                    showListAdapter.addHeaderView()
                }

                showListAdapter.setNewData(item.getPlist());
            }
        });

        foodsAdapter = new FoodsAdapter();
        rvFoods.setNestedScrollingEnabled(false);
        rvFoods.setLayoutManager(new LinearLayoutManager(mContext));
        rvFoods.setAdapter(foodsAdapter);

    }

    private void initSwipe() {
        pullToRefreshListener = new MyPullToRefreshListener(mContext, swipe);
        swipe.setOnPullRefreshListener(pullToRefreshListener);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getCinema(cinemaId);
            }
        });

    }

    private void initViewPager() {
        rlMovies.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return vpMovie.dispatchTouchEvent(event);
            }
        });

        vpMovie.setPageTransformer(false, new CustomViewPagerTransformer());
        vpMovie.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //模糊背景
                ImageView imageView = (ImageView) vpMovie.findViewWithTag(position);
                if (imageView != null) {
                    imageView.setDrawingCacheEnabled(true);
                    Observable.just(imageView)
                            .filter(new Predicate<ImageView>() {
                                @Override
                                public boolean test(@NonNull ImageView imageView) throws Exception {
                                    return imageView != null;
                                }
                            })
                            .map(new Function<ImageView, Bitmap>() {
                                @Override
                                public Bitmap apply(@NonNull ImageView imageView) throws Exception {
                                    return imageView.getDrawingCache();
                                }
                            })
                            .map(new Function<Bitmap, Bitmap>() {
                                @Override
                                public Bitmap apply(@NonNull Bitmap bitmap) throws Exception {
                                    return BlurUtils.with(new WeakReference<Context>(mContext)).bitmap(bitmap)
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
                            });
                }
                setMovieInfo(mCurrentMovies, position);
                setDateList(mCurrentMovies, position);

                showListAdapter.setNewData(movieDateAdapter.getData().get(0).getPlist());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ViewGroup.LayoutParams layoutParams = vpMovie.getLayoutParams();
        layoutParams.width = UIUtils.dp2px(mContext, 100);
        vpMovie.setLayoutParams(layoutParams);
        moviePicAdapter = new MoviePicAdapter();

        vpMovie.setAdapter(moviePicAdapter);
        vpMovie.setOffscreenPageLimit(5);
        vpMovie.setCurrentItem(0);
    }

    @OnClick({R.id.rl_back,R.id.tv_cinema_name})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_cinema_name:
                CinemaInfoDetailActivity.start(mContext,cinemaId);
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
        pullToRefreshListener.refreshDone();
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        pullToRefreshListener.refreshDone();
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getCinema(cinemaId);
            }
        });
    }

    @Override
    public void addCinemaMovies(List<CinemaMovieBean.DataBean.MoviesBean> movies) {
        mCurrentMovies = movies;
        //设置影片信息
        setMovieInfo(movies, 0);
        //设置放映列表
        setDateList(movies, 0);
        //照片url
        moviePicAdapter.setUrls(movies);
        //第一次加载放映列表
        showListAdapter.setNewData(movieDateAdapter.getData().get(0).getPlist());
        vpMovie.setCurrentItem(0);

        //初次模糊
        Observable.just(movies.get(0).getImg())
                .map(new Function<String, String>() {
                    @Override
                    public String apply(@NonNull String s) throws Exception {
                        return ImgSizeUtil.processUrl(s, 174, 244);
                    }
                })
                .map(new Function<String, Bitmap>() {
                    @Override
                    public Bitmap apply(@NonNull String s) throws Exception {
                        try {
                            URL url = new URL(s);
                            return BitmapFactory.decodeStream(url.openStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                })
                .filter(new Predicate<Bitmap>() {
                    @Override
                    public boolean test(@NonNull Bitmap bitmap) throws Exception {
                        return bitmap != null;
                    }
                })
                .map(new Function<Bitmap, Bitmap>() {
                    @Override
                    public Bitmap apply(Bitmap bitmap) {
                        return BlurUtils.with(new WeakReference<Context>(mContext))
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
                });
    }

    @Override
    public void addCinemaData(CinemaBean.DataBean data) {
        tvCinemaName.setText(data.getNm());
        tvLocation.setText(String.format("%s", data.getAddr()));
        //添加影院标签
        llCinemaTag.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 6, 0);
        for (int i = 0; i < data.getFeatureTags().size(); i++) {
            TextView tv = new TextView(mContext);
            tv.setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_promotion));
            GradientDrawable background = (GradientDrawable) tv.getBackground();
            background.setStroke(2, Color.parseColor("#579daf"));
            tv.setTextColor(Color.parseColor("#579daf"));
            tv.setTextSize(11);
            tv.setText(data.getFeatureTags().get(i).getTag());
            tv.setMaxLines(1);
            tv.setEllipsize(TextUtils.TruncateAt.END);
            tv.setLayoutParams(layoutParams);
            llCinemaTag.addView(tv);
        }
        if (data.getSaleInfo() != null) {
            rlSale.setVisibility(View.VISIBLE);
            tvSaleTitle.setText(data.getSaleInfo().getTitle());
            tvSaleContent.setText(data.getSaleInfo().getContent());
        }

    }

    @Override
    public void addFoods(List<FoodsBean.DataBean.DealListBean> dealList) {
        if (dealList != null && dealList.size() > 0) {
            foodsAdapter.setNewData(dealList);
            View foodHeader = View.inflate(mContext, R.layout.layout_foods_header, null);
            foodsAdapter.addHeaderView(foodHeader);
        }
    }

    /**
     * 设置影片播放时间列表
     *
     * @param movies
     * @param position
     */
    private void setDateList(List<CinemaMovieBean.DataBean.MoviesBean> movies, int position) {
//        movieDateAdapter.setNewData(new ArrayList<CinemaMovieBean.DataBean.MoviesBean.ShowsBean>());
//        movies.get(position).getShows().get(0).isSelect = true;
        movieDateAdapter.setNewData(movies.get(position).getShows());
        //判断是否为只有一天排片,并且是否上映
//        View emptyView = showListAdapter.getEmptyView();
//
//        if (movieDateAdapter.getData().size() == 1) {
//            //如果只有一天,则添加今天空放映列表
//            CinemaMovieBean.DataBean.MoviesBean.ShowsBean bean = new CinemaMovieBean.DataBean.MoviesBean.ShowsBean();
//            bean.setShowDate(TimeUtils.dateYMD(System.currentTimeMillis()));
//            movieDateAdapter.addData(0, bean);
//            if(movies.get(position).isGlobalReleased()){
//                TextView tvNext = ((TextView) emptyView.findViewById(R.id.tv_show_next));
//                tvNext.setVisibility(View.VISIBLE);
//                tvNext.setText(String.format("点击查看%s的场次", movieDateAdapter.getData().get(1).getShowDate()));
//                tvNext.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        rvDate.findViewHolderForAdapterPosition(1).itemView.callOnClick();
//                    }
//                });
//                ((TextView) emptyView.findViewById(R.id.tv_empty_show_list)).setText("今天暂无场次");
//            }else {
//                ((TextView) emptyView.findViewById(R.id.tv_empty_show_list)).setText("影片未上映");
//                movieDateAdapter.remove(0);
//
//            }
//        } else {
//            emptyView.findViewById(R.id.tv_show_next).setVisibility(View.GONE);
//            ((TextView) emptyView.findViewById(R.id.tv_empty_show_list)).setText("今天场次已映完");
//        }
//        if()


        showListAdapter.setDuration(movies.get(position).getDur());

    }

    /**
     * 设置电影信息
     *
     * @param movies
     * @param position
     */
    private void setMovieInfo(List<CinemaMovieBean.DataBean.MoviesBean> movies, int position) {
        tvMovieName.setText(movies.get(position).getNm());
        String scoreText = movies.get(position).isGlobalReleased() ? String.format("%s", movies.get(position).getSc()) : String.format("%s", movies.get(position).getWish());
        tvUnit.setText(movies.get(position).isGlobalReleased() ? "分" : "人想看");
        tvMovieScore.setText(scoreText);
        tvMovieDesc.setText(movies.get(position).getDesc());
    }


}

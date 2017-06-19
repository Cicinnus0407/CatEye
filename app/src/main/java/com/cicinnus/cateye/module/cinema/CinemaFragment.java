package com.cicinnus.cateye.module.cinema;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.Constants;
import com.cicinnus.cateye.module.cinema.bean.CinemaListBean;
import com.cicinnus.cateye.module.movie.pick_city.PickCityActivity;
import com.cicinnus.cateye.tools.LocationUtil;
import com.cicinnus.cateye.tools.ToastUtil;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.FloatingHeaderDecoration;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;
import com.cicinnus.retrofitlib.base.BaseMVPFragment;
import com.cicinnus.retrofitlib.utils.SPUtils;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 影院列表
 */

public class CinemaFragment extends BaseMVPFragment<CinemaPresenter> implements CinemaContract.ICinemaView {


    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.rv_cinema)
    RecyclerView rvCinema;
    @BindView(R.id.tv_location)
    TextView tvLocation;

    private LocationUtil locationUtil;
    private MyPullToRefreshListener pullToRefreshListener;
    private int offset;
    private int limit = 10;
    private double lat;
    private double lng;
    private int ci;
    private CinemaAdapter cinemaAdapter;
    private boolean isFirst = true;

    public static CinemaFragment newInstance() {

        return new CinemaFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected CinemaPresenter getPresenter() {
        return new CinemaPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        ci = SPUtils.getInstance(mContext, Constants.SP_CITY).getInt(Constants.CITY_CODE, 20);
        initSwipe();
        initRv();
    }

    @Override
    protected void lazyLoadEveryTime() {
        if (isFirst) {
            initLocation();
            isFirst = false;
        }
    }

    private void initRv() {
        cinemaAdapter = new CinemaAdapter();
        rvCinema.setLayoutManager(new LinearLayoutManager(mContext));
        rvCinema.setAdapter(cinemaAdapter);
        cinemaAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMoreCinema(ci, offset, limit, lat, lng);
            }
        }, rvCinema);

        View header = LayoutInflater.from(mContext).inflate(R.layout.layout_cinema_pinned_header, (ViewGroup) rvCinema.getParent(),false);
        View header2 =  LayoutInflater.from(mContext).inflate(R.layout.layout_cinema_pinned_header, (ViewGroup) rvCinema.getParent(),false);
        cinemaAdapter.addHeaderView(header);
        cinemaAdapter.addHeaderView(header2);
        FloatingHeaderDecoration floatingHeaderDecoration = new FloatingHeaderDecoration(mContext);

        floatingHeaderDecoration.setmTitleHeight(UiUtils.dp2px(mContext, header.getHeight()));
        floatingHeaderDecoration.setShowFloatingHeaderOnScrolling(true);//不悬浮
        rvCinema.addItemDecoration(floatingHeaderDecoration);
        HashMap<Integer,String> keys = new HashMap<>();
        keys.put(1,"B");
        floatingHeaderDecoration.setKeys(keys);

        rvCinema.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //停止滑动
                    tvLocation.setVisibility(View.VISIBLE);
                } else if (recyclerView.getScrollState() != 0) {
                    //正在滑动
                    tvLocation.setVisibility(View.INVISIBLE);
                }
            }
        });


    }

    private void initSwipe() {
        pullToRefreshListener = new MyPullToRefreshListener(mContext, swipe);
        swipe.setOnPullRefreshListener(pullToRefreshListener);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                offset = 0;
                mPresenter.getCinema(ci, offset, limit, lat, lng);
            }
        });

    }

    private void initLocation() {
        if (!progressLayout.isContent()) {
            progressLayout.showLoading();
        }
        locationUtil = new LocationUtil(new WeakReference<>(mContext))
                .setOnceLocation(true)
                .setOnLocationChangeListener(new LocationUtil.OnLocationChangeListener() {
                    @Override
                    public void onChange(AMapLocation amapLocation) {
                        lat = amapLocation.getLatitude();
                        lng = amapLocation.getLongitude();
                        tvLocation.setText(amapLocation.getAddress());
                        mPresenter.getCinema(ci, offset, limit, lat, lng);
                    }
                });
        locationUtil.startLocation();
    }

    @OnClick({
            R.id.tv_location,
//            R.id.tv_city

    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_location:
                tvLocation.setText("正在定位..");
                locationUtil.startLocation();
                break;
            case R.id.tv_city:
                PickCityActivity.start(mContext, 56);
                break;
        }
    }

    @Override
    public void showLoading() {
        progressLayout.showLoading();
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
                mPresenter.getCinema(ci, offset, limit, lat, lng);
            }
        });
    }

    @Override
    public void addCinema(List<CinemaListBean.DataBean.CinemasBean> cinemasBeanList) {
        offset = 20;
        cinemaAdapter.setNewData(cinemasBeanList);
        rvCinema.smoothScrollToPosition(0);

    }

    @Override
    public void addMoreCinema(List<CinemaListBean.DataBean.CinemasBean> cinemas) {
        if (cinemas.size() > 0) {
            offset += 10;
            cinemaAdapter.addData(cinemas);
            cinemaAdapter.loadMoreComplete();
        } else {
            cinemaAdapter.loadMoreEnd();
        }
    }

    @Override
    public void addMoreCinemaFail(String errMsg) {
        ToastUtil.showToast(errMsg);
        cinemaAdapter.loadMoreFail();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 32&&resultCode==33) {
            ci = SPUtils.getInstance(mContext, Constants.SP_CITY).getInt(Constants.CITY_CODE, 20);
            mPresenter.getCinema(ci, offset, limit, lat, lng);
        } else if (requestCode == 56 && resultCode == 33) {
            ci = SPUtils.getInstance(mContext, Constants.SP_CITY).getInt(Constants.CITY_CODE, 20);
            mPresenter.getCinema(ci, offset, limit, lat, lng);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        locationUtil.destroyLocation();
    }
}

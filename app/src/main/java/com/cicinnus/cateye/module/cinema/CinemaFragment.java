package com.cicinnus.cateye.module.cinema;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.amap.api.location.AMapLocation;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.Constants;
import com.cicinnus.cateye.module.cinema.bean.CinemaListBean;
import com.cicinnus.cateye.tools.LocationUtil;
import com.cicinnus.cateye.view.FloatingItemDecoration;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;
import com.cicinnus.retrofitlib.base.BaseMVPFragment;
import com.cicinnus.retrofitlib.utils.SPUtils;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;

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


    private LocationUtil locationUtil;
    private MyPullToRefreshListener pullToRefreshListener;
    private int offset;
    private int limit = 10;
    private double lat;
    private double lng;
    private int ci;
    private CinemaAdapter cinemaAdapter;
    private boolean isFirst = true;
    private boolean locationOnce=true;

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
        FloatingItemDecoration floatingItemDecoration = new FloatingItemDecoration(mContext);
        rvCinema.addItemDecoration(floatingItemDecoration);
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
        locationUtil = new LocationUtil(new WeakReference<>(mContext));
        locationUtil.setOnceLocation(true);
        locationUtil.startLocation();
        locationUtil.setOnLocationChangeListener(new LocationUtil.OnLocationChangeListener() {
            @Override
            public void onChange(AMapLocation amapLocation) {
                lat = amapLocation.getLatitude();
                lng = amapLocation.getLongitude();
                if (locationOnce) {
                    mPresenter.getCinema(ci, offset, limit, lat, lng);
                    locationOnce = false;
                }
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
        offset += 10;
        cinemaAdapter.setNewData(cinemasBeanList);

    }

}

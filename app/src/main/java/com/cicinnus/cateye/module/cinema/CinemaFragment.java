package com.cicinnus.cateye.module.cinema;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.Constants;
import com.cicinnus.cateye.module.cinema.adapter.AreaAdapter;
import com.cicinnus.cateye.module.cinema.adapter.AreaSubAdapter;
import com.cicinnus.cateye.module.cinema.adapter.BrandAdapter;
import com.cicinnus.cateye.module.cinema.adapter.HallTypeAdapter;
import com.cicinnus.cateye.module.cinema.adapter.MetroAdapter;
import com.cicinnus.cateye.module.cinema.adapter.MetroSubAdapter;
import com.cicinnus.cateye.module.cinema.adapter.ServiceAdapter;
import com.cicinnus.cateye.module.cinema.adapter.SortConditionAdapter;
import com.cicinnus.cateye.module.cinema.bean.CinemaBannerBean;
import com.cicinnus.cateye.module.cinema.bean.CinemaListBean;
import com.cicinnus.cateye.module.cinema.bean.FilterBean;
import com.cicinnus.cateye.module.cinema.bean.SortConditionBean;
import com.cicinnus.cateye.module.movie.pick_city.PickCityActivity;
import com.cicinnus.cateye.tools.LocationUtil;
import com.cicinnus.cateye.tools.ToastUtil;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.Banner;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;
import com.cicinnus.retrofitlib.base.BaseMVPFragment;
import com.cicinnus.retrofitlib.utils.PopupWindowUtils;
import com.cicinnus.retrofitlib.utils.SPUtils;
import com.cicinnus.retrofitlib.utils.UIUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
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
    @BindView(R.id.ll_filter)
    LinearLayout llFilter;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.tv_sort_condition)
    TextView tvSortCondition;
    @BindView(R.id.tv_brand)
    TextView tvBrand;
    @BindView(R.id.tv_hall_type)
    TextView tvHallType;
    @BindView(R.id.tv_city)
    TextView tvCity;

    private LocationUtil locationUtil;
    private MyPullToRefreshListener pullToRefreshListener;
    private int offset;
    private int limit = 10;
    private double lat;
    private double lng;
    private int ci;
    private CinemaAdapter cinemaAdapter;
    private boolean isFirst = true;
    private Banner banner;
    private int mDistanceY;
    private int mBannerHeight;
    //左侧父分类
    private RecyclerView rvParent;
    //右侧子分类
    private RecyclerView rvSub;
    //地区Id,全部为-1
    private int districtId = -1;
    //详细区域id
    private int areaId = -1;
    private String sort = "distance";
    //地铁id,全部为-1
    private int lineId = -1;
    //地铁父线路id
    private int mParentLineId = -1;
    private int stationId = -1;
    //品牌
    private int brandId = -1;
    //特色功能
    private int serviceId = -1;
    //特效厅
    private int hallType = -1;
    private AreaAdapter areaAdapter;
    private AreaSubAdapter areaSubAdapter;
    private MetroAdapter metroAdapter;
    private MetroSubAdapter metroSubAdapter;
    private TextView headerTvArea;
    private TextView headerTvSortCondition;
    private TextView headerTvBrand;
    private FilterBean mCurrentFilterData;
    private String lineText;
    private String parentDistrictName;

    //筛选window
    private PopupWindow sortWindow;
    private PopupWindow areaWindow;


    private BrandAdapter brandAdapter;
    private PopupWindow brandWindow;
    private ServiceAdapter serviceAdapter;
    private HallTypeAdapter hallTypeAdapter;
    private PopupWindow hallTypeWindow;
    private TextView headerTvHallType;
    private PopupWindowUtils popupWindowUtils;

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
        tvCity.setText(SPUtils.getInstance(mContext, Constants.SP_CITY).getString(Constants.CITY_NAME, "广州"));
        initSwipe();
        initRv();
        popupWindowUtils = new PopupWindowUtils();
        createAreaWindow();
        createSortCondition();
        createBrandWindow();
        createHallTypeWindow();
    }


    @Override
    protected void lazyLoadEveryTime() {
        if (isFirst) {
            initLocation();
            isFirst = false;
        }
    }

    /**
     * 初始化列表
     */
    private void initRv() {
        cinemaAdapter = new CinemaAdapter();
        rvCinema.setLayoutManager(new LinearLayoutManager(mContext));
        rvCinema.setAdapter(cinemaAdapter);
        cinemaAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMoreCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
            }
        }, rvCinema);
        rvCinema.setNestedScrollingEnabled(false);



        banner = new Banner(mContext);

        View header = LayoutInflater.from(mContext).inflate(R.layout.layout_cinema_pinned_header, (ViewGroup) rvCinema.getParent(), false);
        headerTvArea = (TextView) header.findViewById(R.id.tv_area);
        headerTvArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindowUtils.ToggleWindow(areaWindow, headerTvArea, new PopupWindowUtils.onWindowStatusChanged() {
                    @Override
                    public void onShow() {
                        setTextDrawableAndColor(tvArea, true);
                        setTextDrawableAndColor(headerTvArea, true);
                    }

                    @Override
                    public void onDismiss() {
                        setTextDrawableAndColor(tvArea, false);
                        setTextDrawableAndColor(headerTvArea, false);
                    }
                });
            }
        });
        headerTvSortCondition = (TextView) header.findViewById(R.id.tv_sort_condition);
        headerTvSortCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindowUtils.ToggleWindow(sortWindow, headerTvSortCondition, new PopupWindowUtils.onWindowStatusChanged() {
                    @Override
                    public void onShow() {
                        setTextDrawableAndColor(tvSortCondition, true);
                        setTextDrawableAndColor(headerTvSortCondition, true);
                    }

                    @Override
                    public void onDismiss() {
                        setTextDrawableAndColor(tvSortCondition, false);
                        setTextDrawableAndColor(headerTvSortCondition, false);
                    }
                });
            }
        });

        headerTvBrand = (TextView) header.findViewById(R.id.tv_brand);
        headerTvBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindowUtils.ToggleWindow(brandWindow, headerTvBrand, new PopupWindowUtils.onWindowStatusChanged() {
                    @Override
                    public void onShow() {
                        setTextDrawableAndColor(tvBrand, true);
                        setTextDrawableAndColor(headerTvBrand, true);
                    }

                    @Override
                    public void onDismiss() {
                        setTextDrawableAndColor(tvBrand, false);
                        setTextDrawableAndColor(headerTvBrand, false);
                    }
                });
            }
        });

        headerTvHallType = (TextView) header.findViewById(R.id.tv_hall_type);
        headerTvHallType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindowUtils.ToggleWindow(hallTypeWindow, headerTvHallType, new PopupWindowUtils.onWindowStatusChanged() {
                    @Override
                    public void onShow() {
                        setTextDrawableAndColor(tvHallType, true);
                        setTextDrawableAndColor(headerTvHallType, true);
                    }

                    @Override
                    public void onDismiss() {
                        if (hallType == -1 && serviceId == -1) {
                            setTextDrawableAndColor(tvHallType, false);
                            setTextDrawableAndColor(headerTvHallType, false);
                        }
                    }
                });
            }
        });

        cinemaAdapter.addHeaderView(header);
        mBannerHeight = UiUtils.dp2px(mContext, 60);
        //滑动监听
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

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //banner高度大于滑动距离,跟随滑动
                if (mBannerHeight >= mDistanceY) {
                    llFilter.setVisibility(View.GONE);
                } else {
                    llFilter.setVisibility(View.VISIBLE);
                }
                mDistanceY += dy;
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
                mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
                mPresenter.getBanner(ci);
                mPresenter.getFilter(ci);
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
                        SPUtils.getInstance(mContext, Constants.SP_CITY)
                                .putDouble(Constants.LNG, lng)
                                .putDouble(Constants.LAT, lat)
                                .apply();
                        tvLocation.setText(amapLocation.getAddress());
                        mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
                        mPresenter.getBanner(ci);
                        mPresenter.getFilter(ci);
                    }

                    @Override
                    public void onLocateFail(AMapLocation amapLocation) {
                        progressLayout.showError(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mPresenter.getBanner(ci);
                                mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
                            }
                        });
                    }
                });
        locationUtil.startLocation();
    }

    @OnClick({
            R.id.tv_location,
            R.id.tv_city,
            R.id.tv_area,
            R.id.tv_sort_condition,
            R.id.tv_brand,
            R.id.tv_hall_type
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
            case R.id.tv_area:
                PopupWindowUtils.ToggleWindow(areaWindow, headerTvArea, new PopupWindowUtils.onWindowStatusChanged() {
                    @Override
                    public void onShow() {
                        setTextDrawableAndColor(tvArea, true);
                        setTextDrawableAndColor(headerTvArea, true);
                    }

                    @Override
                    public void onDismiss() {
                        setTextDrawableAndColor(tvArea, false);
                        setTextDrawableAndColor(headerTvArea, false);
                    }
                });
                break;
            case R.id.tv_sort_condition:
                PopupWindowUtils.ToggleWindow(sortWindow, tvSortCondition, new PopupWindowUtils.onWindowStatusChanged() {
                    @Override
                    public void onShow() {
                        setTextDrawableAndColor(tvSortCondition, true);
                        setTextDrawableAndColor(headerTvSortCondition, true);
                    }

                    @Override
                    public void onDismiss() {
                        setTextDrawableAndColor(tvSortCondition, false);
                        setTextDrawableAndColor(headerTvSortCondition, false);
                    }
                });
                break;
            case R.id.tv_brand:
                PopupWindowUtils.ToggleWindow(brandWindow, tvBrand, new PopupWindowUtils.onWindowStatusChanged() {
                    @Override
                    public void onShow() {
                        setTextDrawableAndColor(tvBrand, true);
                        setTextDrawableAndColor(headerTvBrand, true);
                    }

                    @Override
                    public void onDismiss() {
                        setTextDrawableAndColor(tvBrand, false);
                        setTextDrawableAndColor(headerTvBrand, false);
                    }
                });
                break;
            case R.id.tv_hall_type:
                PopupWindowUtils.ToggleWindow(hallTypeWindow, tvHallType, new PopupWindowUtils.onWindowStatusChanged() {
                    @Override
                    public void onShow() {
                        setTextDrawableAndColor(tvHallType, true);
                        setTextDrawableAndColor(headerTvHallType, true);
                    }

                    @Override
                    public void onDismiss() {
                        if (hallType == -1 && serviceId == -1) {
                            setTextDrawableAndColor(tvHallType, false);
                            setTextDrawableAndColor(headerTvHallType, false);
                        }
                    }
                });
                break;
        }
    }

    /**
     * 设置字体颜色和右侧图标
     *
     * @param tv
     * @param show
     */
    private void setTextDrawableAndColor(TextView tv, boolean show) {
        Drawable drawable;
        int color;
        if (show) {
            drawable = getResources().getDrawable(R.drawable.ic_arrow_down_red);
            color = getResources().getColor(R.color.colorPrimary);
        } else {
            drawable = getResources().getDrawable(R.drawable.ic_arrow_down_solid);
            color = getResources().getColor(R.color.text_gray_deep);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv.setCompoundDrawables(null, null, drawable, null);
        tv.setTextColor(color);

    }

    //区域window
    private void createAreaWindow() {
        View areaContent = LayoutInflater.from(mContext).inflate(R.layout.layout_area_window, null);
        rvParent = (RecyclerView) areaContent.findViewById(R.id.rv_district);
        rvParent.setLayoutManager(new LinearLayoutManager(mContext));
        rvSub = (RecyclerView) areaContent.findViewById(R.id.rv_sub_district);
        rvSub.setLayoutManager(new LinearLayoutManager(mContext));
        TabLayout tabArea = (TabLayout) areaContent.findViewById(R.id.tab_area);
        tabArea.addTab(tabArea.newTab().setText("商圈"));
        tabArea.addTab(tabArea.newTab().setText("地铁站"));
        tabArea.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    rvParent.setAdapter(areaAdapter);
                    rvSub.setAdapter(areaSubAdapter);
                    if (mCurrentFilterData != null) {
                        setDistrictData(mCurrentFilterData);
                    }
                } else if (tab.getPosition() == 1) {
                    rvParent.setAdapter(metroAdapter);
                    rvSub.setAdapter(metroSubAdapter);
                    if (mCurrentFilterData != null) {
                        setMetroData(mCurrentFilterData);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        areaWindow = popupWindowUtils.createPopupWindow(areaContent, UiUtils.dp2px(mContext, 300));
        areaWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setTextDrawableAndColor(tvArea, false);
                setTextDrawableAndColor(headerTvArea, false);
            }
        });
    }

    //排序window
    private void createSortCondition() {
        View sortCondition = LayoutInflater.from(mContext).inflate(R.layout.layout_sort_condition, null);
        RecyclerView rvSortCondition = (RecyclerView) sortCondition.findViewById(R.id.rv_sort_condition);
        rvSortCondition.setLayoutManager(new LinearLayoutManager(mContext));
        SortConditionAdapter sortConditionAdapter = new SortConditionAdapter(generateSortCondition());
        rvSortCondition.setAdapter(sortConditionAdapter);
        sortConditionAdapter.setOnSortConditionClickListener(new SortConditionAdapter.OnSortConditionClickListener() {
            @Override
            public void onClick(SortConditionBean item) {

                headerTvSortCondition.setText(item.getName());
                tvSortCondition.setText(item.getName());
                offset = 0;
                sort = item.getCode();
                mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
                sortWindow.dismiss();
            }
        });
        sortWindow = popupWindowUtils.createPopupWindow(sortCondition, ViewGroup.LayoutParams.WRAP_CONTENT);
        sortWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setTextDrawableAndColor(tvSortCondition, false);
                setTextDrawableAndColor(headerTvSortCondition, false);
            }
        });
    }

    //品牌window
    private void createBrandWindow() {
        View brandContent = LayoutInflater.from(mContext).inflate(R.layout.layout_brand, null);
        RecyclerView rvBrand = (RecyclerView) brandContent.findViewById(R.id.rv_brand);
        rvBrand.setLayoutManager(new LinearLayoutManager(mContext));
        brandAdapter = new BrandAdapter();
        rvBrand.setAdapter(brandAdapter);

        brandAdapter.setOnBrandClickListener(new BrandAdapter.OnBrandClickListener() {
            @Override
            public void onClick(FilterBean.DataBean.BrandBean.SubItemsBean item) {
                String brandName;
                if (item.getId() == -1) {
                    brandName = "品牌";
                } else {
                    brandName = item.getName();
                }
                headerTvBrand.setText(brandName);
                tvBrand.setText(brandName);
                offset = 0;
                brandId = item.getId();
                mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
                brandWindow.dismiss();
            }
        });

        brandWindow = popupWindowUtils.createPopupWindow(brandContent, UIUtils.dp2px(mContext, 260));
        brandWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setTextDrawableAndColor(tvBrand, false);
                setTextDrawableAndColor(headerTvBrand, false);
            }
        });


    }

    //服务和影厅window
    private void createHallTypeWindow() {
        View hallTypeContent = LayoutInflater.from(mContext).inflate(R.layout.layout_hall_type, null);

        //特色功能
        RecyclerView rvService = (RecyclerView) hallTypeContent.findViewById(R.id.rv_service);
        rvService.setLayoutManager(new GridLayoutManager(mContext, 4));
        serviceAdapter = new ServiceAdapter();
        rvService.setAdapter(serviceAdapter);
        serviceAdapter.setOnServiceClickListener(new ServiceAdapter.OnServiceClickListener() {
            @Override
            public void onClick(FilterBean.DataBean.ServiceBean.SubItemsBeanXXXX item) {
                serviceId = item.getId();
            }
        });
        //影院类型
        RecyclerView rvHallType = (RecyclerView) hallTypeContent.findViewById(R.id.rv_hall_type);
        rvHallType.setLayoutManager(new GridLayoutManager(mContext, 4));
        hallTypeAdapter = new HallTypeAdapter();
        rvHallType.setAdapter(hallTypeAdapter);
        hallTypeAdapter.setOnHallTypeClickListener(new HallTypeAdapter.OnHallTypeClickListener() {
            @Override
            public void onClick(FilterBean.DataBean.HallTypeBean.SubItemsBeanXXX item) {
                hallType = item.getId();
            }
        });

        //重置
        hallTypeContent.findViewById(R.id.tv_reset)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int i = 1; i < serviceAdapter.getData().size(); i++) {
                            serviceAdapter.getData().get(i).isSelect = false;
                        }
                        for (int i = 1; i < hallTypeAdapter.getData().size(); i++) {
                            hallTypeAdapter.getData().get(i).isSelect = false;
                        }
                        serviceAdapter.getData().get(0).isSelect = true;
                        hallTypeAdapter.getData().get(0).isSelect = true;
                        serviceAdapter.selectedPos = 0;
                        hallTypeAdapter.selectedPos = 0;

                        serviceAdapter.notifyDataSetChanged();
                        hallTypeAdapter.notifyDataSetChanged();

                        offset = 0;
                        mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
                        hallTypeWindow.dismiss();

                    }
                });

        //确定
        hallTypeContent.findViewById(R.id.tv_confirm)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        offset = 0;
                        mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
                        hallTypeWindow.dismiss();
                    }
                });


        hallTypeWindow = popupWindowUtils.createPopupWindow(hallTypeContent, ViewGroup.LayoutParams.WRAP_CONTENT);
        hallTypeWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if (hallType == -1 && serviceId == -1) {
                    setTextDrawableAndColor(tvHallType, false);
                    setTextDrawableAndColor(headerTvHallType, false);
                }
            }
        });
    }

    /*
    创建排序条件集合
     */
    private List<SortConditionBean> generateSortCondition() {
        List<SortConditionBean> list = new ArrayList<>();
        SortConditionBean bean1 = new SortConditionBean();
        SortConditionBean bean2 = new SortConditionBean();
        SortConditionBean bean3 = new SortConditionBean();
        bean1.isSelect = true;
        bean1.setCode("distance");
        bean1.setName("离我最近");
        bean2.isSelect = false;
        bean2.setCode("price");
        bean2.setName("价格最低");
        bean3.isSelect = false;
        bean3.setCode("rating");
        bean3.setName("好评优先");
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        return list;
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
                mPresenter.getBanner(ci);
                mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
            }
        });
    }

    @Override
    public void addCinema(List<CinemaListBean.DataBean.CinemasBean> cinemasBeanList) {
        offset = 20;
        cinemaAdapter.setNewData(cinemasBeanList);
        //切换数据之后移动到列表第一位,同时将滑动距离设置为0
        rvCinema.scrollToPosition(0);
        mDistanceY = 0;

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
    public void addCinemaBanner(List<CinemaBannerBean.DataBean> data) {
        if (data != null && data.size() > 0) {
            List<Banner.BannerPicBean.PicBean> beanList = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                Banner.BannerPicBean.PicBean bean = new Banner.BannerPicBean.PicBean();
                bean.picUrl = data.get(i).getImgUrl();
                beanList.add(bean);
            }
            if (cinemaAdapter.getHeaderLayoutCount() == 1) {
                banner.setPic(beanList);
                cinemaAdapter.addHeaderView(banner, 0);
            }
        }
    }

    @Override
    public void addFilter(FilterBean filterBean) {
        mCurrentFilterData = filterBean;
        areaAdapter = new AreaAdapter();
        areaSubAdapter = new AreaSubAdapter();
        metroAdapter = new MetroAdapter();
        metroSubAdapter = new MetroSubAdapter();
        rvParent.setAdapter(areaAdapter);
        rvSub.setAdapter(areaSubAdapter);
        setDistrictData(filterBean);
        //品牌
        filterBean.getData().getBrand().getSubItems().get(0).isSelect = true;
        brandAdapter.setNewData(filterBean.getData().getBrand().getSubItems());
        //特色功能
        filterBean.getData().getService().getSubItems().get(0).isSelect = true;
        serviceAdapter.setNewData(filterBean.getData().getService().getSubItems());
        //特效厅
        filterBean.getData().getHallType().getSubItems().get(0).isSelect = true;
        hallTypeAdapter.setNewData(filterBean.getData().getHallType().getSubItems());

    }

    /**
     * 设置地铁筛选数据
     *
     * @param filterBean
     */
    private void setMetroData(FilterBean filterBean) {
        filterBean.getData().getSubway().getSubItems().get(0).isSelect = true;
        metroAdapter.setNewData(filterBean.getData().getSubway().getSubItems());
        metroAdapter.setOnMetroClickListener(new MetroAdapter.OnMetroClickListener() {
            @Override
            public void onClick(FilterBean.DataBean.SubwayBean.SubItemsBeanXXXXXX item) {
                mParentLineId = item.getId();
                lineText = item.getName();
                lineId = item.getId();
                if (item.getId() == -1) {
                    tvArea.setText("区域");
                    headerTvArea.setText("区域");
                    offset = 0;
                    districtId = -2;
                    stationId = -1;
                    mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
                    areaWindow.dismiss();

                }
                metroSubAdapter.setNewData(item.getSubItems());

            }
        });
        metroSubAdapter.setOnMetroSubClickListener(new MetroSubAdapter.OnMetroSubClickListener() {
            @Override
            public void onClick(FilterBean.DataBean.SubwayBean.SubItemsBeanXXXXXX.SubItemsBeanXXXXX item) {

                String tvName = item.getId() == -1 ? lineText : item.getName();
                tvArea.setText(tvName);
                headerTvArea.setText(tvName);
                offset = 0;
                districtId = -2;
                stationId = item.getId();
                if (item.getId() == -1) {
                    lineId = mParentLineId;
                    stationId = -1;
                }
                mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
                areaWindow.dismiss();
            }
        });
    }

    /**
     * 设置地区筛选的数据
     *
     * @param filterBean
     */
    private void setDistrictData(FilterBean filterBean) {
        filterBean.getData().getDistrict().getSubItems().get(0).isSelect = true;
        areaAdapter.setNewData(filterBean.getData().getDistrict().getSubItems());
        areaAdapter.setOnDistrictClickListener(new AreaAdapter.OnDistrictClickListener() {
            @Override
            public void onClick(FilterBean.DataBean.DistrictBean.SubItemsBeanXX item) {
                parentDistrictName = item.getName();
                districtId = item.getId();
                offset = 0;
                if (item.getId() == -1) {
                    tvArea.setText("区域");
                    headerTvArea.setText("区域");
                    lineId = -2;
                    areaId = -1;
                    mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
                    areaWindow.dismiss();
                }
                areaSubAdapter.setNewData(item.getSubItems());
            }
        });
        areaSubAdapter.setOnSubDistrictClickListener(new AreaSubAdapter.OnSubDistrictClickListener() {
            @Override
            public void onClick(FilterBean.DataBean.DistrictBean.SubItemsBeanXX.SubItemsBeanX item) {
                String tvName = item.getId() == -1 ? parentDistrictName : item.getName();
                tvArea.setText(tvName);
                headerTvArea.setText(tvName);
                offset = 0;
                areaId = item.getId();
                lineId = -2;
                mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
                areaWindow.dismiss();
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 32 && resultCode == 33) {
            tvCity.setText(data.getStringExtra("city_name"));
            ci = SPUtils.getInstance(mContext, Constants.SP_CITY).getInt(Constants.CITY_CODE, 20);
            mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
            mPresenter.getBanner(ci);
            mPresenter.getFilter(ci);
        } else if (requestCode == 56 && resultCode == 33) {
            tvCity.setText(data.getStringExtra("city_name"));
            ci = SPUtils.getInstance(mContext, Constants.SP_CITY).getInt(Constants.CITY_CODE, 20);
            mPresenter.getCinema(ci, offset, limit, lat, lng, districtId, areaId, sort, lineId, stationId, brandId, serviceId, hallType);
            mPresenter.getBanner(ci);
            mPresenter.getFilter(ci);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (banner != null) {
            banner.stopPlay();
        }
        if (locationUtil != null) {
            locationUtil.destroyLocation();
        }
    }


}

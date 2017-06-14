package com.cicinnus.cateye.module.movie.pick_city;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.base.Constants;
import com.cicinnus.cateye.tools.LocationUtil;
import com.cicinnus.cateye.tools.PermissionUtils;
import com.cicinnus.cateye.tools.ToastUtil;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.FloatingItemDecoration;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SlideBar;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;
import com.cicinnus.retrofitlib.utils.SPUtils;
import com.google.gson.Gson;

import java.lang.ref.WeakReference;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * 选择城市
 */

public class PickCityActivity extends BaseActivity<PickCityPresenter> implements PickCityContract.IPickCityView {


    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_city)
    RecyclerView rvCity;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.slideBar)
    SlideBar slideBar;
    @BindView(R.id.et_city_name)
    EditText etCityName;
    @BindView(R.id.iv_clear)
    ImageView ivClear;

    protected MyPullToRefreshListener pullToRefreshListener;
    private PickCityAdapter pickCityAdapter;
    //悬浮itemDecoration
    private FloatingItemDecoration floatingItemDecoration;
    //悬浮的item
    private HashMap<Integer, String> keys;
    private LinearLayoutManager llm;
    private HashMap<String, Integer> letterIndexes = new HashMap<>();
    private List<PickCityBean.CtsBean> mCurrentData;
    private View headerView;
    private LocationUtil locationUtil;
    private TextView tvLocationCity;


    public static void start(Activity context) {
        Intent starter = new Intent(context, PickCityActivity.class);
        context.startActivityForResult(starter, 32);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_pick_city;
    }

    @Override
    protected PickCityPresenter getPresenter() {
        return new PickCityPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        tvTitle.setText("选择城市");
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        pullToRefreshListener = new MyPullToRefreshListener(mContext, swipe);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getCity();
            }
        });
        swipe.setOnPullRefreshListener(pullToRefreshListener);
        initLocation();
        initRv();
        initEditText();
        mPresenter.getCity();
    }

    private void initLocation() {
        locationUtil = new LocationUtil(new WeakReference<>(mContext));
        new PermissionUtils(mContext,
                Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION) {
            @Override
            protected void permissionRefused() {

            }

            @Override
            protected void allGranted() {
                locationUtil.setOnLocationChangeListener(new LocationUtil.OnLocationChangeListener() {
                    @Override
                    public void onChange(AMapLocation amapLocation) {
                        // 定位
                        String cityName = amapLocation.getCity();
                        if (cityName.contains("市")) {
                            tvLocationCity.setText(String.format("%s", cityName.substring(0, cityName.indexOf("市"))));
                        }
                    }
                });
                locationUtil.startLocation();
            }
        };
    }

    private void initEditText() {

        etCityName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ivClear.setVisibility(s.length() > 0 ? View.VISIBLE : View.INVISIBLE);
                slideBar.setVisibility(s.length() > 0 ? View.GONE : View.VISIBLE);
                if (s.length() > 0) {
                    sortBySearch();
                } else {
                    sortData(mCurrentData);
                }
            }
        });


    }

    /**
     * 初始化列表和slideBar
     */

    private void initRv() {
        llm = new LinearLayoutManager(mContext);
        rvCity.setLayoutManager(llm);
        pickCityAdapter = new PickCityAdapter();
        rvCity.setAdapter(pickCityAdapter);

        pickCityAdapter.setOnCityClickListener(new PickCityAdapter.OnCityClickListener() {
            @Override
            public void onClick(PickCityBean.CtsBean item) {
                SPUtils.getInstance(mContext, Constants.SP_CITY)
                        .putString(Constants.CITY_NAME, item.getNm())
                        .putInt(Constants.CITY_CODE, item.getId())
                        .putString(Constants.CITY_PY, item.getPy())
                        .apply();
                Intent intent = new Intent();
                intent.putExtra("city_name", item.getNm());
                setResult(33, intent);
                finish();
            }
        });


        headerView = getLayoutInflater().inflate(R.layout.layout_city_header, (ViewGroup) rvCity.getParent(), false);
        //定位城市
        tvLocationCity = ((TextView) headerView.findViewById(R.id.tv_location_city));
        tvLocationCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("正在定位...")) {
                    tvLocationCity.setClickable(false);
                }else {
                    tvLocationCity.setClickable(true);
                }
            }
        });
        tvLocationCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = tvLocationCity.getText().toString().trim();
                boolean haveCity = false;
                for (int i = 0; i < mCurrentData.size(); i++) {
                    if (mCurrentData.get(i).getNm().contains(cityName) || mCurrentData.get(i).getNm().equals(cityName)) {
                        SPUtils.getInstance(mContext, Constants.SP_CITY)
                                .putString(Constants.CITY_NAME, mCurrentData.get(i).getNm())
                                .putInt(Constants.CITY_CODE, mCurrentData.get(i).getId())
                                .putString(Constants.CITY_PY, mCurrentData.get(i).getPy())
                                .apply();
                        haveCity = true;
                        Intent intent = new Intent();
                        intent.putExtra("city_name", mCurrentData.get(i).getNm());
                        setResult(33, intent);
                        finish();
                    }
                }
                if(!haveCity) {
                    ToastUtil.showToast("暂无当前定位城市信息,请手动选择最近的城市");
                }
            }
        });
        RecyclerView rvHotCity = (RecyclerView) headerView.findViewById(R.id.rv_hot_city);
        rvHotCity.setLayoutManager(new GridLayoutManager(mContext, 3));
        PickCityAdapter hotCityAdapter = new PickCityAdapter();
        hotCityAdapter.setNewData(generateHotCity());
        rvHotCity.setAdapter(hotCityAdapter);
        hotCityAdapter.setOnCityClickListener(new PickCityAdapter.OnCityClickListener() {
            @Override
            public void onClick(PickCityBean.CtsBean item) {
                SPUtils.getInstance(mContext, Constants.SP_CITY)
                        .putString(Constants.CITY_NAME, item.getNm())
                        .putInt(Constants.CITY_CODE, item.getId())
                        .putString(Constants.CITY_PY, item.getPy())
                        .apply();
                Intent intent = new Intent();
                intent.putExtra("city_name", item.getNm());
                setResult(33, intent);
                finish();
            }
        });

        floatingItemDecoration = new FloatingItemDecoration(mContext, mContext.getResources().getColor(R.color.divider_normal), 100, 1);
        floatingItemDecoration.setmTitleHeight(UiUtils.dp2px(mContext, 27));
        floatingItemDecoration.setShowFloatingHeaderOnScrolling(true);//悬浮
        rvCity.addItemDecoration(floatingItemDecoration);


        //右侧滑动选择
        slideBar.setOnTouchingLetterChangedListener(new SlideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s, int offset) {
                int position = letterIndexes.get(s) == null ? -1 : letterIndexes.get(s);
                llm.scrollToPositionWithOffset(position, offset);
            }
        });
    }

    /**
     * 热门城市
     *
     * @return
     */
    private List<PickCityBean.CtsBean> generateHotCity() {
        Gson gson = new Gson();
        PickCityBean pickCityBean = gson.fromJson(mContext.getResources().getString(R.string.hot_city_json), PickCityBean.class);
        return pickCityBean.getCts();
    }


    @OnClick({R.id.iv_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_clear:
                etCityName.setText("");
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
                mPresenter.getCity();
            }
        });
    }

    @Override
    public void addCity(List<PickCityBean.CtsBean> cts) {
        mCurrentData = cts;
        //将数据排序
        sortData(cts);

    }

    //排序
    private void sortData(List<PickCityBean.CtsBean> cts) {
        keys = new HashMap<>();
        Observable.fromIterable(cts)
                .toSortedList(new Comparator<PickCityBean.CtsBean>() {
                    @Override
                    public int compare(PickCityBean.CtsBean o1, PickCityBean.CtsBean o2) {
                        //a-z排序
                        String a = o1.getPy();
                        String b = o2.getPy();
                        return a.compareTo(b);
                    }
                })
                .subscribe(new Consumer<List<PickCityBean.CtsBean>>() {
                    @Override
                    public void accept(@NonNull List<PickCityBean.CtsBean> ctsBeen) throws Exception {
                        pickCityAdapter.addHeaderView(headerView);
                        pickCityAdapter.setNewData(ctsBeen);
                        //添加了头部,所以keys要从1开始
                        keys.put(1, "A");
                        letterIndexes.put("#", 0);
                        letterIndexes.put("A", 1);
                        for (int i = 0; i < ctsBeen.size(); i++) {
                            if (i < ctsBeen.size() - 1) {
                                //首字母不同,设为ky
                                String pre = ctsBeen.get(i).getPy().substring(0, 1).toUpperCase();
                                String next = ctsBeen.get(i + 1).getPy().substring(0, 1).toUpperCase();
                                if (!pre.equals(next)) {
                                    keys.put(i + 2, next);
                                    letterIndexes.put(next, i + 2);
                                }
                            }
                        }
                        floatingItemDecoration.setKeys(keys);

                    }
                });
    }

    //搜索后筛选
    private void sortBySearch() {
        Observable
                .fromIterable(mCurrentData)
                .filter(new Predicate<PickCityBean.CtsBean>() {
                    @Override
                    public boolean test(@NonNull PickCityBean.CtsBean ctsBean) throws Exception {
                        int length = etCityName.getText().length();
                        return ctsBean.getPy().substring(0, length).equalsIgnoreCase(etCityName.getText().toString().trim());
                    }
                })
                .toList()
                .subscribe(new Consumer<List<PickCityBean.CtsBean>>() {
                    @Override
                    public void accept(@NonNull List<PickCityBean.CtsBean> ctsBeen) throws Exception {
                        keys = new HashMap<Integer, String>();
                        keys.put(0, etCityName.getText().toString().trim().toUpperCase());
                        pickCityAdapter.removeAllHeaderView();
                        pickCityAdapter.setNewData(ctsBeen);
                        floatingItemDecoration.setKeys(keys);

                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationUtil.destroyLocation();
    }
}

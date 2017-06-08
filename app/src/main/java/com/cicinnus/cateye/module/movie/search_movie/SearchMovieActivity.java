package com.cicinnus.cateye.module.movie.search_movie;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.base.BaseSingleChoiceAdapter;
import com.cicinnus.cateye.base.BaseSingleChoiceBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/2/3.
 */

public class SearchMovieActivity extends BaseActivity<SearchMovieMVPPresenter> implements SearchMovieContract.ISearchMovieView {


    private static final String TYPE_ID = "type_id";
    private static final String NATION_ID = "nation_id";
    private static final String PERIOD_ID = "period_id";
    private static final String TYPE_TITLE = "type_title";
    private static final String NATION_TITLE = "nation_title";
    private static final String PERIOD_TITLE = "period_title";
    private MyPullToRefreshListener pullToRefreshListener;


    public static void startFromType(Context context, int id, String typeTitle) {
        Intent starter = new Intent(context, SearchMovieActivity.class);
        starter.putExtra(TYPE_ID, id);
        starter.putExtra(TYPE_TITLE, typeTitle);
        context.startActivity(starter);
    }

    public static void startFromNation(Context context, int id, String nationTitle) {
        Intent starter = new Intent(context, SearchMovieActivity.class);
        starter.putExtra(NATION_ID, id);
        starter.putExtra(NATION_TITLE, nationTitle);
        context.startActivity(starter);
    }

    public static void startFromPeriod(Context context, int id, String periodTitle) {
        Intent starter = new Intent(context, SearchMovieActivity.class);
        starter.putExtra(PERIOD_ID, id);
        starter.putExtra(PERIOD_TITLE, periodTitle);
        context.startActivity(starter);
    }

    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.rv_search_list)
    RecyclerView rvSearchList;
    @BindView(R.id.tv_classify_title)
    TextView tvTitle;


    /**
     * 单选Adapter
     */
    private BaseSingleChoiceAdapter singleChoiceAdapter1;
    private BaseSingleChoiceAdapter singleChoiceAdapter2;
    private BaseSingleChoiceAdapter singleChoiceAdapter3;
    private BaseSingleChoiceAdapter singleChoiceAdapter4;
    /**
     * 筛选列表Adapter
     */
    private ClassifySearchListAdapter classifySearchListAdapter;
    private int offset;//偏移量
    private int catId;//电影分类
    private int sourceId;//地区Id
    private int yearId;//年代Id
    private int sortId = 3;//好评、最新、热门
    private int mDistanceY = 0;//滑动距离
    private int showTitleHeight;//开始显示的高度
    private int titleHeight;//顶部标题的高度
    private boolean isFirst = true;//判断显示标题栏
    /**
     * 初次显示的数据
     */
    private int searchId;
    private int nationId;
    private int periodId;
    private String typeTitle;
    private String nationTitle;
    private String periodTitle;
    private String sortTitle = "好评";

    @Override
    protected int getLayout() {
        return R.layout.activity_search_movie;
    }

    @Override
    protected SearchMovieMVPPresenter getPresenter() {
        return new SearchMovieMVPPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        initSelectedData();
        initRecyclerView();
        mPresenter.getMovieTypeList();
        mPresenter.getClassifySearchList(offset, catId, sourceId, yearId, sortId);
    }

    /**
     * 获取初始化选中的的id和title
     */
    private void initSelectedData() {
        searchId = catId = getIntent().getIntExtra(TYPE_ID, 0);
        nationId = sourceId = getIntent().getIntExtra(NATION_ID, 0);
        periodId = yearId = getIntent().getIntExtra(PERIOD_ID, 0);
        typeTitle = getIntent().getStringExtra(TYPE_TITLE) == null ? "全部" : getIntent().getStringExtra(TYPE_TITLE);
        nationTitle = getIntent().getStringExtra(NATION_TITLE) == null ? "全部" : getIntent().getStringExtra(NATION_TITLE);
        periodTitle = getIntent().getStringExtra(PERIOD_TITLE) == null ? "全部" : getIntent().getStringExtra(PERIOD_TITLE);
    }

    /**
     * 各个RecyclerView的初始化
     */
    private void initRecyclerView() {
        final View header = mContext.getLayoutInflater().inflate(R.layout.layout_classify_search_header, (ViewGroup) rvSearchList.getParent(), false);
        RecyclerView rvSearchType = (RecyclerView) header.findViewById(R.id.rv_search_type);
        RecyclerView rvSearchNation = (RecyclerView) header.findViewById(R.id.rv_search_nation);
        RecyclerView rvSearchPeriod = (RecyclerView) header.findViewById(R.id.rv_search_period);
        RecyclerView rvSearchPoint = (RecyclerView) header.findViewById(R.id.rv_search_point);
        //影片类型
        singleChoiceAdapter1 = new BaseSingleChoiceAdapter();
        rvSearchType.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rvSearchType.setAdapter(singleChoiceAdapter1);
        singleChoiceAdapter1.setOnItemClickListener(new BaseSingleChoiceAdapter.OnItemClickListener() {
            @Override
            public void click(BaseSingleChoiceBean bean) {
                offset = 0;
                catId = bean.id;
                typeTitle = bean.content;
                classifySearchListAdapter.setNewData(new ArrayList<ClassifySearchBean.ListBean>());
                mPresenter.getClassifySearchList(offset, catId, sourceId, yearId, sortId);
            }
        });
        //地区
        singleChoiceAdapter2 = new BaseSingleChoiceAdapter();
        rvSearchNation.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rvSearchNation.setAdapter(singleChoiceAdapter2);
        singleChoiceAdapter2.setOnItemClickListener(new BaseSingleChoiceAdapter.OnItemClickListener() {
            @Override
            public void click(BaseSingleChoiceBean bean) {
                offset = 0;
                sourceId = bean.id;
                nationTitle = bean.content;
                classifySearchListAdapter.setNewData(new ArrayList<ClassifySearchBean.ListBean>());
                mPresenter.getClassifySearchList(offset, catId, sourceId, yearId, sortId);
            }
        });
        //年代
        singleChoiceAdapter3 = new BaseSingleChoiceAdapter();
        rvSearchPeriod.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rvSearchPeriod.setAdapter(singleChoiceAdapter3);
        singleChoiceAdapter3.setOnItemClickListener(new BaseSingleChoiceAdapter.OnItemClickListener() {
            @Override
            public void click(BaseSingleChoiceBean bean) {
                offset = 0;
                periodTitle = bean.content;
                yearId = bean.id;
                classifySearchListAdapter.setNewData(new ArrayList<ClassifySearchBean.ListBean>());
                mPresenter.getClassifySearchList(offset, catId, sourceId, yearId, sortId);
            }
        });
        //评分
        singleChoiceAdapter4 = new BaseSingleChoiceAdapter();
        rvSearchPoint.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rvSearchPoint.setAdapter(singleChoiceAdapter4);
        singleChoiceAdapter4.setOnItemClickListener(new BaseSingleChoiceAdapter.OnItemClickListener() {
            @Override
            public void click(BaseSingleChoiceBean bean) {
                offset = 0;
                sortTitle = bean.content;
                sortId = bean.id;
                classifySearchListAdapter.setNewData(new ArrayList<ClassifySearchBean.ListBean>());
                mPresenter.getClassifySearchList(offset, catId, sourceId, yearId, sortId);
            }
        });
        //筛选结果
        classifySearchListAdapter = new ClassifySearchListAdapter();
        rvSearchList.setLayoutManager(new LinearLayoutManager(mContext));
        rvSearchList.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));

        //滑动监听，显示title
        rvSearchList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                showTitleHeight = header.getHeight();
                titleHeight = tvTitle.getHeight();
                if (showTitleHeight < mDistanceY) {
                    //显示
                    tvTitle.setVisibility(View.VISIBLE);
                    if (isFirst) {
                        //第一次显示的时候才滑出来
                        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvTitle, "translationY", -titleHeight, 0);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();
                        isFirst = false;
                        String titleContent =
                                (typeTitle.equals("全部") ? "" : typeTitle + "·") +
                                        (nationTitle.equals("全部") ? "" : nationTitle + "·") +
                                        (periodTitle.equals("全部") ? "" : periodTitle + "·") +
                                        (sortTitle);
                        tvTitle.setText(titleContent);

                    }
                } else {
                    //隐藏
                    tvTitle.setVisibility(View.INVISIBLE);
                    isFirst = true;
                }
                mDistanceY += dy;
            }
        });

        rvSearchList.setAdapter(classifySearchListAdapter);
        classifySearchListAdapter.addHeaderView(header);
        classifySearchListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getClassifySearchList(offset, catId, sourceId, yearId, sortId);
            }
        },rvSearchList);

        pullToRefreshListener = new MyPullToRefreshListener(mContext,swipe);
        swipe.setOnPullRefreshListener(pullToRefreshListener);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getClassifySearchList(offset, catId, sourceId, yearId, sortId);

            }
        });

    }

    @OnClick({R.id.rl_back,R.id.rl_search})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_search:
                //TODO 跳转搜索页
                break;

        }
    }

    @Override
    public void addMovieType(List<MovieTypeBean.DataBean.TagListBean> tagList) {
        final List<BaseSingleChoiceBean> choiceBeanList = new ArrayList<>();
        BaseSingleChoiceBean singleChoiceBean = new BaseSingleChoiceBean();
        singleChoiceBean.id = -1;
        singleChoiceBean.content = "全部";
        singleChoiceBean.isSelect = searchId == 0;
        choiceBeanList.add(0, singleChoiceBean);

        Observable
                .fromIterable(tagList)
                .map(new Function<MovieTypeBean.DataBean.TagListBean, BaseSingleChoiceBean>() {
                    @Override
                    public BaseSingleChoiceBean apply(MovieTypeBean.DataBean.TagListBean tagListBean) {
                        BaseSingleChoiceBean bean = new BaseSingleChoiceBean();
                        bean.id = tagListBean.getTagId();
                        bean.content = tagListBean.getTagName();
                        bean.isSelect = searchId == tagListBean.getTagId();//判断是否与传过来的ID相等

                        return bean;
                    }
                })
                .toList()
                .subscribe(new Consumer<List<BaseSingleChoiceBean>>() {
                    @Override
                    public void accept(@NonNull List<BaseSingleChoiceBean> baseSingleChoiceBeen) throws Exception {
                        choiceBeanList.addAll(baseSingleChoiceBeen);
                        singleChoiceAdapter1.addData(choiceBeanList);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void addMovieNation(List<MovieTypeBean.DataBean.TagListBean> tagList) {
        final List<BaseSingleChoiceBean> choiceBeanList2 = new ArrayList<>();
        BaseSingleChoiceBean singleChoiceBean = new BaseSingleChoiceBean();
        singleChoiceBean.id = -1;
        singleChoiceBean.content = "全部";
        singleChoiceBean.isSelect = nationId == 0;

        choiceBeanList2.add(0, singleChoiceBean);

        Observable
                .fromIterable(tagList)
                .map(new Function<MovieTypeBean.DataBean.TagListBean, BaseSingleChoiceBean>() {
                    @Override
                    public BaseSingleChoiceBean apply(MovieTypeBean.DataBean.TagListBean tagListBean) {
                        BaseSingleChoiceBean bean = new BaseSingleChoiceBean();
                        bean.id = tagListBean.getTagId();
                        bean.content = tagListBean.getTagName();
                        bean.isSelect = nationId == tagListBean.getTagId();//判断是否与传过来的ID相等

                        return bean;
                    }
                })
                .toList()
                .subscribe(new Consumer<List<BaseSingleChoiceBean>>() {
                    @Override
                    public void accept(@NonNull List<BaseSingleChoiceBean> baseSingleChoiceBeen) throws Exception {
                        choiceBeanList2.addAll(baseSingleChoiceBeen);
                        singleChoiceAdapter2.addData(choiceBeanList2);
                    }
                });
    }

    @Override
    public void addMoviePeriod(List<MovieTypeBean.DataBean.TagListBean> tagList) {
        final List<BaseSingleChoiceBean> choiceBeanList3 = new ArrayList<>();
        BaseSingleChoiceBean singleChoiceBean = new BaseSingleChoiceBean();
        singleChoiceBean.id = -1;
        singleChoiceBean.content = "全部";
        singleChoiceBean.isSelect = periodId == 0;
        choiceBeanList3.add(0, singleChoiceBean);

        Observable
                .fromIterable(tagList)
                .map(new Function<MovieTypeBean.DataBean.TagListBean, BaseSingleChoiceBean>() {
                    @Override
                    public BaseSingleChoiceBean apply(MovieTypeBean.DataBean.TagListBean tagListBean) {
                        BaseSingleChoiceBean bean = new BaseSingleChoiceBean();
                        bean.id = tagListBean.getTagId();
                        bean.content = tagListBean.getTagName();
                        bean.isSelect = periodId == tagListBean.getTagId();//判断是否与传过来的ID相等
                        return bean;
                    }
                })
                .toList()
                .subscribe(new Consumer<List<BaseSingleChoiceBean>>() {
                    @Override
                    public void accept(@NonNull List<BaseSingleChoiceBean> baseSingleChoiceBeen) throws Exception {
                        choiceBeanList3.addAll(baseSingleChoiceBeen);

                        singleChoiceAdapter3.addData(choiceBeanList3);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void addMoviePoint(List<MovieTypeBean.DataBean.TagListBean> tagList) {
        final List<BaseSingleChoiceBean> choiceBeanList4 = new ArrayList<>();

        for (int i = 0; i < tagList.size(); i++) {
            BaseSingleChoiceBean bean = new BaseSingleChoiceBean();
            bean.id = tagList.get(i).getTagId();
            bean.content = tagList.get(i).getTagName();
            bean.isSelect = i == 0;
            choiceBeanList4.add(bean);
        }
        singleChoiceAdapter4.addData(choiceBeanList4);

    }

    @Override
    public void addClassifySearchData(List<ClassifySearchBean.ListBean> list) {
        if (list.size() > 0) {
            offset += 10;
            classifySearchListAdapter.addData(list);
            classifySearchListAdapter.loadMoreComplete();
        } else {
            classifySearchListAdapter.loadMoreEnd();
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
                mPresenter.getMovieTypeList();
            }
        });
    }
}

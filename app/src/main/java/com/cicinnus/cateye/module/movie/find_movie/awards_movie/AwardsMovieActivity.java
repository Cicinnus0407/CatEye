package com.cicinnus.cateye.module.movie.find_movie.awards_movie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsBean;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsMovieListBean;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.CircleImageView;
import com.cicinnus.cateye.view.FloatingItemDecoration;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/2/6.
 */

public class AwardsMovieActivity extends BaseActivity<AwardsMoviePresenter> implements AwardsMovieContract.IAwardsMovieView {


    private static final String FESTIVAL_ID = "festivalId";
    private static final String FESTSESSION_ID = "festSessionId";
    private MyPullToRefreshListener pullListener;


    public static void start(Context context, int festivalId, int festSessionId) {
        Intent starter = new Intent(context, AwardsMovieActivity.class);
        starter.putExtra(FESTIVAL_ID, festivalId);
        starter.putExtra(FESTSESSION_ID, festSessionId);
        context.startActivity(starter);
    }


    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.rv_awards_movie)
    RecyclerView rvAwardsMovie;
    @BindView(R.id.ll_switch)
    LinearLayout llSwitch;
    @BindView(R.id.iv_next)
    ImageView ivNext;
    @BindView(R.id.iv_previous)
    ImageView ivPrevious;
    @BindView(R.id.tv_currentSession)
    TextView currentSession;

    private AwardsMovieListAdapter awardsMovieListAdapter;

    private int festSessionId;//奖项Id
    private int offset = 0;//偏移量
    private FloatingItemDecoration floatingItemDecoration;//分组分割线
    private HashMap<Integer, String> keys;//分组分割线的key
    private List<AwardsBean.DataBean.FestSessionsBean> awardsList;//历届奖项数据


    private CircleImageView cirAwardImg;//奖项图标
    private TextView tvAwardTitle;//奖项标题
    private int festivalId;//奖项id
    private TextView tvAwardContent;//奖项描述
    private int currentIndex;//当前届
    private TextView tvHeldDateLocation;//举办的时间地点
    private TextView tvFestSession;//第x届
    private boolean canPrevious = false;//能够向上
    private boolean canNext = true;//能向下

    @Override
    protected int getLayout() {
        return R.layout.activity_awards_movie;
    }


    @Override
    protected AwardsMoviePresenter getPresenter() {
        return new AwardsMoviePresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        tv_title.setText("电影奖项");
        festSessionId = getIntent().getIntExtra(FESTSESSION_ID, 0);
        festivalId = getIntent().getIntExtra(FESTIVAL_ID, 0);

        /**
         * adapter
         */
        awardsMovieListAdapter = new AwardsMovieListAdapter();
        rvAwardsMovie.setAdapter(awardsMovieListAdapter);
        rvAwardsMovie.setLayoutManager(new LinearLayoutManager(mContext));
        //分割线
        initDecoration();
        //头部
        initHeader();
        //下拉刷新
        initPullToRefresh();
        //加载更多
        awardsMovieListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMoreAwardsMovie(festSessionId, 10, offset);
            }
        });
        awardsList = new ArrayList<>();

        mPresenter.getAwardsMovie(festSessionId, 10, offset);
        mPresenter.getAwards(festivalId);

    }

    /**
     * 下拉刷新
     */
    private void initPullToRefresh() {
        pullListener = new MyPullToRefreshListener(mContext, swipe);
        swipe.setOnPullRefreshListener(pullListener);
        pullListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                offset = 0;
                awardsMovieListAdapter.setNewData(new ArrayList<AwardsMovieListBean.DataBean.AwardsBean>());
                mPresenter.getAwardsMovie(festSessionId, 10, offset);
            }
        });
    }

    @OnClick({R.id.rl_back, R.id.iv_previous, R.id.iv_next})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.iv_previous:
                if (canPrevious) {
                    canNext = true;
                    currentIndex -= 1;
                    if (currentIndex == 0) {
                        currentIndex = 0;
                        canPrevious = false;
                    }
//                    Log.d("奖项", "onClick: " + currentIndex);
                    currentSession.setText(String.format("第%s届", awardsList.get(currentIndex).getSessionNum()));
                    tvFestSession.setText(String.format("第%s届", awardsList.get(currentIndex).getSessionNum()));
                    tvHeldDateLocation.setText(String.format("%s %s", awardsList.get(currentIndex).getHeldDate(), awardsList.get(currentIndex).getHeldAddress()));
                    festSessionId = awardsList.get(currentIndex).getFestSessionId();
                    offset = 0;
                    awardsMovieListAdapter.setNewData(new ArrayList<AwardsMovieListBean.DataBean.AwardsBean>());
                    mPresenter.getAwardsMovie(festSessionId, 10, offset);

                }
                break;
            case R.id.iv_next:
                if (canNext) {
                    canPrevious = true;
                    currentIndex += 1;
                    if (currentIndex == awardsList.size()) {
                        currentIndex = awardsList.size();
                        canNext = false;
                        return;
                    }
//                    Log.d("奖项", "onClick: " + currentIndex);
                    currentSession.setText(String.format("第%s届", awardsList.get(currentIndex).getSessionNum()));
                    tvFestSession.setText(String.format("第%s届", awardsList.get(currentIndex).getSessionNum()));
                    tvHeldDateLocation.setText(String.format("%s %s", awardsList.get(currentIndex).getHeldDate(), awardsList.get(currentIndex).getHeldAddress()));
                    festSessionId = awardsList.get(currentIndex).getFestSessionId();
                    offset = 0;
                    awardsMovieListAdapter.setNewData(new ArrayList<AwardsMovieListBean.DataBean.AwardsBean>());
                    mPresenter.getAwardsMovie(festSessionId, 10, offset);
                }
                break;
        }
    }

    /**
     * 分割线
     */
    private void initDecoration() {
        floatingItemDecoration = new FloatingItemDecoration(mContext, mContext.getResources().getColor(R.color.divider_normal), 100, 1);
        floatingItemDecoration.setmTitleHeight(UiUtils.dp2px(mContext, 27));
        floatingItemDecoration.setShowFloatingHeaderOnScrolling(false);//不悬浮
        rvAwardsMovie.addItemDecoration(floatingItemDecoration);
    }

    /**
     * 头部
     */
    private void initHeader() {
        View headerView = getLayoutInflater().inflate(R.layout.item_awards_section_header, (ViewGroup) rvAwardsMovie.getParent(), false);
        cirAwardImg = (CircleImageView) headerView.findViewById(R.id.civ_award_img);
        tvAwardTitle = (TextView) headerView.findViewById(R.id.tv_award_title);
        tvAwardContent = (TextView) headerView.findViewById(R.id.tv_award_desc);
        tvFestSession = (TextView) headerView.findViewById(R.id.tv_festSession);
        tvHeldDateLocation = (TextView) headerView.findViewById(R.id.tv_heldDate_location);
        awardsMovieListAdapter.addHeaderView(headerView);
    }

    @Override
    public void addAwardsMovie(AwardsMovieListBean.DataBean data) {
        festSessionId = data.getAwards().get(0).getFestSessionId();
        keys = new HashMap<>();
        keys.put(1, data.getAwards().get(0).getPrizeName());
        //根据item不用的获奖类型进行key的设置
        for (int i = 0; i < data.getAwards().size(); i++) {
            if (i < data.getAwards().size() - 1) {
                if (!data.getAwards().get(i).getPrizeName().equals(data.getAwards().get(i + 1).getPrizeName())) {
                    keys.put(i + 2, data.getAwards().get(i + 1).getPrizeName());
                }
            }
        }
        offset += 10;
        awardsMovieListAdapter.addData(data.getAwards());
        awardsMovieListAdapter.loadMoreComplete();
        floatingItemDecoration.setKeys(keys);
    }

    @Override
    public void addMoreAwardsMovie(AwardsMovieListBean.DataBean data) {
        //加载更多的时候先从上一次的dataSize开始遍历
        int dataSize = awardsMovieListAdapter.getData().size();
        if (data.getAwards().size() > 0) {
            for (int i = dataSize; i < data.getAwards().size() + dataSize; i++) {
                if (i < data.getAwards().size() + dataSize - 1) {
                    //因为是从dataSize开始遍历，所以get（i）方法需要减去dataSize，否则会outOfIndext
                    if (!data.getAwards().get(i - dataSize).getPrizeName().equals(data.getAwards().get(i + 1 - dataSize).getPrizeName())) {
                        keys.put(i + 2, data.getAwards().get(i + 1 - dataSize).getPrizeName());
                    }
                }
            }
            offset += 10;
            awardsMovieListAdapter.addData(data.getAwards());
            floatingItemDecoration.setKeys(keys);
            awardsMovieListAdapter.loadMoreComplete();
        } else {
            awardsMovieListAdapter.loadMoreEnd();
        }
    }

    @Override
    public void addAwardTitle(AwardsBean.DataBean data) {
        //加载历届奖项数据
        awardsList.addAll(data.getFestSessions());
        currentSession.setText(String.format("第%s届", awardsList.get(currentIndex).getSessionNum()));
        for (int i = 0; i < data.getFestSessions().size(); i++) {
            if (data.getFestSessions().get(i).getFestSessionId() == festSessionId) {
                festSessionId = data.getFestSessions().get(i).getFestSessionId();
                tvFestSession.setText(String.format("第%s届", data.getFestSessions().get(i).getSessionNum()));
                tvHeldDateLocation.setText(String.format("%s %s", data.getFestSessions().get(i).getHeldDate(), data.getFestSessions().get(i).getHeldAddress()));
                break;
            }
        }
        tvAwardTitle.setText(data.getCnm());
        tvAwardContent.setText(data.getIntro());
        GlideManager.loadImage(mContext, data.getIcon(), cirAwardImg);
    }

    @Override
    public void showLoading() {
        if (!swipe.isRefreshing()) {
            //不是下拉刷新的时候显示loading界面
            progressLayout.showLoading();
        }

    }

    @Override
    public void showContent() {
        pullListener.refreshDone();
        if (llSwitch.getVisibility() == View.INVISIBLE) {
            llSwitch.setVisibility(View.VISIBLE);
        }
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        pullListener.refreshDone();
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getAwardsMovie(festSessionId, 50, offset);
                mPresenter.getAwards(festivalId);
            }
        });
    }
}

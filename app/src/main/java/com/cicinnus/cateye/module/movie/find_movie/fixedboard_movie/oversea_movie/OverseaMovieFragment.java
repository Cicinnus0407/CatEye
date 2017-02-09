package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaComingMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;
import com.cicinnus.cateye.net.SchedulersCompat;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.FloatingItemDecoration;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMovieFragment extends BaseFragment<OverseaMoviePresenter> implements OverseaMovieContract.IOverseaMovieView {




    private static final String AREA = "area";



    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.rv_oversea_movie)
    RecyclerView rvOverseaMovie;

    private OverseaMovieAdapter overseaMovieAdapter;
    private MyPullToRefreshListener pullToRefreshListener;
    private String area;
    private FloatingItemDecoration floatingItemDecoration;
    private HashMap<Integer,String> keys;
    private boolean isFirst = true;

    public static OverseaMovieFragment newInstance(String area) {

        Bundle args = new Bundle();
        args.putString(AREA, area);
        OverseaMovieFragment fragment = new OverseaMovieFragment();
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    protected int getLayoutId() {
        return R.layout.fragment_oversea_movie;
    }

    @Override
    protected OverseaMoviePresenter getPresenter() {
        return new OverseaMoviePresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        area = getArguments().getString(AREA);

        overseaMovieAdapter = new OverseaMovieAdapter();
        rvOverseaMovie.setLayoutManager(new LinearLayoutManager(mContext));
        rvOverseaMovie.setAdapter(overseaMovieAdapter);


        floatingItemDecoration = new FloatingItemDecoration(mContext);
        floatingItemDecoration.setmTitleHeight(UiUtils.dp2px(mContext,27));
        floatingItemDecoration.setShowFloatingHeaderOnScrolling(false);
        keys = new HashMap<>();
        rvOverseaMovie.addItemDecoration(floatingItemDecoration);
        pullToRefreshListener = new MyPullToRefreshListener(mContext, swipe);
        swipe.setOnPullRefreshListener(pullToRefreshListener);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                overseaMovieAdapter.setNewData(new ArrayList<OverseaHotMovieBean.DataBean.HotBean>());
                mPresenter.getOverseaMovie(area);
            }
        });
        if(area.equals("NA")){
            mPresenter.getOverseaMovie(area);
        }
    }

    private String getArea(String area){
        switch (area){
            case "NA":
                return "美国";
            case "KR":
                return "韩国";
            case "JP":
                return "日本";
            default:
                return "";

        }
    }

    @Override
    protected void lazyLoadEveryTime() {
        if(isFirst) {
            mPresenter.getOverseaMovie(area);
            isFirst = false;
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
            public void onClick(View view) {
                mPresenter.getOverseaMovie(area);
            }
        });
    }

    @Override
    public void addOverseaHotMovie(List<OverseaHotMovieBean.DataBean.HotBean> hot) {
        keys.put(0,String.format("%s热映",getArea(area)));
        floatingItemDecoration.setKeys(keys);
        if(hot.size()>=10){
            OverseaHotMovieBean.DataBean.HotBean footer= new OverseaHotMovieBean.DataBean.HotBean();
            footer.setFooterName("查看全部热映影片");
            footer.setType("hot");
            footer.setArea(area);
            hot.add(footer);
        }
        overseaMovieAdapter.addData(hot);
    }

    @Override
    public void addOverseaComingMovie(List<OverseaComingMovieBean.DataBean.ComingBean> coming) {
        Observable.from(coming)
                .map(new Func1<OverseaComingMovieBean.DataBean.ComingBean, OverseaHotMovieBean.DataBean.HotBean>() {
                    @Override
                    public OverseaHotMovieBean.DataBean.HotBean call(OverseaComingMovieBean.DataBean.ComingBean comingBean) {
                        OverseaHotMovieBean.DataBean.HotBean hotBean = new OverseaHotMovieBean.DataBean.HotBean();
                        List<OverseaHotMovieBean.DataBean.HotBean.HeadLinesVOBean> headLineList = new ArrayList<>();
                        if(comingBean.getHeadLinesVO()!=null) {
                            for (int i = 0; i < comingBean.getHeadLinesVO().size(); i++) {
                                OverseaHotMovieBean.DataBean.HotBean.HeadLinesVOBean headLinesVOBean =
                                        new OverseaHotMovieBean.DataBean.HotBean.HeadLinesVOBean();

                                headLinesVOBean.setMovieId(comingBean.getHeadLinesVO().get(i).getMovieId());
                                headLinesVOBean.setTitle(comingBean.getHeadLinesVO().get(i).getTitle());
                                headLinesVOBean.setType(comingBean.getHeadLinesVO().get(i).getType());
                                headLinesVOBean.setUrl(comingBean.getHeadLinesVO().get(i).getUrl());
                                headLineList.add(headLinesVOBean);
                            }
                        }
                        hotBean.setImg(comingBean.getImg());
                        hotBean.setHeadLinesVO(headLineList);
                        hotBean.setStar(comingBean.getStar());
                        hotBean.setShowst(comingBean.getShowst());
                        hotBean.setWish(comingBean.getWish());
                        hotBean.setVideourl(comingBean.getVideourl());
                        hotBean.setVideoName(comingBean.getVideoName());
                        hotBean.setStar(comingBean.getStar());
                        hotBean.setNm(comingBean.getNm());
                        return hotBean;
                    }
                })
                .toList()
                .compose(SchedulersCompat.<List<OverseaHotMovieBean.DataBean.HotBean>>applyIoSchedulers())
                .subscribe(new Subscriber<List<OverseaHotMovieBean.DataBean.HotBean>>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.getMessage());
                    }

                    @Override
                    public void onNext(List<OverseaHotMovieBean.DataBean.HotBean> hotBeen) {
                        keys.put(overseaMovieAdapter.getData().size(),String.format("%s待映",getArea(area)));
                        floatingItemDecoration.setKeys(keys);
                        if(hotBeen.size()>=10){
                            OverseaHotMovieBean.DataBean.HotBean footer= new OverseaHotMovieBean.DataBean.HotBean();
                            footer.setFooterName("查看全部待映影片");
                            footer.setType("coming");
                            footer.setArea(area);
                            hotBeen.add(footer);
                        }
                        overseaMovieAdapter.addData(hotBeen);
                    }
                });
    }
}

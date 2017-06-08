package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.oversea_movie_total_list;

import android.content.Context;
import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.base.BaseRecyclerViewActivity;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaComingMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/9.
 */

public class OverSeaMovieListActivity extends BaseRecyclerViewActivity<OverseaMovieListMVPPresenter> implements OverseaMovieListContract.IOverseaMovieListView{


    private static final String AREA = "area";
    private static final String TYPE = "type";
    private static final String HOT = "hot";
    private static final String COMING = "coming";
    private String area;
    private int limit = 10;
    private int offset ;
    private OverseaMovieHotListAdapter hotListAdapter;
    private OverseaMovieComingListAdapter comingListAdapter;
    private String type;


    public static void start(Context context,String area,String type) {
        Intent starter = new Intent(context, OverSeaMovieListActivity.class);
        starter.putExtra(AREA,area);
        starter.putExtra(TYPE,type);
        context.startActivity(starter);
    }


    @Override
    protected OverseaMovieListMVPPresenter getMPresenter() {
        return new OverseaMovieListMVPPresenter(mContext,this);
    }

    @Override
    protected void initEventAndData() {
        area = getIntent().getStringExtra(AREA);
        type = getIntent().getStringExtra(TYPE);
        super.initEventAndData();
        switchType(type);
    }

    private void switchType(String type){
        switch (type){
            case HOT:
                hotListAdapter = new OverseaMovieHotListAdapter();
                rvBaseRecyclerView.setAdapter(hotListAdapter);
                hotListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                    @Override
                    public void onLoadMoreRequested() {
                        ((OverseaMovieListMVPPresenter) mPresenter).getOverseaHotMovieList(area,limit,offset);
                    }
                },rvBaseRecyclerView);
                ((OverseaMovieListMVPPresenter) mPresenter).getOverseaHotMovieList(area,limit,offset);
                break;
            case COMING:
                comingListAdapter = new OverseaMovieComingListAdapter();
                rvBaseRecyclerView.setAdapter(comingListAdapter);
                comingListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                    @Override
                    public void onLoadMoreRequested() {
                        ((OverseaMovieListMVPPresenter) mPresenter).getOverseaComingMovieList(area,limit,offset);
                    }
                },rvBaseRecyclerView);
                ((OverseaMovieListMVPPresenter) mPresenter).getOverseaComingMovieList(area,limit,offset);
                break;
        }
    }


    @Override
    protected void setPullToRefresh() {
        offset = 0;
        switch (type){
            case HOT:
                ((OverseaMovieListMVPPresenter) mPresenter).getOverseaHotMovieList(area,limit,offset);
                break;
            case COMING:
                ((OverseaMovieListMVPPresenter) mPresenter).getOverseaComingMovieList(area,limit,offset);
                break;
        }
    }


    @Override
    protected String getTitleText() {
        return type.equals(HOT)?switchAreaToName()+"热映电影":switchAreaToName()+"待映电影";
    }

    private String switchAreaToName(){
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
    protected void onErrorResetData() {
        offset = 0;
        switch (type){
            case HOT:
                ((OverseaMovieListMVPPresenter) mPresenter).getOverseaHotMovieList(area,limit,offset);
                break;
            case COMING:
                ((OverseaMovieListMVPPresenter) mPresenter).getOverseaComingMovieList(area,limit,offset);
                break;
        }
    }

    @Override
    public void addOverseaHotMovieList(List<OverseaHotMovieBean.DataBean.HotBean> hot) {
        if(hot.size()>0){
            offset+=10;
            hotListAdapter.addData(hot);
            hotListAdapter.loadMoreComplete();
        }else {
            hotListAdapter.loadMoreEnd();
        }
    }

    @Override
    public void addOverseaComingMovieList(List<OverseaComingMovieBean.DataBean.ComingBean> coming) {
        if(coming.size()>0){
            offset+=10;
            comingListAdapter.addData(coming);
            comingListAdapter.loadMoreComplete();
        }else {
            comingListAdapter.loadMoreEnd();
        }
    }

    @Override
    protected void onPause() {
        overridePendingTransition(0,0);
        super.onPause();
    }
}

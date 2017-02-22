package com.cicinnus.cateye.module.movie.movie_detail.movie_resource;

import android.content.Context;
import android.content.Intent;

import com.cicinnus.cateye.base.BaseRecyclerViewActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.adapter.MovieDialoguesAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.adapter.MovieHighLightsAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.adapter.MovieParentGuidancesAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.adapter.MovieRelatedCompaniesAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.adapter.MovieTechnicalsAdapter;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.CompaniesSection;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieDialoguesBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieHighLightsBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieParentGuidancesBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieRelatedCompanies;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieTechnicalsBean;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieResourceActivity extends BaseRecyclerViewActivity<MovieResourcePresenter> implements MovieResourceContract.IMovieResourceView {


    private static final String MOVIE_ID = "movie_id";
    private static final String RESOURCE_TYPE = "resource_type";
    private int movieId;

    public static void start(Context context, int movieId, String resourceType) {
        Intent starter = new Intent(context, MovieResourceActivity.class);
        starter.putExtra(MOVIE_ID, movieId);
        starter.putExtra(RESOURCE_TYPE, resourceType);
        context.startActivity(starter);
    }

    private String resource_type;
    private String mTitle;
    private MovieTechnicalsAdapter technicalsAdapter;//技术参数
    private MovieDialoguesAdapter movieDialoguesAdapter;//经典台词
    private MovieRelatedCompaniesAdapter relatedCompaniesAdapter;//出品发行
    private MovieParentGuidancesAdapter parentGuidancesAdapter;//家长指引
    private MovieHighLightsAdapter highLightsAdapter;//幕后花絮

    @Override
    protected MovieResourcePresenter getMPresenter() {
        return new MovieResourcePresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        movieId = getIntent().getIntExtra(MOVIE_ID, 0);
        resource_type = getIntent().getStringExtra(RESOURCE_TYPE);
        getDataFromDifferentType();
        super.initEventAndData();

    }

    @Override
    protected void setPullToRefresh() {
        getDataFromDifferentType();
    }

    @Override
    protected String getTitleText() {
        return mTitle;
    }

    @Override
    protected void onErrorResetData() {
        getDataFromDifferentType();
    }

    @Override
    public void addMovieTechnicals(MovieTechnicalsBean.DataBean technicalsBeanData) {
        technicalsAdapter.setNewData(technicalsBeanData.getItems());

    }

    @Override
    public void addMovieDialogues(List<MovieDialoguesBean.DataBean> movieDialoguesBeanData) {
        Observable.from(movieDialoguesBeanData)
                .limit(1)
                .subscribe(new Action1<MovieDialoguesBean.DataBean>() {
                    @Override
                    public void call(MovieDialoguesBean.DataBean dataBean) {
                        movieDialoguesAdapter.setNewData(dataBean.getItems());
                    }
                });

    }

    @Override
    public void addMovieRelatedCompanies(List<MovieRelatedCompanies.DataBean> movieRelatedCompaniesData) {
        List<CompaniesSection> sectionList = new ArrayList<>();
        for (int i = 0; i < movieRelatedCompaniesData.size(); i++) {
            sectionList.add(new CompaniesSection(true, movieRelatedCompaniesData.get(i).getCmpTypeName()));
            for (int j = 0; j < movieRelatedCompaniesData.get(i).getItems().size(); j++) {
                sectionList.add(new CompaniesSection(movieRelatedCompaniesData.get(i).getItems().get(j)));
            }
        }
        relatedCompaniesAdapter.setNewData(sectionList);
    }

    @Override
    public void addMovieParentGuidances(List<MovieParentGuidancesBean.DataBean.GovBean> govBeanList) {
        parentGuidancesAdapter.setNewData(govBeanList);
    }

    @Override
    public void addMovieHighLights(List<MovieHighLightsBean.DataBean> movieHighLightsBeanData) {
        Observable.from(movieHighLightsBeanData)
                .limit(1)
                .subscribe(new Action1<MovieHighLightsBean.DataBean>() {
                    @Override
                    public void call(MovieHighLightsBean.DataBean dataBean) {
                        highLightsAdapter.setNewData(dataBean.getItems());
                    }
                });
    }

    /**
     * 判断不同的类型请求不同数据
     */
    private void getDataFromDifferentType() {
        switch (resource_type) {
            case "highlights":
                mTitle = "幕后花絮";
                if (highLightsAdapter == null) {
                    highLightsAdapter = new MovieHighLightsAdapter();
                    rvBaseRecyclerView.setAdapter(highLightsAdapter);
                }
                ((MovieResourcePresenter) mPresenter).getMovieHighLights(movieId);
                break;
            case "technicals":
                mTitle = "技术参数";
                if (technicalsAdapter == null) {
                    technicalsAdapter = new MovieTechnicalsAdapter();
                    rvBaseRecyclerView.setAdapter(technicalsAdapter);
                }
                ((MovieResourcePresenter) mPresenter).getMovieTechnicals(movieId);
                break;
            case "dialogues":
                mTitle = "经典台词";
                if (movieDialoguesAdapter == null) {
                    movieDialoguesAdapter = new MovieDialoguesAdapter();
                    rvBaseRecyclerView.setAdapter(movieDialoguesAdapter);
                }
                ((MovieResourcePresenter) mPresenter).getMovieDialogues(movieId);
                break;
            case "relatedCompanies":
                mTitle = "出品发行";
                if (relatedCompaniesAdapter == null) {
                    relatedCompaniesAdapter = new MovieRelatedCompaniesAdapter();
                    rvBaseRecyclerView.setAdapter(relatedCompaniesAdapter);
                }
                ((MovieResourcePresenter) mPresenter).getMovieRelatedCompanies(movieId);
                break;
            case "parentguidances":
                mTitle = "家长指引";
                if (parentGuidancesAdapter == null) {
                    parentGuidancesAdapter = new MovieParentGuidancesAdapter();
                    rvBaseRecyclerView.setAdapter(parentGuidancesAdapter);
                }
                ((MovieResourcePresenter) mPresenter).getMovieParentGuidances(movieId);
                break;
        }
    }


}

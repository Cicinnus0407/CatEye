package com.cicinnus.cateye.module.movie.search_movie;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;
import com.cicinnus.cateye.tools.ErrorHanding;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/2/3.
 */

public class SearchMoviePresenter extends BasePresenter<SearchMovieContract.ISearchMovieView> implements SearchMovieContract.ISearchMoviePresenter {

    private final SearchMovieManager searchMovieManager;

    public SearchMoviePresenter(Activity activity, SearchMovieContract.ISearchMovieView view) {
        super(activity, view);
        searchMovieManager = new SearchMovieManager();
    }

    @Override
    public void getMovieTypeList() {
        mView.showLoading();
        addSubscribe(searchMovieManager.getMovieTypeList()
                .subscribe(new Subscriber<MovieTypeBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(ErrorHanding.handleError(e));
                    }

                    @Override
                    public void onNext(MovieTypeBean movieTypeBean) {
                        mView.addMovieType(movieTypeBean.getData().get(0).getTagList());
                        mView.addMovieNation(movieTypeBean.getData().get(1).getTagList());
                        mView.addMoviePeriod(movieTypeBean.getData().get(2).getTagList());
                        mView.addMoviePoint(movieTypeBean.getData().get(3).getTagList());
                    }
                }));
    }

    @Override
    public void getClassifySearchList(int offset, int catId, int sourceId, int yearId, int sortId) {
        mView.showLoading();
        addSubscribe(searchMovieManager.getClassifySearchList(offset, catId, sourceId, yearId, sortId)
                .subscribe(new Subscriber<ClassifySearchBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(ErrorHanding.handleError(e));
                    }

                    @Override
                    public void onNext(ClassifySearchBean classifySearchBean) {
                        mView.addClassifySearchData(classifySearchBean.getList());
                    }
                }));
    }



}

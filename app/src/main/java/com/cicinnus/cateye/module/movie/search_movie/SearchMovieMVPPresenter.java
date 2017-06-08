package com.cicinnus.cateye.module.movie.search_movie;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;
import com.cicinnus.cateye.tools.ErrorHanding;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Administrator on 2017/2/3.
 */

public class SearchMovieMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<SearchMovieContract.ISearchMovieView> implements SearchMovieContract.ISearchMoviePresenter {

    private final SearchMovieManager searchMovieManager;

    public SearchMovieMVPPresenter(Activity activity, SearchMovieContract.ISearchMovieView view) {
        super(activity, view);
        searchMovieManager = new SearchMovieManager();
    }

    @Override
    public void getMovieTypeList() {
        mView.showLoading();
        addSubscribeUntilDestroy(searchMovieManager.getMovieTypeList()
                .subscribe(new Consumer<MovieTypeBean>() {
                    @Override
                    public void accept(@NonNull MovieTypeBean movieTypeBean) throws Exception {
                        mView.addMovieType(movieTypeBean.getData().get(0).getTagList());
                        mView.addMovieNation(movieTypeBean.getData().get(1).getTagList());
                        mView.addMoviePeriod(movieTypeBean.getData().get(2).getTagList());
                        mView.addMoviePoint(movieTypeBean.getData().get(3).getTagList());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.showError(ErrorHanding.handleError(throwable));

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        mView.showContent();
                    }
                }));
    }

    @Override
    public void getClassifySearchList(int offset, int catId, int sourceId, int yearId, int sortId) {
        mView.showLoading();
        addSubscribeUntilDestroy(searchMovieManager.getClassifySearchList(offset, catId, sourceId, yearId, sortId)
                .subscribe(new Consumer<ClassifySearchBean>() {
                    @Override
                    public void accept(@NonNull ClassifySearchBean classifySearchBean) throws Exception {
                        mView.addClassifySearchData(classifySearchBean.getList());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.showError(ErrorHanding.handleError(throwable));

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        mView.showContent();
                    }
                }));
    }



}

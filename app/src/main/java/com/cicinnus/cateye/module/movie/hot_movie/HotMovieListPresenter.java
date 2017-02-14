package com.cicinnus.cateye.module.movie.hot_movie;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.tools.ErrorHanding;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Cicinnus on 2017/1/24.
 */

public class HotMovieListPresenter extends BasePresenter<HotMovieListContract.IHotMovieListView> implements HotMovieListContract.IHotMoviePresenter {

    private final HotMovieListManager hotMovieListManager;

    public HotMovieListPresenter(Activity activity, HotMovieListContract.IHotMovieListView view) {
        super(activity, view);
        hotMovieListManager = new HotMovieListManager();
    }

    @Override
    public void getHotMovieList(int ci, int limit) {
        mView.showLoading();
        addSubscribe(hotMovieListManager.getHotMovieList(ci, limit)
                .subscribe(new Subscriber<HotMovieListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(ErrorHanding.handleError(e));
                    }

                    @Override
                    public void onNext(HotMovieListBean hotMovieListBean) {
                        mView.addMovieIds(hotMovieListBean.getData().getMovieIds());
                        mView.addHotMovieList(hotMovieListBean.getData().getHot());
                    }
                }));
    }

    @Override
    public void getMoreHotMovieList(int ci, int headline, final String movieIds) {
        addSubscribe(hotMovieListManager.getMoreMovieList(ci, headline, movieIds)
                .subscribe(new Subscriber<List<HotMovieListBean.DataBean.HotBean>>() {
                    @Override
                    public void onCompleted() {
                        mView.loadMoreCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadMoreError();
                    }

                    @Override
                    public void onNext(List<HotMovieListBean.DataBean.HotBean> hotBeen) {
                        mView.addMoreMovies(hotBeen);
                    }
                }));
    }
}

package com.cicinnus.cateye.module.movie.find_movie;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.find_movie.bean.AwardsMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.GridMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;
import com.cicinnus.cateye.tools.ErrorHanding;

import rx.Subscriber;

/**
 * Created by Cicinnus on 2017/2/2.
 */

public class FindMoviePresenter extends BasePresenter<FindMovieContract.IFindMovieView> implements FindMovieContract.IFindMoviePresenter {

    private final FindMovieManager findMovieManager;

    public FindMoviePresenter(Activity activity, FindMovieContract.IFindMovieView view) {
        super(activity, view);
        findMovieManager = new FindMovieManager();

    }

    @Override
    public void getMovieTypeList() {
        mView.showContent();
        addSubscribe(findMovieManager.getMovieTypeList()
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
                    }
                }));
    }

    @Override
    public void getMovieGrid() {
        mView.showLoading();
        addSubscribe(findMovieManager.getMovieGrid()
                .subscribe(new Subscriber<GridMovieBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(ErrorHanding.handleError(e));
                    }

                    @Override
                    public void onNext(GridMovieBean gridMovieBean) {
                        mView.addMovieGrid(gridMovieBean.getData());
                    }
                }));
    }

    @Override
    public void getAwardsMovie() {
        mView.showLoading();
        addSubscribe(findMovieManager.getAwardsMovie()
        .subscribe(new Subscriber<AwardsMovieBean>() {
            @Override
            public void onCompleted() {
                mView.showContent();
            }

            @Override
            public void onError(Throwable e) {
                mView.showError(ErrorHanding.handleError(e));
            }

            @Override
            public void onNext(AwardsMovieBean awardsMovieBean) {
                mView.addAwardsMovie(awardsMovieBean.getData());
            }
        }));
    }
}

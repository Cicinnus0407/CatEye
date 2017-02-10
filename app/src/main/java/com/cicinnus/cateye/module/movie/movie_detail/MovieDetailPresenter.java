package com.cicinnus.cateye.module.movie.movie_detail;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/2/10.
 */

public class MovieDetailPresenter extends BasePresenter<MovieDetailContract.IMovieDetailView> implements MovieDetailContract.IMoviePresenter {

    private final MovieDetailManager movieDetailManager;

    public MovieDetailPresenter(Activity activity, MovieDetailContract.IMovieDetailView view) {
        super(activity, view);
        movieDetailManager = new MovieDetailManager();
    }

    @Override
    public void getMovieBasicData(int movieId) {
        mView.showLoading();
        addSubscribe(movieDetailManager.getMovieBasicData(movieId)
                .compose(SchedulersCompat.<MovieBasicDataBean>applyIoSchedulers())
                .subscribe(new Subscriber<MovieBasicDataBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieBasicDataBean movieBasicDataBean) {
                        mView.addMovieBasicData(movieBasicDataBean.getData().getMovie());
                    }
                }));
    }
}

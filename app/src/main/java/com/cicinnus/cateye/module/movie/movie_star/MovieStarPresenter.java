package com.cicinnus.cateye.module.movie.movie_star;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.movie_star.bean.MovieStarHonor;
import com.cicinnus.cateye.module.movie.movie_star.bean.MovieStarInfoBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.RelatedInformationBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.StarMoviesBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.StarRelatedPeople;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Cicinnus on 2017/2/18.
 */

public class MovieStarPresenter extends BasePresenter<MovieStarContract.IMovieStarView> implements MovieStarContract.IMovieStarPresenter {

    private final MovieStarManage movieStarManage;

    public MovieStarPresenter(Activity activity, MovieStarContract.IMovieStarView view) {
        super(activity, view);
        movieStarManage = new MovieStarManage();
    }

    @Override
    public void getMovieStarInfo(int starId) {
        mView.showLoading();
        addSubscribe(Observable.merge(
                movieStarManage.getMovieStarInfo(starId),
                movieStarManage.getMovieStarHonor(starId),
                movieStarManage.getStarMovies(starId),
                movieStarManage.getRelatedInformation(starId),
                movieStarManage.getStarRelatedPeople(starId))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(Object o) {
                        if(o instanceof MovieStarInfoBean){
                            mView.addMovieStarInfo(((MovieStarInfoBean) o).getData());
                        }else if(o instanceof MovieStarHonor){
                            mView.addMovieStarHonor(((MovieStarHonor) o));
                        }else if(o instanceof StarMoviesBean){
                            mView.addStarMovies(((StarMoviesBean) o).getData());
                        }else if(o instanceof RelatedInformationBean){
                            mView.addRelatedInformation(((RelatedInformationBean) o));
                        }else if(o instanceof StarRelatedPeople){
                            mView.addStarRelatedPeople(((StarRelatedPeople) o));
                        }
                    }
                }));
    }
}

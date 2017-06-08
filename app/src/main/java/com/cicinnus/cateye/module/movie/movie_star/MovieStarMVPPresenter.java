package com.cicinnus.cateye.module.movie.movie_star;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.movie_star.bean.MovieStarHonor;
import com.cicinnus.cateye.module.movie.movie_star.bean.MovieStarInfoBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.RelatedInformationBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.StarMoviesBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.StarRelatedPeople;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Cicinnus on 2017/2/18.
 */

public class MovieStarMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<MovieStarContract.IMovieStarView> implements MovieStarContract.IMovieStarPresenter {

    private final MovieStarManage movieStarManage;

    public MovieStarMVPPresenter(Activity activity, MovieStarContract.IMovieStarView view) {
        super(activity, view);
        movieStarManage = new MovieStarManage();
    }

    @Override
    public void getMovieStarInfo(int starId) {
        mView.showLoading();
        addSubscribeUntilDestroy(Observable.mergeArray(
                movieStarManage.getMovieStarInfo(starId),
                movieStarManage.getMovieStarHonor(starId),
                movieStarManage.getStarMovies(starId),
                movieStarManage.getRelatedInformation(starId),
                movieStarManage.getStarRelatedPeople(starId))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
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
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.showError(throwable.getMessage());

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        mView.showContent();

                    }
                }));
    }
}

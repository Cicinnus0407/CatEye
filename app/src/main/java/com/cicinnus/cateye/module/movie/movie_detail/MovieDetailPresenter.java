package com.cicinnus.cateye.module.movie.movie_detail;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieAwardsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieLongCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieMoneyBoxBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieResourceBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieStarBean;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;
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
    public void getMovieData(int movieId) {
        mView.showLoading();
        addSubscribe(Observable.merge(
                movieDetailManager.getMovieBasicData(movieId),
                movieDetailManager.getMovieStarList(movieId),
                movieDetailManager.getMovieBox(movieId),
                movieDetailManager.getMovieAwards(movieId),
                movieDetailManager.getMovieResource(movieId),
                movieDetailManager.getMovieCommentTag(movieId),
                movieDetailManager.getMovieLongComment(movieId))
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
                        if (o instanceof MovieBasicDataBean) {
                            mView.addMovieBasicData(((MovieBasicDataBean) o).getData().getMovie());
                        } else if (o instanceof MovieStarBean) {
                            mView.addMovieStarList(((MovieStarBean) o));
                        }else if(o instanceof MovieMoneyBoxBean){
                            mView.addMovieMoneyBox(((MovieMoneyBoxBean) o));
                        }else if(o instanceof MovieAwardsBean){
                            mView.addMovieAwards(((MovieAwardsBean) o).getData());
                        }else if(o instanceof MovieResourceBean){
                            mView.addMovieResource(((MovieResourceBean) o).getData());
                        }else if(o instanceof MovieCommentTagBean){
                            mView.addMovieCommentTag(((MovieCommentTagBean) o).getData());
                        }else if(o instanceof MovieLongCommentBean){
                            mView.addMovieLongComment(((MovieLongCommentBean) o).getData());
                        }
                    }
                }));
    }
}

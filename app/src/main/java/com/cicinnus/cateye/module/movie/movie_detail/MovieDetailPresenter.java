package com.cicinnus.cateye.module.movie.movie_detail;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieAwardsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieLongCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieMoneyBoxBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieRelatedInformationBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieResourceBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieStarBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTipsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTopicBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.RelatedMovieBean;
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
        //merge操作只支持9个,所以分开两次获取
        addSubscribe(Observable.merge(
                movieDetailManager.getMovieBasicData(movieId),
                movieDetailManager.getMovieTips(movieId),
                movieDetailManager.getMovieStarList(movieId))
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
                        } else if (o instanceof MovieTipsBean) {
                            mView.addMovieTips(((MovieTipsBean) o).getData());
                        } else if (o instanceof MovieStarBean) {
                            mView.addMovieStarList(((MovieStarBean) o));
                        }
                    }
                }));
    }

    @Override
    public void getMovieSecondData(int movieId) {
        addSubscribe(Observable.merge(movieDetailManager.getMovieBox(movieId),
                movieDetailManager.getMovieAwards(movieId),
                movieDetailManager.getMovieResource(movieId))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Object o) {
                        if (o instanceof MovieMoneyBoxBean) {
                            mView.addMovieMoneyBox(((MovieMoneyBoxBean) o));
                        } else if (o instanceof MovieAwardsBean) {
                            mView.addMovieAwards(((MovieAwardsBean) o).getData());
                        } else if (o instanceof MovieResourceBean) {
                            mView.addMovieResource(((MovieResourceBean) o).getData());
                        }
                    }
                }));
    }

    @Override
    public void getMovieMoreData(int movieId) {
        addSubscribe(Observable.merge(
                movieDetailManager.getMovieCommentTag(movieId),
                movieDetailManager.getMovieLongComment(movieId),
                movieDetailManager.getMovieRelatedInformation(movieId),
                movieDetailManager.getRelatedMovie(movieId),
                movieDetailManager.getMovieTopic(movieId))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Object o) {
                        if (o instanceof MovieCommentTagBean) {
                            mView.addMovieCommentTag(((MovieCommentTagBean) o).getData());
                        } else if (o instanceof MovieLongCommentBean) {
                            mView.addMovieLongComment(((MovieLongCommentBean) o).getData());
                        } else if (o instanceof MovieRelatedInformationBean) {
                            mView.addMovieRelatedInformation(((MovieRelatedInformationBean) o).getData().getNewsList());
                        } else if (o instanceof RelatedMovieBean) {
                            mView.addRelatedMovie(((RelatedMovieBean) o).getData());
                        } else if (o instanceof MovieTopicBean) {
                            mView.addMovieTopic(((MovieTopicBean) o).getData());
                        }
                    }
                }));
    }
}

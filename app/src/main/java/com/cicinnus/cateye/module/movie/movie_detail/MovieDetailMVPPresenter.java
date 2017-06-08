package com.cicinnus.cateye.module.movie.movie_detail;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieAwardsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieLongCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieMoneyBoxBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieProCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieRelatedInformationBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieResourceBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieStarBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTipsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTopicBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.RelatedMovieBean;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


public class MovieDetailMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<MovieDetailContract.IMovieDetailView> implements MovieDetailContract.IMoviePresenter {

    private final MovieDetailManager movieDetailManager;

    public MovieDetailMVPPresenter(Activity activity, MovieDetailContract.IMovieDetailView view) {
        super(activity, view);
        movieDetailManager = new MovieDetailManager();
    }

    @Override
    public void getMovieData(int movieId) {
        mView.showLoading();
        //合并所有请求
        addSubscribeUntilDestroy(Observable.mergeArray(
                movieDetailManager.getMovieBasicData(movieId),
                movieDetailManager.getMovieTips(movieId),
                movieDetailManager.getMovieStarList(movieId),
                movieDetailManager.getMovieBox(movieId),
                movieDetailManager.getMovieAwards(movieId),
                movieDetailManager.getMovieResource(movieId),
                movieDetailManager.getMovieCommentTag(movieId),
                movieDetailManager.getMovieLongComment(movieId),
                movieDetailManager.getMovieProComment(movieId),
                movieDetailManager.getMovieRelatedInformation(movieId),
                movieDetailManager.getRelatedMovie(movieId),
                movieDetailManager.getMovieTopic(movieId))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        if (o instanceof MovieBasicDataBean) {
                            mView.addMovieBasicData(((MovieBasicDataBean) o).getData().getMovie());
                        } else if (o instanceof MovieTipsBean) {
                            mView.addMovieTips(((MovieTipsBean) o).getData());
                        } else if (o instanceof MovieStarBean) {
                            mView.addMovieStarList(((MovieStarBean) o));
                        } else if (o instanceof MovieMoneyBoxBean) {
                            mView.addMovieMoneyBox(((MovieMoneyBoxBean) o));
                        } else if (o instanceof MovieAwardsBean) {
                            mView.addMovieAwards(((MovieAwardsBean) o).getData());
                        } else if (o instanceof MovieResourceBean) {
                            mView.addMovieResource(((MovieResourceBean) o).getData());
                        }else  if (o instanceof MovieCommentTagBean) {
                            mView.addMovieCommentTag(((MovieCommentTagBean) o).getData());
                        } else if (o instanceof MovieProCommentBean) {
                            mView.addMovieProComment(((MovieProCommentBean) o));
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

    @Override
    public void getMovieSecondData(int movieId) {

    }

    @Override
    public void getMovieMoreData(int movieId) {

    }
}

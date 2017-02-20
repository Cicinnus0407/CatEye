package com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieAlbumBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieMusicBean;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieSoundTrackPresenter extends BasePresenter<MovieSoundTrackContract.IMovieSoundTrackView> implements MovieSoundTrackContract.IMovieSoundTrackPresenter {

    private final MovieSoundTrackManager movieSoundTrackManager;

    public MovieSoundTrackPresenter(Activity activity, MovieSoundTrackContract.IMovieSoundTrackView view) {
        super(activity, view);
        movieSoundTrackManager = new MovieSoundTrackManager();
    }

    @Override
    public void getMovieSoundTrack(int movieId) {
        mView.showLoading();
        addSubscribe(Observable.merge(
                movieSoundTrackManager.getMovieAlbum(movieId),
                movieSoundTrackManager.getMovieMusic(movieId))
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
                        if(o instanceof MovieAlbumBean){
                            mView.addMovieAlbum(((MovieAlbumBean) o).getData());
                        }else if(o instanceof MovieMusicBean){
                            mView.addMovieMusic(((MovieMusicBean) o).getData());
                        }
                    }
                }));
    }
}

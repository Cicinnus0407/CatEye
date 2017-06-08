package com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieAlbumBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieMusicBean;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieSoundTrackMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<MovieSoundTrackContract.IMovieSoundTrackView> implements MovieSoundTrackContract.IMovieSoundTrackPresenter {

    private final MovieSoundTrackManager movieSoundTrackManager;

    public MovieSoundTrackMVPPresenter(Activity activity, MovieSoundTrackContract.IMovieSoundTrackView view) {
        super(activity, view);
        movieSoundTrackManager = new MovieSoundTrackManager();
    }

    @Override
    public void getMovieSoundTrack(int movieId) {
        mView.showLoading();
        addSubscribeUntilDestroy(Observable.merge(
                movieSoundTrackManager.getMovieAlbum(movieId),
                movieSoundTrackManager.getMovieMusic(movieId))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        if(o instanceof MovieAlbumBean){
                            mView.addMovieAlbum(((MovieAlbumBean) o).getData());
                        }else if(o instanceof MovieMusicBean){
                            mView.addMovieMusic(((MovieMusicBean) o).getData());
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

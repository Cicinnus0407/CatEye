package com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack;

import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieAlbumBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieMusicBean;
import com.cicinnus.retrofitlib.base.ICoreLoadingView;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieSoundTrackContract {
    public interface IMovieSoundTrackView extends ICoreLoadingView {

        void addMovieAlbum(MovieAlbumBean.DataBean movieAlbum);

        void addMovieMusic(MovieMusicBean.DataBean movieMusic);
    }

    public interface IMovieSoundTrackPresenter {
        void getMovieSoundTrack(int movieId);

    }
}

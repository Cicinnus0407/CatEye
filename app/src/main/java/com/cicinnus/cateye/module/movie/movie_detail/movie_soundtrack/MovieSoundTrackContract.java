package com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieAlbumBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieMusicBean;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieSoundTrackContract {
    public interface IMovieSoundTrackView extends ILoadingView{

        void addMovieAlbum(MovieAlbumBean.DataBean movieAlbum);

        void addMovieMusic(MovieMusicBean.DataBean movieMusic);
    }

    public interface IMovieSoundTrackPresenter {
        void getMovieSoundTrack(int movieId);

    }
}

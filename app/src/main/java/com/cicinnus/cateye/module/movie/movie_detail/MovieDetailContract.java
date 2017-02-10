package com.cicinnus.cateye.module.movie.movie_detail;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;

/**
 * Created by Administrator on 2017/2/10.
 */

public class MovieDetailContract {
    public interface IMovieDetailView extends ILoadingView{
        void addMovieBasicData(MovieBasicDataBean.DataBean.MovieBean movie);
    }

    public interface IMoviePresenter{
        void getMovieBasicData(int movieId);
    }
}

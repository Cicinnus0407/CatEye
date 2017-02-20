package com.cicinnus.cateye.module.movie.movie_detail.movie_resource;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieTechnicalsBean;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieResourceContract {
    public interface IMovieResourceView extends ILoadingView{

        void addMovieTechnicals(MovieTechnicalsBean.DataBean technicalsBeanData);
    }

    public interface IMovieResourcePresenter{
        void getMovieTechnicals(int movieId);
    }

}

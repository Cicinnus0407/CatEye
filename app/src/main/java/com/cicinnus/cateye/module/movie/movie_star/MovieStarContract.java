package com.cicinnus.cateye.module.movie.movie_star;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.movie_star.bean.MovieStarHonor;
import com.cicinnus.cateye.module.movie.movie_star.bean.MovieStarInfoBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.RelatedInformationBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.StarMoviesBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.StarRelatedPeople;

/**
 * Created by Cicinnus on 2017/2/18.
 */

public class MovieStarContract {

    public interface IMovieStarView extends ILoadingView{

        void addMovieStarInfo(MovieStarInfoBean.DataBean info);

        void addMovieStarHonor(MovieStarHonor honors);

        void addStarMovies(StarMoviesBean.DataBean moviesData);

        void addRelatedInformation(RelatedInformationBean relatedInformationBean);

        void addStarRelatedPeople(StarRelatedPeople relatedPeople);
    }

    public interface IMovieStarPresenter {
        void getMovieStarInfo(int starId);
    }
}

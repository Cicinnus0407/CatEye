package com.cicinnus.cateye.module.movie.movie_detail.movie_resource;

import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieDialoguesBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieHighLightsBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieParentGuidancesBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieRelatedCompanies;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieTechnicalsBean;
import com.cicinnus.retrofitlib.base.ICoreLoadingView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieResourceContract {
    public interface IMovieResourceView extends ICoreLoadingView {

        void addMovieTechnicals(MovieTechnicalsBean.DataBean technicalsBeanData);

        void addMovieDialogues(List<MovieDialoguesBean.DataBean> movieDialoguesBeanData);

        void addMovieRelatedCompanies(List<MovieRelatedCompanies.DataBean> movieRelatedCompaniesData);

        void addMovieParentGuidances(List<MovieParentGuidancesBean.DataBean.GovBean> govBeanList);

        void addMovieHighLights(List<MovieHighLightsBean.DataBean> movieHighLightsBeanData);
    }

    public interface IMovieResourcePresenter {
        void getMovieTechnicals(int movieId);

        void getMovieDialogues(int movieId);

        void getMovieRelatedCompanies(int movieId);

        void getMovieParentGuidances(int movieId);

        void getMovieHighLights(int movieId);
    }

}

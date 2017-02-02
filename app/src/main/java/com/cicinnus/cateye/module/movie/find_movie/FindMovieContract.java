package com.cicinnus.cateye.module.movie.find_movie;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.find_movie.bean.AwardsMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.GridMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/2.
 */

public class FindMovieContract {

    public interface IFindMovieView extends ILoadingView {
        void addMovieType(List<MovieTypeBean.DataBean.TagListBean> tagList);

        void addMovieNation(List<MovieTypeBean.DataBean.TagListBean> tagList);

        void addMoviePeriod(List<MovieTypeBean.DataBean.TagListBean> tagList);

        void addMovieGrid(List<GridMovieBean.DataBean> data);

        void addAwardsMovie(List<AwardsMovieBean.DataBean> data);
    }

    public interface IFindMoviePresenter {
        void getMovieTypeList();

        void getMovieGrid();

        void getAwardsMovie();
    }
}

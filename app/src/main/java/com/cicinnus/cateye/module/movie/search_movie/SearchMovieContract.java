package com.cicinnus.cateye.module.movie.search_movie;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/3.
 */

public class SearchMovieContract {
    public interface ISearchMovieView extends ILoadingView{
        void addMovieType(List<MovieTypeBean.DataBean.TagListBean> tagList);

        void addMovieNation(List<MovieTypeBean.DataBean.TagListBean> tagList);

        void addMoviePeriod(List<MovieTypeBean.DataBean.TagListBean> tagList);

        void addMoviePoint(List<MovieTypeBean.DataBean.TagListBean> tagList);

        void addClassifySearchData(List<ClassifySearchBean.ListBean> list);

    }

    public interface ISearchMoviePresenter {
        void getMovieTypeList();

        void getClassifySearchList(int offset,int catId,int sourceId,int yearId,int sortId);


    }
}


package com.cicinnus.cateye.module.movie.hot_movie;

import com.cicinnus.retrofitlib.base.ICoreLoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/1/24.
 */

public class HotMovieListContract {
    public interface IHotMovieListView extends ICoreLoadingView {
        void addHotMovieList(List<HotMovieListBean.DataBean.HotBean> hot);

        void addMovieIds(List<Integer> movieIds);

        void addMoreMovies(List<HotMovieListBean.DataBean.HotBean> movies);

        void loadMoreError();

        void loadMoreCompleted();
    }

    public interface IHotMoviePresenter{
        void getHotMovieList(int ci,int limit);

        void getMoreHotMovieList(int ci,int headline,String movieIds);
    }
}

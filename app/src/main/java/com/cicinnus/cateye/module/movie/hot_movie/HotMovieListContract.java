
package com.cicinnus.cateye.module.movie.hot_movie;

import com.cicinnus.cateye.base.ILoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/1/24.
 */

public class HotMovieListContract {
    public interface IHotMovieListView extends ILoadingView{
        void addHotMovieList(List<HotMovieListBean.DataBean.HotBean> hot);
    }

    public interface IHotMoviePresenter{
        void getHotMovieList(int ci,int limit);
    }
}

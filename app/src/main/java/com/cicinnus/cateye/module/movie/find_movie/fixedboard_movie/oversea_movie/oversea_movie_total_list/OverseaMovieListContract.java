package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.oversea_movie_total_list;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaComingMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/9.
 */

public class OverseaMovieListContract {
    public interface IOverseaMovieListView extends ILoadingView{
        void addOverseaHotMovieList(List<OverseaHotMovieBean.DataBean.HotBean> hot);

        void addOverseaComingMovieList(List<OverseaComingMovieBean.DataBean.ComingBean> coming);
    }

    public interface IOverseaMovieListPresenter {
        void getOverseaHotMovieList(String area, int limit, int offset);

        void getOverseaComingMovieList(String area,int limit,int offset);
    }
}

package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import com.cicinnus.cateye.base.ILoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMovieContract  {
    public interface IOverseaMovieView extends ILoadingView{
        void addOverseaMovie(List<OverseaMovieBean.DataBeanXXX.HotDataBean.DataBeanXX.HotBean> hotData);
    }

    public interface IOverseaMoviePresenter{
        void getOverseaMovie(String area);
    }
}

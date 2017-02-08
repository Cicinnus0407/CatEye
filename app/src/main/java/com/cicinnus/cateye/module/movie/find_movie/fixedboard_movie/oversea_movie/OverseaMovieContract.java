package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaComingMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMovieContract  {
    public interface IOverseaMovieView extends ILoadingView{
        void addOverseaMovie(ResponseBody hot);

        void addOverseaHotMovie(List<OverseaHotMovieBean.DataBean.HotBean> hot);

        void addOverseaComingMovie(List<OverseaComingMovieBean.DataBean.ComingBean> coming);
    }

    public interface IOverseaMoviePresenter{
        void getOverseaMovie(String area);
    }
}

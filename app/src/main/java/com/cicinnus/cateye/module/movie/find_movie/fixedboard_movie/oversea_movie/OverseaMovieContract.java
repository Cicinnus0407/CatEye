package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaComingMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;
import com.cicinnus.retrofitlib.base.ICoreLoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMovieContract  {
    public interface IOverseaMovieView extends ICoreLoadingView {

        void addOverseaHotMovie(List<OverseaHotMovieBean.DataBean.HotBean> hot);

        void addOverseaComingMovie(List<OverseaComingMovieBean.DataBean.ComingBean> coming);
    }

    public interface IOverseaMoviePresenter{
        void getOverseaMovie(String area);
    }
}

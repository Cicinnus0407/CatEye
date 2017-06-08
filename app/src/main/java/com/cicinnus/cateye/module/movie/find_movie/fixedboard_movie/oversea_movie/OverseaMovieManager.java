package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaComingMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;
import com.cicinnus.cateye.net.RetrofitClient;

import io.reactivex.Observable;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMovieManager {


    /**
     * 获取10条热映电影
     * @param area 地区
     * @return
     */

    public Observable<OverseaHotMovieBean> getOverseaHotMovie(String area){
        return RetrofitClient
                .getInstance()
                .api()
                .getOverseaHotMovie(area,10,0);
    }

    /**
     * 获取10条待映电影
     * @param area 地区
     * @return
     */
    public Observable<OverseaComingMovieBean> getOverseaComingMovie(String area){
        return RetrofitClient
                .getInstance()
                .api()
                .getOverseaComingMovie(area,10,0);
    }
}



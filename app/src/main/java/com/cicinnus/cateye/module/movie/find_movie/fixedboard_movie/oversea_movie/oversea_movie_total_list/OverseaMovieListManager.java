package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.oversea_movie_total_list;

import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaComingMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;
import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;


/**
 * Created by Administrator on 2017/2/9.
 */

public class OverseaMovieListManager {


    public Observable<OverseaHotMovieBean> getOverseaHotMovie(String area,int limit,int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getOverseaHotMovie(area,limit,offset)
                .compose(SchedulersCompat.<OverseaHotMovieBean>applyIoSchedulers());
    }

    public Observable<OverseaComingMovieBean> getOverseaComingMovie(String are,int limit,int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getOverseaComingMovie(are,limit,offset)
                .compose(SchedulersCompat.<OverseaComingMovieBean>applyIoSchedulers());

    }
}

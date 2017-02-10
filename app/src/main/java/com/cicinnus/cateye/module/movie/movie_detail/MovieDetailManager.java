package com.cicinnus.cateye.module.movie.movie_detail;

import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.net.RetrofitClient;

import rx.Observable;

/**
 * Created by Administrator on 2017/2/10.
 */

public class MovieDetailManager {
    public Observable<MovieBasicDataBean> getMovieBasicData(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieBasicData(movieId);
    }
}

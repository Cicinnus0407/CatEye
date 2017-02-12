package com.cicinnus.cateye.module.movie.movie_detail;

import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieMoneyBoxBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieStarBean;
import com.cicinnus.cateye.net.RetrofitClient;

import rx.Observable;

/**
 * Created by Administrator on 2017/2/10.
 */

public class MovieDetailManager {

    /**
     * 获取电影资料
     * @param movieId
     * @return
     */
    public Observable<MovieBasicDataBean> getMovieBasicData(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieBasicData(movieId);
    }

    /**
     * 影星列表
     * @param movieId
     * @return
     */
    public Observable<MovieStarBean> getMovieStarList(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieStarList(movieId);
    }

    public Observable<MovieMoneyBoxBean> getMovieBox(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieBox(movieId);
    }

}

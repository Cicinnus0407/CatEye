package com.cicinnus.cateye.module.movie.wait_movie;

import com.cicinnus.cateye.net.RetrofitClient;

import rx.Observable;

/**
 * Created by Cicinnus on 2017/1/25.
 */

public class WaitMovieManager {

    public Observable<TrailerRecommendBean> getTrailerRecommendMovie(){
        return RetrofitClient
                .getInstance()
                .api()
                .getTrailerRecommend();
    }
}

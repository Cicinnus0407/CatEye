package com.cicinnus.cateye.module.movie.movie_detail.movie_information;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;

/**
 * Created by Cicinnus on 2017/2/27.
 */

public class MovieInformationManager {
    public Observable<MovieInformationBean> getMovieInformation(int movieId,int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieInformation(movieId,10,offset)
                .compose(SchedulersCompat.<MovieInformationBean>applyIoSchedulers());
    }
}

package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.most_expect;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/2/4.
 */

public class MostExpectMovieManager {

    public Observable<MostExpectMovieBean> getRecentExpectMovieList(int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getMostExpectMovie(10,offset)
                .compose(SchedulersCompat.<MostExpectMovieBean>applyIoSchedulers());
    }
}

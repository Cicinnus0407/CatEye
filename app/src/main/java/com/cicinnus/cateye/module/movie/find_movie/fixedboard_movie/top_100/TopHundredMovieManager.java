package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.top_100;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.Observable;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class TopHundredMovieManager {

    public Observable<TopHundredMovieBean> getTopHundredMovie(int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getTopHundredMovie(10,offset)
                .compose(SchedulersCompat.<TopHundredMovieBean>applyIoSchedulers());
    }
}

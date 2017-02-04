package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.recent_expect;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;

/**
 * Created by Administrator on 2017/2/4.
 */

public class RecentExpectMovieManager {

    public Observable<RecentExpectMovieBean> getRecentExpectMovieList(int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getRecentExpectMovie(10,offset)
                .compose(SchedulersCompat.<RecentExpectMovieBean>applyIoSchedulers());
    }
}

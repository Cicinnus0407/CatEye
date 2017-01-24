package com.cicinnus.cateye.module.movie.hot_movie;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;

/**
 * Created by Cicinnus on 2017/1/24.
 */

public class HotMovieListManager {

    /**
     * 获取热门电影列表
     * @param ci
     * @param limit
     * @return
     */
    public Observable<HotMovieListBean> getHotMovieList(int ci,int limit){
        return RetrofitClient
                .getInstance()
                .api()
                .getHostList(ci,limit)
                .compose(SchedulersCompat.<HotMovieListBean>applyIoSchedulers());
    }
}

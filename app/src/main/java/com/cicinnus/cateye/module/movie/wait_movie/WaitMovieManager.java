package com.cicinnus.cateye.module.movie.wait_movie;

import com.cicinnus.cateye.module.movie.wait_movie.bean.RecentExpectBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;

/**
 * Created by Cicinnus on 2017/1/25.
 */

public class WaitMovieManager {

    /**
     * 预告片推荐
     * @return
     */
    public Observable<TrailerRecommendBean> getTrailerRecommendMovie(){
        return RetrofitClient
                .getInstance()
                .api()
                .getTrailerRecommend()
                .compose(SchedulersCompat.<TrailerRecommendBean>applyIoSchedulers());
    }

    /**
     * 最近最受期待
     * @param offset 偏移量
     * @param limit 数量
     * @return
     */
    public Observable<RecentExpectBean> getRecentExpectList(int offset, int limit){
        return RetrofitClient
                .getInstance()
                .api()
                .getRecentExpectMovieList(offset,limit)
                .compose(SchedulersCompat.<RecentExpectBean>applyIoSchedulers());

    }

    public Observable<WaitMovieBean> getWaitMovieList(int ci, int limit){
        return RetrofitClient
                .getInstance()
                .api()
                .getWaitMovieList(ci,limit)
                .compose(SchedulersCompat.<WaitMovieBean>applyIoSchedulers());
    }
}

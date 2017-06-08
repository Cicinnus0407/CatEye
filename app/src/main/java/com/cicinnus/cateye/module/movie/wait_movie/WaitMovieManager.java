package com.cicinnus.cateye.module.movie.wait_movie;

import com.cicinnus.cateye.module.movie.wait_movie.bean.ExpectMovieBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.Observable;

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
    public Observable<ExpectMovieBean> getRecentExpectList(int offset, int limit){
        return RetrofitClient
                .getInstance()
                .api()
                .getExpectMovieList(offset,limit)
                .compose(SchedulersCompat.<ExpectMovieBean>applyIoSchedulers());

    }

    public Observable<WaitMovieBean> getWaitMovieList(int ci, int limit){
        return RetrofitClient
                .getInstance()
                .api()
                .getWaitMovieList(ci,limit)
                .compose(SchedulersCompat.<WaitMovieBean>applyIoSchedulers());
    }
}

package com.cicinnus.cateye.module.movie.find_movie;

import com.cicinnus.cateye.module.movie.find_movie.bean.AwardsMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.GridMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;
import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;
import com.cicinnus.cateye.tools.TimeUtils;

import rx.Observable;

/**
 * Created by Cicinnus on 2017/2/2.
 */

public class FindMovieManager {

    //电影类型
    public Observable<MovieTypeBean> getMovieTypeList() {
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieTypeList()
                .compose(SchedulersCompat.<MovieTypeBean>applyIoSchedulers());
    }

    /**
     * 电影表格
     * @return
     */
    public Observable<GridMovieBean> getMovieGrid(){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieGrid()
                .compose(SchedulersCompat.<GridMovieBean>applyIoSchedulers());
    }

    /**
     * 获奖电影
     * @return
     */
    public Observable<AwardsMovieBean> getAwardsMovie(){
        String currentTime = TimeUtils.dateYMD(System.currentTimeMillis());
        return RetrofitClient
                .getInstance()
                .api()
                .getAwardsMovieList(currentTime)
                .compose(SchedulersCompat.<AwardsMovieBean>applyIoSchedulers());
    }


}

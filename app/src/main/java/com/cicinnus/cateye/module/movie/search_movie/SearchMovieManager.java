package com.cicinnus.cateye.module.movie.search_movie;

import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;
import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;

/**
 * Created by Administrator on 2017/2/3.
 */

public class SearchMovieManager {
    //电影类型
    public Observable<MovieTypeBean> getMovieTypeList() {
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieTypeList()
                .compose(SchedulersCompat.<MovieTypeBean>applyIoSchedulers());
    }

    public Observable<ClassifySearchBean> getClassifySearchList(int offset,int catId,int sourceId,int yearId,int sortId){
        return RetrofitClient
                .getInstance()
                .api()
                .getClassifySearchList(10,offset,catId,sourceId,yearId,sortId)
                .compose(SchedulersCompat.<ClassifySearchBean>applyIoSchedulers());
    }
}

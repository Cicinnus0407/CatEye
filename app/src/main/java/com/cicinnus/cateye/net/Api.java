package com.cicinnus.cateye.net;

import com.cicinnus.cateye.module.discover.DiscoverBean;
import com.cicinnus.cateye.module.discover.DiscoverHeaderBean;
import com.cicinnus.cateye.module.movie.hot_movie.HotMovieListBean;
import com.cicinnus.cateye.module.movie.wait_movie.TrailerRecommendBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/18.
 */

public interface Api {
    String BASE_URL = "http://api.maoyan.com";

    //发现的内容列表
    @GET("/sns/v5/feed.json")
    Observable<DiscoverBean> getDiscover(@Query("offset") int offset,
                                         @Query("limit") int limit);

    //发现列表的头部（今日Top10，影视快讯）
    //两个查询参数必须填，缺一不可，最新版猫眼的参数为utm_medium=android&utm_term=7.8.0
    //其中utm_term可以修改为其他参数，如utm_term=1
    @GET("/sns/v2/buttons.json")
    Observable<DiscoverHeaderBean> getDiscoverHeader(@Query("utm_medium") String utm_medium,
                                                     @Query("utm_term") String utm_term);


    //获取首页热映列表
    // ci 参数不知道是什么，抓包时候的是20
    @GET("/mmdb/movie/v3/list/hot.json")
    Observable<HotMovieListBean> getHostList(@Query("ci")int ci,
                                             @Query("limit")int limit);

    //获取首页热映加载更多的数据
    @GET("/mmdb/movie/list/info.json")
    Observable<HotMovieListBean> getMoreHotMovieList(@Query("ci")int ci,
                                                     @Query("headline")int headline,
                                                     @Query("movieIds")String movieIds);

    //待映-预告片推荐
    @GET("/mmdb/movie/lp/list.json")
    Observable<TrailerRecommendBean> getTrailerRecommend();
}

package com.cicinnus.cateye.net;

import com.cicinnus.cateye.module.discover.DiscoverBean;
import com.cicinnus.cateye.module.discover.DiscoverHeaderBean;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsBean;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsMovieListBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.AwardsMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.GridMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.hot_good_comment.HotGoodCommentBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.most_expect.MostExpectMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaComingMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.top_100.TopHundredMovieBean;
import com.cicinnus.cateye.module.movie.hot_movie.HotMovieListBean;
import com.cicinnus.cateye.module.movie.search_movie.ClassifySearchBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.ExpectMovieBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
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
    Observable<HotMovieListBean> getHostList(@Query("ci") int ci,
                                             @Query("limit") int limit);

    //获取首页热映加载更多的数据
    @GET("/mmdb/movie/list/info.json")
    Observable<HotMovieListBean> getMoreHotMovieList(@Query("ci") int ci,
                                                     @Query("headline") int headline,
                                                     @Query("movieIds") String movieIds);

    //待映-预告片推荐
    @GET("/mmdb/movie/lp/list.json")
    Observable<TrailerRecommendBean> getTrailerRecommend();

    //待映-近期最受期待
    @GET("mmdb/movie/v1/list/wish/order/coming.json")
    Observable<ExpectMovieBean> getExpectMovieList(@Query("offset") int offset,
                                                   @Query("limit") int limit);

    //待映-列表
    @GET("mmdb/movie/v2/list/rt/order/coming.json")
    Observable<WaitMovieBean> getWaitMovieList(@Query("ci") int ci,
                                               @Query("limit") int limit);

    //找片-类型
    @GET("mmdb/search/movie/tag/types.json")
    Observable<MovieTypeBean> getMovieTypeList();

    //找片-表格
    @GET("mmdb/movieboard/fixedboard/v1/hot/list.json")
    Observable<GridMovieBean> getMovieGrid();

    //找片-获奖
    @GET("mmdb/movie/winning/film/{time}/list.json")
    Observable<AwardsMovieBean> getAwardsMovieList(@Path("time") String time);

    //分类查找
    @GET("mmdb/search/movie/tag/list.json")
    Observable<ClassifySearchBean> getClassifySearchList(@Query("limit") int limit,
                                                         @Query("offset") int offset,
                                                         @Query("catId") int catId,
                                                         @Query("sourceId") int sourceId,
                                                         @Query("yearId") int yearId,
                                                         @Query("sortId") int sortId);

    //热映口碑
    @GET("mmdb/movieboard/fixedboard/7.json")
    Observable<HotGoodCommentBean> getHotGoodCommentMovie(@Query("limit") int limit,
                                                          @Query("offset") int offset);

    //最受期待
    @GET("mmdb/movieboard/fixedboard/6.json")
    Observable<MostExpectMovieBean> getMostExpectMovie(@Query("limit") int limit,
                                                       @Query("offset") int offset);

    //最受期待
    @GET("mmdb/movieboard/fixedboard/4.json")
    Observable<TopHundredMovieBean> getTopHundredMovie(@Query("limit") int limit,
                                                       @Query("offset") int offset);

    //合并查询的接口
    @POST("http://api.mobile.meituan.com/combo/v2/combo.json")
    Observable<ResponseBody> getCombineData(@Body RequestBody jsonContent);


    //海外热映电影
    @GET("mmdb/movie/oversea/hot.json")
    Observable<OverseaHotMovieBean> getOverseaHotMovie(@Query("area") String area,
                                                       @Query("limit") int limit,
                                                       @Query("offset") int offset);

    //海外待映电影
    @GET("mmdb/movie/oversea/coming.json")
    Observable<OverseaComingMovieBean> getOverseaComingMovie(@Query("area") String area,
                                                             @Query("limit") int limit,
                                                             @Query("offset") int offset);


    //电影奖项
    @GET("mmdb//movie/festival/{festivalId}/feature.json")
    Observable<AwardsBean> getAwards(@Path("festivalId")String festSessionId);

    //获奖电影
    @GET("mmdb/movie/festival/session/{festSessionId}/award.json")
    Observable<AwardsMovieListBean> getAwardsMovie(@Path("festSessionId") String festSessionId,
                                                   @Query("limit") int limit,
                                                   @Query("offset") int offset);
}

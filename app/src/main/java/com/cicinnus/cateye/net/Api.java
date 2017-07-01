package com.cicinnus.cateye.net;

import com.cicinnus.cateye.module.cinema.bean.CinemaBannerBean;
import com.cicinnus.cateye.module.cinema.bean.CinemaListBean;
import com.cicinnus.cateye.module.cinema.bean.FilterBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaMovieBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.FoodsBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean.CinemaCommentBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean.CinemaInfoBean;
import com.cicinnus.cateye.module.discover.DiscoverBean;
import com.cicinnus.cateye.module.discover.DiscoverHeaderBean;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.awards_list.AwardsListBean;
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
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieAwardsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieLongCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieMoneyBoxBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieProCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieRelatedInformationBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieResourceBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieShortCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieStarBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTipsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTopicBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.RelatedMovieBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_information.MovieInformationBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_long_comment.MovieLongCommentBeanList;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieDialoguesBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieHighLightsBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieParentGuidancesBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieRelatedCompanies;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieTechnicalsBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment.movie_short_comment_detail.MovieShortCommentDetailBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieAlbumBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieMusicBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_topic.MovieTopicListBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.MovieStarHonor;
import com.cicinnus.cateye.module.movie.movie_star.bean.MovieStarInfoBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.RelatedInformationBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.StarMoviesBean;
import com.cicinnus.cateye.module.movie.movie_star.bean.StarRelatedPeople;
import com.cicinnus.cateye.module.movie.movie_video.video_comment.VideoCommentListBean;
import com.cicinnus.cateye.module.movie.movie_video.video_list.VideoListBean;
import com.cicinnus.cateye.module.movie.movie_video.video_list.VideoMovieInfoBean;
import com.cicinnus.cateye.module.movie.pick_city.PickCityBean;
import com.cicinnus.cateye.module.movie.search_movie.ClassifySearchBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.ExpectMovieBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieMoreBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/1/18.
 */

public interface Api {
    String BASE_URL = "http://api.maoyan.com/";

    //发现的内容列表
    @GET("sns/v5/feed.json")
    Observable<DiscoverBean> getDiscover(@Query("offset") int offset,
                                         @Query("limit") int limit);

    //发现列表的头部（今日Top10，影视快讯）
    //两个查询参数必须填，缺一不可，最新版猫眼的参数为utm_medium=android&utm_term=7.8.0
    //其中utm_term可以修改为其他参数，如utm_term=1
    @GET("sns/v2/buttons.json")
    Observable<DiscoverHeaderBean> getDiscoverHeader(@Query("utm_medium") String utm_medium,
                                                     @Query("utm_term") String utm_term);


    //获取首页热映列表
    @GET("mmdb/movie/v3/list/hot.json")
    Observable<HotMovieListBean> getHostList(@Query("limit") int limit);

    //加载更多的数据
    @GET("mmdb/movie/list/info.json")
    Observable<HotMovieListBean> getHotMovieList(@Query("headline") int headline,
                                                 @Query("movieIds") String movieIds);

    //待映-预告片推荐
    @GET("mmdb/movie/lp/list.json")
    Observable<TrailerRecommendBean> getTrailerRecommend();

    //待映-近期最受期待
    @GET("mmdb/movie/v1/list/wish/order/coming.json")
    Observable<ExpectMovieBean> getExpectMovieList(@Query("offset") int offset,
                                                   @Query("limit") int limit);

    //待映-列表
    @GET("mmdb/movie/v2/list/rt/order/coming.json")
    Observable<WaitMovieBean> getWaitMovieList(@Query("limit") int limit);

    @GET("mmdb/movie/list/info.json")
    Observable<WaitMovieMoreBean> getMoreWaitMovieList(@Query("headline") int headline, @Query("movieIds") String movieIds);

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
    @GET("mmdb/movie/festival/{festivalId}/feature.json")
    Observable<AwardsBean> getAwards(@Path("festivalId") int festSessionId);

    //获奖电影
    @GET("mmdb/movie/festival/session/{festSessionId}/award.json")
    Observable<AwardsMovieListBean> getAwardsMovie(@Path("festSessionId") int festSessionId,
                                                   @Query("limit") int limit,
                                                   @Query("offset") int offset);

    //奖项列表
    @GET("mmdb/movie/region/festival/list.json")
    Observable<AwardsListBean> getAwardsList();

    //电影基本信息
    @GET("mmdb/movie/v5/{movieId}.json")
    Observable<MovieBasicDataBean> getMovieBasicData(@Path("movieId") int movieId);

    //观影贴士
    @GET("mmdb/movie/tips/{movieId}/list.json")
    Observable<MovieTipsBean> getMovieTipsBean(@Path("movieId") int movieId);

    //演员列表
    @GET("mmdb/v7/movie/{movieId}/celebrities.json")
    Observable<MovieStarBean> getMovieStarList(@Path("movieId") int movieId);

    //票房
    @GET("mmdb/movie/{movieId}/feature/v1/mbox.json")
    Observable<MovieMoneyBoxBean> getMovieBox(@Path("movieId") int movieId);

    //获奖
    @GET("mmdb/movie/{movieId}/feature/awards.json")
    Observable<MovieAwardsBean> getMovieAwards(@Path("movieId") int movieId);

    //影片资料
    @GET("mmdb/movie/{movieId}/feature/v2/list.json")
    Observable<MovieResourceBean> getMovieResource(@Path("movieId") int movieId);

    //短评标签
    @GET("mmdb/comment/tag/movie/{movieId}.json")
    Observable<MovieCommentTagBean> getMovieCommentTag(@Path("movieId") int movieId);

    //热门短评
    @GET("mmdb/comments/movie/v3/{movieId}.json")
    Observable<MovieShortCommentBean> getMovieShortComment(@Path("movieId") int movieId,
                                                           @Query("tag") int tag,
                                                           @Query("limit") int limit,
                                                           @Query("offset") int offset);

    @GET("mmdb/replies/comment/v2/{movieId}.json")
    Observable<MovieShortCommentDetailBean> getMovieShortCommentDetail(@Path("movieId") int movieId,
                                                                       @Query("limit") int limit,
                                                                       @Query("offset") int offset);

    //热门长评
    @GET("sns/movie/{movieId}/filmReview/top.json")
    Observable<MovieLongCommentBean> getMovieLongComment(@Path("movieId") int movieId);

    //专业评论
    @GET("mmdb/comments/pro/movie/{movieId}.json")
    Observable<MovieProCommentBean> getMovieProComment(@Path("movieId") int movieId,
                                                       @Query("offset") int offset,
                                                       @Query("limit") int limit);

    //相关资讯
    @GET("sns/news/v3/type/0/target/{movieId}/top.json")
    Observable<MovieRelatedInformationBean> getMovieRelatedInformation(@Path("movieId") int movieId);

    //相关电影
    @GET("mmdb/movie/{movieId}/feature/relatedFilm.json")
    Observable<RelatedMovieBean> getRelatedMovie(@Path("movieId") int movieId);

    //相关话题
    @GET("sns/0/{movieId}/v2/hotTopics.json")
    Observable<MovieTopicBean> getMovieTopic(@Path("movieId") int movieId);

    //视频预告片
    @GET("mmdb/v1/movie/{movieId}/videos.json")
    Observable<VideoListBean> getVideoList(@Path("movieId") int movieId,
                                           @Query("limit") int limit,
                                           @Query("offset") int offset);

    //视频信息
    @GET("mmdb/movie/{movieId}/videos/movieInfo.json")
    Observable<VideoMovieInfoBean> getVideoMovieInfo(@Path("movieId") int movieId);

    //视频评论
    @GET("mmdb/comments/feature/v2/{movieId}.json")
    Observable<VideoCommentListBean> getVideoComment(@Path("movieId") int movieId,
                                                     @Query("feature") String feature,
                                                     @Query("limit") int limit,
                                                     @Query("offset") int offset);


    //影人资料
    @GET("mmdb/v6/celebrity/{starId}.json")
    Observable<MovieStarInfoBean> getMovieStarInfoBean(@Path("starId") int starId);

    //影人荣誉
    @GET("mmdb/celebrity/{starId}/honors.json")
    Observable<MovieStarHonor> getMovieStarHonors(@Path("starId") int starId);

    //参演电影
    @GET("mmdb/celebrity/{starId}/rank/movies.json")
    Observable<StarMoviesBean> getStarMovies(@Path("starId") int starId,
                                             @Query("limit") int limit,
                                             @Query("offset") int offset);

    //相关资讯
    @GET("sns/news/v3/type/1/target/{starId}/top.json")
    Observable<RelatedInformationBean> getRelatedInformation(@Path("starId") int starId);

    //相关影人
    @GET("mmdb/celebrity/{starId}/relationship.json")
    Observable<StarRelatedPeople> getStarRelatedPeople(@Path("starId") int starId);

    //影片专辑
    @GET("mmdb/movie/{movieId}/feature/album.json")
    Observable<MovieAlbumBean> getMovieAlbum(@Path("movieId") int movieId);

    //影片原声列表
    @GET("mmdb/movie/{movieId}/feature/musics.json")
    Observable<MovieMusicBean> getMovieMusic(@Path("movieId") int movieId);

    //幕后花絮
    @GET("mmdb/movie/{movieId}/feature/highlights.json")
    Observable<MovieHighLightsBean> getMovieHighLights(@Path("movieId") int movieId);

    //影片技术参数
    @GET("mmdb/movie/{movieId}/feature/v1/technicals.json")
    Observable<MovieTechnicalsBean> getMovieTechnicals(@Path("movieId") int movieId);

    //经典台词
    @GET("mmdb/movie/{movieId}/feature/dialogues.json")
    Observable<MovieDialoguesBean> getMovieDialogues(@Path("movieId") int movieId);

    //出品发行
    @GET("mmdb/movie/{movieId}/feature/relatedCompanies.json")
    Observable<MovieRelatedCompanies> getMovieRelatedCompanies(@Path("movieId") int movieId);

    //家长指引
    @GET("mmdb/movie/{movieId}/feature/v1/parentguidances.json")
    Observable<MovieParentGuidancesBean> getMovieParentGuidances(@Path("movieId") int movieId);

    //电影资讯
    @GET("sns/news/v3/type/0/target/{movieId}.json")
    Observable<MovieInformationBean> getMovieInformation(@Path("movieId") int movieId,
                                                         @Query("limit") int limit,
                                                         @Query("offset") int offset);

    //电影话题
    @GET("sns/group/{groupId}/normalTopics.json")
    Observable<MovieTopicListBean> getMovieTopicList(@Path("groupId") int movieId,
                                                     @Query("limit") int limit,
                                                     @Query("offset") int offset);

    //全部热门长评
    @GET("sns/movie/{movieId}/filmReviews.json")
    Observable<MovieLongCommentBeanList> getMovieLongCommentList(@Path("movieId") int movieId,
                                                                 @Query("limit") int limit,
                                                                 @Query("offset") int offset);

    //获取城市
    @GET("dianying/cities.json")
    Observable<PickCityBean> getCity();

    //获取电影院,这4个参数必须有,否则会提示没有授权,
    //Authorization 的值是根据Date和其他约定规则生成,但是无法得知生成规则,所以只能根据抓包内容写死
    @Headers({
            "Date:Wed, 14 Jun 2017 01:30:12 GMT",
            "Key:95345759",
            "Authorization:a7864cebef128a23350d9ffa876f8d2e",
            "if-Modified-Since:Wed, 14 Jun 2017 01:23:28 GMT"})
    @GET("mmcs/cinema/v1/select/cinemas.json")
    Observable<CinemaListBean> getCinemaList(@QueryMap Map<String, Object> queryMap);


    //获取广告条
    @GET("http://advert.mobile.meituan.com/api/v3/adverts")
    Observable<CinemaBannerBean> getBanner(@QueryMap Map<String, Object> queryMap);

    //获取筛选信息
    @Headers({
            "Date:Wed, 21 Jun 2017 13:49:41 GMT",
            "Key:91137528",
            "userid:-1",
            "Authorization:7d125f9728d3f7ad8b73f0a57fbf938d",
            "if-Modified-Since:Wed, 21 Jun 2017 13:49:41 GMT"})
    @GET("mmcs/cinema/v1/select/items.json")
    Observable<FilterBean> getFilter(@Query("cityId") int cityId);


    //获取影院信息
    @Headers({
            "Date:Thu, 22 Jun 2017 08:06:58 GMT",
            "Key:71143834",
            "Authorization:25a4eb48eee17c0ca3fd4c5055b834fa",
    })
    @GET("mmcs/cinema/v1/cinema.json")
    Observable<CinemaBean> getCinemaData(@QueryMap Map<String, Object> map);

    //影院上映电影
    @Headers({
            "Date:Wed, 21 Jun 2017 13:52:23 GMT",
            "Key:20653024",
            "Authorization:a6341de85fdb5a0fffc57897f8237c2b",
            "if-Modified-Since:Wed, 21 Jun 2017 10:40:36 GMT"
    })
    @GET("mmcs/show/v2/cinema/shows.json")
    Observable<CinemaMovieBean> getCinemaMovie(@QueryMap Map<String, Object> queryMap);


    //影院销售食品信息
    @Headers({
            "Date:Thu, 22 Jun 2017 09:01:22 GMT",
            "Key:89345706",
            "Authorization:ad9c2ec80e48adc0c3e45eee55422482"
    })
    @GET("goods/queryDealList.json")
    Observable<FoodsBean> getFoods(@QueryMap Map<String, Object> map);


    //获取影院信息
    @Headers({
            "Date:Mon, 26 Jun 2017 01:55:23 GMT",
            "Key:94178590",
            "Authorization:207eb59e2bc3e49ea0af69e23f84aaa1"
    })
    @GET("mmcs/cinema/v0/cinema.json")
    Observable<CinemaInfoBean> getCinemaInfo(@QueryMap Map<String, Object> queryMap);

    //获取影院评论
    @GET("dianying/v1/comments/cinema/{cinemaId}.json")
    Observable<CinemaCommentBean> getCinemaComment(@Path("cinemaId") int cinemaId, @QueryMap Map<String, Object> map);


}

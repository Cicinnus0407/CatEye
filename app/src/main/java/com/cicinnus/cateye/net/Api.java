package com.cicinnus.cateye.net;

import com.cicinnus.cateye.module.discover.DiscoverBean;
import com.cicinnus.cateye.module.discover.DiscoverHeaderBean;

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
}

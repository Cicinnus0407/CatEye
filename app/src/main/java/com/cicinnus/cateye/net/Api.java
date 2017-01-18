package com.cicinnus.cateye.net;

import com.cicinnus.cateye.module.discover.DiscoverBean;

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
    Observable<DiscoverBean> getDiscover(@Query("offest") int offset,
                                         @Query("limit") int limit);
}

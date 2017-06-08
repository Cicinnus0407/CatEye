package com.cicinnus.cateye.module.discover;

import com.cicinnus.cateye.net.RetrofitClient;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2017/1/18.
 */

public class DiscoverManager {


    /**
     * 获取发现列表数据
     * @param offset
     * @param limit
     * @return
     */
    public Observable<DiscoverBean> getDiscoverData(int offset, int limit){


        return RetrofitClient
                .getInstance()
                .api()
                .getDiscover(offset,limit);

    }

    /**
     * 获取列表头部数据
     * @param utm_term
     * @return
     */
    public Observable<DiscoverHeaderBean> getDiscoverHeaderData(String utm_term){
        return RetrofitClient
                .getInstance()
                .api()
                .getDiscoverHeader("android",utm_term);
    }
}

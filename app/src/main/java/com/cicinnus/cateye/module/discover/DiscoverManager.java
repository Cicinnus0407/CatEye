package com.cicinnus.cateye.module.discover;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/18.
 */

public class DiscoverManager {

    public Observable<DiscoverBean> getDiscoverData(int offset,int limit){
        return RetrofitClient
                .getInstance()
                .api()
                .getDiscover(offset,limit)
                .compose(SchedulersCompat.<DiscoverBean>applyIoSchedulers());

    }
}

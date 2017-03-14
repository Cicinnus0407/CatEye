package com.cicinnus.cateye.module.movie.find_movie.awards_movie.awards_list;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;


/**
 * Created by Administrator on 2017/2/7.
 */

public class AwardsListManager {
    public Observable<AwardsListBean> getAwardsList(){
        return RetrofitClient
                .getInstance()
                .api()
                .getAwardsList()
                .compose(SchedulersCompat.<AwardsListBean>applyIoSchedulers());
    }
}

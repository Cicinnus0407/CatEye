package com.cicinnus.cateye.module.movie.pick_city;

import com.cicinnus.cateye.net.RetrofitClient;

import io.reactivex.Observable;

/**
 * Created by Cicinnus on 2017/6/8.
 */

public class PickCityManager {
    public Observable<PickCityBean> getCity(){
        return RetrofitClient
                .getInstance()
                .api()
                .getCity();
    }
}

package com.cicinnus.cateye.module.cinema;

import com.cicinnus.cateye.module.cinema.bean.CinemaListBean;
import com.cicinnus.cateye.net.RetrofitClient;

import java.util.Date;

import io.reactivex.Observable;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class CinemaManager {
    public Observable<CinemaListBean> getCinemaBean(int cityId, int offset, int limit, double lat, double lng) {
        Date date = new Date(System.currentTimeMillis());
        return RetrofitClient
                .getInstance()
                .api()
                .getCinemaList(cityId, offset, 1, limit, lat, lng, "android", "7.9.1");

    }
}

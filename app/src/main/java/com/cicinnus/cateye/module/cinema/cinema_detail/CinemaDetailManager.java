package com.cicinnus.cateye.module.cinema.cinema_detail;

import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaMovieBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.FoodsBean;
import com.cicinnus.cateye.net.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by Cicinnus on 2017/6/21.
 */

public class CinemaDetailManager {
    public Observable<CinemaMovieBean> getCinemaMovie(int cinemaId){
        Map<String,Object> map = new HashMap<>();
        map.put("cinemaId",cinemaId);
        map.put("clientType","android");
        map.put("channelId","1");
        return RetrofitClient
                .getInstance()
                .api()
                .getCinemaMovie(map);
    }

    public Observable<CinemaBean> getCinemaData(int cinemaId){
        Map<String,Object> map = new HashMap<>();
        map.put("cinemaId",cinemaId);
        map.put("channelId",1);
        map.put("utm_term","7.9.1");
        return RetrofitClient
                .getInstance()
                .api()
                .getCinemaData(map);
    }

    public Observable<FoodsBean> getFoods(int cinemaId){
        Map<String,Object> map = new HashMap<>();
        map.put("cinemaId",cinemaId);
        map.put("channel",12);
        return RetrofitClient
                .getInstance()
                .api()
                .getFoods(map);
    }
}

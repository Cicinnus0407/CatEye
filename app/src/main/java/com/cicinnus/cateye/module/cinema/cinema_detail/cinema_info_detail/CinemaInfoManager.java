package com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail;

import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean.CinemaCommentBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean.CinemaInfoBean;
import com.cicinnus.cateye.net.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by Cicinnus on 2017/6/26.
 */

public class CinemaInfoManager {

    public Observable<CinemaInfoBean> getCinemaInfo(int cinemaId){
        Map<String,Object> map = new HashMap<>();
        map.put("cinemaId",cinemaId);
        map.put("channelId",1);
        return RetrofitClient
                .getInstance()
                .api()
                .getCinemaInfo(map);
    }

    public Observable<CinemaCommentBean> getCinemaComment(int cinemaId,int offset){
     Map<String,Object> map = new HashMap<>();
        map.put("limit",10);
        map.put("offset",offset);
        return RetrofitClient
                .getInstance()
                .api()
                .getCinemaComment(cinemaId,map);
    }
}

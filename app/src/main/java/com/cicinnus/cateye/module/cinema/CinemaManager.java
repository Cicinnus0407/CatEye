package com.cicinnus.cateye.module.cinema;

import com.cicinnus.cateye.module.cinema.bean.CinemaBannerBean;
import com.cicinnus.cateye.module.cinema.bean.CinemaListBean;
import com.cicinnus.cateye.module.cinema.bean.FilterBean;
import com.cicinnus.cateye.net.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class CinemaManager {
    public Observable<CinemaListBean> getCinemaBean(int cityId, int offset, int limit,
                                                    double lat, double lng,
                                                    int districtId, int areaId,String sort,
                                                    int lineId, int stationId, int brandId,
                                                    int serviceId,int hallType) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("cityId", cityId);
        queryMap.put("offset", offset);
        queryMap.put("channelId", 1);
        queryMap.put("limit", limit);
        queryMap.put("lat", lat);
        queryMap.put("lng", lng);
        queryMap.put("utm_medium", "android");
        queryMap.put("utm_term", "7.9.1");
        if (lineId == -2) {
            queryMap.put("districtId", districtId);
            queryMap.put("areaId", areaId);
        }
        queryMap.put("sort",sort);
        if(districtId==-2) {
            queryMap.put("lineId", lineId);
            queryMap.put("stationId", stationId);
        }
        queryMap.put("brandId", brandId);
        queryMap.put("serviceId",serviceId);
        queryMap.put("hallType",hallType);
        return RetrofitClient
                .getInstance()
                .api()
                .getCinemaList(queryMap);

    }

    public Observable<CinemaBannerBean> getCinemaBanner(int cityId) {
        Map<String, Object> cinemaMap = new HashMap<>();
        cinemaMap.put("cityid", cityId);
        cinemaMap.put("category", 12);
        cinemaMap.put("new", 0);
        cinemaMap.put("partner", 1);
        cinemaMap.put("apptype", 1);
        cinemaMap.put("clienttp", "android");
        cinemaMap.put("app", "movie");
        cinemaMap.put("uuid", "");
        cinemaMap.put("uid", "");
        cinemaMap.put("movieid", "");
        cinemaMap.put("devid", "");

        return RetrofitClient
                .getInstance()
                .api()
                .getBanner(cinemaMap);
    }

    public Observable<FilterBean> getFilter(int cityId) {
        return RetrofitClient
                .getInstance()
                .api()
                .getFilter(cityId);
    }

}

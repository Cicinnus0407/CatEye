package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import com.cicinnus.cateye.net.JsonRequestBody;
import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;
import com.cicinnus.cateye.tools.PostBodyBuilder;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMovieManager {

    private PostBodyBuilder builder;

    public Observable<ResponseBody> getOverseaMovie(String area) {

        builder = new PostBodyBuilder()
                .addKeyValue("GET", "http://api.maoyan.com/mmdb/movie/oversea/recommend.json?area=" + area)
                .addKeyValue("GET", "http://api.maoyan.com/mmdb/movie/oversea/coming.json?area=" + area + "&offset=0&limit=10")
                .addKeyValue("GET", "http://api.maoyan.com/mmdb/movie/oversea/hot.json?area=" + area + "&offset=0&limit=10")
                .build();

        return RetrofitClient
                .getInstance()
                .api()
                .getCombineData(JsonRequestBody.getInstance().convertJsonContent(builder.getRequestBodyContent()))
                .compose(SchedulersCompat.<ResponseBody>applyIoSchedulers());
    }
}



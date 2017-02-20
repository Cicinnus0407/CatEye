package com.cicinnus.cateye.module.movie.movie_detail.movie_resource;

import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieTechnicalsBean;
import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieResourceManager {


    /**
     * 影片技术参数
     * @param movieId
     * @return
     */
    public Observable<MovieTechnicalsBean> getMovieTechnicals(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieTechnicals(movieId)
                .compose(SchedulersCompat.<MovieTechnicalsBean>applyIoSchedulers());
    }
}

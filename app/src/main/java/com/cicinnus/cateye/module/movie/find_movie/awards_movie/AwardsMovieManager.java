package com.cicinnus.cateye.module.movie.find_movie.awards_movie;

import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsBean;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsMovieListBean;
import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;

/**
 * Created by Administrator on 2017/2/6.
 */

public class AwardsMovieManager {


    public Observable<AwardsBean> getAwards(String festivalId){
        return RetrofitClient
                .getInstance()
                .api()
                .getAwards(festivalId)
                .compose(SchedulersCompat.<AwardsBean>applyIoSchedulers());
    }



    public Observable<AwardsMovieListBean> getAwardsMovie(String festSessionId, int offset) {
        return RetrofitClient
                .getInstance()
                .api()
                .getAwardsMovie(festSessionId, 10, offset)
                .compose(SchedulersCompat.<AwardsMovieListBean>applyIoSchedulers());
    }
}

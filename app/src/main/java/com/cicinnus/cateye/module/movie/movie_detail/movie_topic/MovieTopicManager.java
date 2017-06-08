package com.cicinnus.cateye.module.movie.movie_detail.movie_topic;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.Observable;


/**
 * Created by Cicinnus on 2017/2/28.
 */

public class MovieTopicManager {

    public Observable<MovieTopicListBean> getMovieTopicList(int movieId, int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieTopicList(movieId,10,offset)
                .compose(SchedulersCompat.<MovieTopicListBean>applyIoSchedulers());
    }
}

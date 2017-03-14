package com.cicinnus.cateye.module.movie.movie_detail.movie_long_comment;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;

/**
 * Created by Cicinnus on 2017/3/13.
 */

public class MovieLongCommentManager {
    public Observable<MovieLongCommentBeanList> getMovieLongComment(int movieId,int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieLongCommentList(movieId,10,offset)
                .compose(SchedulersCompat.<MovieLongCommentBeanList>applyIoSchedulers());
    }
}

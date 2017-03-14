package com.cicinnus.cateye.module.movie.movie_detail.movie_pro_comment;

import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieProCommentBean;
import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;

/**
 * Created by Cicinnus on 2017/3/13.
 */

public class MovieProCommentManager {
    public Observable<MovieProCommentBean> getMovieProComment(int movieId,int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieProComment(movieId,offset,10)
                .compose(SchedulersCompat.<MovieProCommentBean>applyIoSchedulers());
    }
}

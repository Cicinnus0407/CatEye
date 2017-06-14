package com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment.movie_short_comment_detail;

import com.cicinnus.cateye.net.RetrofitClient;

import io.reactivex.Observable;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class MovieShortCommentDetailManager {
    public Observable<MovieShortCommentDetailBean> getMovieShortCommentDetail(int id,int limit,int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieShortCommentDetail(id,limit,offset);
    }
}

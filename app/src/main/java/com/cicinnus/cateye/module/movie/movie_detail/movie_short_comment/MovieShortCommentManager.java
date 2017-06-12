package com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment;

import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieShortCommentBean;
import com.cicinnus.cateye.net.RetrofitClient;

import io.reactivex.Observable;

/**
 * Created by Cicinnus on 2017/6/12.
 */

public class MovieShortCommentManager {


    public Observable<MovieCommentTagBean> getMovieCommentTag(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieCommentTag(movieId);
    }

    public Observable<MovieShortCommentBean> getMovieShortCommentBean(int movieId, int tag,int limit, int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieShortComment(movieId,tag ,limit,offset);
    }
}

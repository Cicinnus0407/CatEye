package com.cicinnus.cateye.module.movie.movie_detail;

import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieAwardsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieLongCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieMoneyBoxBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieResourceBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieStarBean;
import com.cicinnus.cateye.net.RetrofitClient;

import rx.Observable;

/**
 * Created by Administrator on 2017/2/10.
 */

public class MovieDetailManager {

    /**
     * 获取电影资料
     * @param movieId
     * @return
     */
    public Observable<MovieBasicDataBean> getMovieBasicData(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieBasicData(movieId);
    }

    /**
     * 影星列表
     * @param movieId
     * @return
     */
    public Observable<MovieStarBean> getMovieStarList(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieStarList(movieId);
    }

    /**
     * 获取票房
     * @param movieId
     * @return
     */
    public Observable<MovieMoneyBoxBean> getMovieBox(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieBox(movieId);
    }

    /**
     * 获取获奖情况
     * @param movieId
     * @return
     */
    public Observable<MovieAwardsBean> getMovieAwards(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieAwards(movieId);
    }

    /**
     * 获取电影资料
     * @param movieId
     * @return
     */
    public Observable<MovieResourceBean> getMovieResource(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieResource(movieId);
    }

    /**
     * 评论标签
     * @param movieId
     * @return
     */
    public Observable<MovieCommentTagBean> getMovieCommentTag(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                //20为广州,暂时写死
                .getMovieCommentTag(movieId,20);
    }

    /**
     * 热门长评
     * @param movieId
     * @return
     */
    public Observable<MovieLongCommentBean> getMovieLongComment(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieLongComment();
    }

}

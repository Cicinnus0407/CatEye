package com.cicinnus.cateye.module.movie.movie_detail;

import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieAwardsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieLongCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieMoneyBoxBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieProCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieRelatedInformationBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieResourceBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieStarBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTipsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTopicBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.RelatedMovieBean;
import com.cicinnus.cateye.net.RetrofitClient;

import io.reactivex.ObservableSource;

/**
 * Created by Administrator on 2017/2/10.
 */

public class MovieDetailManager {

    /**
     * 获取电影资料
     * @param movieId
     * @return
     */
    public ObservableSource<MovieBasicDataBean> getMovieBasicData(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieBasicData(movieId);
    }

    public ObservableSource<MovieTipsBean> getMovieTips(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieTipsBean(movieId);
    }

    /**
     * 影星列表
     * @param movieId
     * @return
     */
    public ObservableSource<MovieStarBean> getMovieStarList(int movieId){
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
    public ObservableSource<MovieMoneyBoxBean> getMovieBox(int movieId){
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
    public ObservableSource<MovieAwardsBean> getMovieAwards(int movieId){
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
    public ObservableSource<MovieResourceBean> getMovieResource(int movieId){
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
    public ObservableSource<MovieCommentTagBean> getMovieCommentTag(int movieId){
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
    public ObservableSource<MovieLongCommentBean> getMovieLongComment(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieLongComment(movieId);
    }

    /**
     * 获取专业影评
     * @param movieId
     * @return
     */
    public ObservableSource<MovieProCommentBean> getMovieProComment(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieProComment(movieId,0,3);
    }

    /**
     * 相关资讯
     * @param movieId
     * @return
     */
   public ObservableSource<MovieRelatedInformationBean> getMovieRelatedInformation(int movieId){
       return RetrofitClient
               .getInstance()
               .api()
               .getMovieRelatedInformation(movieId);
   }


    /**
     * 相关电影
     * @param movieId
     * @return
     */
    public ObservableSource<RelatedMovieBean> getRelatedMovie(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getRelatedMovie(movieId);
    }

    /**
     * 相关话题
     * @param movieId
     * @return
     */
    public ObservableSource<MovieTopicBean> getMovieTopic(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieTopic(movieId);
    }

}

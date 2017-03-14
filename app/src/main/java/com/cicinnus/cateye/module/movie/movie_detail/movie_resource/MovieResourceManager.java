package com.cicinnus.cateye.module.movie.movie_detail.movie_resource;

import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieDialoguesBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieHighLightsBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieParentGuidancesBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieRelatedCompanies;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieTechnicalsBean;
import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;


/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieResourceManager {


    /**
     * 幕后花絮
     * @param movieId
     * @return
     */
    public Observable<MovieHighLightsBean> getMovieHighLights(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieHighLights(movieId)
                .compose(SchedulersCompat.<MovieHighLightsBean>applyIoSchedulers());
    }

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

    /**
     * 经典台词
     * @param movieId
     * @return
     */
    public Observable<MovieDialoguesBean> getMovieDialogues(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieDialogues(movieId)
                .compose(SchedulersCompat.<MovieDialoguesBean>applyIoSchedulers());
    }

    /**
     * 出品发行
     * @param movieId
     * @return
     */
    public Observable<MovieRelatedCompanies> getMovieRelatedCompanies(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieRelatedCompanies(movieId)
                .compose(SchedulersCompat.<MovieRelatedCompanies>applyIoSchedulers());
    }

    /**
     * 家长指引
     * @param movieId
     * @return
     */
    public Observable<MovieParentGuidancesBean> getMovieParentGuidances(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getMovieParentGuidances(movieId)
                .compose(SchedulersCompat.<MovieParentGuidancesBean>applyIoSchedulers());
    }
}

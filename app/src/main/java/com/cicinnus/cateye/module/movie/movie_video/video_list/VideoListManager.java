package com.cicinnus.cateye.module.movie.movie_video.video_list;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;

/**
 * Created by Administrator on 2017/2/15.
 */

public class VideoListManager {


    /**
     * 视频列表
     * @param movieId
     * @param offset
     * @return
     */
    public Observable<VideoListBean> getVideoList(int movieId,int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getVideoList(movieId,10,offset)
                .compose(SchedulersCompat.<VideoListBean>applyIoSchedulers());
    }

    public Observable<VideoMovieInfoBean> getVideoMovieInfo(int movieId){
        return RetrofitClient
                .getInstance()
                .api()
                .getVideoMovieInfo(movieId)
                .compose(SchedulersCompat.<VideoMovieInfoBean>applyIoSchedulers());
    }


}

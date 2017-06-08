package com.cicinnus.cateye.module.movie.movie_video.video_comment;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2017/2/17.
 */

public class VideoCommentListManager {
    public Observable<VideoCommentListBean> getVideoComment(int movieId, int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getVideoComment(movieId,"video",10,offset)
                .compose(SchedulersCompat.<VideoCommentListBean>applyIoSchedulers());
    }
}

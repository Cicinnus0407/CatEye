package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.hot_good_comment;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import rx.Observable;

/**
 * Created by Cicinnus on 2017/2/3.
 */

public class HotGoodCommentManager {

    //获取热门口碑电影
    public Observable<HotGoodCommentBean> getHotGoodCommentList(int offset){
        return RetrofitClient
                .getInstance()
                .api()
                .getHotGoodCommentList(10,offset)
                .compose(SchedulersCompat.<HotGoodCommentBean>applyIoSchedulers());
    }
}

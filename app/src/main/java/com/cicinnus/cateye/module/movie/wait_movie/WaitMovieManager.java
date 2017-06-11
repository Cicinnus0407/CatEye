package com.cicinnus.cateye.module.movie.wait_movie;

import com.cicinnus.cateye.module.movie.wait_movie.bean.ExpectMovieBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieMoreBean;
import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Cicinnus on 2017/1/25.
 */

public class WaitMovieManager {

    /**
     * 预告片推荐
     *
     * @return
     */
    public Observable<TrailerRecommendBean> getTrailerRecommendMovie() {
        return RetrofitClient
                .getInstance()
                .api()
                .getTrailerRecommend()
                .compose(SchedulersCompat.<TrailerRecommendBean>applyIoSchedulers());
    }

    /**
     * 最近最受期待
     *
     * @param offset 偏移量
     * @param limit  数量
     * @return
     */
    public Observable<ExpectMovieBean> getRecentExpectList(int offset, int limit) {
        return RetrofitClient
                .getInstance()
                .api()
                .getExpectMovieList(offset, limit)
                .compose(SchedulersCompat.<ExpectMovieBean>applyIoSchedulers());

    }

    public Observable<WaitMovieBean> getWaitMovieList(int limit) {
        return RetrofitClient
                .getInstance()
                .api()
                .getWaitMovieList(limit)
                .compose(SchedulersCompat.<WaitMovieBean>applyIoSchedulers());
    }

    public Observable<WaitMovieBean.DataBean> getMoreWaitMovieList(String movieIds) {
        return RetrofitClient
                .getInstance()
                .api()
                .getMoreWaitMovieList(1, movieIds)
                .map(new Function<WaitMovieMoreBean, WaitMovieBean.DataBean>() {
                    @Override
                    public WaitMovieBean.DataBean apply(@NonNull WaitMovieMoreBean waitMovieMoreBean) throws Exception {
                        WaitMovieBean.DataBean dataBean = new WaitMovieBean.DataBean();
                        List<WaitMovieBean.DataBean.ComingBean> comingBeanList = new ArrayList<>();
                        for (int i = 0; i < waitMovieMoreBean.getData().getMovies().size(); i++) {
                            WaitMovieBean.DataBean.ComingBean comingBean = new WaitMovieBean.DataBean.ComingBean();
                            comingBean.setId(waitMovieMoreBean.getData().getMovies().get(i).getId());
                            comingBean.setNm(waitMovieMoreBean.getData().getMovies().get(i).getNm());
                            comingBean.setSc(waitMovieMoreBean.getData().getMovies().get(i).getSc());
                            comingBean.setWish(waitMovieMoreBean.getData().getMovies().get(i).getWish());
                            comingBean.setStar(waitMovieMoreBean.getData().getMovies().get(i).getStar());
                            comingBean.setImg(waitMovieMoreBean.getData().getMovies().get(i).getImg());
                            comingBean.setComingTitle(waitMovieMoreBean.getData().getMovies().get(i).getComingTitle());
                            comingBeanList.add(comingBean);

                        }
                        dataBean.setComing(comingBeanList);
                        return dataBean;
                    }
                })
                .compose(SchedulersCompat.<WaitMovieBean.DataBean>applyIoSchedulers());

    }
}

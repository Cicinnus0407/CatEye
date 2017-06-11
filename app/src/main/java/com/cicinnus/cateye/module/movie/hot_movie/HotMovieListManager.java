package com.cicinnus.cateye.module.movie.hot_movie;

import com.cicinnus.cateye.net.RetrofitClient;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Cicinnus on 2017/1/24.
 */

public class HotMovieListManager {

    /**
     * 获取热门电影列表
     *
     * @param ci
     * @param limit
     * @return
     */
    public Observable<HotMovieListBean> getHotMovieList(int limit) {
        return RetrofitClient
                .getInstance()
                .api()
                .getHostList(limit);
    }

    /**
     * 获取热门电影更多数据
     *
     * @param ci       默认为20
     * @param headline 默认为0
     * @param movieIds 需要
     * @return
     */
    public Observable<List<HotMovieListBean.DataBean.HotBean>> getMoreMovieList(final int headline, final String movieIds) {
        return Observable.create(new ObservableOnSubscribe<List<HotMovieListBean.DataBean.HotBean>>() {
            @Override
            public void subscribe(final ObservableEmitter<List<HotMovieListBean.DataBean.HotBean>> e) throws Exception {
                RetrofitClient
                        .getInstance()
                        .api()
                        .getHotMovieList( headline, movieIds)
                        .flatMap(new Function<HotMovieListBean, ObservableSource<HotMovieListBean.DataBean.MoviesBean>>() {
                            @Override
                            public ObservableSource<HotMovieListBean.DataBean.MoviesBean> apply(@NonNull HotMovieListBean hotMovieListBean) throws Exception {
                                if (hotMovieListBean.getData().getMovies().size() > 0) {
                                    return Observable.fromIterable(hotMovieListBean.getData().getMovies());
                                }
                                return Observable.error(new Exception("没有更多数据"));
                            }
                        })
                        //map操作符将数据转换为需要的数据
                        .map(new Function<HotMovieListBean.DataBean.MoviesBean, HotMovieListBean.DataBean.HotBean>() {
                            @Override
                            public HotMovieListBean.DataBean.HotBean apply(@NonNull HotMovieListBean.DataBean.MoviesBean moviesBean) throws Exception {
                                HotMovieListBean.DataBean.HotBean hotBean = new HotMovieListBean.DataBean.HotBean();
                                hotBean.setBoxInfo(moviesBean.getBoxInfo());
                                hotBean.setCat(moviesBean.getCat());
                                hotBean.setCivilPubSt(moviesBean.getCivilPubSt());
                                hotBean.setId(moviesBean.getId());
                                hotBean.setShowInfo(moviesBean.getShowInfo());//播放场次
                                hotBean.setSc(moviesBean.getSc());//得分
                                hotBean.setNm(moviesBean.getNm());//片名
                                hotBean.setVer(moviesBean.getVer());//3D标签
                                hotBean.setScm(moviesBean.getScm());//描述
                                hotBean.setPreSale(moviesBean.getPreSale());//是否预售
                                hotBean.setWish(moviesBean.getWish());//期待观影人数
                                hotBean.setImg(moviesBean.getImg());
                                return hotBean;
                            }
                        })
                        .toList()
                        .subscribe(new Consumer<List<HotMovieListBean.DataBean.HotBean>>() {
                            @Override
                            public void accept(@NonNull List<HotMovieListBean.DataBean.HotBean> hotBeen) throws Exception {
                                e.onNext(hotBeen);
                                e.onComplete();
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception {
                                e.onError(throwable);
                            }
                        });
            }
        });

    }
}

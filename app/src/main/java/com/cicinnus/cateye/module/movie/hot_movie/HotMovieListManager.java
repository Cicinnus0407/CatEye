package com.cicinnus.cateye.module.movie.hot_movie;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

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
    public Observable<HotMovieListBean> getHotMovieList(int ci, int limit) {
        return RetrofitClient
                .getInstance()
                .api()
                .getHostList(ci, limit)
                .compose(SchedulersCompat.<HotMovieListBean>applyIoSchedulers());
    }

    /**
     * 获取热门电影更多数据
     * @param ci 默认为20
     * @param headline 默认为0
     * @param movieIds 需要
     * @return
     */
    public Observable<List<HotMovieListBean.DataBean.HotBean>> getMoreMovieList(int ci, int headline, String movieIds) {
        return RetrofitClient
                .getInstance()
                .api()
                .getMoreHotMovieList(ci, headline, movieIds)
                .flatMap(new Func1<HotMovieListBean, Observable<HotMovieListBean.DataBean.MoviesBean>>() {
                    @Override
                    public Observable<HotMovieListBean.DataBean.MoviesBean> call(HotMovieListBean hotMovieListBean) {
                        if(hotMovieListBean.getData().getMovies().size()>0){
                            return Observable.from(hotMovieListBean.getData().getMovies());
                        }
                        return Observable.error(new Exception("没有更多数据"));
                    }
                })
                //map操作符将数据转换为需要的数据
                .map(new Func1<HotMovieListBean.DataBean.MoviesBean, HotMovieListBean.DataBean.HotBean>() {
                    @Override
                    public HotMovieListBean.DataBean.HotBean call(HotMovieListBean.DataBean.MoviesBean moviesBean) {
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
                .compose(SchedulersCompat.<List<HotMovieListBean.DataBean.HotBean>>applyIoSchedulers());
    }
}

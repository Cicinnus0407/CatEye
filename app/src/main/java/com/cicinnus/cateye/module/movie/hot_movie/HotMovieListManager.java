package com.cicinnus.cateye.module.movie.hot_movie;

import com.cicinnus.cateye.net.RetrofitClient;
import com.cicinnus.cateye.net.SchedulersCompat;

import java.util.ArrayList;
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
                //map操作符将数据转换为需要的数据
                .map(new Func1<HotMovieListBean, List<HotMovieListBean.DataBean.HotBean>>() {
                    @Override
                    public List<HotMovieListBean.DataBean.HotBean> call(HotMovieListBean hotMovieListBean) {
                        List<HotMovieListBean.DataBean.MoviesBean> moviesBeanList = hotMovieListBean.getData().getMovies();
                        List<HotMovieListBean.DataBean.HotBean> hotBeanList = new ArrayList<>();
                        for (int i = 0; i < moviesBeanList.size(); i++) {
                            HotMovieListBean.DataBean.HotBean hotBean = new HotMovieListBean.DataBean.HotBean();
                            hotBean.setShowInfo(moviesBeanList.get(i).getShowInfo());//播放场次
                            hotBean.setSc(moviesBeanList.get(i).getSc());//得分
                            hotBean.setNm(moviesBeanList.get(i).getNm());//片名
                            hotBean.setVer(moviesBeanList.get(i).getVer());//3D标签
                            hotBean.setScm(moviesBeanList.get(i).getScm());//描述
                            hotBean.setPreSale(moviesBeanList.get(i).getPreSale());//是否预售
                            hotBean.setWish(moviesBeanList.get(i).getWish());//期待观影人数
                            hotBean.setImg(moviesBeanList.get(i).getImg());
                            hotBeanList.add(hotBean);
                        }
                        return hotBeanList;
                    }
                })
                .compose(SchedulersCompat.<List<HotMovieListBean.DataBean.HotBean>>applyIoSchedulers());
    }
}

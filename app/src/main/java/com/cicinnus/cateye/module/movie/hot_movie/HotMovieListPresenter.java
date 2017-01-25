package com.cicinnus.cateye.module.movie.hot_movie;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.tools.ErrorHanding;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Cicinnus on 2017/1/24.
 */

public class HotMovieListPresenter extends BasePresenter<HotMovieListContract.IHotMovieListView> implements HotMovieListContract.IHotMoviePresenter {

    private final HotMovieListManager hotMovieListManager;

    public HotMovieListPresenter(Activity activity, HotMovieListContract.IHotMovieListView view) {
        super(activity, view);
        hotMovieListManager = new HotMovieListManager();
    }

    @Override
    public void getHotMovieList(int ci, int limit) {
        mView.showLoading();
        addSubscribe(hotMovieListManager.getHotMovieList(ci, limit)
                .subscribe(new Subscriber<HotMovieListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(ErrorHanding.handleError(e));
                    }

                    @Override
                    public void onNext(HotMovieListBean hotMovieListBean) {
                        mView.addMovieIds(hotMovieListBean.getData().getMovieIds());
                        mView.addHotMovieList(hotMovieListBean.getData().getHot());
                    }
                }));
    }

    @Override
    public void getMoreHotMovieList(int ci, int headline, final String movieIds) {
        //map操作符将数据转换为需要的数据再进行发布
        addSubscribe(hotMovieListManager.getMoreMovieList(ci, headline, movieIds)
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
                .subscribe(new Subscriber<List<HotMovieListBean.DataBean.HotBean>>() {
                    @Override
                    public void onCompleted() {
                        mView.loadMoreCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadMoreError();
                    }

                    @Override
                    public void onNext(List<HotMovieListBean.DataBean.HotBean> hotBeen) {
                        mView.addMoreMovieIds(hotBeen);
                    }
                }));
    }
}

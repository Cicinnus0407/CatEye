package com.cicinnus.cateye.module.cinema;

import android.app.Activity;

import com.cicinnus.cateye.module.cinema.bean.CinemaBannerBean;
import com.cicinnus.cateye.module.cinema.bean.CinemaListBean;
import com.cicinnus.cateye.module.cinema.bean.FilterBean;
import com.cicinnus.retrofitlib.base.BaseMVPPresenter;
import com.cicinnus.retrofitlib.net.error.ExceptionHandle;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;
import com.orhanobut.logger.Logger;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class CinemaPresenter extends BaseMVPPresenter<CinemaContract.ICinemaView> implements CinemaContract.ICinemaPresenter {


    private final CinemaManager cinemaManager;

    public CinemaPresenter(Activity activity, CinemaContract.ICinemaView view) {
        super(activity, view);
        cinemaManager = new CinemaManager();
    }

    @Override
    public void getCinema(int cityId, int offset, int limit, double lat, double lng, int districtId,int areaId,
                          String sort,int lineId,int stationId,int brandId,int serviceId,int hallType) {
        mView.showLoading();
        addSubscribeUntilDestroy(cinemaManager.getCinemaBean(cityId, offset, limit, lat, lng, districtId,areaId,sort,lineId,stationId,brandId,serviceId,hallType)
                .compose(SchedulersCompat.<CinemaListBean>applyIoSchedulers())
                .subscribe(new Consumer<CinemaListBean>() {
                    @Override
                    public void accept(@NonNull CinemaListBean cinemaListBean) throws Exception {
                        mView.addCinema(cinemaListBean.getData().getCinemas());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Logger.d(throwable.getMessage());
                        mView.showError(ExceptionHandle.handleException(throwable));
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        mView.showContent();
                    }
                }));
    }

    @Override
    public void getMoreCinema(int cityId, int offset, int limit, double lat, double lng, int districtId,int areaId,String sort,
                              int lineId,int stationId,int brandId,int serviceId,int hallType) {
        addSubscribeUntilDestroy(cinemaManager.getCinemaBean(cityId, offset, limit, lat, lng, districtId,areaId,sort,lineId,stationId,brandId,serviceId,hallType)
                .compose(SchedulersCompat.<CinemaListBean>applyIoSchedulers())
                .subscribe(new Consumer<CinemaListBean>() {
                    @Override
                    public void accept(@NonNull CinemaListBean cinemaListBean) throws Exception {
                        mView.addMoreCinema(cinemaListBean.getData().getCinemas());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.addMoreCinemaFail(ExceptionHandle.handleException(throwable));
                    }
                }));
    }

    @Override
    public void getBanner(int cityId) {
        addSubscribeUntilDestroy(cinemaManager.getCinemaBanner(cityId)
                .compose(SchedulersCompat.<CinemaBannerBean>applyIoSchedulers())
                .subscribe(new Consumer<CinemaBannerBean>() {
                    @Override
                    public void accept(@NonNull CinemaBannerBean cinemaBannerBean) throws Exception {
                        mView.addCinemaBanner(cinemaBannerBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                }));
    }

    @Override
    public void getFilter(int cityId) {
        addSubscribeUntilDestroy(cinemaManager.getFilter(cityId)
                .compose(SchedulersCompat.<FilterBean>applyIoSchedulers())
                .subscribe(new Consumer<FilterBean>() {
                    @Override
                    public void accept(@NonNull FilterBean filterBean) throws Exception {
                        mView.addFilter(filterBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                }));
    }

}

package com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail;

import android.app.Activity;

import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.CinemaInfoContract.ICinemaInfoView;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean.CinemaCommentBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean.CinemaInfoBean;
import com.cicinnus.retrofitlib.base.BaseMVPPresenter;
import com.cicinnus.retrofitlib.net.error.ExceptionHandle;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by Cicinnus on 2017/6/26.
 */

public class CinemaInfoPresenter extends BaseMVPPresenter<ICinemaInfoView> implements CinemaInfoContract.ICinemaInfoPresenter {

    private final CinemaInfoManager cinemaInfoManager;

    public CinemaInfoPresenter(Activity activity, ICinemaInfoView view) {
        super(activity, view);
        cinemaInfoManager = new CinemaInfoManager();
    }

    @Override
    public void getCinemaInfo(int cinemaId) {
        mView.showLoading();
        addSubscribeUntilDestroy(cinemaInfoManager.getCinemaInfo(cinemaId)
                .compose(SchedulersCompat.<CinemaInfoBean>applyIoSchedulers())
                .subscribe(new Consumer<CinemaInfoBean>() {
                    @Override
                    public void accept(@NonNull CinemaInfoBean cinemaInfoBean) throws Exception {
                        mView.addCinemaInfo(cinemaInfoBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
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
    public void getCinemaComment(int cinemaId, int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(cinemaInfoManager.getCinemaComment(cinemaId, offset)
                .compose(SchedulersCompat.<CinemaCommentBean>applyIoSchedulers())
                .subscribe(new Consumer<CinemaCommentBean>() {
                    @Override
                    public void accept(@NonNull CinemaCommentBean commentBean) throws Exception {
                        mView.addCinemaComment(commentBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
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
    public void getMoreCinemaComment(int cinemaId, int offset) {
        addSubscribeUntilDestroy(cinemaInfoManager.getCinemaComment(cinemaId, offset)
                .compose(SchedulersCompat.<CinemaCommentBean>applyIoSchedulers())
                .subscribe(new Consumer<CinemaCommentBean>() {
                    @Override
                    public void accept(@NonNull CinemaCommentBean commentBean) throws Exception {
                        mView.addMoreCinemaComment(commentBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.addMoreCinemaCommentFail(ExceptionHandle.handleException(throwable));
                    }
                }));
    }
}

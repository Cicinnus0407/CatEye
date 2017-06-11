package com.cicinnus.cateye.module.movie.wait_movie;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.wait_movie.bean.ExpectMovieBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.cateye.tools.ErrorHanding;
import com.orhanobut.logger.Logger;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Cicinnus on 2017/1/25.
 */

public class WaitMovieMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<WaitMovieFragmentContract.IWaitMovieView> implements WaitMovieFragmentContract.IWaitMoviePresenter {

    private final WaitMovieManager waitMovieManager;

    public WaitMovieMVPPresenter(Activity activity, WaitMovieFragmentContract.IWaitMovieView view) {
        super(activity, view);
        waitMovieManager = new WaitMovieManager();
    }

    @Override
    public void getTrailerRecommendMovie() {
        addSubscribeUntilDestroy(waitMovieManager.getTrailerRecommendMovie()
                .subscribe(new Consumer<TrailerRecommendBean>() {
                    @Override
                    public void accept(@NonNull TrailerRecommendBean trailerRecommendBean) throws Exception {
                        mView.addTrailerRecommendMovieList(trailerRecommendBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                }));
    }

    @Override
    public void getRecentExpect(int offset, int limit) {
        mView.showLoading();
        addSubscribeUntilDestroy(waitMovieManager.getRecentExpectList(offset, limit)
                .subscribe(new Consumer<ExpectMovieBean>() {
                    @Override
                    public void accept(@NonNull ExpectMovieBean expectMovieBean) throws Exception {
                        mView.addRecentExpectMovieList(expectMovieBean.getData().getComing());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.showError(ErrorHanding.handleError(throwable));

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        mView.showContent();
                    }
                }));
    }

    @Override
    public void getWaitMovieList(int limit, int offset, int limit2) {
        mView.showLoading();
        //按顺序发射三组数据
        addSubscribeUntilDestroy(Observable.concatArray(
                waitMovieManager.getWaitMovieList(limit),
                waitMovieManager.getTrailerRecommendMovie(),
                waitMovieManager.getRecentExpectList(offset, limit2))
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        if (o instanceof WaitMovieBean) {
                            mView.addWaitMovieList(((WaitMovieBean) o).getData().getComing());
                            mView.addIds(((WaitMovieBean) o).getData().getMovieIds());
                        } else if (o instanceof TrailerRecommendBean) {
                            mView.addTrailerRecommendMovieList(((TrailerRecommendBean) o).getData());
                        } else if (o instanceof ExpectMovieBean) {
                            mView.addRecentExpectMovieList(((ExpectMovieBean) o).getData().getComing());

                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Logger.d(throwable.getMessage());
                        mView.showError(ErrorHanding.handleError(throwable));
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        mView.showContent();
                    }
                }));
    }

    @Override
    public void getMoreWaitMovie(String s) {
        addSubscribeUntilDestroy(waitMovieManager.getMoreWaitMovieList(s)
                .subscribe(new Consumer<WaitMovieBean.DataBean>() {
                    @Override
                    public void accept(@NonNull WaitMovieBean.DataBean dataBean) throws Exception {
                        mView.addMoreWaitMovie(dataBean.getComing());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                        mView.loadMoreFail();
                    }
                }));
    }


}

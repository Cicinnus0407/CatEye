package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.most_expect;

import android.app.Activity;

import com.cicinnus.cateye.tools.ErrorHanding;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Administrator on 2017/2/4.
 */

public class MostExpectMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<MostExpectMovieContract.IRecentExpectMovieView> implements MostExpectMovieContract.IRecentExpectMoviePresenter {

    private final MostExpectMovieManager mostExpectMovieManager;

    public MostExpectMVPPresenter(Activity activity, MostExpectMovieContract.IRecentExpectMovieView view) {
        super(activity, view);
        mostExpectMovieManager = new MostExpectMovieManager();
    }

    @Override
    public void getRecentExpectMovie(int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(mostExpectMovieManager.getRecentExpectMovieList(offset)
        .subscribe(new Consumer<MostExpectMovieBean>() {
            @Override
            public void accept(@NonNull MostExpectMovieBean mostExpectMovieBean) throws Exception {
                mView.addData(mostExpectMovieBean.getData().getContent(),mostExpectMovieBean.getData().getCreated());
                mView.addRecentExpectMovie(mostExpectMovieBean.getData());
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
}

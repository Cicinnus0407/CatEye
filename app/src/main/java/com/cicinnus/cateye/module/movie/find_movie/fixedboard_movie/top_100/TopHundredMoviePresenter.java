package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.top_100;

import android.app.Activity;

import com.cicinnus.cateye.tools.ErrorHanding;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Cicinnus on 2017/2/5.
 */

public class TopHundredMoviePresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<TopHundredMovieContract.ITopHundredMovieView> implements TopHundredMovieContract.ITopHUndredMoviePresenter {

    private final TopHundredMovieManager topHundredMovieManager;

    public TopHundredMoviePresenter(Activity activity, TopHundredMovieContract.ITopHundredMovieView view) {
        super(activity, view);
        topHundredMovieManager = new TopHundredMovieManager();
    }


    @Override
    public void getTopHundredMovie(int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(topHundredMovieManager.getTopHundredMovie(offset)
                .subscribe(new Consumer<TopHundredMovieBean>() {
                    @Override
                    public void accept(@NonNull TopHundredMovieBean topHundredMovieBean) throws Exception {
                        mView.addContent(topHundredMovieBean.getData().getCreated(),topHundredMovieBean.getData().getContent());
                        mView.addTopHundredMovie(topHundredMovieBean.getData().getMovies());
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

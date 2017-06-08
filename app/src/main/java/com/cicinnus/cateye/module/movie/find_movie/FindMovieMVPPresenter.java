package com.cicinnus.cateye.module.movie.find_movie;

import android.app.Activity;

import com.cicinnus.cateye.module.movie.find_movie.bean.AwardsMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.GridMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;
import com.cicinnus.cateye.tools.ErrorHanding;
import com.cicinnus.retrofitlib.base.BaseMVPPresenter;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Cicinnus on 2017/2/2.
 */

public class FindMovieMVPPresenter extends BaseMVPPresenter<FindMovieContract.IFindMovieView> implements FindMovieContract.IFindMoviePresenter {

    private final FindMovieManager findMovieManager;

    public FindMovieMVPPresenter(Activity activity, FindMovieContract.IFindMovieView view) {
        super(activity, view);
        findMovieManager = new FindMovieManager();

    }

    @Override
    public void getFindMovieData() {
        mView.showLoading();
        //merge合并多个请求
        addSubscribeUntilDestroy(Observable
                .mergeArray(findMovieManager.getMovieTypeList(),
                        findMovieManager.getMovieGrid(),
                        findMovieManager.getAwardsMovie())
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        if (o instanceof MovieTypeBean) {
                            mView.addMovieType(((MovieTypeBean) o).getData().get(0).getTagList());
                            mView.addMovieNation(((MovieTypeBean) o).getData().get(1).getTagList());
                            mView.addMoviePeriod(((MovieTypeBean) o).getData().get(2).getTagList());
                        } else if (o instanceof GridMovieBean) {
                            mView.addMovieGrid(((GridMovieBean) o).getData());
                        } else if (o instanceof AwardsMovieBean) {
                            mView.addAwardsMovie(((AwardsMovieBean) o).getData());

                        }
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

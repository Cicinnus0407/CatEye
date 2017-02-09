package com.cicinnus.cateye.module.movie.find_movie;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.module.movie.find_movie.bean.AwardsMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.GridMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;
import com.cicinnus.cateye.net.SchedulersCompat;
import com.cicinnus.cateye.tools.ErrorHanding;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Cicinnus on 2017/2/2.
 */

public class FindMoviePresenter extends BasePresenter<FindMovieContract.IFindMovieView> implements FindMovieContract.IFindMoviePresenter {

    private final FindMovieManager findMovieManager;

    public FindMoviePresenter(Activity activity, FindMovieContract.IFindMovieView view) {
        super(activity, view);
        findMovieManager = new FindMovieManager();

    }

    @Override
    public void getFindMovieData() {
        mView.showLoading();
        //merge合并多个请求
        addSubscribe(Observable
                .merge(findMovieManager.getMovieTypeList(),
                        findMovieManager.getMovieGrid(),
                        findMovieManager.getAwardsMovie())
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(ErrorHanding.handleError(e));

                    }

                    @Override
                    public void onNext(Object o) {
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
                }));

    }

}

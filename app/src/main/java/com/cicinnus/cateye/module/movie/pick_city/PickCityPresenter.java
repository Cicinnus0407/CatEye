package com.cicinnus.cateye.module.movie.pick_city;

import android.app.Activity;

import com.cicinnus.retrofitlib.base.BaseMVPPresenter;
import com.cicinnus.retrofitlib.net.error.ExceptionHandle;
import com.cicinnus.retrofitlib.rx.SchedulersCompat;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by Cicinnus on 2017/6/8.
 */

public class PickCityPresenter extends BaseMVPPresenter<PickCityContract.IPickCityView> implements PickCityContract.IPickCityPresenter {

    private final PickCityManager pickCityManager;

    public PickCityPresenter(Activity activity, PickCityContract.IPickCityView view) {
        super(activity, view);
        pickCityManager = new PickCityManager();
    }

    @Override
    public void getCity() {
        mView.showLoading();
        addSubscribeUntilDestroy(pickCityManager.getCity()
                .compose(SchedulersCompat.<PickCityBean>applyIoSchedulers())
                .subscribe(new Consumer<PickCityBean>() {
                    @Override
                    public void accept(@NonNull PickCityBean pickCityBean) throws Exception {
                        mView.addCity(pickCityBean.getCts());
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
}

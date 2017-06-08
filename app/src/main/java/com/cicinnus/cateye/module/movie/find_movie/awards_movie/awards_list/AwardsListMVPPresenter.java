package com.cicinnus.cateye.module.movie.find_movie.awards_movie.awards_list;

import android.app.Activity;

import com.cicinnus.retrofitlib.net.error.ExceptionHandle;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/2/7.
 */

public class AwardsListMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<AwardsListContract.IAwardsListView> implements AwardsListContract.IAwardsListPresenter {

    private final AwardsListManager awardsListManager;

    public AwardsListMVPPresenter(Activity activity, AwardsListContract.IAwardsListView view) {
        super(activity, view);
        awardsListManager = new AwardsListManager();
    }

    @Override
    public void getAwardsList() {
        mView.showLoading();
        addSubscribeUntilDestroy(awardsListManager.getAwardsList()
                .subscribe(new Consumer<AwardsListBean>() {
                    @Override
                    public void accept(@NonNull AwardsListBean awardsListBean) throws Exception {
                        mView.addAwardsList(awardsListBean.getData());

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

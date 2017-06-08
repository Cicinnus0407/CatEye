package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.hot_good_comment;

import android.app.Activity;

import com.cicinnus.cateye.tools.ErrorHanding;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by Cicinnus on 2017/2/3.
 */

public class HotGoodCommentMVPPresenter extends com.cicinnus.retrofitlib.base.BaseMVPPresenter<HotGoodCommentContract.IHotGoodCommentView> implements HotGoodCommentContract.IHotGoodCommentPresenter {

    private final HotGoodCommentManager hotGoodCommentManager;

    public HotGoodCommentMVPPresenter(Activity activity, HotGoodCommentContract.IHotGoodCommentView view) {
        super(activity, view);
        hotGoodCommentManager = new HotGoodCommentManager();
    }

    @Override
    public void getHotGoodCommentList(int offset) {
        mView.showLoading();
        addSubscribeUntilDestroy(hotGoodCommentManager.getHotGoodCommentList(offset)
                .subscribe(new Consumer<HotGoodCommentBean>() {
                    @Override
                    public void accept(@NonNull HotGoodCommentBean hotGoodCommentBean) throws Exception {
                        mView.addListHeader(hotGoodCommentBean.getData().getCreated(),hotGoodCommentBean.getData().getContent());
                        mView.addTitle(hotGoodCommentBean.getData().getTitle());
                        mView.addHotGoodCommentList(hotGoodCommentBean);
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

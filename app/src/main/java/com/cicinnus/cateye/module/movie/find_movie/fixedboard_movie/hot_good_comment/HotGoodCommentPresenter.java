package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.hot_good_comment;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.tools.ErrorHanding;

import rx.Subscriber;

/**
 * Created by Cicinnus on 2017/2/3.
 */

public class HotGoodCommentPresenter extends BasePresenter<HotGoodCommentContract.IHotGoodCommentView> implements HotGoodCommentContract.IHotGoodCommentPresenter {

    private final HotGoodCommentManager hotGoodCommentManager;

    public HotGoodCommentPresenter(Activity activity, HotGoodCommentContract.IHotGoodCommentView view) {
        super(activity, view);
        hotGoodCommentManager = new HotGoodCommentManager();
    }

    @Override
    public void getHotGoodCommentList(int offset) {
        mView.showLoading();
        addSubscribe(hotGoodCommentManager.getHotGoodCommentList(offset)
                .subscribe(new Subscriber<HotGoodCommentBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(ErrorHanding.handleError(e));
                    }

                    @Override
                    public void onNext(HotGoodCommentBean hotGoodCommentBean) {
                        mView.addListHeader(hotGoodCommentBean.getData().getCreated(),hotGoodCommentBean.getData().getContent());
                        mView.addTitle(hotGoodCommentBean.getData().getTitle());
                        mView.addHotGoodCommentList(hotGoodCommentBean);
                    }
                }));
    }
}

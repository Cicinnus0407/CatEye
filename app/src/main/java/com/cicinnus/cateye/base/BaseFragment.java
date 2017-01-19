package com.cicinnus.cateye.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/1/18.
 */

public abstract class BaseFragment<T extends IPresenter> extends Fragment {

    protected Activity mContext;
    protected T mPresenter;
    private boolean isInit;
    private boolean isLoad;

    @Override
    public void onAttach(Context context) {
        mContext = (Activity) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, rootView);
        isInit = true;
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = getPresenter();
        initEventAndData();
        initEventAndData(savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        loadData();
    }

    private void loadData() {
        if (!isInit) {
            return;
        }

        if (getUserVisibleHint()) {
            lazyLoad();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }

    /**
     * 懒加载实现该方法
     */
    protected void lazyLoad() {

    }

    /**
     * 取消加载
     */
    protected void stopLoad(){

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }


    protected T getPresenter() {
        return null;
    }

    protected abstract int getLayoutId();


    protected void initEventAndData(Bundle saveData) {
    }

    protected void initEventAndData() {
    }


}

package com.cicinnus.retrofitlib.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseFragment，拥有懒加载方法
 */

public abstract class BaseMVPFragment<T extends ICorePresenter> extends Fragment {
    protected Activity mContext;
    protected T mPresenter;
    private boolean isInit;
    private boolean isLoad;
    protected View rootView;
    private Unbinder mUnbinder;
    @Override
    public void onAttach(Context context) {
        mContext = (Activity) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), container, false);
        isInit = true;
        mUnbinder = ButterKnife.bind(this, rootView);
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
            lazyLoadEveryTime();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }

    /**
     * 懒加载实现该方法，里面的方法在Fragment每次的重现中会再次调用，
     * 如果只需加载一次，需自行增加判断
     */
    protected void lazyLoadEveryTime() {

    }

    /**
     * 取消懒加载
     */
    protected void stopLoad() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
        if (mUnbinder != Unbinder.EMPTY) mUnbinder.unbind();
    }


    @Override
    public void onStop() {
        super.onStop();
        if (mPresenter != null) mPresenter.onViewStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onViewDestroy();
    }


    protected T getPresenter() {
        return null;
    }

    protected abstract int getLayoutId();


    protected void initEventAndData(Bundle saveData) {
    }

    protected abstract void initEventAndData();


}

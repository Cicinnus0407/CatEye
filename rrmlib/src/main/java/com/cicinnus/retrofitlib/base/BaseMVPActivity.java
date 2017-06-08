package com.cicinnus.retrofitlib.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseActivity
 */

public abstract class BaseMVPActivity<T extends ICorePresenter> extends AppCompatActivity {
    protected Activity mContext;
    protected T mPresenter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mContext = this;
        mPresenter = getPresenter();
        initEventAndData(savedInstanceState);
        initEventAndData();
    }

    /**
     * onStop方法调用Presenter的取消调用链方法
     */
    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter != null) {
            mPresenter.onViewStop();
        }
    }

    /**
     * onDestroy方法调用Presenter的取消调用链方法
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onViewDestroy();
        }
        if (unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
        }
    }

    /**
     * 获取Presenter
     *
     * @return IPresenter的实现类
     * 例 ： new xxPresenter(mContext,this);
     * 由于不是每个Activity都必须为MVP，在需要使用的时候需要手动调用getPresent
     */
    protected T getPresenter() {
        return mPresenter;
    }

    /**
     * 布局Id
     * R.layout.xx
     */
    public abstract int getLayoutId();

    /**
     * 初始化时间和数据,调用在onCreate方法中
     */
    protected abstract void initEventAndData();

    /**
     * 带Bundle的方法,用于恢复Fragment获取其他属性的方法时候可以调用
     */
    protected void initEventAndData(Bundle savedInstanceState) {

    }
}

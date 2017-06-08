package com.cicinnus.cateye.base;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cicinnus.cateye.R;
import com.cicinnus.retrofitlib.base.BaseMVPActivity;
import com.cicinnus.retrofitlib.base.ICorePresenter;

/**
 * Created by Administrator on 2017/1/18.
 */

public abstract class BaseActivity<T extends ICorePresenter> extends BaseMVPActivity<T> {


    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
//        this.initEventAndData();

    }

    @Override
    public int getLayoutId() {
        return getLayout();
    }

    protected abstract int getLayout();

    @Override
    protected void initEventAndData() {
        initToolbar();
    }

    private void initToolbar() {

    }

    protected void setUpToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void setupSwipe(SwipeRefreshLayout swipe, SwipeRefreshLayout.OnRefreshListener listener) {
        swipe.setColorSchemeResources(R.color.colorPrimary);
        swipe.setOnRefreshListener(listener);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

}

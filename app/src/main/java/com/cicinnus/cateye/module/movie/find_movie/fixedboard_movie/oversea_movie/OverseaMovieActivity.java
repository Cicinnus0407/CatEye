package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMovieActivity extends BaseActivity {


    public static void start(Context context) {
        Intent starter = new Intent(context, OverseaMovieActivity.class);
        context.startActivity(starter);
    }

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tab_oversea)
    TabLayout tabOversea;

    private OverseaMovieMVPFragment overseaMovieFragment1;
    private OverseaMovieMVPFragment overseaMovieFragment2;
    private OverseaMovieMVPFragment overseaMovieFragment3;

    @Override
    protected int getLayout() {
        return R.layout.activity_oversea_movie;
    }

    @Override
    protected void initEventAndData(Bundle savedInstance) {
        tvTitle.setText("海外电影");
        setupFragment(savedInstance);
        tabOversea.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switchFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabOversea.addTab(tabOversea.newTab().setText("美国"), true);
        tabOversea.addTab(tabOversea.newTab().setText("韩国"));
        tabOversea.addTab(tabOversea.newTab().setText("日本"));
    }

    @OnClick({R.id.rl_back})
    void onClick(View view){
        finish();
    }

    private void setupFragment(Bundle savedInstance) {
        if (savedInstance != null) {
            overseaMovieFragment1 = (OverseaMovieMVPFragment) getSupportFragmentManager().findFragmentByTag("overseaMovieFragment1");
            overseaMovieFragment2 = (OverseaMovieMVPFragment) getSupportFragmentManager().findFragmentByTag("overseaMovieFragment2");
            overseaMovieFragment3 = (OverseaMovieMVPFragment) getSupportFragmentManager().findFragmentByTag("overseaMovieFragment3");

            switchFragment(0);
        } else {
            overseaMovieFragment1 = OverseaMovieMVPFragment.newInstance("NA");
            overseaMovieFragment2 = OverseaMovieMVPFragment.newInstance("KR");
            overseaMovieFragment3 = OverseaMovieMVPFragment.newInstance("JP");


            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_container_oversea_movie, overseaMovieFragment1, "overseaMovieFragment1")
                    .add(R.id.fl_container_oversea_movie, overseaMovieFragment2, "overseaMovieFragment2")
                    .add(R.id.fl_container_oversea_movie, overseaMovieFragment3, "overseaMovieFragment3")
                    .commit();
            switchFragment(0);

        }
    }


    private void switchFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                overseaMovieFragment1.setUserVisibleHint(true);
                overseaMovieFragment2.setUserVisibleHint(false);
                overseaMovieFragment3.setUserVisibleHint(false);
                transaction
                        .show(overseaMovieFragment1)
                        .hide(overseaMovieFragment2)
                        .hide(overseaMovieFragment3);
                break;
            case 1:
                overseaMovieFragment2.setUserVisibleHint(true);
                overseaMovieFragment1.setUserVisibleHint(false);
                overseaMovieFragment3.setUserVisibleHint(false);
                transaction
                        .show(overseaMovieFragment2)
                        .hide(overseaMovieFragment1)
                        .hide(overseaMovieFragment3);
                break;
            case 2:
                overseaMovieFragment3.setUserVisibleHint(true);
                overseaMovieFragment2.setUserVisibleHint(false);
                overseaMovieFragment1.setUserVisibleHint(false);
                transaction
                        .show(overseaMovieFragment3)
                        .hide(overseaMovieFragment2)
                        .hide(overseaMovieFragment1);
                break;
        }
        transaction.commit();
    }

    @Override
    protected void onPause() {
        overridePendingTransition(0,0);
        super.onPause();
    }
}

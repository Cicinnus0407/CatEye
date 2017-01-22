package com.cicinnus.cateye.base;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.CinemaFragment;
import com.cicinnus.cateye.module.discover.DiscoverFragment;
import com.cicinnus.cateye.module.mine.MineFragment;
import com.cicinnus.cateye.module.movie.movie_main.MovieMainFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/18.
 */

public class MainActivity extends BaseActivity {


    @BindView(R.id.rg_main)
    RadioGroup rg_main;

    private MovieMainFragment movieMainFragment;
    private CinemaFragment cinemaFragment;
    private DiscoverFragment discoverFragment;
    private MineFragment mineFragment;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData(Bundle savedStated) {

        setupRg();

        if (savedStated != null) {
            movieMainFragment = (MovieMainFragment) getSupportFragmentManager().findFragmentByTag("movieMainFragment");
            cinemaFragment = (CinemaFragment) getSupportFragmentManager().findFragmentByTag("cinemaFragment");
            discoverFragment = (DiscoverFragment) getSupportFragmentManager().findFragmentByTag("discoverFragment");
            mineFragment = (MineFragment) getSupportFragmentManager().findFragmentByTag("mineFragment");
            switchFragment(BaseConstant.RB_MOVIE);

        } else {
            movieMainFragment = MovieMainFragment.newInstance();
            cinemaFragment = CinemaFragment.newInstance();
            discoverFragment = DiscoverFragment.newInstance();
            mineFragment = MineFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fl_container_main, movieMainFragment, "movieMainFragment")
                    .add(R.id.fl_container_main, cinemaFragment, "cinemaFragment")
                    .add(R.id.fl_container_main, discoverFragment, "discoverFragment")
                    .add(R.id.fl_container_main, mineFragment, "mineFragment")
                    .commit();
            switchFragment(BaseConstant.RB_MOVIE);

        }
    }

    /**
     * RadioGroup点击监听
     */
    private void setupRg() {
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_movie:
                        switchFragment(BaseConstant.RB_MOVIE);
                        break;
                    case R.id.rb_cinema:
                        switchFragment(BaseConstant.RB_CINEMA);
                        break;
                    case R.id.rb_discover:
                        switchFragment(BaseConstant.RB_DISCOVER);
                        break;
                    case R.id.rb_mine:
                        switchFragment(BaseConstant.RB_MINE);
                        break;
                }
            }
        });
    }

    /**
     * 切换Fragment
     *
     * @param index
     */
    private void switchFragment(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (index) {
            case BaseConstant.RB_MOVIE:
                transaction
                        .show(movieMainFragment)
                        .hide(cinemaFragment)
                        .hide(discoverFragment)
                        .hide(mineFragment);
                movieMainFragment.setUserVisibleHint(true);
                cinemaFragment.setUserVisibleHint(false);
                discoverFragment.setUserVisibleHint(false);
                mineFragment.setUserVisibleHint(false);
                break;
            case BaseConstant.RB_CINEMA:
                transaction
                        .show(cinemaFragment)
                        .hide(movieMainFragment)
                        .hide(discoverFragment)
                        .hide(mineFragment);
                cinemaFragment.setUserVisibleHint(true);
                movieMainFragment.setUserVisibleHint(false);
                discoverFragment.setUserVisibleHint(false);
                mineFragment.setUserVisibleHint(false);
                break;
            case BaseConstant.RB_DISCOVER:
                transaction
                        .show(discoverFragment)
                        .hide(cinemaFragment)
                        .hide(movieMainFragment)
                        .hide(mineFragment);
                discoverFragment.setUserVisibleHint(true);
                cinemaFragment.setUserVisibleHint(false);
                movieMainFragment.setUserVisibleHint(false);
                mineFragment.setUserVisibleHint(false);
                break;
            case BaseConstant.RB_MINE:
                transaction
                        .show(mineFragment)
                        .hide(cinemaFragment)
                        .hide(discoverFragment)
                        .hide(movieMainFragment);
                mineFragment.setUserVisibleHint(true);
                cinemaFragment.setUserVisibleHint(false);
                discoverFragment.setUserVisibleHint(false);
                movieMainFragment.setUserVisibleHint(false);
                break;
        }
        transaction.commit();
    }
}

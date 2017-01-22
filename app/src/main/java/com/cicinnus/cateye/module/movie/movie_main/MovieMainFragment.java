package com.cicinnus.cateye.module.movie.movie_main;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;
import com.cicinnus.cateye.module.movie.find_movie.FindMovieFragment;
import com.cicinnus.cateye.module.movie.hot_movie.HotMovieFragment;
import com.cicinnus.cateye.module.movie.wait_movie.WaitMovieFragment;
import com.orhanobut.logger.Logger;

import java.util.Arrays;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/18.
 */

public class MovieMainFragment extends BaseFragment {

    public static MovieMainFragment newInstance() {
        return new MovieMainFragment();
    }


    private HotMovieFragment hotMovieFragment;
    private WaitMovieFragment waitMovieFragment;
    private FindMovieFragment findMovieFragment;


    @BindView(R.id.tv_hot_movie)
    TextView tvHotMovie;
    @BindView(R.id.tv_wait_movie)
    TextView tvWaitMovie;
    @BindView(R.id.tv_find_movie)
    TextView tvFindView;
    @BindView(R.id.vp_movie)
    ViewPager vp_movie;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initEventAndData(Bundle saveData) {
        hotMovieFragment = HotMovieFragment.newInstance();
        waitMovieFragment = WaitMovieFragment.newInstance();
        findMovieFragment = FindMovieFragment.newInstance();
        MovieMainAdapter movieMainAdapter = new MovieMainAdapter(getFragmentManager());
        Fragment[] fragments = new Fragment[]{hotMovieFragment, waitMovieFragment, findMovieFragment};
        String[] titles = new String[]{"热映", "待映", "找片"};
        movieMainAdapter.addFragment(Arrays.asList(fragments), Arrays.asList(titles));
        vp_movie.setAdapter(movieMainAdapter);
        vp_movie.setOffscreenPageLimit(3);


        final Drawable drawable = getResources().getDrawable(R.drawable.bg_tv_indicator);
        final int selectedColor = getResources().getColor(R.color.colorAccent);
        final int unSelectedColor = getResources().getColor(android.R.color.white);

        final int startX = (int) tvHotMovie.getX();
        Logger.d(startX);

        vp_movie.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("滑动", "onPageScrolled: " + positionOffset);
                if (positionOffset != 0.0) {
                    ObjectAnimator animator = ObjectAnimator.ofFloat(drawable, "scale", startX,startX+positionOffsetPixels);
                    animator.start();
                }
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        tvHotMovie.setBackground(drawable);
                        tvHotMovie.setTextColor(selectedColor);
                        tvWaitMovie.setBackground(null);
                        tvWaitMovie.setTextColor(unSelectedColor);
                        tvFindView.setBackground(null);
                        tvFindView.setTextColor(unSelectedColor);
                        break;
                    case 1:
                        tvHotMovie.setBackground(null);
                        tvHotMovie.setTextColor(unSelectedColor);
                        tvWaitMovie.setBackground(drawable);
                        tvWaitMovie.setTextColor(selectedColor);
                        tvFindView.setBackground(null);
                        tvFindView.setTextColor(unSelectedColor);
                        break;
                    case 2:
                        tvHotMovie.setBackground(null);
                        tvHotMovie.setTextColor(unSelectedColor);
                        tvWaitMovie.setBackground(null);
                        tvWaitMovie.setTextColor(unSelectedColor);
                        tvFindView.setBackground(drawable);
                        tvFindView.setTextColor(selectedColor);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

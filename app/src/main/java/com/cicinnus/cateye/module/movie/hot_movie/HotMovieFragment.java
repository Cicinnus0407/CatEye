package com.cicinnus.cateye.module.movie.hot_movie;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;

/**
 * Created by Cicinnus on 2017/1/22.
 */

public class HotMovieFragment extends BaseFragment {

    public static HotMovieFragment newInstance() {

        HotMovieFragment fragment = new HotMovieFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot_movie;
    }
}

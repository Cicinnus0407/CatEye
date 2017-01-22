package com.cicinnus.cateye.module.movie.find_movie;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;

/**
 * Created by Cicinnus on 2017/1/22.
 */

public class FindMovieFragment extends BaseFragment {

    public static FindMovieFragment newInstance() {
        FindMovieFragment fragment = new FindMovieFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find_movie;
    }
}

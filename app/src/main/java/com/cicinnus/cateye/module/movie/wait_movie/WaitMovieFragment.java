package com.cicinnus.cateye.module.movie.wait_movie;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;

/**
 * Created by Cicinnus on 2017/1/22.
 */

public class WaitMovieFragment extends BaseFragment {

    public static WaitMovieFragment newInstance() {


        WaitMovieFragment fragment = new WaitMovieFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wait_movie;
    }
}

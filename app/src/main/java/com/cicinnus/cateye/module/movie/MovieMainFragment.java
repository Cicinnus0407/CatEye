package com.cicinnus.cateye.module.movie;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;

/**
 * Created by Administrator on 2017/1/18.
 */

public class MovieMainFragment extends BaseFragment {

    public static MovieMainFragment newInstance() {
        return new MovieMainFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie;
    }
}

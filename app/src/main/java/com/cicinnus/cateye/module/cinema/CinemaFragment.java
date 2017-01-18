package com.cicinnus.cateye.module.cinema;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;

/**
 * Created by Administrator on 2017/1/18.
 */

public class CinemaFragment extends BaseFragment {

    public static CinemaFragment newInstance() {

        return new CinemaFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cinema;
    }
}

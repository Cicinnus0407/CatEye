package com.cicinnus.cateye.module.cinema;

import com.cicinnus.cateye.R;
import com.cicinnus.retrofitlib.base.BaseMVPFragment;

/**
 * 影院列表
 */

public class CinemaFragment extends BaseMVPFragment {

    public static CinemaFragment newInstance() {

        return new CinemaFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected void initEventAndData() {

    }
}

package com.cicinnus.cateye.module.cinema;

import com.cicinnus.cateye.R;
import com.cicinnus.retrofitlib.base.BaseMVPFragment;

/**
 * Created by Administrator on 2017/1/18.
 */

public class CinemaMVPFragment extends BaseMVPFragment {

    public static CinemaMVPFragment newInstance() {

        return new CinemaMVPFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected void initEventAndData() {

    }
}

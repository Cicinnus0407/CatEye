package com.cicinnus.cateye.module.mine;

import com.cicinnus.cateye.R;
import com.cicinnus.retrofitlib.base.BaseMVPFragment;

/**
 * Created by Administrator on 2017/1/18.
 */

public class MineMVPFragment extends BaseMVPFragment {

    public static MineMVPFragment newInstance() {

        return new MineMVPFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initEventAndData() {

    }
}

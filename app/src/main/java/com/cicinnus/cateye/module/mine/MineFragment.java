package com.cicinnus.cateye.module.mine;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;

/**
 * Created by Administrator on 2017/1/18.
 */

public class MineFragment extends BaseFragment {

    public static MineFragment newInstance() {

        return new MineFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
}

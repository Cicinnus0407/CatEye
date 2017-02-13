package com.cicinnus.cateye.module.movie.movie_detail.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;

/**
 * Created by Administrator on 2017/2/13.
 */

public class MovieAwardsAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public MovieAwardsAdapter() {
        super(R.layout.item_movie_awards,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_award_name,item);
    }
}

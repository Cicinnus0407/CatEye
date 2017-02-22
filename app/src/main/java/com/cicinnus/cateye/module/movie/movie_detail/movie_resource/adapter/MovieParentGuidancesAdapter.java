package com.cicinnus.cateye.module.movie.movie_detail.movie_resource.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieParentGuidancesBean;

/**
 * Created by Cicinnus on 2017/2/22.
 */

public class MovieParentGuidancesAdapter extends BaseQuickAdapter<MovieParentGuidancesBean.DataBean.GovBean,BaseViewHolder> {
    public MovieParentGuidancesAdapter() {
        super(R.layout.item_movie_parent_guidances, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieParentGuidancesBean.DataBean.GovBean item) {
        helper.setText(R.id.tv_movie_parent_guidances,item.getDesc());
    }
}

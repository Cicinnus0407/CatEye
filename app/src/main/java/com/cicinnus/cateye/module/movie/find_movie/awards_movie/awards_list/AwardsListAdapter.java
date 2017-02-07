package com.cicinnus.cateye.module.movie.find_movie.awards_movie.awards_list;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;

/**
 * Created by Administrator on 2017/2/7.
 */

public class AwardsListAdapter extends BaseQuickAdapter<AwardsListBean.DataBean.FestivalsBean,BaseViewHolder> {

    public AwardsListAdapter() {
        super(R.layout.item_awards_list, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, AwardsListBean.DataBean.FestivalsBean item) {
        helper.setText(R.id.tv_award_name,item.getFestivalName());
    }
}

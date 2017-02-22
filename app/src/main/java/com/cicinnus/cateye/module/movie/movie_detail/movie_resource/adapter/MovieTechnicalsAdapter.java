package com.cicinnus.cateye.module.movie.movie_detail.movie_resource.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieTechnicalsBean;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieTechnicalsAdapter extends BaseQuickAdapter<MovieTechnicalsBean.DataBean.ItemsBean,BaseViewHolder> {
    public MovieTechnicalsAdapter() {
        super(R.layout.item_movie_technicals, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieTechnicalsBean.DataBean.ItemsBean item) {
        helper.setText(R.id.tv_technicals_title,item.getTitle())
                .setText(R.id.tv_technicals_content,item.getDesc());
    }
}

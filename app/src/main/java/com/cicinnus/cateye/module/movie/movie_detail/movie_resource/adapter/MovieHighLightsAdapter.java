package com.cicinnus.cateye.module.movie.movie_detail.movie_resource.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieHighLightsBean;
import com.cicinnus.cateye.tools.GlideManager;

/**
 * Created by Cicinnus on 2017/2/22.
 */

public class MovieHighLightsAdapter extends BaseQuickAdapter<MovieHighLightsBean.DataBean.ItemsBean,BaseViewHolder> {
    public MovieHighLightsAdapter() {
        super(R.layout.item_movie_hight_lights, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieHighLightsBean.DataBean.ItemsBean item) {
        helper.setText(R.id.tv_movie_high_lights_desc,item.getDesc());
        if (item.getProvider() != null) {
            helper.setText(R.id.tv_username,String.format("%s 添加",item.getProvider().getUserName()));
            GlideManager.loadImage(mContext,item.getProvider().getAvatarUrl(), (ImageView) helper.getView(R.id.civ_username));
        }
    }
}

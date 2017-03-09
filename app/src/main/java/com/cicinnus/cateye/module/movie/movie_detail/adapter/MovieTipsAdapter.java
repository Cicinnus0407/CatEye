package com.cicinnus.cateye.module.movie.movie_detail.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieTipsBean;
import com.cicinnus.cateye.tools.GlideManager;

/**
 * Created by Cicinnus on 2017/3/7.
 */

public class MovieTipsAdapter extends BaseQuickAdapter<MovieTipsBean.DataBean.TipsBean,BaseViewHolder>{
    public MovieTipsAdapter() {
        super(R.layout.item_movie_tips,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieTipsBean.DataBean.TipsBean item) {
        helper.setText(R.id.tv_tips,item.getContent());
        GlideManager.loadImage(mContext,item.getTipImg(), (ImageView) helper.getView(R.id.iv_tips));
    }
}

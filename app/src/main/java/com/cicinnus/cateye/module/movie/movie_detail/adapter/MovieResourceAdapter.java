package com.cicinnus.cateye.module.movie.movie_detail.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieResourceBean;
import com.cicinnus.cateye.tools.GlideManager;

/**
 * Created by Administrator on 2017/2/13.
 */

public class MovieResourceAdapter extends BaseQuickAdapter<MovieResourceBean.DataBean,BaseViewHolder> {
    public MovieResourceAdapter() {
        super(R.layout.item_movie_resource, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieResourceBean.DataBean item) {
        helper.setText(R.id.tv_movie_resource_title,item.getTitle())
                .setText(R.id.tv_movie_resource_content,item.getContent());

        GlideManager.loadImage(mContext,item.getImg(), (ImageView) helper.getView(R.id.iv_movie_resource));
    }
}

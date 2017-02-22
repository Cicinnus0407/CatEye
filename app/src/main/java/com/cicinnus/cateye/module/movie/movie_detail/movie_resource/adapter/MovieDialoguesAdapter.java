package com.cicinnus.cateye.module.movie.movie_detail.movie_resource.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.MovieDialoguesBean;
import com.cicinnus.cateye.tools.GlideManager;

/**
 * Created by Cicinnus on 2017/2/22.
 */

public class MovieDialoguesAdapter extends BaseQuickAdapter<MovieDialoguesBean.DataBean.ItemsBean,BaseViewHolder> {
    public MovieDialoguesAdapter() {
        super(R.layout.item_movie_dialogues, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieDialoguesBean.DataBean.ItemsBean item) {
        helper.setText(R.id.tv_dialogues_desc,item.getDesc())
                .setText(R.id.tv_username,String.format("%s 添加",item.getProvider().getUserName()));

        GlideManager.loadImage(mContext,item.getProvider().getAvatarUrl(), (ImageView) helper.getView(R.id.civ_username));
    }
}

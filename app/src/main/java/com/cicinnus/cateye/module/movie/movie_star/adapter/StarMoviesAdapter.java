package com.cicinnus.cateye.module.movie.movie_star.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_star.bean.StarMoviesBean;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

/**
 * Created by Cicinnus on 2017/2/19.
 */

public class StarMoviesAdapter extends BaseQuickAdapter<StarMoviesBean.DataBean.MoviesBean,BaseViewHolder> {
    public StarMoviesAdapter() {
        super(R.layout.item_star_movies, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, StarMoviesBean.DataBean.MoviesBean item) {
        helper.setText(R.id.tv_movie_title,item.getTitle())
                .setText(R.id.tv_movie_name,item.getName())
                .setText(R.id.tv_movie_role,item.getMultiroles()==null||item.getMultiroles().equals("")?
                        item.getMutlidutys():item.getMultiroles());

        String imgUrl = ImgSizeUtil.resetPicUrl(item.getAvatar(),".webp@210w_285h_1e_1c_1l");
        GlideManager.loadImage(mContext,imgUrl, (ImageView) helper.getView(R.id.iv_movie_img));
    }
}

package com.cicinnus.cateye.module.movie.find_movie.adapter;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.find_movie.bean.GridMovieBean;
import com.cicinnus.cateye.tools.GlideManager;

/**
 * Created by Cicinnus on 2017/2/2.
 */

public class FindMovieGridAdapter extends BaseQuickAdapter<GridMovieBean.DataBean, BaseViewHolder> {
    public FindMovieGridAdapter() {
        super(R.layout.item_grid_movie, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, GridMovieBean.DataBean item) {
        helper.setText(R.id.tv_grid_movie_type, item.getBoardName())
                .setText(R.id.tv_grid_movie_name, item.getMovieName());


        TextView tv_type = helper.getView(R.id.tv_grid_movie_type);
        int color = 0;
        switch (item.getBoardId()) {
            case 4:
                color = Color.parseColor("#FF76C231");
                break;
            case 6:
                color = Color.parseColor("#FFF35846");
                break;
            case 7:
                color = Color.parseColor("#21a9ef");
                break;
            case 9:
                color = Color.parseColor("#FFF67B2E");
                break;

        }
        tv_type.setTextColor(color);


        String originalUrl0 = item.getMovieImgs().get(0);
        String imgUrl0 = originalUrl0.replace("/w.h/", "/") + ".webp@129w_183h_1e_1c_1l";
        String originalUrl1 = item.getMovieImgs().get(1);
        String imgUrl1 = originalUrl1.replace("/w.h/", "/") + ".webp@129w_183h_1e_1c_1l";
        GlideManager.loadImage(mContext, imgUrl0, (ImageView) helper.getView(R.id.iv_grid2));
        GlideManager.loadImage(mContext, imgUrl1, (ImageView) helper.getView(R.id.iv_grid1));
    }
}

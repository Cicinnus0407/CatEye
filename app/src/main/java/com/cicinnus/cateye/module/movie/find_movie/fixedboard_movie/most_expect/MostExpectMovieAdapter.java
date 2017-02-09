package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.most_expect;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

/**
 * Created by Administrator on 2017/2/4.
 */

public class MostExpectMovieAdapter extends BaseQuickAdapter<MostExpectMovieBean.DataBean.MoviesBean, BaseViewHolder> {

    public MostExpectMovieAdapter() {
        super(R.layout.item_recent_expect, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MostExpectMovieBean.DataBean.MoviesBean item) {

        String imgUrl = ImgSizeUtil.processUrl(item.getImg(), 224, 315);
        GlideManager.loadImage(mContext, imgUrl, (ImageView) helper.getView(R.id.iv_movie_img));


        if (helper.getAdapterPosition() < 4) {
            ((ImageView) helper.getView(R.id.iv_movie_rank)).setImageResource(R.drawable.ic_yellow_angle_small);
        } else {
            ((ImageView) helper.getView(R.id.iv_movie_rank)).setImageResource(R.drawable.ic_gray_angle);
        }

        helper.setText(R.id.tv_movie_name, item.getNm())
                .setText(R.id.tv_movie_desc, item.getStar())
                .setText(R.id.tv_movie_desc, item.getPubDesc())
                .setText(R.id.tv_total_wish, String.format("总想看:%s人", item.getWish()))
                .setText(R.id.tv_new_wish, String.format("%s", item.getMonthWish()))
                .setText(R.id.tv_movie_rank, String.format("%s", helper.getAdapterPosition()));
    }
}

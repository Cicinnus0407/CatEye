package com.cicinnus.cateye.module.movie.find_movie.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.find_movie.bean.AwardsMovieBean;
import com.cicinnus.cateye.tools.GlideManager;

/**
 * Created by Cicinnus on 2017/2/2.
 */

public class AwardsMovieAdapter extends BaseQuickAdapter<AwardsMovieBean.DataBean,BaseViewHolder>{

    public AwardsMovieAdapter() {
        super(R.layout.item_awards_movie, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, AwardsMovieBean.DataBean item) {
        helper.setText(R.id.tv_award_movie_title,item.getFestivalName())
                .setText(R.id.tv_award_movie_time,item.getHeldDate().substring(5,item.getHeldDate().length()))
                .setText(R.id.tv_award_prize_name,item.getPrizeName())
                .setText(R.id.tv_award_movie_name,item.getMovieName());

        String originUrl = item.getImg();
        String imgUrl = originUrl.replace("/w.h/", "/") + ".webp@345w_480h_1e_1c_1l";//后缀为图片大小
        GlideManager.loadImage(mContext, imgUrl, (ImageView) helper.getView(R.id.iv_award_movie));

    }
}

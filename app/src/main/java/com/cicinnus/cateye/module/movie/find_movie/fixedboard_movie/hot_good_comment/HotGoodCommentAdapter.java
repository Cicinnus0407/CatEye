package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.hot_good_comment;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

/**
 * Created by Cicinnus on 2017/2/3.
 */

public class HotGoodCommentAdapter extends BaseQuickAdapter<HotGoodCommentBean.DataBean.MoviesBean,BaseViewHolder> {

    public HotGoodCommentAdapter() {
        super(R.layout.item_hot_good_comment,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, HotGoodCommentBean.DataBean.MoviesBean item) {

        String imgUrl = ImgSizeUtil.processUrl(item.getImg(),224,315);
        GlideManager.loadImage(mContext,imgUrl, (ImageView) helper.getView(R.id.iv_movie_img));

        helper.setText(R.id.tv_movie_name,item.getNm())
                .setText(R.id.tv_movie_star,item.getStar())
                .setText(R.id.tv_movie_pubDesc,item.getPubDesc())
                .setText(R.id.tv_movie_score,String.format("%s",item.getSc()))
                .setText(R.id.tv_movie_rank,String.format("%s",helper.getAdapterPosition()));
        if(helper.getAdapterPosition()<4){
            ((ImageView) helper.getView(R.id.iv_movie_rank)).setImageResource(R.drawable.ic_yellow_angle_small);
        }else {
            ((ImageView) helper.getView(R.id.iv_movie_rank)).setImageResource(R.drawable.ic_gray_angle);

        }
    }
}

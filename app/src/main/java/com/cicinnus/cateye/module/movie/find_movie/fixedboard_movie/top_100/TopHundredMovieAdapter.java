package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.top_100;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_detail.MovieDetailActivity;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class TopHundredMovieAdapter extends BaseQuickAdapter<TopHundredMovieBean.DataBean.MoviesBean,BaseViewHolder> {
    public TopHundredMovieAdapter() {
        super(R.layout.item_top_hundred_movie,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, final TopHundredMovieBean.DataBean.MoviesBean item) {
        String imgUrl = ImgSizeUtil.processUrl(item.getImg(),224,315);
        GlideManager.loadImage(mContext,imgUrl, (ImageView) helper.getView(R.id.iv_movie_img));

        helper.setText(R.id.tv_movie_name,item.getNm())
                .setText(R.id.tv_movie_desc,item.getStar())
                .setText(R.id.tv_movie_desc,item.getPubDesc())
                .setText(R.id.tv_movie_score,String.format("%s",item.getSc()))
                .setText(R.id.tv_movie_rank,String.format("%s",helper.getAdapterPosition()));
        if(helper.getAdapterPosition()<4){
            ((ImageView) helper.getView(R.id.iv_movie_rank)).setImageResource(R.drawable.ic_yellow_angle_small);
        }else {
            ((ImageView) helper.getView(R.id.iv_movie_rank)).setImageResource(R.drawable.ic_gray_angle);

        }
        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieDetailActivity.start(mContext,item.getId());
            }
        });
    }
}

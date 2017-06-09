package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.oversea_movie_total_list.OverSeaMovieListActivity;
import com.cicinnus.cateye.module.movie.movie_detail.MovieDetailActivity;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMovieAdapter extends BaseMultiItemQuickAdapter<OverseaHotMovieBean.DataBean.HotBean,BaseViewHolder> {




    public OverseaMovieAdapter() {
        super(null);
        addItemType(BaseConstant.TYPE_OVERSEA_NORMAL, R.layout.item_oversea_movie);
        addItemType(BaseConstant.TYPE_OVERSEA_HEAD_LINE,R.layout.item_oversea_movie_headline);
//        addItemType(BaseConstant.TYPE_OVERSEA_BUY,R.layout.item_oversea_movie_buy);
        addItemType(BaseConstant.TYPE_OVERSEA_PRESALE,R.layout.item_oversea_movie_presell);
        addItemType(BaseConstant.TYPE_OVERSEA_FOOTER,R.layout.item_normal_list_footer);
    }

    @Override
    protected void convert(BaseViewHolder helper, final OverseaHotMovieBean.DataBean.HotBean item) {

        if(helper.getItemViewType()!=BaseConstant.TYPE_OVERSEA_FOOTER) {
            String imgUrl = ImgSizeUtil.resetPicUrl(item.getImg(), ".webp@171w_240h_1e_1c_1l");
            GlideManager.loadImage(mContext, imgUrl, (ImageView) helper.getView(R.id.iv_movie_img));
        }
        switch (helper.getItemViewType()){
            case BaseConstant.TYPE_OVERSEA_NORMAL:
                helper.setText(R.id.tv_movie_name,item.getNm())
                        .setText(R.id.tv_movie_type,item.getCat())
                        .setText(R.id.tv_movie_desc,item.getStar())
                        .setText(R.id.tv_movie_wish,String.format("%s",item.getWish()));
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MovieDetailActivity.start(mContext,item.getId());
                    }
                });
                break;
            case BaseConstant.TYPE_OVERSEA_HEAD_LINE:
                helper.setText(R.id.tv_movie_name,item.getNm())
                        .setText(R.id.tv_movie_desc,item.getDesc())
                        .setText(R.id.tv_movie_star,item.getStar())
                        .setText(R.id.tv_movie_score,String.format("%s",item.getSc()))
                        .setText(R.id.tv_hot_type1,item.getHeadLinesVO().get(0).getType())
                        .setText(R.id.tv_hot_type2,item.getHeadLinesVO().get(1).getType())
                        .setText(R.id.tv_hot_headline_title1,item.getHeadLinesVO().get(0).getTitle())
                        .setText(R.id.tv_hot_headline_title2,item.getHeadLinesVO().get(1).getTitle());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MovieDetailActivity.start(mContext,item.getId());
                    }
                });
                break;
            case BaseConstant.TYPE_OVERSEA_PRESALE:
                helper.setText(R.id.tv_movie_name,item.getNm())
                        .setText(R.id.tv_movie_type,item.getCat())
                        .setText(R.id.tv_movie_desc,item.getDesc())
                        .setText(R.id.tv_movie_wish,String.format("%s",item.getWish()));
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MovieDetailActivity.start(mContext,item.getId());
                    }
                });
                break;
            case BaseConstant.TYPE_OVERSEA_FOOTER:
                helper.setText(R.id.tv_footer,item.getFooterName());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OverSeaMovieListActivity.start(mContext,item.getArea(),item.getType());

                    }
                });
                break;
        }


    }

}

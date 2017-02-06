package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie.bean.OverseaHotMovieBean;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMovieAdapter extends BaseMultiItemQuickAdapter<OverseaHotMovieBean.DataBean.HotBean,BaseViewHolder> {




    public OverseaMovieAdapter() {
        super(null);
        addItemType(BaseConstant.TYPE_OVERSEA_NORMAL, R.layout.item_oversea_movie);
        addItemType(BaseConstant.TYPE_OVERSEA_BUY_MULIT,R.layout.item_oversea_movie_headline);
        addItemType(BaseConstant.TYPE_OVERSEA_BUY,R.layout.item_oversea_movie_buy);
        addItemType(BaseConstant.TYPE_OVERSEA_PRESALE,R.layout.item_oversea_movie_presell);
    }

    @Override
    protected void convert(BaseViewHolder helper, OverseaHotMovieBean.DataBean.HotBean item) {
        switch (helper.getItemViewType()){
            case BaseConstant.TYPE_OVERSEA_NORMAL:
                helper.setText(R.id.tv_movie_name,item.getNm())
                        .setText(R.id.tv_movie_type,item.getCat())
                        .setText(R.id.tv_movie_star,item.getStar())
                        .setText(R.id.tv_movie_wish,String.format("%s",item.getWish()));
                break;
        }
    }
}

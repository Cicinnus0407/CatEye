package com.cicinnus.cateye.module.movie.movie_detail.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_detail.bean.RelatedMovieBean;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

/**
 * Created by Cicinnus on 2017/2/13.
 */

public class RelatedMovieAdapter extends BaseQuickAdapter<RelatedMovieBean.DataBean.ItemsBean,BaseViewHolder> {
    public RelatedMovieAdapter() {
        super(R.layout.item_related_movie, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, RelatedMovieBean.DataBean.ItemsBean item) {
        //255*234
        helper.setText(R.id.tv_movie_name,item.getTitle())
                .setText(R.id.tv_movie_score,String.format("%s",item.getSc()==0?"暂无评分":item.getSc()));
        String imgUrl = ImgSizeUtil.processUrl(item.getImg(),255,345);
        GlideManager.loadImage(mContext,imgUrl, (ImageView) helper.getView(R.id.iv_movie_img));
    }
}

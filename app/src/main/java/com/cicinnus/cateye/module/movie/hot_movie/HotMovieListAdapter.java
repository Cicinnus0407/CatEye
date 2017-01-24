package com.cicinnus.cateye.module.movie.hot_movie;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.tools.GlideManager;

/**
 * Created by Cicinnus on 2017/1/24.
 */

public class HotMovieListAdapter extends BaseMultiItemQuickAdapter<HotMovieListBean.DataBean.HotBean, BaseViewHolder> {


    public HotMovieListAdapter() {
        super(null);
        addItemType(BaseConstant.TYPE_HOT_HEADLINE, R.layout.item_hot_headline);
        addItemType(BaseConstant.TYPE_HOT_NORMAL, R.layout.item_hot_normal);
    }


    @Override
    protected void convert(BaseViewHolder helper, HotMovieListBean.DataBean.HotBean item) {
        helper.setText(R.id.tv_hot_movie_name, String.format("%s", item.getNm()))
                .setText(R.id.tv_hot_desc, String.format("%s", item.getScm()))
                .setText(R.id.tv_hot_showInfo, String.format("%s", item.getShowInfo()));
        String originUrl = item.getImg();
        String imgUrl = originUrl.replace("/w.h/","/")+"@171w_240h_1e_1c_1l";//后缀为图片大小
        GlideManager.loadImage(mContext, imgUrl, (ImageView) helper.getView(R.id.iv_hot_img));
        switch (helper.getItemViewType()) {
            case BaseConstant.TYPE_HOT_HEADLINE:

                helper
                        .setText(R.id.tv_hot_type1, String.format("%s", item.getHeadLinesVO().get(0).getType()))
                        .setText(R.id.tv_hot_type2, String.format("%s", item.getHeadLinesVO().get(1).getType()))
                        .setText(R.id.tv_hot_headline_title1, String.format("%s", item.getHeadLinesVO().get(0).getTitle()))
                        .setText(R.id.tv_hot_headline_title2, String.format("%s", item.getHeadLinesVO().get(1).getTitle()));
                break;
            case BaseConstant.TYPE_HOT_NORMAL:

                break;
        }
    }
}

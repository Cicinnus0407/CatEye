package com.cicinnus.cateye.module.movie.wait_movie.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.tools.GlideManager;

import java.util.List;

/**
 * Created by Cicinnus on 2017/1/26.
 */

public class TrailerRecommendAdapter extends BaseQuickAdapter<TrailerRecommendBean.DataBean,BaseViewHolder> {


    public TrailerRecommendAdapter(@Nullable List<TrailerRecommendBean.DataBean> data) {
        super(R.layout.item_wait_movie_trailer_recommend, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, TrailerRecommendBean.DataBean item) {

        GlideManager.loadImage(mContext,item.getImg()+".webp@405w_225h_1e_1c_1l", (ImageView) helper.getView(R.id.iv_trailer_recommend));
        helper.setText(R.id.tv_trailer_movie_title,item.getMovieName())
                .setText(R.id.tv_trailer_movie_desc,item.getName());
    }
}

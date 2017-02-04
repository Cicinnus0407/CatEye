package com.cicinnus.cateye.module.movie.wait_movie.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.wait_movie.bean.ExpectMovieBean;
import com.cicinnus.cateye.tools.GlideManager;

/**
 * Created by Cicinnus on 2017/1/26.
 */

public class RecentExpectAdapter extends BaseQuickAdapter<ExpectMovieBean.DataBean.ComingBean, BaseViewHolder> {
    public RecentExpectAdapter() {
        super(R.layout.item_wait_movie_recent_expect, null);
    }

    @Override
    protected void convert(final BaseViewHolder helper, ExpectMovieBean.DataBean.ComingBean item) {


        String originUrl = item.getImg();
        String imgUrl = originUrl.replace("/w.h/", "/") + "@345w_480h_1e_1c_1l";
        GlideManager.loadImage(mContext, imgUrl, (ImageView) helper.getView(R.id.iv_recent_expect));
        helper.setText(R.id.tv_recent_expect_movie_name, item.getNm())
                .setText(R.id.tv_recent_expect_wish, String.format("%s人想看", item.getWish()))
                .setText(R.id.tv_recent_expect_time,item.getComingTitle().substring(0,item.getComingTitle().indexOf(" ")));
    }
}

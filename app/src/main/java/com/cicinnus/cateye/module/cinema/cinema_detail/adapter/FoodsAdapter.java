package com.cicinnus.cateye.module.cinema.cinema_detail.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.FoodsBean;
import com.cicinnus.cateye.tools.GlideManager;

/**
 * Created by Cicinnus on 2017/6/22.
 */

public class FoodsAdapter extends BaseQuickAdapter<FoodsBean.DataBean.DealListBean, BaseViewHolder> {
    public FoodsAdapter() {
        super(R.layout.item_foods);
    }

    @Override
    protected void convert(BaseViewHolder helper, FoodsBean.DataBean.DealListBean item) {
        helper.setText(R.id.tv_foods_title, item.getFirstTitle())
                .setText(R.id.tv_foods_desc, item.getSecondTitle())
                .setText(R.id.tv_foods_price, String.format("%s元", item.getPrice()))
                .setText(R.id.tv_orin_price, String.format("影院价: %s元", item.getValue()));

        GlideManager.loadImage(mContext, item.getImageUrl().replace("/w.h/","/"), (ImageView) helper.getView(R.id.iv_foods));
    }
}

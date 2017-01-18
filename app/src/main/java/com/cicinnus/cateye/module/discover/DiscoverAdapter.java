package com.cicinnus.cateye.module.discover;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.TimeUtils;

/**
 * Created by Administrator on 2017/1/18.
 */

public class DiscoverAdapter extends BaseQuickAdapter<DiscoverBean.DataBean.FeedsBean, BaseViewHolder> {
    public DiscoverAdapter() {
        super(R.layout.item_discover, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, DiscoverBean.DataBean.FeedsBean item) {
        helper.setText(R.id.tv_disc_title, item.getTitle())
                .setText(R.id.tv_nickName, item.getUser().getNickName())
                .setText(R.id.tv_time, TimeUtils.dateYMDHM(item.getTime()));

        ImageView iv_img = helper.getView(R.id.iv_img);
        GlideManager.loadImage(mContext, item.getImages().get(0).getUrl(), iv_img);

    }
}

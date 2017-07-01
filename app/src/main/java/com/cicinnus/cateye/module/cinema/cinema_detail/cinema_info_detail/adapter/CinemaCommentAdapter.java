package com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean.CinemaCommentBean;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.view.ExpandTextView;

/**
 * Created by Cicinnus on 2017/6/26.
 */

public class CinemaCommentAdapter extends BaseQuickAdapter<CinemaCommentBean.CmtsBean,BaseViewHolder> {
    public CinemaCommentAdapter() {
        super(R.layout.item_cinema_comment);
    }

    @Override
    protected void convert(BaseViewHolder helper, CinemaCommentBean.CmtsBean item) {
        helper.setText(R.id.tv_username,item.getNickName())
                .setText(R.id.tv_date,item.getTime().substring(5,9));

        ExpandTextView tv = helper.getView(R.id.tv_content);
        tv.setText(item.getContent());
//        RatingBar rb = helper.getView(R.id.rb_score);
//        rb.setStar(item.getS()==0?item.getS():0);

        GlideManager.loadImage(mContext,item.getAvatarurl(), (ImageView) helper.getView(R.id.civ_author));

    }
}

package com.cicinnus.cateye.module.movie.movie_detail.adapter;

import android.graphics.drawable.Drawable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieShortCommentBean;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.TimeUtils;
import com.cicinnus.cateye.view.CircleImageView;

/**
 * Created by Administrator on 2017/2/13.
 */

public class MovieShortCommentAdapter extends BaseQuickAdapter<MovieShortCommentBean.DataBean.HcmtsBean,BaseViewHolder> {
    public MovieShortCommentAdapter() {
        super(R.layout.item_short_comment,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieShortCommentBean.DataBean.HcmtsBean item) {
        helper.setText(R.id.tv_author_name,item.getNickName())
                .setText(R.id.tv_comment_content,String.format("%s",item.getContent()))
                .setText(R.id.tv_approve_count,String.format("%s",item.getApprove()))
                .setText(R.id.tv_reply_count,String.format("%s",item.getReply()))
                .setText(R.id.tv_pub_time, TimeUtils.dateMD(item.getCreated()));

        Drawable icon = null;
        switch (item.getUserLevel()){
            case 1:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv1);
                break;
            case 2:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv2);
                break;
            case 3:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv3);
                break;
            case 4:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv4);
                break;
            case 5:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv5);
                break;
        }
        helper.setImageDrawable(R.id.iv_user_level,icon);
        GlideManager.loadImage(mContext,item.getAvatarurl(), (CircleImageView) helper.getView(R.id.civ_author));
    }
}

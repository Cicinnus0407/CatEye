package com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment.movie_short_comment_detail;

import android.graphics.drawable.Drawable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.TimeUtils;
import com.cicinnus.cateye.view.CircleImageView;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class MovieShortCommentDetailAdapter extends BaseQuickAdapter<MovieShortCommentDetailBean.CmtsBean, BaseViewHolder> {

    public MovieShortCommentDetailAdapter() {
        super(R.layout.item_short_comment_detail);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieShortCommentDetailBean.CmtsBean item) {
        helper
                .setText(R.id.tv_author_name, String.format("%s",item.getNickName()))
                .setText(R.id.tv_time, String.format("%s", TimeUtils.daysAgo(TimeUtils.dateToMillions(item.getTime()))))
                .setText(R.id.tv_content, String.format("%s", item.getContent()))
                .setText(R.id.tv_approve_count,String.format("%s",item.getApprove()==0?"赞":item.getApprove()));
        helper.setVisible(R.id.ll_reply, item.getRef() != null&&!item.getRef().isDeleted());
        if (item.getRef() != null&&!item.getRef().isDeleted()) {
            helper.setText(R.id.tv_reply_name, String.format("回复 %s", item.getRef().getNickName()))
                    .setText(R.id.tv_reply_content, item.getRef().getContent());
        }

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
        GlideManager.loadImage(mContext,item.getAvatarurl(), R.drawable.ic_user_default,(CircleImageView) helper.getView(R.id.civ_author));


    }
}

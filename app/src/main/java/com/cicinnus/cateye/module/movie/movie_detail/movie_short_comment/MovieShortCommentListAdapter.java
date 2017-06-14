package com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieShortCommentBean;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.TimeUtils;
import com.cicinnus.cateye.view.CircleImageView;
import com.cicinnus.cateye.view.RatingBar;

/**
 * Created by Cicinnus on 2017/6/12.
 */

public class MovieShortCommentListAdapter extends BaseQuickAdapter<MovieShortCommentBean.DataBean.CmtsBean,BaseViewHolder> {


    private OnShortCommentClickListener onShortCommentClickListener;

    public MovieShortCommentListAdapter() {
        super(R.layout.item_short_comment,null);

    }

    @Override
    protected void convert(BaseViewHolder helper, final MovieShortCommentBean.DataBean.CmtsBean item) {
        helper.setText(R.id.tv_author_name,item.getNickName())
                .setText(R.id.tv_comment_content,String.format("%s",item.getContent()))
                .setText(R.id.tv_approve_count,String.format("%s",item.getApprove()==0?"赞":item.getApprove()))
                .setText(R.id.tv_reply_count,String.format("%s",item.getReply()==0?"回复":item.getReply()))
                .setText(R.id.tv_pub_time, TimeUtils.dateMD(item.getCreated()));

        RatingBar ratingBar = helper.getView(R.id.rb_score);
        ratingBar.setStar(item.getScore().floatValue());

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

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onShortCommentClickListener != null) {
                    onShortCommentClickListener.onClick(item.getId());
                }
            }
        });
    }

    public void setOnShortCommentClickListener(OnShortCommentClickListener onShortCommentClickListener) {
        this.onShortCommentClickListener = onShortCommentClickListener;
    }

    public interface OnShortCommentClickListener{
        void onClick(int id);
    }
}

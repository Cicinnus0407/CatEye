package com.cicinnus.cateye.module.movie.movie_video.video_comment;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.UserUtils;
import com.cicinnus.cateye.view.ExpandTextView;

/**
 *
 */

public class VideoCommentAdapter extends BaseMultiItemQuickAdapter<VideoCommentListBean.DataBean.CommentsBean,BaseViewHolder> {

    public VideoCommentAdapter() {
        super(null);
        addItemType(BaseConstant.TYPE_VIDEO_COMMENT_NO_REPLY, R.layout.item_video_comment_no_reply);
        addItemType(BaseConstant.TYPE_VIDEO_COMMENT_REPLY,R.layout.item_video_comment_reply);
    }


    @Override
    protected void convert(BaseViewHolder helper, VideoCommentListBean.DataBean.CommentsBean item) {

        helper.setText(R.id.tv_author_name,item.getNickName())
                .setText(R.id.tv_comment_content,item.getContent())
                .setText(R.id.tv_pub_time, item.getTime());

        if(item.getAvatarUrl().equals("")){
            helper.setImageResource(R.id.civ_author,R.drawable.icon_default);
        }else {
            GlideManager.loadImage(mContext,item.getAvatarUrl(), (ImageView) helper.getView(R.id.civ_author));
        }
        helper.setImageDrawable(R.id.iv_user_level, UserUtils.getUserLevelLable(mContext,item.getUserLevel()));
        switch (helper.getItemViewType()){
            case BaseConstant.TYPE_VIDEO_COMMENT_REPLY:
                helper.setText(R.id.tv_reply,String.format("回复%s:",item.getRef().getNickName()));
                ((ExpandTextView) helper.getView(R.id.tv_reply_content)).setText(item.getRef().getContent());
                break;
            case BaseConstant.TYPE_VIDEO_COMMENT_NO_REPLY:

                break;
        }
    }
}

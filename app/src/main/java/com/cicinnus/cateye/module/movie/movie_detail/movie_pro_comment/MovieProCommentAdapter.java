package com.cicinnus.cateye.module.movie.movie_detail.movie_pro_comment;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieProCommentBean;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.TimeUtils;

/**
 * Created by Cicinnus on 2017/3/7.
 */

public class MovieProCommentAdapter extends BaseQuickAdapter<MovieProCommentBean.DataBean,BaseViewHolder> {
    public MovieProCommentAdapter() {
        super(R.layout.item_movie_pro_comment, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieProCommentBean.DataBean item) {
        helper.setText(R.id.tv_author_name,item.getNickName())
                .setText(R.id.tv_author_title,item.getAuthInfo())
                .setText(R.id.tv_comment_content,item.getContent())
                .setText(R.id.tv_createDate, TimeUtils.dateYMD(item.getCreated()))
                .setText(R.id.tv_score,String.format("%s",(int)(item.getScore()*2)))
                .setText(R.id.tv_likes_num,String.format("%s",item.getApprove()));
        String imgUrl = item.getAvatarurl();
        imgUrl.replace("avatar","180.180/avatar");
        GlideManager.loadImage(mContext,imgUrl, (ImageView) helper.getView(R.id.civ_author));
    }
}

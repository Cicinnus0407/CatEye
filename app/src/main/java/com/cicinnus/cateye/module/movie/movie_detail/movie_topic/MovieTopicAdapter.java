package com.cicinnus.cateye.module.movie.movie_detail.movie_topic;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.TimeUtils;
import com.cicinnus.cateye.tools.UserUtils;

/**
 * Created by Cicinnus on 2017/2/28.
 */
public class MovieTopicAdapter extends BaseMultiItemQuickAdapter<MovieTopicListBean.DataBean, BaseViewHolder> {
    public MovieTopicAdapter() {
        super(null);
        addItemType(BaseConstant.TYPE_MOVIE_TOPIC_NO_IMG, R.layout.item_movie_topic_no_img);
        addItemType(BaseConstant.TYPE_MOVIE_TOPIC_ONE_IMG, R.layout.item_movie_topic_one_img);
        addItemType(BaseConstant.TYPE_MOVIE_TOPIC_MULTI_IMG, R.layout.item_movie_topic_multi_img);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieTopicListBean.DataBean item) {
        helper.setText(R.id.tv_movie_topic_title, item.getTitle())
                .setText(R.id.tv_movie_topic_up_count, String.format("%s", item.getUpCount() == 0 ? "赞" : item.getUpCount()))
                .setText(R.id.tv_movie_topic_comment_count, String.format("%s", item.getCommentCount() == 0 ? "回复" : item.getCommentCount()))
                .setText(R.id.tv_movie_topic_author, item.getAuthor().getNickName())
                .setText(R.id.tv_movie_topic_date, TimeUtils.dateYMD(item.getCreated()));
        GlideManager.loadImage(mContext, item.getAuthor().getAvatarurl(), R.drawable.ic_user_default,(ImageView) helper.getView(R.id.civ_author));
        helper.setImageDrawable(R.id.iv_user_level, UserUtils.getUserLevelLable(mContext,item.getAuthor().getUserLevel()));

        switch (helper.getItemViewType()) {
            case BaseConstant.TYPE_MOVIE_TOPIC_NO_IMG:

                break;
            case BaseConstant.TYPE_MOVIE_TOPIC_ONE_IMG:
                GlideManager.loadImage(mContext, item.getPreviews().get(0).getUrl(),  (ImageView) helper.getView(R.id.iv_movie_topic_img));
                break;
            case BaseConstant.TYPE_MOVIE_TOPIC_MULTI_IMG:
                GlideManager.loadImage(mContext, item.getPreviews().get(0).getUrl(),  (ImageView) helper.getView(R.id.iv_movie_topic_img1));
                GlideManager.loadImage(mContext, item.getPreviews().get(1).getUrl(),  (ImageView) helper.getView(R.id.iv_movie_topic_img2));
                GlideManager.loadImage(mContext, item.getPreviews().get(2).getUrl(),  (ImageView) helper.getView(R.id.iv_movie_topic_img3));

                break;
        }
    }
}

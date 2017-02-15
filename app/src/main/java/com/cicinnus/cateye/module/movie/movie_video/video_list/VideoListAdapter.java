package com.cicinnus.cateye.module.movie.movie_video.video_list;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;
import com.cicinnus.cateye.tools.StringUtil;
import com.cicinnus.cateye.tools.TimeUtils;

/**
 * Created by Administrator on 2017/2/15.
 */

public class VideoListAdapter extends BaseQuickAdapter<VideoListBean.DataBean, BaseViewHolder> {


    private int selectedPos = 0;

    public VideoListAdapter() {
        super(R.layout.item_video_list, null);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final VideoListBean.DataBean item) {
        helper.setText(R.id.tv_video_title, item.getTl())
                .setText(R.id.tv_view_comment_count,
                        String.format("观看: %s 评论: %s", StringUtil.changeNumToCN(item.getCount()), item.getComment()));


        if (mData.get(helper.getAdapterPosition()).isSelect) {
            helper.setText(R.id.tv_video_play_status, "播放中")
                    .setTextColor(R.id.tv_video_title, mContext.getResources().getColor(R.color.colorPrimary))
                    .setBackgroundColor(R.id.fl_video_iv, mContext.getResources().getColor(R.color.colorPrimary));
        } else {
            helper.setTextColor(R.id.tv_video_title, mContext.getResources().getColor(R.color.text_primary))
                    .setBackgroundColor(R.id.fl_video_iv, mContext.getResources().getColor(R.color.white))
                    .setText(R.id.tv_video_play_status, TimeUtils.secondToMinute(item.getTm()));
        }

        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPos != helper.getAdapterPosition()) {
                    mData.get(selectedPos).isSelect = false;
                    notifyItemChanged(selectedPos);
                    selectedPos = helper.getAdapterPosition();
                    mData.get(selectedPos).isSelect = true;
                    notifyItemChanged(selectedPos);
                }
            }
        });

        String imgUrl = ImgSizeUtil.resetPicUrl(item.getImg(), ".webp@375w_210h_1e_1c_1l");
        GlideManager.loadImage(mContext, imgUrl, (ImageView) helper.getView(R.id.iv_video_img));
    }

}

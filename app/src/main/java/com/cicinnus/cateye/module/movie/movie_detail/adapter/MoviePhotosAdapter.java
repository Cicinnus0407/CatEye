package com.cicinnus.cateye.module.movie.movie_detail.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MoviePhotosBean;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

/**
 * Created by Cicinnus on 2017/2/11.
 */

public class MoviePhotosAdapter extends BaseMultiItemQuickAdapter<MoviePhotosBean, BaseViewHolder> {
    public MoviePhotosAdapter() {
        super(null);
        addItemType(BaseConstant.TYPE_MOVIE_DETAIL_VEDIO, R.layout.item_movie_vedio);
        addItemType(BaseConstant.TYPE_MOVIE_DETAIL_PHOTO, R.layout.item_movie_photo);
    }


    @Override
    protected void convert(BaseViewHolder helper, MoviePhotosBean item) {
        switch (helper.getItemViewType()) {
            case BaseConstant.TYPE_MOVIE_DETAIL_VEDIO:
                if (helper.getAdapterPosition() == 0) {
                    helper.setText(R.id.tv_movie_video, "视频");
                }
                helper.setText(R.id.tv_video_num, String.format("%s",item.getVideoNum()));
                GlideManager.loadImage(mContext, item.getVideoImg(), (ImageView) helper.getView(R.id.iv_movie_video_img));
                break;
            case BaseConstant.TYPE_MOVIE_DETAIL_PHOTO:
                if (helper.getAdapterPosition() == 1) {
                    helper.setText(R.id.tv_photo, "图片");
                }else {
                    helper.setText(R.id.tv_photo, "");
                }
                String imgUrl = ImgSizeUtil.resetPicUrl(item.getUrl(), "@100w_100h_1e_1c");
                GlideManager.loadImage(mContext, imgUrl, (ImageView) helper.getView(R.id.iv_movie_photo));
                break;
        }
    }
}

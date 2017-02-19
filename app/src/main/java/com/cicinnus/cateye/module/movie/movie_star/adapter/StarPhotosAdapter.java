package com.cicinnus.cateye.module.movie.movie_star.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

/**
 * Created by Cicinnus on 2017/2/19.
 */

public class StarPhotosAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public StarPhotosAdapter() {
        super(R.layout.item_star_photos, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        String imgUrl = ImgSizeUtil.resetPicUrl(item,"");
        GlideManager.loadImage(mContext,imgUrl, (ImageView) helper.getView(R.id.iv_star_photo));
    }
}

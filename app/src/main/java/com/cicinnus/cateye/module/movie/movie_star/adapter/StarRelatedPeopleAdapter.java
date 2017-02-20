package com.cicinnus.cateye.module.movie.movie_star.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_star.MovieStarActivity;
import com.cicinnus.cateye.module.movie.movie_star.bean.StarRelatedPeople;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

/**
 * Created by Cicinnus on 2017/2/19.
 */

public class StarRelatedPeopleAdapter extends BaseQuickAdapter<StarRelatedPeople.DataBean.RelationsBean,BaseViewHolder> {
    public StarRelatedPeopleAdapter() {
        super(R.layout.item_related_star, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, final StarRelatedPeople.DataBean.RelationsBean item) {
        helper.setText(R.id.tv_related_star_name,item.getName())
                .setText(R.id.tv_cooperate_time,item.getRelation());
        String imgUrl = ImgSizeUtil.processUrl(item.getAvatar(),255,345);
        GlideManager.loadImage(mContext,imgUrl, (ImageView) helper.getView(R.id.iv_related_star));

        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieStarActivity.start(mContext,item.getId());
            }
        });
    }
}

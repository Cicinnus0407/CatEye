package com.cicinnus.cateye.module.movie.hot_movie;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.module.movie.movie_detail.MovieDetailActivity;
import com.cicinnus.cateye.module.movie.movie_video.MovieVideoActivity;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

/**
 * Created by Cicinnus on 2017/1/24.
 */

public class HotMovieListAdapter extends BaseMultiItemQuickAdapter<HotMovieListBean.DataBean.HotBean, BaseViewHolder> {


    public HotMovieListAdapter() {
        super(null);
        addItemType(BaseConstant.TYPE_HOT_HEADLINE, R.layout.item_hot_headline);
        addItemType(BaseConstant.TYPE_HOT_NORMAL, R.layout.item_hot_normal);
    }


    @Override
    protected void convert(BaseViewHolder helper, final HotMovieListBean.DataBean.HotBean item) {
        helper.setText(R.id.tv_hot_movie_name, String.format("%s", item.getNm()))
                .setText(R.id.tv_hot_desc, String.format("%s", item.getScm()))
                .setText(R.id.tv_hot_showInfo, String.format("%s", item.getShowInfo()));
        //图片地址不能直接使用，需要进行转换
        final String imgUrl = ImgSizeUtil.resetPicUrl(item.getImg(),".webp@171w_240h_1e_1c_1l");
        GlideManager.loadImage(mContext, imgUrl, (ImageView) helper.getView(R.id.iv_hot_img));

        //显示3D和IMAX的标签
        if (item.getVer().contains("IMAX 3D")) {
            helper.setImageResource(R.id.iv_ver, R.drawable.ic_3d_imax);

        } else if (item.getVer().contains("3D")) {
            helper.setImageResource(R.id.iv_ver, R.drawable.ic_3d);

        }

        if (item.getPreSale() == 0) {
            //presale为0时表示正在销售 显示为（观众 7.6）
            helper.setText(R.id.tv_hot_audience, String.format("观众%s", item.getSc()))
                    .setText(R.id.tv_buy_ticket, "购票")
                    .setTextColor(R.id.tv_buy_ticket, mContext.getResources().getColor(R.color.colorAccent))
                    .setBackgroundRes(R.id.tv_buy_ticket, R.drawable.bg_tv_buy);
        } else if (item.getPreSale() == 1) {
            //presale为1时表示预售中 显示为（xxx人想看）
            helper.setText(R.id.tv_hot_audience, String.format("%s人想看", item.getWish()))
                    .setText(R.id.tv_buy_ticket, "预售")
                    .setTextColor(R.id.tv_buy_ticket, mContext.getResources().getColor(R.color.text_blue))
                    .setBackgroundRes(R.id.tv_buy_ticket, R.drawable.bg_tv_presale);
        }

        if (item.getSc() == 0 && item.getPreSale() == 0) {
            helper.setText(R.id.tv_hot_audience, "暂无评分");
        }

        //解决多TextView导致的View回收后的文字全都显示问题
        //使用单TextView+Spannable
        TextView tv = helper.getView(R.id.tv_hot_audience);
        String content = tv.getText().toString();
        Spannable span = new SpannableString(content);
        if (content.contains("人想看")) {
            span.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.text_yellow)), 0, content.indexOf("人"), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv.setText(span);
        } else if (content.contains("观众")) {
            span.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.text_yellow)), 2, content.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv.setText(span);
        }

        switch (helper.getItemViewType()) {
            case BaseConstant.TYPE_HOT_HEADLINE:
                helper.setText(R.id.tv_hot_type1, String.format("%s", item.getHeadLinesVO().get(0).getType()))
                        .setText(R.id.tv_hot_type2, String.format("%s", item.getHeadLinesVO().get(1).getType()))
                        .setText(R.id.tv_hot_headline_title1, String.format("%s", item.getHeadLinesVO().get(0).getTitle()))
                        .setText(R.id.tv_hot_headline_title2, String.format("%s", item.getHeadLinesVO().get(1).getTitle()));
                break;
        }

        helper.getView(R.id.fl_hot_movie)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MovieVideoActivity.start(mContext,item.getId(),item.getVideoId(),item.getNm()+" "+item.getVideoName(),item.getVideourl());
                    }
                });

        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieDetailActivity.start(mContext,item.getId());
            }
        });
    }
}

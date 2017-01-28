package com.cicinnus.cateye.module.movie.wait_movie.adapter;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.cateye.tools.GlideManager;

/**
 * Created by Cicinnus on 2017/1/27.
 */

public class WaitMovieMultiAdapter extends BaseMultiItemQuickAdapter<WaitMovieBean.DataBean.ComingBean, BaseViewHolder> {


    private TrailerRecommendAdapter mTrailerRecommendAdapter;

    public WaitMovieMultiAdapter() {
        super(null);
        addItemType(BaseConstant.TYPE_WAIT_DIVIDER,R.layout.layout_wait_movie_divider);
        addItemType(BaseConstant.TYPE_WAIT_NORMAL,R.layout.item_wait_movie);
        addItemType(BaseConstant.TYPE_WAIT_TRAILER,R.layout.layout_wait_movie_trailer_recommend);
    }

    public void setTrailerAdapter(TrailerRecommendAdapter adapter){
        mTrailerRecommendAdapter = adapter;
    }


    @Override
    protected void convert(BaseViewHolder helper, WaitMovieBean.DataBean.ComingBean item) {
        switch (helper.getItemViewType()) {
            case BaseConstant.TYPE_WAIT_NORMAL:

                //图片地址不能直接使用，需要进行转换
                String originUrl = item.getImg();
                String imgUrl = originUrl.replace("/w.h/", "/") + "@171w_240h_1e_1c_1l";//后缀为图片大小
                GlideManager.loadImage(mContext, imgUrl, (ImageView) helper.getView(R.id.iv_wait_movie));

                helper.setText(R.id.tv_wait_movie_name, item.getNm())
                        .setText(R.id.tv_wait_movie_desc, item.getScm())
                        .setText(R.id.tv_wait_movie_wish, String.format("%s人想看", item.getWish()))
                        .setText(R.id.tv_wait_movie_major, String.format("主演:%s", item.getStar()));

                TextView tv_wish = helper.getView(R.id.tv_wait_movie_wish);
                Spannable spannable = new SpannableString(tv_wish.getText());
                spannable.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.text_yellow)), 0, tv_wish.getText().toString().indexOf("人想看"), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                tv_wish.setText(spannable);
                break;
            case BaseConstant.TYPE_WAIT_DIVIDER:
                //预告片
                helper.setText(R.id.tv_divider,item.getComingTitle());
                break;
        }
    }
}

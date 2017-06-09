package com.cicinnus.cateye.module.movie.wait_movie.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.cicinnus.cateye.module.movie.wait_movie.bean.ExpectMovieBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.cateye.tools.GlideManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicinnus on 2017/1/27.
 */

public class WaitMovieMultiAdapter extends BaseMultiItemQuickAdapter<WaitMovieBean.DataBean.ComingBean, BaseViewHolder> {


    private List<ExpectMovieBean.DataBean.ComingBean> mRecentList;
    private List<TrailerRecommendBean.DataBean> mTrailerList;

    public WaitMovieMultiAdapter() {
        super(null);
        mRecentList = new ArrayList<>();
        addItemType(BaseConstant.TYPE_WAIT_TRAILER, R.layout.layout_wait_movie_trailer_recommend);
        addItemType(BaseConstant.TYPE_WAIT_RECENT, R.layout.layout_recent_expect);
        addItemType(BaseConstant.TYPE_WAIT_NORMAL, R.layout.item_wait_movie);
    }


    public void setRecent(List<ExpectMovieBean.DataBean.ComingBean> data){
        this.mRecentList.clear();
        this.mRecentList.addAll(data);
    }
    public void setTrailer(List<TrailerRecommendBean.DataBean> data) {
        this.mTrailerList.clear();
        this.mTrailerList.addAll(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final WaitMovieBean.DataBean.ComingBean item) {
        switch (helper.getItemViewType()) {
            case BaseConstant.TYPE_WAIT_TRAILER:
                //预告片
                TrailerRecommendAdapter mTrailerRecommendAdapter = new TrailerRecommendAdapter(item.getTrailerDataBeanList());
                RecyclerView rvTrailerRecommend = helper.getView(R.id.rv_wait_movie_trailer_recommend);
                rvTrailerRecommend.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                rvTrailerRecommend.setAdapter(mTrailerRecommendAdapter);
                break;
            case BaseConstant.TYPE_WAIT_RECENT:
                RecyclerView rvRecentExpect = helper.getView(R.id.rv_wait_movie_recent_expect);
                rvRecentExpect.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                RecentExpectAdapter recentExpectAdapter = new RecentExpectAdapter(mRecentList);
                rvRecentExpect.setAdapter(recentExpectAdapter);
                break;
            case BaseConstant.TYPE_WAIT_NORMAL:
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MovieDetailActivity.start(mContext, item.getId());
                    }
                });
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

        }
    }


}

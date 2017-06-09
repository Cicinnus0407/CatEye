package com.cicinnus.cateye.module.movie.movie_detail.movie_information;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.base.BaseWebViewActivity;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.StringUtil;

/**
 * Created by Cicinnus on 2017/2/27.
 */

public class MovieInformationAdapter extends BaseMultiItemQuickAdapter<MovieInformationBean.DataBean.NewsListBean,BaseViewHolder> {

    public MovieInformationAdapter() {
        super(null);
        addItemType(BaseConstant.TYPE_MOVIE_INFORMATION_ONE_IMG, R.layout.item_movie_information_one_img);
        addItemType(BaseConstant.TYPE_MOVIE_INFORMATION_MULTI_IMG, R.layout.item_movie_information_multi_img);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MovieInformationBean.DataBean.NewsListBean item) {
        helper.setText(R.id.tv_movie_information_author,item.getSource())
                .setText(R.id.tv_movie_information_title,item.getTitle())
                .setText(R.id.tv_movie_information_view_count,String.format("%s",item.getViewCount()))
                .setText(R.id.tv_movie_information_comment_count,String.format("%s",item.getCommentCount()));
        switch (helper.getItemViewType()){
            case BaseConstant.TYPE_MOVIE_INFORMATION_MULTI_IMG:
                GlideManager.loadImage(mContext,item.getPreviewImages().get(0).getUrl(), (ImageView) helper.getView(R.id.iv_movie_information_img1));
                GlideManager.loadImage(mContext,item.getPreviewImages().get(1).getUrl(), (ImageView) helper.getView(R.id.iv_movie_information_img2));
                GlideManager.loadImage(mContext,item.getPreviewImages().get(2).getUrl(), (ImageView) helper.getView(R.id.iv_movie_information_img3));
                break;
            case BaseConstant.TYPE_MOVIE_INFORMATION_ONE_IMG:
                GlideManager.loadImage(mContext,item.getPreviewImages().get(0).getUrl(), (ImageView) helper.getView(R.id.iv_movie_information_img1));
                break;
        }
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseWebViewActivity.start(mContext, StringUtil.getRealUrl(item.getUrl()));
            }
        });

    }
}

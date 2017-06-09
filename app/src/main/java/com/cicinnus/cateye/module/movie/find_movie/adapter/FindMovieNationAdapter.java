package com.cicinnus.cateye.module.movie.find_movie.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.find_movie.bean.MovieTypeBean;
import com.cicinnus.cateye.module.movie.search_movie.SearchMovieActivity;

/**
 * Created by Cicinnus on 2017/2/2.
 */

public class FindMovieNationAdapter extends BaseQuickAdapter<MovieTypeBean.DataBean.TagListBean,BaseViewHolder> {
    public FindMovieNationAdapter() {
        super(R.layout.item_movie_type, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MovieTypeBean.DataBean.TagListBean item) {
        helper.setText(R.id.tv_movie_type,item.getTagName());

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchMovieActivity.startFromNation(mContext,item.getTagId(),item.getTagName());

            }
        });
    }
}

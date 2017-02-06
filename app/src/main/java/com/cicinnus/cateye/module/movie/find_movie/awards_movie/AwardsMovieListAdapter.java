package com.cicinnus.cateye.module.movie.find_movie.awards_movie;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsMovieListBean;

/**
 * Created by Administrator on 2017/2/6.
 */

public class AwardsMovieListAdapter extends BaseMultiItemQuickAdapter<AwardsMovieListBean.DataBean.AwardsBean, BaseViewHolder> {

    public AwardsMovieListAdapter() {
        super(null);
        addItemType(BaseConstant.TYPE_AWARDS_MOVIE, R.layout.item_awards_type_movie);
        addItemType(BaseConstant.TYPE_AWARDS_PEOPLE, R.layout.item_awards_type_people);
    }

    @Override
    protected void convert(BaseViewHolder helper, AwardsMovieListBean.DataBean.AwardsBean item) {

        switch (helper.getItemViewType()) {
            case BaseConstant.TYPE_AWARDS_MOVIE:
                helper.setText(R.id.tv_movie_name, item.getMovieCnm())
                        .setText(R.id.tv_movie_english_name, item.getMovieEnm());
                break;
            case BaseConstant.TYPE_AWARDS_PEOPLE:
                helper.setText(R.id.tv_star_name,item.getCelebrityList().get(0).getCelebrityCnm());
                break;
        }
    }
}

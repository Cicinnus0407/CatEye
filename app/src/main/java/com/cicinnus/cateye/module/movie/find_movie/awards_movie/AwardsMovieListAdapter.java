package com.cicinnus.cateye.module.movie.find_movie.awards_movie;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsMovieListBean;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

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
        switch (item.getWinnerType()){
            case 1:
                //提名
                helper.setImageResource(R.id.iv_winner_prize,R.drawable.ic_nomination_prize);
                break;
            case 2:
                //获奖
                helper.setImageResource(R.id.iv_winner_prize,R.drawable.ic_win_prize);
                break;
        }
        switch (helper.getItemViewType()) {
            case BaseConstant.TYPE_AWARDS_MOVIE:
                helper.setText(R.id.tv_movie_name, item.getMovieCnm())
                        .setText(R.id.tv_movie_english_name, item.getMovieEnm());


                String imgUrl = ImgSizeUtil.resetPicUrl(item.getImg(),".webp@171w_240h_1e_1c_1l");
                GlideManager.loadImage(mContext,imgUrl, (ImageView) helper.getView(R.id.iv_movie_img));

                break;
            case BaseConstant.TYPE_AWARDS_PEOPLE:
                helper.setText(R.id.tv_star_name,item.getCelebrityList().get(0).getCelebrityCnm())
                        .setText(R.id.tv_star_english_name,item.getCelebrityList().get(0).getCelebrityEnm())
                        .setText(R.id.tv_movie_name,item.getMovieCnm());
                if(item.getMovieId()==0){
                    helper.getView(R.id.tv_movie_name).setVisibility(View.INVISIBLE);
                }

                String starImgUrl = ImgSizeUtil.resetPicUrl(item.getCelebrityList().get(0).getAvatar(),".webp@171w_240h_1e_1c_1l");
                GlideManager.loadImage(mContext,starImgUrl, (ImageView) helper.getView(R.id.civ_award_star));
                break;
        }
    }
}

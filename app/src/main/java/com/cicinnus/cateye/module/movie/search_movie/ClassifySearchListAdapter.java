package com.cicinnus.cateye.module.movie.search_movie;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.module.movie.movie_detail.MovieDetailActivity;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

/**
 * Created by Administrator on 2017/2/3.
 */

public class ClassifySearchListAdapter extends BaseMultiItemQuickAdapter<ClassifySearchBean.ListBean, BaseViewHolder> {


    public ClassifySearchListAdapter() {
        super(null);
        addItemType(BaseConstant.TYPE_CLASSIFY_NORMAL, R.layout.item_classify_normal);
        addItemType(BaseConstant.TYPE_CLASSIFY_WISH, R.layout.item_classify_wish);
        addItemType(BaseConstant.TYPE_CLASSIFY_BUY, R.layout.item_classify_buy);
        addItemType(BaseConstant.TYPE_CLASSIFY_PRESALE, R.layout.item_classify_presale);
    }

    @Override
    protected void convert(BaseViewHolder helper, final ClassifySearchBean.ListBean item) {
        String imgUrl = ImgSizeUtil.resetPicUrl(item.getImg(), ".webp@210w_285h_1e_1c_1l");
        GlideManager.loadImage(mContext, imgUrl, (ImageView) helper.getView(R.id.iv_movie_img));
        helper.setText(R.id.tv_movie_name, item.getNm())
                .setText(R.id.tv_movie_english_name, item.getEnm())
                .setText(R.id.tv_movie_type, item.getCat())
                .setText(R.id.tv_movie_publicDate, item.getPubDesc());

        //显示3D和IMAX的标签
        if (item.getVer().contains("IMAX 3D")) {
            helper.setImageResource(R.id.iv_ver, R.drawable.ic_3d_imax);

        } else if (item.getVer().contains("3D")) {
            helper.setImageResource(R.id.iv_ver, R.drawable.ic_3d);
        }
        switch (helper.getItemViewType()) {
            case BaseConstant.TYPE_CLASSIFY_NORMAL:
                if(item.getSc()==0){
                    helper.setText(R.id.tv_point,"暂无评分");
                    helper.getView(R.id.tv_movie_score).setVisibility(View.INVISIBLE);
                }else {
                    helper.setText(R.id.tv_movie_score, String.format("%s", item.getSc()));
                }
                break;
            case BaseConstant.TYPE_CLASSIFY_WISH:
                helper.setText(R.id.tv_movie_wish, String.format("%s", item.getWish()));
                break;
            case BaseConstant.TYPE_CLASSIFY_BUY:
                if(item.getSc()==0){
                    helper.setText(R.id.tv_point,"暂无评分");
                    helper.getView(R.id.tv_movie_score).setVisibility(View.INVISIBLE);
                }else {
                    helper.setText(R.id.tv_movie_score, String.format("%s", item.getSc()));
                }
                break;
            case BaseConstant.TYPE_CLASSIFY_PRESALE:
                if(item.getSc()==0){
                    helper.setText(R.id.tv_point,"暂无评分");
                }else {
                    helper.getView(R.id.tv_movie_score).setVisibility(View.INVISIBLE);
                    helper.setText(R.id.tv_movie_score, String.format("%s", item.getSc()));
                }
                break;
        }
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieDetailActivity.start(mContext,item.getId());
            }
        });
    }
}

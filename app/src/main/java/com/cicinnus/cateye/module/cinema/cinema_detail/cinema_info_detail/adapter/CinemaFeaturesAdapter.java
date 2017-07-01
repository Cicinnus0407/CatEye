package com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean.CinemaInfoBean;

/**
 * Created by Cicinnus on 2017/6/26.
 */

public class CinemaFeaturesAdapter extends BaseMultiItemQuickAdapter<CinemaInfoBean.DataBean.FeatureTagsBean,BaseViewHolder> {


    public CinemaFeaturesAdapter() {
        super(null);
        addItemType(BaseConstant.TYPE_CINEMA_FEATURE_URL, R.layout.item_cinema_features_url);
        addItemType(BaseConstant.TYPE_CINEMA_FEATURE_ONE, R.layout.item_cinema_features);
    }

    @Override
    protected void convert(BaseViewHolder helper, CinemaInfoBean.DataBean.FeatureTagsBean item) {
                helper.setText(R.id.tv_tag,item.getTag())
                        .setText(R.id.tv_desc,item.getDesc());

        switch (helper.getItemViewType()){
            case BaseConstant.TYPE_CINEMA_FEATURE_URL:
                break;
            case BaseConstant.TYPE_CINEMA_FEATURE_ONE:

                break;
        }
    }
}

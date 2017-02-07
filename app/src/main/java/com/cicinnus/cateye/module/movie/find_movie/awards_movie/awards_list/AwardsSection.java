package com.cicinnus.cateye.module.movie.find_movie.awards_movie.awards_list;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by Cicinnus on 2017/2/7.
 */

public class AwardsSection extends SectionEntity<AwardsListBean.DataBean.FestivalsBean> {
    public AwardsSection(AwardsListBean.DataBean.FestivalsBean dataBean) {
        super(dataBean);
    }

    public AwardsSection(boolean isHeader, String header) {
        super(isHeader, header);
    }
}

package com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.cicinnus.cateye.module.movie.find_movie.bean.AwardsMovieBean;

/**
 * Created by Administrator on 2017/2/6.
 */

public class AwardsSection extends SectionEntity<AwardsMovieBean.DataBean> {

    public AwardsSection(AwardsMovieBean.DataBean dataBean) {
        super(dataBean);
    }

    public AwardsSection(boolean isHeader, String header) {
        super(isHeader, header);
    }
}

package com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by Cicinnus on 2017/2/22.
 */

public class CompaniesSection extends SectionEntity<MovieRelatedCompanies.DataBean.ItemsBean> {
    public CompaniesSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public CompaniesSection(MovieRelatedCompanies.DataBean.ItemsBean itemsBean) {
        super(itemsBean);
    }
}

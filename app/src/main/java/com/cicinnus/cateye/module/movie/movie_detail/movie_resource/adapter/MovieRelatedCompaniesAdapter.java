package com.cicinnus.cateye.module.movie.movie_detail.movie_resource.adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean.CompaniesSection;

/**
 * Created by Cicinnus on 2017/2/22.
 */

public class MovieRelatedCompaniesAdapter extends BaseSectionQuickAdapter<CompaniesSection,BaseViewHolder> {

    public MovieRelatedCompaniesAdapter() {
        super(R.layout.item_related_companies, R.layout.item_related_companies_header, null);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, CompaniesSection item) {
        helper.setText(R.id.tv_movie_related_companies_title,item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, CompaniesSection item) {
        helper.setText(R.id.tv_movie_related_companies,item.t.getDesc());
    }
}

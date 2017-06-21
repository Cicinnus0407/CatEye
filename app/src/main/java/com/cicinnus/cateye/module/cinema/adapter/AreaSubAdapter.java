package com.cicinnus.cateye.module.cinema.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.bean.FilterBean;

/**
 * Created by Cicinnus on 2017/6/20.
 */
public class AreaSubAdapter extends BaseQuickAdapter<FilterBean.DataBean.DistrictBean.SubItemsBeanXX.SubItemsBeanX, BaseViewHolder> {

    private OnSubDistrictClickListener onSubDistrictClickListener;

    public AreaSubAdapter() {
        super(R.layout.item_sub_disrtict);
    }

    @Override
    protected void convert(BaseViewHolder helper, final FilterBean.DataBean.DistrictBean.SubItemsBeanXX.SubItemsBeanX item) {
        helper.setText(R.id.tv_sub_district, item.getName())
                .setText(R.id.tv_count, String.format("%s", item.getId() == -1 ? "" : item.getCount()));
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSubDistrictClickListener != null) {
                    onSubDistrictClickListener.onClick(item);
                }
            }
        });

    }

    public void setOnSubDistrictClickListener(OnSubDistrictClickListener onSubDistrictClickListener) {
        this.onSubDistrictClickListener = onSubDistrictClickListener;
    }

    public interface OnSubDistrictClickListener {
        void onClick(FilterBean.DataBean.DistrictBean.SubItemsBeanXX.SubItemsBeanX item);
    }
}

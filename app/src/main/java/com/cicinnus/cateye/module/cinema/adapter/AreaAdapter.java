package com.cicinnus.cateye.module.cinema.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.bean.FilterBean;

/**
 * Created by Cicinnus on 2017/6/20.
 */

public class AreaAdapter extends BaseQuickAdapter<FilterBean.DataBean.DistrictBean.SubItemsBeanXX, BaseViewHolder> {


    private OnDistrictClickListener onDistrictClickListener;
    private int selectedPos = 0;

    public AreaAdapter() {
        super(R.layout.item_district);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final FilterBean.DataBean.DistrictBean.SubItemsBeanXX item) {
        helper.setText(R.id.tv_district_name, item.getName())
                .setText(R.id.tv_count, String.format("%s", item.getId() == -1 ? "" : item.getCount()));

        if (item.isSelect) {
            helper.setBackgroundColor(R.id.ll_district, mContext.getResources().getColor(R.color.white));
        } else {
            helper.setBackgroundColor(R.id.ll_district, mContext.getResources().getColor(R.color.divider_normal));

        }

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedPos != helper.getAdapterPosition()) {
                    mData.get(selectedPos).isSelect = false;
                    notifyItemChanged(selectedPos);
                    selectedPos = helper.getAdapterPosition();
                    mData.get(selectedPos).isSelect = true;
                    notifyItemChanged(selectedPos);
                    if (onDistrictClickListener != null) {
                        onDistrictClickListener.onClick(item);
                    }
                }
            }
        });
    }

    public void setOnDistrictClickListener(OnDistrictClickListener onDistrictClickListener) {
        this.onDistrictClickListener = onDistrictClickListener;
    }

    public interface OnDistrictClickListener {
        void onClick(FilterBean.DataBean.DistrictBean.SubItemsBeanXX item);
    }
}

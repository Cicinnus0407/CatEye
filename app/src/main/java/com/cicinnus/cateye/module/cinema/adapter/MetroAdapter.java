package com.cicinnus.cateye.module.cinema.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.bean.FilterBean;

/**
 * Created by Cicinnus on 2017/6/20.
 */

public class MetroAdapter extends BaseQuickAdapter<FilterBean.DataBean.SubwayBean.SubItemsBeanXXXXXX, BaseViewHolder> {

    private OnMetroClickListener onMetroClickListener;
    private int selectedPos = 0;

    public MetroAdapter() {
        super(R.layout.item_metro);

    }

    @Override
    protected void convert(final BaseViewHolder helper, final FilterBean.DataBean.SubwayBean.SubItemsBeanXXXXXX item) {
        helper.setText(R.id.tv_metro_name, item.getName())
                .setText(R.id.tv_count, String.format("%s", item.getCount()));

        if (item.isSelect) {
            helper.setBackgroundColor(R.id.ll_metro, mContext.getResources().getColor(R.color.white));
        } else {
            helper.setBackgroundColor(R.id.ll_metro, mContext.getResources().getColor(R.color.divider_normal));

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
                    if (onMetroClickListener != null) {
                        onMetroClickListener.onClick(item);
                    }
                }
            }
        });


    }

    public void setOnMetroClickListener(OnMetroClickListener onMetroClickListener) {
        this.onMetroClickListener = onMetroClickListener;
    }

    public interface OnMetroClickListener {
        void onClick(FilterBean.DataBean.SubwayBean.SubItemsBeanXXXXXX item);
    }
}

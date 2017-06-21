package com.cicinnus.cateye.module.cinema.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.bean.SortConditionBean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/6/21.
 */

public class SortConditionAdapter extends BaseQuickAdapter<SortConditionBean, BaseViewHolder> {

    private OnSortConditionClickListener onSortConditionClickListener;
    private int selectedPos = 0;

    public SortConditionAdapter(List<SortConditionBean> data) {
        super(R.layout.item_sort_condition,data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final SortConditionBean item) {
        helper.setText(R.id.tv_sort_condition, item.getName());

        helper.setTextColor(R.id.tv_sort_condition, item.isSelect ?
                mContext.getResources().getColor(R.color.colorPrimary) :
                mContext.getResources().getColor(R.color.text_gray_deep));

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPos != helper.getAdapterPosition()) {
                    mData.get(selectedPos).isSelect = false;
                    notifyItemChanged(selectedPos);
                    selectedPos = helper.getAdapterPosition();
                    mData.get(selectedPos).isSelect = true;
                    notifyItemChanged(selectedPos);
                }
                if (onSortConditionClickListener != null) {
                    onSortConditionClickListener.onClick(item);
                }
            }
        });
    }

    public void setOnSortConditionClickListener(OnSortConditionClickListener onSortConditionClickListener) {
        this.onSortConditionClickListener = onSortConditionClickListener;
    }

    public interface OnSortConditionClickListener {
        void onClick(SortConditionBean item);
    }
}

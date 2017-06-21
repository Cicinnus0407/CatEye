package com.cicinnus.cateye.module.cinema.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.bean.FilterBean;

/**
 * Created by Cicinnus on 2017/6/21.
 */

public class BrandAdapter extends BaseQuickAdapter<FilterBean.DataBean.BrandBean.SubItemsBean, BaseViewHolder> {


    private OnBrandClickListener onBrandClickListener;
    private int selectedPos = 0;

    public BrandAdapter() {
        super(R.layout.item_brand);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final FilterBean.DataBean.BrandBean.SubItemsBean item) {
        helper.setText(R.id.tv_brand, item.getName());

        helper.setTextColor(R.id.tv_brand, item.isSelect ?
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

                if (onBrandClickListener != null) {
                    onBrandClickListener.onClick(item);
                }
            }
        });
    }

    public void setOnBrandClickListener(OnBrandClickListener onBrandClickListener) {
        this.onBrandClickListener = onBrandClickListener;
    }


    public interface OnBrandClickListener {
        void onClick(FilterBean.DataBean.BrandBean.SubItemsBean item);
    }

}

package com.cicinnus.cateye.module.cinema.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.bean.FilterBean;

/**
 * Created by Cicinnus on 2017/6/21.
 */

public class ServiceAdapter extends BaseQuickAdapter<FilterBean.DataBean.ServiceBean.SubItemsBeanXXXX, BaseViewHolder> {

    private OnServiceClickListener onServiceClickListener;
    public int selectedPos = 0;

    public ServiceAdapter() {
        super(R.layout.item_service);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final FilterBean.DataBean.ServiceBean.SubItemsBeanXXXX item) {
        helper.setText(R.id.tv_service, item.getName())
                .setTextColor(R.id.tv_service, item.isSelect ?
                        mContext.getResources().getColor(R.color.colorPrimary) :
                        mContext.getResources().getColor(R.color.text_gray_deep));
        helper.getView(R.id.tv_service).setBackground(item.isSelect ?
                mContext.getResources().getDrawable(R.drawable.bg_service_checked) :
                mContext.getResources().getDrawable(R.drawable.bg_service_normal));

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
                if (onServiceClickListener != null) {
                    onServiceClickListener.onClick(item);
                }
            }
        });
    }

    public void setOnServiceClickListener(OnServiceClickListener onServiceClickListener) {
        this.onServiceClickListener = onServiceClickListener;
    }

    public interface OnServiceClickListener {
        void onClick(FilterBean.DataBean.ServiceBean.SubItemsBeanXXXX item);
    }
}

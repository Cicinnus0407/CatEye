package com.cicinnus.cateye.module.cinema.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.bean.FilterBean;

/**
 * Created by Cicinnus on 2017/6/20.
 */

public class MetroSubAdapter extends BaseQuickAdapter<FilterBean.DataBean.SubwayBean.SubItemsBeanXXXXXX.SubItemsBeanXXXXX,BaseViewHolder> {

    private OnMetroSubClickListener onMetroSubClickListener;
    public MetroSubAdapter() {
        super(R.layout.item_sub_metro);

    }

    @Override
    protected void convert(BaseViewHolder helper, final FilterBean.DataBean.SubwayBean.SubItemsBeanXXXXXX.SubItemsBeanXXXXX item) {
        helper.setText(R.id.tv_sub_metro,item.getName())
                .setText(R.id.tv_count,String.format("%s",item.getCount()));

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMetroSubClickListener != null) {
                    onMetroSubClickListener.onClick(item);
                }
            }
        });
    }


    public void setOnMetroSubClickListener(OnMetroSubClickListener onMetroSubClickListener) {
        this.onMetroSubClickListener = onMetroSubClickListener;
    }

    public interface OnMetroSubClickListener{
        void onClick(FilterBean.DataBean.SubwayBean.SubItemsBeanXXXXXX.SubItemsBeanXXXXX item);
    }
}

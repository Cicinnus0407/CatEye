package com.cicinnus.cateye.module.movie.pick_city;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;

/**
 * Created by Cicinnus on 2017/6/8.
 */

public class PickCityAdapter extends BaseQuickAdapter<PickCityBean.CtsBean, BaseViewHolder> {


    private OnCityClickListener onCityClickListener;

    public PickCityAdapter() {
        super(R.layout.item_city);
    }
    @Override
    protected void convert(BaseViewHolder helper, final PickCityBean.CtsBean item) {
        helper.setText(R.id.tv_city_name, item.getNm());
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCityClickListener != null) {
                    onCityClickListener.onClick(item);
                }
            }
        });
    }

    public void setOnCityClickListener(OnCityClickListener onCityClickListener) {
        this.onCityClickListener = onCityClickListener;
    }

    public interface OnCityClickListener{
        void onClick(PickCityBean.CtsBean item);
    }


}

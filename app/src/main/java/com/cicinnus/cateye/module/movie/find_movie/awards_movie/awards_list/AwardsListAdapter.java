package com.cicinnus.cateye.module.movie.find_movie.awards_movie.awards_list;

import android.view.View;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;

/**
 * Created by Administrator on 2017/2/7.
 */

public class AwardsListAdapter extends BaseSectionQuickAdapter<AwardsSection,BaseViewHolder> {


    private OnAwardsClickListener onAwardsClickListener;

    public AwardsListAdapter() {
        super(R.layout.item_awards_list, R.layout.item_awards_list_section_head, null);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, AwardsSection item) {
        helper.setText(R.id.tv_award_list_title,item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, final AwardsSection item) {
        helper.setText(R.id.tv_award_name,item.t.getFestivalName());

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onAwardsClickListener != null) {
                    onAwardsClickListener.onClick(item.t.getFestivalId());
                }
            }
        });
    }
    public void setOnAwardsClickListener(OnAwardsClickListener onAwardsClickListener) {
        this.onAwardsClickListener = onAwardsClickListener;
    }


    public interface OnAwardsClickListener{
        void onClick(int festivalId);
    }
}

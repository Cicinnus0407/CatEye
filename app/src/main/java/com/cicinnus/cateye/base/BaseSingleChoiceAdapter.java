package com.cicinnus.cateye.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cicinnus.cateye.R;

import java.util.ArrayList;
import java.util.List;


/**
 * 单选RecyclerView的Adapter
 */
public class BaseSingleChoiceAdapter extends RecyclerView.Adapter<BaseSingleChoiceAdapter.ViewHolder> {

    private int selectedPos = 0;
    private List<BaseSingleChoiceBean> mData;
    private OnItemClickListener onItemClickListener;
    private Context mContext;

    public BaseSingleChoiceAdapter() {
        mData = new ArrayList<>();

    }

    public void addData(List<BaseSingleChoiceBean> data) {
        mData.addAll(data);
        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).isSelect) {
                selectedPos = i;
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public BaseSingleChoiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_single_choie_filter, parent, false));
    }

    @Override
    public void onBindViewHolder(final BaseSingleChoiceAdapter.ViewHolder holder, int position) {
        holder.tv.setText(mData.get(holder.getAdapterPosition()).content);
        if (mData.get(holder.getAdapterPosition()).isSelect) {
            holder.tv.setBackgroundResource(R.drawable.bg_tv_movie_type_pre);
            holder.tv.setTextColor(mContext.getResources().getColor(R.color.white));
        } else {
            holder.tv.setBackgroundResource(R.drawable.bg_tv_movie_type_nor);
            holder.tv.setTextColor(mContext.getResources().getColor(R.color.text_primary));
        }
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPos != holder.getAdapterPosition()) {
                    mData.get(selectedPos).isSelect = false;
                    notifyItemChanged(selectedPos);
                    selectedPos = holder.getAdapterPosition();
                    mData.get(selectedPos).isSelect = true;
                    notifyItemChanged(selectedPos);
                    if (onItemClickListener != null) {
                        onItemClickListener.click(mData.get(holder.getAdapterPosition()));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_movie_type);
        }
    }

    public interface OnItemClickListener {
        void click(BaseSingleChoiceBean bean);
    }
}

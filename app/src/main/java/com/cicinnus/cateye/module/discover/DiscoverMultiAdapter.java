package com.cicinnus.cateye.module.discover;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseConstant;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.TimeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/19.
 */

public class DiscoverMultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<DiscoverBean.DataBean.FeedsBean> mData;
    private Context mContext;

    public DiscoverMultiAdapter(Context context) {
        mData = new ArrayList<>();
        this.mContext = context;
    }

    public void addData(List<DiscoverBean.DataBean.FeedsBean> newData) {
        this.mData.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case BaseConstant.TYPE_DISCOVER_ONE_IMG:
                return new OneImgViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_one_img, parent, false));
            case BaseConstant.TYPE_DISCOVER_MULTI_IMG:
                return new MultiImgViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_muilt_img, parent, false));
            case BaseConstant.TYPE_DISCOVER_BIG_IMG:
                return new BigImgViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_big_img, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case BaseConstant.TYPE_DISCOVER_ONE_IMG:
                ((OneImgViewHolder) holder).tvComment.setText(String.format("%s", mData.get(position).getCommentCount()));
                ((OneImgViewHolder) holder).tvDiscTitle.setText(mData.get(position).getTitle());
                ((OneImgViewHolder) holder).tvNickName.setText(String.format("%s", mData.get(position).getUser().getNickName()));
                ((OneImgViewHolder) holder).tvViewCount.setText(String.format("%s", mData.get(position).getViewCount()));
                ((OneImgViewHolder) holder).tvTime.setText(String.format("%s", TimeUtils.dateYMDHM(mData.get(position).getTime())));
                GlideManager.loadImage(mContext, mData.get(position).getImages().get(0).getUrl(), ((OneImgViewHolder) holder).ivImg);
                break;
            case BaseConstant.TYPE_DISCOVER_MULTI_IMG:
                ((MultiImgViewHolder) holder).tvComment.setText(String.format("%s", mData.get(position).getCommentCount()));
                ((MultiImgViewHolder) holder).tvDiscTitle.setText(mData.get(position).getTitle());
                ((MultiImgViewHolder) holder).tvNickName.setText(String.format("%s", mData.get(position).getUser().getNickName()));
                ((MultiImgViewHolder) holder).tvViewCount.setText(String.format("%s", mData.get(position).getViewCount()));
                ((MultiImgViewHolder) holder).tvTime.setText(String.format("%s", TimeUtils.dateYMDHM(mData.get(position).getTime())));
                GlideManager.loadImage(mContext, mData.get(position).getImages().get(0).getUrl(), ((MultiImgViewHolder) holder).ivImg1);
                GlideManager.loadImage(mContext, mData.get(position).getImages().get(1).getUrl(), ((MultiImgViewHolder) holder).ivImg2);
                GlideManager.loadImage(mContext, mData.get(position).getImages().get(2).getUrl(), ((MultiImgViewHolder) holder).ivImg3);
                break;
            case BaseConstant.TYPE_DISCOVER_BIG_IMG:
                ((BigImgViewHolder) holder).tvComment.setText(String.format("%s", mData.get(position).getCommentCount()));
                ((BigImgViewHolder) holder).tvDiscTitle.setText(mData.get(position).getTitle());
                ((BigImgViewHolder) holder).tvNickName.setText(String.format("%s", mData.get(position).getUser().getNickName()));
                ((BigImgViewHolder) holder).tvViewCount.setText(String.format("%s", mData.get(position).getViewCount()));
                ((BigImgViewHolder) holder).tvTime.setText(String.format("%s", TimeUtils.dateYMDHM(mData.get(position).getTime())));
                ((BigImgViewHolder) holder).tvImgCount.setText(String.format("%s", mData.get(position).getImageCount()));
                GlideManager.loadImage(mContext, mData.get(position).getImages().get(0).getUrl(), ((BigImgViewHolder) holder).ivImg1);
                GlideManager.loadImage(mContext, mData.get(position).getImages().get(1).getUrl(), ((BigImgViewHolder) holder).ivImg2);
                GlideManager.loadImage(mContext, mData.get(position).getImages().get(2).getUrl(), ((BigImgViewHolder) holder).ivImg3);
                break;
        }
    }

    /**
     * 根据Style来判断是什么类型的布局
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        switch (mData.get(position).getStyle()) {
            case 2:
                return BaseConstant.TYPE_DISCOVER_ONE_IMG;
            case 3:
                return BaseConstant.TYPE_DISCOVER_MULTI_IMG;
            case 4:
                return BaseConstant.TYPE_DISCOVER_BIG_IMG;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    /**
     * 一张图的ViewHolder
     */
    public class OneImgViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_disc_title)
        TextView tvDiscTitle;
        @BindView(R.id.tv_comment)
        TextView tvComment;
        @BindView(R.id.tv_viewCount)
        TextView tvViewCount;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_nickName)
        TextView tvNickName;

        public OneImgViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 多张图的ViewHolder
     */
    public class MultiImgViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_disc_title)
        TextView tvDiscTitle;
        @BindView(R.id.tv_comment)
        TextView tvComment;
        @BindView(R.id.tv_viewCount)
        TextView tvViewCount;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_nickName)
        TextView tvNickName;
        @BindView(R.id.iv_img1)
        ImageView ivImg1;
        @BindView(R.id.iv_img2)
        ImageView ivImg2;
        @BindView(R.id.iv_img3)
        ImageView ivImg3;

        public MultiImgViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class BigImgViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_disc_title)
        TextView tvDiscTitle;
        @BindView(R.id.tv_comment)
        TextView tvComment;
        @BindView(R.id.tv_viewCount)
        TextView tvViewCount;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_nickName)
        TextView tvNickName;
        @BindView(R.id.iv_img1)
        ImageView ivImg1;
        @BindView(R.id.iv_img2)
        ImageView ivImg2;
        @BindView(R.id.iv_img3)
        ImageView ivImg3;
        @BindView(R.id.tv_imgCount)
        TextView tvImgCount;

        public BigImgViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

package com.cicinnus.cateye.module.cinema.cinema_detail.adapter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaMovieBean;
import com.cicinnus.cateye.tools.TimeUtils;

/**
 * Created by Cicinnus on 2017/6/22.
 */

public class ShowListAdapter extends BaseQuickAdapter<CinemaMovieBean.DataBean.MoviesBean.ShowsBean.PlistBean, BaseViewHolder> {
    private int duration;

    public ShowListAdapter() {
        super(R.layout.item_show_list);
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    protected void convert(BaseViewHolder helper, CinemaMovieBean.DataBean.MoviesBean.ShowsBean.PlistBean item) {
        helper.setText(R.id.tv_time, item.getTm())
                .setText(R.id.tv_language, String.format("%s%s", item.getLang(), item.getTp()))
                .setText(R.id.tv_hall, item.getTh())
                .setText(R.id.tv_login_benefit, item.getExtraDesc())
                .setText(R.id.tv_money,String.format("%s元",item.getSellPr()));
        TextView tvBuy = helper.getView(R.id.tv_buy);
        if (item.getTicketStatus() == 0) {
            tvBuy.setText("购买");
            tvBuy.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            tvBuy.setBackground(mContext.getResources().getDrawable(R.drawable.bg_tv_buy_white));
            GradientDrawable background = (GradientDrawable) tvBuy.getBackground();
            background.setStroke(2, mContext.getResources().getColor(R.color.colorPrimary));

        } else if (item.getTicketStatus() == 1) {
            tvBuy.setText("满座");
            tvBuy.setTextColor(Color.parseColor("#FFDA8C88"));
            tvBuy.setBackground(mContext.getResources().getDrawable(R.drawable.bg_tv_buy_white));
            GradientDrawable background = (GradientDrawable) tvBuy.getBackground();
            background.setStroke(2, Color.parseColor("#FFDA8C88"));
        } else if(item.getTicketStatus()==2){
            tvBuy.setText("停售");
            tvBuy.setTextColor(mContext.getResources().getColor(R.color.text_gray));
            tvBuy.setBackground(mContext.getResources().getDrawable(R.drawable.bg_tv_buy_white));
            GradientDrawable background = (GradientDrawable) tvBuy.getBackground();
            background.setStroke(2, mContext.getResources().getColor(R.color.text_gray));
        }else if (item.getTicketStatus() == 5) {
            tvBuy.setText("特惠");
            tvBuy.setTextColor(mContext.getResources().getColor(R.color.text_yellow));
            tvBuy.setBackground(mContext.getResources().getDrawable(R.drawable.bg_tv_buy_white_yellow));
        }

        helper.setVisible(R.id.tv_login_benefit, item.getExtraDesc() != null);
        helper.setVisible(R.id.tv_play_next_day, item.getZeroFlag() != null && item.getZeroFlag().equals("次日放映"));


        int hour = Integer.parseInt(item.getTm().substring(0, 2));
        int minute = Integer.parseInt(item.getTm().substring(3, 5));
        int total = hour * 60 + minute + duration;

        helper.setText(R.id.tv_end_time, String.format("%s散场", TimeUtils.MinuteToHour(total)));
    }

}

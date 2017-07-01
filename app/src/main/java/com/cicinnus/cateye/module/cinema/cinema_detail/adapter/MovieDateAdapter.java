package com.cicinnus.cateye.module.cinema.cinema_detail.adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaMovieBean;
import com.cicinnus.retrofitlib.utils.TimeUtil;
import com.cicinnus.retrofitlib.utils.UIUtils;

import java.util.List;

/**
 * Created by Cicinnus on 2017/6/22.
 */

public class MovieDateAdapter extends BaseQuickAdapter<CinemaMovieBean.DataBean.MoviesBean.ShowsBean, BaseViewHolder> {

    private int selectedPos = 0;
    private OnMovieDateClickListener onMovieDateClickListener;

    public MovieDateAdapter() {
        super(R.layout.item_movie_date);
    }

    @Override
    public void setNewData(@Nullable List<CinemaMovieBean.DataBean.MoviesBean.ShowsBean> data) {
        super.setNewData(data);
        if (data != null) {
            data.get(0).isSelect = true;
            for (int i = 1; i < data.size(); i++) {
                data.get(i).isSelect = false;
            }
            selectedPos = 0;
        }
    }

    @Override
    protected void convert(final BaseViewHolder helper, final CinemaMovieBean.DataBean.MoviesBean.ShowsBean item) {


        int index = TimeUtil.dayForWeek(item.getShowDate());
        int currentIndex = TimeUtil.dayForWeek(TimeUtil.dateYMD(System.currentTimeMillis()));
        String dateText;
        if (index == currentIndex) {
            dateText = "今天";
        } else if (index == currentIndex + 1) {
            dateText = "明天";
        } else if (index == currentIndex + 2) {
            dateText = "后天";
        } else {
            dateText = switchDate(index);
        }

        helper.setText(R.id.tv_date, String.format("%s%s%s", dateText,
                item.getShowDate().substring(5, item.getShowDate().length())
                        .replace("-", "月"), "日")).
                setVisible(R.id.view_indicator, item.isSelect).
                setTextColor(R.id.tv_date, item.isSelect ? mContext.getResources().getColor(R.color.colorPrimary) :
                        mContext.getResources().getColor(R.color.text_primary));


        if (item.getPreferential() == 1) {
            Drawable drawable = mContext.getResources().getDrawable(R.drawable.ic_benefit_26);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((TextView) helper.getView(R.id.tv_date)).setCompoundDrawablePadding(UIUtils.dp2px(mContext, 6));
            ((TextView) helper.getView(R.id.tv_date)).setCompoundDrawables(null, null, drawable, null);
        } else {
            ((TextView) helper.getView(R.id.tv_date)).setCompoundDrawables(null, null, null, null);
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

                }
                if (onMovieDateClickListener != null) {
                    onMovieDateClickListener.onClick(item);
                }
            }
        });
    }

    private String switchDate(int index) {
        String[] week = new String[]{"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        return week[index % 7];
    }

    public void setOnMovieDateClickListener(OnMovieDateClickListener onMovieDateClickListener) {
        this.onMovieDateClickListener = onMovieDateClickListener;
    }

    public interface OnMovieDateClickListener {
        void onClick(CinemaMovieBean.DataBean.MoviesBean.ShowsBean item);
    }

}

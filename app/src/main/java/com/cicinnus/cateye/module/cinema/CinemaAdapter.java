package com.cicinnus.cateye.module.cinema;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.module.cinema.bean.CinemaListBean;
import com.cicinnus.cateye.tools.UiUtils;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class CinemaAdapter extends BaseQuickAdapter<CinemaListBean.DataBean.CinemasBean, BaseViewHolder> {


    public CinemaAdapter() {
        super(R.layout.item_cinema);
    }

    @Override
    protected void convert(BaseViewHolder helper, CinemaListBean.DataBean.CinemasBean item) {
        helper.setText(R.id.tv_cinema_name, item.getNm())
                .setText(R.id.tv_address, item.getAddr())
                .setText(R.id.tv_platform_activity, item.getPromotion().getPlatformActivityTag())
                .setText(R.id.tv_card_activity, item.getPromotion().getCardPromotionTag())
                .setText(R.id.tv_merchant_activity, item.getPromotion().getMerchantActivityTag())
                .setText(R.id.tv_distance, item.getDistance());

        helper.setVisible(R.id.tv_card_activity, item.getPromotion().getCardPromotionTag() != null);
        helper.setVisible(R.id.tv_platform_activity, item.getPromotion().getPlatformActivityTag() != null);
        helper.setVisible(R.id.tv_merchant_activity, item.getPromotion().getMerchantActivityTag() != null);


        double price = item.getPrice();
        TextView tvPrice = helper.getView(R.id.tv_price);
        tvPrice.setText(String.format("%s元起", price));
        Spannable spannable = new SpannableString(tvPrice.getText());
        spannable.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.colorPrimary)),
                0,
                tvPrice.getText().toString().indexOf("元起"),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvPrice.setText(spannable);


        //添加标签
        LinearLayout ll = helper.getView(R.id.ll_promotion);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, UiUtils.dp2px(helper.itemView.getContext(), 4), 0);
        if (ll.getTag() == null) {

            //座
            if (item.getTag().getSell() == 1) {
                TextView tv = createTextView(
                        helper.itemView.getContext(),
                        layoutParams,
                        "座",
                        "#579daf");
                ll.addView(tv);
            }

            //退票
//            if (item.getTag().getAllowRefund() == 1) {
//                TextView tv = createTextView(
//                        helper.itemView.getContext(),
//                        layoutParams,
//                        "退",
//                        "#579daf");
//                ll.addView(tv);
//            }
            //影院类型
            if (item.getTag().getHallType() != null && item.getTag().getHallType().size() > 0) {
                for (int i = 0; i < item.getTag().getHallType().size(); i++) {
                    TextView tv = createTextView(
                            helper.itemView.getContext(),
                            layoutParams,
                            item.getTag().getHallType().get(i),
                            "#579daf");
                    ll.addView(tv);
                }

            }
            if (item.getLabels() != null && item.getLabels().size() > 0) {
                for (int i = 0; i < item.getLabels().size(); i++) {
                    TextView tv = createTextView(
                            helper.itemView.getContext(),
                            layoutParams,
                            item.getLabels().get(i).getName(),
                            item.getLabels().get(i).getColor());
                    ll.addView(tv);

                }
            }

            //这样在view复用的时候就不会重复添加label
            ll.setTag("addView");
        }


    }

    public TextView createTextView(Context context, LinearLayout.LayoutParams layoutParams, String content, String color) {
        TextView tv = new TextView(context);
        tv.setLayoutParams(layoutParams);
        tv.setTextSize(11f);
        tv.setText(content);
        tv.setTextColor(Color.parseColor(color));
        tv.setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_promotion));
        GradientDrawable background = (GradientDrawable) tv.getBackground();
        background.setStroke(2, Color.parseColor(color));
        return tv;
    }
}

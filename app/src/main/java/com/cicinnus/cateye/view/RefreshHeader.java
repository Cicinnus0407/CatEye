package com.cicinnus.cateye.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.cicinnus.cateye.tools.UiUtils;

/**
 * Created by Administrator on 2017/1/19.
 */

public class RefreshHeader extends LinearLayout {
    private RefreshView refreshView;
    private static final float defaultSize = 30f;
    private static final float defaultMargin = 10f;

    public RefreshHeader(Context context) {
        this(context, null);
    }
    public RefreshHeader(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshHeader(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setOrientation(LinearLayout.VERTICAL);
        this.setGravity(Gravity.CENTER);
        addCatRefreshView();
    }

    private void addCatRefreshView(){
        refreshView = new RefreshView(getContext());
        int size = UiUtils.dp2px(getContext(), defaultSize);
        LayoutParams params = new LayoutParams(size, size);
        int margin = UiUtils.dp2px(getContext(), defaultMargin);
        params.bottomMargin = margin;
        params.topMargin = margin;
        refreshView.setLayoutParams(params);
        this.addView(refreshView);
    }

    public RefreshView getRefreshView() {
        return refreshView;
    }
}

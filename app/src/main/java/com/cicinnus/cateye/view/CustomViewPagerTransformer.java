package com.cicinnus.cateye.view;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 中间变大的PageTransformer
 */

public class CustomViewPagerTransformer implements ViewPager.PageTransformer {

    public static final float MAX_SCALE = 0.85f;
    public static final float MIN_SCALE = 0.65f;

    public CustomViewPagerTransformer() {

    }

    public void transformPage(View view, float position) {

        //[-1,1]才是需要变化的位置
        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }
        float tempScale = position < 0 ? 1 + position : 1 - position;
        float slope = (MAX_SCALE - MIN_SCALE) / 1;
        float scaleValue = MIN_SCALE + tempScale * slope;
        view.setScaleX(scaleValue);
        view.setScaleY(scaleValue);

    }

}

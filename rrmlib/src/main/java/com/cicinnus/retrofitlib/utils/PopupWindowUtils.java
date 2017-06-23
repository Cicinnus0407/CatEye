package com.cicinnus.retrofitlib.utils;

import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by Cicinnus on 2017/6/20.
 */

public class PopupWindowUtils {

    private  PopupWindow window;

    public  PopupWindow createPopupWindow(final View content, int heightPx) {
        window = new PopupWindow(content,
                ViewGroup.LayoutParams.MATCH_PARENT, heightPx);
        //点击地方消失
        content.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (content.equals("") && window.isShowing()) {
                    window.dismiss();
                    window = null;
                }
                return false;
            }
        });
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setFocusable(true);
        //点击外部隐藏
        window.setOutsideTouchable(true);
        return window;
    }

    /**
     * 显示或者隐藏window
     *
     * @param popupWindow   需要显示/隐藏的popupWindow
     * @param targetView    popupWindow出现的位置
     * @param statusChanged 状态
     */
    public  void ToggleWindow(PopupWindow popupWindow, View targetView, onWindowStatusChanged statusChanged) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
            statusChanged.onDismiss();

        } else {
            statusChanged.onShow();
            popupWindow.showAsDropDown(targetView, 0, 0);
        }
    }

    public interface onWindowStatusChanged {
        void onShow();

        void onDismiss();
    }

}

package com.cicinnus.cateye.view;

import android.content.Context;
import android.util.AttributeSet;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by Administrator on 2017/2/15.
 */

public class MyJcPlayer extends JCVideoPlayer {
    public MyJcPlayer(Context context) {
        super(context);
    }

    public MyJcPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }
}

package com.cicinnus.cateye.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.cicinnus.cateye.R;

/**
 * Created by Administrator on 2017/1/19.
 */

public class RefreshView extends ImageView {


    private float progress;//下拉程度
    private boolean isAnimate;//是否播放动画
    private Paint mPaint;
    private int rotateProgress;//旋转度数
    private Handler mHandler = new Handler();

    public RefreshView(Context context) {
        super(context);
    }

    public RefreshView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿
        progress = 0f;
        rotateProgress = 180;
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int minWidth = (int) (this.getWidth() * progress);//最小宽度
        int minHeight = (int) (this.getHeight() * progress);//最小高度

        if (minHeight > 1 && minWidth > 1) {
            Bitmap inner = BitmapFactory.decodeResource(getResources(), R.drawable.bg_pull_process);
            Bitmap outer = BitmapFactory.decodeResource(getResources(), R.drawable.ic_progress_out);

            float scaleW = getWidth() / inner.getWidth();
            float scaleH = getHeight() / inner.getHeight();
            int scaleWidth = (int) (inner.getWidth()*scaleW);
            int scaleHeight = (int) (inner.getHeight()*scaleH);
            canvas.drawBitmap(inner,null,new Rect(0,0,scaleWidth,scaleHeight),mPaint);


            Matrix matrix = new Matrix();
            matrix.postRotate(rotateProgress,scaleWidth/2.0f,scaleHeight/2.0f);
            Bitmap tmp_outer = Bitmap.createScaledBitmap(outer,scaleWidth,scaleHeight,true);

            if(progress>=1.0f){
                progress = 1.0f;
            }

            Bitmap mask_outter_circle = Bitmap.createBitmap(tmp_outer,0,0,tmp_outer.getWidth(), progress==1.0f?tmp_outer.getHeight(): (int) (tmp_outer.getHeight() * progress));
            canvas.drawBitmap(mask_outter_circle,matrix,mPaint);

            inner.recycle();
            tmp_outer.recycle();
            mask_outter_circle.recycle();
            outer.recycle();

        }

    }
    /**
     *开始旋转动画
     */
    public void startAnimate(){
        if(!isAnimate){
            isAnimate = true;
            mHandler.post(mRunnable);
        }

    }
    /**
     *结束旋转动画
     */
    public void stopAnimate(){
        isAnimate = false;
        mHandler.removeCallbacks(mRunnable);
        rotateProgress = 180;
        progress = 0f;
    }

    private Runnable mRunnable = new Runnable(){

        @Override
        public void run() {
            if(isAnimate){
                mHandler.postDelayed(mRunnable,10);
            }
            RefreshView.this.invalidate();
        }
    };


}

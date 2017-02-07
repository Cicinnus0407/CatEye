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


public class RefreshView extends ImageView{

    private Paint mPaint;
    private float progress;
    private boolean isAnimate;
    private int rotateProgress;
    private static Handler mHandler = new Handler();

    public RefreshView(Context context){
        this(context,null);
    }

    public RefreshView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        rotateProgress = 180;
        progress = 0f;
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int minWidth = (int) (this.getWidth() * progress);
        int minHeight = (int) (this.getHeight() * progress);
        if (minWidth > 1 && minHeight > 1) {

            Bitmap inner_cat = BitmapFactory.decodeResource(getResources(), R.drawable.bg_pull_process);
            Bitmap outter_circle = BitmapFactory.decodeResource(getResources(), R.drawable.ic_progress_out);

            float scaleW = (float)getWidth() / (float)inner_cat.getWidth();
            float scaleH = (float)getHeight() / (float)inner_cat.getHeight();
            int scaleWidth = (int) (inner_cat.getWidth() * scaleW);
            int scaleHeight = (int) (inner_cat.getHeight() * scaleH);
            canvas.drawBitmap(inner_cat, null, new Rect(0, 0, scaleWidth, scaleHeight), mPaint);

            Matrix matrix = new Matrix();
            matrix.postRotate(rotateProgress, (float)scaleWidth/2.0f, (float)scaleHeight/2.0f);
            //创建一个新的可缩放的bitmap
            Bitmap temp_outter_circle = Bitmap.createScaledBitmap(outter_circle,scaleWidth,scaleHeight,true);

            if(progress >= 1.0f){
                progress = 1.0f;
            }
            Bitmap mask_outter_circle = Bitmap.createBitmap(temp_outter_circle, 0, 0,
                    temp_outter_circle.getWidth(),progress == 1.0f?
                            temp_outter_circle.getHeight()
                            :(int)(temp_outter_circle.getHeight()*progress));
            canvas.drawBitmap(mask_outter_circle, matrix, mPaint);

            inner_cat.recycle();
            temp_outter_circle.recycle();
            mask_outter_circle.recycle();
            outter_circle.recycle();
        }
    }

    /**
     *设置红色圆圈显示程度
     */
    public void setProgress(float progress) {
        this.progress = progress;
        this.invalidate();
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
            rotateProgress += 8;
//			if(rotateProgress>=360){
//				rotateProgress = 0;
//			}
            if(isAnimate){
                mHandler.postDelayed(mRunnable,10);
            }
            RefreshView.this.invalidate();
        }
    };
}

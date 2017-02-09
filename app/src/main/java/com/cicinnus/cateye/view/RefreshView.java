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
 * 自定义刷新头部
 */

public class RefreshView extends ImageView {

    private Paint mPaint;
    private float progress;//进度，就是显示的程度
    private boolean isAnimate;//判断是否在旋转
    private int rotateProgress;//旋转角度
    private Handler mHandler;

    public RefreshView(Context context) {
        this(context, null);
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
        mPaint.setAntiAlias(true);
        rotateProgress = 180;
        progress = 0f;
        mHandler = new Handler();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int minWidth = (int) (this.getWidth() * progress);
        int minHeight = (int) (this.getHeight() * progress);
        if (minWidth > 1 && minHeight > 1) {

            Bitmap inner = BitmapFactory.decodeResource(getResources(), R.drawable.bg_pull_process);
            Bitmap circle = BitmapFactory.decodeResource(getResources(), R.drawable.ic_progress_out);

            float scaleW = (float) getWidth() / (float) inner.getWidth();
            float scaleH = (float) getHeight() / (float) inner.getHeight();
            int scaleWidth = (int) (inner.getWidth() * scaleW);
            int scaleHeight = (int) (inner.getHeight() * scaleH);
            //画内部的灰色猫icon
            canvas.drawBitmap(inner, null, new Rect(0, 0, scaleWidth, scaleHeight), mPaint);

            Matrix matrix = new Matrix();
            //顺时针旋转180度，因为一开始应该是从下网上画图片
            matrix.postRotate(rotateProgress, (float) scaleWidth / 2.0f, (float) scaleHeight / 2.0f);
            //创建一个新的可缩放的bitmap
            Bitmap temp_circle = Bitmap.createScaledBitmap(circle, scaleWidth, scaleHeight, true);

            if (progress >= 1.0f) {
                progress = 1.0f;
            }
            //创建一个bitmap，其实就是从下到上画一个图，
            // progress每次变动都会重新绘制外圈，
            // createBitmap最后一个参数就是所画图片的高度，
            // 因为是根据显示程度来绘制，所以高度*（progress） 其中progess<=1,就会有渐变的效果
            Bitmap mask_outter_circle = Bitmap.createBitmap(temp_circle, 0, 0, temp_circle.getWidth(), progress == 1.0f ?
                            temp_circle.getHeight()
                            : (int) (temp_circle.getHeight() * progress));

            canvas.drawBitmap(mask_outter_circle, matrix, mPaint);

            inner.recycle();
            temp_circle.recycle();
            mask_outter_circle.recycle();
            circle.recycle();
        }
    }

    /**
     * 设置红色圆圈显示程度
     */
    public void setProgress(float progress) {
        this.progress = progress;
        this.invalidate();
    }

    /**
     * 开始旋转动画
     */
    public void startAnimate() {
        if (!isAnimate) {
            isAnimate = true;
            mHandler.post(mRunnable);
        }

    }

    /**
     * 结束旋转动画
     */
    public void stopAnimate() {
        isAnimate = false;
        mHandler.removeCallbacks(mRunnable);
        rotateProgress = 180;
        progress = 0f;
    }

    private Runnable mRunnable = new Runnable() {

        @Override
        public void run() {
            rotateProgress += 8;
            if (isAnimate) {
                mHandler.postDelayed(mRunnable, 10);
            }
            RefreshView.this.invalidate();
        }
    };
}

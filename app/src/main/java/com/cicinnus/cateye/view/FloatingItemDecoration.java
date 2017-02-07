package com.cicinnus.cateye.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Dimension;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;

import com.cicinnus.cateye.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cicinnus on 2017/1/26.
 */

public class FloatingItemDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "FloatingItemDecoration";
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};
    private Drawable mDivider;
    private int dividerHeight;
    private int dividerWidth;
    private Map<Integer,String> keys=new HashMap<>();
    private int mTitleHeight;
    private Paint mTextPaint;
    private Paint mBackgroundPaint;
    private float mTextHeight;
    private float mTextBaselineOffset;
    private Context mContext;
    /**
     * 滚动列表的时候是否一直显示悬浮头部
     */
    private boolean showFloatingHeaderOnScrolling=true;

    public FloatingItemDecoration(Context context) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        this.dividerHeight=mDivider.getIntrinsicHeight();
        this.dividerWidth=mDivider.getIntrinsicWidth();
        init(context);
    }

    /**
     * 自定义分割线
     *
     * @param context
     * @param drawableId           分割线图片
     */
    public FloatingItemDecoration(Context context, @DrawableRes int drawableId) {
        mDivider = ContextCompat.getDrawable(context, drawableId);
        this.dividerHeight=mDivider.getIntrinsicHeight();
        this.dividerWidth=mDivider.getIntrinsicWidth();
        init(context);
    }

    /**
     * 自定义分割线
     * 也可以使用{@link Canvas#drawRect(float, float, float, float, Paint)}或者{@link Canvas#drawText(String, float, float, Paint)}等等
     * 结合{@link Paint}去绘制各式各样的分割线
     * @param context
     * @param color  整型颜色值，非资源id
     * @param dividerWidth  单位为dp
     * @param dividerHeight  单位为dp
     */
    public FloatingItemDecoration(Context context, @ColorInt int color, @Dimension float dividerWidth, @Dimension float dividerHeight) {
        mDivider = new ColorDrawable(color);
        this.dividerWidth= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dividerWidth,context.getResources().getDisplayMetrics());
        this.dividerHeight= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dividerHeight,context.getResources().getDisplayMetrics());
        init(context);
    }

    private void init(Context mContext){
        this.mContext=mContext;
        mTextPaint=new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,12,mContext.getResources().getDisplayMetrics()));
        mTextPaint.setColor(Color.BLACK);
        Paint.FontMetrics fm=mTextPaint.getFontMetrics();
        mTextHeight=fm.bottom-fm.top;//计算文字高度
        mTextBaselineOffset=fm.bottom;

        mBackgroundPaint=new Paint();
        mBackgroundPaint.setAntiAlias(true);
        mBackgroundPaint.setColor(mContext.getResources().getColor(R.color.divider_normal));
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        drawVertical(c,parent);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        if(!showFloatingHeaderOnScrolling){
            return;
        }
        int firstVisiblePos=((LinearLayoutManager)parent.getLayoutManager()).findFirstVisibleItemPosition();
        if(firstVisiblePos==RecyclerView.NO_POSITION){
            return;
        }
        String title=getTitle(firstVisiblePos);
        if(TextUtils.isEmpty(title)){
            return;
        }
        boolean flag=false;
        if(getTitle(firstVisiblePos+1)!=null&&!title.equals(getTitle(firstVisiblePos+1))){
            //说明是当前组最后一个元素，但不一定碰撞了
//            Log.e(TAG, "onDrawOver: "+"==============" +firstVisiblePos);
            View child=parent.findViewHolderForAdapterPosition(firstVisiblePos).itemView;
            if(child.getTop()+child.getMeasuredHeight()<mTitleHeight){
                //进一步检测碰撞
//                Log.e(TAG, "onDrawOver: "+child.getTop()+"$"+firstVisiblePos );
                c.save();//保存画布当前的状态
                flag=true;
                c.translate(0,child.getTop()+child.getMeasuredHeight()-mTitleHeight);//负的代表向上
            }
        }
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int top=parent.getPaddingTop();
        int bottom=top+mTitleHeight;
        c.drawRect(left,top,right,bottom,mBackgroundPaint);
        float x=TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10,mContext.getResources().getDisplayMetrics());
        float y=bottom - (mTitleHeight - mTextHeight) / 2 - mTextBaselineOffset;//计算文字baseLine
        c.drawText(title,x,y,mTextPaint);
        if(flag){
            //还原画布为初始状态
            c.restore();
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos=parent.getChildViewHolder(view).getAdapterPosition();
        if(keys.containsKey(pos)){//留出头部偏移
            outRect.set(0,mTitleHeight,0,0);
        }else{
            outRect.set(0,dividerHeight,0,0);
        }
    }

    /**
     **如果该位置没有，则往前循环去查找标题，找到说明该位置属于该分组
     * @param position
     * @return
     */
    private String getTitle(int position) {
        while (position >= 0) {
            if (keys.containsKey(position)) {
                return keys.get(position);
            }
            position--;
        }
        return null;
    }

    private void drawVertical(Canvas c, RecyclerView parent){
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int top=0;
        int bottom=0;
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child=parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            if(!keys.containsKey(params.getViewAdapterPosition())){
                //画普通分割线
                top=child.getTop()-params.topMargin-dividerHeight;
                bottom=top+dividerHeight;
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }else{
                //画分组
                top=child.getTop()-params.topMargin-mTitleHeight;
                bottom=top+mTitleHeight;
                c.drawRect(left,top,right,bottom,mBackgroundPaint);
//                float x=child.getPaddingLeft()+params.leftMargin;
                float x=TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10,mContext.getResources().getDisplayMetrics());
                float y=bottom - (mTitleHeight - mTextHeight) / 2 - mTextBaselineOffset;//计算文字baseLine
//                Log.e(TAG, "drawVertical: "+bottom );
                c.drawText(keys.get(params.getViewLayoutPosition()),x,y,mTextPaint);
            }
        }
    }

    public void setShowFloatingHeaderOnScrolling(boolean showFloatingHeaderOnScrolling) {
        this.showFloatingHeaderOnScrolling = showFloatingHeaderOnScrolling;
    }

    public void setKeys(Map<Integer,String> keys){
        this.keys.clear();
        this.keys.putAll(keys);
    }

    public void setmTitleHeight(int titleHeight){
        this.mTitleHeight=titleHeight;
    }
}

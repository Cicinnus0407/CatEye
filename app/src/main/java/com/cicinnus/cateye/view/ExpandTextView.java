package com.cicinnus.cateye.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.tools.UiUtils;

/**
 * Created by Cicinnus on 2017/2/11.
 */

public class ExpandTextView extends LinearLayout {

    protected TextView contentView; //文本正文
    protected ImageView expandView; //展开按钮

    //对应styleable中的属性
    protected int textColor;
    protected float textSize;
    protected int maxLine;
    protected String text;

    //默认属性值
    public int defaultTextColor = Color.BLACK;
    public int defaultTextSize = 14;
    public int defaultLine = 1;
    private int orientation = 1;


    public ExpandTextView(Context context) {
        super(context);
    }

    public ExpandTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithAttrs(context, attrs);
        bindListener();
    }


    public ExpandTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        setGravity(Gravity.CENTER); //中间对齐
        //初始化textView并添加
        contentView = new TextView(getContext());
        //添加行距
        contentView.setLineSpacing(1f, 1.3f);
        addView(contentView);
        //初始化ImageView并添加
        expandView = new ImageView(getContext());
        int padding = UiUtils.dp2px(getContext(), 5);
        expandView.setPadding(padding, padding, padding, padding);
        expandView.setImageResource(R.drawable.ic_arrow_down);
//        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        addView(expandView);
    }


    private void initWithAttrs(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ExpandTextView);
        int textColor = a.getColor(R.styleable.ExpandTextView_textColor,
                defaultTextColor);  //取颜色值，默认defaultTextColor
        textSize = a.getDimensionPixelSize(R.styleable.ExpandTextView_textSize, defaultTextSize);//取字体大小，默认defaultTextSize
        maxLine = a.getInt(R.styleable.ExpandTextView_maxLine, defaultLine);//取显示行数，默认defaultLine
        text = a.getString(R.styleable.ExpandTextView_text);//取文本内容
        orientation = a.getInteger(R.styleable.ExpandTextView_tv_orientation, 1);        //图标和文字方向,默认为垂直
        setOrientation(orientation == 0 ? HORIZONTAL : VERTICAL);//设置布局


        //绑定到textView   bindTextView(textColor,textSize,maxLine,text);
        bindTextView(textColor, textSize, maxLine, text);
        a.recycle();//回收释放
    }


    private void bindTextView(int textColor, float textSize, final int maxLine, String text) {
        contentView.setTextColor(textColor);
        contentView.setTextSize(textSize);
        contentView.setText(text);
        contentView.setHeight(contentView.getLineHeight() * maxLine);
    }

    private void bindListener() {
        setOnClickListener(new View.OnClickListener() {
            boolean isExpand;

            @Override
            public void onClick(View v) {
                isExpand = !isExpand;
                contentView.clearAnimation();
                final int deltaValue;
                final int startValue = contentView.getHeight();
                int durationMillis = 350;
                if (isExpand) {
                    deltaValue = contentView.getLineHeight() * contentView.getLineCount() - startValue;
                    RotateAnimation animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(durationMillis);
                    animation.setFillAfter(true);
                    expandView.startAnimation(animation);
                } else {
                    deltaValue = contentView.getLineHeight() * maxLine - startValue;
                    RotateAnimation animation = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(durationMillis);
                    animation.setFillAfter(true);
                    expandView.startAnimation(animation);
                }
                Animation animation = new Animation() {
                    protected void applyTransformation(float interpolatedTime, Transformation t) {
                        contentView.setHeight((int) (startValue + deltaValue * interpolatedTime));
                    }

                };
                animation.setDuration(durationMillis);
                contentView.startAnimation(animation);
            }
        });
    }

    public TextView getTextView() {
        return contentView;
    }

    public void setText(CharSequence charSequence) {
        contentView.setText(charSequence);
    }

}

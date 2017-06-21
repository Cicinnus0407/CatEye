package com.cicinnus.cateye.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.tools.GlideManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Cicinnus on 2017/6/20.
 */

public class Banner extends FrameLayout implements View.OnClickListener {

    //时间
    private static final long SECONDS = 5;
    //顶部轮播体条新闻
    private List<BannerPicBean.PicBean> picBeen;
    private ViewPager vp;
    private Context context;
    //自动播放
    private boolean isAutoPlay;

    //view集合
    private List<View> views;
    //小圆点集合
//    private List<ImageView> iv_dots;
    //当前图片
    private int currentItem;

    private OnItemClickListener mItemClickListener;

    private MyOnPageChangeListener myOnPageChangeListener;
    private boolean stopScroll = false;
    private ImageView.ScaleType mScyleType = ImageView.ScaleType.CENTER_CROP;
    private List<ImageView> imageViews;
    private Disposable disposable;

    public Banner(Context context) {
        this(context, null);
    }

    public Banner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Banner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.picBeen = new ArrayList<>();
        initView();
    }

    private void initView() {
        //初始化view集合
        views = new ArrayList<>();
        imageViews = new ArrayList<>();
    }

    public void setPic(List<BannerPicBean.PicBean> bannerPicBeen) {
        this.picBeen = bannerPicBeen;
        reset();
    }

    public void setErrorPic(List<BannerPicBean.PicBean> errorPic) {
        this.picBeen = errorPic;
        reset();
    }

    private void reset() {
        views.clear();
        initUI();
    }

    private void initUI() {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_layout, this, true);
        vp = (ViewPager) view.findViewById(R.id.vp);

        int len = picBeen.size();

        for (int i = 0; i <= len + 1; i++) {
            View view_content = LayoutInflater.from(context)
                    .inflate(R.layout.banner_content_layout, null);
            ImageView iv = (ImageView) view_content.findViewById(R.id.iv_title);
            //设置以缩放类型
            iv.setScaleType(mScyleType);

            //在本来的最后一张图片后面，再添加一张和第一张一样的图片来充当一个缓冲。
            if (i == 0) {
                GlideManager.loadImage(context, picBeen.get(len - 1).picUrl, iv);

            } else if (i == len + 1) {
                GlideManager.loadImage(context, picBeen.get(0).picUrl, iv);

            } else {
                GlideManager.loadImage(context, picBeen.get(i - 1).picUrl, iv);

            }
            view_content.setOnClickListener(this);
            views.add(view_content);
        }
        vp.setAdapter(new MyPagerAdapter());
        vp.setFocusable(true);//设置可以获取触摸焦点
        vp.setCurrentItem(1);
        currentItem = 1;//初始化item为1
        myOnPageChangeListener = new MyOnPageChangeListener();
        vp.addOnPageChangeListener(myOnPageChangeListener);
        startPlay();
    }

    /**
     * 自动播放
     */
    private void startPlay() {
        isAutoPlay = true;
        disposable = Observable.interval(SECONDS, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        if (isAutoPlay) {
                            currentItem = currentItem % (picBeen.size() + 1) + 1;
                            if (currentItem == 1) {
                                vp.setCurrentItem(currentItem, false);
                            } else {
                                vp.setCurrentItem(currentItem);
                            }
                        }
                    }
                });
    }

    public void stopPlay() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
        }
    }


    @Override
    public void onClick(View v) {
        if (mItemClickListener != null && stopScroll) {
            BannerPicBean.PicBean bean = picBeen.get(vp.getCurrentItem() - 1);
            mItemClickListener.click(v, bean);
        }
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    /**
     * 设置图片的压缩类型
     *
     * @param mScyleType ImageView.ScaleType
     */
    public void setmScyleType(ImageView.ScaleType mScyleType) {
        this.mScyleType = mScyleType;
    }

    public interface OnItemClickListener {
        void click(View v, BannerPicBean.PicBean bean);
    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imageViews.size() > 0 ? imageViews.size() : views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (views.size() > 1) {
                container.addView(views.get(position));
                return views.get(position);
            } else {
                container.addView(imageViews.get(position));
                return imageViews.get(position);
            }
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    /**
     * 图片滑动监听
     */
    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
                case ViewPager.SCROLL_STATE_DRAGGING:
                    isAutoPlay = false;
                    stopScroll = false;
                    break;
                case ViewPager.SCROLL_STATE_SETTLING:
                    isAutoPlay = true;
                    stopScroll = true;
                    break;
                case ViewPager.SCROLL_STATE_IDLE:
                    if (vp.getCurrentItem() == 0) {
                        vp.setCurrentItem(picBeen.size(), false);
                    } else if (vp.getCurrentItem() == picBeen.size() + 1) {
                        vp.setCurrentItem(1, false);
                    }
                    currentItem = vp.getCurrentItem();
                    isAutoPlay = true;
                    stopScroll = true;
                    break;
            }
        }
    }


    public static class BannerPicBean {

        public static class PicBean {
            public String picUrl;
        }
    }
}

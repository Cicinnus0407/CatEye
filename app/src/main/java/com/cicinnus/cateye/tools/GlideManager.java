package com.cicinnus.cateye.tools;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cicinnus.cateye.R;


public class GlideManager {

    public static void loadImage(Context context, String url, int errorImg, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .error(errorImg)
                .placeholder(R.drawable.icon_default)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(imageView);
    }

    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.icon_default)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(imageView);
    }

    public static void loadImage(Context context, int drawable, ImageView imageView) {
        Glide.with(context)
                .load(drawable)
                .placeholder(R.drawable.icon_default)
                .dontAnimate()
                .into(imageView);
    }

    public static void clearPicCache(Context context) {
        final Glide glide = Glide.get(context);
        new Thread(new Runnable() {
            @Override
            public void run() {
                glide.clearDiskCache();
            }
        }).start();
    }
}

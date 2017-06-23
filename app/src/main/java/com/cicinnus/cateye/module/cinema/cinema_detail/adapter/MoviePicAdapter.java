package com.cicinnus.cateye.module.cinema.cinema_detail.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaMovieBean;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片轮播ViewPager
 */

public class MoviePicAdapter extends PagerAdapter {

    private List<String> urls;
    private OnImageViewClickListener onImageViewClickListener;

    public MoviePicAdapter() {
        urls = new ArrayList<>();
    }

    public void setUrls(List<CinemaMovieBean.DataBean.MoviesBean> movies) {
        urls.clear();
        for (int i = 0; i < movies.size(); i++) {
            String url = ImgSizeUtil.processUrl(movies.get(i).getImg(), 174, 244);
            urls.add(url);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return urls.size();
    }




    @Override
    public final Object instantiateItem(final ViewGroup container, final int position) {

        ImageView imageView = new ImageView(container.getContext());
        GlideManager.loadImage(container.getContext(), urls.get(position), imageView);
        imageView.setTag(position);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onImageViewClickListener != null) {
                    onImageViewClickListener.onClick(position);
                }
            }
        });
        container.addView(imageView);
        return imageView;
    }

    @Override
    public final void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);

    }

    @Override
    public final boolean isViewFromObject(View view, Object object) {
        return view == object;
    }



    public interface OnImageViewClickListener {
        void onClick(int position);
    }
}

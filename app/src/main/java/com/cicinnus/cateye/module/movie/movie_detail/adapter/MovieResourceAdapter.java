package com.cicinnus.cateye.module.movie.movie_detail.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseWebViewActivity;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieResourceBean;
import com.cicinnus.cateye.tools.GlideManager;

/**
 * Created by Administrator on 2017/2/13.
 */

public class MovieResourceAdapter extends BaseQuickAdapter<MovieResourceBean.DataBean, BaseViewHolder> {

    private IMovieResourceClickListener movieResourceClickListener;

    public MovieResourceAdapter() {
        super(R.layout.item_movie_resource, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MovieResourceBean.DataBean item) {
        helper.setText(R.id.tv_movie_resource_title, item.getTitle())
                .setText(R.id.tv_movie_resource_content, item.getContent());

        GlideManager.loadImage(mContext, item.getImg(), (ImageView) helper.getView(R.id.iv_movie_resource));

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (movieResourceClickListener != null) {
                    if (item.getUrl() == null) {
                        movieResourceClickListener.onClick(item.getName());
                    } else {
                        String url = item.getUrl();
                        String id = url.substring(url.indexOf("id=") + 3, url.indexOf("&"));
                        String realUrl = "http://m.maoyan.com/information/"+id+"?_v_=yes";
                        BaseWebViewActivity.start(mContext, realUrl);
                    }
                }
            }
        });
    }

    public void setMovieResourceClickListener(IMovieResourceClickListener movieResourceClickListener) {
        this.movieResourceClickListener = movieResourceClickListener;
    }

    public interface IMovieResourceClickListener {
        void onClick(String type);
    }
}

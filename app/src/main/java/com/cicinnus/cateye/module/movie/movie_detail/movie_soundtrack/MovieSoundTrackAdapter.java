package com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseWebViewActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieMusicBean;
import com.cicinnus.cateye.module.movie.movie_video.MovieVideoActivity;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieSoundTrackAdapter extends BaseQuickAdapter<MovieMusicBean.DataBean.ItemsBean, BaseViewHolder> {

    public MovieSoundTrackAdapter() {
        super(R.layout.item_movie_music, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MovieMusicBean.DataBean.ItemsBean item) {

        if(item.getMusicType()==1){
            //视频
            helper.setImageResource(R.id.iv_video_or_music,R.drawable.ic_video)
                    .setImageResource(R.id.iv_mv_or_music,R.drawable.ic_mv);

            helper.convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MovieVideoActivity.start(mContext,
                            item.getVideoTagVO().getMovieId(),
                            item.getVideoTagVO().getId(),
                            item.getVideoTagVO().getTitle(),
                            item.getVideoTagVO().getUrl(),true,item.getVideoTagVO());
                }
            });
        }else {
            helper.setImageResource(R.id.iv_video_or_music,R.drawable.ic_music)
                    .setImageResource(R.id.iv_mv_or_music,R.drawable.ic_qq_music);
            helper.convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BaseWebViewActivity.start(mContext,item.getUrl(),"电影原声");
                }
            });
        }
        helper.setText(R.id.tv_music_name, item.getTitle())
                .setText(R.id.tv_music_num, String.format("%s",helper.getAdapterPosition()))
                .setText(R.id.tv_singer, item.getDesc());

    }
}

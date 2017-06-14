package com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseRecyclerViewActivity;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieAlbumBean;
import com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean.MovieMusicBean;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.tools.ImgSizeUtil;

/**
 * 电影原声
 */

public class MovieSoundTrackActivity extends BaseRecyclerViewActivity<MovieSoundTrackMVPPresenter> implements MovieSoundTrackContract.IMovieSoundTrackView {


    private static final String MOVIE_ID = "movie_id";
    private int movieId;
    private MovieSoundTrackAdapter movieSoundTrackAdapter;
    private View header;

    public static void start(Context context,int movieId) {
        Intent starter = new Intent(context, MovieSoundTrackActivity.class);
        starter.putExtra(MOVIE_ID,movieId);
        context.startActivity(starter);
    }

    @Override
    protected MovieSoundTrackMVPPresenter getMPresenter() {
        return new MovieSoundTrackMVPPresenter(mContext,this);
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        movieId = getIntent().getIntExtra(MOVIE_ID,0);

        movieSoundTrackAdapter = new MovieSoundTrackAdapter();
        rvBaseRecyclerView.setAdapter(movieSoundTrackAdapter);
        header = getLayoutInflater().inflate(R.layout.layout_movie_music_header, (ViewGroup) rvBaseRecyclerView.getParent(),false);
        movieSoundTrackAdapter.addHeaderView(header);
        ((MovieSoundTrackMVPPresenter) mPresenter).getMovieSoundTrack(movieId);
    }

    @Override
    protected void setPullToRefresh() {
        ((MovieSoundTrackMVPPresenter) mPresenter).getMovieSoundTrack(movieId);
    }

    @Override
    protected String getTitleText() {
        return "电影原声";
    }

    @Override
    protected void onErrorResetData() {
        ((MovieSoundTrackMVPPresenter) mPresenter).getMovieSoundTrack(movieId);
    }

    @Override
    public void addMovieAlbum(MovieAlbumBean.DataBean movieAlbum) {
        ((TextView) header.findViewById(R.id.tv_movie_album)).setText(movieAlbum.getAlbumName());
        ((TextView) header.findViewById(R.id.tv_movie_album_singer)).setText(movieAlbum.getSinger());
        String imgUrl = ImgSizeUtil.resetPicUrl(movieAlbum.getImg(),".webp@420w_420h_1e_1c_1l");
        GlideManager.loadImage(mContext,imgUrl, ((ImageView) header.findViewById(R.id.iv_movie_album)));

    }

    @Override
    public void addMovieMusic(MovieMusicBean.DataBean movieMusic) {
        movieSoundTrackAdapter.setNewData(movieMusic.getItems());
    }
}

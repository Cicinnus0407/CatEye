package com.cicinnus.cateye.module.movie.movie_video;

import android.content.Context;
import android.content.Intent;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Administrator on 2017/2/14.
 */

public class MovieVideoActivity extends BaseActivity {


    @BindView(R.id.videoplayer)
    JCVideoPlayerStandard videoplayer;


    private static final String VIDEO_URL = "video_url";

    public static void start(Context context,String url) {
        Intent starter = new Intent(context, MovieVideoActivity.class);
        starter.putExtra(VIDEO_URL,url);
        context.startActivity(starter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_movie_video;
    }

    @Override
    protected void initEventAndData() {
        String videoUrl = getIntent().getStringExtra(VIDEO_URL);
        videoplayer.setUp(videoUrl, JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"title");
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}

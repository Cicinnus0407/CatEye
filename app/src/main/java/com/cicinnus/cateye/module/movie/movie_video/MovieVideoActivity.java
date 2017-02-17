package com.cicinnus.cateye.module.movie.movie_video;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.module.movie.movie_video.RxBusPostBean.CommentCountPostBean;
import com.cicinnus.cateye.module.movie.movie_video.RxBusPostBean.VideoPostBean;
import com.cicinnus.cateye.module.movie.movie_video.video_comment.VideoCommentListFragment;
import com.cicinnus.cateye.module.movie.movie_video.video_list.VideoListFragment;
import com.cicinnus.cateye.tools.UiUtils;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Administrator on 2017/2/14.
 */

public class MovieVideoActivity extends BaseActivity {


    @BindView(R.id.videoplayer)
    JCVideoPlayerStandard videoplayer;
    @BindView(R.id.view_indicator)
    View view;
    @BindView(R.id.tv_video_info)
    TextView tvVideoInfo;
    @BindView(R.id.tv_video_comment)
    TextView tvVideoComment;
    @BindView(R.id.tv_video_comment_count)
    TextView tvVideoCommentCount;
    @BindView(R.id.vp_video_comment)
    ViewPager vpVideoComment;



    private FrameLayout.LayoutParams params;

    private static final String MOVIE_ID = "movie_id";
    private static final String VIDEO_URL = "video_url";
    private static final String VIDEO_NAME = "video_name";
    private static final String VIDEO_ID = "video_id";
    private int videoId;
    private int movieId;

    public static void start(Context context, int movieId,int videoId,String videoName, String url) {
        Intent starter = new Intent(context, MovieVideoActivity.class);
        starter.putExtra(MOVIE_ID, movieId);
        starter.putExtra(VIDEO_ID, videoId);
        starter.putExtra(VIDEO_NAME, videoName);
        starter.putExtra(VIDEO_URL, url);
        context.startActivity(starter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_movie_video;
    }

    @Override
    protected void initEventAndData() {
        String videoUrl = getIntent().getStringExtra(VIDEO_URL);
        String videoName = getIntent().getStringExtra(VIDEO_NAME);
        videoId = getIntent().getIntExtra(VIDEO_ID,0);
        movieId = getIntent().getIntExtra(MOVIE_ID,0);
        videoplayer.setUp(videoUrl, JCVideoPlayer.SCREEN_LAYOUT_NORMAL, videoName);

        setUpViewPager();
        RxBus.get().register(this);
    }

    private void setUpViewPager() {
        //设置view的宽度
        params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.width = UiUtils.getDeviceWidth(mContext)/2;
        params.setMargins(UiUtils.dp2px(mContext,14),0,UiUtils.dp2px(mContext,14),0);
        view.setLayoutParams(params);

        final List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(VideoListFragment.newInstance(movieId));
        fragmentList.add(VideoCommentListFragment.newInstance(videoId));





        vpVideoComment.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });




        vpVideoComment.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //判断滑动的距离
                if (positionOffset == 0) { // 停止滚动
                    params.setMargins(view.getWidth() * position, 0, 0, 0);
                } else {
                    params.setMargins((int) (view.getWidth() * (position + positionOffset)), 0, 0, 0);
                }
                //通过LayoutParams设置滑块的位置
                view.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        tvVideoInfo.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
                        tvVideoComment.setTextColor(mContext.getResources().getColor(R.color.text_gray_deep));
                        break;
                    case 1:
                        tvVideoComment.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
                        tvVideoInfo.setTextColor(mContext.getResources().getColor(R.color.text_gray_deep));

                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.tv_video_info, R.id.rl_video_comment,R.id.iv_back})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_video_info:
                vpVideoComment.setCurrentItem(0);
                break;
            case R.id.rl_video_comment:
                vpVideoComment.setCurrentItem(1);
                break;

        }
    }

    @Subscribe
    public void ChangeVideo(VideoPostBean videoPostBean){
        videoplayer.setUp(videoPostBean.getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL, videoPostBean.getVideoName());
        videoplayer.startVideo();

    }

    @Subscribe
    public void CommentCount(CommentCountPostBean count){
        tvVideoCommentCount.setVisibility(View.VISIBLE);
        tvVideoCommentCount.setText(String.format("%s",count.getCommentCount()));
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }
}

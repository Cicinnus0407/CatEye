package com.cicinnus.cateye.module.movie.movie_video.video_list;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/15.
 */

public class VideoListFragment extends BaseFragment<VideoListPresenter> implements VideoListContract.IVideoListView {

    @BindView(R.id.rv_movie_video)
    RecyclerView rvMovieVideo;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    @BindView(R.id.tv_movie_name)
    TextView tvMovieName;
    @BindView(R.id.tv_movie_score)
    TextView tvMovieScore;
    @BindView(R.id.tv_score_wish)
    TextView tvScoreWish;
    @BindView(R.id.tv_pub_time)
    TextView tvPubTime;
    @BindView(R.id.tv_video_count)
    TextView tvVideoCount;


    private VideoListAdapter videoListAdapter;


    private static final String MOVIE_ID = "movie_id";
    private int movieId;
    private int offset;
    private MyPullToRefreshListener pullToRefreshListener;
    private List<VideoListBean.DataBean> videoListBeen;

    public static VideoListFragment newInstance(int movieId) {

        Bundle args = new Bundle();
        args.putInt(MOVIE_ID, movieId);
        VideoListFragment fragment = new VideoListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_list;
    }

    @Override
    protected VideoListPresenter getPresenter() {
        return new VideoListPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        movieId = getArguments().getInt(MOVIE_ID, 0);
        videoListBeen = new ArrayList<>();
        videoListAdapter = new VideoListAdapter();
        rvMovieVideo.setLayoutManager(new LinearLayoutManager(mContext));
        rvMovieVideo.setAdapter(videoListAdapter);


        //下拉刷新
        pullToRefreshListener = new MyPullToRefreshListener(mContext, swipe);
        swipe.setOnPullRefreshListener(pullToRefreshListener);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                offset = 0;
                mPresenter.getVideoList(movieId, offset);
            }
        });
        //加载更多
        videoListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMoreVideo(movieId, offset);
            }
        });


        mPresenter.getVideoList(movieId, offset);
        mPresenter.getVideoMovieInfo(movieId);
    }

    /**
     * 视频列表
     * @param data
     */
    @Override
    public void addVideoList(List<VideoListBean.DataBean> data) {
        offset+=10;
        videoListBeen.addAll(data);
        //将第一个数据设为选中状态,因为默认播放第一个视频
        videoListBeen.get(0).isSelect = true;
        videoListBeen.set(0, videoListBeen.get(0));
        videoListAdapter.setNewData(videoListBeen);

    }

    /**
     * 影片信息
     * @param info
     */
    @Override
    public void addVideoMovieInfo(VideoMovieInfoBean.DataBean info) {
        tvMovieName.setText(info.getName());
        if(info.getScore()==0){
            tvMovieScore.setText(String.format("%s",info.getWish()));
            tvScoreWish.setText("人想看");
        }else {
            tvMovieScore.setText(String.format("%s",info.getScore()));
            tvScoreWish.setText("分");
        }
        tvPubTime.setText(info.getPubdesc());
    }

    /**
     * 视频总数
     * @param total
     */
    @Override
    public void addTotalCount(int total) {
        tvVideoCount.setText(String.format("(%s)",total));
    }

    @Override
    public void addVideoMoreList(List<VideoListBean.DataBean> videoMoreData) {
        if (videoMoreData.size() > 0) {
            offset += 10;
            videoListAdapter.addData(videoMoreData);
            videoListAdapter.loadMoreComplete();
        } else {
            videoListAdapter.loadMoreEnd();
        }
    }

    @Override
    public void showLoadMoreError(String message) {
        videoListAdapter.loadMoreFail();
    }

    @Override
    public void showLoading() {
        if (!progressLayout.isContent()) {
            progressLayout.showLoading();
        }
    }

    @Override
    public void showContent() {
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
        pullToRefreshListener.refreshDone();
    }

    @Override
    public void showError(String errorMsg) {
        pullToRefreshListener.refreshDone();
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getVideoList(movieId, offset);
            }
        });
    }

}

package com.cicinnus.cateye.module.movie.movie_video.video_list;

import com.cicinnus.cateye.base.ILoadingView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */

public class VideoListContract {
    public interface IVideoListView extends ILoadingView{
        void addVideoList(List<VideoListBean.DataBean> data);

        void addVideoMovieInfo(VideoMovieInfoBean.DataBean videoMovieInfoBeanData);

        void addTotalCount(int total);

        void addVideoMoreList(List<VideoListBean.DataBean> videoMoreData);

        void showLoadMoreError(String message);
    }

    public interface IVideoListPresenter{
        void getVideoList(int movieId,int offset);

        void getVideoMovieInfo(int movieId);

        void getMoreVideo(int movieId, int offset);
    }
}

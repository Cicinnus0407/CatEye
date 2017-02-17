package com.cicinnus.cateye.module.movie.movie_video.video_comment;

import com.cicinnus.cateye.base.ILoadingView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */

public class VideoCommentListContract {
    public interface IVideoCommentListView extends ILoadingView{

        void addVideoCommentList(List<VideoCommentListBean.DataBean.CommentsBean> comments);

        void addVideoCommentCount(int total);

        void addMoreVideoComment(List<VideoCommentListBean.DataBean.CommentsBean> comments);

        void loadMoreError(String message);
    }

    public interface IVideoCommentListPresenter{
        void getVideoCommentList(int movieId,int offset);

        void getMoreVideoComment(int movieId, int offset);
    }
}

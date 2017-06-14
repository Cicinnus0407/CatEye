package com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment.movie_short_comment_detail;

import com.cicinnus.retrofitlib.base.ICoreLoadingView;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class MovieShortCommentDetailContract {
    public interface IMovieShortCommentDetailView extends ICoreLoadingView{
        void addShortCommentDetail(MovieShortCommentDetailBean movieShortCommentDetailBean);
    }

    public interface IMovieShortCommentDetailPresenter{
        void getShortCommentList(int id,int limit,int offset);
    }
}

package com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment;

import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieShortCommentBean;
import com.cicinnus.retrofitlib.base.ICoreLoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/6/12.
 */

public class MovieShortCommentContract {
    public interface IMovieShortCommentView extends ICoreLoadingView {
        void addMovieShortComment(MovieShortCommentBean o);

        void addMovieShortCommentTag(List<MovieCommentTagBean.DataBean> data);

        void addMoreShortComment(MovieShortCommentBean.DataBean data);

        void loadMoreShotCommentFail(String s);
    }

    public interface IMovieShortCommentPresenter {
        void getCommentShortComment(int movieId, int tag,int limit, int offset);

        void getMoreShortComment(int movieId,int tag, int limit, int offset);
    }
}

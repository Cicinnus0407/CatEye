package com.cicinnus.cateye.module.movie.movie_detail.movie_long_comment;

import com.cicinnus.retrofitlib.base.ICoreLoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/3/13.
 */

public class MovieLongCommentContract {
    public interface IMovieLongCommentView extends ICoreLoadingView {

        void addMovieLongComment(List<MovieLongCommentBeanList.DataBean.FilmReviewsBean> filmReviews);

        void loadMoreError(String message);
    }
    public interface IMovieLongCommentPresenter{
        void getMovieLongComment(int movieId,int offset);
        void getMoreMovieLongComment(int movieId,int offset);
    }
}

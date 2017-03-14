package com.cicinnus.cateye.module.movie.movie_detail.movie_long_comment;

import com.cicinnus.cateye.base.ILoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/3/13.
 */

public class MovieLongCommentContract {
    public interface IMovieLongCommentView extends ILoadingView{

        void addMovieLongComment(List<MovieLongCommentBeanList.DataBean.FilmReviewsBean> filmReviews);

        void loadMoreError(String message);
    }
    public interface IMovieLongCommentPresenter{
        void getMovieLongComment(int movieId,int offset);
        void getMoreMovieLongComment(int movieId,int offset);
    }
}

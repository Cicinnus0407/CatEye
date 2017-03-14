package com.cicinnus.cateye.module.movie.movie_detail.movie_pro_comment;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieProCommentBean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/3/13.
 */

public class MovieProCommentContract {
    public interface IMovieProCommentView extends ILoadingView{
        void addMovieProComment(List<MovieProCommentBean.DataBean> movieProCommentBeanData);

        void loadMoreFail(String message);
    }

    public interface IMovieProCommentPresenter{
        void getMovieProComment(int movieId, int offset);

        void getMoreMovieProComment(int movieId, int offset);
    }
}

package com.cicinnus.cateye.module.movie.movie_detail.movie_topic;

import com.cicinnus.cateye.base.ILoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/28.
 */

public class MovieTopicContract {
    public interface IMovieTopicView extends ILoadingView{

        void addMovieTopic(List<MovieTopicListBean.DataBean> data);

        void loadMoreTopicError(String message);

        void addMoreMovieTopic(List<MovieTopicListBean.DataBean> data);
    }
    public interface IMovieTopicPresenter{
        void getMovieTopic(int movieId,int offset);

        void getMoreTopic(int movieId, int offset);
    }
}

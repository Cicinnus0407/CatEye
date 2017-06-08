package com.cicinnus.cateye.module.movie.movie_detail.movie_information;

import com.cicinnus.retrofitlib.base.ICoreLoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/27.
 */

public class MovieInformationContract {
    public interface IMovieInformationView extends ICoreLoadingView {

        void addMovieInformation(List<MovieInformationBean.DataBean.NewsListBean> movieInformationBean);

        void loadMoreError(String message);

        void addMoreMovieInformation(List<MovieInformationBean.DataBean.NewsListBean> newsList);
    }
    public interface IMovieInformationPresenter{
        void getMovieInformation(int movieId, int offset);

        void getMoreMovieInformation(int mMovieId, int offset);
    }
}

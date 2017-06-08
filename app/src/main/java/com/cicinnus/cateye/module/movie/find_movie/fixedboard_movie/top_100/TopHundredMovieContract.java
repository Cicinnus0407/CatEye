package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.top_100;

import com.cicinnus.retrofitlib.base.ICoreLoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class TopHundredMovieContract {

    public interface ITopHundredMovieView extends ICoreLoadingView {
        void addTopHundredMovie(List<TopHundredMovieBean.DataBean.MoviesBean> movies);

        void addContent(String created, String content);
    }
    public interface ITopHUndredMoviePresenter{
        void getTopHundredMovie(int offset);
    }
}

package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.recent_expect;

import com.cicinnus.cateye.base.ILoadingView;

/**
 * Created by Administrator on 2017/2/4.
 */

public class RecentExpectMovieContract {
    public interface IRecentExpectMovieView extends ILoadingView {
        void addRecentExpectMovie(RecentExpectMovieBean.DataBean movies);

        void addData(String content, String date);
    }

    public interface IRecentExpectMoviePresenter{

        void getRecentExpectMovie(int offset);
    }
}

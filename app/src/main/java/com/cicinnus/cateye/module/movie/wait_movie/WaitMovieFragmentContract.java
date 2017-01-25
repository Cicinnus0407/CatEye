package com.cicinnus.cateye.module.movie.wait_movie;

import com.cicinnus.cateye.base.ILoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/1/25.
 */

public class WaitMovieFragmentContract {
    public interface IWaitMovieView extends ILoadingView{
        void addWaitMovieList(List<TrailerRecommendBean.DataBean> data);
    }

    public interface IWaitMoviePresenter{
        void getTrailerRecommendMovie();
    }
}

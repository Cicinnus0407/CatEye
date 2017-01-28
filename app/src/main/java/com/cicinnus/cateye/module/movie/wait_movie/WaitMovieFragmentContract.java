package com.cicinnus.cateye.module.movie.wait_movie;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.wait_movie.bean.RecentExpectBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/1/25.
 */

public class WaitMovieFragmentContract {
    public interface IWaitMovieView extends ILoadingView {
        void addTrailerRecommendMovieList(List<TrailerRecommendBean.DataBean> data);

        void addRecentExpectMovieList(List<RecentExpectBean.DataBean.ComingBean> coming);

        void addWaitMovieList(List<WaitMovieBean.DataBean.ComingBean> coming);

    }

    public interface IWaitMoviePresenter {
        void getTrailerRecommendMovie();

        void getRecentExpect(int offset, int limit);

        void getWaitMovieList(int ci, int limit);
    }
}

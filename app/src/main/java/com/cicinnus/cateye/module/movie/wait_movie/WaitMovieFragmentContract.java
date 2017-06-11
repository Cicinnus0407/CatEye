package com.cicinnus.cateye.module.movie.wait_movie;

import com.cicinnus.cateye.module.movie.wait_movie.bean.ExpectMovieBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.TrailerRecommendBean;
import com.cicinnus.cateye.module.movie.wait_movie.bean.WaitMovieBean;
import com.cicinnus.retrofitlib.base.ICoreLoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/1/25.
 */

public class WaitMovieFragmentContract {
    public interface IWaitMovieView extends ICoreLoadingView {
        void addTrailerRecommendMovieList(List<TrailerRecommendBean.DataBean> data);

        void addRecentExpectMovieList(List<ExpectMovieBean.DataBean.ComingBean> coming);

        void addWaitMovieList(List<WaitMovieBean.DataBean.ComingBean> coming);

        void addIds(List<Integer> movieIds);

        void addMoreWaitMovie(List<WaitMovieBean.DataBean.ComingBean> coming);

        void loadMoreFail();

        void loadMoreComplete();
    }

    public interface IWaitMoviePresenter {
        void getTrailerRecommendMovie();

        void getRecentExpect(int offset, int limit);

        void getWaitMovieList(int limit,int offset,int limit2);

        void getMoreWaitMovie(String s);
    }
}

package com.cicinnus.cateye.module.movie.find_movie.awards_movie;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsBean;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsMovieListBean;

/**
 * Created by Administrator on 2017/2/6.
 */

public class AwardsMovieContract {
    public interface IAwardsMovieView extends ILoadingView {
        void addAwardsMovie(AwardsMovieListBean.DataBean data);

        void addMoreAwardsMovie(AwardsMovieListBean.DataBean data);

        void addAwardTitle(AwardsBean.DataBean data);
    }

    public interface IAwardsMoviePresenter {

        void getAwards(int festivalId);

        void getAwardsMovie(int festSessionId, int limit, int offset);

        void getMoreAwardsMovie(int festSessionId, int limit, int offset);
    }
}

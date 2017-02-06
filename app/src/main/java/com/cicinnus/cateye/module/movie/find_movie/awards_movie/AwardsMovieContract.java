package com.cicinnus.cateye.module.movie.find_movie.awards_movie;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsMovieListBean;
import com.cicinnus.cateye.module.movie.find_movie.bean.AwardsMovieBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */

public class AwardsMovieContract {
    public interface IAwardsMovieView extends ILoadingView{
        void addIAwardsMovie(AwardsMovieListBean.DataBean data);
    }

    public interface IAwardsMoviePresenter{

        void getAwards(String festivalId);

        void getAwardsMovie(String festSessionId,int offset);
    }
}

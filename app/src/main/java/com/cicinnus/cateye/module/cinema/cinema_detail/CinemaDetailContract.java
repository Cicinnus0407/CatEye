package com.cicinnus.cateye.module.cinema.cinema_detail;

import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.CinemaMovieBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.bean.FoodsBean;
import com.cicinnus.retrofitlib.base.ICoreLoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/6/21.
 */

public class CinemaDetailContract {

    public interface ICinemaDetailView extends ICoreLoadingView{
        void addCinemaMovies(List<CinemaMovieBean.DataBean.MoviesBean> movies);

        void addCinemaData(CinemaBean.DataBean data);

        void addFoods(List<FoodsBean.DataBean.DealListBean> dealList);
    }

    public interface ICinemaDetailPresenter{

        void getCinema(int cinemaId);

    }
}

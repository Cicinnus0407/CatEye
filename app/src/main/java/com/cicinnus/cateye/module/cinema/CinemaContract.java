package com.cicinnus.cateye.module.cinema;

import com.cicinnus.cateye.module.cinema.bean.CinemaListBean;
import com.cicinnus.retrofitlib.base.ICoreLoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class CinemaContract {
    public interface ICinemaView extends ICoreLoadingView{
        void addCinema(List<CinemaListBean.DataBean.CinemasBean> cinemas);

        void addMoreCinema(List<CinemaListBean.DataBean.CinemasBean> cinemas);

        void addMoreCinemaFail(String errMsg);
    }

    public interface ICinemaPresenter{


        void getCinema(int cityId, int offset, int limit, double lat, double lng);

        void getMoreCinema(int cityId, int offset, int limit, double lat, double lng);
    }
}

package com.cicinnus.cateye.module.cinema;

import com.cicinnus.cateye.module.cinema.bean.CinemaListBean;
import com.cicinnus.retrofitlib.base.ICoreLoadingView;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class CinemaContract {
    public interface ICinemaView extends ICoreLoadingView{
        void addCinema(List<CinemaListBean.DataBean.CinemasBean> cinemas);
    }

    public interface ICinemaPresenter{
        void getCinema(int cityId, int offset, int limit, double lat, double lng);
    }
}

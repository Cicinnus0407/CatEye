package com.cicinnus.cateye.module.movie.pick_city;

import com.cicinnus.retrofitlib.base.ICoreLoadingView;

import java.util.List;

/**
 * Created by Cicinnus on 2017/6/8.
 */

public class PickCityContract {
    public interface IPickCityView extends ICoreLoadingView{
        void addCity(List<PickCityBean.CtsBean> cts);
    }

    public interface IPickCityPresenter{
        void getCity();
    }
}

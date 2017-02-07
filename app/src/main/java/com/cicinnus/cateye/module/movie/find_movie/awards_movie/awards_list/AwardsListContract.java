package com.cicinnus.cateye.module.movie.find_movie.awards_movie.awards_list;

import com.cicinnus.cateye.base.ILoadingView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */

public class AwardsListContract {

    public interface IAwardsListView extends ILoadingView{
        void addAwardsList(List<AwardsListBean.DataBean> data);
    }

    public interface IAwardsListPresenter {
        void getAwardsList();
    }
}

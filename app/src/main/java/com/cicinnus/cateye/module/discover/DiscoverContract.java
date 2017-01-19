package com.cicinnus.cateye.module.discover;

import com.cicinnus.cateye.base.ILoadingView;

import java.util.List;

/**
 * Created by Administrator on 2017/1/18.
 */

public class DiscoverContract {
    interface IDiscoverView extends ILoadingView {
        void addDiscoverData(List<DiscoverBean.DataBean.FeedsBean> feeds);

        void addDiscoverHeaderData(List<DiscoverHeaderBean.DataBean> data);
    }

    interface IDiscoverPresenter {
        void getDiscoverData(int offset, int limit);

        void getDiscoverHeader(String utm_term);

    }
}

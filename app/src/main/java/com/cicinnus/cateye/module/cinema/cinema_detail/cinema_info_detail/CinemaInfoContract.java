package com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail;

import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean.CinemaCommentBean;
import com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean.CinemaInfoBean;
import com.cicinnus.retrofitlib.base.ICoreLoadingView;

/**
 * Created by Cicinnus on 2017/6/26.
 */

public class CinemaInfoContract {
    public interface ICinemaInfoView extends ICoreLoadingView {
        void addCinemaInfo(CinemaInfoBean.DataBean data);

        void addCinemaComment(CinemaCommentBean commentBean);

        void addMoreCinemaComment(CinemaCommentBean commentBean);

        void addMoreCinemaCommentFail(String s);
    }

    public interface ICinemaInfoPresenter {
        void getCinemaInfo(int cinemaId);

        void getCinemaComment(int cinemaId, int offset);

        void getMoreCinemaComment(int cinemaId, int offset);

    }
}

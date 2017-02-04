package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.hot_good_comment;

import com.cicinnus.cateye.base.ILoadingView;

/**
 * Created by Cicinnus on 2017/2/3.
 */

public class HotGoodCommentContract {
    public interface IHotGoodCommentView extends ILoadingView{
        void addHotGoodCommentList(HotGoodCommentBean data);

        void addTitle(String title);

        void addListHeader(String created, String content);
    }
    public interface IHotGoodCommentPresenter{
        void getHotGoodCommentList(int offset);
    }
}

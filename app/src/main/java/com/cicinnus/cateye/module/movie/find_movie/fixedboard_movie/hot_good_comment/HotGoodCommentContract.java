package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.hot_good_comment;

import com.cicinnus.retrofitlib.base.ICoreLoadingView;

/**
 * Created by Cicinnus on 2017/2/3.
 */

public class HotGoodCommentContract {
    public interface IHotGoodCommentView extends ICoreLoadingView {
        void addHotGoodCommentList(HotGoodCommentBean data);

        void addTitle(String title);

        void addListHeader(String created, String content);
    }
    public interface IHotGoodCommentPresenter{
        void getHotGoodCommentList(int offset);
    }
}

package com.cicinnus.cateye.module.movie.movie_detail;

import com.cicinnus.cateye.base.ILoadingView;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieAwardsBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieBasicDataBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieLongCommentBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieMoneyBoxBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieResourceBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieStarBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/10.
 */

public class MovieDetailContract {
    public interface IMovieDetailView extends ILoadingView{
        void addMovieBasicData(MovieBasicDataBean.DataBean.MovieBean movie);

        void addMovieStarList(MovieStarBean movieStarBean);

        void addMovieMoneyBox(MovieMoneyBoxBean moneyBoxBean);

        void addMovieAwards(List<MovieAwardsBean.DataBean> movieAwards);

        void addMovieResource(List<MovieResourceBean.DataBean> movieResources);

        void addMovieCommentTag(List<MovieCommentTagBean.DataBean> commentTags);

        void addMovieLongComment(MovieLongCommentBean.DataBean movieLongComments);
    }

    public interface IMoviePresenter{
        void getMovieData(int movieId);
    }
}

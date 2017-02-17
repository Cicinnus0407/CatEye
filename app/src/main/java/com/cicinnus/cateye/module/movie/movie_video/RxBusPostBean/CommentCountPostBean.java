package com.cicinnus.cateye.module.movie.movie_video.RxBusPostBean;

/**
 * Created by Administrator on 2017/2/17.
 */

public class CommentCountPostBean {
    private int commentCount;

    public CommentCountPostBean(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}

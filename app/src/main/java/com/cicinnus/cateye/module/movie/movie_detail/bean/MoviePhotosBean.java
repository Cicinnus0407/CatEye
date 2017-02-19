package com.cicinnus.cateye.module.movie.movie_detail.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.cicinnus.cateye.base.BaseConstant;

/**
 * Created by Cicinnus on 2017/2/11.
 */

public class MoviePhotosBean implements MultiItemEntity {
    private int movieId;
    private String url;
    private int videoNum;
    private String movieTitle;
    private boolean isVideo;
    private String videoImg;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    @Override
    public int getItemType() {
        if(isVideo()){
            return BaseConstant.TYPE_MOVIE_DETAIL_VEDIO;
        }else {
            return BaseConstant.TYPE_MOVIE_DETAIL_PHOTO;
        }
    }

    public int getVideoNum() {
        return videoNum;
    }

    public void setVideoNum(int videoNum) {
        this.videoNum = videoNum;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
}

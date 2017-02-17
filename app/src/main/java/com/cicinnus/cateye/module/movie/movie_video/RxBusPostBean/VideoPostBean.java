package com.cicinnus.cateye.module.movie.movie_video.RxBusPostBean;

/**
 * Created by Administrator on 2017/2/17.
 */

public class VideoPostBean {
    private String videoName;
    private String videoUrl;

    public VideoPostBean(String videoName, String videoUrl) {
        this.videoName = videoName;
        this.videoUrl = videoUrl;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}

package com.cicinnus.cateye.module.movie.wait_movie;

import java.util.List;

/**
 * Created by Cicinnus on 2017/1/25.
 */

public class TrailerRecommendBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * img : http://p0.meituan.net/movie/790859165b19bdb28748c01d5e54bc9d24553.jpg
         * movieId : 1170255
         * movieName : 乘风破浪
         * name : 《乘风破浪》终极预告
         * originName : 终极预告片
         * url : http://maoyan.meituan.net/movie/videos/854x480364e9171dfbe44dfbf31e0e653349305.mp4
         * videoId : 82993
         * wish : 44618
         */

        private String img;
        private int movieId;
        private String movieName;
        private String name;
        private String originName;
        private String url;
        private int videoId;
        private int wish;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOriginName() {
            return originName;
        }

        public void setOriginName(String originName) {
            this.originName = originName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        public int getWish() {
            return wish;
        }

        public void setWish(int wish) {
            this.wish = wish;
        }
    }
}

package com.cicinnus.cateye.module.movie.find_movie.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/2.
 */

public class AwardsMovieBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * festSessionId : 4071
         * festivalId : 105
         * festivalName : 日本电影学院奖
         * heldDate : 2017-03-02
         * img : http://p1.meituan.net/w.h/movie/8bca340d154d6b318f9e81b618bc3203167158.jpg
         * movieId : 342249
         * movieName : 怒
         * prizeName : 最佳影片(提名)
         * sessionNum : 40
         */

        private int festSessionId;
        private int festivalId;
        private String festivalName;
        private String heldDate;
        private String img;
        private int movieId;
        private String movieName;
        private String prizeName;
        private int sessionNum;

        public int getFestSessionId() {
            return festSessionId;
        }

        public void setFestSessionId(int festSessionId) {
            this.festSessionId = festSessionId;
        }

        public int getFestivalId() {
            return festivalId;
        }

        public void setFestivalId(int festivalId) {
            this.festivalId = festivalId;
        }

        public String getFestivalName() {
            return festivalName;
        }

        public void setFestivalName(String festivalName) {
            this.festivalName = festivalName;
        }

        public String getHeldDate() {
            return heldDate;
        }

        public void setHeldDate(String heldDate) {
            this.heldDate = heldDate;
        }

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

        public String getPrizeName() {
            return prizeName;
        }

        public void setPrizeName(String prizeName) {
            this.prizeName = prizeName;
        }

        public int getSessionNum() {
            return sessionNum;
        }

        public void setSessionNum(int sessionNum) {
            this.sessionNum = sessionNum;
        }
    }
}

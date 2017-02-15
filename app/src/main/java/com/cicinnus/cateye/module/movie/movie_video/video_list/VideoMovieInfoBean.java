package com.cicinnus.cateye.module.movie.movie_video.video_list;

/**
 * Created by Administrator on 2017/2/15.
 */

public class VideoMovieInfoBean {

    /**
     * data : {"globalReleased":true,"image":"http://p1.meituan.net/w.h/movie/43aeb3fe86ed6fb9f9cc86ed0b177e26109383.jpeg","name":"极限特工：终极回归","pubdesc":"2017-02-10大陆上映","score":8.8,"showSt":3,"ver":"3D/IMAX 3D/中国巨幕/全景声","wish":131897,"wishst":0}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * globalReleased : true
         * image : http://p1.meituan.net/w.h/movie/43aeb3fe86ed6fb9f9cc86ed0b177e26109383.jpeg
         * name : 极限特工：终极回归
         * pubdesc : 2017-02-10大陆上映
         * score : 8.8
         * showSt : 3
         * ver : 3D/IMAX 3D/中国巨幕/全景声
         * wish : 131897
         * wishst : 0
         */

        private boolean globalReleased;
        private String image;
        private String name;
        private String pubdesc;
        private double score;
        private int showSt;
        private String ver;
        private int wish;
        private int wishst;

        public boolean isGlobalReleased() {
            return globalReleased;
        }

        public void setGlobalReleased(boolean globalReleased) {
            this.globalReleased = globalReleased;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPubdesc() {
            return pubdesc;
        }

        public void setPubdesc(String pubdesc) {
            this.pubdesc = pubdesc;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public int getShowSt() {
            return showSt;
        }

        public void setShowSt(int showSt) {
            this.showSt = showSt;
        }

        public String getVer() {
            return ver;
        }

        public void setVer(String ver) {
            this.ver = ver;
        }

        public int getWish() {
            return wish;
        }

        public void setWish(int wish) {
            this.wish = wish;
        }

        public int getWishst() {
            return wishst;
        }

        public void setWishst(int wishst) {
            this.wishst = wishst;
        }
    }
}

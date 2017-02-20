package com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieAlbumBean {

    /**
     * data : {"albumName":"极限特工：终极回归 电影原声","img":"http://p0.meituan.net/movie/ee66c0a168622d8d0affc3e58575953930257.jpeg","movieId":334590,"singer":"群星"}
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
         * albumName : 极限特工：终极回归 电影原声
         * img : http://p0.meituan.net/movie/ee66c0a168622d8d0affc3e58575953930257.jpeg
         * movieId : 334590
         * singer : 群星
         */

        private String albumName;
        private String img;
        private int movieId;
        private String singer;

        public String getAlbumName() {
            return albumName;
        }

        public void setAlbumName(String albumName) {
            this.albumName = albumName;
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

        public String getSinger() {
            return singer;
        }

        public void setSinger(String singer) {
            this.singer = singer;
        }
    }
}

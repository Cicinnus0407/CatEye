package com.cicinnus.cateye.module.movie.find_movie.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/2.
 */

public class GridMovieBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * boardId : 7
         * boardName : 热映口碑
         * movieId : 1198738
         * movieImgs : ["http://p0.meituan.net/w.h/movie/49f7e42bed14bc2ebe791146d2444ced438579.jpeg","http://p0.meituan.net/w.h/movie/018ceaadb90ac5c1b9ba33546d1fb746401981.jpg"]
         * movieName : 一路逆风
         * url : meituanmovie://www.meituan.com/movieBoard/detail?id=7&boardType=7&title=热映口碑榜单
         */

        private int boardId;
        private String boardName;
        private int movieId;
        private String movieName;
        private String url;
        private List<String> movieImgs;

        public int getBoardId() {
            return boardId;
        }

        public void setBoardId(int boardId) {
            this.boardId = boardId;
        }

        public String getBoardName() {
            return boardName;
        }

        public void setBoardName(String boardName) {
            this.boardName = boardName;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getMovieImgs() {
            return movieImgs;
        }

        public void setMovieImgs(List<String> movieImgs) {
            this.movieImgs = movieImgs;
        }
    }
}

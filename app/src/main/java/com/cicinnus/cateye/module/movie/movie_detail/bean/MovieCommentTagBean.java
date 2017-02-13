package com.cicinnus.cateye.module.movie.movie_detail.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */

public class MovieCommentTagBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        public DataBean() {
        }

        public DataBean(int count, int movieId, int tag, String tagName) {
            this.count = count;
            this.movieId = movieId;
            this.tag = tag;
            this.tagName = tagName;
        }

        /**
         * count : 17659
         * movieId : 334590
         * tag : 1
         * tagName : 好评
         */


        private int count;
        private int movieId;
        private int tag;
        private String tagName;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public int getTag() {
            return tag;
        }

        public void setTag(int tag) {
            this.tag = tag;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }
    }
}

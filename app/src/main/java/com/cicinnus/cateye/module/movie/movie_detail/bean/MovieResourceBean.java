package com.cicinnus.cateye.module.movie.movie_detail.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */

public class MovieResourceBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * content : 甄子丹扮演“Xiang”，此前这个角色原本是为李连杰设计的，甄子丹取代了后者出演这个反派角色。
         * img : http://p0.meituan.net/mmdb/620a7e33958c1a0dcdf5f068d2d278fc1286.png
         * name : highlights
         * title : 幕后花絮
         */

        private String content;
        private String img;
        private String name;
        private String title;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}

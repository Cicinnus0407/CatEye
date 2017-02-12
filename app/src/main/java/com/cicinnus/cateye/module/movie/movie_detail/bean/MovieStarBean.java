package com.cicinnus.cateye.module.movie.movie_detail.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/11.
 */

public class MovieStarBean {

    private List<List<DataBean>> data;

    public List<List<DataBean>> getData() {
        return data;
    }

    public void setData(List<List<DataBean>> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * avatar : http://p1.meituan.net/w.h/movie/3597deb6006cf5c0c5ce74838fd4794327931.jpg
         * cnm : 叶伟民
         * cr : 2
         * enm : Wai Man Yip
         * id : 30249
         * roles : 导演
         * still :
         */

        private String avatar;
        private String cnm;
        private int cr;
        private String enm;
        private int id;
        private String roles;
        private String still;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getCnm() {
            return cnm;
        }

        public void setCnm(String cnm) {
            this.cnm = cnm;
        }

        public int getCr() {
            return cr;
        }

        public void setCr(int cr) {
            this.cr = cr;
        }

        public String getEnm() {
            return enm;
        }

        public void setEnm(String enm) {
            this.enm = enm;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRoles() {
            return roles;
        }

        public void setRoles(String roles) {
            this.roles = roles;
        }

        public String getStill() {
            return still;
        }

        public void setStill(String still) {
            this.still = still;
        }
    }
}

package com.cicinnus.cateye.module.movie.movie_star.bean;

/**
 * Created by Cicinnus on 2017/2/18.
 */

public class MovieStarHonor {

    /**
     * data : {"award":"曾获香港金像奖最佳动作设计","awardCount":"8","awardDesc":"共8次获奖，13次提名","awardUrl":"http://m.maoyan.com/celebrity/28936/honor?_v_=yes&utm_campaign=AmovieBmovieD100","festivalName":"香港金像奖","nomCount":"13","prizeDesc":"最佳动作设计"}
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
         * award : 曾获香港金像奖最佳动作设计
         * awardCount : 8
         * awardDesc : 共8次获奖，13次提名
         * awardUrl : http://m.maoyan.com/celebrity/28936/honor?_v_=yes&utm_campaign=AmovieBmovieD100
         * festivalName : 香港金像奖
         * nomCount : 13
         * prizeDesc : 最佳动作设计
         */

        private String award;
        private String awardCount;
        private String awardDesc;
        private String awardUrl;
        private String festivalName;
        private String nomCount;
        private String prizeDesc;

        public String getAward() {
            return award;
        }

        public void setAward(String award) {
            this.award = award;
        }

        public String getAwardCount() {
            return awardCount;
        }

        public void setAwardCount(String awardCount) {
            this.awardCount = awardCount;
        }

        public String getAwardDesc() {
            return awardDesc;
        }

        public void setAwardDesc(String awardDesc) {
            this.awardDesc = awardDesc;
        }

        public String getAwardUrl() {
            return awardUrl;
        }

        public void setAwardUrl(String awardUrl) {
            this.awardUrl = awardUrl;
        }

        public String getFestivalName() {
            return festivalName;
        }

        public void setFestivalName(String festivalName) {
            this.festivalName = festivalName;
        }

        public String getNomCount() {
            return nomCount;
        }

        public void setNomCount(String nomCount) {
            this.nomCount = nomCount;
        }

        public String getPrizeDesc() {
            return prizeDesc;
        }

        public void setPrizeDesc(String prizeDesc) {
            this.prizeDesc = prizeDesc;
        }
    }
}

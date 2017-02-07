package com.cicinnus.cateye.module.movie.find_movie.awards_movie.awards_list;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */

public class AwardsListBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * festivals : [{"festivalId":117,"festivalName":"奥斯卡金像奖"},{"festivalId":116,"festivalName":"戛纳电影节"},{"festivalId":115,"festivalName":"威尼斯电影节"},{"festivalId":114,"festivalName":"柏林国际电影节"},{"festivalId":113,"festivalName":"金球奖"},{"festivalId":112,"festivalName":"香港金像奖"},{"festivalId":111,"festivalName":"台湾金马奖"},{"festivalId":110,"festivalName":"东京国际电影节"},{"festivalId":83,"festivalName":"中国电影金鸡奖"},{"festivalId":109,"festivalName":"釜山国际电影节"}]
         * region : 热门
         */

        private String region;
        private List<FestivalsBean> festivals;

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public List<FestivalsBean> getFestivals() {
            return festivals;
        }

        public void setFestivals(List<FestivalsBean> festivals) {
            this.festivals = festivals;
        }

        public static class FestivalsBean {
            /**
             * festivalId : 117
             * festivalName : 奥斯卡金像奖
             */

            private int festivalId;
            private String festivalName;

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
        }
    }
}

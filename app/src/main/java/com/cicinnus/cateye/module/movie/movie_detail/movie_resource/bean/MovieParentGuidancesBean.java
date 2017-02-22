package com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/22.
 */

public class MovieParentGuidancesBean {

    /**
     * data : {"gov":[{"desc":"本片在美国的评级为【R】，未满18岁的观众需在家长的陪同下观看。","id":0,"type":"textTag"},{"desc":"本片在英国的评级为【15】，未满15岁的儿童不宜观看。","id":0,"type":"textTag"},{"desc":"本片在日本的评级为【PG-12】，未满12岁的儿童须在家长的陪同下观看。","id":0,"type":"textTag"},{"desc":"本片在韩国的评级为【18+】（2017），未满18岁不得观看。","id":0,"type":"textTag"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<GovBean> gov;

        public List<GovBean> getGov() {
            return gov;
        }

        public void setGov(List<GovBean> gov) {
            this.gov = gov;
        }

        public static class GovBean {
            /**
             * desc : 本片在美国的评级为【R】，未满18岁的观众需在家长的陪同下观看。
             * id : 0
             * type : textTag
             */

            private String desc;
            private int id;
            private String type;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}

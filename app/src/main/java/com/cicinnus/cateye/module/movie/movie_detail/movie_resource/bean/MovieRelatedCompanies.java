package com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/22.
 */

public class MovieRelatedCompanies {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cmpTypeId : 1
         * cmpTypeName : 制作
         * items : [{"desc":"美国PK电影公司","id":31606},{"desc":"美国天下大同电影公司","id":31607}]
         */

        private int cmpTypeId;
        private String cmpTypeName;
        private List<ItemsBean> items;

        public int getCmpTypeId() {
            return cmpTypeId;
        }

        public void setCmpTypeId(int cmpTypeId) {
            this.cmpTypeId = cmpTypeId;
        }

        public String getCmpTypeName() {
            return cmpTypeName;
        }

        public void setCmpTypeName(String cmpTypeName) {
            this.cmpTypeName = cmpTypeName;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * desc : 美国PK电影公司
             * id : 31606
             */

            private String desc;
            private int id;

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
        }
    }
}

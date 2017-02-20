package com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieTechnicalsBean {

    /**
     * data : {"items":[{"desc":"1小时47分钟","title":"时长"},{"desc":"彩色","title":"颜色"},{"desc":"DCP","title":"洗印格式"}],"title":"技术参数"}
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
         * items : [{"desc":"1小时47分钟","title":"时长"},{"desc":"彩色","title":"颜色"},{"desc":"DCP","title":"洗印格式"}]
         * title : 技术参数
         */

        private String title;
        private List<ItemsBean> items;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * desc : 1小时47分钟
             * title : 时长
             */

            private String desc;
            private String title;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}

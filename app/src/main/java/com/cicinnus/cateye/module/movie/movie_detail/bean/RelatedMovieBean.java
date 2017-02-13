package com.cicinnus.cateye.module.movie.movie_detail.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/13.
 */

public class RelatedMovieBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * items : [{"desc":"223940","img":"http://p1.meituan.net/w.h/movie/__42979638__9595964.jpg","onlinePlay":false,"sc":6.7,"title":"极限特工2","type":"imageTag"},{"desc":"11978","img":"http://p0.meituan.net/w.h/movie/96/4282355.jpg","onlinePlay":false,"sc":7.1,"title":"极限特工","type":"imageTag"},{"desc":"247185","img":"http://p0.meituan.net/w.h/movie/ef1bc6e7987fcb64558d11cadb86b3be687974.jpg","onlinePlay":false,"sc":8,"title":"星球大战外传：侠盗一号","type":"imageTag"},{"desc":"248933","img":"http://p1.meituan.net/w.h/movie/d273af80e581b4c60abcbb57a95ad2b72956123.jpg","onlinePlay":false,"sc":8.5,"title":"功夫瑜伽","type":"imageTag"},{"desc":"13511","img":"http://p1.meituan.net/w.h/movie/a375ebfcdc2a396423c368b943813b01179997.jpg","onlinePlay":false,"sc":8.6,"title":"忍者神龟2：破影而出","type":"imageTag"},{"desc":"78617","img":"http://p0.meituan.net/w.h/movie/f4aad31c17436f73ef2a369c2e2188b1110089.jpg","onlinePlay":false,"sc":8,"title":"007：幽灵党","type":"imageTag"},{"desc":"341240","img":"http://p0.meituan.net/w.h/movie/ea793782588faee517495b2cbd8ad3b9312655.jpg","onlinePlay":false,"sc":8.5,"title":"泰山归来：险战丛林","type":"imageTag"},{"desc":"249875","img":"http://p1.meituan.net/w.h/movie/0b3708b5f6c82f2c30fd341723f176ed1413054.jpeg","onlinePlay":false,"sc":8.3,"title":"谍影重重5","type":"imageTag"},{"desc":"246461","img":"http://p0.meituan.net/w.h/movie/7a1ab391b0d4261f38947f902c921bc4909744.jpg","onlinePlay":false,"sc":8.6,"title":"星际迷航3：超越星辰","type":"imageTag"},{"desc":"248896","img":"http://p1.meituan.net/w.h/movie/4f06d5b4989902305bae7992ba2297e9162007.jpg","onlinePlay":false,"sc":8.5,"title":"伦敦陷落","type":"imageTag"},{"desc":"247401","img":"http://p0.meituan.net/w.h/movie/55e95f9cb4b8e21f0b69491155a98fba360529.jpg","onlinePlay":false,"sc":8.3,"title":"最后的巫师猎人","type":"imageTag"},{"desc":"345257","img":"http://p1.meituan.net/w.h/movie/bfffe8731390d5b78e2af5d016846381175313.jpg","onlinePlay":false,"sc":7.6,"title":"王牌逗王牌","type":"imageTag"},{"desc":"246333","img":"http://p1.meituan.net/w.h/movie/2e0b5b5c6c086cc93068fbc212f9f6b0142193.jpg","onlinePlay":false,"sc":8.5,"title":"惊天魔盗团2","type":"imageTag"},{"desc":"338412","img":"http://p1.meituan.net/w.h/movie/352a6bbf59de330c62b40a090fd3b6c4503610.jpg","onlinePlay":false,"sc":8.5,"title":"神战：权力之眼","type":"imageTag"},{"desc":"246124","img":"http://p1.meituan.net/w.h/movie/aa492b57443fc95a5b3b46c459d59e50898549.jpg","onlinePlay":false,"sc":8.9,"title":"奇异博士","type":"imageTag"},{"desc":"75090","img":"http://p0.meituan.net/w.h/movie/0e50c05b694a6d87d04608f1093a747a120784.jpg","onlinePlay":false,"sc":9,"title":"碟中谍5：神秘国度","type":"imageTag"},{"desc":"246375","img":"http://p1.meituan.net/w.h/movie/b408a9322cd0da51d4bdd3261ba3d1c0278866.jpg","onlinePlay":false,"sc":8.4,"title":"独立日：卷土重来","type":"imageTag"},{"desc":"248935","img":"http://p1.meituan.net/w.h/movie/015de6bbaa2ecc299254b24e4f96939d489607.jpg","onlinePlay":false,"sc":7.5,"title":"大闹天竺","type":"imageTag"},{"desc":"78392","img":"http://p1.meituan.net/w.h/movie/1e4d3a71c2ef248b956d00f6c26751c4116127.jpg","onlinePlay":false,"sc":8.9,"title":"蚁人","type":"imageTag"},{"desc":"246234","img":"http://p1.meituan.net/w.h/movie/73f8a5ba9c96f136454d737530cac56b448798.jpg","onlinePlay":false,"sc":8.6,"title":"美国队长3","type":"imageTag"}]
         * title :
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
             * desc : 223940
             * img : http://p1.meituan.net/w.h/movie/__42979638__9595964.jpg
             * onlinePlay : false
             * sc : 6.7
             * title : 极限特工2
             * type : imageTag
             */

            private String desc;
            private String img;
            private boolean onlinePlay;
            private double sc;
            private String title;
            private String type;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public boolean isOnlinePlay() {
                return onlinePlay;
            }

            public void setOnlinePlay(boolean onlinePlay) {
                this.onlinePlay = onlinePlay;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

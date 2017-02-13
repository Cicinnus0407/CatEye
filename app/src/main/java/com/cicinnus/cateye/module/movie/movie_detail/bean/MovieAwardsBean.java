package com.cicinnus.cateye.module.movie.movie_detail.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */

public class MovieAwardsBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * awardCount : 0
         * awardUrl : http://m.maoyan.com/movie/338436/honor?_v_=yes&utm_campaign=AmovieBmovieD100
         * festSessionId : 3957
         * festivalId : 117
         * icon : http://p1.meituan.net/movie/ae0de4faa2366f9c23405c361387fe6f4358.jpg
         * items : [{"desc":"爱乐之城","img":"http://p0.meituan.net/w.h/movie/f4990a965755af1be2a16c421951c48219905345.jpg","onlinePlay":false,"sc":0,"title":"最佳影片(提名)","type":"imageTag"},{"celebrityId":29845,"desc":"瑞恩·高斯林","img":"http://p0.meituan.net/w.h/movie/7bda07a4d7dd30ba26e2386f6f8332ca51972.jpg","title":"最佳男主角(提名)","type":"celebrityTag"},{"celebrityId":28484,"desc":"艾玛·斯通","img":"http://p0.meituan.net/w.h/movie/b506190f1a5a329d2de1befd99c8836d52662.jpg","title":"最佳女主角(提名)","type":"celebrityTag"},{"celebrityId":369780,"desc":"达米恩·查泽雷","img":"http://p0.meituan.net/w.h/movie/93c8e9c7a0e471a267658dcf6bd7057e20133.jpg","title":"最佳导演(提名)","type":"celebrityTag"},{"desc":"爱乐之城","img":"http://p0.meituan.net/w.h/movie/f4990a965755af1be2a16c421951c48219905345.jpg","onlinePlay":false,"sc":0,"subDesc":"达米恩·查泽雷","title":"最佳原创剧本(提名)","type":"imageTag"},{"desc":"爱乐之城","img":"http://p0.meituan.net/w.h/movie/f4990a965755af1be2a16c421951c48219905345.jpg","onlinePlay":false,"sc":0,"title":"最佳摄影(提名)","type":"imageTag"},{"desc":"爱乐之城","img":"http://p0.meituan.net/w.h/movie/f4990a965755af1be2a16c421951c48219905345.jpg","onlinePlay":false,"sc":0,"title":"最佳音效(提名)","type":"imageTag"},{"desc":"爱乐之城","img":"http://p0.meituan.net/w.h/movie/f4990a965755af1be2a16c421951c48219905345.jpg","onlinePlay":false,"sc":0,"title":"最佳剪辑(提名)","type":"imageTag"},{"desc":"爱乐之城","img":"http://p0.meituan.net/w.h/movie/f4990a965755af1be2a16c421951c48219905345.jpg","onlinePlay":false,"sc":0,"title":"最佳音效剪辑(提名)","type":"imageTag"},{"desc":"爱乐之城","img":"http://p0.meituan.net/w.h/movie/f4990a965755af1be2a16c421951c48219905345.jpg","onlinePlay":false,"sc":0,"title":"最佳原创歌曲(提名)","type":"imageTag"},{"desc":"爱乐之城","img":"http://p0.meituan.net/w.h/movie/f4990a965755af1be2a16c421951c48219905345.jpg","onlinePlay":false,"sc":0,"subDesc":"Justin Hurwitz","title":"最佳原创音乐(提名)","type":"imageTag"}]
         * nominationCount : 11
         * title : 第89届奥斯卡金像奖
         */

        private int awardCount;
        private String awardUrl;
        private int festSessionId;
        private int festivalId;
        private String icon;
        private int nominationCount;
        private String title;
        private List<ItemsBean> items;

        public int getAwardCount() {
            return awardCount;
        }

        public void setAwardCount(int awardCount) {
            this.awardCount = awardCount;
        }

        public String getAwardUrl() {
            return awardUrl;
        }

        public void setAwardUrl(String awardUrl) {
            this.awardUrl = awardUrl;
        }

        public int getFestSessionId() {
            return festSessionId;
        }

        public void setFestSessionId(int festSessionId) {
            this.festSessionId = festSessionId;
        }

        public int getFestivalId() {
            return festivalId;
        }

        public void setFestivalId(int festivalId) {
            this.festivalId = festivalId;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getNominationCount() {
            return nominationCount;
        }

        public void setNominationCount(int nominationCount) {
            this.nominationCount = nominationCount;
        }

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
             * desc : 爱乐之城
             * img : http://p0.meituan.net/w.h/movie/f4990a965755af1be2a16c421951c48219905345.jpg
             * onlinePlay : false
             * sc : 0
             * title : 最佳影片(提名)
             * type : imageTag
             * celebrityId : 29845
             * subDesc : 达米恩·查泽雷
             */

            private String desc;
            private String img;
            private boolean onlinePlay;
            private int sc;
            private String title;
            private String type;
            private int celebrityId;
            private String subDesc;

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

            public int getSc() {
                return sc;
            }

            public void setSc(int sc) {
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

            public int getCelebrityId() {
                return celebrityId;
            }

            public void setCelebrityId(int celebrityId) {
                this.celebrityId = celebrityId;
            }

            public String getSubDesc() {
                return subDesc;
            }

            public void setSubDesc(String subDesc) {
                this.subDesc = subDesc;
            }
        }
    }
}

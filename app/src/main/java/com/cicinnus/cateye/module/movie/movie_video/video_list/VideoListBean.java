package com.cicinnus.cateye.module.movie.movie_video.video_list;

import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */

public class VideoListBean {
    /**
     * data : [{"comment":77,"count":2495664,"id":83397,"img":"http://p1.meituan.net/w.h/movie/e906f4f84be05edc3e1b82bd54113e2048584.jpeg","movieId":334590,"movieName":"极限特工：终极回归","pubTime":"2017.02.10","showSt":3,"tl":"终极预告片","tm":92,"type":1,"url":"http://maoyan.meituan.net/movie/videos/854x48060703da44cc941e5b89522f42ae242b4.mp4"},{"comment":35,"count":1638053,"id":83276,"img":"http://p1.meituan.net/w.h/movie/53c66e823dee55fbf3aa8df32d71b33222605.jpg","movieId":334590,"movieName":"极限特工：终极回归","pubTime":"2017.02.10","showSt":3,"tl":"甄子丹中文角色预告片","tm":30,"type":1,"url":"http://maoyan.meituan.net/movie/videos/854x48054cd184fb9d74a4a8c55abaf0651d21c.mp4"},{"comment":21,"count":969934,"id":83083,"img":"http://p1.meituan.net/w.h/movie/7abd2b7afd6269f8c68d03736c11b8ae13707.jpg","movieId":334590,"movieName":"极限特工：终极回归","pubTime":"2017.02.10","showSt":3,"tl":"战士版预告片","tm":20,"type":1,"url":"http://maoyan.meituan.net/movie/videos/854x480f7b6498493a0454c8202cda9aedad440.mp4"},{"comment":15,"count":487823,"id":83082,"img":"http://p0.meituan.net/w.h/movie/59f1fe063f8c5f192a0e8c6642e8ebaf29900.jpg","movieId":334590,"movieName":"极限特工：终极回归","pubTime":"2017.02.10","showSt":3,"tl":"对抗版预告片","tm":30,"type":1,"url":"http://maoyan.meituan.net/movie/videos/854x48059e1515bb50549c1b33e0194fb24262b.mp4"},{"comment":29,"count":283054,"id":82839,"img":"http://p0.meituan.net/w.h/movie/1ea4ec6bded5b243f9e7b4809966ff4f51123.jpg","movieId":334590,"movieName":"极限特工：终极回归","pubTime":"2017.02.10","showSt":3,"tl":"定档版预告片","tm":30,"type":1,"url":"http://maoyan.meituan.net/movie/videos/99edeafb33a24f659e5acd8db2231480.mp4"},{"comment":49,"count":296042,"id":82567,"img":"http://p0.meituan.net/w.h/movie/1c6347e1b4ef4359a365101903a0719826501.jpg","movieId":334590,"movieName":"极限特工：终极回归","pubTime":"2017.02.10","showSt":3,"tl":"吴亦凡电影角色预告片","tm":37,"type":1,"url":"http://maoyan.meituan.net/movie/videos/854x48030326aee9fb34bc0b601cd56705e9010.mp4"},{"comment":12,"count":220149,"id":82497,"img":"http://p0.meituan.net/w.h/movie/60ac797ffe0aeb2011da69b7ae50b11a52746.jpg","movieId":334590,"movieName":"极限特工：终极回归","pubTime":"2017.02.10","showSt":3,"tl":"国际版预告片","tm":60,"type":1,"url":"http://maoyan.meituan.net/movie/videos/f70b3ba609fc4ebba23d04e62e858b06.mp4"},{"comment":15,"count":154685,"id":81998,"img":"http://p0.meituan.net/w.h/movie/853bdf466a14c5e21b76a11bdf0321e821821.jpg","movieId":334590,"movieName":"极限特工：终极回归","pubTime":"2017.02.10","showSt":3,"tl":"国际版预告片","tm":62,"type":1,"url":"http://maoyan.meituan.net/movie/videos/667a473a1c134125b90e2d3cb8f1fea9.mp4"},{"comment":28,"count":154178,"id":81598,"img":"http://p1.meituan.net/w.h/movie/cdc6aecf7d5d6765f969aed804f5308639485.jpg","movieId":334590,"movieName":"极限特工：终极回归","pubTime":"2017.02.10","showSt":3,"tl":"中文版终极预告片","tm":139,"type":1,"url":"http://maoyan.meituan.net/movie/videos/854x4805f887937e7464bf7abc90ba5684a9f0b.mp4"},{"comment":9,"count":60801,"id":81593,"img":"http://p0.meituan.net/w.h/movie/858f81879d24af1015b4159a57482bf744231.jpg","movieId":334590,"movieName":"极限特工：终极回归","pubTime":"2017.02.10","showSt":3,"tl":"终极预告片","tm":139,"type":1,"url":"http://maoyan.meituan.net/movie/videos/ff4b7448d4de40cead6cde5e6ceefb18.mp4"}]
     * paging : {"hasMore":true,"limit":10,"offset":0,"total":48}
     */

    private PagingBean paging;
    private List<DataBean> data;

    public PagingBean getPaging() {
        return paging;
    }

    public void setPaging(PagingBean paging) {
        this.paging = paging;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class PagingBean {
        /**
         * hasMore : true
         * limit : 10
         * offset : 0
         * total : 48
         */

        private boolean hasMore;
        private int limit;
        private int offset;
        private int total;

        public boolean isHasMore() {
            return hasMore;
        }

        public void setHasMore(boolean hasMore) {
            this.hasMore = hasMore;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    public static class DataBean {
        /**
         * comment : 77
         * count : 2495664
         * id : 83397
         * img : http://p1.meituan.net/w.h/movie/e906f4f84be05edc3e1b82bd54113e2048584.jpeg
         * movieId : 334590
         * movieName : 极限特工：终极回归
         * pubTime : 2017.02.10
         * showSt : 3
         * tl : 终极预告片
         * tm : 92
         * type : 1
         * url : http://maoyan.meituan.net/movie/videos/854x48060703da44cc941e5b89522f42ae242b4.mp4
         */

        private int comment;
        private int count;
        private int id;
        private String img;
        private int movieId;
        private String movieName;
        private String pubTime;
        private int showSt;
        private String tl;
        private int tm;
        private int type;
        private String url;
        public boolean isSelect;

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getPubTime() {
            return pubTime;
        }

        public void setPubTime(String pubTime) {
            this.pubTime = pubTime;
        }

        public int getShowSt() {
            return showSt;
        }

        public void setShowSt(int showSt) {
            this.showSt = showSt;
        }

        public String getTl() {
            return tl;
        }

        public void setTl(String tl) {
            this.tl = tl;
        }

        public int getTm() {
            return tm;
        }

        public void setTm(int tm) {
            this.tm = tm;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}

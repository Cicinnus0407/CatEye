package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.hot_good_comment;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/3.
 */

public class HotGoodCommentBean {

    /**
     * data : {"boardtype":7,"content":"《每日热映口碑榜》\u2014\u2014将昨日国内热映的影片，按照评分从高到低排列，取前10名，每天上午10点更新，相关数据来源于\u201c猫眼专业版\u201d及\u201c猫眼电影库\u201d。","created":"2017-02-03","id":7,"movies":[{"dir":"梅尔·吉布森","globalReleased":true,"id":338349,"img":"http://p0.meituan.net/w.h/movie/018ceaadb90ac5c1b9ba33546d1fb746401981.jpg","nm":"血战钢锯岭","pubDesc":"2016-12-08大陆上映","rt":"2016-12-08","sc":9.4,"star":"安德鲁·加菲尔德,雨果·维文,卢克·布雷西","wish":32064},{"dir":"丁亮,林永长,林汇达","globalReleased":true,"id":1189089,"img":"http://p1.meituan.net/w.h/movie/cfcdb50d181a2111a2b79a0639db0f19764116.png","nm":"熊出没·奇幻空间","pubDesc":"2017-01-28大陆上映","rt":"2017-01-28","sc":9.2,"star":"尚雯婕,鲍春来,曾舜晞","wish":29669},{"dir":"埃里克·韦林,埃里克·萨默","globalReleased":true,"id":1042603,"img":"http://p1.meituan.net/w.h/movie/f885e601ccd912011725a8d7488633b7812258.jpg","nm":"了不起的菲丽西","pubDesc":"2017-02-01大陆上映","rt":"2017-02-01","sc":9.2,"star":"艾丽·范宁,卡莉·蕾·吉普森,戴恩·德哈恩","wish":12299},{"dir":"韩寒","globalReleased":true,"id":1170255,"img":"http://p0.meituan.net/w.h/movie/c6cadc16e53ee7a0f79a9455a147449d50210.jpeg","nm":"乘风破浪","pubDesc":"2017-01-28大陆上映","rt":"2017-01-28","sc":8.8,"star":"邓超,彭于晏,赵丽颖","wish":49770},{"dir":"宋晓飞,董旭","globalReleased":true,"id":1188324,"img":"http://p0.meituan.net/w.h/movie/8bd63a54c2ebcb79fbaa3777e2d72d0c199654.jpg","nm":"情圣","pubDesc":"2016-12-30大陆上映","rt":"2016-12-30","sc":8.7,"star":"肖央,闫妮,小沈阳","wish":37660},{"dir":"唐季礼","globalReleased":true,"id":248933,"img":"http://p1.meituan.net/w.h/movie/d273af80e581b4c60abcbb57a95ad2b72956123.jpg","nm":"功夫瑜伽","pubDesc":"2017-01-28大陆上映","rt":"2017-01-28","sc":8.6,"star":"成龙,李治廷,张艺兴","wish":89920},{"dir":"李清舫,张遥函,雪萌","globalReleased":true,"id":1197753,"img":"http://p1.meituan.net/w.h/movie/d0f9c85f526557c1d0ad3011e2c83cbb446135.png","nm":"大卫贝肯之倒霉特工熊","pubDesc":"2017-01-13大陆上映","rt":"2017-01-13","sc":8.6,"star":"汤水雨,徐佳琦,杨默","wish":8342},{"dir":"莫腾·泰杜姆","globalReleased":true,"id":341201,"img":"http://p0.meituan.net/w.h/movie/9b7f7df143af8a13ccd17057d772e9e7654933.png","nm":"太空旅客","pubDesc":"2017-01-13大陆上映","rt":"2017-01-13","sc":8.5,"star":"詹妮弗·劳伦斯,克里斯·帕拉特,迈克尔·辛","wish":44420},{"dir":"张艺谋","globalReleased":true,"id":246267,"img":"http://p0.meituan.net/w.h/movie/e4a3447ebe8c44eea59ab7f68790c7e2179321.jpeg","nm":"长城","pubDesc":"2016-12-16大陆上映","rt":"2016-12-16","sc":8.4,"star":"马特·达蒙,景甜,佩德罗·帕斯卡","wish":242315},{"dir":"加里斯·爱德华斯","globalReleased":true,"id":247185,"img":"http://p0.meituan.net/w.h/movie/ef1bc6e7987fcb64558d11cadb86b3be687974.jpg","nm":"星球大战外传：侠盗一号","pubDesc":"2017-01-06大陆上映","rt":"2017-01-06","sc":8,"star":"菲丽希缇·琼斯,迭戈·鲁纳,艾伦·图代克","wish":100271}],"paging":{"hasMore":false,"limit":10,"offset":0,"total":10},"shareHidden":1,"title":"每日热映口碑榜"}
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
         * boardtype : 7
         * content : 《每日热映口碑榜》——将昨日国内热映的影片，按照评分从高到低排列，取前10名，每天上午10点更新，相关数据来源于“猫眼专业版”及“猫眼电影库”。
         * created : 2017-02-03
         * id : 7
         * movies : [{"dir":"梅尔·吉布森","globalReleased":true,"id":338349,"img":"http://p0.meituan.net/w.h/movie/018ceaadb90ac5c1b9ba33546d1fb746401981.jpg","nm":"血战钢锯岭","pubDesc":"2016-12-08大陆上映","rt":"2016-12-08","sc":9.4,"star":"安德鲁·加菲尔德,雨果·维文,卢克·布雷西","wish":32064},{"dir":"丁亮,林永长,林汇达","globalReleased":true,"id":1189089,"img":"http://p1.meituan.net/w.h/movie/cfcdb50d181a2111a2b79a0639db0f19764116.png","nm":"熊出没·奇幻空间","pubDesc":"2017-01-28大陆上映","rt":"2017-01-28","sc":9.2,"star":"尚雯婕,鲍春来,曾舜晞","wish":29669},{"dir":"埃里克·韦林,埃里克·萨默","globalReleased":true,"id":1042603,"img":"http://p1.meituan.net/w.h/movie/f885e601ccd912011725a8d7488633b7812258.jpg","nm":"了不起的菲丽西","pubDesc":"2017-02-01大陆上映","rt":"2017-02-01","sc":9.2,"star":"艾丽·范宁,卡莉·蕾·吉普森,戴恩·德哈恩","wish":12299},{"dir":"韩寒","globalReleased":true,"id":1170255,"img":"http://p0.meituan.net/w.h/movie/c6cadc16e53ee7a0f79a9455a147449d50210.jpeg","nm":"乘风破浪","pubDesc":"2017-01-28大陆上映","rt":"2017-01-28","sc":8.8,"star":"邓超,彭于晏,赵丽颖","wish":49770},{"dir":"宋晓飞,董旭","globalReleased":true,"id":1188324,"img":"http://p0.meituan.net/w.h/movie/8bd63a54c2ebcb79fbaa3777e2d72d0c199654.jpg","nm":"情圣","pubDesc":"2016-12-30大陆上映","rt":"2016-12-30","sc":8.7,"star":"肖央,闫妮,小沈阳","wish":37660},{"dir":"唐季礼","globalReleased":true,"id":248933,"img":"http://p1.meituan.net/w.h/movie/d273af80e581b4c60abcbb57a95ad2b72956123.jpg","nm":"功夫瑜伽","pubDesc":"2017-01-28大陆上映","rt":"2017-01-28","sc":8.6,"star":"成龙,李治廷,张艺兴","wish":89920},{"dir":"李清舫,张遥函,雪萌","globalReleased":true,"id":1197753,"img":"http://p1.meituan.net/w.h/movie/d0f9c85f526557c1d0ad3011e2c83cbb446135.png","nm":"大卫贝肯之倒霉特工熊","pubDesc":"2017-01-13大陆上映","rt":"2017-01-13","sc":8.6,"star":"汤水雨,徐佳琦,杨默","wish":8342},{"dir":"莫腾·泰杜姆","globalReleased":true,"id":341201,"img":"http://p0.meituan.net/w.h/movie/9b7f7df143af8a13ccd17057d772e9e7654933.png","nm":"太空旅客","pubDesc":"2017-01-13大陆上映","rt":"2017-01-13","sc":8.5,"star":"詹妮弗·劳伦斯,克里斯·帕拉特,迈克尔·辛","wish":44420},{"dir":"张艺谋","globalReleased":true,"id":246267,"img":"http://p0.meituan.net/w.h/movie/e4a3447ebe8c44eea59ab7f68790c7e2179321.jpeg","nm":"长城","pubDesc":"2016-12-16大陆上映","rt":"2016-12-16","sc":8.4,"star":"马特·达蒙,景甜,佩德罗·帕斯卡","wish":242315},{"dir":"加里斯·爱德华斯","globalReleased":true,"id":247185,"img":"http://p0.meituan.net/w.h/movie/ef1bc6e7987fcb64558d11cadb86b3be687974.jpg","nm":"星球大战外传：侠盗一号","pubDesc":"2017-01-06大陆上映","rt":"2017-01-06","sc":8,"star":"菲丽希缇·琼斯,迭戈·鲁纳,艾伦·图代克","wish":100271}]
         * paging : {"hasMore":false,"limit":10,"offset":0,"total":10}
         * shareHidden : 1
         * title : 每日热映口碑榜
         */

        private int boardtype;
        private String content;
        private String created;
        private int id;
        private PagingBean paging;
        private int shareHidden;
        private String title;
        private List<MoviesBean> movies;

        public int getBoardtype() {
            return boardtype;
        }

        public void setBoardtype(int boardtype) {
            this.boardtype = boardtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public int getShareHidden() {
            return shareHidden;
        }

        public void setShareHidden(int shareHidden) {
            this.shareHidden = shareHidden;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class PagingBean {
            /**
             * hasMore : false
             * limit : 10
             * offset : 0
             * total : 10
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

        public static class MoviesBean {
            /**
             * dir : 梅尔·吉布森
             * globalReleased : true
             * id : 338349
             * img : http://p0.meituan.net/w.h/movie/018ceaadb90ac5c1b9ba33546d1fb746401981.jpg
             * nm : 血战钢锯岭
             * pubDesc : 2016-12-08大陆上映
             * rt : 2016-12-08
             * sc : 9.4
             * star : 安德鲁·加菲尔德,雨果·维文,卢克·布雷西
             * wish : 32064
             */

            private String dir;
            private boolean globalReleased;
            private int id;
            private String img;
            private String nm;
            private String pubDesc;
            private String rt;
            private double sc;
            private String star;
            private int wish;

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public boolean isGlobalReleased() {
                return globalReleased;
            }

            public void setGlobalReleased(boolean globalReleased) {
                this.globalReleased = globalReleased;
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

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getPubDesc() {
                return pubDesc;
            }

            public void setPubDesc(String pubDesc) {
                this.pubDesc = pubDesc;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }
        }
    }
}

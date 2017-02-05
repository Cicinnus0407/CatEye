
package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.top_100;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class TopHundredMovieBean {

    /**
     * data : {"boardtype":1,"content":"《猫眼经典Top100》\u2014\u2014将猫眼电影库中的经典影片，按照评分和评分人数综合排序，取前100名，每天上午10点更新，相关数据来源于\u201c猫眼电影库\u201d。","created":"2017-02-04","id":4,"movies":[{"dir":"陈凯歌","globalReleased":true,"id":1203,"img":"http://p1.meituan.net/w.h/movie/20803f59291c47e1e116c11963ce019e68711.jpg","nm":"霸王别姬","pubDesc":"1993-01-01中国香港上映","rt":"1993-01-01(中国香港)","sc":9.6,"star":"张国荣,张丰毅,巩俐"},{"dir":"弗兰克·德拉邦特","globalReleased":true,"id":1297,"img":"http://p0.meituan.net/w.h/movie/__40191813__4767047.jpg","nm":"肖申克的救赎","pubDesc":"1994-10-14美国上映","rt":"1994-10-14(美国)","sc":9.5,"star":"蒂姆·罗宾斯,摩根·弗里曼,鲍勃·冈顿"},{"dir":"吕克·贝松","globalReleased":true,"id":4055,"img":"http://p0.meituan.net/w.h/movie/fc9d78dd2ce84d20e53b6d1ae2eea4fb1515304.jpg","nm":"这个杀手不太冷","pubDesc":"1994-09-14法国上映","rt":"1994-09-14(法国)","sc":9.5,"star":"让·雷诺,加里·奥德曼,娜塔莉·波特曼"},{"dir":"威廉·惠勒","globalReleased":true,"id":2641,"img":"http://p0.meituan.net/w.h/movie/23/6009725.jpg","nm":"罗马假日","pubDesc":"1953-09-02美国上映","rt":"1953-09-02(美国)","sc":9.1,"star":"格利高利·派克,奥黛丽·赫本,埃迪·艾伯特"},{"dir":"罗伯特·泽米吉斯","globalReleased":true,"id":1633,"img":"http://p0.meituan.net/w.h/movie/53/1541925.jpg","nm":"阿甘正传","pubDesc":"1994-07-06美国上映","rt":"1994-07-06(美国)","sc":9.4,"star":"汤姆·汉克斯,罗宾·怀特,加里·西尼斯"},{"dir":"詹姆斯·卡梅隆","globalReleased":true,"id":267,"img":"http://p0.meituan.net/w.h/movie/11/324629.jpg","nm":"泰坦尼克号","pubDesc":"1998-04-03大陆上映","rt":"1998-04-03","sc":9.5,"star":"莱昂纳多·迪卡普里奥,凯特·温丝莱特,比利·赞恩"},{"dir":"宫崎骏","globalReleased":true,"id":123,"img":"http://p0.meituan.net/w.h/movie/99/678407.jpg","nm":"龙猫","pubDesc":"1988-04-16日本上映","rt":"1988-04-16(日本)","sc":9.2,"star":"日高法子,坂本千夏,糸井重里"},{"dir":"弗朗西斯·福特·科波拉","globalReleased":true,"id":1247,"img":"http://p0.meituan.net/w.h/movie/92/8212889.jpg","nm":"教父","pubDesc":"1972-03-24美国上映","rt":"1972-03-24(美国)","sc":9.3,"star":"马龙·白兰度,阿尔·帕西诺,詹姆斯·凯恩"},{"dir":"李力持","globalReleased":true,"id":837,"img":"http://p0.meituan.net/w.h/movie/62/109878.jpg","nm":"唐伯虎点秋香","pubDesc":"1993-07-01中国香港上映","rt":"1993-07-01(中国香港)","sc":9.2,"star":"周星驰,巩俐,郑佩佩"},{"dir":"宫崎骏","globalReleased":true,"id":1228,"img":"http://p0.meituan.net/w.h/movie/24/4495986.jpg","nm":"天空之城","pubDesc":"1986-08-02日本上映","rt":"1986-08-02(日本)","sc":9.1,"star":"寺田农,鹫尾真知子,龟山助清"}],"paging":{"hasMore":true,"limit":10,"offset":0,"total":100},"shareHidden":1,"title":"猫眼经典Top100"}
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
         * boardtype : 1
         * content : 《猫眼经典Top100》——将猫眼电影库中的经典影片，按照评分和评分人数综合排序，取前100名，每天上午10点更新，相关数据来源于“猫眼电影库”。
         * created : 2017-02-04
         * id : 4
         * movies : [{"dir":"陈凯歌","globalReleased":true,"id":1203,"img":"http://p1.meituan.net/w.h/movie/20803f59291c47e1e116c11963ce019e68711.jpg","nm":"霸王别姬","pubDesc":"1993-01-01中国香港上映","rt":"1993-01-01(中国香港)","sc":9.6,"star":"张国荣,张丰毅,巩俐"},{"dir":"弗兰克·德拉邦特","globalReleased":true,"id":1297,"img":"http://p0.meituan.net/w.h/movie/__40191813__4767047.jpg","nm":"肖申克的救赎","pubDesc":"1994-10-14美国上映","rt":"1994-10-14(美国)","sc":9.5,"star":"蒂姆·罗宾斯,摩根·弗里曼,鲍勃·冈顿"},{"dir":"吕克·贝松","globalReleased":true,"id":4055,"img":"http://p0.meituan.net/w.h/movie/fc9d78dd2ce84d20e53b6d1ae2eea4fb1515304.jpg","nm":"这个杀手不太冷","pubDesc":"1994-09-14法国上映","rt":"1994-09-14(法国)","sc":9.5,"star":"让·雷诺,加里·奥德曼,娜塔莉·波特曼"},{"dir":"威廉·惠勒","globalReleased":true,"id":2641,"img":"http://p0.meituan.net/w.h/movie/23/6009725.jpg","nm":"罗马假日","pubDesc":"1953-09-02美国上映","rt":"1953-09-02(美国)","sc":9.1,"star":"格利高利·派克,奥黛丽·赫本,埃迪·艾伯特"},{"dir":"罗伯特·泽米吉斯","globalReleased":true,"id":1633,"img":"http://p0.meituan.net/w.h/movie/53/1541925.jpg","nm":"阿甘正传","pubDesc":"1994-07-06美国上映","rt":"1994-07-06(美国)","sc":9.4,"star":"汤姆·汉克斯,罗宾·怀特,加里·西尼斯"},{"dir":"詹姆斯·卡梅隆","globalReleased":true,"id":267,"img":"http://p0.meituan.net/w.h/movie/11/324629.jpg","nm":"泰坦尼克号","pubDesc":"1998-04-03大陆上映","rt":"1998-04-03","sc":9.5,"star":"莱昂纳多·迪卡普里奥,凯特·温丝莱特,比利·赞恩"},{"dir":"宫崎骏","globalReleased":true,"id":123,"img":"http://p0.meituan.net/w.h/movie/99/678407.jpg","nm":"龙猫","pubDesc":"1988-04-16日本上映","rt":"1988-04-16(日本)","sc":9.2,"star":"日高法子,坂本千夏,糸井重里"},{"dir":"弗朗西斯·福特·科波拉","globalReleased":true,"id":1247,"img":"http://p0.meituan.net/w.h/movie/92/8212889.jpg","nm":"教父","pubDesc":"1972-03-24美国上映","rt":"1972-03-24(美国)","sc":9.3,"star":"马龙·白兰度,阿尔·帕西诺,詹姆斯·凯恩"},{"dir":"李力持","globalReleased":true,"id":837,"img":"http://p0.meituan.net/w.h/movie/62/109878.jpg","nm":"唐伯虎点秋香","pubDesc":"1993-07-01中国香港上映","rt":"1993-07-01(中国香港)","sc":9.2,"star":"周星驰,巩俐,郑佩佩"},{"dir":"宫崎骏","globalReleased":true,"id":1228,"img":"http://p0.meituan.net/w.h/movie/24/4495986.jpg","nm":"天空之城","pubDesc":"1986-08-02日本上映","rt":"1986-08-02(日本)","sc":9.1,"star":"寺田农,鹫尾真知子,龟山助清"}]
         * paging : {"hasMore":true,"limit":10,"offset":0,"total":100}
         * shareHidden : 1
         * title : 猫眼经典Top100
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
             * hasMore : true
             * limit : 10
             * offset : 0
             * total : 100
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
             * dir : 陈凯歌
             * globalReleased : true
             * id : 1203
             * img : http://p1.meituan.net/w.h/movie/20803f59291c47e1e116c11963ce019e68711.jpg
             * nm : 霸王别姬
             * pubDesc : 1993-01-01中国香港上映
             * rt : 1993-01-01(中国香港)
             * sc : 9.6
             * star : 张国荣,张丰毅,巩俐
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
        }
    }
}

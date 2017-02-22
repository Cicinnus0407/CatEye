package com.cicinnus.cateye.module.movie.hot_movie;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.cicinnus.cateye.base.BaseConstant;

import java.util.List;

/**
 * Created by Cicinnus on 2017/1/24.
 */

public class HotMovieListBean {


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private String stid;
        private int total;
        private List<?> coming;
        private List<HotBean> hot;
        private List<Integer> movieIds;
        private List<StidsBean> stids;
        private List<MoviesBean> movies;

        public String getStid() {
            return stid;
        }

        public void setStid(String stid) {
            this.stid = stid;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<?> getComing() {
            return coming;
        }

        public void setComing(List<?> coming) {
            this.coming = coming;
        }

        public List<HotBean> getHot() {
            return hot;
        }

        public void setHot(List<HotBean> hot) {
            this.hot = hot;
        }

        public List<Integer> getMovieIds() {
            return movieIds;
        }

        public void setMovieIds(List<Integer> movieIds) {
            this.movieIds = movieIds;
        }

        public List<StidsBean> getStids() {
            return stids;
        }

        public void setStids(List<StidsBean> stids) {
            this.stids = stids;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class HotBean implements MultiItemEntity {
            /**
             * boxInfo : 上映12天，累计票房26263万
             * cat : 爱情,冒险,科幻
             * civilPubSt : 0
             * desc : 主演:詹妮弗·劳伦斯,克里斯·帕拉特,迈克尔·辛
             * dir : 莫腾·泰杜姆
             * dur : 118
             * effectShowNum : 0
             * fra : 美国
             * frt : 2016-12-21
             * globalReleased : true
             * headLineShow : false
             * headLines : []
             * headLinesVO : [{"movieId":341201,"title":"航天博士提醒太空啪啪啪都是骗人滴！","type":"专题","url":"meituanmovie://www.meituan.com/forum/newsDetail?id= 18314"},{"movieId":341201,"title":"2.37亿美元登顶全球周票房榜冠军","type":"资讯","url":"meituanmovie://www.meituan.com/forum/newsDetail?id= 18294"}]
             * id : 341201
             * img : http://p0.meituan.net/w.h/movie/9b7f7df143af8a13ccd17057d772e9e7654933.png
             * late : false
             * localPubSt : 0
             * mk : 8.5
             * newsHeadlines : [{"movieId":341201,"title":"航天博士提醒太空啪啪啪都是骗人滴！","type":"专题","url":"meituanmovie://www.meituan.com/forum/newsDetail?id= 18314"},{"movieId":341201,"title":"2.37亿美元登顶全球周票房榜冠军","type":"资讯","url":"meituanmovie://www.meituan.com/forum/newsDetail?id= 18294"}]
             * nm : 太空旅客
             * pn : 169
             * preSale : 0
             * preShow : false
             * proScore : 0
             * proScoreNum : 13
             * pubDate : 1484236800000
             * pubShowNum : 0
             * recentShowDate : 1485187200000
             * recentShowNum : 0
             * rt : 2017-01-13
             * sc : 8.5
             * scm : 未达目的地，太空铁达尼
             * showCinemaNum : 139
             * showInfo : 今天139家影院放映1185场
             * showNum : 1185
             * showTimeInfo : 2017-01-13上映
             * showst : 3
             * snum : 79456
             * star : 詹妮弗·劳伦斯,克里斯·帕拉特,迈克尔·辛
             * totalShowNum : 2096
             * ver : 3D/中国巨幕
             * videoId : 82973
             * videoName : “扭转命运”版预告片
             * videourl : http://maoyan.meituan.net/movie/videos/854x48066c53e6a247d45059607a6f0f5e0a42d.mp4
             * vnum : 26
             * weight : 1
             * wish : 44420
             * wishst : 0
             */

            private String boxInfo;
            private String cat;
            private int civilPubSt;
            private String desc;
            private String dir;
            private int dur;
            private int effectShowNum;
            private String fra;
            private String frt;
            private boolean globalReleased;
            private boolean headLineShow;
            private int id;
            private String img;
            private boolean late;
            private int localPubSt;
            private double mk;
            private String nm;
            private int pn;
            private int preSale;
            private boolean preShow;
            private int proScore;
            private int proScoreNum;
            private long pubDate;
            private int pubShowNum;
            private long recentShowDate;
            private int recentShowNum;
            private String rt;
            private double sc;
            private String scm;
            private int showCinemaNum;
            private String showInfo;
            private int showNum;
            private String showTimeInfo;
            private int showst;
            private int snum;
            private String star;
            private int totalShowNum;
            private String ver;
            private int videoId;
            private String videoName;
            private String videourl;
            private int vnum;
            private int weight;
            private int wish;
            private int wishst;
            private List<?> headLines;
            private List<HeadLinesVOBean> headLinesVO;
            private List<NewsHeadlinesBean> newsHeadlines;

            public String getBoxInfo() {
                return boxInfo;
            }

            public void setBoxInfo(String boxInfo) {
                this.boxInfo = boxInfo;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getCivilPubSt() {
                return civilPubSt;
            }

            public void setCivilPubSt(int civilPubSt) {
                this.civilPubSt = civilPubSt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public int getEffectShowNum() {
                return effectShowNum;
            }

            public void setEffectShowNum(int effectShowNum) {
                this.effectShowNum = effectShowNum;
            }

            public String getFra() {
                return fra;
            }

            public void setFra(String fra) {
                this.fra = fra;
            }

            public String getFrt() {
                return frt;
            }

            public void setFrt(String frt) {
                this.frt = frt;
            }

            public boolean isGlobalReleased() {
                return globalReleased;
            }

            public void setGlobalReleased(boolean globalReleased) {
                this.globalReleased = globalReleased;
            }

            public boolean isHeadLineShow() {
                return headLineShow;
            }

            public void setHeadLineShow(boolean headLineShow) {
                this.headLineShow = headLineShow;
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

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public int getLocalPubSt() {
                return localPubSt;
            }

            public void setLocalPubSt(int localPubSt) {
                this.localPubSt = localPubSt;
            }

            public double getMk() {
                return mk;
            }

            public void setMk(double mk) {
                this.mk = mk;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public boolean isPreShow() {
                return preShow;
            }

            public void setPreShow(boolean preShow) {
                this.preShow = preShow;
            }

            public int getProScore() {
                return proScore;
            }

            public void setProScore(int proScore) {
                this.proScore = proScore;
            }

            public int getProScoreNum() {
                return proScoreNum;
            }

            public void setProScoreNum(int proScoreNum) {
                this.proScoreNum = proScoreNum;
            }

            public long getPubDate() {
                return pubDate;
            }

            public void setPubDate(long pubDate) {
                this.pubDate = pubDate;
            }

            public int getPubShowNum() {
                return pubShowNum;
            }

            public void setPubShowNum(int pubShowNum) {
                this.pubShowNum = pubShowNum;
            }

            public long getRecentShowDate() {
                return recentShowDate;
            }

            public void setRecentShowDate(long recentShowDate) {
                this.recentShowDate = recentShowDate;
            }

            public int getRecentShowNum() {
                return recentShowNum;
            }

            public void setRecentShowNum(int recentShowNum) {
                this.recentShowNum = recentShowNum;
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

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public int getShowCinemaNum() {
                return showCinemaNum;
            }

            public void setShowCinemaNum(int showCinemaNum) {
                this.showCinemaNum = showCinemaNum;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public int getShowNum() {
                return showNum;
            }

            public void setShowNum(int showNum) {
                this.showNum = showNum;
            }

            public String getShowTimeInfo() {
                return showTimeInfo;
            }

            public void setShowTimeInfo(String showTimeInfo) {
                this.showTimeInfo = showTimeInfo;
            }

            public int getShowst() {
                return showst;
            }

            public void setShowst(int showst) {
                this.showst = showst;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public int getTotalShowNum() {
                return totalShowNum;
            }

            public void setTotalShowNum(int totalShowNum) {
                this.totalShowNum = totalShowNum;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public int getVideoId() {
                return videoId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }

            public String getVideoName() {
                return videoName;
            }

            public void setVideoName(String videoName) {
                this.videoName = videoName;
            }

            public String getVideourl() {
                return videourl;
            }

            public void setVideourl(String videourl) {
                this.videourl = videourl;
            }

            public int getVnum() {
                return vnum;
            }

            public void setVnum(int vnum) {
                this.vnum = vnum;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public int getWishst() {
                return wishst;
            }

            public void setWishst(int wishst) {
                this.wishst = wishst;
            }

            public List<?> getHeadLines() {
                return headLines;
            }

            public void setHeadLines(List<?> headLines) {
                this.headLines = headLines;
            }

            public List<HeadLinesVOBean> getHeadLinesVO() {
                return headLinesVO;
            }

            public void setHeadLinesVO(List<HeadLinesVOBean> headLinesVO) {
                this.headLinesVO = headLinesVO;
            }

            public List<NewsHeadlinesBean> getNewsHeadlines() {
                return newsHeadlines;
            }

            public void setNewsHeadlines(List<NewsHeadlinesBean> newsHeadlines) {
                this.newsHeadlines = newsHeadlines;
            }

            @Override
            public int getItemType() {
                if (getHeadLinesVO() != null && getHeadLinesVO().size() > 0) {

                    return BaseConstant.TYPE_HOT_HEADLINE;
                }
                return BaseConstant.TYPE_HOT_NORMAL;

            }

            public static class HeadLinesVOBean {
                /**
                 * movieId : 341201
                 * title : 航天博士提醒太空啪啪啪都是骗人滴！
                 * type : 专题
                 * url : meituanmovie://www.meituan.com/forum/newsDetail?id= 18314
                 */

                private int movieId;
                private String title;
                private String type;
                private String url;

                public int getMovieId() {
                    return movieId;
                }

                public void setMovieId(int movieId) {
                    this.movieId = movieId;
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

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class NewsHeadlinesBean {
                /**
                 * movieId : 341201
                 * title : 航天博士提醒太空啪啪啪都是骗人滴！
                 * type : 专题
                 * url : meituanmovie://www.meituan.com/forum/newsDetail?id= 18314
                 */

                private int movieId;
                private String title;
                private String type;
                private String url;

                public int getMovieId() {
                    return movieId;
                }

                public void setMovieId(int movieId) {
                    this.movieId = movieId;
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

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class StidsBean {
            /**
             * movieId : 341201
             * stid : 576591972453269000_a341201_c0
             */

            private int movieId;
            private String stid;

            public int getMovieId() {
                return movieId;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public String getStid() {
                return stid;
            }

            public void setStid(String stid) {
                this.stid = stid;
            }
        }

        public static class MoviesBean {

            private String boxInfo;
            private String cat;
            private int civilPubSt;
            private String desc;
            private String dir;
            private int dur;
            private int effectShowNum;
            private String fra;
            private String frt;
            private boolean globalReleased;
            private boolean headLineShow;
            private int id;
            private String img;
            private boolean late;
            private int localPubSt;
            private double mk;
            private String nm;
            private int pn;
            private int preSale;
            private boolean preShow;
            private int proScore;
            private int proScoreNum;
            private long pubDate;
            private int pubShowNum;
            private long recentShowDate;
            private int recentShowNum;
            private String rt;
            private double sc;
            private String scm;
            private int showCinemaNum;
            private String showInfo;
            private int showNum;
            private String showTimeInfo;
            private int showst;
            private int snum;
            private String star;
            private int totalShowNum;
            private String ver;
            private int videoId;
            private String videoName;
            private String videourl;
            private int vnum;
            private int weight;
            private int wish;
            private int wishst;

            public String getBoxInfo() {
                return boxInfo;
            }

            public void setBoxInfo(String boxInfo) {
                this.boxInfo = boxInfo;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getCivilPubSt() {
                return civilPubSt;
            }

            public void setCivilPubSt(int civilPubSt) {
                this.civilPubSt = civilPubSt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public int getEffectShowNum() {
                return effectShowNum;
            }

            public void setEffectShowNum(int effectShowNum) {
                this.effectShowNum = effectShowNum;
            }

            public String getFra() {
                return fra;
            }

            public void setFra(String fra) {
                this.fra = fra;
            }

            public String getFrt() {
                return frt;
            }

            public void setFrt(String frt) {
                this.frt = frt;
            }

            public boolean isGlobalReleased() {
                return globalReleased;
            }

            public void setGlobalReleased(boolean globalReleased) {
                this.globalReleased = globalReleased;
            }

            public boolean isHeadLineShow() {
                return headLineShow;
            }

            public void setHeadLineShow(boolean headLineShow) {
                this.headLineShow = headLineShow;
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

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public int getLocalPubSt() {
                return localPubSt;
            }

            public void setLocalPubSt(int localPubSt) {
                this.localPubSt = localPubSt;
            }

            public double getMk() {
                return mk;
            }

            public void setMk(double mk) {
                this.mk = mk;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public boolean isPreShow() {
                return preShow;
            }

            public void setPreShow(boolean preShow) {
                this.preShow = preShow;
            }

            public int getProScore() {
                return proScore;
            }

            public void setProScore(int proScore) {
                this.proScore = proScore;
            }

            public int getProScoreNum() {
                return proScoreNum;
            }

            public void setProScoreNum(int proScoreNum) {
                this.proScoreNum = proScoreNum;
            }

            public long getPubDate() {
                return pubDate;
            }

            public void setPubDate(long pubDate) {
                this.pubDate = pubDate;
            }

            public int getPubShowNum() {
                return pubShowNum;
            }

            public void setPubShowNum(int pubShowNum) {
                this.pubShowNum = pubShowNum;
            }

            public long getRecentShowDate() {
                return recentShowDate;
            }

            public void setRecentShowDate(long recentShowDate) {
                this.recentShowDate = recentShowDate;
            }

            public int getRecentShowNum() {
                return recentShowNum;
            }

            public void setRecentShowNum(int recentShowNum) {
                this.recentShowNum = recentShowNum;
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

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public int getShowCinemaNum() {
                return showCinemaNum;
            }

            public void setShowCinemaNum(int showCinemaNum) {
                this.showCinemaNum = showCinemaNum;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public int getShowNum() {
                return showNum;
            }

            public void setShowNum(int showNum) {
                this.showNum = showNum;
            }

            public String getShowTimeInfo() {
                return showTimeInfo;
            }

            public void setShowTimeInfo(String showTimeInfo) {
                this.showTimeInfo = showTimeInfo;
            }

            public int getShowst() {
                return showst;
            }

            public void setShowst(int showst) {
                this.showst = showst;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public int getTotalShowNum() {
                return totalShowNum;
            }

            public void setTotalShowNum(int totalShowNum) {
                this.totalShowNum = totalShowNum;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public int getVideoId() {
                return videoId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }

            public String getVideoName() {
                return videoName;
            }

            public void setVideoName(String videoName) {
                this.videoName = videoName;
            }

            public String getVideourl() {
                return videourl;
            }

            public void setVideourl(String videourl) {
                this.videourl = videourl;
            }

            public int getVnum() {
                return vnum;
            }

            public void setVnum(int vnum) {
                this.vnum = vnum;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public int getWishst() {
                return wishst;
            }

            public void setWishst(int wishst) {
                this.wishst = wishst;
            }


        }
    }
}

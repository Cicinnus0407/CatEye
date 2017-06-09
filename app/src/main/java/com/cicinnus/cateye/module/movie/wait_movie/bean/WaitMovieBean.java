package com.cicinnus.cateye.module.movie.wait_movie.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.cicinnus.cateye.base.BaseConstant;

import java.util.List;

/**
 * Created by Cicinnus on 2017/1/25.
 */

public class WaitMovieBean {


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private List<ComingBean> coming;
        private List<Integer> movieIds;

        public List<ComingBean> getComing() {
            return coming;
        }

        public void setComing(List<ComingBean> coming) {
            this.coming = coming;
        }

        public List<Integer> getMovieIds() {
            return movieIds;
        }

        public void setMovieIds(List<Integer> movieIds) {
            this.movieIds = movieIds;
        }


        public static class ComingBean  implements MultiItemEntity{
            /**
             * boxInfo : 喵，即将上映
             * cat : 喜剧,奇幻,武侠
             * civilPubSt : 0
             * comingTitle : 1月27日 周五
             * desc : 主演:舒淇,王千源,张孝全
             * dir : 陈玉勋
             * dur : 116
             * effectShowNum : 0
             * globalReleased : false
             * headLineShow : false
             * headLinesVO : []
             * id : 345668
             * img : http://p0.meituan.net/w.h/movie/cd23a5f30b3918cf241074bad9589d0d421744.jpg
             * late : false
             * localPubSt : 0
             * mk : 0
             * nm : 健忘村
             * pn : 241
             * preShow : true
             * proScore : 0
             * proScoreNum : 0
             * pubDate : 1485446400000
             * pubDesc : 2017-01-27大陆上映
             * pubShowNum : 0
             * recentShowDate : 0
             * recentShowNum : 0
             * rt : 2017-01-27
             * sc : 0
             * scm : 偏僻小山村，通车换乾坤
             * showCinemaNum : 0
             * showInfo : 今天80家影院放映230场
             * showNum : 0
             * showst : 4
             * snum : 688
             * star : 舒淇,王千源,张孝全
             * ver : 2D
             * videoId : 83103
             * videoName : 四川版预告片
             * videourl : http://maoyan.meituan.net/movie/videos/854x48062cdd36d482848c2a48a08b811d24413.mp4
             * vnum : 28
             * weight : 1
             * wish : 13647
             * wishst : 0
             * ftime : 2017-12
             * fra : 美国
             * frt : 2016-02-26
             */

            private String boxInfo;
            private String cat;
            private int civilPubSt;
            private String comingTitle;
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
            private List<HeadLinesVOBean> headLinesVO;
            private List<NewsHeadlinesBean> newsHeadlines;
            private List<ExpectMovieBean.DataBean.ComingBean> recentExpectList;
            private List<TrailerRecommendBean.DataBean> trailerDataBeanList;


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


            public String getComingTitle() {
                return comingTitle;
            }

            public void setComingTitle(String comingTitle) {
                this.comingTitle = comingTitle;
            }




            @Override
            public int getItemType() {
                if(getTrailerDataBeanList()!=null){
                    return BaseConstant.TYPE_WAIT_TRAILER;
                }
                if(getRecentExpectList()!=null){
                    return BaseConstant.TYPE_WAIT_RECENT;
                }
                return BaseConstant.TYPE_WAIT_NORMAL;
            }

            public List<ExpectMovieBean.DataBean.ComingBean> getRecentExpectList() {
                return recentExpectList;
            }

            public void setRecentExpectList(List<ExpectMovieBean.DataBean.ComingBean> recentExpectList) {
                this.recentExpectList = recentExpectList;
            }

            public List<TrailerRecommendBean.DataBean> getTrailerDataBeanList() {
                return trailerDataBeanList;
            }

            public void setTrailerDataBeanList(List<TrailerRecommendBean.DataBean> trailerDataBeanList) {
                this.trailerDataBeanList = trailerDataBeanList;
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



    }


}

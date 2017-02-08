package com.cicinnus.cateye.module.movie.search_movie;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.cicinnus.cateye.base.BaseConstant;

import java.util.List;

/**
 * Created by Administrator on 2017/2/3.
 */

public class ClassifySearchBean {

    /**
     * list : [{"cat":"爱情,剧情","dur":171,"enm":"Farewell My Concubine","fra":"中国香港","frt":"1993-01-01","globalReleased":true,"id":1203,"img":"http://p1.meituan.net/w.h/movie/20803f59291c47e1e116c11963ce019e68711.jpg","movieType":0,"nm":"霸王别姬","onlinePlay":false,"pubDesc":"1993-01-01中国香港上映","sc":9.6,"show":"","showst":2,"type":0,"ver":"2D","wish":30,"wishst":0},{"cat":"历史,爱情,灾难","dur":194,"enm":"Titanic","fra":"美国","frt":"1997-12-19","globalReleased":true,"id":267,"img":"http://p0.meituan.net/w.h/movie/11/324629.jpg","movieType":0,"nm":"泰坦尼克号","onlinePlay":false,"pubDesc":"1998-04-03大陆上映","rt":"1998-04-03","sc":9.5,"show":"","showst":2,"type":0,"ver":"2D","wish":143,"wishst":0},{"cat":"喜剧,奇幻,爱情","dur":95,"enm":"A Chinese Odyssey Part Two - Cinderella","fra":"中国香港","frt":"1995-02-04","globalReleased":true,"id":158,"img":"http://p0.meituan.net/w.h/movie/b429501a792ae227deaa16bc25c2e07a122042.jpg","movieType":0,"nm":"大话西游之大圣娶亲","onlinePlay":false,"pubDesc":"2014-10-24大陆上映","rt":"2014-10-24","sc":9.4,"show":"","showst":2,"type":0,"ver":"2D","wish":8907,"wishst":0},{"cat":"爱情,灾难,剧情","dur":194,"enm":"Titanic 3D","fra":"美国","frt":"2012-04-04","globalReleased":true,"id":125,"img":"http://p0.meituan.net/w.h/movie/85/637119.jpg","movieType":0,"nm":"泰坦尼克号3D","onlinePlay":false,"pubDesc":"2012-04-10大陆上映","rt":"2012-04-10","sc":9.4,"show":"","showst":2,"type":0,"ver":"2D/3D","wish":780,"wishst":0},{"cat":"喜剧,爱情","dur":104,"enm":"Goodbye Mr. Loser,Xia Luo Te Fan Nao","globalReleased":true,"id":246082,"img":"http://p1.meituan.net/w.h/movie/fb3c0a57f5c7a06d5059fd5059eb1d13141704.jpg","movieType":0,"nm":"夏洛特烦恼","onlinePlay":true,"pubDesc":"2015-09-30大陆上映","rt":"2015-09-30","sc":9.3,"show":"","showst":2,"type":0,"ver":"2D","wish":75859,"wishst":0},{"cat":"喜剧,爱情,家庭","dur":112,"enm":"장수상회","fra":"韩国","frt":"2015-04-09","globalReleased":true,"id":247739,"img":"http://p0.meituan.net/w.h/movie/08d4747ab4753de380502ea682125c96159371.jpg","movieType":0,"nm":"长寿商会","onlinePlay":false,"pubDesc":"2015-04-09韩国上映","sc":9.3,"show":"","showst":2,"type":0,"ver":"2D","wish":86,"wishst":0},{"cat":"战争,剧情,爱情","dur":116,"enm":"La vita è bella","fra":"意大利","frt":"1997-12-20","globalReleased":true,"id":1303,"img":"http://p0.meituan.net/w.h/movie/5bef87296178cc0c0946f9c352ca267a119592.jpg","movieType":0,"nm":"美丽人生","onlinePlay":false,"pubDesc":"1997-12-20意大利上映","sc":9.3,"show":"","showst":2,"type":0,"ver":"2D","wish":7,"wishst":0},{"cat":"动画,爱情,奇幻","dur":107,"enm":"君の名は。","fra":"日本","frt":"2016-08-26","globalReleased":true,"id":344881,"img":"http://p0.meituan.net/w.h/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","movieType":0,"nm":"你的名字。","onlinePlay":false,"pubDesc":"2016-12-02大陆上映","rt":"2016-12-02","sc":9.2,"show":"","showst":2,"type":0,"ver":"2D","wish":277114,"wishst":0},{"cat":"喜剧,爱情","dur":134,"enm":"Our Times","fra":"中国台湾,中国香港,新加坡,韩国,日本","frt":"2015-08-13,2015-10-15,2015-10-22,2016-05-12,2016-11-26","globalReleased":true,"id":341569,"img":"http://p1.meituan.net/w.h/movie/19e87124de0929c5df86cb760776afc5655939.jpg","movieType":0,"nm":"我的少女时代","onlinePlay":false,"pubDesc":"2015-11-19大陆上映","rt":"2015-11-19","sc":9.2,"show":"","showst":2,"type":0,"ver":"2D","wish":54553,"wishst":0},{"cat":"喜剧,爱情,奇幻","dur":131,"enm":"Miss Granny","fra":"中国台湾","frt":"2015-01-23","globalReleased":true,"id":245876,"img":"http://p1.meituan.net/w.h/movie/f8c8e543b94efd9bae5e9c4415666646225384.jpg","movieType":0,"nm":"重返20岁","onlinePlay":true,"pubDesc":"2015-01-08大陆上映","rt":"2015-01-08","sc":9.2,"show":"","showst":2,"type":0,"ver":"2D","wish":49029,"wishst":0}]
     * total : 8185
     * type : 0
     */

    private int total;
    private int type;
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements MultiItemEntity{
        /**
         * cat : 爱情,剧情
         * dur : 171
         * enm : Farewell My Concubine
         * fra : 中国香港
         * frt : 1993-01-01
         * globalReleased : true
         * id : 1203
         * img : http://p1.meituan.net/w.h/movie/20803f59291c47e1e116c11963ce019e68711.jpg
         * movieType : 0
         * nm : 霸王别姬
         * onlinePlay : false
         * pubDesc : 1993-01-01中国香港上映
         * sc : 9.6
         * show :
         * showst : 2
         * type : 0
         * ver : 2D
         * wish : 30
         * wishst : 0
         * rt : 1998-04-03
         */

        private String cat;
        private int dur;
        private String enm;
        private String fra;
        private String frt;
        private boolean globalReleased;
        private int id;
        private String img;
        private int movieType;
        private String nm;
        private boolean onlinePlay;
        private String pubDesc;
        private double sc;
        private String show;
        private int showst;
        private int type;
        private String ver;
        private int wish;
        private int wishst;
        private String rt;

        public String getCat() {
            return cat;
        }

        public void setCat(String cat) {
            this.cat = cat;
        }

        public int getDur() {
            return dur;
        }

        public void setDur(int dur) {
            this.dur = dur;
        }

        public String getEnm() {
            return enm;
        }

        public void setEnm(String enm) {
            this.enm = enm;
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

        public int getMovieType() {
            return movieType;
        }

        public void setMovieType(int movieType) {
            this.movieType = movieType;
        }

        public String getNm() {
            return nm;
        }

        public void setNm(String nm) {
            this.nm = nm;
        }

        public boolean isOnlinePlay() {
            return onlinePlay;
        }

        public void setOnlinePlay(boolean onlinePlay) {
            this.onlinePlay = onlinePlay;
        }

        public String getPubDesc() {
            return pubDesc;
        }

        public void setPubDesc(String pubDesc) {
            this.pubDesc = pubDesc;
        }

        public double getSc() {
            return sc;
        }

        public void setSc(double sc) {
            this.sc = sc;
        }

        public String getShow() {
            return show;
        }

        public void setShow(String show) {
            this.show = show;
        }

        public int getShowst() {
            return showst;
        }

        public void setShowst(int showst) {
            this.showst = showst;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getVer() {
            return ver==null?"":ver;
        }

        public void setVer(String ver) {
            this.ver = ver;
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

        public String getRt() {
            return rt;
        }

        public void setRt(String rt) {
            this.rt = rt;
        }

        @Override
        public int getItemType() {
            switch (getShowst()){
                case 1:
                    return BaseConstant.TYPE_CLASSIFY_WISH;
                case 2:
                    return BaseConstant.TYPE_CLASSIFY_NORMAL;
                case 3:
                    return BaseConstant.TYPE_CLASSIFY_BUY;
                case 4:
                    return BaseConstant.TYPE_CLASSIFY_PRESALE;
                default:
                    return BaseConstant.TYPE_CLASSIFY_NORMAL;
            }
        }
    }
}

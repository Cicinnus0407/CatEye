package com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */

public class AwardsBean {

    /**
     * data : {"cnm":"日本电影学院奖","enm":"Awards of the Japanese Academy","festSessions":[{"festSessionId":4071,"heldAddress":"日本","heldDate":"2017-03-02","sessionNum":40},{"festSessionId":3366,"heldAddress":"Japan","heldDate":"","sessionNum":39},{"festSessionId":3367,"heldAddress":"Japan","heldDate":"","sessionNum":38},{"festSessionId":3368,"heldAddress":"Japan","heldDate":"","sessionNum":37},{"festSessionId":3369,"heldAddress":"Japan","heldDate":"","sessionNum":36},{"festSessionId":3370,"heldAddress":"Japan","heldDate":"","sessionNum":35},{"festSessionId":3371,"heldAddress":"Japan","heldDate":"","sessionNum":34},{"festSessionId":3372,"heldAddress":"Japan","heldDate":"2010-03-05","sessionNum":33},{"festSessionId":3373,"heldAddress":"Japan","heldDate":"2009-02-20","sessionNum":32},{"festSessionId":3374,"heldAddress":"Japan","heldDate":"2008-02-15","sessionNum":31},{"festSessionId":3375,"heldAddress":"Japan","heldDate":"2007-02-16","sessionNum":30},{"festSessionId":3376,"heldAddress":"Japan","heldDate":"2006-03-03","sessionNum":29},{"festSessionId":3377,"heldAddress":"Japan","heldDate":"2005-02-18","sessionNum":28},{"festSessionId":3379,"heldAddress":"Japan","heldDate":"2004-02-20","sessionNum":27},{"festSessionId":3380,"heldAddress":"Japan","heldDate":"2003-03-07","sessionNum":26},{"festSessionId":3378,"heldAddress":"Japan","heldDate":"2002-03-08","sessionNum":25},{"festSessionId":3381,"heldAddress":"Japan","heldDate":"2001-03-09","sessionNum":24},{"festSessionId":3382,"heldAddress":"Japan","heldDate":"2000-03-10","sessionNum":23},{"festSessionId":3383,"heldAddress":"Japan","heldDate":"1999-03-12","sessionNum":22},{"festSessionId":3384,"heldAddress":"Japan","heldDate":"1998-03-06","sessionNum":21},{"festSessionId":3385,"heldAddress":"Japan","heldDate":"1997-03-29","sessionNum":20},{"festSessionId":3386,"heldAddress":"Japan","heldDate":"1996-03-23","sessionNum":19},{"festSessionId":3387,"heldAddress":"Japan","heldDate":"1995-03-18","sessionNum":18},{"festSessionId":3388,"heldAddress":"Japan","heldDate":"1994-03-17","sessionNum":17},{"festSessionId":3389,"heldAddress":"Japan","heldDate":"1993-03-19","sessionNum":16},{"festSessionId":3390,"heldAddress":"Japan","heldDate":"1992-03-20","sessionNum":15},{"festSessionId":3391,"heldAddress":"Japan","heldDate":"1991-03-22","sessionNum":14},{"festSessionId":3392,"heldAddress":"Japan","heldDate":"1990-02-23","sessionNum":13},{"festSessionId":3393,"heldAddress":"Japan","heldDate":"1989-03-17","sessionNum":12},{"festSessionId":3394,"heldAddress":"Japan","heldDate":"1988-02-18","sessionNum":11},{"festSessionId":3395,"heldAddress":"Japan","heldDate":"1987-02-19","sessionNum":10},{"festSessionId":3396,"heldAddress":"Japan","heldDate":"1986-02-20","sessionNum":9},{"festSessionId":3397,"heldAddress":"Japan","heldDate":"1985-02-21","sessionNum":8},{"festSessionId":3398,"heldAddress":"Japan","heldDate":"1984-02-16","sessionNum":7},{"festSessionId":3399,"heldAddress":"Japan","heldDate":"1983-02-17","sessionNum":6},{"festSessionId":3400,"heldAddress":"Japan","heldDate":"1982-02-18","sessionNum":5},{"festSessionId":3402,"heldAddress":"Japan","heldDate":"1981-02-12","sessionNum":4},{"festSessionId":3401,"heldAddress":"Japan","heldDate":"1980-03-29","sessionNum":3},{"festSessionId":3403,"heldAddress":"Japan","heldDate":"1979-04-07","sessionNum":2},{"festSessionId":3404,"heldAddress":"Japan","heldDate":"1978-04-06","sessionNum":1}],"icon":"http://p0.meituan.net/movie/04d8bf2467f29ea0b72491587f8b34f95687.jpg","id":105,"intro":"日本电影学院奖协会主办的电影奖项。"}
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
         * cnm : 日本电影学院奖
         * enm : Awards of the Japanese Academy
         * festSessions : [{"festSessionId":4071,"heldAddress":"日本","heldDate":"2017-03-02","sessionNum":40},{"festSessionId":3366,"heldAddress":"Japan","heldDate":"","sessionNum":39},{"festSessionId":3367,"heldAddress":"Japan","heldDate":"","sessionNum":38},{"festSessionId":3368,"heldAddress":"Japan","heldDate":"","sessionNum":37},{"festSessionId":3369,"heldAddress":"Japan","heldDate":"","sessionNum":36},{"festSessionId":3370,"heldAddress":"Japan","heldDate":"","sessionNum":35},{"festSessionId":3371,"heldAddress":"Japan","heldDate":"","sessionNum":34},{"festSessionId":3372,"heldAddress":"Japan","heldDate":"2010-03-05","sessionNum":33},{"festSessionId":3373,"heldAddress":"Japan","heldDate":"2009-02-20","sessionNum":32},{"festSessionId":3374,"heldAddress":"Japan","heldDate":"2008-02-15","sessionNum":31},{"festSessionId":3375,"heldAddress":"Japan","heldDate":"2007-02-16","sessionNum":30},{"festSessionId":3376,"heldAddress":"Japan","heldDate":"2006-03-03","sessionNum":29},{"festSessionId":3377,"heldAddress":"Japan","heldDate":"2005-02-18","sessionNum":28},{"festSessionId":3379,"heldAddress":"Japan","heldDate":"2004-02-20","sessionNum":27},{"festSessionId":3380,"heldAddress":"Japan","heldDate":"2003-03-07","sessionNum":26},{"festSessionId":3378,"heldAddress":"Japan","heldDate":"2002-03-08","sessionNum":25},{"festSessionId":3381,"heldAddress":"Japan","heldDate":"2001-03-09","sessionNum":24},{"festSessionId":3382,"heldAddress":"Japan","heldDate":"2000-03-10","sessionNum":23},{"festSessionId":3383,"heldAddress":"Japan","heldDate":"1999-03-12","sessionNum":22},{"festSessionId":3384,"heldAddress":"Japan","heldDate":"1998-03-06","sessionNum":21},{"festSessionId":3385,"heldAddress":"Japan","heldDate":"1997-03-29","sessionNum":20},{"festSessionId":3386,"heldAddress":"Japan","heldDate":"1996-03-23","sessionNum":19},{"festSessionId":3387,"heldAddress":"Japan","heldDate":"1995-03-18","sessionNum":18},{"festSessionId":3388,"heldAddress":"Japan","heldDate":"1994-03-17","sessionNum":17},{"festSessionId":3389,"heldAddress":"Japan","heldDate":"1993-03-19","sessionNum":16},{"festSessionId":3390,"heldAddress":"Japan","heldDate":"1992-03-20","sessionNum":15},{"festSessionId":3391,"heldAddress":"Japan","heldDate":"1991-03-22","sessionNum":14},{"festSessionId":3392,"heldAddress":"Japan","heldDate":"1990-02-23","sessionNum":13},{"festSessionId":3393,"heldAddress":"Japan","heldDate":"1989-03-17","sessionNum":12},{"festSessionId":3394,"heldAddress":"Japan","heldDate":"1988-02-18","sessionNum":11},{"festSessionId":3395,"heldAddress":"Japan","heldDate":"1987-02-19","sessionNum":10},{"festSessionId":3396,"heldAddress":"Japan","heldDate":"1986-02-20","sessionNum":9},{"festSessionId":3397,"heldAddress":"Japan","heldDate":"1985-02-21","sessionNum":8},{"festSessionId":3398,"heldAddress":"Japan","heldDate":"1984-02-16","sessionNum":7},{"festSessionId":3399,"heldAddress":"Japan","heldDate":"1983-02-17","sessionNum":6},{"festSessionId":3400,"heldAddress":"Japan","heldDate":"1982-02-18","sessionNum":5},{"festSessionId":3402,"heldAddress":"Japan","heldDate":"1981-02-12","sessionNum":4},{"festSessionId":3401,"heldAddress":"Japan","heldDate":"1980-03-29","sessionNum":3},{"festSessionId":3403,"heldAddress":"Japan","heldDate":"1979-04-07","sessionNum":2},{"festSessionId":3404,"heldAddress":"Japan","heldDate":"1978-04-06","sessionNum":1}]
         * icon : http://p0.meituan.net/movie/04d8bf2467f29ea0b72491587f8b34f95687.jpg
         * id : 105
         * intro : 日本电影学院奖协会主办的电影奖项。
         */

        private String cnm;
        private String enm;
        private String icon;
        private int id;
        private String intro;
        private List<FestSessionsBean> festSessions;

        public String getCnm() {
            return cnm;
        }

        public void setCnm(String cnm) {
            this.cnm = cnm;
        }

        public String getEnm() {
            return enm;
        }

        public void setEnm(String enm) {
            this.enm = enm;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public List<FestSessionsBean> getFestSessions() {
            return festSessions;
        }

        public void setFestSessions(List<FestSessionsBean> festSessions) {
            this.festSessions = festSessions;
        }

        public static class FestSessionsBean {
            /**
             * festSessionId : 4071
             * heldAddress : 日本
             * heldDate : 2017-03-02
             * sessionNum : 40
             */

            private int festSessionId;
            private String heldAddress;
            private String heldDate;
            private int sessionNum;

            public int getFestSessionId() {
                return festSessionId;
            }

            public void setFestSessionId(int festSessionId) {
                this.festSessionId = festSessionId;
            }

            public String getHeldAddress() {
                return heldAddress;
            }

            public void setHeldAddress(String heldAddress) {
                this.heldAddress = heldAddress;
            }

            public String getHeldDate() {
                return heldDate;
            }

            public void setHeldDate(String heldDate) {
                this.heldDate = heldDate;
            }

            public int getSessionNum() {
                return sessionNum;
            }

            public void setSessionNum(int sessionNum) {
                this.sessionNum = sessionNum;
            }
        }
    }
}

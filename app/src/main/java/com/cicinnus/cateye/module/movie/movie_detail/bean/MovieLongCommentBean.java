package com.cicinnus.cateye.module.movie.movie_detail.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */

public class MovieLongCommentBean {

    /**
     * data :       */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * filmReviews : [{"author":{"age":"27","authInfo":"","avatarType":255,"avatarurl":"https://img.meituan.net/avatar/__77705166__1214126.jpg","birthday":632851200000,"city":{"deleted":false,"id":60,"nm":"青岛","py":"qingdao"},"currentExp":1699,"gender":1,"id":50594003,"interest":"旅游,宠物,汽车,动漫,时尚,音乐,摄影,美食,电影,游戏,科技,文学","juryLevel":0,"maoyanAge":"3.5","marriage":"已婚","nextTitle":"","nickName":"cydenylau","occupation":"学生","registerTime":1372234121000,"roleType":0,"signature":"I don't COMMENT, I CRITISIZE.","title":"铂金会员","topicCount":1,"totalExp":3100,"uid":0,"userLevel":4,"userNextLevel":5,"username":"cydenylau","vipInfo":"特邀作者","vipType":1,"visitorCount":2747},"commentCount":47,"created":1485576784000,"id":124942,"movieId":334590,"pro":false,"sc":2.5,"supportComment":true,"supportLike":true,"text":"无脑的视效，乏味的表演，卡通化的故事\u2014\u2014每年春季档的Shitstorm都特别多：而近年来范柴油的吴克表演法，狮门/顶峰的黄金屎，简直是春晚一样的必备消遣。","title":"极限特工3：碟中谍之速度与激情与磨皮洗剪吹","upCount":27,"url":"meituanmovie://www.meituan.com/forum/postDetail?postID=124942","viewCount":7950},{"author":{"age":"22","authInfo":"","avatarType":255,"avatarurl":"https://img.meituan.net/avatar/c2cb3e45c953e9fce0fc28fe6d812b4b20817.jpg","birthday":805305600000,"city":{"deleted":false,"id":1,"nm":"北京","py":"beijing"},"currentExp":3376,"gender":1,"id":176081458,"interest":"财经,美食,电影,文学","juryLevel":0,"maoyanAge":"1.5","marriage":"单身","nextTitle":"","nickName":"张公子利源","occupation":"学生","registerTime":1427455525000,"roleType":0,"signature":"准备，准备，再准备\u2026\u2026","title":"钻石会员","topicCount":41,"totalExp":3376,"uid":0,"userLevel":5,"userNextLevel":5,"username":"张公子利源","vipInfo":"","vipType":0,"visitorCount":931},"commentCount":5,"created":1486950953000,"id":127007,"movieId":334590,"pro":false,"sc":4,"supportComment":true,"supportLike":true,"text":"推荐指数：8.33分","title":"《极限特工：终极回归》试片员观影报告：打斗场面精彩，剧情一般的标准好莱坞大片","upCount":2,"url":"meituanmovie://www.meituan.com/forum/postDetail?postID=127007","viewCount":881},{"author":{"age":"117","authInfo":"","avatarType":255,"avatarurl":"https://img.meituan.net/avatar/3f0734361aba6fb4ccc4212b79960d3d54332.jpg","birthday":-2177654400000,"city":{"deleted":false,"id":1,"nm":"北京","py":"beijing"},"currentExp":1033,"gender":2,"id":48284771,"interest":"","juryLevel":0,"maoyanAge":"3.5","marriage":"","nextTitle":"","nickName":"阿moon1026","occupation":"","registerTime":1369454548000,"roleType":0,"signature":"","title":"黄金会员","topicCount":1,"totalExp":1300,"uid":0,"userLevel":3,"userNextLevel":4,"username":"阿moon1026","vipInfo":"","vipType":0,"visitorCount":162},"commentCount":5,"created":1486653453000,"id":126711,"movieId":334590,"pro":false,"sc":4.5,"supportComment":true,"supportLike":true,"text":"要说稀有和珍贵，天底下只有一个桑德·凯奇，没有什么是他干不了的。","title":"一个全面开挂的天团，玩就玩点非人类的","upCount":9,"url":"meituanmovie://www.meituan.com/forum/postDetail?postID=126711","viewCount":434}]
         * total : 24
         */

        private int total;
        private List<FilmReviewsBean> filmReviews;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<FilmReviewsBean> getFilmReviews() {
            return filmReviews;
        }

        public void setFilmReviews(List<FilmReviewsBean> filmReviews) {
            this.filmReviews = filmReviews;
        }

        public static class FilmReviewsBean {
            /**
             * author : {"age":"27","authInfo":"","avatarType":255,"avatarurl":"https://img.meituan.net/avatar/__77705166__1214126.jpg","birthday":632851200000,"city":{"deleted":false,"id":60,"nm":"青岛","py":"qingdao"},"currentExp":1699,"gender":1,"id":50594003,"interest":"旅游,宠物,汽车,动漫,时尚,音乐,摄影,美食,电影,游戏,科技,文学","juryLevel":0,"maoyanAge":"3.5","marriage":"已婚","nextTitle":"","nickName":"cydenylau","occupation":"学生","registerTime":1372234121000,"roleType":0,"signature":"I don't COMMENT, I CRITISIZE.","title":"铂金会员","topicCount":1,"totalExp":3100,"uid":0,"userLevel":4,"userNextLevel":5,"username":"cydenylau","vipInfo":"特邀作者","vipType":1,"visitorCount":2747}
             * commentCount : 47
             * created : 1485576784000
             * id : 124942
             * movieId : 334590
             * pro : false
             * sc : 2.5
             * supportComment : true
             * supportLike : true
             * text : 无脑的视效，乏味的表演，卡通化的故事——每年春季档的Shitstorm都特别多：而近年来范柴油的吴克表演法，狮门/顶峰的黄金屎，简直是春晚一样的必备消遣。
             * title : 极限特工3：碟中谍之速度与激情与磨皮洗剪吹
             * upCount : 27
             * url : meituanmovie://www.meituan.com/forum/postDetail?postID=124942
             * viewCount : 7950
             */

            private AuthorBean author;
            private int commentCount;
            private long created;
            private int id;
            private int movieId;
            private boolean pro;
            private double sc;
            private boolean supportComment;
            private boolean supportLike;
            private String text;
            private String title;
            private int upCount;
            private String url;
            private int viewCount;

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public long getCreated() {
                return created;
            }

            public void setCreated(long created) {
                this.created = created;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMovieId() {
                return movieId;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public boolean isPro() {
                return pro;
            }

            public void setPro(boolean pro) {
                this.pro = pro;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public boolean isSupportComment() {
                return supportComment;
            }

            public void setSupportComment(boolean supportComment) {
                this.supportComment = supportComment;
            }

            public boolean isSupportLike() {
                return supportLike;
            }

            public void setSupportLike(boolean supportLike) {
                this.supportLike = supportLike;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpCount() {
                return upCount;
            }

            public void setUpCount(int upCount) {
                this.upCount = upCount;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }

            public static class AuthorBean {
                /**
                 * age : 27
                 * authInfo :
                 * avatarType : 255
                 * avatarurl : https://img.meituan.net/avatar/__77705166__1214126.jpg
                 * birthday : 632851200000
                 * city : {"deleted":false,"id":60,"nm":"青岛","py":"qingdao"}
                 * currentExp : 1699
                 * gender : 1
                 * id : 50594003
                 * interest : 旅游,宠物,汽车,动漫,时尚,音乐,摄影,美食,电影,游戏,科技,文学
                 * juryLevel : 0
                 * maoyanAge : 3.5
                 * marriage : 已婚
                 * nextTitle :
                 * nickName : cydenylau
                 * occupation : 学生
                 * registerTime : 1372234121000
                 * roleType : 0
                 * signature : I don't COMMENT, I CRITISIZE.
                 * title : 铂金会员
                 * topicCount : 1
                 * totalExp : 3100
                 * uid : 0
                 * userLevel : 4
                 * userNextLevel : 5
                 * username : cydenylau
                 * vipInfo : 特邀作者
                 * vipType : 1
                 * visitorCount : 2747
                 */

                private String age;
                private String authInfo;
                private int avatarType;
                private String avatarurl;
                private long birthday;
                private CityBean city;
                private int currentExp;
                private int gender;
                private int id;
                private String interest;
                private int juryLevel;
                private String maoyanAge;
                private String marriage;
                private String nextTitle;
                private String nickName;
                private String occupation;
                private long registerTime;
                private int roleType;
                private String signature;
                private String title;
                private int topicCount;
                private int totalExp;
                private int uid;
                private int userLevel;
                private int userNextLevel;
                private String username;
                private String vipInfo;
                private int vipType;
                private int visitorCount;

                public String getAge() {
                    return age;
                }

                public void setAge(String age) {
                    this.age = age;
                }

                public String getAuthInfo() {
                    return authInfo;
                }

                public void setAuthInfo(String authInfo) {
                    this.authInfo = authInfo;
                }

                public int getAvatarType() {
                    return avatarType;
                }

                public void setAvatarType(int avatarType) {
                    this.avatarType = avatarType;
                }

                public String getAvatarurl() {
                    return avatarurl;
                }

                public void setAvatarurl(String avatarurl) {
                    this.avatarurl = avatarurl;
                }

                public long getBirthday() {
                    return birthday;
                }

                public void setBirthday(long birthday) {
                    this.birthday = birthday;
                }

                public CityBean getCity() {
                    return city;
                }

                public void setCity(CityBean city) {
                    this.city = city;
                }

                public int getCurrentExp() {
                    return currentExp;
                }

                public void setCurrentExp(int currentExp) {
                    this.currentExp = currentExp;
                }

                public int getGender() {
                    return gender;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getInterest() {
                    return interest;
                }

                public void setInterest(String interest) {
                    this.interest = interest;
                }

                public int getJuryLevel() {
                    return juryLevel;
                }

                public void setJuryLevel(int juryLevel) {
                    this.juryLevel = juryLevel;
                }

                public String getMaoyanAge() {
                    return maoyanAge;
                }

                public void setMaoyanAge(String maoyanAge) {
                    this.maoyanAge = maoyanAge;
                }

                public String getMarriage() {
                    return marriage;
                }

                public void setMarriage(String marriage) {
                    this.marriage = marriage;
                }

                public String getNextTitle() {
                    return nextTitle;
                }

                public void setNextTitle(String nextTitle) {
                    this.nextTitle = nextTitle;
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public String getOccupation() {
                    return occupation;
                }

                public void setOccupation(String occupation) {
                    this.occupation = occupation;
                }

                public long getRegisterTime() {
                    return registerTime;
                }

                public void setRegisterTime(long registerTime) {
                    this.registerTime = registerTime;
                }

                public int getRoleType() {
                    return roleType;
                }

                public void setRoleType(int roleType) {
                    this.roleType = roleType;
                }

                public String getSignature() {
                    return signature;
                }

                public void setSignature(String signature) {
                    this.signature = signature;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getTopicCount() {
                    return topicCount;
                }

                public void setTopicCount(int topicCount) {
                    this.topicCount = topicCount;
                }

                public int getTotalExp() {
                    return totalExp;
                }

                public void setTotalExp(int totalExp) {
                    this.totalExp = totalExp;
                }

                public int getUid() {
                    return uid;
                }

                public void setUid(int uid) {
                    this.uid = uid;
                }

                public int getUserLevel() {
                    return userLevel;
                }

                public void setUserLevel(int userLevel) {
                    this.userLevel = userLevel;
                }

                public int getUserNextLevel() {
                    return userNextLevel;
                }

                public void setUserNextLevel(int userNextLevel) {
                    this.userNextLevel = userNextLevel;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getVipInfo() {
                    return vipInfo;
                }

                public void setVipInfo(String vipInfo) {
                    this.vipInfo = vipInfo;
                }

                public int getVipType() {
                    return vipType;
                }

                public void setVipType(int vipType) {
                    this.vipType = vipType;
                }

                public int getVisitorCount() {
                    return visitorCount;
                }

                public void setVisitorCount(int visitorCount) {
                    this.visitorCount = visitorCount;
                }

                public static class CityBean {
                    /**
                     * deleted : false
                     * id : 60
                     * nm : 青岛
                     * py : qingdao
                     */

                    private boolean deleted;
                    private int id;
                    private String nm;
                    private String py;

                    public boolean isDeleted() {
                        return deleted;
                    }

                    public void setDeleted(boolean deleted) {
                        this.deleted = deleted;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getNm() {
                        return nm;
                    }

                    public void setNm(String nm) {
                        this.nm = nm;
                    }

                    public String getPy() {
                        return py;
                    }

                    public void setPy(String py) {
                        this.py = py;
                    }
                }
            }
        }
    }
}

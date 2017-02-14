package com.cicinnus.cateye.module.movie.movie_detail.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */

public class MovieTopicBean {



    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {


        private String uri;
        private List<TopicsBean> topics;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public List<TopicsBean> getTopics() {
            return topics;
        }

        public void setTopics(List<TopicsBean> topics) {
            this.topics = topics;
        }

        public static class TopicsBean {
            /**
             * activity : false
             * author : {"age":"32","authInfo":"","avatarType":255,"avatarurl":"https://img.meituan.net/avatar/22d05f00da9141a81ec3fbdcedf665f026485.jpg","birthday":491673600000,"city":{"deleted":false,"id":42,"nm":"西安","py":"xian"},"currentExp":2813,"gender":1,"id":57126124,"interest":"旅游,音乐,摄影,电影,体育,文学","juryLevel":0,"maoyanAge":"3","marriage":"单身","nextTitle":"","nickName":"fengfeng","occupation":"影视","registerTime":1377426252000,"roleType":0,"signature":"你以目光感受 浪漫宁静宇宙","title":"铂金会员","topicCount":3,"totalExp":3100,"uid":0,"userLevel":4,"userNextLevel":5,"username":"高卫峰521","vipInfo":"","vipType":0,"visitorCount":41}
             * best : false
             * category : 0
             * collected : false
             * commentCount : 1
             * created : 1483010816000
             * filmReview : false
             * groupId : 1501304
             * groupTitle : 爱乐之城
             * hot : false
             * id : 122477
             * latestCommentTime : 1486868432614
             * previews : [{"authorId":57126124,"height":720,"id":2790735,"sizeType":0,"targetId":122477,"targetType":10,"url":"http://p1.meituan.net/movie/7274c50b263692d1310875d35ff6dd98287094.jpg@300w_225h_1e_1c_1l","width":720}]
             * pro : false
             * supportComment : true
             * supportLike : true
             * text :
             * title : 石头姐集锦
             * top : false
             * type : 0
             * upCount : 41
             * viewCount : 5610
             */

            private boolean activity;
            private AuthorBean author;
            private boolean best;
            private int category;
            private boolean collected;
            private int commentCount;
            private long created;
            private boolean filmReview;
            private int groupId;
            private String groupTitle;
            private boolean hot;
            private int id;
            private long latestCommentTime;
            private boolean pro;
            private boolean supportComment;
            private boolean supportLike;
            private String text;
            private String title;
            private boolean top;
            private int type;
            private int upCount;
            private int viewCount;
            private List<PreviewsBean> previews;

            public boolean isActivity() {
                return activity;
            }

            public void setActivity(boolean activity) {
                this.activity = activity;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public boolean isBest() {
                return best;
            }

            public void setBest(boolean best) {
                this.best = best;
            }

            public int getCategory() {
                return category;
            }

            public void setCategory(int category) {
                this.category = category;
            }

            public boolean isCollected() {
                return collected;
            }

            public void setCollected(boolean collected) {
                this.collected = collected;
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

            public boolean isFilmReview() {
                return filmReview;
            }

            public void setFilmReview(boolean filmReview) {
                this.filmReview = filmReview;
            }

            public int getGroupId() {
                return groupId;
            }

            public void setGroupId(int groupId) {
                this.groupId = groupId;
            }

            public String getGroupTitle() {
                return groupTitle;
            }

            public void setGroupTitle(String groupTitle) {
                this.groupTitle = groupTitle;
            }

            public boolean isHot() {
                return hot;
            }

            public void setHot(boolean hot) {
                this.hot = hot;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getLatestCommentTime() {
                return latestCommentTime;
            }

            public void setLatestCommentTime(long latestCommentTime) {
                this.latestCommentTime = latestCommentTime;
            }

            public boolean isPro() {
                return pro;
            }

            public void setPro(boolean pro) {
                this.pro = pro;
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

            public boolean isTop() {
                return top;
            }

            public void setTop(boolean top) {
                this.top = top;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUpCount() {
                return upCount;
            }

            public void setUpCount(int upCount) {
                this.upCount = upCount;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }

            public List<PreviewsBean> getPreviews() {
                return previews;
            }

            public void setPreviews(List<PreviewsBean> previews) {
                this.previews = previews;
            }

            public static class AuthorBean {
                /**
                 * age : 32
                 * authInfo :
                 * avatarType : 255
                 * avatarurl : https://img.meituan.net/avatar/22d05f00da9141a81ec3fbdcedf665f026485.jpg
                 * birthday : 491673600000
                 * city : {"deleted":false,"id":42,"nm":"西安","py":"xian"}
                 * currentExp : 2813
                 * gender : 1
                 * id : 57126124
                 * interest : 旅游,音乐,摄影,电影,体育,文学
                 * juryLevel : 0
                 * maoyanAge : 3
                 * marriage : 单身
                 * nextTitle :
                 * nickName : fengfeng
                 * occupation : 影视
                 * registerTime : 1377426252000
                 * roleType : 0
                 * signature : 你以目光感受 浪漫宁静宇宙
                 * title : 铂金会员
                 * topicCount : 3
                 * totalExp : 3100
                 * uid : 0
                 * userLevel : 4
                 * userNextLevel : 5
                 * username : 高卫峰521
                 * vipInfo :
                 * vipType : 0
                 * visitorCount : 41
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
                     * id : 42
                     * nm : 西安
                     * py : xian
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

            public static class PreviewsBean {
                /**
                 * authorId : 57126124
                 * height : 720
                 * id : 2790735
                 * sizeType : 0
                 * targetId : 122477
                 * targetType : 10
                 * url : http://p1.meituan.net/movie/7274c50b263692d1310875d35ff6dd98287094.jpg@300w_225h_1e_1c_1l
                 * width : 720
                 */

                private int authorId;
                private int height;
                private int id;
                private int sizeType;
                private int targetId;
                private int targetType;
                private String url;
                private int width;

                public int getAuthorId() {
                    return authorId;
                }

                public void setAuthorId(int authorId) {
                    this.authorId = authorId;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getSizeType() {
                    return sizeType;
                }

                public void setSizeType(int sizeType) {
                    this.sizeType = sizeType;
                }

                public int getTargetId() {
                    return targetId;
                }

                public void setTargetId(int targetId) {
                    this.targetId = targetId;
                }

                public int getTargetType() {
                    return targetType;
                }

                public void setTargetType(int targetType) {
                    this.targetType = targetType;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }
        }
    }
}

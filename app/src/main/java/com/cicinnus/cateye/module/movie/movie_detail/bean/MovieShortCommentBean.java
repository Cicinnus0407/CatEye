package com.cicinnus.cateye.module.movie.movie_detail.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/6/8.
 */

public class MovieShortCommentBean {



    private DataBean data;
    private PagingBean paging;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public PagingBean getPaging() {
        return paging;
    }

    public void setPaging(PagingBean paging) {
        this.paging = paging;
    }

    public static class DataBean {
        private List<CmtsBean> cmts;
        private List<HcmtsBean> hcmts;

        public List<CmtsBean> getCmts() {
            return cmts;
        }

        public void setCmts(List<CmtsBean> cmts) {
            this.cmts = cmts;
        }

        public List<HcmtsBean> getHcmts() {
            return hcmts;
        }

        public void setHcmts(List<HcmtsBean> hcmts) {
            this.hcmts = hcmts;
        }

        public static class CmtsBean {
            /**
             * approve : 0
             * approved : false
             * authInfo :
             * avatarurl : https://img.meituan.net/avatar/e8b8e9cea99733806b71328ccdffaa13127773.jpg
             * content : 银河味道极浓的一部作品，宿命感也很强，这里没有对和错，只有人性的挣扎！影片的结构很特殊，三位男主的演技更是太棒了，无可挑剔！
             * created : 1466869586000
             * filmView : false
             * gender : 1
             * id : 70980918
             * isMajor : false
             * juryLevel : 0
             * movieId : 246313
             * nick : KwY447145035
             * nickName : 舟山加肥猫
             * oppose : 0
             * pro : false
             * reply : 0
             * score : 5
             * spoiler : 0
             * startTime : 2017-06-03 08:40:11
             * supportComment : true
             * supportLike : true
             * sureViewed : 0
             * time : 2017-06-03 08:40
             * userId : 61313788
             * userLevel : 4
             * vipInfo :
             * vipType : 0
             * cityName : 银川
             */

            private int approve;
            private boolean approved;
            private String authInfo;
            private String avatarurl;
            private String content;
            private long created;
            private boolean filmView;
            private int gender;
            private int id;
            private boolean isMajor;
            private int juryLevel;
            private int movieId;
            private String nick;
            private String nickName;
            private int oppose;
            private boolean pro;
            private int reply;
            private Number score;
            private int spoiler;
            private String startTime;
            private boolean supportComment;
            private boolean supportLike;
            private int sureViewed;
            private String time;
            private int userId;
            private int userLevel;
            private String vipInfo;
            private int vipType;
            private String cityName;

            public int getApprove() {
                return approve;
            }

            public void setApprove(int approve) {
                this.approve = approve;
            }

            public boolean isApproved() {
                return approved;
            }

            public void setApproved(boolean approved) {
                this.approved = approved;
            }

            public String getAuthInfo() {
                return authInfo;
            }

            public void setAuthInfo(String authInfo) {
                this.authInfo = authInfo;
            }

            public String getAvatarurl() {
                return avatarurl;
            }

            public void setAvatarurl(String avatarurl) {
                this.avatarurl = avatarurl;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public long getCreated() {
                return created;
            }

            public void setCreated(long created) {
                this.created = created;
            }

            public boolean isFilmView() {
                return filmView;
            }

            public void setFilmView(boolean filmView) {
                this.filmView = filmView;
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

            public boolean isIsMajor() {
                return isMajor;
            }

            public void setIsMajor(boolean isMajor) {
                this.isMajor = isMajor;
            }

            public int getJuryLevel() {
                return juryLevel;
            }

            public void setJuryLevel(int juryLevel) {
                this.juryLevel = juryLevel;
            }

            public int getMovieId() {
                return movieId;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getOppose() {
                return oppose;
            }

            public void setOppose(int oppose) {
                this.oppose = oppose;
            }

            public boolean isPro() {
                return pro;
            }

            public void setPro(boolean pro) {
                this.pro = pro;
            }

            public int getReply() {
                return reply;
            }

            public void setReply(int reply) {
                this.reply = reply;
            }



            public int getSpoiler() {
                return spoiler;
            }

            public void setSpoiler(int spoiler) {
                this.spoiler = spoiler;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
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

            public int getSureViewed() {
                return sureViewed;
            }

            public void setSureViewed(int sureViewed) {
                this.sureViewed = sureViewed;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getUserLevel() {
                return userLevel;
            }

            public void setUserLevel(int userLevel) {
                this.userLevel = userLevel;
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

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public Number getScore() {
                return score;
            }

            public void setScore(Number score) {
                this.score = score;
            }
        }

        public static class HcmtsBean {
            /**
             * approve : 17
             * approved : false
             * authInfo :
             * avatarurl : https://img.meituan.net/avatar/c0062b136fd6f365ccf292eecedd396c301406.jpg
             * cityName : 顺德
             * content : 等了两个多月终于等到资源，三位导演分拍出来居然不跳戏，可见剪接流畅，而且武戏文拍，把回归焦虑症用三大贼王的故事引出，细节到位，各种讽刺隐喻随处可见，最后三大贼王没落充满了银河宿命感，而且最后一幕跟开头首尾呼应有如神来之笔，高！
             * created : 1466830024000
             * filmView : false
             * gender : 2
             * id : 70867030
             * isMajor : false
             * juryLevel : 0
             * movieId : 246313
             * nick : 大Ccccc_
             * nickName : 大Cc_
             * oppose : 0
             * pro : false
             * reply : 3
             * score : 4
             * spoiler : 0
             * startTime : 2016-06-25 13:12:43
             * supportComment : true
             * supportLike : true
             * sureViewed : 0
             * time : 2016-06-25 13:12
             * userId : 11079622
             * userLevel : 4
             * vipInfo :
             * vipType : 0
             * tagList : {"fixed":[{"id":5,"name":"认证作者"}]}
             */

            private int approve;
            private boolean approved;
            private String authInfo;
            private String avatarurl;
            private String cityName;
            private String content;
            private long created;
            private boolean filmView;
            private int gender;
            private int id;
            private boolean isMajor;
            private int juryLevel;
            private int movieId;
            private String nick;
            private String nickName;
            private int oppose;
            private boolean pro;
            private int reply;
            private Number score;
            private int spoiler;
            private String startTime;
            private boolean supportComment;
            private boolean supportLike;
            private int sureViewed;
            private String time;
            private int userId;
            private int userLevel;
            private String vipInfo;
            private int vipType;
            private TagListBean tagList;

            public int getApprove() {
                return approve;
            }

            public void setApprove(int approve) {
                this.approve = approve;
            }

            public boolean isApproved() {
                return approved;
            }

            public void setApproved(boolean approved) {
                this.approved = approved;
            }

            public String getAuthInfo() {
                return authInfo;
            }

            public void setAuthInfo(String authInfo) {
                this.authInfo = authInfo;
            }

            public String getAvatarurl() {
                return avatarurl;
            }

            public void setAvatarurl(String avatarurl) {
                this.avatarurl = avatarurl;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public long getCreated() {
                return created;
            }

            public void setCreated(long created) {
                this.created = created;
            }

            public boolean isFilmView() {
                return filmView;
            }

            public void setFilmView(boolean filmView) {
                this.filmView = filmView;
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

            public boolean isIsMajor() {
                return isMajor;
            }

            public void setIsMajor(boolean isMajor) {
                this.isMajor = isMajor;
            }

            public int getJuryLevel() {
                return juryLevel;
            }

            public void setJuryLevel(int juryLevel) {
                this.juryLevel = juryLevel;
            }

            public int getMovieId() {
                return movieId;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getOppose() {
                return oppose;
            }

            public void setOppose(int oppose) {
                this.oppose = oppose;
            }

            public boolean isPro() {
                return pro;
            }

            public void setPro(boolean pro) {
                this.pro = pro;
            }

            public int getReply() {
                return reply;
            }

            public void setReply(int reply) {
                this.reply = reply;
            }

            public Number getScore() {

                return score;
            }

            public void setScore(Number score) {
                this.score = score;
            }

            public int getSpoiler() {
                return spoiler;
            }

            public void setSpoiler(int spoiler) {
                this.spoiler = spoiler;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
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

            public int getSureViewed() {
                return sureViewed;
            }

            public void setSureViewed(int sureViewed) {
                this.sureViewed = sureViewed;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getUserLevel() {
                return userLevel;
            }

            public void setUserLevel(int userLevel) {
                this.userLevel = userLevel;
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

            public TagListBean getTagList() {
                return tagList;
            }

            public void setTagList(TagListBean tagList) {
                this.tagList = tagList;
            }

            public static class TagListBean {
                private List<FixedBean> fixed;

                public List<FixedBean> getFixed() {
                    return fixed;
                }

                public void setFixed(List<FixedBean> fixed) {
                    this.fixed = fixed;
                }

                public static class FixedBean {
                    /**
                     * id : 5
                     * name : 认证作者
                     */

                    private int id;
                    private String name;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }
            }
        }
    }

    public static class PagingBean {
        /**
         * hasMore : true
         * limit : 15
         * offset : 0
         * total : 193
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
}

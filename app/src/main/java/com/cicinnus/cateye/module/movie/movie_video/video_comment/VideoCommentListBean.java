package com.cicinnus.cateye.module.movie.movie_video.video_comment;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.cicinnus.cateye.base.BaseConstant;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */

public class VideoCommentListBean {



    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {


        private ObjBean obj;
        private int total;
        private List<CommentsBean> comments;

        public ObjBean getObj() {
            return obj;
        }

        public void setObj(ObjBean obj) {
            this.obj = obj;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class ObjBean {
            /**
             * comment : 86
             * count : 2843542
             * id : 83397
             * img : http://p1.meituan.net/w.h/movie/e906f4f84be05edc3e1b82bd54113e2048584.jpeg
             * movieId : 334590
             * movieName : 极限特工：终极回归
             * score : 0
             * showSt : 0
             * tl : 终极预告片
             * tm : 92
             * type : 1
             * url : http://maoyan.meituan.net/movie/videos/854x48060703da44cc941e5b89522f42ae242b4.mp4
             * wish : 131897
             */

            private int comment;
            private int count;
            private int id;
            private String img;
            private int movieId;
            private String movieName;
            private int score;
            private int showSt;
            private String tl;
            private int tm;
            private int type;
            private String url;
            private int wish;

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

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
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

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }
        }

        public static class CommentsBean implements MultiItemEntity{
            /**
             * approve : 1
             * avatarUrl : https://img.meituan.net/avatar/09a9e75eee345945e4c753b9ea93a4e774800.jpg
             * content : 你说你是不是有病，演员有演员的尊严，没错，我是吴亦凡的fans，但是如果换成是别的明星，我照样会质疑你的，你如果这样骂，我是会怀疑你的人品的！再说，你凭什么骂吴亦凡！娘娘腔！我就呵呵了，你骂别人的同时，先想清楚你自己！中国是个文明的古国，不允许被这么肮脏的语言所覆盖，所以，你好自为之吧！！！
             * deleted : false
             * id : 97369
             * nickName : Lucy
             * ref : {"approve":1,"avatarUrl":"https://img.meituan.net/avatar/3dc75fbcf9d9d0617a7c8f6cd371e1094241.jpg","content":"你是吴鸡凡 炮友？ 跟娘娘腔干 感觉如何？","deleted":false,"id":97363,"nickName":"老不死影响全世界","time":"2017-02-17 09:35","userId":204813197,"userLevel":2,"vipInfo":"","vipType":0}
             * time : 2017-02-17 09:54
             * userId : 771787991
             * userLevel : 2
             * vipInfo :
             * vipType : 0
             */

            private int approve;
            private String avatarUrl;
            private String content;
            private boolean deleted;
            private int id;
            private String nickName;
            private RefBean ref;
            private String time;
            private int userId;
            private int userLevel;
            private String vipInfo;
            private int vipType;

            public int getApprove() {
                return approve;
            }

            public void setApprove(int approve) {
                this.approve = approve;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

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

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public RefBean getRef() {
                return ref;
            }

            public void setRef(RefBean ref) {
                this.ref = ref;
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

            @Override
            public int getItemType() {
                if(getRef()!=null){
                    return BaseConstant.TYPE_VIDEO_COMMENT_REPLY;
                }
                return BaseConstant.TYPE_VIDEO_COMMENT_NO_REPLY;
            }

            public static class RefBean {
                /**
                 * approve : 1
                 * avatarUrl : https://img.meituan.net/avatar/3dc75fbcf9d9d0617a7c8f6cd371e1094241.jpg
                 * content : 你是吴鸡凡 炮友？ 跟娘娘腔干 感觉如何？
                 * deleted : false
                 * id : 97363
                 * nickName : 老不死影响全世界
                 * time : 2017-02-17 09:35
                 * userId : 204813197
                 * userLevel : 2
                 * vipInfo :
                 * vipType : 0
                 */

                private int approve;
                private String avatarUrl;
                private String content;
                private boolean deleted;
                private int id;
                private String nickName;
                private String time;
                private int userId;
                private int userLevel;
                private String vipInfo;
                private int vipType;

                public int getApprove() {
                    return approve;
                }

                public void setApprove(int approve) {
                    this.approve = approve;
                }

                public String getAvatarUrl() {
                    return avatarUrl;
                }

                public void setAvatarUrl(String avatarUrl) {
                    this.avatarUrl = avatarUrl;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

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

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
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
            }
        }
    }
}

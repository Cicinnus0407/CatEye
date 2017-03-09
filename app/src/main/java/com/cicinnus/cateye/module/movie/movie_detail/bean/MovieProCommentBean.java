package com.cicinnus.cateye.module.movie.movie_detail.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/3/7.
 */

public class MovieProCommentBean {

    /**
     * data : [{"approve":23,"approved":false,"authInfo":"极客电影联合发起人，时光网前主编","avatarurl":"https://img.meituan.net/avatar/ba75f3b26f20cfb0fa933684fc963a19145729.jpg","cityName":"北京","content":"四星之作！期待限制级完整版再添一星。《蝙蝠侠:黑暗骑士》之后，超级英雄电影鲜有如此的悲壮与震撼！休叔封爪，狼叔绝唱，一代X战警落幕，令人唏嘘。末尾小狼女将十字架改作X标志，便是泪闸决堤之时。","created":1488849151000,"filmView":false,"gender":1,"id":99108226,"isMajor":false,"juryLevel":2,"movieId":247875,"nick":"子虚Brad","nickName":"子虚Brad","oppose":0,"pro":true,"reply":0,"score":4,"spoiler":0,"startTime":"2017-03-07 09:12:31","supportComment":false,"supportLike":true,"sureViewed":1,"tagList":{},"time":"2017-03-07 09:12","userId":228944158,"userLevel":5,"vipInfo":"猫眼星级专业评委","vipType":3},{"approve":14,"approved":false,"authInfo":"《齐鲁晚报》资深电影记者、影评人","avatarurl":"https://img.meituan.net/avatar/01e9ecdf77b88dd1f205a0be2d8464d078480.jpg","cityName":"济南","content":"一部中年危机电影，亲情片，有着西部片、公路片的包装形式。现在的动作血腥场景，刚刚好，作为一个相对传统的观众，对删减十多分钟持正面评价。本来是部7分片，给8分的原因，是实在看不上那些一味追求所谓科幻的片，这部片西部电影、公路电影的外壳，虽然老套，却是我喜欢的。","created":1488808016000,"filmView":false,"id":99090659,"isMajor":false,"juryLevel":1,"movieId":247875,"nick":"倪自放","nickName":"倪自放","oppose":0,"pro":true,"reply":0,"score":4,"spoiler":0,"startTime":"2017-03-06 21:49:03","supportComment":false,"supportLike":true,"sureViewed":1,"tagList":{"fixed":[{"id":1,"name":"好评"},{"id":4,"name":"购票"}]},"time":"2017-03-06 21:49","userId":307620960,"userLevel":4,"vipInfo":"猫眼专业评委","vipType":3},{"approve":41,"approved":false,"authInfo":"电影学博士，《电影艺术》编辑","avatarurl":"https://img.meituan.net/avatar/bdaf2279ab008c7564ae9c21c06b355e58882.jpg","cityName":"北京","content":"英雄垂垂老矣、童话落幕散场，看得我心都碎了，从头哭到尾。还好有强悍凶猛的小萝莉，多少带来一点抚慰。 超级英雄系列电影取代古典类型电影，已经是视听效果为导向的好莱坞的一个必然趋势。然而，《金刚狼3》提供了一条全新的路径，使得原本只注重感官享受的超级英雄电影，有可能获得一种原本属于古典类型电影的社会功能属性。与《原野奇侠》的互文关系，让这部另类的超级英雄电影成为类型融合与衍变的新场域\u2014\u2014西部电影和公路电影的主题、场景、对抗模式等都全面被纳入。这些尝试，使《金刚狼3》成为X战警系列最有深度和最具情感力量的一部，虽然观赏性可能稍弱（也可能是删节的缘故）。","created":1488798870000,"filmView":false,"id":99077709,"isMajor":false,"juryLevel":1,"movieId":247875,"nick":"lanxinshui","nickName":"刘起","oppose":0,"pro":true,"reply":0,"score":4.5,"spoiler":0,"startTime":"2017-03-06 19:14:30","supportComment":false,"supportLike":true,"sureViewed":1,"tagList":{"fixed":[{"id":1,"name":"好评"},{"id":4,"name":"购票"}]},"time":"2017-03-06 19:14","userId":328285948,"userLevel":2,"vipInfo":"猫眼专业评委","vipType":3},{"approve":10,"approved":false,"authInfo":"腾讯娱乐电影频道主编","avatarurl":"https://img.meituan.net/avatar/ec84937c47cdddf6188ee70dd36ee21492000.jpg","cityName":"北京","content":"就记住了女狼的脸，过目不忘。希望以后为她单开一篇。这是一部老一代Xman为新一代Xman让路的电影，让路就让路吧，有必要搞这么惨吗？要不要脸？","created":1488787431000,"filmView":false,"gender":1,"id":99060575,"isMajor":false,"juryLevel":2,"movieId":247875,"nick":"红胡子曾","nickName":"大宝剑","oppose":0,"pro":true,"reply":0,"score":3.5,"spoiler":0,"startTime":"2017-03-06 16:03:51","supportComment":false,"supportLike":true,"sureViewed":1,"tagList":{"fixed":[{"id":4,"name":"购票"}]},"time":"2017-03-06 16:03","userId":9491608,"userLevel":5,"vipInfo":"猫眼星级专业评委","vipType":3}]
     * paging : {"hasMore":true,"limit":4,"offset":0,"total":29}
     */

    private PagingBean paging;
    private List<DataBean> data;

    public PagingBean getPaging() {
        return paging;
    }

    public void setPaging(PagingBean paging) {
        this.paging = paging;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class PagingBean {
        /**
         * hasMore : true
         * limit : 4
         * offset : 0
         * total : 29
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

    public static class DataBean {
        /**
         * approve : 23
         * approved : false
         * authInfo : 极客电影联合发起人，时光网前主编
         * avatarurl : https://img.meituan.net/avatar/ba75f3b26f20cfb0fa933684fc963a19145729.jpg
         * cityName : 北京
         * content : 四星之作！期待限制级完整版再添一星。《蝙蝠侠:黑暗骑士》之后，超级英雄电影鲜有如此的悲壮与震撼！休叔封爪，狼叔绝唱，一代X战警落幕，令人唏嘘。末尾小狼女将十字架改作X标志，便是泪闸决堤之时。
         * created : 1488849151000
         * filmView : false
         * gender : 1
         * id : 99108226
         * isMajor : false
         * juryLevel : 2
         * movieId : 247875
         * nick : 子虚Brad
         * nickName : 子虚Brad
         * oppose : 0
         * pro : true
         * reply : 0
         * score : 4
         * spoiler : 0
         * startTime : 2017-03-07 09:12:31
         * supportComment : false
         * supportLike : true
         * sureViewed : 1
         * tagList : {}
         * time : 2017-03-07 09:12
         * userId : 228944158
         * userLevel : 5
         * vipInfo : 猫眼星级专业评委
         * vipType : 3
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
        private double score;
        private int spoiler;
        private String startTime;
        private boolean supportComment;
        private boolean supportLike;
        private int sureViewed;
        private TagListBean tagList;
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

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
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

        public TagListBean getTagList() {
            return tagList;
        }

        public void setTagList(TagListBean tagList) {
            this.tagList = tagList;
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

        public static class TagListBean {
        }
    }
}

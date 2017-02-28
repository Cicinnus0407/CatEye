package com.cicinnus.cateye.module.movie.movie_detail.movie_information;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.cicinnus.cateye.base.BaseConstant;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/27.
 */

public class MovieInformationBean {

    /**
     * data : {"newsList":[{"commentCount":3,"created":1488198755000,"id":19110,"imageCount":0,"previewImages":[{"authorId":0,"height":600,"id":2819176,"sizeType":0,"targetId":19110,"targetType":13,"url":"http://p0.meituan.net/movie/afcb0239a0d8b6643c9b7e4b433fa91e274613.jpg@300w_225h_1e_1c","width":600},{"authorId":0,"height":343,"id":2819177,"sizeType":0,"targetId":19110,"targetType":13,"url":"http://p0.meituan.net/movie/c6cdfa8825837a0ab068cec47e11955559525.jpg@300w_225h_1e_1c","width":343},{"authorId":0,"height":346,"id":2819178,"sizeType":0,"targetId":19110,"targetType":13,"url":"http://p1.meituan.net/movie/c4eedc83ade5b04e942f286b2593bcae61263.jpg@300w_225h_1e_1c","width":346}],"source":"猫眼电影","title":"一周专业口碑榜：两部新片均扑街，票房却截然不同","type":0,"upCount":1,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19110","viewCount":332},{"commentCount":3,"created":1488183490000,"id":19102,"imageCount":0,"previewImages":[{"authorId":0,"height":294,"id":2819122,"sizeType":0,"targetId":19102,"targetType":13,"url":"http://p0.meituan.net/movie/8d67980b7048c86bb4e1cfded042ba7238404.jpg@300w_225h_1e_1c","width":294},{"authorId":0,"height":400,"id":2819123,"sizeType":0,"targetId":19102,"targetType":13,"url":"http://p0.meituan.net/movie/a5de0bc0df171cfe42883e012919e20d73528.jpg@300w_225h_1e_1c","width":400}],"source":"猫眼电影","title":"《生化危机：终章》发布大反派伊恩·格雷特辑","type":0,"upCount":4,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19102","viewCount":1211},{"commentCount":22,"created":1488183150000,"id":19100,"imageCount":0,"previewImages":[{"authorId":0,"height":347,"id":2819118,"sizeType":0,"targetId":19100,"targetType":13,"url":"http://p1.meituan.net/movie/44c71e753d3c76c6a21d18ea871dca8c39232.jpg@300w_225h_1e_1c","width":347}],"source":"猫眼电影","title":"《生化危机：终章》首周破6亿，周票房TOP5全是引进片","type":0,"upCount":43,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19100","viewCount":3317},{"commentCount":79,"created":1488104726000,"id":19080,"imageCount":0,"previewImages":[{"authorId":0,"height":450,"id":2818476,"sizeType":0,"targetId":19080,"targetType":13,"url":"http://p0.meituan.net/movie/a188a6f5746ed53423296dae00494e1d144735.jpg@300w_225h_1e_1c","width":450}],"source":"猫眼电影","title":"《生化危机：终章》突破6亿，票房堪比爱丽丝打怪开了挂！","type":0,"upCount":252,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19080","viewCount":20201},{"commentCount":94,"created":1488068503000,"id":19071,"imageCount":0,"previewImages":[{"authorId":0,"height":450,"id":2818276,"sizeType":0,"targetId":19071,"targetType":13,"url":"http://p0.meituan.net/movie/425707919fcb64ac77c436b4eb93cf35159975.jpg@300w_225h_1e_1c","width":450}],"source":"猫眼电影","title":"《生化危机：终章》上映3天破5亿，当之无愧的票房霸主！","type":0,"upCount":251,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19071","viewCount":18329},{"commentCount":177,"created":1488017069000,"id":19069,"imageCount":0,"previewImages":[{"authorId":0,"height":450,"id":2818145,"sizeType":0,"targetId":19069,"targetType":13,"url":"http://p1.meituan.net/movie/634c4cdfb39028471007ae50490ab3aa146573.jpg@300w_225h_1e_1c","width":450},{"authorId":0,"height":399,"id":2818146,"sizeType":0,"targetId":19069,"targetType":13,"url":"http://p1.meituan.net/movie/e091c3dce65ec1b39b9a2bd30eb52380102244.jpg@300w_225h_1e_1c","width":399}],"source":"猫眼电影","title":"《生化危机：终章》2天破4亿，远超北美总票房","type":0,"upCount":363,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19069","viewCount":29112},{"commentCount":207,"created":1488014130000,"id":19068,"imageCount":0,"previewImages":[{"authorId":0,"height":249,"id":2818139,"sizeType":0,"targetId":19068,"targetType":13,"url":"http://p1.meituan.net/movie/0402ad5dbc01af42e37b24549e952821142825.png@300w_225h_1e_1c","width":249},{"authorId":0,"height":0,"id":2818140,"sizeType":0,"targetId":19068,"targetType":13,"url":"http://p1.meituan.net/movie/fd70736eff6ca4749cf29d51b6241ce5948224.gif@300w_225h_1e_1c","width":0},{"authorId":0,"height":240,"id":2818141,"sizeType":0,"targetId":19068,"targetType":13,"url":"http://p0.meituan.net/movie/d9a756f1f3f0d1e5a01a259c51236bd420480.gif@300w_225h_1e_1c","width":240}],"source":"猫眼电影","title":"用动图告诉你《生化危机》究竟被删了哪7分钟","type":0,"upCount":628,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19068","viewCount":75879},{"commentCount":70,"created":1487987887000,"id":19063,"imageCount":0,"previewImages":[{"authorId":0,"height":500,"id":2818039,"sizeType":0,"targetId":19063,"targetType":13,"url":"http://p0.meituan.net/movie/072e713164529d37fb880f9a20b11b08208171.jpg@300w_225h_1e_1c","width":500},{"authorId":0,"height":667,"id":2818040,"sizeType":0,"targetId":19063,"targetType":13,"url":"http://p0.meituan.net/movie/7e24467e1f1e97bb309c04826ec744ce297343.jpg@300w_225h_1e_1c","width":667}],"source":"猫眼电影","title":"《生化危机: 终章》首日大爆2.27亿居内地影史第五","type":0,"upCount":244,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19063","viewCount":29069},{"commentCount":104,"created":1487938474000,"id":19060,"imageCount":0,"previewImages":[{"authorId":0,"height":720,"id":2817878,"sizeType":0,"targetId":19060,"targetType":13,"url":"http://p0.meituan.net/movie/02589d70fb1f7335aa3b1c4da606d3c11077630.png@300w_225h_1e_1c","width":720},{"authorId":0,"height":1000,"id":2817879,"sizeType":0,"targetId":19060,"targetType":13,"url":"http://p0.meituan.net/movie/0f29c0e406b742bedb9ed010a756ecd1147456.png@300w_225h_1e_1c","width":1000}],"source":"猫眼电影","title":"《生化危机：终章》首日票房破2亿，刷新系列票房纪录！","type":0,"upCount":247,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19060","viewCount":25262},{"commentCount":18,"created":1487904879000,"id":19040,"imageCount":0,"previewImages":[{"authorId":0,"height":667,"id":2817667,"sizeType":0,"targetId":19040,"targetType":13,"url":"http://p1.meituan.net/movie/310876e8d696444359c8c45628b5f8fc206898.jpg@300w_225h_1e_1c","width":667}],"source":"猫眼电影","title":"《生化危机：终章》零点破1500万预售破亿，追平美队3","type":0,"upCount":42,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19040","viewCount":11386}],"paging":{"hasMore":true,"limit":10,"offset":0,"total":0},"timestamp":1488201656295}
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
         * newsList : [{"commentCount":3,"created":1488198755000,"id":19110,"imageCount":0,"previewImages":[{"authorId":0,"height":600,"id":2819176,"sizeType":0,"targetId":19110,"targetType":13,"url":"http://p0.meituan.net/movie/afcb0239a0d8b6643c9b7e4b433fa91e274613.jpg@300w_225h_1e_1c","width":600},{"authorId":0,"height":343,"id":2819177,"sizeType":0,"targetId":19110,"targetType":13,"url":"http://p0.meituan.net/movie/c6cdfa8825837a0ab068cec47e11955559525.jpg@300w_225h_1e_1c","width":343},{"authorId":0,"height":346,"id":2819178,"sizeType":0,"targetId":19110,"targetType":13,"url":"http://p1.meituan.net/movie/c4eedc83ade5b04e942f286b2593bcae61263.jpg@300w_225h_1e_1c","width":346}],"source":"猫眼电影","title":"一周专业口碑榜：两部新片均扑街，票房却截然不同","type":0,"upCount":1,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19110","viewCount":332},{"commentCount":3,"created":1488183490000,"id":19102,"imageCount":0,"previewImages":[{"authorId":0,"height":294,"id":2819122,"sizeType":0,"targetId":19102,"targetType":13,"url":"http://p0.meituan.net/movie/8d67980b7048c86bb4e1cfded042ba7238404.jpg@300w_225h_1e_1c","width":294},{"authorId":0,"height":400,"id":2819123,"sizeType":0,"targetId":19102,"targetType":13,"url":"http://p0.meituan.net/movie/a5de0bc0df171cfe42883e012919e20d73528.jpg@300w_225h_1e_1c","width":400}],"source":"猫眼电影","title":"《生化危机：终章》发布大反派伊恩·格雷特辑","type":0,"upCount":4,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19102","viewCount":1211},{"commentCount":22,"created":1488183150000,"id":19100,"imageCount":0,"previewImages":[{"authorId":0,"height":347,"id":2819118,"sizeType":0,"targetId":19100,"targetType":13,"url":"http://p1.meituan.net/movie/44c71e753d3c76c6a21d18ea871dca8c39232.jpg@300w_225h_1e_1c","width":347}],"source":"猫眼电影","title":"《生化危机：终章》首周破6亿，周票房TOP5全是引进片","type":0,"upCount":43,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19100","viewCount":3317},{"commentCount":79,"created":1488104726000,"id":19080,"imageCount":0,"previewImages":[{"authorId":0,"height":450,"id":2818476,"sizeType":0,"targetId":19080,"targetType":13,"url":"http://p0.meituan.net/movie/a188a6f5746ed53423296dae00494e1d144735.jpg@300w_225h_1e_1c","width":450}],"source":"猫眼电影","title":"《生化危机：终章》突破6亿，票房堪比爱丽丝打怪开了挂！","type":0,"upCount":252,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19080","viewCount":20201},{"commentCount":94,"created":1488068503000,"id":19071,"imageCount":0,"previewImages":[{"authorId":0,"height":450,"id":2818276,"sizeType":0,"targetId":19071,"targetType":13,"url":"http://p0.meituan.net/movie/425707919fcb64ac77c436b4eb93cf35159975.jpg@300w_225h_1e_1c","width":450}],"source":"猫眼电影","title":"《生化危机：终章》上映3天破5亿，当之无愧的票房霸主！","type":0,"upCount":251,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19071","viewCount":18329},{"commentCount":177,"created":1488017069000,"id":19069,"imageCount":0,"previewImages":[{"authorId":0,"height":450,"id":2818145,"sizeType":0,"targetId":19069,"targetType":13,"url":"http://p1.meituan.net/movie/634c4cdfb39028471007ae50490ab3aa146573.jpg@300w_225h_1e_1c","width":450},{"authorId":0,"height":399,"id":2818146,"sizeType":0,"targetId":19069,"targetType":13,"url":"http://p1.meituan.net/movie/e091c3dce65ec1b39b9a2bd30eb52380102244.jpg@300w_225h_1e_1c","width":399}],"source":"猫眼电影","title":"《生化危机：终章》2天破4亿，远超北美总票房","type":0,"upCount":363,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19069","viewCount":29112},{"commentCount":207,"created":1488014130000,"id":19068,"imageCount":0,"previewImages":[{"authorId":0,"height":249,"id":2818139,"sizeType":0,"targetId":19068,"targetType":13,"url":"http://p1.meituan.net/movie/0402ad5dbc01af42e37b24549e952821142825.png@300w_225h_1e_1c","width":249},{"authorId":0,"height":0,"id":2818140,"sizeType":0,"targetId":19068,"targetType":13,"url":"http://p1.meituan.net/movie/fd70736eff6ca4749cf29d51b6241ce5948224.gif@300w_225h_1e_1c","width":0},{"authorId":0,"height":240,"id":2818141,"sizeType":0,"targetId":19068,"targetType":13,"url":"http://p0.meituan.net/movie/d9a756f1f3f0d1e5a01a259c51236bd420480.gif@300w_225h_1e_1c","width":240}],"source":"猫眼电影","title":"用动图告诉你《生化危机》究竟被删了哪7分钟","type":0,"upCount":628,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19068","viewCount":75879},{"commentCount":70,"created":1487987887000,"id":19063,"imageCount":0,"previewImages":[{"authorId":0,"height":500,"id":2818039,"sizeType":0,"targetId":19063,"targetType":13,"url":"http://p0.meituan.net/movie/072e713164529d37fb880f9a20b11b08208171.jpg@300w_225h_1e_1c","width":500},{"authorId":0,"height":667,"id":2818040,"sizeType":0,"targetId":19063,"targetType":13,"url":"http://p0.meituan.net/movie/7e24467e1f1e97bb309c04826ec744ce297343.jpg@300w_225h_1e_1c","width":667}],"source":"猫眼电影","title":"《生化危机: 终章》首日大爆2.27亿居内地影史第五","type":0,"upCount":244,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19063","viewCount":29069},{"commentCount":104,"created":1487938474000,"id":19060,"imageCount":0,"previewImages":[{"authorId":0,"height":720,"id":2817878,"sizeType":0,"targetId":19060,"targetType":13,"url":"http://p0.meituan.net/movie/02589d70fb1f7335aa3b1c4da606d3c11077630.png@300w_225h_1e_1c","width":720},{"authorId":0,"height":1000,"id":2817879,"sizeType":0,"targetId":19060,"targetType":13,"url":"http://p0.meituan.net/movie/0f29c0e406b742bedb9ed010a756ecd1147456.png@300w_225h_1e_1c","width":1000}],"source":"猫眼电影","title":"《生化危机：终章》首日票房破2亿，刷新系列票房纪录！","type":0,"upCount":247,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19060","viewCount":25262},{"commentCount":18,"created":1487904879000,"id":19040,"imageCount":0,"previewImages":[{"authorId":0,"height":667,"id":2817667,"sizeType":0,"targetId":19040,"targetType":13,"url":"http://p1.meituan.net/movie/310876e8d696444359c8c45628b5f8fc206898.jpg@300w_225h_1e_1c","width":667}],"source":"猫眼电影","title":"《生化危机：终章》零点破1500万预售破亿，追平美队3","type":0,"upCount":42,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=19040","viewCount":11386}]
         * paging : {"hasMore":true,"limit":10,"offset":0,"total":0}
         * timestamp : 1488201656295
         */

        private PagingBean paging;
        private long timestamp;
        private List<NewsListBean> newsList;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public List<NewsListBean> getNewsList() {
            return newsList;
        }

        public void setNewsList(List<NewsListBean> newsList) {
            this.newsList = newsList;
        }

        public static class PagingBean {
            /**
             * hasMore : true
             * limit : 10
             * offset : 0
             * total : 0
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

        public static class NewsListBean implements MultiItemEntity{
            /**
             * commentCount : 3
             * created : 1488198755000
             * id : 19110
             * imageCount : 0
             * previewImages : [{"authorId":0,"height":600,"id":2819176,"sizeType":0,"targetId":19110,"targetType":13,"url":"http://p0.meituan.net/movie/afcb0239a0d8b6643c9b7e4b433fa91e274613.jpg@300w_225h_1e_1c","width":600},{"authorId":0,"height":343,"id":2819177,"sizeType":0,"targetId":19110,"targetType":13,"url":"http://p0.meituan.net/movie/c6cdfa8825837a0ab068cec47e11955559525.jpg@300w_225h_1e_1c","width":343},{"authorId":0,"height":346,"id":2819178,"sizeType":0,"targetId":19110,"targetType":13,"url":"http://p1.meituan.net/movie/c4eedc83ade5b04e942f286b2593bcae61263.jpg@300w_225h_1e_1c","width":346}]
             * source : 猫眼电影
             * title : 一周专业口碑榜：两部新片均扑街，票房却截然不同
             * type : 0
             * upCount : 1
             * url : meituanmovie://www.meituan.com/forum/newsDetail?id=19110
             * viewCount : 332
             */

            private int commentCount;
            private long created;
            private int id;
            private int imageCount;
            private String source;
            private String title;
            private int type;
            private int upCount;
            private String url;
            private int viewCount;
            private List<PreviewImagesBean> previewImages;

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

            public int getImageCount() {
                return imageCount;
            }

            public void setImageCount(int imageCount) {
                this.imageCount = imageCount;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

            public List<PreviewImagesBean> getPreviewImages() {
                return previewImages;
            }

            public void setPreviewImages(List<PreviewImagesBean> previewImages) {
                this.previewImages = previewImages;
            }

            @Override
            public int getItemType() {
                if(getPreviewImages().size()==3){
                    return BaseConstant.TYPE_MOVIE_INFORMATION_MULTI_IMG;
                }
                return BaseConstant.TYPE_MOVIE_INFORMATION_ONE_IMG;
            }

            public static class PreviewImagesBean {
                /**
                 * authorId : 0
                 * height : 600
                 * id : 2819176
                 * sizeType : 0
                 * targetId : 19110
                 * targetType : 13
                 * url : http://p0.meituan.net/movie/afcb0239a0d8b6643c9b7e4b433fa91e274613.jpg@300w_225h_1e_1c
                 * width : 600
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

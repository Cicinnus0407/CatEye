package com.cicinnus.cateye.module.movie.movie_detail.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/13.
 */

public class MovieRelatedInformationBean {

    /**
     * data : {"newsList":[{"commentCount":1,"created":1486963694000,"id":18805,"imageCount":0,"previewImages":[{"authorId":0,"height":1000,"id":2812372,"sizeType":0,"targetId":18805,"targetType":13,"url":"http://p0.meituan.net/movie/baa1202c4af720cda8b061199705b5b1348160.jpeg@300w_225h_1e_1c","width":1000}],"source":"猫眼电影","title":"《极限特工3》3天破4亿创特工片纪录，荷尔蒙撩妹有高招","type":0,"upCount":6,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=18805","viewCount":2188},{"commentCount":105,"created":1486957570000,"id":18802,"imageCount":0,"previewImages":[{"authorId":0,"height":347,"id":2812361,"sizeType":0,"targetId":18802,"targetType":13,"url":"http://p1.meituan.net/movie/44c71e753d3c76c6a21d18ea871dca8c39232.jpg@300w_225h_1e_1c","width":347}],"source":"猫眼电影","title":"《极限特工3》首周4.3亿夺冠，内地2天赶超北美4周","type":0,"upCount":63,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=18802","viewCount":43687}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<NewsListBean> newsList;

        public List<NewsListBean> getNewsList() {
            return newsList;
        }

        public void setNewsList(List<NewsListBean> newsList) {
            this.newsList = newsList;
        }

        public static class NewsListBean {
            /**
             * commentCount : 1
             * created : 1486963694000
             * id : 18805
             * imageCount : 0
             * previewImages : [{"authorId":0,"height":1000,"id":2812372,"sizeType":0,"targetId":18805,"targetType":13,"url":"http://p0.meituan.net/movie/baa1202c4af720cda8b061199705b5b1348160.jpeg@300w_225h_1e_1c","width":1000}]
             * source : 猫眼电影
             * title : 《极限特工3》3天破4亿创特工片纪录，荷尔蒙撩妹有高招
             * type : 0
             * upCount : 6
             * url : meituanmovie://www.meituan.com/forum/newsDetail?id=18805
             * viewCount : 2188
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

            public static class PreviewImagesBean {
                /**
                 * authorId : 0
                 * height : 1000
                 * id : 2812372
                 * sizeType : 0
                 * targetId : 18805
                 * targetType : 13
                 * url : http://p0.meituan.net/movie/baa1202c4af720cda8b061199705b5b1348160.jpeg@300w_225h_1e_1c
                 * width : 1000
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

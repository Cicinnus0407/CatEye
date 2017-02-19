package com.cicinnus.cateye.module.movie.movie_star.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/19.
 */

public class RelatedInformationBean {

    /**
     * data : {"newsList":[{"commentCount":32,"created":1483524061000,"id":17972,"imageCount":0,"previewImages":[{"authorId":0,"height":384,"id":2792943,"sizeType":0,"targetId":17972,"targetType":13,"url":"http://p0.meituan.net/movie/a7dafc101c2978c3d3d9496306739a69115428.jpg@300w_225h_1e_1c","width":384}],"source":"猫眼电影","title":"《极限特工3》内地定档2月10日，范迪塞尔再现全明星阵容","type":0,"upCount":65,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=17972","viewCount":6328},{"commentCount":26,"created":1481502773000,"id":17311,"imageCount":0,"previewImages":[{"authorId":0,"height":411,"id":2783802,"sizeType":0,"targetId":17311,"targetType":13,"url":"http://p1.meituan.net/movie/8bd107041e5feae499143df1c139631d70150.jpg@300w_225h_1e_1c","width":411}],"source":"Mtime时光网","title":"《速度与激情8》范迪塞尔与强森镜头前也闹不和？","type":0,"upCount":79,"url":"meituanmovie://www.meituan.com/forum/newsDetail?id=17311","viewCount":5536}]}
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
             * commentCount : 32
             * created : 1483524061000
             * id : 17972
             * imageCount : 0
             * previewImages : [{"authorId":0,"height":384,"id":2792943,"sizeType":0,"targetId":17972,"targetType":13,"url":"http://p0.meituan.net/movie/a7dafc101c2978c3d3d9496306739a69115428.jpg@300w_225h_1e_1c","width":384}]
             * source : 猫眼电影
             * title : 《极限特工3》内地定档2月10日，范迪塞尔再现全明星阵容
             * type : 0
             * upCount : 65
             * url : meituanmovie://www.meituan.com/forum/newsDetail?id=17972
             * viewCount : 6328
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
                 * height : 384
                 * id : 2792943
                 * sizeType : 0
                 * targetId : 17972
                 * targetType : 13
                 * url : http://p0.meituan.net/movie/a7dafc101c2978c3d3d9496306739a69115428.jpg@300w_225h_1e_1c
                 * width : 384
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

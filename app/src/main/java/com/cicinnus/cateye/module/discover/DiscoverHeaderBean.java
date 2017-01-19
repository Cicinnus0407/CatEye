package com.cicinnus.cateye.module.discover;

import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */

public class DiscoverHeaderBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * description :
         * id : 39
         * image : {"authorId":0,"height":86,"id":2719364,"sizeType":0,"targetId":39,"targetType":8,"url":"http://p0.meituan.net/movie/5acd468360744ef1358d2e7276e5c5504617.png","width":86}
         * tag :
         * title : 今日TOP10
         * url : meituanmovie://www.meituan.com/web?url=http://t.meituan.com/Tjf4B5
         */

        private String description;
        private int id;
        private ImageBean image;
        private String tag;
        private String title;
        private String url;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public ImageBean getImage() {
            return image;
        }

        public void setImage(ImageBean image) {
            this.image = image;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public static class ImageBean {
            /**
             * authorId : 0
             * height : 86
             * id : 2719364
             * sizeType : 0
             * targetId : 39
             * targetType : 8
             * url : http://p0.meituan.net/movie/5acd468360744ef1358d2e7276e5c5504617.png
             * width : 86
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

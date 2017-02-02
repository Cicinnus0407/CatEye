package com.cicinnus.cateye.module.movie.find_movie.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/2.
 */

public class MovieTypeBean {

    /**
     * data : [{"tagList":[{"tagName":"爱情","tagId":3},{"tagName":"喜剧","tagId":2},{"tagName":"动画","tagId":4},{"tagName":"剧情","tagId":1},{"tagName":"恐怖","tagId":6},{"tagName":"惊悚","tagId":7},{"tagName":"科幻","tagId":10},{"tagName":"动作","tagId":5},{"tagName":"悬疑","tagId":8},{"tagName":"犯罪","tagId":11},{"tagName":"冒险","tagId":9},{"tagName":"战争","tagId":12},{"tagName":"奇幻","tagId":14},{"tagName":"运动","tagId":15},{"tagName":"家庭","tagId":16},{"tagName":"古装","tagId":17},{"tagName":"武侠","tagId":18},{"tagName":"西部","tagId":19},{"tagName":"历史","tagId":20},{"tagName":"传记","tagId":21},{"tagName":"情色","tagId":22},{"tagName":"歌舞","tagId":23},{"tagName":"黑色电影","tagId":24},{"tagName":"短片","tagId":25},{"tagName":"纪录片","tagId":13},{"tagName":"其他","tagId":100}],"tagTypeName":"cat"},{"tagList":[{"tagName":"大陆","tagId":2},{"tagName":"美国","tagId":3},{"tagName":"韩国","tagId":7},{"tagName":"日本","tagId":6},{"tagName":"中国香港","tagId":10},{"tagName":"中国台湾","tagId":13},{"tagName":"泰国","tagId":9},{"tagName":"印度","tagId":8},{"tagName":"法国","tagId":4},{"tagName":"英国","tagId":5},{"tagName":"俄罗斯","tagId":14},{"tagName":"意大利","tagId":16},{"tagName":"西班牙","tagId":17},{"tagName":"德国","tagId":11},{"tagName":"波兰","tagId":19},{"tagName":"澳大利亚","tagId":20},{"tagName":"伊朗","tagId":21},{"tagName":"其他","tagId":100}],"tagTypeName":"source"},{"tagList":[{"tagName":"2017以后","tagId":13},{"tagName":"2017","tagId":12},{"tagName":"2016","tagId":11},{"tagName":"2015","tagId":10},{"tagName":"2014","tagId":9},{"tagName":"2013","tagId":8},{"tagName":"2012","tagId":7},{"tagName":"2011","tagId":6},{"tagName":"2000-2010","tagId":5},{"tagName":"90年代","tagId":4},{"tagName":"80年代","tagId":3},{"tagName":"70年代","tagId":2},{"tagName":"更早","tagId":1}],"tagTypeName":"year"},{"tagList":[{"tagName":"好评","tagId":3,"isDefault":1},{"tagName":"最新","tagId":2,"isDefault":0},{"tagName":"热门","tagId":1,"isDefault":0}],"tagTypeName":"sort"}]
     * title : 电影分类
     * tag : category
     */

    private String title;
    private String tag;
    private List<DataBean> data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * tagList : [{"tagName":"爱情","tagId":3},{"tagName":"喜剧","tagId":2},{"tagName":"动画","tagId":4},{"tagName":"剧情","tagId":1},{"tagName":"恐怖","tagId":6},{"tagName":"惊悚","tagId":7},{"tagName":"科幻","tagId":10},{"tagName":"动作","tagId":5},{"tagName":"悬疑","tagId":8},{"tagName":"犯罪","tagId":11},{"tagName":"冒险","tagId":9},{"tagName":"战争","tagId":12},{"tagName":"奇幻","tagId":14},{"tagName":"运动","tagId":15},{"tagName":"家庭","tagId":16},{"tagName":"古装","tagId":17},{"tagName":"武侠","tagId":18},{"tagName":"西部","tagId":19},{"tagName":"历史","tagId":20},{"tagName":"传记","tagId":21},{"tagName":"情色","tagId":22},{"tagName":"歌舞","tagId":23},{"tagName":"黑色电影","tagId":24},{"tagName":"短片","tagId":25},{"tagName":"纪录片","tagId":13},{"tagName":"其他","tagId":100}]
         * tagTypeName : cat
         */

        private String tagTypeName;
        private List<TagListBean> tagList;

        public String getTagTypeName() {
            return tagTypeName;
        }

        public void setTagTypeName(String tagTypeName) {
            this.tagTypeName = tagTypeName;
        }

        public List<TagListBean> getTagList() {
            return tagList;
        }

        public void setTagList(List<TagListBean> tagList) {
            this.tagList = tagList;
        }

        public static class TagListBean {
            /**
             * tagName : 爱情
             * tagId : 3
             */

            private String tagName;
            private int tagId;

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }

            public int getTagId() {
                return tagId;
            }

            public void setTagId(int tagId) {
                this.tagId = tagId;
            }
        }
    }
}

package com.cicinnus.cateye.module.movie.movie_detail.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */

public class MovieTipsBean {


    /**
     * data : {"tipsTitle":"观影小贴士","tips":[{"content":"有1个彩蛋，片尾字幕中间","tipImg":"http://p0.meituan.net/mmdb/8f52014d6b15bf93415d10cdcd16cbf52917.png","tipJumpURL":"","tipName":""}]}
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
         * tipsTitle : 观影小贴士
         * tips : [{"content":"有1个彩蛋，片尾字幕中间","tipImg":"http://p0.meituan.net/mmdb/8f52014d6b15bf93415d10cdcd16cbf52917.png","tipJumpURL":"","tipName":""}]
         */

        private String tipsTitle;
        private List<TipsBean> tips;

        public String getTipsTitle() {
            return tipsTitle;
        }

        public void setTipsTitle(String tipsTitle) {
            this.tipsTitle = tipsTitle;
        }

        public List<TipsBean> getTips() {
            return tips;
        }

        public void setTips(List<TipsBean> tips) {
            this.tips = tips;
        }

        public static class TipsBean {
            /**
             * content : 有1个彩蛋，片尾字幕中间
             * tipImg : http://p0.meituan.net/mmdb/8f52014d6b15bf93415d10cdcd16cbf52917.png
             * tipJumpURL :
             * tipName :
             */

            private String content;
            private String tipImg;
            private String tipJumpURL;
            private String tipName;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getTipImg() {
                return tipImg;
            }

            public void setTipImg(String tipImg) {
                this.tipImg = tipImg;
            }

            public String getTipJumpURL() {
                return tipJumpURL;
            }

            public void setTipJumpURL(String tipJumpURL) {
                this.tipJumpURL = tipJumpURL;
            }

            public String getTipName() {
                return tipName;
            }

            public void setTipName(String tipName) {
                this.tipName = tipName;
            }
        }
    }
}

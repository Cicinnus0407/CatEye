package com.cicinnus.cateye.module.cinema.cinema_detail.cinema_info_detail.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.cicinnus.cateye.base.BaseConstant;

import java.util.List;

/**
 * Created by Cicinnus on 2017/6/26.
 */

public class CinemaInfoBean {

    /**
     * code : 0
     * data : {"addr":"天河区马场路36号太阳新天地八楼（近中国联通）","cinemaId":2505,"featureTags":[{"desc":"限网上选座后取票","tag":"取票机","type":0,"url":"http://m.maoyan.com/poi/machine/1535757"},{"desc":"5号杜比全景声厅，241个座位；6号杜比全景声厅，241个座位","tag":"杜比全景声厅","type":15},{"desc":"不免费提供3D眼镜，需自备或柜台购买","tag":"3D眼镜收费","type":4},{"desc":"1.3m（不含）以下儿童免票无座，需家长陪同,仅限2D,3D需购儿童票。1.3m（含）以上可凭学生证购买学生票","tag":"儿童优惠","type":7},{"desc":"影城消费满100可享受2小时免费停车，最多累积4小时。","tag":"可停车","type":5},{"desc":"影院商场提供免费WIFI","tag":"WiFi","type":9},{"desc":"无","tag":"情侣座","type":6}],"follow":0,"lat":23.12362,"lng":113.3443,"nm":"中影国际影城(太阳新天地店)","notice":"无","poiId":1535757,"s":7.423077,"s1":7.730769,"s2":7.730769,"s3":7.9423075,"sell":true,"snum":104,"tel":"020-37260533","vipInfo":{"desc":"首单最高立减30元","icon":"http://p1.meituan.net/movie/889d5aaca9316ddcec5831a095ac6a8b1145.png","title":"折扣卡","type":2,"url":"meituanmovie://www.meituan.com/web?url=http%3A%2F%2Fm.maoyan.com%2Fmembercard%2Fdetail%2F1246059%3F_v_%3Dyes%26version%3D4%26channelId%3D1%26cinemaId%3D2505%26fromShow%3D1"}}
     * success : true
     */

    private int code;
    private DataBean data;
    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * addr : 天河区马场路36号太阳新天地八楼（近中国联通）
         * cinemaId : 2505
         * featureTags : [{"desc":"限网上选座后取票","tag":"取票机","type":0,"url":"http://m.maoyan.com/poi/machine/1535757"},{"desc":"5号杜比全景声厅，241个座位；6号杜比全景声厅，241个座位","tag":"杜比全景声厅","type":15},{"desc":"不免费提供3D眼镜，需自备或柜台购买","tag":"3D眼镜收费","type":4},{"desc":"1.3m（不含）以下儿童免票无座，需家长陪同,仅限2D,3D需购儿童票。1.3m（含）以上可凭学生证购买学生票","tag":"儿童优惠","type":7},{"desc":"影城消费满100可享受2小时免费停车，最多累积4小时。","tag":"可停车","type":5},{"desc":"影院商场提供免费WIFI","tag":"WiFi","type":9},{"desc":"无","tag":"情侣座","type":6}]
         * follow : 0
         * lat : 23.12362
         * lng : 113.3443
         * nm : 中影国际影城(太阳新天地店)
         * notice : 无
         * poiId : 1535757
         * s : 7.423077
         * s1 : 7.730769
         * s2 : 7.730769
         * s3 : 7.9423075
         * sell : true
         * snum : 104
         * tel : 020-37260533
         * vipInfo : {"desc":"首单最高立减30元","icon":"http://p1.meituan.net/movie/889d5aaca9316ddcec5831a095ac6a8b1145.png","title":"折扣卡","type":2,"url":"meituanmovie://www.meituan.com/web?url=http%3A%2F%2Fm.maoyan.com%2Fmembercard%2Fdetail%2F1246059%3F_v_%3Dyes%26version%3D4%26channelId%3D1%26cinemaId%3D2505%26fromShow%3D1"}
         */

        private String addr;
        private int cinemaId;
        private int follow;
        private double lat;
        private double lng;
        private String nm;
        private String notice;
        private int poiId;
        private double s;
        private double s1;
        private double s2;
        private double s3;
        private boolean sell;
        private int snum;
        private String tel;
        private VipInfoBean vipInfo;
        private List<FeatureTagsBean> featureTags;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
        }

        public int getFollow() {
            return follow;
        }

        public void setFollow(int follow) {
            this.follow = follow;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public String getNm() {
            return nm;
        }

        public void setNm(String nm) {
            this.nm = nm;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }

        public int getPoiId() {
            return poiId;
        }

        public void setPoiId(int poiId) {
            this.poiId = poiId;
        }

        public double getS() {
            return s;
        }

        public void setS(double s) {
            this.s = s;
        }

        public double getS1() {
            return s1;
        }

        public void setS1(double s1) {
            this.s1 = s1;
        }

        public double getS2() {
            return s2;
        }

        public void setS2(double s2) {
            this.s2 = s2;
        }

        public double getS3() {
            return s3;
        }

        public void setS3(double s3) {
            this.s3 = s3;
        }

        public boolean isSell() {
            return sell;
        }

        public void setSell(boolean sell) {
            this.sell = sell;
        }

        public int getSnum() {
            return snum;
        }

        public void setSnum(int snum) {
            this.snum = snum;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public VipInfoBean getVipInfo() {
            return vipInfo;
        }

        public void setVipInfo(VipInfoBean vipInfo) {
            this.vipInfo = vipInfo;
        }

        public List<FeatureTagsBean> getFeatureTags() {
            return featureTags;
        }

        public void setFeatureTags(List<FeatureTagsBean> featureTags) {
            this.featureTags = featureTags;
        }

        public static class VipInfoBean {
            /**
             * desc : 首单最高立减30元
             * icon : http://p1.meituan.net/movie/889d5aaca9316ddcec5831a095ac6a8b1145.png
             * title : 折扣卡
             * type : 2
             * url : meituanmovie://www.meituan.com/web?url=http%3A%2F%2Fm.maoyan.com%2Fmembercard%2Fdetail%2F1246059%3F_v_%3Dyes%26version%3D4%26channelId%3D1%26cinemaId%3D2505%26fromShow%3D1
             */

            private String desc;
            private String icon;
            private String title;
            private int type;
            private String url;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class FeatureTagsBean implements MultiItemEntity{
            /**
             * desc : 限网上选座后取票
             * tag : 取票机
             * type : 0
             * url : http://m.maoyan.com/poi/machine/1535757
             */

            private String desc;
            private String tag;
            private int type;
            private String url;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
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

            @Override
            public int getItemType() {
                if(url!=null&&url.length()>0){
                    return BaseConstant.TYPE_CINEMA_FEATURE_URL;
                }else {
                    return BaseConstant.TYPE_CINEMA_FEATURE_ONE;
                }
            }
        }
    }
}

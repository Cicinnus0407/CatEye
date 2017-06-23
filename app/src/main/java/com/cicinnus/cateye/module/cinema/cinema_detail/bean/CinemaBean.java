package com.cicinnus.cateye.module.cinema.cinema_detail.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/6/22.
 */

public class CinemaBean {

    /**
     * code : 0
     * data : {"addr":"番禺区小谷围街贝岗村中二横路1号高高新天地商业广场B2B001铺","cinemaId":14409,"featureTags":[{"desc":"未取票用户放映前30分钟可改签","tag":"改签","url":"http://m.maoyan.com/order/endorseinfo?_v_=yes&time=30&cinemaId=14409&userId=-1"},{"desc":"限网上选座后取票","tag":"取票机","url":"http://m.maoyan.com/poi/machine/86715464"},{"desc":"免押金","tag":"3D眼镜"},{"desc":"1.1以下儿童在一名大人带领下可免费看电影（提供3D眼镜），满场无座","tag":"儿童优惠"},{"desc":"影院免费提供WIFI","tag":"WiFi"}],"follow":0,"lat":23.061058,"lng":113.39208,"mallInfo":{"features":[],"img":"http://p0.meituan.net/w.h/poi/3ffc375359a1d64691e88cdb5cc7dd1f137216.jpg","mallUrl":"http://i.meituan.com/brunch/shoppingmall/detail?smid=4070427","name":"GOGO新天地","promotion":"原始烤肉、李记虾蟹煲(GoGo新天地店)等174家商户优惠中"},"nm":"金逸珠江国际影城(大学城店)","poiId":86715464,"s":7.4,"saleInfo":{"content":"小吃、周边17.5元起","desc":"小吃周边","hasProm":0,"icon":"http://p1.meituan.net/movie/a3d93ec007da41e4ba0bfffbbb3bd4b21885.png","lstPrice":17.5,"title":"观影套餐"},"sell":true,"shopId":57285425,"tel":"020-39340185"}
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
         * addr : 番禺区小谷围街贝岗村中二横路1号高高新天地商业广场B2B001铺
         * cinemaId : 14409
         * featureTags : [{"desc":"未取票用户放映前30分钟可改签","tag":"改签","url":"http://m.maoyan.com/order/endorseinfo?_v_=yes&time=30&cinemaId=14409&userId=-1"},{"desc":"限网上选座后取票","tag":"取票机","url":"http://m.maoyan.com/poi/machine/86715464"},{"desc":"免押金","tag":"3D眼镜"},{"desc":"1.1以下儿童在一名大人带领下可免费看电影（提供3D眼镜），满场无座","tag":"儿童优惠"},{"desc":"影院免费提供WIFI","tag":"WiFi"}]
         * follow : 0
         * lat : 23.061058
         * lng : 113.39208
         * mallInfo : {"features":[],"img":"http://p0.meituan.net/w.h/poi/3ffc375359a1d64691e88cdb5cc7dd1f137216.jpg","mallUrl":"http://i.meituan.com/brunch/shoppingmall/detail?smid=4070427","name":"GOGO新天地","promotion":"原始烤肉、李记虾蟹煲(GoGo新天地店)等174家商户优惠中"}
         * nm : 金逸珠江国际影城(大学城店)
         * poiId : 86715464
         * s : 7.4
         * saleInfo : {"content":"小吃、周边17.5元起","desc":"小吃周边","hasProm":0,"icon":"http://p1.meituan.net/movie/a3d93ec007da41e4ba0bfffbbb3bd4b21885.png","lstPrice":17.5,"title":"观影套餐"}
         * sell : true
         * shopId : 57285425
         * tel : 020-39340185
         */

        private String addr;
        private int cinemaId;
        private int follow;
        private double lat;
        private double lng;
        private MallInfoBean mallInfo;
        private String nm;
        private int poiId;
        private double s;
        private SaleInfoBean saleInfo;
        private boolean sell;
        private int shopId;
        private String tel;
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

        public MallInfoBean getMallInfo() {
            return mallInfo;
        }

        public void setMallInfo(MallInfoBean mallInfo) {
            this.mallInfo = mallInfo;
        }

        public String getNm() {
            return nm;
        }

        public void setNm(String nm) {
            this.nm = nm;
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

        public SaleInfoBean getSaleInfo() {
            return saleInfo;
        }

        public void setSaleInfo(SaleInfoBean saleInfo) {
            this.saleInfo = saleInfo;
        }

        public boolean isSell() {
            return sell;
        }

        public void setSell(boolean sell) {
            this.sell = sell;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public List<FeatureTagsBean> getFeatureTags() {
            return featureTags;
        }

        public void setFeatureTags(List<FeatureTagsBean> featureTags) {
            this.featureTags = featureTags;
        }

        public static class MallInfoBean {
            /**
             * features : []
             * img : http://p0.meituan.net/w.h/poi/3ffc375359a1d64691e88cdb5cc7dd1f137216.jpg
             * mallUrl : http://i.meituan.com/brunch/shoppingmall/detail?smid=4070427
             * name : GOGO新天地
             * promotion : 原始烤肉、李记虾蟹煲(GoGo新天地店)等174家商户优惠中
             */

            private String img;
            private String mallUrl;
            private String name;
            private String promotion;
            private List<?> features;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getMallUrl() {
                return mallUrl;
            }

            public void setMallUrl(String mallUrl) {
                this.mallUrl = mallUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPromotion() {
                return promotion;
            }

            public void setPromotion(String promotion) {
                this.promotion = promotion;
            }

            public List<?> getFeatures() {
                return features;
            }

            public void setFeatures(List<?> features) {
                this.features = features;
            }
        }

        public static class SaleInfoBean {
            /**
             * content : 小吃、周边17.5元起
             * desc : 小吃周边
             * hasProm : 0
             * icon : http://p1.meituan.net/movie/a3d93ec007da41e4ba0bfffbbb3bd4b21885.png
             * lstPrice : 17.5
             * title : 观影套餐
             */

            private String content;
            private String desc;
            private int hasProm;
            private String icon;
            private double lstPrice;
            private String title;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getHasProm() {
                return hasProm;
            }

            public void setHasProm(int hasProm) {
                this.hasProm = hasProm;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public double getLstPrice() {
                return lstPrice;
            }

            public void setLstPrice(double lstPrice) {
                this.lstPrice = lstPrice;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class FeatureTagsBean {
            /**
             * desc : 未取票用户放映前30分钟可改签
             * tag : 改签
             * url : http://m.maoyan.com/order/endorseinfo?_v_=yes&time=30&cinemaId=14409&userId=-1
             */

            private String desc;
            private String tag;
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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}

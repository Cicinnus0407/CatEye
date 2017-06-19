package com.cicinnus.cateye.module.cinema.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class CinemaListBean {


    /**
     * code : 0
     * data : {"cinemas":[{"addr":"天河区马场路36号太阳新天地八楼（近中国联通）","cityId":20,"dis":779.0377208409321,"distance":"0.8km","follow":0,"id":2505,"labels":[{"color":"#ff9900","name":"小吃"},{"color":"#ff9900","name":"会员卡"}],"lat":23.12362,"lng":113.3443,"mark":0,"nm":"中影国际影城(太阳新天地店)","poiId":1535757,"price":18.9,"promotion":{"cardPromotionTag":"开卡特惠，首单最高立减30元！","platformActivityTag":"异形：契约等2部影片特惠"},"referencePrice":"40","score":742.30774,"sellPrice":"18.9","shopId":5250506,"tag":{"allowRefund":0,"buyout":0,"deal":0,"endorse":0,"hallType":["杜比全景声厅"],"hallTypeVOList":[],"sell":1,"snack":1,"vipTag":"会员卡"}},{"addr":"天河区黄埔大道西120号高志大厦4楼","cityId":20,"dis":1264.9928880485627,"distance":"1.3km","follow":0,"id":16180,"labels":[{"color":"#579daf","name":"退"},{"color":"#579daf","name":"改签"},{"color":"#ff9900","name":"小吃"},{"color":"#ff9900","name":"折扣卡"}],"lat":23.125715,"lng":113.340126,"mark":0,"nm":"中影南方WE影城(高志店)","poiId":82852411,"price":12.7,"promotion":{"cardPromotionTag":"开卡特惠，首单最高立减30元！","merchantActivityTag":"影院特惠促销","platformActivityTag":"异形：契约等4部影片特惠"},"referencePrice":"0","score":731.0345,"sellPrice":"12.7","shopId":67331849,"tag":{"allowRefund":1,"buyout":0,"deal":0,"endorse":1,"hallTypeVOList":[],"sell":1,"snack":1,"vipTag":"折扣卡"}}],"ct_pois":[{"ct_poi":"936879945111165696_a2505_c0","poiid":1535757},{"ct_poi":"936879945111165696_a16180_c1","poiid":82852411},{"ct_poi":"936879945111165696_a176_c2","poiid":1436408},{"ct_poi":"936879945111165696_a211_c3","poiid":85597},{"ct_poi":"936879945111165696_a16407_c4","poiid":113559614},{"ct_poi":"936879945111165696_a2062_c5","poiid":1465628},{"ct_poi":"936879945111165696_a208_c6","poiid":623314},{"ct_poi":"936879945111165696_a11016_c7","poiid":41236222},{"ct_poi":"936879945111165696_a12749_c8","poiid":40973226},{"ct_poi":"936879945111165696_a1676_c9","poiid":1448425}],"paging":{"hasMore":true,"limit":10,"offset":0,"total":150}}
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
         * cinemas : [{"addr":"天河区马场路36号太阳新天地八楼（近中国联通）","cityId":20,"dis":779.0377208409321,"distance":"0.8km","follow":0,"id":2505,"labels":[{"color":"#ff9900","name":"小吃"},{"color":"#ff9900","name":"会员卡"}],"lat":23.12362,"lng":113.3443,"mark":0,"nm":"中影国际影城(太阳新天地店)","poiId":1535757,"price":18.9,"promotion":{"cardPromotionTag":"开卡特惠，首单最高立减30元！","platformActivityTag":"异形：契约等2部影片特惠"},"referencePrice":"40","score":742.30774,"sellPrice":"18.9","shopId":5250506,"tag":{"allowRefund":0,"buyout":0,"deal":0,"endorse":0,"hallType":["杜比全景声厅"],"hallTypeVOList":[],"sell":1,"snack":1,"vipTag":"会员卡"}},{"addr":"天河区黄埔大道西120号高志大厦4楼","cityId":20,"dis":1264.9928880485627,"distance":"1.3km","follow":0,"id":16180,"labels":[{"color":"#579daf","name":"退"},{"color":"#579daf","name":"改签"},{"color":"#ff9900","name":"小吃"},{"color":"#ff9900","name":"折扣卡"}],"lat":23.125715,"lng":113.340126,"mark":0,"nm":"中影南方WE影城(高志店)","poiId":82852411,"price":12.7,"promotion":{"cardPromotionTag":"开卡特惠，首单最高立减30元！","merchantActivityTag":"影院特惠促销","platformActivityTag":"异形：契约等4部影片特惠"},"referencePrice":"0","score":731.0345,"sellPrice":"12.7","shopId":67331849,"tag":{"allowRefund":1,"buyout":0,"deal":0,"endorse":1,"hallTypeVOList":[],"sell":1,"snack":1,"vipTag":"折扣卡"}}]
         * ct_pois : [{"ct_poi":"936879945111165696_a2505_c0","poiid":1535757},{"ct_poi":"936879945111165696_a16180_c1","poiid":82852411},{"ct_poi":"936879945111165696_a176_c2","poiid":1436408},{"ct_poi":"936879945111165696_a211_c3","poiid":85597},{"ct_poi":"936879945111165696_a16407_c4","poiid":113559614},{"ct_poi":"936879945111165696_a2062_c5","poiid":1465628},{"ct_poi":"936879945111165696_a208_c6","poiid":623314},{"ct_poi":"936879945111165696_a11016_c7","poiid":41236222},{"ct_poi":"936879945111165696_a12749_c8","poiid":40973226},{"ct_poi":"936879945111165696_a1676_c9","poiid":1448425}]
         * paging : {"hasMore":true,"limit":10,"offset":0,"total":150}
         */

        private PagingBean paging;
        private List<CinemasBean> cinemas;
        private List<CtPoisBean> ct_pois;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<CinemasBean> getCinemas() {
            return cinemas;
        }

        public void setCinemas(List<CinemasBean> cinemas) {
            this.cinemas = cinemas;
        }

        public List<CtPoisBean> getCt_pois() {
            return ct_pois;
        }

        public void setCt_pois(List<CtPoisBean> ct_pois) {
            this.ct_pois = ct_pois;
        }

        public static class PagingBean {
            /**
             * hasMore : true
             * limit : 10
             * offset : 0
             * total : 150
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

        public static class CinemasBean {
            /**
             * addr : 天河区马场路36号太阳新天地八楼（近中国联通）
             * cityId : 20
             * dis : 779.0377208409321
             * distance : 0.8km
             * follow : 0
             * id : 2505
             * labels : [{"color":"#ff9900","name":"小吃"},{"color":"#ff9900","name":"会员卡"}]
             * lat : 23.12362
             * lng : 113.3443
             * mark : 0
             * nm : 中影国际影城(太阳新天地店)
             * poiId : 1535757
             * price : 18.9
             * promotion : {"cardPromotionTag":"开卡特惠，首单最高立减30元！","platformActivityTag":"异形：契约等2部影片特惠"}
             * referencePrice : 40
             * score : 742.30774
             * sellPrice : 18.9
             * shopId : 5250506
             * tag : {"allowRefund":0,"buyout":0,"deal":0,"endorse":0,"hallType":["杜比全景声厅"],"hallTypeVOList":[],"sell":1,"snack":1,"vipTag":"会员卡"}
             */

            private String addr;
            private int cityId;
            private double dis;
            private String distance;
            private int follow;
            private int id;
            private double lat;
            private double lng;
            private int mark;
            private String nm;
            private int poiId;
            private double price;
            private PromotionBean promotion;
            private String referencePrice;
            private double score;
            private String sellPrice;
            private int shopId;
            private TagBean tag;
            private List<LabelsBean> labels;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public double getDis() {
                return dis;
            }

            public void setDis(double dis) {
                this.dis = dis;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public int getMark() {
                return mark;
            }

            public void setMark(int mark) {
                this.mark = mark;
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

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public PromotionBean getPromotion() {
                return promotion;
            }

            public void setPromotion(PromotionBean promotion) {
                this.promotion = promotion;
            }

            public String getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(String referencePrice) {
                this.referencePrice = referencePrice;
            }

            public double getScore() {
                return score;
            }

            public void setScore(double score) {
                this.score = score;
            }

            public String getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(String sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public TagBean getTag() {
                return tag;
            }

            public void setTag(TagBean tag) {
                this.tag = tag;
            }

            public List<LabelsBean> getLabels() {
                return labels;
            }

            public void setLabels(List<LabelsBean> labels) {
                this.labels = labels;
            }

            public static class PromotionBean {
                /**
                 * cardPromotionTag : 开卡特惠，首单最高立减30元！
                 * platformActivityTag : 异形：契约等2部影片特惠
                 */

                private String cardPromotionTag;
                private String platformActivityTag;
                private String merchantActivityTag;

                public String getCardPromotionTag() {
                    return cardPromotionTag;
                }

                public void setCardPromotionTag(String cardPromotionTag) {
                    this.cardPromotionTag = cardPromotionTag;
                }

                public String getPlatformActivityTag() {
                    return platformActivityTag;
                }

                public void setPlatformActivityTag(String platformActivityTag) {
                    this.platformActivityTag = platformActivityTag;
                }

                public String getMerchantActivityTag() {
                    return merchantActivityTag;
                }

                public void setMerchantActivityTag(String merchantActivityTag) {
                    this.merchantActivityTag = merchantActivityTag;
                }
            }

            public static class TagBean {
                /**
                 * allowRefund : 0
                 * buyout : 0
                 * deal : 0
                 * endorse : 0
                 * hallType : ["杜比全景声厅"]
                 * hallTypeVOList : []
                 * sell : 1
                 * snack : 1
                 * vipTag : 会员卡
                 */

                private int allowRefund;
                private int buyout;
                private int deal;
                private int endorse;
                private int sell;
                private int snack;
                private String vipTag;
                private List<String> hallType;
                private List<?> hallTypeVOList;

                public int getAllowRefund() {
                    return allowRefund;
                }

                public void setAllowRefund(int allowRefund) {
                    this.allowRefund = allowRefund;
                }

                public int getBuyout() {
                    return buyout;
                }

                public void setBuyout(int buyout) {
                    this.buyout = buyout;
                }

                public int getDeal() {
                    return deal;
                }

                public void setDeal(int deal) {
                    this.deal = deal;
                }

                public int getEndorse() {
                    return endorse;
                }

                public void setEndorse(int endorse) {
                    this.endorse = endorse;
                }

                public int getSell() {
                    return sell;
                }

                public void setSell(int sell) {
                    this.sell = sell;
                }

                public int getSnack() {
                    return snack;
                }

                public void setSnack(int snack) {
                    this.snack = snack;
                }

                public String getVipTag() {
                    return vipTag;
                }

                public void setVipTag(String vipTag) {
                    this.vipTag = vipTag;
                }

                public List<String> getHallType() {
                    return hallType;
                }

                public void setHallType(List<String> hallType) {
                    this.hallType = hallType;
                }

                public List<?> getHallTypeVOList() {
                    return hallTypeVOList;
                }

                public void setHallTypeVOList(List<?> hallTypeVOList) {
                    this.hallTypeVOList = hallTypeVOList;
                }
            }

            public static class LabelsBean {
                /**
                 * color : #ff9900
                 * name : 小吃
                 */

                private String color;
                private String name;

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        public static class CtPoisBean {
            /**
             * ct_poi : 936879945111165696_a2505_c0
             * poiid : 1535757
             */

            private String ct_poi;
            private int poiid;

            public String getCt_poi() {
                return ct_poi;
            }

            public void setCt_poi(String ct_poi) {
                this.ct_poi = ct_poi;
            }

            public int getPoiid() {
                return poiid;
            }

            public void setPoiid(int poiid) {
                this.poiid = poiid;
            }
        }
    }
}

package com.cicinnus.cateye.module.cinema.cinema_detail.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/6/22.
 */

public class FoodsBean {

    /**
     * errCode : 1
     * data : {"stid":"1585401697750747136","dealList":[{"dealId":100006824,"verifyBeginTime":1461911086000,"verifyEndTime":1498456800000,"firstTitle":"单人套餐","secondTitle":"爆米花1桶+可乐1杯","title":"[单人套餐]爆米花1桶+可乐1杯","imageUrl":"http://p0.meituan.net/w.h/deal/a4aee9d4358e0ed67e289ef47562700723993.jpg@90_0_279_279a%7C267h_267w_2e_90Q","maxNumberPerUser":100,"maxNumberPerOrder":100,"maxNumberPerMobile":100,"curNumber":2345,"recommendPersonNum":1,"cardTag":null,"newDeal":null,"price":17.5,"priceChange":false,"promotionId":0,"promotionPrice":17.5,"buyButton":0,"useBeginTime":1461911086000,"useEndTime":1498492799000,"promotionLogo":null,"promotionTag":null,"groupDealFlag":false,"unionPromotionTag":null,"discountCardTag":"","curNumberDesc":null,"redirectUrl":"http://m.maoyan.com/deal/14409/100006824?_v_=yes&cityId=*&longitude=*&latitude=*&channelId=1&cinemaId=14409&versionName=8.0.1","value":21,"category":11},{"dealId":100001894,"verifyBeginTime":1461917565000,"verifyEndTime":1498456800000,"firstTitle":"双人套餐","secondTitle":"46oz爆米花1桶+16oz可乐2杯","title":"[双人套餐]46oz爆米花1桶+16oz可乐2杯","imageUrl":"http://p0.meituan.net/w.h/deal/5e6045c4d5d6cb818adb1eb0c0109d8b37080.jpg@102_0_315_315a%7C267h_267w_2e_90Q","maxNumberPerUser":100,"maxNumberPerOrder":100,"maxNumberPerMobile":100,"curNumber":3871,"recommendPersonNum":2,"cardTag":null,"newDeal":null,"price":27.5,"priceChange":false,"promotionId":0,"promotionPrice":27.5,"buyButton":0,"useBeginTime":1461917565000,"useEndTime":1498492799000,"promotionLogo":null,"promotionTag":null,"groupDealFlag":false,"unionPromotionTag":null,"discountCardTag":"","curNumberDesc":null,"redirectUrl":"http://m.maoyan.com/deal/14409/100001894?_v_=yes&cityId=*&longitude=*&latitude=*&channelId=1&cinemaId=14409&versionName=8.0.1","value":32,"category":11}]}
     * success : true
     */

    private int errCode;
    private DataBean data;
    private boolean success;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
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
         * stid : 1585401697750747136
         * dealList : [{"dealId":100006824,"verifyBeginTime":1461911086000,"verifyEndTime":1498456800000,"firstTitle":"单人套餐","secondTitle":"爆米花1桶+可乐1杯","title":"[单人套餐]爆米花1桶+可乐1杯","imageUrl":"http://p0.meituan.net/w.h/deal/a4aee9d4358e0ed67e289ef47562700723993.jpg@90_0_279_279a%7C267h_267w_2e_90Q","maxNumberPerUser":100,"maxNumberPerOrder":100,"maxNumberPerMobile":100,"curNumber":2345,"recommendPersonNum":1,"cardTag":null,"newDeal":null,"price":17.5,"priceChange":false,"promotionId":0,"promotionPrice":17.5,"buyButton":0,"useBeginTime":1461911086000,"useEndTime":1498492799000,"promotionLogo":null,"promotionTag":null,"groupDealFlag":false,"unionPromotionTag":null,"discountCardTag":"","curNumberDesc":null,"redirectUrl":"http://m.maoyan.com/deal/14409/100006824?_v_=yes&cityId=*&longitude=*&latitude=*&channelId=1&cinemaId=14409&versionName=8.0.1","value":21,"category":11},{"dealId":100001894,"verifyBeginTime":1461917565000,"verifyEndTime":1498456800000,"firstTitle":"双人套餐","secondTitle":"46oz爆米花1桶+16oz可乐2杯","title":"[双人套餐]46oz爆米花1桶+16oz可乐2杯","imageUrl":"http://p0.meituan.net/w.h/deal/5e6045c4d5d6cb818adb1eb0c0109d8b37080.jpg@102_0_315_315a%7C267h_267w_2e_90Q","maxNumberPerUser":100,"maxNumberPerOrder":100,"maxNumberPerMobile":100,"curNumber":3871,"recommendPersonNum":2,"cardTag":null,"newDeal":null,"price":27.5,"priceChange":false,"promotionId":0,"promotionPrice":27.5,"buyButton":0,"useBeginTime":1461917565000,"useEndTime":1498492799000,"promotionLogo":null,"promotionTag":null,"groupDealFlag":false,"unionPromotionTag":null,"discountCardTag":"","curNumberDesc":null,"redirectUrl":"http://m.maoyan.com/deal/14409/100001894?_v_=yes&cityId=*&longitude=*&latitude=*&channelId=1&cinemaId=14409&versionName=8.0.1","value":32,"category":11}]
         */

        private String stid;
        private List<DealListBean> dealList;

        public String getStid() {
            return stid;
        }

        public void setStid(String stid) {
            this.stid = stid;
        }

        public List<DealListBean> getDealList() {
            return dealList;
        }

        public void setDealList(List<DealListBean> dealList) {
            this.dealList = dealList;
        }

        public static class DealListBean {
            /**
             * dealId : 100006824
             * verifyBeginTime : 1461911086000
             * verifyEndTime : 1498456800000
             * firstTitle : 单人套餐
             * secondTitle : 爆米花1桶+可乐1杯
             * title : [单人套餐]爆米花1桶+可乐1杯
             * imageUrl : http://p0.meituan.net/w.h/deal/a4aee9d4358e0ed67e289ef47562700723993.jpg@90_0_279_279a%7C267h_267w_2e_90Q
             * maxNumberPerUser : 100
             * maxNumberPerOrder : 100
             * maxNumberPerMobile : 100
             * curNumber : 2345
             * recommendPersonNum : 1
             * cardTag : null
             * newDeal : null
             * price : 17.5
             * priceChange : false
             * promotionId : 0
             * promotionPrice : 17.5
             * buyButton : 0
             * useBeginTime : 1461911086000
             * useEndTime : 1498492799000
             * promotionLogo : null
             * promotionTag : null
             * groupDealFlag : false
             * unionPromotionTag : null
             * discountCardTag :
             * curNumberDesc : null
             * redirectUrl : http://m.maoyan.com/deal/14409/100006824?_v_=yes&cityId=*&longitude=*&latitude=*&channelId=1&cinemaId=14409&versionName=8.0.1
             * value : 21.0
             * category : 11
             */

            private int dealId;
            private long verifyBeginTime;
            private long verifyEndTime;
            private String firstTitle;
            private String secondTitle;
            private String title;
            private String imageUrl;
            private int maxNumberPerUser;
            private int maxNumberPerOrder;
            private int maxNumberPerMobile;
            private int curNumber;
            private int recommendPersonNum;
            private Object cardTag;
            private Object newDeal;
            private double price;
            private boolean priceChange;
            private int promotionId;
            private double promotionPrice;
            private int buyButton;
            private long useBeginTime;
            private long useEndTime;
            private Object promotionLogo;
            private Object promotionTag;
            private boolean groupDealFlag;
            private Object unionPromotionTag;
            private String discountCardTag;
            private Object curNumberDesc;
            private String redirectUrl;
            private double value;
            private int category;

            public int getDealId() {
                return dealId;
            }

            public void setDealId(int dealId) {
                this.dealId = dealId;
            }

            public long getVerifyBeginTime() {
                return verifyBeginTime;
            }

            public void setVerifyBeginTime(long verifyBeginTime) {
                this.verifyBeginTime = verifyBeginTime;
            }

            public long getVerifyEndTime() {
                return verifyEndTime;
            }

            public void setVerifyEndTime(long verifyEndTime) {
                this.verifyEndTime = verifyEndTime;
            }

            public String getFirstTitle() {
                return firstTitle;
            }

            public void setFirstTitle(String firstTitle) {
                this.firstTitle = firstTitle;
            }

            public String getSecondTitle() {
                return secondTitle;
            }

            public void setSecondTitle(String secondTitle) {
                this.secondTitle = secondTitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getMaxNumberPerUser() {
                return maxNumberPerUser;
            }

            public void setMaxNumberPerUser(int maxNumberPerUser) {
                this.maxNumberPerUser = maxNumberPerUser;
            }

            public int getMaxNumberPerOrder() {
                return maxNumberPerOrder;
            }

            public void setMaxNumberPerOrder(int maxNumberPerOrder) {
                this.maxNumberPerOrder = maxNumberPerOrder;
            }

            public int getMaxNumberPerMobile() {
                return maxNumberPerMobile;
            }

            public void setMaxNumberPerMobile(int maxNumberPerMobile) {
                this.maxNumberPerMobile = maxNumberPerMobile;
            }

            public int getCurNumber() {
                return curNumber;
            }

            public void setCurNumber(int curNumber) {
                this.curNumber = curNumber;
            }

            public int getRecommendPersonNum() {
                return recommendPersonNum;
            }

            public void setRecommendPersonNum(int recommendPersonNum) {
                this.recommendPersonNum = recommendPersonNum;
            }

            public Object getCardTag() {
                return cardTag;
            }

            public void setCardTag(Object cardTag) {
                this.cardTag = cardTag;
            }

            public Object getNewDeal() {
                return newDeal;
            }

            public void setNewDeal(Object newDeal) {
                this.newDeal = newDeal;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public boolean isPriceChange() {
                return priceChange;
            }

            public void setPriceChange(boolean priceChange) {
                this.priceChange = priceChange;
            }

            public int getPromotionId() {
                return promotionId;
            }

            public void setPromotionId(int promotionId) {
                this.promotionId = promotionId;
            }

            public double getPromotionPrice() {
                return promotionPrice;
            }

            public void setPromotionPrice(double promotionPrice) {
                this.promotionPrice = promotionPrice;
            }

            public int getBuyButton() {
                return buyButton;
            }

            public void setBuyButton(int buyButton) {
                this.buyButton = buyButton;
            }

            public long getUseBeginTime() {
                return useBeginTime;
            }

            public void setUseBeginTime(long useBeginTime) {
                this.useBeginTime = useBeginTime;
            }

            public long getUseEndTime() {
                return useEndTime;
            }

            public void setUseEndTime(long useEndTime) {
                this.useEndTime = useEndTime;
            }

            public Object getPromotionLogo() {
                return promotionLogo;
            }

            public void setPromotionLogo(Object promotionLogo) {
                this.promotionLogo = promotionLogo;
            }

            public Object getPromotionTag() {
                return promotionTag;
            }

            public void setPromotionTag(Object promotionTag) {
                this.promotionTag = promotionTag;
            }

            public boolean isGroupDealFlag() {
                return groupDealFlag;
            }

            public void setGroupDealFlag(boolean groupDealFlag) {
                this.groupDealFlag = groupDealFlag;
            }

            public Object getUnionPromotionTag() {
                return unionPromotionTag;
            }

            public void setUnionPromotionTag(Object unionPromotionTag) {
                this.unionPromotionTag = unionPromotionTag;
            }

            public String getDiscountCardTag() {
                return discountCardTag;
            }

            public void setDiscountCardTag(String discountCardTag) {
                this.discountCardTag = discountCardTag;
            }

            public Object getCurNumberDesc() {
                return curNumberDesc;
            }

            public void setCurNumberDesc(Object curNumberDesc) {
                this.curNumberDesc = curNumberDesc;
            }

            public String getRedirectUrl() {
                return redirectUrl;
            }

            public void setRedirectUrl(String redirectUrl) {
                this.redirectUrl = redirectUrl;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public int getCategory() {
                return category;
            }

            public void setCategory(int category) {
                this.category = category;
            }
        }
    }
}

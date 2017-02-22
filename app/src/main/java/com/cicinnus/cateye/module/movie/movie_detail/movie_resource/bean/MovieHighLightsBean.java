package com.cicinnus.cateye.module.movie.movie_detail.movie_resource.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/22.
 */

public class MovieHighLightsBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * items : [{"desc":"甄子丹扮演\u201cXiang\u201d，此前这个角色原本是为李连杰设计的，甄子丹取代了后者出演这个反派角色。","id":62395,"provider":{"avatarUrl":"https://img.meituan.net/avatar/fea6c03c6f270e6cc6643185f0cf433612995.jpg","provideCount":0,"userId":122882331,"userName":"花花公子哥儿","vipInfo":"","vipType":0},"type":"textTag"},{"desc":"本片是\u201c极限特工\u201d系列电影的第三部。","id":62891,"provider":{"avatarUrl":"https://img.meituan.net/avatar/fea6c03c6f270e6cc6643185f0cf433612995.jpg","provideCount":0,"userId":122882331,"userName":"花花公子哥儿","vipInfo":"","vipType":0},"type":"textTag"},{"desc":"迪塞尔透露本片的灵感来源于\u201c速度与激情\u201d系列电影。","id":62892,"provider":{"avatarUrl":"https://img.meituan.net/avatar/fea6c03c6f270e6cc6643185f0cf433612995.jpg","provideCount":0,"userId":122882331,"userName":"花花公子哥儿","vipInfo":"","vipType":0},"type":"textTag"},{"desc":"本片是甄子丹与范迪塞尔首次合作的影片。","id":65317,"provider":{"avatarUrl":"https://img.meituan.net/avatar/fea6c03c6f270e6cc6643185f0cf433612995.jpg","provideCount":0,"userId":122882331,"userName":"花花公子哥儿","vipInfo":"","vipType":0},"type":"textTag"},{"desc":"该片是吴亦凡继《星际特工：千星之城》（2017）后加盟的第二部国际制作影片。","id":66057,"provider":{"avatarUrl":"https://img.meituan.net/avatar/fea6c03c6f270e6cc6643185f0cf433612995.jpg","provideCount":0,"userId":122882331,"userName":"花花公子哥儿","vipInfo":"","vipType":0},"type":"textTag"},{"desc":"甄子丹称在片场他与范迪塞尔除了聊剧本，最爱聊的是照顾孩子的经验。","id":66156,"provider":{"avatarUrl":"https://img.meituan.net/avatar/fea6c03c6f270e6cc6643185f0cf433612995.jpg","provideCount":0,"userId":122882331,"userName":"花花公子哥儿","vipInfo":"","vipType":0},"type":"textTag"},{"desc":"本片是美国前橄榄球明星托尼·冈萨雷斯的大银幕首秀。","id":66219,"provider":{"avatarUrl":"https://img.meituan.net/avatar/fea6c03c6f270e6cc6643185f0cf433612995.jpg","provideCount":0,"userId":122882331,"userName":"花花公子哥儿","vipInfo":"","vipType":0},"type":"textTag"},{"desc":"迈克尔·比斯平在康纳·麦格雷戈退出后取代他出演片中角色，二人均是他们所属重量级别的终极格斗冠军赛冠军。","id":77667,"provider":{"avatarUrl":"https://img.meituan.net/avatar/acc4b218c00d07ce604199c968c3f958212465.jpg","provideCount":0,"userId":17410915,"userName":"questionzhu","vipInfo":"","vipType":0},"type":"textTag"},{"desc":"范·迪塞尔在片中身穿的Hochock毛皮大衣仅价值59.9美金。","id":77690,"provider":{"avatarUrl":"https://img.meituan.net/avatar/1de6a7175a36408839c893dc677f277c148793.jpg","provideCount":0,"userId":36982768,"userName":"punnypencil","vipInfo":"猫爪团高级导师,猫爪翻译官","vipType":1},"type":"textTag"}]
         * title :
         */

        private String title;
        private List<ItemsBean> items;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * desc : 甄子丹扮演“Xiang”，此前这个角色原本是为李连杰设计的，甄子丹取代了后者出演这个反派角色。
             * id : 62395
             * provider : {"avatarUrl":"https://img.meituan.net/avatar/fea6c03c6f270e6cc6643185f0cf433612995.jpg","provideCount":0,"userId":122882331,"userName":"花花公子哥儿","vipInfo":"","vipType":0}
             * type : textTag
             */

            private String desc;
            private int id;
            private ProviderBean provider;
            private String type;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public ProviderBean getProvider() {
                return provider;
            }

            public void setProvider(ProviderBean provider) {
                this.provider = provider;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public static class ProviderBean {
                /**
                 * avatarUrl : https://img.meituan.net/avatar/fea6c03c6f270e6cc6643185f0cf433612995.jpg
                 * provideCount : 0
                 * userId : 122882331
                 * userName : 花花公子哥儿
                 * vipInfo :
                 * vipType : 0
                 */

                private String avatarUrl;
                private int provideCount;
                private int userId;
                private String userName;
                private String vipInfo;
                private int vipType;

                public String getAvatarUrl() {
                    return avatarUrl;
                }

                public void setAvatarUrl(String avatarUrl) {
                    this.avatarUrl = avatarUrl;
                }

                public int getProvideCount() {
                    return provideCount;
                }

                public void setProvideCount(int provideCount) {
                    this.provideCount = provideCount;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getVipInfo() {
                    return vipInfo;
                }

                public void setVipInfo(String vipInfo) {
                    this.vipInfo = vipInfo;
                }

                public int getVipType() {
                    return vipType;
                }

                public void setVipType(int vipType) {
                    this.vipType = vipType;
                }
            }
        }
    }
}

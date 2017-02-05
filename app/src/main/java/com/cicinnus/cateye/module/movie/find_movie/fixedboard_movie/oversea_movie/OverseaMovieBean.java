package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.cicinnus.cateye.base.BaseConstant;

import java.util.List;

public class OverseaMovieBean {



    private DataBeanXXX data;

    public DataBeanXXX getData() {
        return data;
    }

    public void setData(DataBeanXXX data) {
        this.data = data;
    }

    public static class DataBeanXXX {


        private RecommendDataBean recommendData;
        private ComingDataBean comingData;
        private HotDataBean hotData;

        public RecommendDataBean getRecommendData() {
            return recommendData;
        }

        public void setRecommendData(RecommendDataBean recommendData) {
            this.recommendData = recommendData;
        }

        public ComingDataBean getComingData() {
            return comingData;
        }

        public void setComingData(ComingDataBean comingData) {
            this.comingData = comingData;
        }

        public HotDataBean getHotData() {
            return hotData;
        }

        public void setHotData(HotDataBean hotData) {
            this.hotData = hotData;
        }

        public static class RecommendDataBean {
            /**
             * data : {"recommend":[]}
             */

            private DataBean data;

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public static class DataBean {
                private List<?> recommend;

                public List<?> getRecommend() {
                    return recommend;
                }

                public void setRecommend(List<?> recommend) {
                    this.recommend = recommend;
                }
            }
        }

        public static class ComingDataBean {
            /**
             * data : {"coming":[{"cat":"动作,惊悚","civilPubSt":3,"comingTitle":"2月 待定","desc":"主演:基努·里维斯,伊恩·麦柯肖恩,里卡多·斯卡马里奥","dir":"查德·斯塔尔斯基,大卫·雷奇","dur":100,"effectShowNum":0,"fra":"美国","frt":"2017-02-10","globalReleased":false,"headLineShow":false,"id":248812,"img":"http://p1.meituan.net/w.h/movie/d00e825d0ede67eeded9837e4468d1e3392199.jpg","late":false,"localPubSt":0,"mk":0,"nm":"疾速特攻","overseaTime":"2017-02-10","pn":74,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1488254400000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"遇见老朋友，又要闯破头","showCinemaNum":0,"showNum":0,"showst":1,"snum":66,"star":"基努·里维斯,伊恩·麦柯肖恩,里卡多·斯卡马里奥","time":"2017-02","ver":"2D","videoId":82588,"videoName":"重返杀场版预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x480167d91c3379244199844ad529c341b56.mp4","vnum":10,"weight":1,"wish":13598,"wishst":0,"headLinesVO":[{"movieId":246267,"title":"6天破6亿，成张艺谋最卖座电影","type":"票房","url":"meituanmovie://www.meituan.com/forum/newsDetail?id=17613"},{"movieId":246267,"title":"最全资料库：你想知道的都在这里","type":"专题","url":"meituanmovie://www.meituan.com/web?url=http://m.maoyan.com/newGuide/ceshi9999"}],"newsHeadlines":[{"movieId":246267,"title":"6天破6亿，成张艺谋最卖座电影","type":"票房","url":"meituanmovie://www.meituan.com/forum/newsDetail?id=17613"},{"movieId":246267,"title":"最全资料库：你想知道的都在这里","type":"专题","url":"meituanmovie://www.meituan.com/web?url=http://m.maoyan.com/newGuide/ceshi9999"}],"rt":"2016-12-16"},{"cat":"剧情,爱情,情色","civilPubSt":1,"comingTitle":"","desc":"主演:詹米·多南,达科塔·约翰逊,卢克·葛莱姆斯","dir":"詹姆斯·弗雷","dur":90,"effectShowNum":0,"fra":"美国","frt":"2017-02-10","globalReleased":false,"headLineShow":false,"id":248676,"img":"http://p0.meituan.net/w.h/movie/9ccb26664fcb3eb4b50f9bd02a8e4738101423.jpg","late":false,"localPubSt":0,"mk":0,"nm":"五十度黑","overseaTime":"2017-02-10","pn":155,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1486656000000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"","showCinemaNum":0,"showNum":0,"showst":1,"snum":33,"star":"詹米·多南,达科塔·约翰逊,卢克·葛莱姆斯","ver":"2D","videoId":83195,"videoName":"预告特辑","videourl":"http://maoyan.meituan.net/movie/videos/e71878f658824ff8bed1f17a15d800a1.mp4","vnum":14,"weight":1,"wish":1556,"wishst":0},{"cat":"剧情,爱情,灾难","civilPubSt":1,"comingTitle":"","desc":"主演:凯特·温丝莱特,伊德瑞斯·艾尔巴","dir":"汉尼·阿布-阿萨德","dur":90,"effectShowNum":0,"fra":"美国","frt":"2017-02-10","globalReleased":false,"headLineShow":false,"id":246713,"img":"http://p0.meituan.net/w.h/mmdb/1dbdf00ff02b21684d9ac34f12ada27e3944.png","late":false,"localPubSt":0,"mk":0,"nm":"我们之间的那座山","overseaTime":"2017-02-10","pn":1,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1486656000000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"","showCinemaNum":0,"showNum":0,"showst":1,"snum":7,"star":"凯特·温丝莱特,伊德瑞斯·艾尔巴","ver":"2D","videoId":0,"vnum":0,"weight":1,"wish":35,"wishst":0},{"cat":"剧情,冒险,奇幻","civilPubSt":4,"comingTitle":"2016年12月16日 周五","desc":"主演:马特·达蒙,景甜,佩德罗·帕斯卡","dir":"张艺谋","dur":104,"effectShowNum":0,"fra":"美国","frt":"2017-02-17","globalReleased":true,"headLineShow":false,"headLinesVO":[{"movieId":246267,"title":"6天破6亿，成张艺谋最卖座电影","type":"票房","url":"meituanmovie://www.meituan.com/forum/newsDetail?id=17613"},{"movieId":246267,"title":"最全资料库：你想知道的都在这里","type":"专题","url":"meituanmovie://www.meituan.com/web?url=http://m.maoyan.com/newGuide/ceshi9999"}],"id":246267,"img":"http://p0.meituan.net/w.h/movie/e4a3447ebe8c44eea59ab7f68790c7e2179321.jpeg","late":false,"localPubSt":0,"mk":8.4,"newsHeadlines":[{"movieId":246267,"title":"6天破6亿，成张艺谋最卖座电影","type":"票房","url":"meituanmovie://www.meituan.com/forum/newsDetail?id=17613"},{"movieId":246267,"title":"最全资料库：你想知道的都在这里","type":"专题","url":"meituanmovie://www.meituan.com/web?url=http://m.maoyan.com/newGuide/ceshi9999"}],"nm":"长城","overseaTime":"2017-02-17","pn":209,"preShow":false,"proScore":0,"proScoreNum":46,"pubDate":1481817600000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2016-12-16","sc":8.4,"scm":"五军战饕餮，中国魂不灭","showCinemaNum":0,"showNum":0,"showst":3,"snum":680043,"star":"马特·达蒙,景甜,佩德罗·帕斯卡","ver":"2D/3D","videoId":82447,"videoName":"希望版预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x4804781df4753a148648c534e4e8531a3ff.mp4","vnum":40,"weight":1,"wish":242315,"wishst":0},{"cat":"剧情,恐怖,惊悚,悬疑","civilPubSt":1,"comingTitle":"","desc":"主演:詹森·艾萨克,西莉亚·伊姆瑞,卡尔·鲁伯利","dir":"戈尔·维宾斯基","dur":146,"effectShowNum":0,"fra":"美国","frt":"2017-02-17","globalReleased":false,"headLineShow":false,"id":612521,"img":"http://p1.meituan.net/w.h/movie/1c0689dc2434a66b1088e9c772e8ccf4102912.jpg","late":false,"localPubSt":0,"mk":0,"nm":"救命解药","overseaTime":"2017-02-17","pn":0,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1487260800000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"","showCinemaNum":0,"showNum":0,"showst":1,"snum":5,"star":"詹森·艾萨克,西莉亚·伊姆瑞,卡尔·鲁伯利","ver":"2D","videoId":82614,"videoName":"正式预告片","videourl":"http://maoyan.meituan.net/movie/videos/a3e5ba94d2b948b1a8a821d963684c6f.mp4","vnum":5,"weight":1,"wish":73,"wishst":0},{"cat":"喜剧","civilPubSt":1,"comingTitle":"","desc":"主演:克里斯蒂娜·亨德里克斯,朱利安·贝尔,查理·戴","dir":"Richie Keen","dur":90,"effectShowNum":0,"fra":"美国","frt":"2017-02-17","globalReleased":false,"headLineShow":false,"id":343005,"img":"http://p0.meituan.net/w.h/movie/8fe1111ac99eb584a595b973e6f5fb3213503.jpg","late":false,"localPubSt":0,"mk":0,"nm":"Fist Fight","overseaTime":"2017-02-17","pn":1,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1487260800000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"","showCinemaNum":0,"showNum":0,"showst":1,"snum":0,"star":"克里斯蒂娜·亨德里克斯,朱利安·贝尔,查理·戴","ver":"2D","videoId":83275,"videoName":"Kumail Nanjiani","videourl":"http://maoyan.meituan.net/movie/videos/854x4806332a119080e41b2af90cb8d8a189cf3.mp4","vnum":19,"weight":1,"wish":10,"wishst":0},{"cat":"喜剧,动画,动作","civilPubSt":3,"comingTitle":"3月3日 周五","desc":"主演:威尔·阿奈特,罗莎里奥·道森,拉尔夫·费因斯","dir":"克里斯·麦凯","dur":104,"effectShowNum":0,"fra":"美国","frt":"2017-02-20","globalReleased":false,"headLineShow":false,"id":342183,"img":"http://p0.meituan.net/w.h/movie/c138a4878343cca293708a23e566d5bc837570.png","late":false,"localPubSt":0,"mk":0,"nm":"乐高蝙蝠侠大电影","overseaTime":"2017-02-20","pn":59,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1488470400000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2017-03-03","sc":0,"scm":"乐高大蝙蝠，逗比挡不住","showCinemaNum":0,"showNum":0,"showst":1,"snum":88,"star":"威尔·阿奈特,罗莎里奥·道森,拉尔夫·费因斯","ver":"2D","videoId":83210,"videoName":"电视版预告片17 Son (2017) Animated Comedy Movie HD","videourl":"http://maoyan.meituan.net/movie/videos/d1bc59cc4ca24cc69283ee17e1f05f7c.mp4","vnum":21,"weight":1,"wish":2862,"wishst":0},{"cat":"动画,音乐,冒险","civilPubSt":2,"comingTitle":"2016年7月8日 周五","desc":"主演:郭麒麟,路知行,郭德纲","dir":"艾什·布兰农","dur":93,"effectShowNum":0,"fra":"美国,韩国","frt":"2017-02-24,2016-09-14","globalReleased":true,"headLineShow":false,"id":247244,"img":"http://p1.meituan.net/w.h/movie/b8860717e8d8d9dc4a26122215dbdf07317552.jpg","late":false,"localPubSt":0,"mk":8.6,"nm":"摇滚藏獒","overseaTime":"2017-02-24","pn":227,"preShow":false,"proScore":0,"proScoreNum":21,"pubDate":1467907200000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2016-07-08","sc":8.6,"scm":"郑钧写剧本，混搭玩摇滚","showCinemaNum":0,"showNum":0,"showst":2,"snum":18617,"star":"郭麒麟,路知行,郭德纲","ver":"2D/3D/中国巨幕","videoId":46811,"videoName":"终极预告片","videourl":"http://maoyan.meituan.net/movie/videos/d3b9701f202b4baca7c779dfc1e6376d.mp4","vnum":11,"weight":1,"wish":19752,"wishst":0},{"cat":"剧情,爱情","civilPubSt":1,"comingTitle":"","desc":"主演:戴恩·德哈恩,克里斯托弗·瓦尔兹,杰克·奥康奈尔","dir":"贾斯汀·查德维克","dur":107,"effectShowNum":0,"fra":"美国","frt":"2017-02-24","globalReleased":false,"headLineShow":false,"id":336805,"img":"http://p0.meituan.net/w.h/movie/0f447c21a8deff7bc0df6ba673bbfede139853.jpg","late":false,"localPubSt":0,"mk":0,"nm":"狂热郁金香","overseaTime":"2017-02-24","pn":4,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1487865600000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"","showCinemaNum":0,"showNum":0,"showst":1,"snum":1,"star":"戴恩·德哈恩,克里斯托弗·瓦尔兹,杰克·奥康奈尔","ver":"2D","videoId":45285,"videoName":"先导预告片","videourl":"http://maoyan.meituan.net/movie/videos/4e2e81706da348cd9a25233cdd5f2c6d.mp4","vnum":1,"weight":1,"wish":135,"wishst":0},{"cat":"剧情,爱情,战争","civilPubSt":1,"comingTitle":"","desc":"主演:麦克斯·艾恩斯,巴里·佩珀,阿纽林·巴纳德","dir":"乔治·曼多陆","dur":103,"effectShowNum":0,"fra":"美国","frt":"2017-02-24","globalReleased":false,"headLineShow":false,"id":823954,"img":"http://p1.meituan.net/w.h/movie/63fbcfac80f65049179a6a65a2ddde1116724.jpg","late":false,"localPubSt":0,"mk":0,"nm":"Bitter Harvest","overseaTime":"2017-02-24","pn":6,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1487865600000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"showCinemaNum":0,"showNum":0,"showst":1,"snum":0,"star":"麦克斯·艾恩斯,巴里·佩珀,阿纽林·巴纳德","videoId":83122,"videoName":"Bitter Harvest Official Trailer","videourl":"http://maoyan.meituan.net/movie/videos/8958a262dd42421882989877a6b57349.mp4","vnum":1,"weight":0,"wish":4,"wishst":0}],"paging":{"hasMore":true,"limit":10,"offset":0,"total":95}}
             */

            private DataBeanX data;

            public DataBeanX getData() {
                return data;
            }

            public void setData(DataBeanX data) {
                this.data = data;
            }

            public static class DataBeanX {
                /**
                 * coming : [{"cat":"动作,惊悚","civilPubSt":3,"comingTitle":"2月 待定","desc":"主演:基努·里维斯,伊恩·麦柯肖恩,里卡多·斯卡马里奥","dir":"查德·斯塔尔斯基,大卫·雷奇","dur":100,"effectShowNum":0,"fra":"美国","frt":"2017-02-10","globalReleased":false,"headLineShow":false,"id":248812,"img":"http://p1.meituan.net/w.h/movie/d00e825d0ede67eeded9837e4468d1e3392199.jpg","late":false,"localPubSt":0,"mk":0,"nm":"疾速特攻","overseaTime":"2017-02-10","pn":74,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1488254400000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"遇见老朋友，又要闯破头","showCinemaNum":0,"showNum":0,"showst":1,"snum":66,"star":"基努·里维斯,伊恩·麦柯肖恩,里卡多·斯卡马里奥","time":"2017-02","ver":"2D","videoId":82588,"videoName":"重返杀场版预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x480167d91c3379244199844ad529c341b56.mp4","vnum":10,"weight":1,"wish":13598,"wishst":0},{"cat":"剧情,爱情,情色","civilPubSt":1,"comingTitle":"","desc":"主演:詹米·多南,达科塔·约翰逊,卢克·葛莱姆斯","dir":"詹姆斯·弗雷","dur":90,"effectShowNum":0,"fra":"美国","frt":"2017-02-10","globalReleased":false,"headLineShow":false,"id":248676,"img":"http://p0.meituan.net/w.h/movie/9ccb26664fcb3eb4b50f9bd02a8e4738101423.jpg","late":false,"localPubSt":0,"mk":0,"nm":"五十度黑","overseaTime":"2017-02-10","pn":155,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1486656000000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"","showCinemaNum":0,"showNum":0,"showst":1,"snum":33,"star":"詹米·多南,达科塔·约翰逊,卢克·葛莱姆斯","ver":"2D","videoId":83195,"videoName":"预告特辑","videourl":"http://maoyan.meituan.net/movie/videos/e71878f658824ff8bed1f17a15d800a1.mp4","vnum":14,"weight":1,"wish":1556,"wishst":0},{"cat":"剧情,爱情,灾难","civilPubSt":1,"comingTitle":"","desc":"主演:凯特·温丝莱特,伊德瑞斯·艾尔巴","dir":"汉尼·阿布-阿萨德","dur":90,"effectShowNum":0,"fra":"美国","frt":"2017-02-10","globalReleased":false,"headLineShow":false,"id":246713,"img":"http://p0.meituan.net/w.h/mmdb/1dbdf00ff02b21684d9ac34f12ada27e3944.png","late":false,"localPubSt":0,"mk":0,"nm":"我们之间的那座山","overseaTime":"2017-02-10","pn":1,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1486656000000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"","showCinemaNum":0,"showNum":0,"showst":1,"snum":7,"star":"凯特·温丝莱特,伊德瑞斯·艾尔巴","ver":"2D","videoId":0,"vnum":0,"weight":1,"wish":35,"wishst":0},{"cat":"剧情,冒险,奇幻","civilPubSt":4,"comingTitle":"2016年12月16日 周五","desc":"主演:马特·达蒙,景甜,佩德罗·帕斯卡","dir":"张艺谋","dur":104,"effectShowNum":0,"fra":"美国","frt":"2017-02-17","globalReleased":true,"headLineShow":false,"headLinesVO":[{"movieId":246267,"title":"6天破6亿，成张艺谋最卖座电影","type":"票房","url":"meituanmovie://www.meituan.com/forum/newsDetail?id=17613"},{"movieId":246267,"title":"最全资料库：你想知道的都在这里","type":"专题","url":"meituanmovie://www.meituan.com/web?url=http://m.maoyan.com/newGuide/ceshi9999"}],"id":246267,"img":"http://p0.meituan.net/w.h/movie/e4a3447ebe8c44eea59ab7f68790c7e2179321.jpeg","late":false,"localPubSt":0,"mk":8.4,"newsHeadlines":[{"movieId":246267,"title":"6天破6亿，成张艺谋最卖座电影","type":"票房","url":"meituanmovie://www.meituan.com/forum/newsDetail?id=17613"},{"movieId":246267,"title":"最全资料库：你想知道的都在这里","type":"专题","url":"meituanmovie://www.meituan.com/web?url=http://m.maoyan.com/newGuide/ceshi9999"}],"nm":"长城","overseaTime":"2017-02-17","pn":209,"preShow":false,"proScore":0,"proScoreNum":46,"pubDate":1481817600000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2016-12-16","sc":8.4,"scm":"五军战饕餮，中国魂不灭","showCinemaNum":0,"showNum":0,"showst":3,"snum":680043,"star":"马特·达蒙,景甜,佩德罗·帕斯卡","ver":"2D/3D","videoId":82447,"videoName":"希望版预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x4804781df4753a148648c534e4e8531a3ff.mp4","vnum":40,"weight":1,"wish":242315,"wishst":0},{"cat":"剧情,恐怖,惊悚,悬疑","civilPubSt":1,"comingTitle":"","desc":"主演:詹森·艾萨克,西莉亚·伊姆瑞,卡尔·鲁伯利","dir":"戈尔·维宾斯基","dur":146,"effectShowNum":0,"fra":"美国","frt":"2017-02-17","globalReleased":false,"headLineShow":false,"id":612521,"img":"http://p1.meituan.net/w.h/movie/1c0689dc2434a66b1088e9c772e8ccf4102912.jpg","late":false,"localPubSt":0,"mk":0,"nm":"救命解药","overseaTime":"2017-02-17","pn":0,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1487260800000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"","showCinemaNum":0,"showNum":0,"showst":1,"snum":5,"star":"詹森·艾萨克,西莉亚·伊姆瑞,卡尔·鲁伯利","ver":"2D","videoId":82614,"videoName":"正式预告片","videourl":"http://maoyan.meituan.net/movie/videos/a3e5ba94d2b948b1a8a821d963684c6f.mp4","vnum":5,"weight":1,"wish":73,"wishst":0},{"cat":"喜剧","civilPubSt":1,"comingTitle":"","desc":"主演:克里斯蒂娜·亨德里克斯,朱利安·贝尔,查理·戴","dir":"Richie Keen","dur":90,"effectShowNum":0,"fra":"美国","frt":"2017-02-17","globalReleased":false,"headLineShow":false,"id":343005,"img":"http://p0.meituan.net/w.h/movie/8fe1111ac99eb584a595b973e6f5fb3213503.jpg","late":false,"localPubSt":0,"mk":0,"nm":"Fist Fight","overseaTime":"2017-02-17","pn":1,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1487260800000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"","showCinemaNum":0,"showNum":0,"showst":1,"snum":0,"star":"克里斯蒂娜·亨德里克斯,朱利安·贝尔,查理·戴","ver":"2D","videoId":83275,"videoName":"Kumail Nanjiani","videourl":"http://maoyan.meituan.net/movie/videos/854x4806332a119080e41b2af90cb8d8a189cf3.mp4","vnum":19,"weight":1,"wish":10,"wishst":0},{"cat":"喜剧,动画,动作","civilPubSt":3,"comingTitle":"3月3日 周五","desc":"主演:威尔·阿奈特,罗莎里奥·道森,拉尔夫·费因斯","dir":"克里斯·麦凯","dur":104,"effectShowNum":0,"fra":"美国","frt":"2017-02-20","globalReleased":false,"headLineShow":false,"id":342183,"img":"http://p0.meituan.net/w.h/movie/c138a4878343cca293708a23e566d5bc837570.png","late":false,"localPubSt":0,"mk":0,"nm":"乐高蝙蝠侠大电影","overseaTime":"2017-02-20","pn":59,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1488470400000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2017-03-03","sc":0,"scm":"乐高大蝙蝠，逗比挡不住","showCinemaNum":0,"showNum":0,"showst":1,"snum":88,"star":"威尔·阿奈特,罗莎里奥·道森,拉尔夫·费因斯","ver":"2D","videoId":83210,"videoName":"电视版预告片17 Son (2017) Animated Comedy Movie HD","videourl":"http://maoyan.meituan.net/movie/videos/d1bc59cc4ca24cc69283ee17e1f05f7c.mp4","vnum":21,"weight":1,"wish":2862,"wishst":0},{"cat":"动画,音乐,冒险","civilPubSt":2,"comingTitle":"2016年7月8日 周五","desc":"主演:郭麒麟,路知行,郭德纲","dir":"艾什·布兰农","dur":93,"effectShowNum":0,"fra":"美国,韩国","frt":"2017-02-24,2016-09-14","globalReleased":true,"headLineShow":false,"id":247244,"img":"http://p1.meituan.net/w.h/movie/b8860717e8d8d9dc4a26122215dbdf07317552.jpg","late":false,"localPubSt":0,"mk":8.6,"nm":"摇滚藏獒","overseaTime":"2017-02-24","pn":227,"preShow":false,"proScore":0,"proScoreNum":21,"pubDate":1467907200000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2016-07-08","sc":8.6,"scm":"郑钧写剧本，混搭玩摇滚","showCinemaNum":0,"showNum":0,"showst":2,"snum":18617,"star":"郭麒麟,路知行,郭德纲","ver":"2D/3D/中国巨幕","videoId":46811,"videoName":"终极预告片","videourl":"http://maoyan.meituan.net/movie/videos/d3b9701f202b4baca7c779dfc1e6376d.mp4","vnum":11,"weight":1,"wish":19752,"wishst":0},{"cat":"剧情,爱情","civilPubSt":1,"comingTitle":"","desc":"主演:戴恩·德哈恩,克里斯托弗·瓦尔兹,杰克·奥康奈尔","dir":"贾斯汀·查德维克","dur":107,"effectShowNum":0,"fra":"美国","frt":"2017-02-24","globalReleased":false,"headLineShow":false,"id":336805,"img":"http://p0.meituan.net/w.h/movie/0f447c21a8deff7bc0df6ba673bbfede139853.jpg","late":false,"localPubSt":0,"mk":0,"nm":"狂热郁金香","overseaTime":"2017-02-24","pn":4,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1487865600000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"","showCinemaNum":0,"showNum":0,"showst":1,"snum":1,"star":"戴恩·德哈恩,克里斯托弗·瓦尔兹,杰克·奥康奈尔","ver":"2D","videoId":45285,"videoName":"先导预告片","videourl":"http://maoyan.meituan.net/movie/videos/4e2e81706da348cd9a25233cdd5f2c6d.mp4","vnum":1,"weight":1,"wish":135,"wishst":0},{"cat":"剧情,爱情,战争","civilPubSt":1,"comingTitle":"","desc":"主演:麦克斯·艾恩斯,巴里·佩珀,阿纽林·巴纳德","dir":"乔治·曼多陆","dur":103,"effectShowNum":0,"fra":"美国","frt":"2017-02-24","globalReleased":false,"headLineShow":false,"id":823954,"img":"http://p1.meituan.net/w.h/movie/63fbcfac80f65049179a6a65a2ddde1116724.jpg","late":false,"localPubSt":0,"mk":0,"nm":"Bitter Harvest","overseaTime":"2017-02-24","pn":6,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1487865600000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"showCinemaNum":0,"showNum":0,"showst":1,"snum":0,"star":"麦克斯·艾恩斯,巴里·佩珀,阿纽林·巴纳德","videoId":83122,"videoName":"Bitter Harvest Official Trailer","videourl":"http://maoyan.meituan.net/movie/videos/8958a262dd42421882989877a6b57349.mp4","vnum":1,"weight":0,"wish":4,"wishst":0}]
                 * paging : {"hasMore":true,"limit":10,"offset":0,"total":95}
                 */

                private PagingBean paging;
                private List<ComingBean> coming;

                public PagingBean getPaging() {
                    return paging;
                }

                public void setPaging(PagingBean paging) {
                    this.paging = paging;
                }

                public List<ComingBean> getComing() {
                    return coming;
                }

                public void setComing(List<ComingBean> coming) {
                    this.coming = coming;
                }

                public static class PagingBean {
                    /**
                     * hasMore : true
                     * limit : 10
                     * offset : 0
                     * total : 95
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

                public static class ComingBean {
                    /**
                     * cat : 动作,惊悚
                     * civilPubSt : 3
                     * comingTitle : 2月 待定
                     * desc : 主演:基努·里维斯,伊恩·麦柯肖恩,里卡多·斯卡马里奥
                     * dir : 查德·斯塔尔斯基,大卫·雷奇
                     * dur : 100
                     * effectShowNum : 0
                     * fra : 美国
                     * frt : 2017-02-10
                     * globalReleased : false
                     * headLineShow : false
                     * id : 248812
                     * img : http://p1.meituan.net/w.h/movie/d00e825d0ede67eeded9837e4468d1e3392199.jpg
                     * late : false
                     * localPubSt : 0
                     * mk : 0
                     * nm : 疾速特攻
                     * overseaTime : 2017-02-10
                     * pn : 74
                     * preShow : false
                     * proScore : 0
                     * proScoreNum : 0
                     * pubDate : 1488254400000
                     * pubShowNum : 0
                     * recentShowDate : 0
                     * recentShowNum : 0
                     * sc : 0
                     * scm : 遇见老朋友，又要闯破头
                     * showCinemaNum : 0
                     * showNum : 0
                     * showst : 1
                     * snum : 66
                     * star : 基努·里维斯,伊恩·麦柯肖恩,里卡多·斯卡马里奥
                     * time : 2017-02
                     * ver : 2D
                     * videoId : 82588
                     * videoName : 重返杀场版预告片
                     * videourl : http://maoyan.meituan.net/movie/videos/854x480167d91c3379244199844ad529c341b56.mp4
                     * vnum : 10
                     * weight : 1
                     * wish : 13598
                     * wishst : 0
                     * headLinesVO : [{"movieId":246267,"title":"6天破6亿，成张艺谋最卖座电影","type":"票房","url":"meituanmovie://www.meituan.com/forum/newsDetail?id=17613"},{"movieId":246267,"title":"最全资料库：你想知道的都在这里","type":"专题","url":"meituanmovie://www.meituan.com/web?url=http://m.maoyan.com/newGuide/ceshi9999"}]
                     * newsHeadlines : [{"movieId":246267,"title":"6天破6亿，成张艺谋最卖座电影","type":"票房","url":"meituanmovie://www.meituan.com/forum/newsDetail?id=17613"},{"movieId":246267,"title":"最全资料库：你想知道的都在这里","type":"专题","url":"meituanmovie://www.meituan.com/web?url=http://m.maoyan.com/newGuide/ceshi9999"}]
                     * rt : 2016-12-16
                     */

                    private String cat;
                    private int civilPubSt;
                    private String comingTitle;
                    private String desc;
                    private String dir;
                    private int dur;
                    private int effectShowNum;
                    private String fra;
                    private String frt;
                    private boolean globalReleased;
                    private boolean headLineShow;
                    private int id;
                    private String img;
                    private boolean late;
                    private int localPubSt;
                    private int mk;
                    private String nm;
                    private String overseaTime;
                    private int pn;
                    private boolean preShow;
                    private int proScore;
                    private int proScoreNum;
                    private long pubDate;
                    private int pubShowNum;
                    private int recentShowDate;
                    private int recentShowNum;
                    private int sc;
                    private String scm;
                    private int showCinemaNum;
                    private int showNum;
                    private int showst;
                    private int snum;
                    private String star;
                    private String time;
                    private String ver;
                    private int videoId;
                    private String videoName;
                    private String videourl;
                    private int vnum;
                    private int weight;
                    private int wish;
                    private int wishst;
                    private String rt;
                    private List<HeadLinesVOBean> headLinesVO;
                    private List<NewsHeadlinesBean> newsHeadlines;

                    public String getCat() {
                        return cat;
                    }

                    public void setCat(String cat) {
                        this.cat = cat;
                    }

                    public int getCivilPubSt() {
                        return civilPubSt;
                    }

                    public void setCivilPubSt(int civilPubSt) {
                        this.civilPubSt = civilPubSt;
                    }

                    public String getComingTitle() {
                        return comingTitle;
                    }

                    public void setComingTitle(String comingTitle) {
                        this.comingTitle = comingTitle;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public String getDir() {
                        return dir;
                    }

                    public void setDir(String dir) {
                        this.dir = dir;
                    }

                    public int getDur() {
                        return dur;
                    }

                    public void setDur(int dur) {
                        this.dur = dur;
                    }

                    public int getEffectShowNum() {
                        return effectShowNum;
                    }

                    public void setEffectShowNum(int effectShowNum) {
                        this.effectShowNum = effectShowNum;
                    }

                    public String getFra() {
                        return fra;
                    }

                    public void setFra(String fra) {
                        this.fra = fra;
                    }

                    public String getFrt() {
                        return frt;
                    }

                    public void setFrt(String frt) {
                        this.frt = frt;
                    }

                    public boolean isGlobalReleased() {
                        return globalReleased;
                    }

                    public void setGlobalReleased(boolean globalReleased) {
                        this.globalReleased = globalReleased;
                    }

                    public boolean isHeadLineShow() {
                        return headLineShow;
                    }

                    public void setHeadLineShow(boolean headLineShow) {
                        this.headLineShow = headLineShow;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }

                    public boolean isLate() {
                        return late;
                    }

                    public void setLate(boolean late) {
                        this.late = late;
                    }

                    public int getLocalPubSt() {
                        return localPubSt;
                    }

                    public void setLocalPubSt(int localPubSt) {
                        this.localPubSt = localPubSt;
                    }

                    public int getMk() {
                        return mk;
                    }

                    public void setMk(int mk) {
                        this.mk = mk;
                    }

                    public String getNm() {
                        return nm;
                    }

                    public void setNm(String nm) {
                        this.nm = nm;
                    }

                    public String getOverseaTime() {
                        return overseaTime;
                    }

                    public void setOverseaTime(String overseaTime) {
                        this.overseaTime = overseaTime;
                    }

                    public int getPn() {
                        return pn;
                    }

                    public void setPn(int pn) {
                        this.pn = pn;
                    }

                    public boolean isPreShow() {
                        return preShow;
                    }

                    public void setPreShow(boolean preShow) {
                        this.preShow = preShow;
                    }

                    public int getProScore() {
                        return proScore;
                    }

                    public void setProScore(int proScore) {
                        this.proScore = proScore;
                    }

                    public int getProScoreNum() {
                        return proScoreNum;
                    }

                    public void setProScoreNum(int proScoreNum) {
                        this.proScoreNum = proScoreNum;
                    }

                    public long getPubDate() {
                        return pubDate;
                    }

                    public void setPubDate(long pubDate) {
                        this.pubDate = pubDate;
                    }

                    public int getPubShowNum() {
                        return pubShowNum;
                    }

                    public void setPubShowNum(int pubShowNum) {
                        this.pubShowNum = pubShowNum;
                    }

                    public int getRecentShowDate() {
                        return recentShowDate;
                    }

                    public void setRecentShowDate(int recentShowDate) {
                        this.recentShowDate = recentShowDate;
                    }

                    public int getRecentShowNum() {
                        return recentShowNum;
                    }

                    public void setRecentShowNum(int recentShowNum) {
                        this.recentShowNum = recentShowNum;
                    }

                    public int getSc() {
                        return sc;
                    }

                    public void setSc(int sc) {
                        this.sc = sc;
                    }

                    public String getScm() {
                        return scm;
                    }

                    public void setScm(String scm) {
                        this.scm = scm;
                    }

                    public int getShowCinemaNum() {
                        return showCinemaNum;
                    }

                    public void setShowCinemaNum(int showCinemaNum) {
                        this.showCinemaNum = showCinemaNum;
                    }

                    public int getShowNum() {
                        return showNum;
                    }

                    public void setShowNum(int showNum) {
                        this.showNum = showNum;
                    }

                    public int getShowst() {
                        return showst;
                    }

                    public void setShowst(int showst) {
                        this.showst = showst;
                    }

                    public int getSnum() {
                        return snum;
                    }

                    public void setSnum(int snum) {
                        this.snum = snum;
                    }

                    public String getStar() {
                        return star;
                    }

                    public void setStar(String star) {
                        this.star = star;
                    }

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }

                    public String getVer() {
                        return ver;
                    }

                    public void setVer(String ver) {
                        this.ver = ver;
                    }

                    public int getVideoId() {
                        return videoId;
                    }

                    public void setVideoId(int videoId) {
                        this.videoId = videoId;
                    }

                    public String getVideoName() {
                        return videoName;
                    }

                    public void setVideoName(String videoName) {
                        this.videoName = videoName;
                    }

                    public String getVideourl() {
                        return videourl;
                    }

                    public void setVideourl(String videourl) {
                        this.videourl = videourl;
                    }

                    public int getVnum() {
                        return vnum;
                    }

                    public void setVnum(int vnum) {
                        this.vnum = vnum;
                    }

                    public int getWeight() {
                        return weight;
                    }

                    public void setWeight(int weight) {
                        this.weight = weight;
                    }

                    public int getWish() {
                        return wish;
                    }

                    public void setWish(int wish) {
                        this.wish = wish;
                    }

                    public int getWishst() {
                        return wishst;
                    }

                    public void setWishst(int wishst) {
                        this.wishst = wishst;
                    }

                    public String getRt() {
                        return rt;
                    }

                    public void setRt(String rt) {
                        this.rt = rt;
                    }

                    public List<HeadLinesVOBean> getHeadLinesVO() {
                        return headLinesVO;
                    }

                    public void setHeadLinesVO(List<HeadLinesVOBean> headLinesVO) {
                        this.headLinesVO = headLinesVO;
                    }

                    public List<NewsHeadlinesBean> getNewsHeadlines() {
                        return newsHeadlines;
                    }

                    public void setNewsHeadlines(List<NewsHeadlinesBean> newsHeadlines) {
                        this.newsHeadlines = newsHeadlines;
                    }

                    public static class HeadLinesVOBean {
                        /**
                         * movieId : 246267
                         * title : 6天破6亿，成张艺谋最卖座电影
                         * type : 票房
                         * url : meituanmovie://www.meituan.com/forum/newsDetail?id=17613
                         */

                        private int movieId;
                        private String title;
                        private String type;
                        private String url;

                        public int getMovieId() {
                            return movieId;
                        }

                        public void setMovieId(int movieId) {
                            this.movieId = movieId;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }

                    public static class NewsHeadlinesBean {
                        /**
                         * movieId : 246267
                         * title : 6天破6亿，成张艺谋最卖座电影
                         * type : 票房
                         * url : meituanmovie://www.meituan.com/forum/newsDetail?id=17613
                         */

                        private int movieId;
                        private String title;
                        private String type;
                        private String url;

                        public int getMovieId() {
                            return movieId;
                        }

                        public void setMovieId(int movieId) {
                            this.movieId = movieId;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
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
        }

        public static class HotDataBean {
            /**
             * data : {"hot":[{"cat":"剧情,恐怖,惊悚","civilPubSt":1,"comingTitle":"","desc":"主演:艾米·缇加登,亚历克斯·路-布朗,Matilda Anna Ingrid Lutz","dir":"F. Javier Gutiérrez","dur":90,"effectShowNum":0,"fra":"美国","frt":"2017-02-03","globalReleased":true,"headLineShow":false,"id":247399,"img":"http://p0.meituan.net/w.h/movie/be52cf2f13e143a6c20bd8baa567cffb198185.jpg","late":false,"localPubSt":0,"mk":5.1,"nm":"美版午夜凶铃3","overseaTime":"2017-02-03","pn":18,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1486051200000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":5.1,"scm":"","showCinemaNum":0,"showNum":0,"showst":2,"snum":19,"star":"艾米·缇加登,亚历克斯·路-布朗,Matilda Anna Ingrid Lutz","ver":"2D","videoId":82886,"videoName":"终极预告片","videourl":"http://maoyan.meituan.net/movie/videos/ffe0e6cba2204da399323085500d0d4a.mp4","vnum":3,"weight":1,"wish":423,"wishst":0,"rt":"2017-03-03","ftime":",2017-01,","time":"2017-02"},{"cat":"剧情,惊悚","civilPubSt":1,"comingTitle":"","desc":"主演:詹姆斯·麦卡沃伊,安雅·泰勒·乔伊,杰西卡·苏拉","dir":"M·奈特·沙马兰","dur":116,"effectShowNum":0,"fra":"美国","frt":"2017-01-20","globalReleased":true,"headLineShow":false,"id":343113,"img":"http://p0.meituan.net/w.h/movie/20bb18601295713a5d62d9fc027d3129170981.jpg","late":false,"localPubSt":0,"mk":7.5,"nm":"分裂","overseaTime":"2017-01-20","pn":24,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1484841600000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":7.5,"scm":"","showCinemaNum":0,"showNum":0,"showst":2,"snum":44,"star":"詹姆斯·麦卡沃伊,安雅·泰勒·乔伊,杰西卡·苏拉","ver":"2D","videoId":82589,"videoName":"分裂电视预告片","videourl":"http://maoyan.meituan.net/movie/videos/437a2888478d449086f582af209ade0a.mp4","vnum":12,"weight":1,"wish":948,"wishst":0},{"cat":"历史","civilPubSt":1,"comingTitle":"","desc":"主演:凯文·科斯特纳,塔拉吉·P·汉森,Saniyya Sidney","dir":"特奥多尔·梅尔菲","dur":90,"effectShowNum":0,"fra":"美国","frt":"2017-01-13","globalReleased":true,"headLineShow":false,"id":342934,"img":"http://p1.meituan.net/w.h/movie/5c33336f3ec9df5123615910e0afab4a122750.jpg","late":false,"localPubSt":0,"mk":7.9,"nm":"隐藏人物","overseaTime":"2017-01-13","pn":6,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1484236800000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":7.9,"scm":"","showCinemaNum":0,"showNum":0,"showst":2,"snum":14,"star":"凯文·科斯特纳,塔拉吉·P·汉森,Saniyya Sidney","ver":"2D","videoId":81935,"videoName":"正式版预告片","videourl":"http://maoyan.meituan.net/movie/videos/1551ad1c3cfe4fa486772407d2b0eb3a.mp4","vnum":4,"weight":1,"wish":47,"wishst":0},{"cat":"剧情,喜剧","civilPubSt":3,"comingTitle":"3月3日 周五","desc":"主演:布丽特妮·罗伯森,丹尼斯·奎德,佩吉·利普顿","dir":"莱塞·霍尔斯道姆","dur":120,"effectShowNum":0,"fra":"美国","frt":"2017-01-27","globalReleased":false,"headLineShow":false,"id":342858,"img":"http://p1.meituan.net/w.h/movie/92941ca1e6a5e3c6adab795721c4065a759373.jpg","late":false,"localPubSt":0,"mk":0,"nm":"一条狗的使命","overseaTime":"2017-01-27","pn":11,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1488470400000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2017-03-03","sc":0,"scm":"狗狗爱主人，重生不离分","showCinemaNum":0,"showNum":0,"showst":1,"snum":220,"star":"布丽特妮·罗伯森,丹尼斯·奎德,佩吉·利普顿","ver":"2D","videoId":83250,"videoName":"定档预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x480dea8ad287df344a3a904a27a36f4d212.mp4","vnum":4,"weight":1,"wish":10216,"wishst":0},{"cat":"爱情,歌舞","civilPubSt":3,"comingTitle":"2月14日 周二","desc":"主演:瑞恩·高斯林,艾玛·斯通,约翰·传奇","dir":"达米恩·查泽雷","dur":129,"effectShowNum":0,"fra":"美国","frt":"2016-12-02","globalReleased":false,"headLineShow":false,"id":338436,"img":"http://p0.meituan.net/w.h/movie/f4990a965755af1be2a16c421951c48219905345.jpg","late":false,"localPubSt":0,"mk":0,"nm":"爱乐之城","overseaTime":"2016-12-02","pn":134,"preShow":true,"proScore":0,"proScoreNum":2,"pubDate":1487001600000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2017-02-14","sc":0,"scm":"爵士钢琴家，恋爱舞天涯","showCinemaNum":0,"showNum":0,"showst":4,"snum":540,"star":"瑞恩·高斯林,艾玛·斯通,约翰·传奇","ver":"2D/IMAX 2D/中国巨幕/全景声","videoId":82926,"videoName":"定档预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x480f0ef72dd3d6540959b6325ce06d625f6.mp4","vnum":15,"weight":1,"wish":22462,"wishst":0},{"cat":"剧情,爱情,冒险","civilPubSt":1,"comingTitle":"","desc":"主演:加里·奥德曼,阿沙·巴特菲尔德,Trey Tucker","dir":"彼德·切尔瑟姆","dur":90,"effectShowNum":0,"fra":"美国","frt":"2017-02-03","globalReleased":true,"headLineShow":false,"id":342605,"img":"http://p1.meituan.net/w.h/movie/c9416737b3ccc2fa6185d988e5a5cf12112325.jpg","late":false,"localPubSt":0,"mk":6.1,"nm":"世界之外","overseaTime":"2017-02-03","pn":26,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1486051200000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":6.1,"scm":"","showCinemaNum":0,"showNum":0,"showst":2,"snum":36,"star":"加里·奥德曼,阿沙·巴特菲尔德,Trey Tucker","ver":"2D","videoId":80873,"videoName":"正式版预告片2","videourl":"http://maoyan.meituan.net/movie/videos/c01863edc2004313bf275783da820327.mp4","vnum":6,"weight":1,"wish":497,"wishst":0},{"cat":"动作,惊悚,科幻","civilPubSt":3,"comingTitle":"2月 待定","desc":"主演:米拉·乔沃维奇,西耶娜·盖尔利,肖恩·罗伯茨","dir":"保罗·安德森","dur":106,"effectShowNum":0,"fra":"美国,韩国,日本","frt":"2017-01-27,,2016-12-23","ftime":",2017-01,","globalReleased":false,"headLineShow":false,"id":246065,"img":"http://p0.meituan.net/w.h/movie/69528cd37e79d709b4c59aa73580d90d98982.jpg","late":false,"localPubSt":0,"mk":0,"nm":"生化危机6：终章","overseaTime":"2017-01-27","pn":101,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1488254400000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"终篇重新改，女神再归来","showCinemaNum":0,"showNum":0,"showst":1,"snum":4082,"star":"米拉·乔沃维奇,西耶娜·盖尔利,肖恩·罗伯茨","time":"2017-02","ver":"3D/IMAX 3D/中国巨幕","videoId":82810,"videoName":"打怪升级预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x48003e22dadf8114314a1deba3372988b71.mp4","vnum":16,"weight":1,"wish":132227,"wishst":0},{"cat":"剧情","civilPubSt":1,"comingTitle":"","desc":"主演:鲁妮·玛拉,戴夫·帕特尔,妮可·基德曼","dir":"加斯·戴维斯","dur":129,"effectShowNum":0,"fra":"美国","frt":"2016-11-25","globalReleased":true,"headLineShow":false,"id":257722,"img":"http://p1.meituan.net/w.h/movie/24961cb9f44fceb654bdb36089d6d33a878429.png","late":false,"localPubSt":0,"mk":8,"nm":"雄狮","overseaTime":"2016-11-25","pn":80,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1480003200000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":8,"scm":"","showCinemaNum":0,"showNum":0,"showst":2,"snum":5,"star":"鲁妮·玛拉,戴夫·帕特尔,妮可·基德曼","ver":"2D","videoId":48006,"videoName":"首发版预告片","videourl":"http://v.meituan.net/movie/videos/5d598b01ce6645afb5a5ec131e356560.mp4","vnum":1,"weight":1,"wish":34,"wishst":0},{"cat":"动作,冒险","civilPubSt":3,"comingTitle":"2月10日 周五","desc":"主演:范·迪塞尔,塞缪尔·杰克逊,迪皮卡·帕度柯妮","dir":"D·J·卡卢索","dur":107,"effectShowNum":0,"fra":"美国","frt":"2017-01-20","globalReleased":false,"headLineShow":false,"id":334590,"img":"http://p0.meituan.net/w.h/movie/222f2fbb546a33cdcbd976e95305091b252892.jpg","late":false,"localPubSt":0,"mk":0,"nm":"极限特工：终极回归","overseaTime":"2017-01-20","pn":561,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1486656000000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2017-02-10","sc":0,"scm":"特工再回归，英雄组团来","showCinemaNum":0,"showNum":0,"showst":4,"snum":2999,"star":"范·迪塞尔,塞缪尔·杰克逊,迪皮卡·帕度柯妮","ver":"3D/IMAX 3D/中国巨幕/全景声","videoId":83276,"videoName":"甄子丹中文角色预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x48054cd184fb9d74a4a8c55abaf0651d21c.mp4","vnum":33,"weight":1,"wish":107495,"wishst":0},{"cat":"喜剧,动画,音乐","civilPubSt":3,"comingTitle":"2月17日 周五","desc":"主演:马修·麦康纳,约翰·C·赖利,瑞茜·威瑟斯彭","dir":"加斯·詹宁斯","dur":108,"effectShowNum":0,"fra":"美国","frt":"2016-12-21","globalReleased":false,"headLineShow":false,"id":344258,"img":"http://p0.meituan.net/w.h/movie/2fed2c127078fcca08b075736bf7b69e454069.jpg","late":false,"localPubSt":0,"mk":0,"nm":"欢乐好声音","overseaTime":"2016-12-21","pn":91,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1487260800000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2017-02-17","sc":0,"scm":"挽救歌剧院，欢唱动物园","showCinemaNum":0,"showNum":0,"showst":1,"snum":152,"star":"马修·麦康纳,约翰·C·赖利,瑞茜·威瑟斯彭","ver":"2D/3D/IMAX 3D","videoId":82913,"videoName":"定档预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x480c350ad6cb9704026a7a1dadc35f00e5a.mp4","vnum":28,"weight":1,"wish":10340,"wishst":0}],"paging":{"hasMore":true,"limit":10,"offset":0,"total":84}}
             */

            private DataBeanXX data;

            public DataBeanXX getData() {
                return data;
            }

            public void setData(DataBeanXX data) {
                this.data = data;
            }


            public static class DataBeanXX {
                /**
                 * hot : [{"cat":"剧情,恐怖,惊悚","civilPubSt":1,"comingTitle":"","desc":"主演:艾米·缇加登,亚历克斯·路-布朗,Matilda Anna Ingrid Lutz","dir":"F. Javier Gutiérrez","dur":90,"effectShowNum":0,"fra":"美国","frt":"2017-02-03","globalReleased":true,"headLineShow":false,"id":247399,"img":"http://p0.meituan.net/w.h/movie/be52cf2f13e143a6c20bd8baa567cffb198185.jpg","late":false,"localPubSt":0,"mk":5.1,"nm":"美版午夜凶铃3","overseaTime":"2017-02-03","pn":18,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1486051200000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":5.1,"scm":"","showCinemaNum":0,"showNum":0,"showst":2,"snum":19,"star":"艾米·缇加登,亚历克斯·路-布朗,Matilda Anna Ingrid Lutz","ver":"2D","videoId":82886,"videoName":"终极预告片","videourl":"http://maoyan.meituan.net/movie/videos/ffe0e6cba2204da399323085500d0d4a.mp4","vnum":3,"weight":1,"wish":423,"wishst":0},{"cat":"剧情,惊悚","civilPubSt":1,"comingTitle":"","desc":"主演:詹姆斯·麦卡沃伊,安雅·泰勒·乔伊,杰西卡·苏拉","dir":"M·奈特·沙马兰","dur":116,"effectShowNum":0,"fra":"美国","frt":"2017-01-20","globalReleased":true,"headLineShow":false,"id":343113,"img":"http://p0.meituan.net/w.h/movie/20bb18601295713a5d62d9fc027d3129170981.jpg","late":false,"localPubSt":0,"mk":7.5,"nm":"分裂","overseaTime":"2017-01-20","pn":24,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1484841600000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":7.5,"scm":"","showCinemaNum":0,"showNum":0,"showst":2,"snum":44,"star":"詹姆斯·麦卡沃伊,安雅·泰勒·乔伊,杰西卡·苏拉","ver":"2D","videoId":82589,"videoName":"分裂电视预告片","videourl":"http://maoyan.meituan.net/movie/videos/437a2888478d449086f582af209ade0a.mp4","vnum":12,"weight":1,"wish":948,"wishst":0},{"cat":"历史","civilPubSt":1,"comingTitle":"","desc":"主演:凯文·科斯特纳,塔拉吉·P·汉森,Saniyya Sidney","dir":"特奥多尔·梅尔菲","dur":90,"effectShowNum":0,"fra":"美国","frt":"2017-01-13","globalReleased":true,"headLineShow":false,"id":342934,"img":"http://p1.meituan.net/w.h/movie/5c33336f3ec9df5123615910e0afab4a122750.jpg","late":false,"localPubSt":0,"mk":7.9,"nm":"隐藏人物","overseaTime":"2017-01-13","pn":6,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1484236800000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":7.9,"scm":"","showCinemaNum":0,"showNum":0,"showst":2,"snum":14,"star":"凯文·科斯特纳,塔拉吉·P·汉森,Saniyya Sidney","ver":"2D","videoId":81935,"videoName":"正式版预告片","videourl":"http://maoyan.meituan.net/movie/videos/1551ad1c3cfe4fa486772407d2b0eb3a.mp4","vnum":4,"weight":1,"wish":47,"wishst":0},{"cat":"剧情,喜剧","civilPubSt":3,"comingTitle":"3月3日 周五","desc":"主演:布丽特妮·罗伯森,丹尼斯·奎德,佩吉·利普顿","dir":"莱塞·霍尔斯道姆","dur":120,"effectShowNum":0,"fra":"美国","frt":"2017-01-27","globalReleased":false,"headLineShow":false,"id":342858,"img":"http://p1.meituan.net/w.h/movie/92941ca1e6a5e3c6adab795721c4065a759373.jpg","late":false,"localPubSt":0,"mk":0,"nm":"一条狗的使命","overseaTime":"2017-01-27","pn":11,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1488470400000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2017-03-03","sc":0,"scm":"狗狗爱主人，重生不离分","showCinemaNum":0,"showNum":0,"showst":1,"snum":220,"star":"布丽特妮·罗伯森,丹尼斯·奎德,佩吉·利普顿","ver":"2D","videoId":83250,"videoName":"定档预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x480dea8ad287df344a3a904a27a36f4d212.mp4","vnum":4,"weight":1,"wish":10216,"wishst":0},{"cat":"爱情,歌舞","civilPubSt":3,"comingTitle":"2月14日 周二","desc":"主演:瑞恩·高斯林,艾玛·斯通,约翰·传奇","dir":"达米恩·查泽雷","dur":129,"effectShowNum":0,"fra":"美国","frt":"2016-12-02","globalReleased":false,"headLineShow":false,"id":338436,"img":"http://p0.meituan.net/w.h/movie/f4990a965755af1be2a16c421951c48219905345.jpg","late":false,"localPubSt":0,"mk":0,"nm":"爱乐之城","overseaTime":"2016-12-02","pn":134,"preShow":true,"proScore":0,"proScoreNum":2,"pubDate":1487001600000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2017-02-14","sc":0,"scm":"爵士钢琴家，恋爱舞天涯","showCinemaNum":0,"showNum":0,"showst":4,"snum":540,"star":"瑞恩·高斯林,艾玛·斯通,约翰·传奇","ver":"2D/IMAX 2D/中国巨幕/全景声","videoId":82926,"videoName":"定档预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x480f0ef72dd3d6540959b6325ce06d625f6.mp4","vnum":15,"weight":1,"wish":22462,"wishst":0},{"cat":"剧情,爱情,冒险","civilPubSt":1,"comingTitle":"","desc":"主演:加里·奥德曼,阿沙·巴特菲尔德,Trey Tucker","dir":"彼德·切尔瑟姆","dur":90,"effectShowNum":0,"fra":"美国","frt":"2017-02-03","globalReleased":true,"headLineShow":false,"id":342605,"img":"http://p1.meituan.net/w.h/movie/c9416737b3ccc2fa6185d988e5a5cf12112325.jpg","late":false,"localPubSt":0,"mk":6.1,"nm":"世界之外","overseaTime":"2017-02-03","pn":26,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1486051200000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":6.1,"scm":"","showCinemaNum":0,"showNum":0,"showst":2,"snum":36,"star":"加里·奥德曼,阿沙·巴特菲尔德,Trey Tucker","ver":"2D","videoId":80873,"videoName":"正式版预告片2","videourl":"http://maoyan.meituan.net/movie/videos/c01863edc2004313bf275783da820327.mp4","vnum":6,"weight":1,"wish":497,"wishst":0},{"cat":"动作,惊悚,科幻","civilPubSt":3,"comingTitle":"2月 待定","desc":"主演:米拉·乔沃维奇,西耶娜·盖尔利,肖恩·罗伯茨","dir":"保罗·安德森","dur":106,"effectShowNum":0,"fra":"美国,韩国,日本","frt":"2017-01-27,,2016-12-23","ftime":",2017-01,","globalReleased":false,"headLineShow":false,"id":246065,"img":"http://p0.meituan.net/w.h/movie/69528cd37e79d709b4c59aa73580d90d98982.jpg","late":false,"localPubSt":0,"mk":0,"nm":"生化危机6：终章","overseaTime":"2017-01-27","pn":101,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1488254400000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":0,"scm":"终篇重新改，女神再归来","showCinemaNum":0,"showNum":0,"showst":1,"snum":4082,"star":"米拉·乔沃维奇,西耶娜·盖尔利,肖恩·罗伯茨","time":"2017-02","ver":"3D/IMAX 3D/中国巨幕","videoId":82810,"videoName":"打怪升级预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x48003e22dadf8114314a1deba3372988b71.mp4","vnum":16,"weight":1,"wish":132227,"wishst":0},{"cat":"剧情","civilPubSt":1,"comingTitle":"","desc":"主演:鲁妮·玛拉,戴夫·帕特尔,妮可·基德曼","dir":"加斯·戴维斯","dur":129,"effectShowNum":0,"fra":"美国","frt":"2016-11-25","globalReleased":true,"headLineShow":false,"id":257722,"img":"http://p1.meituan.net/w.h/movie/24961cb9f44fceb654bdb36089d6d33a878429.png","late":false,"localPubSt":0,"mk":8,"nm":"雄狮","overseaTime":"2016-11-25","pn":80,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1480003200000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"sc":8,"scm":"","showCinemaNum":0,"showNum":0,"showst":2,"snum":5,"star":"鲁妮·玛拉,戴夫·帕特尔,妮可·基德曼","ver":"2D","videoId":48006,"videoName":"首发版预告片","videourl":"http://v.meituan.net/movie/videos/5d598b01ce6645afb5a5ec131e356560.mp4","vnum":1,"weight":1,"wish":34,"wishst":0},{"cat":"动作,冒险","civilPubSt":3,"comingTitle":"2月10日 周五","desc":"主演:范·迪塞尔,塞缪尔·杰克逊,迪皮卡·帕度柯妮","dir":"D·J·卡卢索","dur":107,"effectShowNum":0,"fra":"美国","frt":"2017-01-20","globalReleased":false,"headLineShow":false,"id":334590,"img":"http://p0.meituan.net/w.h/movie/222f2fbb546a33cdcbd976e95305091b252892.jpg","late":false,"localPubSt":0,"mk":0,"nm":"极限特工：终极回归","overseaTime":"2017-01-20","pn":561,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1486656000000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2017-02-10","sc":0,"scm":"特工再回归，英雄组团来","showCinemaNum":0,"showNum":0,"showst":4,"snum":2999,"star":"范·迪塞尔,塞缪尔·杰克逊,迪皮卡·帕度柯妮","ver":"3D/IMAX 3D/中国巨幕/全景声","videoId":83276,"videoName":"甄子丹中文角色预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x48054cd184fb9d74a4a8c55abaf0651d21c.mp4","vnum":33,"weight":1,"wish":107495,"wishst":0},{"cat":"喜剧,动画,音乐","civilPubSt":3,"comingTitle":"2月17日 周五","desc":"主演:马修·麦康纳,约翰·C·赖利,瑞茜·威瑟斯彭","dir":"加斯·詹宁斯","dur":108,"effectShowNum":0,"fra":"美国","frt":"2016-12-21","globalReleased":false,"headLineShow":false,"id":344258,"img":"http://p0.meituan.net/w.h/movie/2fed2c127078fcca08b075736bf7b69e454069.jpg","late":false,"localPubSt":0,"mk":0,"nm":"欢乐好声音","overseaTime":"2016-12-21","pn":91,"preShow":false,"proScore":0,"proScoreNum":0,"pubDate":1487260800000,"pubShowNum":0,"recentShowDate":0,"recentShowNum":0,"rt":"2017-02-17","sc":0,"scm":"挽救歌剧院，欢唱动物园","showCinemaNum":0,"showNum":0,"showst":1,"snum":152,"star":"马修·麦康纳,约翰·C·赖利,瑞茜·威瑟斯彭","ver":"2D/3D/IMAX 3D","videoId":82913,"videoName":"定档预告片","videourl":"http://maoyan.meituan.net/movie/videos/854x480c350ad6cb9704026a7a1dadc35f00e5a.mp4","vnum":28,"weight":1,"wish":10340,"wishst":0}]
                 * paging : {"hasMore":true,"limit":10,"offset":0,"total":84}
                 */

                private PagingBeanX paging;
                private List<HotBean> hot;

                public PagingBeanX getPaging() {
                    return paging;
                }

                public void setPaging(PagingBeanX paging) {
                    this.paging = paging;
                }

                public List<HotBean> getHot() {
                    return hot;
                }

                public void setHot(List<HotBean> hot) {
                    this.hot = hot;
                }

                public static class PagingBeanX {
                    /**
                     * hasMore : true
                     * limit : 10
                     * offset : 0
                     * total : 84
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

                public static class HotBean implements MultiItemEntity {
                    /**
                     * cat : 剧情,恐怖,惊悚
                     * civilPubSt : 1
                     * comingTitle :
                     * desc : 主演:艾米·缇加登,亚历克斯·路-布朗,Matilda Anna Ingrid Lutz
                     * dir : F. Javier Gutiérrez
                     * dur : 90
                     * effectShowNum : 0
                     * fra : 美国
                     * frt : 2017-02-03
                     * globalReleased : true
                     * headLineShow : false
                     * id : 247399
                     * img : http://p0.meituan.net/w.h/movie/be52cf2f13e143a6c20bd8baa567cffb198185.jpg
                     * late : false
                     * localPubSt : 0
                     * mk : 5.1
                     * nm : 美版午夜凶铃3
                     * overseaTime : 2017-02-03
                     * pn : 18
                     * preShow : false
                     * proScore : 0
                     * proScoreNum : 0
                     * pubDate : 1486051200000
                     * pubShowNum : 0
                     * recentShowDate : 0
                     * recentShowNum : 0
                     * sc : 5.1
                     * scm :
                     * showCinemaNum : 0
                     * showNum : 0
                     * showst : 2
                     * snum : 19
                     * star : 艾米·缇加登,亚历克斯·路-布朗,Matilda Anna Ingrid Lutz
                     * ver : 2D
                     * videoId : 82886
                     * videoName : 终极预告片
                     * videourl : http://maoyan.meituan.net/movie/videos/ffe0e6cba2204da399323085500d0d4a.mp4
                     * vnum : 3
                     * weight : 1
                     * wish : 423
                     * wishst : 0
                     * rt : 2017-03-03
                     * ftime : ,2017-01,
                     * time : 2017-02
                     */

                    private String cat;
                    private int civilPubSt;
                    private String comingTitle;
                    private String desc;
                    private String dir;
                    private int dur;
                    private int effectShowNum;
                    private String fra;
                    private String frt;
                    private boolean globalReleased;
                    private boolean headLineShow;
                    private int id;
                    private String img;
                    private boolean late;
                    private int localPubSt;
                    private double mk;
                    private String nm;
                    private String overseaTime;
                    private int pn;
                    private boolean preShow;
                    private int proScore;
                    private int proScoreNum;
                    private long pubDate;
                    private int pubShowNum;
                    private int recentShowDate;
                    private int recentShowNum;
                    private double sc;
                    private String scm;
                    private int showCinemaNum;
                    private int showNum;
                    private int showst;
                    private int snum;
                    private String star;
                    private String ver;
                    private int videoId;
                    private String videoName;
                    private String videourl;
                    private int vnum;
                    private int weight;
                    private int wish;
                    private int wishst;
                    private String rt;
                    private String ftime;
                    private String time;
                    private List<ComingDataBean.DataBeanX.ComingBean.HeadLinesVOBean> headLinesVO;
                    private List<ComingDataBean.DataBeanX.ComingBean.NewsHeadlinesBean> newsHeadlines;
                    public String getCat() {
                        return cat;
                    }

                    public void setCat(String cat) {
                        this.cat = cat;
                    }

                    public int getCivilPubSt() {
                        return civilPubSt;
                    }

                    public void setCivilPubSt(int civilPubSt) {
                        this.civilPubSt = civilPubSt;
                    }

                    public String getComingTitle() {
                        return comingTitle;
                    }

                    public void setComingTitle(String comingTitle) {
                        this.comingTitle = comingTitle;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public String getDir() {
                        return dir;
                    }

                    public void setDir(String dir) {
                        this.dir = dir;
                    }

                    public int getDur() {
                        return dur;
                    }

                    public void setDur(int dur) {
                        this.dur = dur;
                    }

                    public int getEffectShowNum() {
                        return effectShowNum;
                    }

                    public void setEffectShowNum(int effectShowNum) {
                        this.effectShowNum = effectShowNum;
                    }

                    public String getFra() {
                        return fra;
                    }

                    public void setFra(String fra) {
                        this.fra = fra;
                    }

                    public String getFrt() {
                        return frt;
                    }

                    public void setFrt(String frt) {
                        this.frt = frt;
                    }

                    public boolean isGlobalReleased() {
                        return globalReleased;
                    }

                    public void setGlobalReleased(boolean globalReleased) {
                        this.globalReleased = globalReleased;
                    }

                    public boolean isHeadLineShow() {
                        return headLineShow;
                    }

                    public void setHeadLineShow(boolean headLineShow) {
                        this.headLineShow = headLineShow;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }

                    public boolean isLate() {
                        return late;
                    }

                    public void setLate(boolean late) {
                        this.late = late;
                    }

                    public int getLocalPubSt() {
                        return localPubSt;
                    }

                    public void setLocalPubSt(int localPubSt) {
                        this.localPubSt = localPubSt;
                    }

                    public double getMk() {
                        return mk;
                    }

                    public void setMk(double mk) {
                        this.mk = mk;
                    }

                    public String getNm() {
                        return nm;
                    }

                    public void setNm(String nm) {
                        this.nm = nm;
                    }

                    public String getOverseaTime() {
                        return overseaTime;
                    }

                    public void setOverseaTime(String overseaTime) {
                        this.overseaTime = overseaTime;
                    }

                    public int getPn() {
                        return pn;
                    }

                    public void setPn(int pn) {
                        this.pn = pn;
                    }

                    public boolean isPreShow() {
                        return preShow;
                    }

                    public void setPreShow(boolean preShow) {
                        this.preShow = preShow;
                    }

                    public int getProScore() {
                        return proScore;
                    }

                    public void setProScore(int proScore) {
                        this.proScore = proScore;
                    }

                    public int getProScoreNum() {
                        return proScoreNum;
                    }

                    public void setProScoreNum(int proScoreNum) {
                        this.proScoreNum = proScoreNum;
                    }

                    public long getPubDate() {
                        return pubDate;
                    }

                    public void setPubDate(long pubDate) {
                        this.pubDate = pubDate;
                    }

                    public int getPubShowNum() {
                        return pubShowNum;
                    }

                    public void setPubShowNum(int pubShowNum) {
                        this.pubShowNum = pubShowNum;
                    }

                    public int getRecentShowDate() {
                        return recentShowDate;
                    }

                    public void setRecentShowDate(int recentShowDate) {
                        this.recentShowDate = recentShowDate;
                    }

                    public int getRecentShowNum() {
                        return recentShowNum;
                    }

                    public void setRecentShowNum(int recentShowNum) {
                        this.recentShowNum = recentShowNum;
                    }

                    public double getSc() {
                        return sc;
                    }

                    public void setSc(double sc) {
                        this.sc = sc;
                    }

                    public String getScm() {
                        return scm;
                    }

                    public void setScm(String scm) {
                        this.scm = scm;
                    }

                    public int getShowCinemaNum() {
                        return showCinemaNum;
                    }

                    public void setShowCinemaNum(int showCinemaNum) {
                        this.showCinemaNum = showCinemaNum;
                    }

                    public int getShowNum() {
                        return showNum;
                    }

                    public void setShowNum(int showNum) {
                        this.showNum = showNum;
                    }

                    public int getShowst() {
                        return showst;
                    }

                    public void setShowst(int showst) {
                        this.showst = showst;
                    }

                    public int getSnum() {
                        return snum;
                    }

                    public void setSnum(int snum) {
                        this.snum = snum;
                    }

                    public String getStar() {
                        return star;
                    }

                    public void setStar(String star) {
                        this.star = star;
                    }

                    public String getVer() {
                        return ver;
                    }

                    public void setVer(String ver) {
                        this.ver = ver;
                    }

                    public int getVideoId() {
                        return videoId;
                    }

                    public void setVideoId(int videoId) {
                        this.videoId = videoId;
                    }

                    public String getVideoName() {
                        return videoName;
                    }

                    public void setVideoName(String videoName) {
                        this.videoName = videoName;
                    }

                    public String getVideourl() {
                        return videourl;
                    }

                    public void setVideourl(String videourl) {
                        this.videourl = videourl;
                    }

                    public int getVnum() {
                        return vnum;
                    }

                    public void setVnum(int vnum) {
                        this.vnum = vnum;
                    }

                    public int getWeight() {
                        return weight;
                    }

                    public void setWeight(int weight) {
                        this.weight = weight;
                    }

                    public int getWish() {
                        return wish;
                    }

                    public void setWish(int wish) {
                        this.wish = wish;
                    }

                    public int getWishst() {
                        return wishst;
                    }

                    public void setWishst(int wishst) {
                        this.wishst = wishst;
                    }

                    public String getRt() {
                        return rt;
                    }

                    public void setRt(String rt) {
                        this.rt = rt;
                    }

                    public String getFtime() {
                        return ftime;
                    }

                    public void setFtime(String ftime) {
                        this.ftime = ftime;
                    }

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }

                    public List<ComingDataBean.DataBeanX.ComingBean.HeadLinesVOBean> getHeadLinesVO() {
                        return headLinesVO;
                    }

                    public void setHeadLinesVO(List<ComingDataBean.DataBeanX.ComingBean.HeadLinesVOBean> headLinesVO) {
                        this.headLinesVO = headLinesVO;
                    }

                    public List<ComingDataBean.DataBeanX.ComingBean.NewsHeadlinesBean> getNewsHeadlines() {
                        return newsHeadlines;
                    }

                    public void setNewsHeadlines(List<ComingDataBean.DataBeanX.ComingBean.NewsHeadlinesBean> newsHeadlines) {
                        this.newsHeadlines = newsHeadlines;
                    }

                    public static class HeadLinesVOBean {
                        /**
                         * movieId : 246267
                         * title : 6天破6亿，成张艺谋最卖座电影
                         * type : 票房
                         * url : meituanmovie://www.meituan.com/forum/newsDetail?id=17613
                         */

                        private int movieId;
                        private String title;
                        private String type;
                        private String url;

                        public int getMovieId() {
                            return movieId;
                        }

                        public void setMovieId(int movieId) {
                            this.movieId = movieId;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }

                    public static class NewsHeadlinesBean {
                        /**
                         * movieId : 246267
                         * title : 6天破6亿，成张艺谋最卖座电影
                         * type : 票房
                         * url : meituanmovie://www.meituan.com/forum/newsDetail?id=17613
                         */

                        private int movieId;
                        private String title;
                        private String type;
                        private String url;

                        public int getMovieId() {
                            return movieId;
                        }

                        public void setMovieId(int movieId) {
                            this.movieId = movieId;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }


                    @Override
                    public int getItemType() {

                        if(getHeadLinesVO()!=null&&getHeadLinesVO().size()>1){
                            return BaseConstant.TYPE_OVERSEA_BUY_MULIT;
                        }
                        switch (getShowst()) {
                            case 1:
                                return BaseConstant.TYPE_OVERSEA_NORMAL;
                            case 3:
                                return BaseConstant.TYPE_OVERSEA_BUY;
                            case 4:
                                return BaseConstant.TYPE_OVERSEA_PRESALE;
                            default:
                                return BaseConstant.TYPE_OVERSEA_NORMAL;
                        }
                    }
                }
            }
        }
    }
}

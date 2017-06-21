package com.cicinnus.cateye.module.cinema.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicinnus on 2017/6/20.
 */

public class FilterBean {

    /**
     * code : 0
     * data : {"brand":{"name":"品牌","subItems":[{"count":150,"id":-1,"name":"全部"},{"count":15,"id":1079568,"name":"金逸影城"},{"count":13,"id":384262,"name":"大地影院"},{"count":7,"id":102642,"name":"万达影城"},{"count":6,"id":1640929,"name":"哈艺时尚影城"},{"count":6,"id":30032,"name":"星美国际影城"},{"count":5,"id":1233223,"name":"中影佰纳国际影城"},{"count":4,"id":26045,"name":"横店电影城"},{"count":3,"id":1156990,"name":"飞扬影城"},{"count":3,"id":348260,"name":"喜洋时代影城"},{"count":3,"id":25383,"name":"烽禾影城"},{"count":2,"id":30898,"name":"中影火山湖电影城"},{"count":2,"id":822548,"name":"百丽宫影城"},{"count":2,"id":24472,"name":"保利国际影城"},{"count":2,"id":2233611,"name":"英皇UA电影城"},{"count":1,"id":26222,"name":"华影万晟国际影城"},{"count":1,"id":413896,"name":"太古仓电影库"},{"count":1,"id":30901,"name":"中影乐佳影城"},{"count":1,"id":152419,"name":"丽江电影城"},{"count":1,"id":29095,"name":"天河电影城"},{"count":1,"id":30227,"name":"耀莱成龙国际影城"},{"count":1,"id":24071,"name":"UME国际影城"},{"count":1,"id":292030,"name":"卢米埃影城"},{"count":1,"id":2020418,"name":"CGV影城"},{"count":1,"id":24745,"name":"橙天嘉禾影城"},{"count":1,"id":494396,"name":"左岸国际影城"},{"count":1,"id":173611,"name":"五月花电影城"},{"count":1,"id":124487,"name":"东圃摩登电影城"},{"count":1,"id":23745,"name":"中影国际影城"},{"count":1,"id":24377,"name":"百老汇影城"},{"count":1,"id":30856,"name":"中华广场电影城"},{"count":1,"id":616001,"name":"星汇电影城"},{"count":1,"id":2880988,"name":"SFC上影影城"},{"count":59,"id":0,"name":"其他"}]},"district":{"name":"行政区","subItems":[{"count":150,"id":-1,"name":"全部"},{"count":30,"id":274,"name":"番禺区","subItems":[{"count":30,"id":-1,"name":"全部"},{"count":6,"id":1182,"name":"市桥"},{"count":4,"id":7541,"name":"长隆/南村/万达"},{"count":4,"id":1183,"name":"大石"},{"count":3,"id":7542,"name":"钟村"},{"count":3,"id":9023,"name":"市桥南"},{"count":3,"id":1461,"name":"番禺广场"},{"count":2,"id":1184,"name":"大学城"},{"count":1,"id":5187,"name":"洛溪"},{"count":1,"id":9024,"name":"沙湾镇"},{"count":1,"id":9276,"name":"石基"},{"count":1,"id":18905,"name":"南浦"},{"count":1,"id":14179,"name":"石楼"}]},{"count":28,"id":26,"name":"白云区","subItems":[{"count":28,"id":-1,"name":"全部"},{"count":3,"id":1491,"name":"同德围"},{"count":3,"id":1180,"name":"白云大道沿线"},{"count":2,"id":1493,"name":"新市"},{"count":2,"id":17078,"name":"江高"},{"count":2,"id":5193,"name":"嘉禾/人和"},{"count":2,"id":17256,"name":"均禾"},{"count":2,"id":1181,"name":"同和/京溪"},{"count":1,"id":16022,"name":"石井"},{"count":1,"id":1492,"name":"罗冲围/金沙洲"},{"count":1,"id":7535,"name":"嘉裕太阳城"},{"count":1,"id":7536,"name":"五号停机坪"},{"count":1,"id":7537,"name":"黄石"},{"count":1,"id":7539,"name":"万达广场"},{"count":1,"id":27976,"name":"白云国际机场"},{"count":1,"id":16091,"name":"钟落潭"},{"count":1,"id":18064,"name":"太和镇"},{"count":1,"id":734,"name":"机场路沿线"}]},{"count":23,"id":22,"name":"天河区","subItems":[{"count":23,"id":-1,"name":"全部"},{"count":4,"id":1164,"name":"东圃"},{"count":3,"id":7791,"name":"花城汇/高德置地"},{"count":3,"id":717,"name":"棠下"},{"count":2,"id":13875,"name":"正佳广场"},{"count":2,"id":15110,"name":"兴盛路/猎德"},{"count":2,"id":715,"name":"岗顶/龙口"},{"count":1,"id":1490,"name":"龙洞"},{"count":1,"id":14405,"name":"车陂"},{"count":1,"id":1380,"name":"天河客运站"},{"count":1,"id":13162,"name":"员村"},{"count":1,"id":7783,"name":"天河城/体育西"},{"count":1,"id":14391,"name":"五山"},{"count":1,"id":716,"name":"跑马场"}]},{"count":15,"id":24,"name":"海珠区","subItems":[{"count":15,"id":-1,"name":"全部"},{"count":4,"id":725,"name":"江南大道沿线"},{"count":2,"id":1165,"name":"客村/赤岗"},{"count":2,"id":1178,"name":"东晓南路沿线"},{"count":2,"id":1179,"name":"工业大道沿线"},{"count":1,"id":1494,"name":"江南西"},{"count":1,"id":8961,"name":"琶洲"}]},{"count":12,"id":23,"name":"越秀区","subItems":[{"count":12,"id":-1,"name":"全部"},{"count":4,"id":719,"name":"北京路商业区"},{"count":2,"id":720,"name":"沿江路沿线/二沙岛"},{"count":1,"id":19682,"name":"建设六马路"},{"count":1,"id":1065,"name":"中山二三路/东山口"},{"count":1,"id":21642,"name":"中华广场"},{"count":1,"id":722,"name":"中山六路"},{"count":1,"id":723,"name":"火车站/人民北路"}]},{"count":11,"id":25,"name":"荔湾区","subItems":[{"count":11,"id":-1,"name":"全部"},{"count":2,"id":7669,"name":"西村西场"},{"count":2,"id":1067,"name":"芳村"},{"count":2,"id":729,"name":"上下九商业区"},{"count":1,"id":7540,"name":"康王路"},{"count":1,"id":730,"name":"中山七八路"}]},{"count":9,"id":739,"name":"增城市","subItems":[{"count":9,"id":-1,"name":"全部"},{"count":2,"id":9180,"name":"荔城挂绿/泰富广场"},{"count":2,"id":13113,"name":"凤凰城"},{"count":2,"id":7718,"name":"新塘大润发/新好景"},{"count":1,"id":9178,"name":"东汇城/人人乐"},{"count":1,"id":9181,"name":"太阳城/凯旋门"},{"count":1,"id":13071,"name":"万达广场"}]},{"count":8,"id":738,"name":"花都区","subItems":[{"count":8,"id":-1,"name":"全部"},{"count":3,"id":5887,"name":"狮岭"},{"count":2,"id":13356,"name":"北站/建设路"},{"count":2,"id":13362,"name":"大润发"},{"count":1,"id":13904,"name":"花都体育场"}]},{"count":7,"id":737,"name":"黄埔区","subItems":[{"count":7,"id":-1,"name":"全部"},{"count":2,"id":8034,"name":"开发区东区"},{"count":1,"id":22706,"name":"万达广场"},{"count":1,"id":8033,"name":"中心城"},{"count":1,"id":8032,"name":"科学城/萝岗高德汇"},{"count":1,"id":8797,"name":"生活区/南岗"}]},{"count":4,"id":1068,"name":"南沙区","subItems":[{"count":4,"id":-1,"name":"全部"},{"count":1,"id":13850,"name":"华汇广场"},{"count":1,"id":13848,"name":"金洲商业街"},{"count":1,"id":25709,"name":"南沙万达广场"},{"count":1,"id":15267,"name":"大岗"}]},{"count":3,"id":740,"name":"从化市","subItems":[{"count":3,"id":-1,"name":"全部"},{"count":1,"id":13150,"name":"街口/新世纪广场"},{"count":1,"id":16273,"name":"太平镇/太平商业街"},{"count":1,"id":13157,"name":"欣荣宏广场"}]}]},"hallType":{"name":"特殊厅","subItems":[{"count":150,"id":-1,"name":"全部"},{"count":16,"id":20019,"name":"IMAX厅"},{"count":12,"id":20021,"name":"杜比全景声厅"},{"count":11,"id":20029,"name":"60帧厅"},{"count":7,"id":20026,"name":"中国巨幕厅"},{"count":7,"id":20022,"name":"4K厅"},{"count":6,"id":20027,"name":"巨幕厅"},{"count":4,"id":20024,"name":"4D厅"},{"count":3,"id":20032,"name":"RealD 6FL厅"},{"count":2,"id":20025,"name":"RealD厅"},{"count":2,"id":20028,"name":"4DX厅"},{"count":2,"id":20033,"name":"LUXE巨幕厅"},{"count":1,"id":20023,"name":"双机3D厅"}]},"service":{"name":"服务","subItems":[{"count":150,"id":-1,"name":"全部"},{"count":87,"id":3,"name":"可改签"},{"count":77,"id":2,"name":"可退票"},{"count":74,"id":4,"name":"会员卡"}]},"subway":{"name":"地铁","subItems":[{"count":150,"id":-1,"name":"全部"},{"count":31,"id":32,"name":"1号线","subItems":[{"count":11,"id":-1,"name":"全部"},{"count":6,"id":551,"name":"农讲所"},{"count":5,"id":547,"name":"体育西路"},{"count":5,"id":552,"name":"公园前"},{"count":4,"id":555,"name":"长寿路"},{"count":3,"id":546,"name":"体育中心"},{"count":2,"id":556,"name":"黄沙"},{"count":2,"id":554,"name":"陈家祠"},{"count":1,"id":550,"name":"烈士陵园"},{"count":1,"id":549,"name":"东山口"},{"count":1,"id":557,"name":"芳村"},{"count":1,"id":553,"name":"西门口"}]},{"count":30,"id":33,"name":"2号线","subItems":[{"count":15,"id":-1,"name":"全部"},{"count":5,"id":572,"name":"公园前"},{"count":3,"id":575,"name":"江南西"},{"count":3,"id":573,"name":"海珠广场"},{"count":3,"id":576,"name":"昌岗"},{"count":2,"id":567,"name":"飞翔公园"},{"count":2,"id":566,"name":"白云公园"},{"count":2,"id":571,"name":"纪念堂"},{"count":2,"id":577,"name":"江泰路"},{"count":2,"id":578,"name":"东晓南"},{"count":1,"id":563,"name":"江夏"},{"count":1,"id":562,"name":"黄边"},{"count":1,"id":574,"name":"市二宫"},{"count":1,"id":569,"name":"广州火车站"},{"count":1,"id":568,"name":"三元里"},{"count":1,"id":580,"name":"洛溪"}]},{"count":34,"id":34,"name":"3号线","subItems":[{"count":17,"id":-1,"name":"全部"},{"count":5,"id":590,"name":"体育西路"},{"count":3,"id":589,"name":"石牌桥"},{"count":3,"id":591,"name":"珠江新城"},{"count":3,"id":599,"name":"市桥"},{"count":2,"id":587,"name":"华师"},{"count":2,"id":588,"name":"岗顶"},{"count":2,"id":592,"name":"广州塔"},{"count":2,"id":597,"name":"大石"},{"count":2,"id":600,"name":"番禺广场"},{"count":2,"id":4269,"name":"京溪南方医院"},{"count":2,"id":4275,"name":"人和"},{"count":1,"id":585,"name":"天河客运站"},{"count":1,"id":593,"name":"客村"},{"count":1,"id":4266,"name":"白云大道北"},{"count":1,"id":4265,"name":"同和"},{"count":1,"id":4270,"name":"永泰"},{"count":1,"id":4274,"name":"梅花园"}]},{"count":13,"id":35,"name":"3号线支线","subItems":[{"count":7,"id":-1,"name":"全部"},{"count":5,"id":612,"name":"体育西路"},{"count":2,"id":608,"name":"京溪南方医院"},{"count":2,"id":602,"name":"人和"},{"count":1,"id":605,"name":"白云大道北"},{"count":1,"id":607,"name":"同和"},{"count":1,"id":606,"name":"永泰"},{"count":1,"id":1004,"name":"梅花园"}]},{"count":8,"id":36,"name":"4号线","subItems":[{"count":5,"id":-1,"name":"全部"},{"count":3,"id":627,"name":"车陂"},{"count":2,"id":613,"name":"金洲"},{"count":1,"id":614,"name":"蕉门"},{"count":1,"id":623,"name":"大学城北"},{"count":1,"id":625,"name":"万胜围"}]},{"count":20,"id":37,"name":"5号线","subItems":[{"count":14,"id":-1,"name":"全部"},{"count":3,"id":639,"name":"猎德"},{"count":3,"id":640,"name":"珠江新城"},{"count":2,"id":648,"name":"西村"},{"count":2,"id":650,"name":"中山八"},{"count":1,"id":630,"name":"大沙东"},{"count":1,"id":634,"name":"东圃"},{"count":1,"id":638,"name":"潭村"},{"count":1,"id":637,"name":"员村"},{"count":1,"id":636,"name":"科韵路"},{"count":1,"id":652,"name":"滘口"},{"count":1,"id":649,"name":"西场"},{"count":1,"id":645,"name":"淘金"},{"count":1,"id":647,"name":"广州火车站"},{"count":1,"id":646,"name":"小北"}]},{"count":24,"id":78,"name":"6号线","subItems":[{"count":11,"id":-1,"name":"全部"},{"count":6,"id":1551,"name":"北京路"},{"count":4,"id":1543,"name":"海珠广场"},{"count":3,"id":1546,"name":"团一大广场"},{"count":3,"id":1542,"name":"文化公园"},{"count":2,"id":1541,"name":"黄沙"},{"count":1,"id":1548,"name":"区庄"},{"count":1,"id":1544,"name":"一德路"},{"count":1,"id":1547,"name":"长湴"},{"count":1,"id":1540,"name":"东山口"},{"count":1,"id":1536,"name":"河沙"},{"count":1,"id":1532,"name":"天河客运站"}]},{"count":19,"id":38,"name":"8号线","subItems":[{"count":10,"id":-1,"name":"全部"},{"count":3,"id":662,"name":"昌岗"},{"count":3,"id":663,"name":"宝岗大道"},{"count":3,"id":1005,"name":"沙园"},{"count":2,"id":664,"name":"凤凰新村"},{"count":2,"id":661,"name":"晓港"},{"count":2,"id":657,"name":"赤岗"},{"count":1,"id":653,"name":"万胜围"},{"count":1,"id":655,"name":"新港东"},{"count":1,"id":654,"name":"琶洲"},{"count":1,"id":658,"name":"客村"}]},{"count":28,"id":39,"name":"APM线","subItems":[{"count":8,"id":-1,"name":"全部"},{"count":6,"id":668,"name":"黄埔大道"},{"count":5,"id":667,"name":"天河南"},{"count":4,"id":670,"name":"花城大道"},{"count":4,"id":666,"name":"体育中心南"},{"count":3,"id":669,"name":"妇儿中心"},{"count":2,"id":673,"name":"广州塔"},{"count":2,"id":672,"name":"海心沙"},{"count":2,"id":671,"name":"大剧院"}]},{"count":2,"id":40,"name":"广佛线","subItems":[{"count":2,"id":-1,"name":"全部"},{"count":1,"id":3913,"name":"沙涌"},{"count":1,"id":3916,"name":"燕岗"}]}]}}
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
         * brand : {"name":"品牌","subItems":[{"count":150,"id":-1,"name":"全部"},{"count":15,"id":1079568,"name":"金逸影城"},{"count":13,"id":384262,"name":"大地影院"},{"count":7,"id":102642,"name":"万达影城"},{"count":6,"id":1640929,"name":"哈艺时尚影城"},{"count":6,"id":30032,"name":"星美国际影城"},{"count":5,"id":1233223,"name":"中影佰纳国际影城"},{"count":4,"id":26045,"name":"横店电影城"},{"count":3,"id":1156990,"name":"飞扬影城"},{"count":3,"id":348260,"name":"喜洋时代影城"},{"count":3,"id":25383,"name":"烽禾影城"},{"count":2,"id":30898,"name":"中影火山湖电影城"},{"count":2,"id":822548,"name":"百丽宫影城"},{"count":2,"id":24472,"name":"保利国际影城"},{"count":2,"id":2233611,"name":"英皇UA电影城"},{"count":1,"id":26222,"name":"华影万晟国际影城"},{"count":1,"id":413896,"name":"太古仓电影库"},{"count":1,"id":30901,"name":"中影乐佳影城"},{"count":1,"id":152419,"name":"丽江电影城"},{"count":1,"id":29095,"name":"天河电影城"},{"count":1,"id":30227,"name":"耀莱成龙国际影城"},{"count":1,"id":24071,"name":"UME国际影城"},{"count":1,"id":292030,"name":"卢米埃影城"},{"count":1,"id":2020418,"name":"CGV影城"},{"count":1,"id":24745,"name":"橙天嘉禾影城"},{"count":1,"id":494396,"name":"左岸国际影城"},{"count":1,"id":173611,"name":"五月花电影城"},{"count":1,"id":124487,"name":"东圃摩登电影城"},{"count":1,"id":23745,"name":"中影国际影城"},{"count":1,"id":24377,"name":"百老汇影城"},{"count":1,"id":30856,"name":"中华广场电影城"},{"count":1,"id":616001,"name":"星汇电影城"},{"count":1,"id":2880988,"name":"SFC上影影城"},{"count":59,"id":0,"name":"其他"}]}
         * district : {"name":"行政区","subItems":[{"count":150,"id":-1,"name":"全部"},{"count":30,"id":274,"name":"番禺区","subItems":[{"count":30,"id":-1,"name":"全部"},{"count":6,"id":1182,"name":"市桥"},{"count":4,"id":7541,"name":"长隆/南村/万达"},{"count":4,"id":1183,"name":"大石"},{"count":3,"id":7542,"name":"钟村"},{"count":3,"id":9023,"name":"市桥南"},{"count":3,"id":1461,"name":"番禺广场"},{"count":2,"id":1184,"name":"大学城"},{"count":1,"id":5187,"name":"洛溪"},{"count":1,"id":9024,"name":"沙湾镇"},{"count":1,"id":9276,"name":"石基"},{"count":1,"id":18905,"name":"南浦"},{"count":1,"id":14179,"name":"石楼"}]},{"count":28,"id":26,"name":"白云区","subItems":[{"count":28,"id":-1,"name":"全部"},{"count":3,"id":1491,"name":"同德围"},{"count":3,"id":1180,"name":"白云大道沿线"},{"count":2,"id":1493,"name":"新市"},{"count":2,"id":17078,"name":"江高"},{"count":2,"id":5193,"name":"嘉禾/人和"},{"count":2,"id":17256,"name":"均禾"},{"count":2,"id":1181,"name":"同和/京溪"},{"count":1,"id":16022,"name":"石井"},{"count":1,"id":1492,"name":"罗冲围/金沙洲"},{"count":1,"id":7535,"name":"嘉裕太阳城"},{"count":1,"id":7536,"name":"五号停机坪"},{"count":1,"id":7537,"name":"黄石"},{"count":1,"id":7539,"name":"万达广场"},{"count":1,"id":27976,"name":"白云国际机场"},{"count":1,"id":16091,"name":"钟落潭"},{"count":1,"id":18064,"name":"太和镇"},{"count":1,"id":734,"name":"机场路沿线"}]},{"count":23,"id":22,"name":"天河区","subItems":[{"count":23,"id":-1,"name":"全部"},{"count":4,"id":1164,"name":"东圃"},{"count":3,"id":7791,"name":"花城汇/高德置地"},{"count":3,"id":717,"name":"棠下"},{"count":2,"id":13875,"name":"正佳广场"},{"count":2,"id":15110,"name":"兴盛路/猎德"},{"count":2,"id":715,"name":"岗顶/龙口"},{"count":1,"id":1490,"name":"龙洞"},{"count":1,"id":14405,"name":"车陂"},{"count":1,"id":1380,"name":"天河客运站"},{"count":1,"id":13162,"name":"员村"},{"count":1,"id":7783,"name":"天河城/体育西"},{"count":1,"id":14391,"name":"五山"},{"count":1,"id":716,"name":"跑马场"}]},{"count":15,"id":24,"name":"海珠区","subItems":[{"count":15,"id":-1,"name":"全部"},{"count":4,"id":725,"name":"江南大道沿线"},{"count":2,"id":1165,"name":"客村/赤岗"},{"count":2,"id":1178,"name":"东晓南路沿线"},{"count":2,"id":1179,"name":"工业大道沿线"},{"count":1,"id":1494,"name":"江南西"},{"count":1,"id":8961,"name":"琶洲"}]},{"count":12,"id":23,"name":"越秀区","subItems":[{"count":12,"id":-1,"name":"全部"},{"count":4,"id":719,"name":"北京路商业区"},{"count":2,"id":720,"name":"沿江路沿线/二沙岛"},{"count":1,"id":19682,"name":"建设六马路"},{"count":1,"id":1065,"name":"中山二三路/东山口"},{"count":1,"id":21642,"name":"中华广场"},{"count":1,"id":722,"name":"中山六路"},{"count":1,"id":723,"name":"火车站/人民北路"}]},{"count":11,"id":25,"name":"荔湾区","subItems":[{"count":11,"id":-1,"name":"全部"},{"count":2,"id":7669,"name":"西村西场"},{"count":2,"id":1067,"name":"芳村"},{"count":2,"id":729,"name":"上下九商业区"},{"count":1,"id":7540,"name":"康王路"},{"count":1,"id":730,"name":"中山七八路"}]},{"count":9,"id":739,"name":"增城市","subItems":[{"count":9,"id":-1,"name":"全部"},{"count":2,"id":9180,"name":"荔城挂绿/泰富广场"},{"count":2,"id":13113,"name":"凤凰城"},{"count":2,"id":7718,"name":"新塘大润发/新好景"},{"count":1,"id":9178,"name":"东汇城/人人乐"},{"count":1,"id":9181,"name":"太阳城/凯旋门"},{"count":1,"id":13071,"name":"万达广场"}]},{"count":8,"id":738,"name":"花都区","subItems":[{"count":8,"id":-1,"name":"全部"},{"count":3,"id":5887,"name":"狮岭"},{"count":2,"id":13356,"name":"北站/建设路"},{"count":2,"id":13362,"name":"大润发"},{"count":1,"id":13904,"name":"花都体育场"}]},{"count":7,"id":737,"name":"黄埔区","subItems":[{"count":7,"id":-1,"name":"全部"},{"count":2,"id":8034,"name":"开发区东区"},{"count":1,"id":22706,"name":"万达广场"},{"count":1,"id":8033,"name":"中心城"},{"count":1,"id":8032,"name":"科学城/萝岗高德汇"},{"count":1,"id":8797,"name":"生活区/南岗"}]},{"count":4,"id":1068,"name":"南沙区","subItems":[{"count":4,"id":-1,"name":"全部"},{"count":1,"id":13850,"name":"华汇广场"},{"count":1,"id":13848,"name":"金洲商业街"},{"count":1,"id":25709,"name":"南沙万达广场"},{"count":1,"id":15267,"name":"大岗"}]},{"count":3,"id":740,"name":"从化市","subItems":[{"count":3,"id":-1,"name":"全部"},{"count":1,"id":13150,"name":"街口/新世纪广场"},{"count":1,"id":16273,"name":"太平镇/太平商业街"},{"count":1,"id":13157,"name":"欣荣宏广场"}]}]}
         * hallType : {"name":"特殊厅","subItems":[{"count":150,"id":-1,"name":"全部"},{"count":16,"id":20019,"name":"IMAX厅"},{"count":12,"id":20021,"name":"杜比全景声厅"},{"count":11,"id":20029,"name":"60帧厅"},{"count":7,"id":20026,"name":"中国巨幕厅"},{"count":7,"id":20022,"name":"4K厅"},{"count":6,"id":20027,"name":"巨幕厅"},{"count":4,"id":20024,"name":"4D厅"},{"count":3,"id":20032,"name":"RealD 6FL厅"},{"count":2,"id":20025,"name":"RealD厅"},{"count":2,"id":20028,"name":"4DX厅"},{"count":2,"id":20033,"name":"LUXE巨幕厅"},{"count":1,"id":20023,"name":"双机3D厅"}]}
         * service : {"name":"服务","subItems":[{"count":150,"id":-1,"name":"全部"},{"count":87,"id":3,"name":"可改签"},{"count":77,"id":2,"name":"可退票"},{"count":74,"id":4,"name":"会员卡"}]}
         * subway : {"name":"地铁","subItems":[{"count":150,"id":-1,"name":"全部"},{"count":31,"id":32,"name":"1号线","subItems":[{"count":11,"id":-1,"name":"全部"},{"count":6,"id":551,"name":"农讲所"},{"count":5,"id":547,"name":"体育西路"},{"count":5,"id":552,"name":"公园前"},{"count":4,"id":555,"name":"长寿路"},{"count":3,"id":546,"name":"体育中心"},{"count":2,"id":556,"name":"黄沙"},{"count":2,"id":554,"name":"陈家祠"},{"count":1,"id":550,"name":"烈士陵园"},{"count":1,"id":549,"name":"东山口"},{"count":1,"id":557,"name":"芳村"},{"count":1,"id":553,"name":"西门口"}]},{"count":30,"id":33,"name":"2号线","subItems":[{"count":15,"id":-1,"name":"全部"},{"count":5,"id":572,"name":"公园前"},{"count":3,"id":575,"name":"江南西"},{"count":3,"id":573,"name":"海珠广场"},{"count":3,"id":576,"name":"昌岗"},{"count":2,"id":567,"name":"飞翔公园"},{"count":2,"id":566,"name":"白云公园"},{"count":2,"id":571,"name":"纪念堂"},{"count":2,"id":577,"name":"江泰路"},{"count":2,"id":578,"name":"东晓南"},{"count":1,"id":563,"name":"江夏"},{"count":1,"id":562,"name":"黄边"},{"count":1,"id":574,"name":"市二宫"},{"count":1,"id":569,"name":"广州火车站"},{"count":1,"id":568,"name":"三元里"},{"count":1,"id":580,"name":"洛溪"}]},{"count":34,"id":34,"name":"3号线","subItems":[{"count":17,"id":-1,"name":"全部"},{"count":5,"id":590,"name":"体育西路"},{"count":3,"id":589,"name":"石牌桥"},{"count":3,"id":591,"name":"珠江新城"},{"count":3,"id":599,"name":"市桥"},{"count":2,"id":587,"name":"华师"},{"count":2,"id":588,"name":"岗顶"},{"count":2,"id":592,"name":"广州塔"},{"count":2,"id":597,"name":"大石"},{"count":2,"id":600,"name":"番禺广场"},{"count":2,"id":4269,"name":"京溪南方医院"},{"count":2,"id":4275,"name":"人和"},{"count":1,"id":585,"name":"天河客运站"},{"count":1,"id":593,"name":"客村"},{"count":1,"id":4266,"name":"白云大道北"},{"count":1,"id":4265,"name":"同和"},{"count":1,"id":4270,"name":"永泰"},{"count":1,"id":4274,"name":"梅花园"}]},{"count":13,"id":35,"name":"3号线支线","subItems":[{"count":7,"id":-1,"name":"全部"},{"count":5,"id":612,"name":"体育西路"},{"count":2,"id":608,"name":"京溪南方医院"},{"count":2,"id":602,"name":"人和"},{"count":1,"id":605,"name":"白云大道北"},{"count":1,"id":607,"name":"同和"},{"count":1,"id":606,"name":"永泰"},{"count":1,"id":1004,"name":"梅花园"}]},{"count":8,"id":36,"name":"4号线","subItems":[{"count":5,"id":-1,"name":"全部"},{"count":3,"id":627,"name":"车陂"},{"count":2,"id":613,"name":"金洲"},{"count":1,"id":614,"name":"蕉门"},{"count":1,"id":623,"name":"大学城北"},{"count":1,"id":625,"name":"万胜围"}]},{"count":20,"id":37,"name":"5号线","subItems":[{"count":14,"id":-1,"name":"全部"},{"count":3,"id":639,"name":"猎德"},{"count":3,"id":640,"name":"珠江新城"},{"count":2,"id":648,"name":"西村"},{"count":2,"id":650,"name":"中山八"},{"count":1,"id":630,"name":"大沙东"},{"count":1,"id":634,"name":"东圃"},{"count":1,"id":638,"name":"潭村"},{"count":1,"id":637,"name":"员村"},{"count":1,"id":636,"name":"科韵路"},{"count":1,"id":652,"name":"滘口"},{"count":1,"id":649,"name":"西场"},{"count":1,"id":645,"name":"淘金"},{"count":1,"id":647,"name":"广州火车站"},{"count":1,"id":646,"name":"小北"}]},{"count":24,"id":78,"name":"6号线","subItems":[{"count":11,"id":-1,"name":"全部"},{"count":6,"id":1551,"name":"北京路"},{"count":4,"id":1543,"name":"海珠广场"},{"count":3,"id":1546,"name":"团一大广场"},{"count":3,"id":1542,"name":"文化公园"},{"count":2,"id":1541,"name":"黄沙"},{"count":1,"id":1548,"name":"区庄"},{"count":1,"id":1544,"name":"一德路"},{"count":1,"id":1547,"name":"长湴"},{"count":1,"id":1540,"name":"东山口"},{"count":1,"id":1536,"name":"河沙"},{"count":1,"id":1532,"name":"天河客运站"}]},{"count":19,"id":38,"name":"8号线","subItems":[{"count":10,"id":-1,"name":"全部"},{"count":3,"id":662,"name":"昌岗"},{"count":3,"id":663,"name":"宝岗大道"},{"count":3,"id":1005,"name":"沙园"},{"count":2,"id":664,"name":"凤凰新村"},{"count":2,"id":661,"name":"晓港"},{"count":2,"id":657,"name":"赤岗"},{"count":1,"id":653,"name":"万胜围"},{"count":1,"id":655,"name":"新港东"},{"count":1,"id":654,"name":"琶洲"},{"count":1,"id":658,"name":"客村"}]},{"count":28,"id":39,"name":"APM线","subItems":[{"count":8,"id":-1,"name":"全部"},{"count":6,"id":668,"name":"黄埔大道"},{"count":5,"id":667,"name":"天河南"},{"count":4,"id":670,"name":"花城大道"},{"count":4,"id":666,"name":"体育中心南"},{"count":3,"id":669,"name":"妇儿中心"},{"count":2,"id":673,"name":"广州塔"},{"count":2,"id":672,"name":"海心沙"},{"count":2,"id":671,"name":"大剧院"}]},{"count":2,"id":40,"name":"广佛线","subItems":[{"count":2,"id":-1,"name":"全部"},{"count":1,"id":3913,"name":"沙涌"},{"count":1,"id":3916,"name":"燕岗"}]}]}
         */

        private BrandBean brand;
        private DistrictBean district;
        private HallTypeBean hallType;
        private ServiceBean service;
        private SubwayBean subway;

        public BrandBean getBrand() {
            return brand;
        }

        public void setBrand(BrandBean brand) {
            this.brand = brand;
        }

        public DistrictBean getDistrict() {
            return district;
        }

        public void setDistrict(DistrictBean district) {
            this.district = district;
        }

        public HallTypeBean getHallType() {
            return hallType;
        }

        public void setHallType(HallTypeBean hallType) {
            this.hallType = hallType;
        }

        public ServiceBean getService() {
            return service;
        }

        public void setService(ServiceBean service) {
            this.service = service;
        }

        public SubwayBean getSubway() {
            return subway;
        }

        public void setSubway(SubwayBean subway) {
            this.subway = subway;
        }

        public static class BrandBean {
            /**
             * name : 品牌
             * subItems : [{"count":150,"id":-1,"name":"全部"},{"count":15,"id":1079568,"name":"金逸影城"},{"count":13,"id":384262,"name":"大地影院"},{"count":7,"id":102642,"name":"万达影城"},{"count":6,"id":1640929,"name":"哈艺时尚影城"},{"count":6,"id":30032,"name":"星美国际影城"},{"count":5,"id":1233223,"name":"中影佰纳国际影城"},{"count":4,"id":26045,"name":"横店电影城"},{"count":3,"id":1156990,"name":"飞扬影城"},{"count":3,"id":348260,"name":"喜洋时代影城"},{"count":3,"id":25383,"name":"烽禾影城"},{"count":2,"id":30898,"name":"中影火山湖电影城"},{"count":2,"id":822548,"name":"百丽宫影城"},{"count":2,"id":24472,"name":"保利国际影城"},{"count":2,"id":2233611,"name":"英皇UA电影城"},{"count":1,"id":26222,"name":"华影万晟国际影城"},{"count":1,"id":413896,"name":"太古仓电影库"},{"count":1,"id":30901,"name":"中影乐佳影城"},{"count":1,"id":152419,"name":"丽江电影城"},{"count":1,"id":29095,"name":"天河电影城"},{"count":1,"id":30227,"name":"耀莱成龙国际影城"},{"count":1,"id":24071,"name":"UME国际影城"},{"count":1,"id":292030,"name":"卢米埃影城"},{"count":1,"id":2020418,"name":"CGV影城"},{"count":1,"id":24745,"name":"橙天嘉禾影城"},{"count":1,"id":494396,"name":"左岸国际影城"},{"count":1,"id":173611,"name":"五月花电影城"},{"count":1,"id":124487,"name":"东圃摩登电影城"},{"count":1,"id":23745,"name":"中影国际影城"},{"count":1,"id":24377,"name":"百老汇影城"},{"count":1,"id":30856,"name":"中华广场电影城"},{"count":1,"id":616001,"name":"星汇电影城"},{"count":1,"id":2880988,"name":"SFC上影影城"},{"count":59,"id":0,"name":"其他"}]
             */

            private String name;
            private List<SubItemsBean> subItems;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<SubItemsBean> getSubItems() {
                return subItems;
            }

            public void setSubItems(List<SubItemsBean> subItems) {
                this.subItems = subItems;
            }

            public static class SubItemsBean {
                /**
                 * count : 150
                 * id : -1
                 * name : 全部
                 */

                private int count;
                private int id;
                private String name;
                public boolean isSelect;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        public static class DistrictBean implements Parcelable{
            /**
             * name : 行政区
             * subItems : [{"count":150,"id":-1,"name":"全部"},{"count":30,"id":274,"name":"番禺区","subItems":[{"count":30,"id":-1,"name":"全部"},{"count":6,"id":1182,"name":"市桥"},{"count":4,"id":7541,"name":"长隆/南村/万达"},{"count":4,"id":1183,"name":"大石"},{"count":3,"id":7542,"name":"钟村"},{"count":3,"id":9023,"name":"市桥南"},{"count":3,"id":1461,"name":"番禺广场"},{"count":2,"id":1184,"name":"大学城"},{"count":1,"id":5187,"name":"洛溪"},{"count":1,"id":9024,"name":"沙湾镇"},{"count":1,"id":9276,"name":"石基"},{"count":1,"id":18905,"name":"南浦"},{"count":1,"id":14179,"name":"石楼"}]},{"count":28,"id":26,"name":"白云区","subItems":[{"count":28,"id":-1,"name":"全部"},{"count":3,"id":1491,"name":"同德围"},{"count":3,"id":1180,"name":"白云大道沿线"},{"count":2,"id":1493,"name":"新市"},{"count":2,"id":17078,"name":"江高"},{"count":2,"id":5193,"name":"嘉禾/人和"},{"count":2,"id":17256,"name":"均禾"},{"count":2,"id":1181,"name":"同和/京溪"},{"count":1,"id":16022,"name":"石井"},{"count":1,"id":1492,"name":"罗冲围/金沙洲"},{"count":1,"id":7535,"name":"嘉裕太阳城"},{"count":1,"id":7536,"name":"五号停机坪"},{"count":1,"id":7537,"name":"黄石"},{"count":1,"id":7539,"name":"万达广场"},{"count":1,"id":27976,"name":"白云国际机场"},{"count":1,"id":16091,"name":"钟落潭"},{"count":1,"id":18064,"name":"太和镇"},{"count":1,"id":734,"name":"机场路沿线"}]},{"count":23,"id":22,"name":"天河区","subItems":[{"count":23,"id":-1,"name":"全部"},{"count":4,"id":1164,"name":"东圃"},{"count":3,"id":7791,"name":"花城汇/高德置地"},{"count":3,"id":717,"name":"棠下"},{"count":2,"id":13875,"name":"正佳广场"},{"count":2,"id":15110,"name":"兴盛路/猎德"},{"count":2,"id":715,"name":"岗顶/龙口"},{"count":1,"id":1490,"name":"龙洞"},{"count":1,"id":14405,"name":"车陂"},{"count":1,"id":1380,"name":"天河客运站"},{"count":1,"id":13162,"name":"员村"},{"count":1,"id":7783,"name":"天河城/体育西"},{"count":1,"id":14391,"name":"五山"},{"count":1,"id":716,"name":"跑马场"}]},{"count":15,"id":24,"name":"海珠区","subItems":[{"count":15,"id":-1,"name":"全部"},{"count":4,"id":725,"name":"江南大道沿线"},{"count":2,"id":1165,"name":"客村/赤岗"},{"count":2,"id":1178,"name":"东晓南路沿线"},{"count":2,"id":1179,"name":"工业大道沿线"},{"count":1,"id":1494,"name":"江南西"},{"count":1,"id":8961,"name":"琶洲"}]},{"count":12,"id":23,"name":"越秀区","subItems":[{"count":12,"id":-1,"name":"全部"},{"count":4,"id":719,"name":"北京路商业区"},{"count":2,"id":720,"name":"沿江路沿线/二沙岛"},{"count":1,"id":19682,"name":"建设六马路"},{"count":1,"id":1065,"name":"中山二三路/东山口"},{"count":1,"id":21642,"name":"中华广场"},{"count":1,"id":722,"name":"中山六路"},{"count":1,"id":723,"name":"火车站/人民北路"}]},{"count":11,"id":25,"name":"荔湾区","subItems":[{"count":11,"id":-1,"name":"全部"},{"count":2,"id":7669,"name":"西村西场"},{"count":2,"id":1067,"name":"芳村"},{"count":2,"id":729,"name":"上下九商业区"},{"count":1,"id":7540,"name":"康王路"},{"count":1,"id":730,"name":"中山七八路"}]},{"count":9,"id":739,"name":"增城市","subItems":[{"count":9,"id":-1,"name":"全部"},{"count":2,"id":9180,"name":"荔城挂绿/泰富广场"},{"count":2,"id":13113,"name":"凤凰城"},{"count":2,"id":7718,"name":"新塘大润发/新好景"},{"count":1,"id":9178,"name":"东汇城/人人乐"},{"count":1,"id":9181,"name":"太阳城/凯旋门"},{"count":1,"id":13071,"name":"万达广场"}]},{"count":8,"id":738,"name":"花都区","subItems":[{"count":8,"id":-1,"name":"全部"},{"count":3,"id":5887,"name":"狮岭"},{"count":2,"id":13356,"name":"北站/建设路"},{"count":2,"id":13362,"name":"大润发"},{"count":1,"id":13904,"name":"花都体育场"}]},{"count":7,"id":737,"name":"黄埔区","subItems":[{"count":7,"id":-1,"name":"全部"},{"count":2,"id":8034,"name":"开发区东区"},{"count":1,"id":22706,"name":"万达广场"},{"count":1,"id":8033,"name":"中心城"},{"count":1,"id":8032,"name":"科学城/萝岗高德汇"},{"count":1,"id":8797,"name":"生活区/南岗"}]},{"count":4,"id":1068,"name":"南沙区","subItems":[{"count":4,"id":-1,"name":"全部"},{"count":1,"id":13850,"name":"华汇广场"},{"count":1,"id":13848,"name":"金洲商业街"},{"count":1,"id":25709,"name":"南沙万达广场"},{"count":1,"id":15267,"name":"大岗"}]},{"count":3,"id":740,"name":"从化市","subItems":[{"count":3,"id":-1,"name":"全部"},{"count":1,"id":13150,"name":"街口/新世纪广场"},{"count":1,"id":16273,"name":"太平镇/太平商业街"},{"count":1,"id":13157,"name":"欣荣宏广场"}]}]
             */

            private String name;
            private List<SubItemsBeanXX> subItems;
            private int count;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<SubItemsBeanXX> getSubItems() {
                return subItems;
            }

            public void setSubItems(List<SubItemsBeanXX> subItems) {
                this.subItems = subItems;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public static class SubItemsBeanXX implements Parcelable{
                /**
                 * count : 150
                 * id : -1
                 * name : 全部
                 * subItems : [{"count":30,"id":-1,"name":"全部"},{"count":6,"id":1182,"name":"市桥"},{"count":4,"id":7541,"name":"长隆/南村/万达"},{"count":4,"id":1183,"name":"大石"},{"count":3,"id":7542,"name":"钟村"},{"count":3,"id":9023,"name":"市桥南"},{"count":3,"id":1461,"name":"番禺广场"},{"count":2,"id":1184,"name":"大学城"},{"count":1,"id":5187,"name":"洛溪"},{"count":1,"id":9024,"name":"沙湾镇"},{"count":1,"id":9276,"name":"石基"},{"count":1,"id":18905,"name":"南浦"},{"count":1,"id":14179,"name":"石楼"}]
                 */

                private int count;
                private int id;
                private String name;
                private List<SubItemsBeanX> subItems;
                public boolean isSelect;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<SubItemsBeanX> getSubItems() {
                    return subItems;
                }

                public void setSubItems(List<SubItemsBeanX> subItems) {
                    this.subItems = subItems;
                }

                public static class SubItemsBeanX implements Parcelable{
                    /**
                     * count : 30
                     * id : -1
                     * name : 全部
                     */

                    private int count;
                    private int id;
                    private String name;

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeInt(this.count);
                        dest.writeInt(this.id);
                        dest.writeString(this.name);
                    }

                    public SubItemsBeanX() {
                    }

                    protected SubItemsBeanX(Parcel in) {
                        this.count = in.readInt();
                        this.id = in.readInt();
                        this.name = in.readString();
                    }

                    public static final Creator<SubItemsBeanX> CREATOR = new Creator<SubItemsBeanX>() {
                        @Override
                        public SubItemsBeanX createFromParcel(Parcel source) {
                            return new SubItemsBeanX(source);
                        }

                        @Override
                        public SubItemsBeanX[] newArray(int size) {
                            return new SubItemsBeanX[size];
                        }
                    };
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.count);
                    dest.writeInt(this.id);
                    dest.writeString(this.name);
                    dest.writeList(this.subItems);
                }

                public SubItemsBeanXX() {
                }

                protected SubItemsBeanXX(Parcel in) {
                    this.count = in.readInt();
                    this.id = in.readInt();
                    this.name = in.readString();
                    this.subItems = new ArrayList<SubItemsBeanX>();
                    in.readList(this.subItems, SubItemsBeanX.class.getClassLoader());
                }

                public static final Creator<SubItemsBeanXX> CREATOR = new Creator<SubItemsBeanXX>() {
                    @Override
                    public SubItemsBeanXX createFromParcel(Parcel source) {
                        return new SubItemsBeanXX(source);
                    }

                    @Override
                    public SubItemsBeanXX[] newArray(int size) {
                        return new SubItemsBeanXX[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.name);
                dest.writeList(this.subItems);
                dest.writeInt(this.count);
            }

            public DistrictBean() {
            }

            protected DistrictBean(Parcel in) {
                this.name = in.readString();
                this.subItems = new ArrayList<SubItemsBeanXX>();
                in.readList(this.subItems, SubItemsBeanXX.class.getClassLoader());
                this.count = in.readInt();
            }

            public static final Creator<DistrictBean> CREATOR = new Creator<DistrictBean>() {
                @Override
                public DistrictBean createFromParcel(Parcel source) {
                    return new DistrictBean(source);
                }

                @Override
                public DistrictBean[] newArray(int size) {
                    return new DistrictBean[size];
                }
            };
        }

        public static class HallTypeBean

        {
            /**
             * name : 特殊厅
             * subItems : [{"count":150,"id":-1,"name":"全部"},{"count":16,"id":20019,"name":"IMAX厅"},{"count":12,"id":20021,"name":"杜比全景声厅"},{"count":11,"id":20029,"name":"60帧厅"},{"count":7,"id":20026,"name":"中国巨幕厅"},{"count":7,"id":20022,"name":"4K厅"},{"count":6,"id":20027,"name":"巨幕厅"},{"count":4,"id":20024,"name":"4D厅"},{"count":3,"id":20032,"name":"RealD 6FL厅"},{"count":2,"id":20025,"name":"RealD厅"},{"count":2,"id":20028,"name":"4DX厅"},{"count":2,"id":20033,"name":"LUXE巨幕厅"},{"count":1,"id":20023,"name":"双机3D厅"}]
             */

            private String name;
            private List<SubItemsBeanXXX> subItems;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<SubItemsBeanXXX> getSubItems() {
                return subItems;
            }

            public void setSubItems(List<SubItemsBeanXXX> subItems) {
                this.subItems = subItems;
            }

            public static class SubItemsBeanXXX {
                /**
                 * count : 150
                 * id : -1
                 * name : 全部
                 */

                private int count;
                private int id;
                private String name;
                public boolean isSelect;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        public static class ServiceBean {
            /**
             * name : 服务
             * subItems : [{"count":150,"id":-1,"name":"全部"},{"count":87,"id":3,"name":"可改签"},{"count":77,"id":2,"name":"可退票"},{"count":74,"id":4,"name":"会员卡"}]
             */

            private String name;
            private List<SubItemsBeanXXXX> subItems;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<SubItemsBeanXXXX> getSubItems() {
                return subItems;
            }

            public void setSubItems(List<SubItemsBeanXXXX> subItems) {
                this.subItems = subItems;
            }

            public static class SubItemsBeanXXXX {
                /**
                 * count : 150
                 * id : -1
                 * name : 全部
                 */

                private int count;
                private int id;
                private String name;
                public boolean isSelect;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        public static class SubwayBean implements Parcelable{
            /**
             * name : 地铁
             * subItems : [{"count":150,"id":-1,"name":"全部"},{"count":31,"id":32,"name":"1号线","subItems":[{"count":11,"id":-1,"name":"全部"},{"count":6,"id":551,"name":"农讲所"},{"count":5,"id":547,"name":"体育西路"},{"count":5,"id":552,"name":"公园前"},{"count":4,"id":555,"name":"长寿路"},{"count":3,"id":546,"name":"体育中心"},{"count":2,"id":556,"name":"黄沙"},{"count":2,"id":554,"name":"陈家祠"},{"count":1,"id":550,"name":"烈士陵园"},{"count":1,"id":549,"name":"东山口"},{"count":1,"id":557,"name":"芳村"},{"count":1,"id":553,"name":"西门口"}]},{"count":30,"id":33,"name":"2号线","subItems":[{"count":15,"id":-1,"name":"全部"},{"count":5,"id":572,"name":"公园前"},{"count":3,"id":575,"name":"江南西"},{"count":3,"id":573,"name":"海珠广场"},{"count":3,"id":576,"name":"昌岗"},{"count":2,"id":567,"name":"飞翔公园"},{"count":2,"id":566,"name":"白云公园"},{"count":2,"id":571,"name":"纪念堂"},{"count":2,"id":577,"name":"江泰路"},{"count":2,"id":578,"name":"东晓南"},{"count":1,"id":563,"name":"江夏"},{"count":1,"id":562,"name":"黄边"},{"count":1,"id":574,"name":"市二宫"},{"count":1,"id":569,"name":"广州火车站"},{"count":1,"id":568,"name":"三元里"},{"count":1,"id":580,"name":"洛溪"}]},{"count":34,"id":34,"name":"3号线","subItems":[{"count":17,"id":-1,"name":"全部"},{"count":5,"id":590,"name":"体育西路"},{"count":3,"id":589,"name":"石牌桥"},{"count":3,"id":591,"name":"珠江新城"},{"count":3,"id":599,"name":"市桥"},{"count":2,"id":587,"name":"华师"},{"count":2,"id":588,"name":"岗顶"},{"count":2,"id":592,"name":"广州塔"},{"count":2,"id":597,"name":"大石"},{"count":2,"id":600,"name":"番禺广场"},{"count":2,"id":4269,"name":"京溪南方医院"},{"count":2,"id":4275,"name":"人和"},{"count":1,"id":585,"name":"天河客运站"},{"count":1,"id":593,"name":"客村"},{"count":1,"id":4266,"name":"白云大道北"},{"count":1,"id":4265,"name":"同和"},{"count":1,"id":4270,"name":"永泰"},{"count":1,"id":4274,"name":"梅花园"}]},{"count":13,"id":35,"name":"3号线支线","subItems":[{"count":7,"id":-1,"name":"全部"},{"count":5,"id":612,"name":"体育西路"},{"count":2,"id":608,"name":"京溪南方医院"},{"count":2,"id":602,"name":"人和"},{"count":1,"id":605,"name":"白云大道北"},{"count":1,"id":607,"name":"同和"},{"count":1,"id":606,"name":"永泰"},{"count":1,"id":1004,"name":"梅花园"}]},{"count":8,"id":36,"name":"4号线","subItems":[{"count":5,"id":-1,"name":"全部"},{"count":3,"id":627,"name":"车陂"},{"count":2,"id":613,"name":"金洲"},{"count":1,"id":614,"name":"蕉门"},{"count":1,"id":623,"name":"大学城北"},{"count":1,"id":625,"name":"万胜围"}]},{"count":20,"id":37,"name":"5号线","subItems":[{"count":14,"id":-1,"name":"全部"},{"count":3,"id":639,"name":"猎德"},{"count":3,"id":640,"name":"珠江新城"},{"count":2,"id":648,"name":"西村"},{"count":2,"id":650,"name":"中山八"},{"count":1,"id":630,"name":"大沙东"},{"count":1,"id":634,"name":"东圃"},{"count":1,"id":638,"name":"潭村"},{"count":1,"id":637,"name":"员村"},{"count":1,"id":636,"name":"科韵路"},{"count":1,"id":652,"name":"滘口"},{"count":1,"id":649,"name":"西场"},{"count":1,"id":645,"name":"淘金"},{"count":1,"id":647,"name":"广州火车站"},{"count":1,"id":646,"name":"小北"}]},{"count":24,"id":78,"name":"6号线","subItems":[{"count":11,"id":-1,"name":"全部"},{"count":6,"id":1551,"name":"北京路"},{"count":4,"id":1543,"name":"海珠广场"},{"count":3,"id":1546,"name":"团一大广场"},{"count":3,"id":1542,"name":"文化公园"},{"count":2,"id":1541,"name":"黄沙"},{"count":1,"id":1548,"name":"区庄"},{"count":1,"id":1544,"name":"一德路"},{"count":1,"id":1547,"name":"长湴"},{"count":1,"id":1540,"name":"东山口"},{"count":1,"id":1536,"name":"河沙"},{"count":1,"id":1532,"name":"天河客运站"}]},{"count":19,"id":38,"name":"8号线","subItems":[{"count":10,"id":-1,"name":"全部"},{"count":3,"id":662,"name":"昌岗"},{"count":3,"id":663,"name":"宝岗大道"},{"count":3,"id":1005,"name":"沙园"},{"count":2,"id":664,"name":"凤凰新村"},{"count":2,"id":661,"name":"晓港"},{"count":2,"id":657,"name":"赤岗"},{"count":1,"id":653,"name":"万胜围"},{"count":1,"id":655,"name":"新港东"},{"count":1,"id":654,"name":"琶洲"},{"count":1,"id":658,"name":"客村"}]},{"count":28,"id":39,"name":"APM线","subItems":[{"count":8,"id":-1,"name":"全部"},{"count":6,"id":668,"name":"黄埔大道"},{"count":5,"id":667,"name":"天河南"},{"count":4,"id":670,"name":"花城大道"},{"count":4,"id":666,"name":"体育中心南"},{"count":3,"id":669,"name":"妇儿中心"},{"count":2,"id":673,"name":"广州塔"},{"count":2,"id":672,"name":"海心沙"},{"count":2,"id":671,"name":"大剧院"}]},{"count":2,"id":40,"name":"广佛线","subItems":[{"count":2,"id":-1,"name":"全部"},{"count":1,"id":3913,"name":"沙涌"},{"count":1,"id":3916,"name":"燕岗"}]}]
             */

            private String name;
            private List<SubItemsBeanXXXXXX> subItems;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<SubItemsBeanXXXXXX> getSubItems() {
                return subItems;
            }

            public void setSubItems(List<SubItemsBeanXXXXXX> subItems) {
                this.subItems = subItems;
            }

            public static class SubItemsBeanXXXXXX {
                /**
                 * count : 150
                 * id : -1
                 * name : 全部
                 * subItems : [{"count":11,"id":-1,"name":"全部"},{"count":6,"id":551,"name":"农讲所"},{"count":5,"id":547,"name":"体育西路"},{"count":5,"id":552,"name":"公园前"},{"count":4,"id":555,"name":"长寿路"},{"count":3,"id":546,"name":"体育中心"},{"count":2,"id":556,"name":"黄沙"},{"count":2,"id":554,"name":"陈家祠"},{"count":1,"id":550,"name":"烈士陵园"},{"count":1,"id":549,"name":"东山口"},{"count":1,"id":557,"name":"芳村"},{"count":1,"id":553,"name":"西门口"}]
                 */

                private int count;
                private int id;
                private String name;
                private List<SubItemsBeanXXXXX> subItems;
                public boolean isSelect;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<SubItemsBeanXXXXX> getSubItems() {
                    return subItems;
                }

                public void setSubItems(List<SubItemsBeanXXXXX> subItems) {
                    this.subItems = subItems;
                }

                public static class SubItemsBeanXXXXX {
                    /**
                     * count : 11
                     * id : -1
                     * name : 全部
                     */

                    private int count;
                    private int id;
                    private String name;

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.name);
                dest.writeList(this.subItems);
            }

            public SubwayBean() {
            }

            protected SubwayBean(Parcel in) {
                this.name = in.readString();
                this.subItems = new ArrayList<SubItemsBeanXXXXXX>();
                in.readList(this.subItems, SubItemsBeanXXXXXX.class.getClassLoader());
            }

            public static final Creator<SubwayBean> CREATOR = new Creator<SubwayBean>() {
                @Override
                public SubwayBean createFromParcel(Parcel source) {
                    return new SubwayBean(source);
                }

                @Override
                public SubwayBean[] newArray(int size) {
                    return new SubwayBean[size];
                }
            };
        }
    }
}

package com.cicinnus.cateye.base;

/**
 * Created by Administrator on 2017/1/18.
 */

public interface BaseConstant {
    //底部4个Tab
    int RB_MOVIE = 0;
    int RB_CINEMA = 1;
    int RB_DISCOVER = 2;
    int RB_MINE = 3;

    //发现列表2种类型的item
    int TYPE_DISCOVER_ONE_IMG = 0;
    int TYPE_DISCOVER_MULTI_IMG = 1;
    int TYPE_DISCOVER_BIG_IMG = 2;
    int TYPE_DISCOVER_ONE_BIG_IMG = 3;


    //首页热映的2种item
    int TYPE_HOT_HEADLINE = 0;//第一个热门
    int TYPE_HOT_NORMAL = 1;//正常
    int TYPE_HOT_PRE_SELL = 2;//预售

    //待映5种item
    int TYPE_WAIT_DIVIDER = 0;//悬浮item
    int TYPE_WAIT_HEADLINES = 1;//有专访的item
    int TYPE_WAIT_TRAILER = 2;//预告片
    int TYPE_WAIT_RECENT = 3;//近期受期待
    int TYPE_WAIT_NORMAL = 4;//正常

    //分类查找
    int TYPE_CLASSIFY_NORMAL = 0;//不在上映
    int TYPE_CLASSIFY_WISH = 1;//想看
    int TYPE_CLASSIFY_BUY = 2;//可以购票
    int TYPE_CLASSIFY_PRESALE = 3;//预售

    //海外电影
    int TYPE_OVERSEA_NORMAL = 0;//普通
    int TYPE_OVERSEA_PRESALE = 1;//预售
    int TYPE_OVERSEA_BUY = 2;//可以购票
    int TYPE_OVERSEA_HEAD_LINE = 3;//有专题内容
    int TYPE_OVERSEA_FOOTER = 4;//尾部点击查看更多

    //电影奖项
    int TYPE_AWARDS_MOVIE = 0;//最佳电影
    int TYPE_AWARDS_PEOPLE = 1;//最佳导演

    //视频/图片
    int TYPE_MOVIE_DETAIL_VEDIO = 0;
    int TYPE_MOVIE_DETAIL_PHOTO = 1;

    //视频评论
    int TYPE_VIDEO_COMMENT_REPLY =0;//有回复
    int TYPE_VIDEO_COMMENT_NO_REPLY=1;//没有回复

}


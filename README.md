# CatEye v3
## 高仿猫眼App(8.x) 2017-11-18


# CatEye v2
## ~~高仿猫眼App(7.9.1)~~


### 项目初衷
一直以来看到很多开源项目都是什么MaterialDesign(后面简称MD),但是真的是这样吗,个人觉得这些项目只是为了MD而MD,用几个控件就说自己的是MD风格,写了几个XML就觉得把MD的控件用熟了,如果是这样,我宁愿不用!对于真正是MD的App我只在Google市场和一些真正优秀的开源项目看到过,至于国内的目前我只看到了B站.

### 为什么不参照一些设计和交互都不错的应用?学习优秀的界面和交互设计,所以就有了高仿猫眼电影App,项目磕磕碰碰完成了大部分的UI界面,其中涉及用户的界面全都没有做,

### 
   - NOTICE: 又开始更新了..
### 主要使用技术：
  - RxJava2+Retrofit2+MVP
  - [BaseQuickAdapter](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)
  - Glide
  - [JieCaoVideoPlayer](https://github.com/lipangit/JieCaoVideoPlayer)
  - and More..
  
### 能从项目中学到什么?
  - [x] RxJava2+Retrofit2+MVP的封装
  - [x] RxJava2与Retrofit结合的操作符使用
  - [x] Retrofit添加全局请求参数
  - [x] RecyclerView悬浮头部(选择城市,待映列表)
  - [x] 高斯模糊工具类实现
  - [x] 非入侵的自定义下拉刷新实现
  - [x] ViewPager的画廊实现(影院详情页)
  
### 截图
![](https://github.com/Cicinnus0407/CatEye/blob/v2/screenShoot/device-2017-07-01-170714.png)
![](https://github.com/Cicinnus0407/CatEye/blob/v2/screenShoot/device-2017-07-01-170754.png)
![](https://github.com/Cicinnus0407/CatEye/blob/v2/screenShoot/device-2017-07-01-170833.png)
</br>
![](https://github.com/Cicinnus0407/CatEye/blob/v2/screenShoot/device-2017-07-01-170944.png)
![](https://github.com/Cicinnus0407/CatEye/blob/v2/screenShoot/device-2017-07-01-171000.png)
![](https://github.com/Cicinnus0407/CatEye/blob/v2/screenShoot/device-2017-07-01-171423.png)
</br>
![](https://github.com/Cicinnus0407/CatEye/blob/v2/screenShoot/device-2017-07-01-171502.png)
![](https://github.com/Cicinnus0407/CatEye/blob/v2/screenShoot/device-2017-07-01-172138.png)
![](https://github.com/Cicinnus0407/CatEye/blob/v2/screenShoot/device-2017-07-01-172240.png)
</br>
![](https://github.com/Cicinnus0407/CatEye/blob/v2/screenShoot/device-2017-07-01-172359.png)
</br>

###注意事项

- 本项目数据来源自网络抓包，请勿用于商业用途，如因商业性质导致纠纷本人概不负责，数据内容如有侵权立即删除</br>
- MVP架构参考：</br>
[MVP+Rxjava+Retrofit构建项目](http://www.jianshu.com/p/b1da0387f805 )</br>
[步一步实现Android的MVP框架](http://mp.weixin.qq.com/s?__biz=MzA3NTYzODYzMg==&mid=2653577546&idx=1&sn=e10be159645a3aa8f6d6f209420fb412&scene=0#wechat_redirect)


#License
```
Copyright (C) 2017 钟嵘光
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

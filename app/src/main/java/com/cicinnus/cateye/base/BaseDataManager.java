package com.cicinnus.cateye.base;

import rx.Observable;

/**
 * Created by Administrator on 2017/2/8.
 */

public abstract class BaseDataManager<T>  {
    public abstract Observable<T> getDataFromServer();
}

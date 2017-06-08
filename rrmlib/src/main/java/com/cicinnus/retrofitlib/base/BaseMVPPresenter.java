package com.cicinnus.retrofitlib.base;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * BaseMVPPresenter，封装调用链
 */

public class BaseMVPPresenter<T> implements ICorePresenter {
    private static final String TAG = "BaseMVPPresenter";
    protected Activity mActivity;//与Activity交互
    protected T mView;//Presenter持有的View
    private CompositeDisposable disposables2Stop;// 管理Stop取消订阅者者
    private CompositeDisposable disposables2Destroy;// 管理Destroy取消订阅者者
    private ArrayMap<String, Disposable> disposable2StopArrayMap;//管理Stop集合
    private ArrayMap<String, Disposable> disposable2DestroyArrayMap;//管理Destroy集合


    public BaseMVPPresenter(Activity activity, T view) {
        this.mActivity = activity;
        this.mView = view;

    }


    /**
     * 将调用链加入，直到onStop触发
     *
     * @param tag        加入调用链时的tag
     * @param disposable 传入一个disposable实现类，即rx调用链
     */
    protected void addSubscribeUntilStop(String tag, Disposable disposable) {
        if (disposables2Stop == null) {
            disposables2Stop = new CompositeDisposable();
        }
        if( disposable2StopArrayMap==null){
            disposable2StopArrayMap = new ArrayMap<>();
        }
        disposables2Stop.add(disposable);
        disposable2StopArrayMap.put(tag, disposable);

    }

    /**
     * 将调用链加入，直到onStop触发
     *
     * @param disposable 传入一个disposable实现类，即rx调用链
     */
    protected void addSubscribeUntilStop(Disposable disposable) {
        if (disposables2Stop == null) {
            disposables2Stop = new CompositeDisposable();
        }
        disposables2Stop.add(disposable);

    }

    /**
     * onStop触发停止调用链
     */
    private void unSubscribeWhenStop() {
        if (disposables2Stop != null) {
            disposables2Stop.dispose();
            disposables2Stop = null;
        }
        if (disposable2StopArrayMap != null && disposable2StopArrayMap.size() > 0) {
            disposable2StopArrayMap.clear();
        }
    }

    /**
     * 将调用链 加入，直到调用onDestroy
     *
     * @param tag        加入调用链时的tag
     * @param disposable 传入一个disposable实现类，即rx调用链
     */
    protected void addSubscribeUntilDestroy(@NonNull String tag, Disposable disposable) {
        if (disposables2Destroy == null) {
            disposables2Destroy = new CompositeDisposable();
        }
        if(disposable2DestroyArrayMap==null){
            disposable2DestroyArrayMap = new ArrayMap<>();
        }
        disposable2DestroyArrayMap.put(tag, disposable);
        disposables2Destroy.add(disposable);

    }

    /**
     * 将调用链 加入，直到调用onDestroy
     *
     * @param disposable 传入一个disposable实现类，即rx调用链
     */
    protected void addSubscribeUntilDestroy(Disposable disposable) {
        if (disposables2Destroy == null) {
            disposables2Destroy = new CompositeDisposable();
        }
        disposables2Destroy.add(disposable);
    }

    /**
     * onDestroy触发停止调用链
     */
    private void unSubscribeWhenDestroy() {
        if (disposables2Destroy != null) {
            disposables2Destroy.dispose();
            disposables2Destroy = null;
        }
        if (disposable2DestroyArrayMap != null && disposable2DestroyArrayMap.size() > 0) {
            disposable2DestroyArrayMap.clear();
        }
    }

    /**
     * 移除一个或多个调用方法
     */
    protected void removeDisposable(Disposable... disposables) {
        if (disposables2Destroy != null) {
            for (Disposable d : disposables) {
                disposables2Destroy.remove(d);
            }
        }
        if (disposables2Stop != null) {
            for (Disposable d : disposables) {
                disposables2Stop.remove(d);
            }
        }

    }

    /**
     * 通过tag移除多个调用链
     *
     * @param tags 订阅时候的tag
     */
    public void removeDisposableByTag(String... tags) {
        if (disposable2DestroyArrayMap!=null&&disposable2DestroyArrayMap.size() > 0) {
            for (String tag : tags) {
                if (disposable2DestroyArrayMap.containsKey(tag)) {
                    disposables2Destroy.remove(disposable2DestroyArrayMap.get(tag));
                    disposable2DestroyArrayMap.remove(tag);
                } else {
                    throw new RuntimeException("没有该tag: "+tag);
                }
            }
        }
        if (disposable2StopArrayMap!=null&&disposable2StopArrayMap.size() > 0) {
            for (String tag : tags) {
                if (disposable2StopArrayMap.containsKey(tag)) {
                    disposables2Stop.remove(disposable2StopArrayMap.get(tag));
                    disposable2StopArrayMap.remove(tag);
                }else {
                    throw new RuntimeException("没有该tag: "+tag);
                }
            }
        }

    }

    @Override
    public void onViewStop() {
        unSubscribeWhenStop();
    }

    @Override
    public void onViewDestroy() {
        unSubscribeWhenDestroy();
    }
}

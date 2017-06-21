package com.cicinnus.cateye.tools;

import android.app.Activity;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import java.lang.ref.WeakReference;

/**
 * 高德定位工具类
 */

public class LocationUtil {

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
    //定位模式,默认为省电模式
    public AMapLocationClientOption.AMapLocationMode aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Device_Sensors;
    //定位信息
    private AMapLocation mLocationInfo;

    public LocationUtil setOnLocationChangeListener(OnLocationChangeListener onLocationChangeListener) {
        this.onLocationChangeListener = onLocationChangeListener;
        return this;
    }

    //回调
    public OnLocationChangeListener onLocationChangeListener;

    public LocationUtil(final WeakReference<Activity> mContext) {
        mLocationClient = new AMapLocationClient(mContext.get());
        initOption();
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {

                if (amapLocation != null) {
                    if (amapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。
                        mLocationInfo = amapLocation;
                        if (onLocationChangeListener != null) {
                            onLocationChangeListener.onChange(amapLocation);
                        }
                    } else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError", "location Error, ErrCode:"
                                + amapLocation.getErrorCode() + ", errInfo:"
                                + amapLocation.getErrorInfo());
                        if (onLocationChangeListener != null) {
                            onLocationChangeListener.onLocateFail(amapLocation);
                        }
                    }
                }
            }
        });

    }

    private void initOption() {
              //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。
        // 如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(true);

    }


    /**
     * 开始定位
     */
    public void startLocation() {
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.startLocation();

    }

    /**
     * 设置是否进行单次定位,默认true
     *
     * @param once
     */
    public LocationUtil setOnceLocation(boolean once) {
        mLocationOption.setOnceLocation(once);
        return this;
    }

    /**
     * 设置定位精度模式
     * @param mode
     */
    public LocationUtil setLocationType(AMapLocationClientOption.AMapLocationMode mode){
        this.aMapLocationMode = mode;
        mLocationOption.setLocationMode(aMapLocationMode);
        return this;
    }

    /**
     * 获取经度
     */
    public double getLongtitude() {
        return mLocationInfo.getLongitude();
    }

    /**
     * 获取维度
     */
    public double getLatitude() {
        return mLocationInfo.getLatitude();
    }

    /**
     * 获取地址
     */
    public String getAddress() {
        return mLocationInfo.getAddress();
    }

    /**
     * 停止定位,本地定位服务并不会被销毁
     */
    public void stopLocation() {
        mLocationClient.stopLocation();
    }

    /**
     * 销毁定位客户端，同时销毁本地定位服务。
     */
    public void destroyLocation() {
        if (mLocationClient != null) {
            mLocationClient.onDestroy();
            mLocationClient = null;
        }
    }

    public interface OnLocationChangeListener {
        void onChange(AMapLocation amapLocation);

        void onLocateFail(AMapLocation amapLocation);
    }
}

package com.cicinnus.cateye.module.movie.find_movie.fixedboard_movie.oversea_movie;

import android.app.Activity;

import com.cicinnus.cateye.base.BasePresenter;
import com.cicinnus.cateye.net.SchedulersCompat;
import com.cicinnus.cateye.tools.ErrorHanding;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class OverseaMoviePresenter extends BasePresenter<OverseaMovieContract.IOverseaMovieView> implements OverseaMovieContract.IOverseaMoviePresenter {

    private final OverseaMovieManager overseaMovieManager;

    public OverseaMoviePresenter(Activity activity, OverseaMovieContract.IOverseaMovieView view) {
        super(activity, view);
        overseaMovieManager = new OverseaMovieManager();
    }

    @Override
    public void getOverseaMovie(final String area) {
        mView.showLoading();
        addSubscribe(overseaMovieManager.getOverseaMovie(area)
                .map(new Func1<ResponseBody, OverseaMovieBean.DataBeanXXX.HotDataBean.DataBeanXX>() {
                    @Override
                    public OverseaMovieBean.DataBeanXXX.HotDataBean.DataBeanXX call(ResponseBody responseBody) {
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            JSONObject data = (JSONObject) jsonObject.get("data");
                            JSONObject hotData = (JSONObject) data.get("http://api.maoyan.com/mmdb/movie/oversea/hot.json?area=" + area + "&offset=0&limit=10");
                            JSONObject hot = (JSONObject) hotData.get("data");
                            return new Gson().fromJson(hot.toString(), OverseaMovieBean.DataBeanXXX.HotDataBean.DataBeanXX.class);
                        } catch (JSONException | IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                })
                .compose(SchedulersCompat.<OverseaMovieBean.DataBeanXXX.HotDataBean.DataBeanXX>applyIoSchedulers())
                .subscribe(new Subscriber<OverseaMovieBean.DataBeanXXX.HotDataBean.DataBeanXX>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(ErrorHanding.handleError(e));
                    }

                    @Override
                    public void onNext(OverseaMovieBean.DataBeanXXX.HotDataBean.DataBeanXX dataBeanXX) {
                        mView.addOverseaMovie(dataBeanXX.getHot());
                    }
                }));
    }
}

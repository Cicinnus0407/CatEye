package com.cicinnus.cateye.module.movie.find_movie.awards_movie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean.AwardsMovieListBean;
import com.cicinnus.cateye.view.FloatingItemDecoration;
import com.orhanobut.logger.Logger;

import java.util.HashMap;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/6.
 */

public class AwardsMovieActivity extends BaseActivity<AwardsMoviePresenter> implements AwardsMovieContract.IAwardsMovieView {


    public static void start(Context context) {
        Intent starter = new Intent(context, AwardsMovieActivity.class);
        context.startActivity(starter);
    }

    @BindView(R.id.rv_awards_movie)
    RecyclerView rvAwardsMovie;

    private AwardsMovieListAdapter awardsMovieListAdapter;

    private String festSessionId = "4071";
    private int offset = 0;
    private FloatingItemDecoration floatingItemDecoration;
    private HashMap<Integer, String> keys;
    private int currentSize = 0;
    private int currentIndex;

    @Override
    protected int getLayout() {
        return R.layout.activity_awards_movie;
    }


    @Override
    protected AwardsMoviePresenter getPresenter() {
        return new AwardsMoviePresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        awardsMovieListAdapter = new AwardsMovieListAdapter();
        rvAwardsMovie.setAdapter(awardsMovieListAdapter);
        rvAwardsMovie.setLayoutManager(new LinearLayoutManager(mContext));

//        awardsMovieListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                mPresenter.getAwardsMovie(festSessionId, offset);
//            }
//        });
        floatingItemDecoration = new FloatingItemDecoration(mContext);
        rvAwardsMovie.addItemDecoration(floatingItemDecoration);
        mPresenter.getAwardsMovie(festSessionId, offset);
        keys = new HashMap<>();
    }

    @Override
    public void addIAwardsMovie(AwardsMovieListBean.DataBean data) {
//        keys.put(currentSize, data.getAwards().get(0).getPrizeName());
        for (int i = 0; i < data.getAwards().size(); i++) {
            if (i < data.getAwards().size() - 1) {
                if (data.getAwards().get(i).getPrizeName().equals(data.getAwards().get(i + 1).getPrizeName())) {
                    //前一个标题与后一个相等
                    currentSize += 1;
                } else {
                    Logger.d("应该显示的标题数" + currentIndex+"显示的位置："+currentIndex+currentSize);
                    keys.put(currentIndex + currentSize, data.getAwards().get(i).getPrizeName());
                    currentSize = 1;
                    currentIndex += 1;

                }
            }
//       sdxcv  keys.put(currentSize, data.getAwards().get(i).getPrizeName());
//
        }
        offset += 10;
        floatingItemDecoration.setKeys(keys);
        awardsMovieListAdapter.addData(data.getAwards());
//        if (data.getAwards().size() > 0) {
//            for (int i = 0; i < data.getAwards().size(); i++) {
//                if(i<data.getAwards().size()-1){
//                    if (!data.getAwards().get(i).getPrizeName().equals(data.getAwards().get(i+1).getPrizeName())) {
//                        //前一个标题与后一个不相等
//                        currentSize+=1;
//                        keys.put(currentSize,data.getAwards().get(i).getPrizeName());
//                    }
//                }
//            }
//            offset+=10;
//            awardsMovieListAdapter.addData(data.getAwards());
//            awardsMovieListAdapter.loadMoreComplete();
//            floatingItemDecoration.setKeys(keys);
//        } else {
//            awardsMovieListAdapter.loadMoreEnd();
//        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(String errorMsg) {
        Logger.e(errorMsg);
    }
}

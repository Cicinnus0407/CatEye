package com.cicinnus.cateye.module.movie.find_movie.awards_movie.awards_list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.module.movie.find_movie.awards_movie.AwardsMovieActivity;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/2/7.
 */

public class AwardsListActivity extends BaseActivity<AwardsListPresenter> implements AwardsListContract.IAwardsListView {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_awards_list)
    RecyclerView rvAwardsList;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    private AwardsListAdapter adapter;//分组adapter
    private MyPullToRefreshListener pullListener;


    public static final String COME_FROM_FIND_MOVIE = "come_from_find_movie";
    private boolean isComeFromFindMovie;

    public static void start(Context context,boolean isComeFromFindMovie) {
        Intent starter = new Intent(context, AwardsListActivity.class);
        starter.putExtra(COME_FROM_FIND_MOVIE,isComeFromFindMovie);
        context.startActivity(starter);
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_awards_list;
    }

    @Override
    protected AwardsListPresenter getPresenter() {
        return new AwardsListPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {

        isComeFromFindMovie = getIntent().getBooleanExtra(COME_FROM_FIND_MOVIE,false);

        tvTitle.setText("全球电影奖项");
        adapter = new AwardsListAdapter();
        //分组Adapter需要使用瀑布流布局
        rvAwardsList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvAwardsList.setAdapter(adapter);
        pullListener = new MyPullToRefreshListener(mContext, swipe);
        swipe.setOnPullRefreshListener(pullListener);
        pullListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                adapter.setNewData(new ArrayList<AwardsSection>());
                mPresenter.getAwardsList();
            }
        });
        adapter.setOnAwardsClickListener(new AwardsListAdapter.OnAwardsClickListener() {
            @Override

            public void onClick(int festivalId) {
                Intent intent = new Intent(mContext,AwardsMovieActivity.class);
                intent.putExtra(AwardsMovieActivity.ID, festivalId);
                if (isComeFromFindMovie) {
                    intent.putExtra(AwardsMovieActivity.COME_FROM_FIND_MOVIE,true);
                    startActivity(intent);
                }else {
                    setResult( RESULT_OK, intent);
                    finish();

                }
            }
        });

        mPresenter.getAwardsList();
    }

    @OnClick({R.id.rl_back})
    void onClick(View view){
        finish();
    }



    @Override
    public void addAwardsList(List<AwardsListBean.DataBean> data) {
        List<AwardsSection> awardsSectionList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            //6组
            awardsSectionList.add(new AwardsSection(true, data.get(i).getRegion()));
            for (int j = 0; j < data.get(i).getFestivals().size(); j++) {
                awardsSectionList.add(new AwardsSection(data.get(i).getFestivals().get(j)));
            }
        }
        adapter.setNewData(awardsSectionList);
    }

    @Override
    public void showLoading() {
        if (!progressLayout.isContent()) {
            progressLayout.showLoading();
        }
    }

    @Override
    public void showContent() {
        pullListener.refreshDone();
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        pullListener.refreshDone();
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getAwardsList();
            }
        });
    }

    @Override
    protected void onPause() {
        overridePendingTransition(0,0);
        super.onPause();
    }
}

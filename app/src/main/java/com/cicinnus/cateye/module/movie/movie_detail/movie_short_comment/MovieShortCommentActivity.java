package com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieCommentTagBean;
import com.cicinnus.cateye.module.movie.movie_detail.bean.MovieShortCommentBean;
import com.cicinnus.cateye.tools.UiUtils;
import com.cicinnus.cateye.view.FloatingItemDecoration;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * 所有短评
 */

public class MovieShortCommentActivity extends BaseActivity<MovieShortCommentPresenter> implements MovieShortCommentContract.IMovieShortCommentView {

    private static final int SHORT_COMMENT_LIMIT = 10;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_short_comment)
    RecyclerView rvShortComment;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;

    private int tag;//评论类型
    private int offset;//偏移量
    private int movieId;//电影id
    private MyPullToRefreshListener pullToRefreshListener;
    private MovieShortCommentListAdapter commentListAdapter;
    private TagFlowLayout tagFlowLayout;
    private FloatingItemDecoration floatingItemDecoration;
    private int mCurrentPosition;
    private TextView tvAllShortComment;

    public static void start(Context context, int movieId, String movieName,int tag,int position) {
        Intent starter = new Intent(context, MovieShortCommentActivity.class);
        starter.putExtra("movieId", movieId);
        starter.putExtra("movieName", movieName);
        starter.putExtra("tag",tag);
        starter.putExtra("position",position);
        context.startActivity(starter);
    }



    @Override
    protected int getLayout() {
        return R.layout.activity_short_comment;
    }

    @Override
    protected MovieShortCommentPresenter getPresenter() {
        return new MovieShortCommentPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        String movieName = getIntent().getStringExtra("movieName");
        movieId = getIntent().getIntExtra("movieId", 0);
        tag = getIntent().getIntExtra("tag",0);
        mCurrentPosition = getIntent().getIntExtra("position",0);
        tvTitle.setText(String.format("猫眼短评-%s", movieName));
        initRv();

        mPresenter.getCommentShortComment(movieId, tag, SHORT_COMMENT_LIMIT, offset);

    }


    private void initRv() {
        pullToRefreshListener = new MyPullToRefreshListener(mContext, swipe);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getCommentShortComment(movieId, tag, SHORT_COMMENT_LIMIT, offset);
            }
        });
        swipe.setOnPullRefreshListener(pullToRefreshListener);
        rvShortComment.setLayoutManager(new LinearLayoutManager(mContext));
        commentListAdapter = new MovieShortCommentListAdapter();
        rvShortComment.setAdapter(commentListAdapter);
        commentListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMoreShortComment(movieId, tag, SHORT_COMMENT_LIMIT, offset);
            }
        }, rvShortComment);

        //头部
        View shortCommentHeader = getLayoutInflater().inflate(R.layout.layout_short_comment_header, (ViewGroup) rvShortComment.getParent(), false);
        tagFlowLayout = (TagFlowLayout) shortCommentHeader.findViewById(R.id.tagFlowLayout);
        tvAllShortComment = (TextView) shortCommentHeader.findViewById(R.id.tv_all_short_comment);
        commentListAdapter.addHeaderView(shortCommentHeader);


        floatingItemDecoration = new FloatingItemDecoration(mContext, mContext.getResources().getColor(R.color.divider_normal), 100, 1);
        floatingItemDecoration.setmTitleHeight(UiUtils.dp2px(mContext, 27));
        floatingItemDecoration.setShowFloatingHeaderOnScrolling(true);//悬浮
        rvShortComment.addItemDecoration(floatingItemDecoration);
    }


    @OnClick({R.id.rl_back})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
        }
    }

    @Override
    public void showLoading() {
        progressLayout.showLoading();
    }

    @Override
    public void showContent() {
        progressLayout.showContent();
        pullToRefreshListener.refreshDone();
    }

    @Override
    public void showError(String errorMsg) {
        pullToRefreshListener.refreshDone();
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getCommentShortComment(movieId, tag, SHORT_COMMENT_LIMIT, offset);
            }
        });
    }

    @Override
    public void addMovieShortComment(MovieShortCommentBean movieShortCommentBean) {
        if(tag==0) {
            tvAllShortComment.setText(String.format("所有短评(%s)条", movieShortCommentBean.getPaging().getTotal()));
        }

        commentListAdapter.setNewData(movieShortCommentBean.getData().getCmts());
        HashMap<Integer, String> keys = new HashMap<>();
        if (movieShortCommentBean.getData().getHcmts().size() > 0) {
            keys.put(1, "热门短评");
        }
        keys.put(movieShortCommentBean.getData().getHcmts().size() + 1, "最新短评");
        floatingItemDecoration.setKeys(keys);

        //前面10条是热门评论,将热门数据转换为最新的条目,放到最前面
        Observable.fromIterable(movieShortCommentBean.getData().getHcmts())
                .map(new Function<MovieShortCommentBean.DataBean.HcmtsBean, MovieShortCommentBean.DataBean.CmtsBean>() {
                    @Override
                    public MovieShortCommentBean.DataBean.CmtsBean apply(@NonNull MovieShortCommentBean.DataBean.HcmtsBean hcmtsBean) throws Exception {
                        MovieShortCommentBean.DataBean.CmtsBean cmtsBean = new MovieShortCommentBean.DataBean.CmtsBean();
                        cmtsBean.setId(hcmtsBean.getId());
                        cmtsBean.setNickName(hcmtsBean.getNickName());
                        cmtsBean.setContent(hcmtsBean.getContent());
                        cmtsBean.setApprove(hcmtsBean.getApprove());
                        cmtsBean.setReply(hcmtsBean.getReply());
                        cmtsBean.setCreated(hcmtsBean.getCreated());
                        cmtsBean.setScore(hcmtsBean.getScore());
                        cmtsBean.setUserLevel(hcmtsBean.getUserLevel());
                        cmtsBean.setAvatarurl(hcmtsBean.getAvatarurl());
                        return cmtsBean;
                    }
                })
                .toList()
                .subscribe(new Consumer<List<MovieShortCommentBean.DataBean.CmtsBean>>() {
                    @Override
                    public void accept(@NonNull List<MovieShortCommentBean.DataBean.CmtsBean> cmtsBeen) throws Exception {
                        commentListAdapter.addData(0, cmtsBeen);
                    }
                });
    }

    @Override
    public void addMovieShortCommentTag(final List<MovieCommentTagBean.DataBean> commentTags) {
        commentTags.add(0, new MovieCommentTagBean.DataBean(0, movieId, 0, "全部"));
        final List<String> tags = new ArrayList<>();
        if (commentTags.size() > 1) {
            for (int i = 0; i < commentTags.size(); i++) {
                if (commentTags.get(i).getCount() == 0) {
                    tags.add(commentTags.get(i).getTagName());
                } else {
                    tags.add(commentTags.get(i).getTagName() + " " + commentTags.get(i).getCount());
                }
            }
        }
        TagAdapter tagAdapter = new TagAdapter<String>(tags) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) getLayoutInflater().inflate(R.layout.layout_flow_tv, tagFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        tagFlowLayout.setAdapter(tagAdapter);
        tagFlowLayout.setMaxSelectCount(1);
        tagAdapter.setSelectedList(mCurrentPosition);
        tagFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                mCurrentPosition = position;
                offset = 0;
                tag = commentTags.get(position).getTag();
                mPresenter.getCommentShortComment(movieId, commentTags.get(position).getTag(), SHORT_COMMENT_LIMIT, offset);
                return true;
            }
        });
    }

    @Override
    public void addMoreShortComment(MovieShortCommentBean.DataBean data) {

        if (data.getCmts().size() > 0) {
            offset += 10;
            commentListAdapter.addData(data.getCmts());
            commentListAdapter.loadMoreComplete();
        } else {
            commentListAdapter.loadMoreEnd();
        }


    }

    @Override
    public void loadMoreShotCommentFail(String s) {
        commentListAdapter.loadMoreFail();
    }

}

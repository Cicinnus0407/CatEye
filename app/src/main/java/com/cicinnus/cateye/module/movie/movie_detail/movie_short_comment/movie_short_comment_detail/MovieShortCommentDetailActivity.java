package com.cicinnus.cateye.module.movie.movie_detail.movie_short_comment.movie_short_comment_detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseActivity;
import com.cicinnus.cateye.tools.GlideManager;
import com.cicinnus.cateye.view.CircleImageView;
import com.cicinnus.cateye.view.FloatingItemDecoration;
import com.cicinnus.cateye.view.MyPullToRefreshListener;
import com.cicinnus.cateye.view.ProgressLayout;
import com.cicinnus.cateye.view.RatingBar;
import com.cicinnus.cateye.view.SuperSwipeRefreshLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class MovieShortCommentDetailActivity extends BaseActivity<MovieShortCommentDetailPresenter> implements MovieShortCommentDetailContract.IMovieShortCommentDetailView {


    private static final int LIMIT = 20;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_short_comment_list)
    RecyclerView rvShortCommentList;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;

    private int offset;
    private int mId;
    private MyPullToRefreshListener pullToRefreshListener;
    private MovieShortCommentDetailAdapter shortCommentDetailAdapter;
    private View header;
    private TextView tvAuthorName;
    private TextView tvCommentContent;
    private TextView tvApproveCount;
    private TextView tvReplyCount;
    private TextView tvPubTime;
    private CircleImageView civAuthor;
    private ImageView ivUserLevel;
    private RatingBar ratingBar;

    public static void start(Context context, int id, String movieName) {
        Intent starter = new Intent(context, MovieShortCommentDetailActivity.class);
        starter.putExtra("id", id);
        starter.putExtra("movieName", movieName);
        context.startActivity(starter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_short_comment_detail;
    }

    @Override
    protected MovieShortCommentDetailPresenter getPresenter() {
        return new MovieShortCommentDetailPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {
        mId = getIntent().getIntExtra("id", 0);
        String movieName = getIntent().getStringExtra("movieName");
        tvTitle.setText(String.format("猫眼短评-%s", movieName));
        initSwipe();
        initRv();
        mPresenter.getShortCommentList(mId, LIMIT, offset);

    }


    private void initSwipe() {
        pullToRefreshListener = new MyPullToRefreshListener(mContext, swipe);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getShortCommentList(mId, LIMIT, offset);
            }
        });
        swipe.setOnPullRefreshListener(pullToRefreshListener);

    }

    private void initRv() {
        shortCommentDetailAdapter = new MovieShortCommentDetailAdapter();
        rvShortCommentList.setLayoutManager(new LinearLayoutManager(mContext));
        rvShortCommentList.setAdapter(shortCommentDetailAdapter);

        FloatingItemDecoration floatingItemDecoration = new FloatingItemDecoration(mContext, mContext.getResources().getColor(R.color.text_gray_light), 100, 0.5f);
        rvShortCommentList.addItemDecoration(floatingItemDecoration);

        header = getLayoutInflater().inflate(R.layout.item_short_comment, (ViewGroup) rvShortCommentList.getParent(), false);
        initHeaderView();
        shortCommentDetailAdapter.addHeaderView(header);
    }

    private void initHeaderView() {
        tvAuthorName = (TextView) header.findViewById(R.id.tv_author_name);
        tvCommentContent = (TextView) header.findViewById(R.id.tv_comment_content);
        tvApproveCount = (TextView) header.findViewById(R.id.tv_approve_count);
        tvReplyCount = (TextView) header.findViewById(R.id.tv_reply_count);
        tvPubTime = (TextView) header.findViewById(R.id.tv_pub_time);
        civAuthor = (CircleImageView) header.findViewById(R.id.civ_author);
        ivUserLevel = (ImageView) header.findViewById(R.id.iv_user_level);
        ratingBar = (RatingBar) header.findViewById(R.id.rb_score);
    }

    @OnClick({R.id.rl_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
        }
    }

    @Override
    public void showLoading() {
        if (!progressLayout.isContent()) {
            progressLayout.showLoading();
        }
    }

    @Override
    public void showContent() {
        pullToRefreshListener.refreshDone();
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        pullToRefreshListener.refreshDone();
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getShortCommentList(mId, LIMIT, offset);

            }
        });
    }

    @Override
    public void addShortCommentDetail(MovieShortCommentDetailBean movieShortCommentDetailBean) {
        shortCommentDetailAdapter.setNewData(movieShortCommentDetailBean.getCmts());
        setHeaderContent(movieShortCommentDetailBean.getOcm());
    }

    private void setHeaderContent(MovieShortCommentDetailBean.OcmBean ocm) {
        tvAuthorName.setText(ocm.getNickName());
        tvCommentContent.setText(String.format("%s", ocm.getContent()));
        tvApproveCount.setText(String.format("%s", ocm.getApprove() == 0 ? "赞" : ocm.getApprove()));
        tvReplyCount.setText(String.format("%s", ocm.getReply() == 0 ? "回复" : ocm.getReply()));
        tvPubTime.setText(String.format("%s", ocm.getTime().substring(5, ocm.getTime().indexOf(" "))));
        GlideManager.loadImage(mContext, ocm.getAvatarurl(), civAuthor);

        ratingBar.setStar(ocm.getScore().floatValue());

        Drawable icon = null;
        switch (ocm.getUserLevel()) {
            case 1:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv1);
                break;
            case 2:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv2);
                break;
            case 3:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv3);
                break;
            case 4:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv4);
                break;
            case 5:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv5);
                break;
        }
        ivUserLevel.setImageDrawable(icon);

//                .setText(R.id.tv_author_name,item.getNickName())
//                .setText(R.id.tv_comment_content,String.format("%s",item.getContent()))
//                .setText(R.id.tv_approve_count,String.format("%s",item.getApprove()==0?"赞":item.getApprove()))
//                .setText(R.id.tv_reply_count,String.format("%s",item.getReply()==0?"回复":item.getReply()))
//                .setText(R.id.tv_pub_time, TimeUtils.dateMD(item.getCreated()));
    }


}

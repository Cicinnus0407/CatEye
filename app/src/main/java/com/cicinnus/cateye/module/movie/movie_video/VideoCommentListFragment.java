package com.cicinnus.cateye.module.movie.movie_video;

import android.os.Bundle;

import com.cicinnus.cateye.R;
import com.cicinnus.cateye.base.BaseFragment;

/**
 * Created by Administrator on 2017/2/15.
 */

public class VideoCommentListFragment extends BaseFragment {

    public static VideoCommentListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        VideoCommentListFragment fragment = new VideoCommentListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_comment_list;
    }
}

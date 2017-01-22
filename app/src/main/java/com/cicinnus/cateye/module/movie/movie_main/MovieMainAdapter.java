package com.cicinnus.cateye.module.movie.movie_main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicinnus on 2017/1/22.
 */

public class MovieMainAdapter extends FragmentPagerAdapter {


    private List<Fragment> mFragments;
    private List<String> mTitles;


    public MovieMainAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();
    }

    public void addFragment(List<Fragment> fragments,List<String> titles){
        mFragments.addAll(fragments);
        mTitles.addAll(titles);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}

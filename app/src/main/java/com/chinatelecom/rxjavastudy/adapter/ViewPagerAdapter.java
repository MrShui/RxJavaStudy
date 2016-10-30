package com.chinatelecom.rxjavastudy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.chinatelecom.rxjavastudy.ui.CollectFragment;
import com.chinatelecom.rxjavastudy.ui.HotFragment;
import com.chinatelecom.rxjavastudy.ui.RecommendFragment;
import com.chinatelecom.rxjavastudy.ui.RoundTableFragment;

/**
 * Created by Administrator on 2016/10/30.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitle = {"推荐", "圆桌", "热门", "收藏"};
    private Fragment[] mFragments = {RecommendFragment.newInstance(), RoundTableFragment.newInstance(), HotFragment.newInstance(), CollectFragment.newInstance()};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}

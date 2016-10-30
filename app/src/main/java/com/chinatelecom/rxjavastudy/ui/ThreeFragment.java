package com.chinatelecom.rxjavastudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.adapter.ViewPagerAdapter;
import com.chinatelecom.rxjavastudy.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shui on 16/10/30.
 */

public class ThreeFragment extends BaseFragment {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    public static ThreeFragment newInstance() {
        return new ThreeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_three, container, false);
        ButterKnife.bind(this, inflate);
        initView();
        return inflate;
    }

    private void initView() {
        tabLayout.addTab(tabLayout.newTab().setText("推荐"));
        tabLayout.addTab(tabLayout.newTab().setText("圆桌"));
        tabLayout.addTab(tabLayout.newTab().setText("热门"));
        tabLayout.addTab(tabLayout.newTab().setText("收藏"));
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void initLazy(@Nullable Bundle savedInstanceState) {
        Log.i("TAG", "ThreeFragment");
    }
}

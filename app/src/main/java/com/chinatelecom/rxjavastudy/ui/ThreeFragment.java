package com.chinatelecom.rxjavastudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.ui.base.BaseFragment;

/**
 * Created by Shui on 16/10/31.
 */

public class ThreeFragment extends BaseFragment {
    public static ThreeFragment newInstance() {
        return new ThreeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, null);
    }

    @Override
    protected void initLazy(@Nullable Bundle savedInstanceState) {
        loadRootFragment(R.id.fl_container, ViewPagerFragment.newInstance());
    }
}

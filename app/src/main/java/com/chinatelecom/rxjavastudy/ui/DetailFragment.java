package com.chinatelecom.rxjavastudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/30.
 */

public class DetailFragment extends BaseFragment {
    private static String mTitle;
    private static final String TAG = "Fragmentation";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_next)
    Button btnNext;

    public static DetailFragment newInstance(String item) {
        mTitle = item;
        return new DetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_detail, null, false);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    protected void initLazy(@Nullable Bundle savedInstanceState) {
        toolbar.setTitleTextColor(ActivityCompat.getColor(_mActivity, android.R.color.white));
        toolbar.setTitle(mTitle);
    }

    @OnClick(R.id.btn_next)
    public void nextClick() {
        start(DetailNextFragment.newInstance());
    }

    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }
}

package com.chinatelecom.rxjavastudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.ui.base.BaseFragment;

/**
 * Created by Administrator on 2016/10/30.
 */

public class HotFragment extends BaseFragment {
    public static HotFragment newInstance() {
        return new HotFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_hot, container, false);
        return inflate;
    }

    @Override
    protected void initLazy(@Nullable Bundle savedInstanceState) {
        Log.i("TAG", "HotFragment");
    }
}

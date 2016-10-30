package com.chinatelecom.rxjavastudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.base.BaseFragment;

/**
 * Created by Shui on 16/10/30.
 */

public class OneFragment extends BaseFragment {
    public static OneFragment newInstance() {
        return new OneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_one, container, false);
        return inflate;
    }
}

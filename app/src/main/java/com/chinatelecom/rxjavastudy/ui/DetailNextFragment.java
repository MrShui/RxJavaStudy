package com.chinatelecom.rxjavastudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
 * Created by Shui on 16/10/31.
 */

public class DetailNextFragment extends BaseFragment {
    @BindView(R.id.btn_finish)
    Button btnFinish;

    public static DetailNextFragment newInstance() {
        return new DetailNextFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_next_detail, null);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    protected void initLazy(@Nullable Bundle savedInstanceState) {

    }

    @OnClick(R.id.btn_finish)
    public void finishClick() {
        pop();
    }

    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }
}

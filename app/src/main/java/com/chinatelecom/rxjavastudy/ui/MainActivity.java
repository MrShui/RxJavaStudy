package com.chinatelecom.rxjavastudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shui on 16/10/30.
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.tv_one)
    TextView tvOne;
    @BindView(R.id.tv_two)
    TextView tvTwo;
    @BindView(R.id.tv_three)
    TextView tvThree;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadRootFragment(R.id.fl_container, OneFragment.newInstance());
    }

    @OnClick({R.id.tv_one, R.id.tv_two, R.id.tv_three})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_one:
                break;
            case R.id.tv_two:

                break;
            case R.id.tv_three:

                break;
        }
    }
}

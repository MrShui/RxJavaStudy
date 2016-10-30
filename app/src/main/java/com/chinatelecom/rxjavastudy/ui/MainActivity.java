package com.chinatelecom.rxjavastudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.ui.base.BaseActivity;
import com.chinatelecom.rxjavastudy.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

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
    private BaseFragment[] mBaseFragments;
    private int mLastPosition = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            mBaseFragments = new BaseFragment[]{OneFragment.newInstance(), TwoFragment.newInstance(), ThreeFragment.newInstance()};
            loadMultipleRootFragment(R.id.fl_container, 0, (SupportFragment[]) mBaseFragments);
        } else {
            mBaseFragments[0] = findFragment(OneFragment.class);
            mBaseFragments[1] = findFragment(TwoFragment.class);
            mBaseFragments[2] = findFragment(ThreeFragment.class);
        }
    }

    @OnClick({R.id.tv_one, R.id.tv_two, R.id.tv_three})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_one:
                safeStartFragment(0);
                break;
            case R.id.tv_two:
                safeStartFragment(1);
                break;
            case R.id.tv_three:
                safeStartFragment(2);
                break;
        }
    }

    private void safeStartFragment(int position) {
        if (findFragment(mBaseFragments[position].getClass()) == null) {
            start(mBaseFragments[position]);
        } else {
            showHideFragment(mBaseFragments[position], mBaseFragments[mLastPosition]);
        }
        mLastPosition = position;
    }
}

package com.chinatelecom.rxjavastudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.RxTag;
import com.chinatelecom.rxjavastudy.ui.base.BaseActivity;
import com.chinatelecom.rxjavastudy.ui.base.BaseFragment;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Shui on 16/10/30.
 */

public class MainActivity extends BaseActivity {
    public final static String BACK_FIRST_FRAGMENT = "back_first_fragment";

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
        RxBus.get().register(this);
    }

    @OnClick({R.id.tv_one, R.id.tv_two, R.id.tv_three})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_one:
                showHideFragment(mBaseFragments[0], mBaseFragments[mLastPosition]);
                mLastPosition = 0;
                break;
            case R.id.tv_two:
                showHideFragment(mBaseFragments[1], mBaseFragments[mLastPosition]);
                mLastPosition = 1;
                break;
            case R.id.tv_three:
                showHideFragment(mBaseFragments[2], mBaseFragments[mLastPosition]);
                mLastPosition = 2;
                break;
        }
    }

    private void safeStartFragment(int position) {
        showHideFragment(mBaseFragments[position], mBaseFragments[mLastPosition]);
    }

    @Subscribe(tags = {@Tag(RxTag.BACK_FRAGMENT)})
    public void backFragment(String s) {
        if (TextUtils.equals(s, BACK_FIRST_FRAGMENT)) {
            safeStartFragment(0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }
}

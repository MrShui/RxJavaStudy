package com.chinatelecom.rxjavastudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.RxTag;
import com.chinatelecom.rxjavastudy.ui.base.BaseFragment;
import com.hwangjr.rxbus.RxBus;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Shui on 16/10/30.
 */

public class TwoFragment extends BaseFragment {
    public static TwoFragment newInstance() {
        return new TwoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_two, container, false);
        return inflate;
    }

    @Override
    protected void initLazy(@Nullable Bundle savedInstanceState) {
//        Log.i("TAG", "TwoFragment");
//        Observable.interval(1, TimeUnit.SECONDS)
//                .compose(this.<Long>bindToLifecycle())
//                .subscribe(new Action1<Long>() {
//                    @Override
//                    public void call(Long aLong) {
//                        Log.i("TAG", "测试RxLifecycle：" + aLong);
//                    }
//                });
    }

    @Override
    public boolean onBackPressedSupport() {
        RxBus.get().post(RxTag.BACK_FRAGMENT, MainActivity.BACK_FIRST_FRAGMENT);
        return true;
    }
}

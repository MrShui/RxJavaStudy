package com.chinatelecom.rxjavastudy.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.ui.base.BaseActivity;
import com.hwangjr.rxbus.RxBus;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Administrator on 2016/10/29.
 */

public class SecondActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        RxBus.get().post(BusAction.SHOW_TIME, aLong);
                    }
                });
    }
}

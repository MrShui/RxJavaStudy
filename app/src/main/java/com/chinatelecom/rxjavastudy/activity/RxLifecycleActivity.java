package com.chinatelecom.rxjavastudy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.api.rxhelper.RxSchedulersHelper;
import com.chinatelecom.rxjavastudy.base.BaseActivity;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * 使用RxLifecycle管理生命週期
 * Created by Administrator on 2016/10/29.
 */

public class RxLifecycleActivity extends BaseActivity {

    private TextView tvDisplay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        RxBus.get().register(this);
        tvDisplay = (TextView) findViewById(R.id.tv_display);

        LifecycleTransformer<Long> bind = RxLifecycle.bind(lifecycle());
        Observable.interval(1, TimeUnit.SECONDS)
                .compose(bind)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {

                    }
                });
        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RxLifecycleActivity.this, SecondActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }

    @Subscribe(thread = EventThread.MAIN_THREAD, tags = {@Tag(BusAction.SHOW_TIME)})
    public void showTime(Long aLong) {
        tvDisplay.setText(String.valueOf(aLong));
    }

    private void lifecycleDemo() {
        Observable.interval(1, TimeUnit.SECONDS)
                .compose(RxSchedulersHelper.<Long>io_main())
                .compose(RxLifecycle.bind(lifecycle()))
                .subscribe();

    }
}

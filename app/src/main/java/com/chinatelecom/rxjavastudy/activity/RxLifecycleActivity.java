package com.chinatelecom.rxjavastudy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chinatelecom.rxjavastudy.R;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * 使用RxLifecycle管理生命週期
 * Created by Administrator on 2016/10/29.
 */

public class RxLifecycleActivity extends RxAppCompatActivity {

    private TextView tvDisplay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        RxBus.get().register(this);
        tvDisplay = (TextView) findViewById(R.id.tv_display);
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
}

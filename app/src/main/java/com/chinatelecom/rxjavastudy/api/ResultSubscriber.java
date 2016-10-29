package com.chinatelecom.rxjavastudy.api;

import android.util.Log;

import rx.Subscriber;

/**
 * Created by Shui on 16/10/28.
 */

public abstract class ResultSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        Log.i("TAG", "onCompleted()");
    }

    @Override
    public void onError(Throwable e) {
        Log.i("TAG", "e:" + e.getMessage());
    }

    @Override
    public abstract void onNext(T t);
}

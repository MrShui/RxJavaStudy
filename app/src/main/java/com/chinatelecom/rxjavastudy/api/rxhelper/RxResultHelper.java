package com.chinatelecom.rxjavastudy.api.rxhelper;

import com.chinatelecom.rxjavastudy.ResultModel;
import com.chinatelecom.rxjavastudy.api.exception.ServerException;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Shui on 16/10/28.
 */

public class RxResultHelper {
    public static <T> Observable.Transformer<ResultModel<T>, T> handleResult() {
        return new Observable.Transformer<ResultModel<T>, T>() {
            @Override
            public Observable<T> call(Observable<ResultModel<T>> resultModelObservable) {
                return resultModelObservable.flatMap(new Func1<ResultModel<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(ResultModel<T> tResultModel) {
                        if (tResultModel == null) {
                            return Observable.empty();
                        }

                        if (tResultModel.isSuccess()) {
                            return createData(tResultModel.getData());
                        } else {
                            return Observable.error(new ServerException(tResultModel.getErrorMsg()));
                        }
                    }
                });
            }
        };
    }

    private static <T> Observable<T> createData(final T data) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                subscriber.onNext(data);
                subscriber.onCompleted();
            }
        });
    }
}

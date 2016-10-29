package com.chinatelecom.rxjavastudy.api;

import com.chinatelecom.rxjavastudy.util.L;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shui on 16/10/28.
 */

public class ApiHelper {
    private final static String BASE_URL = "http://101.95.153.34:4011/";
    private static Api mApi;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);
        if (L.isDebug) {
            builder.addInterceptor(new HttpLoggingInterceptor());
        }
    }

    public static Api getApi() {
        if (mApi == null) {
            HttpUrl url = HttpUrl.parse(BASE_URL);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(60, TimeUnit.SECONDS);
            builder.readTimeout(60, TimeUnit.SECONDS);
            if (L.isDebug) {
                builder.addInterceptor(new HttpLoggingInterceptor());
            }
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                    .client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            mApi = retrofit.create(Api.class);

        }
        return mApi;
    }
}

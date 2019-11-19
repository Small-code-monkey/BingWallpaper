package com.example.bingwallpaper.impl;

import android.content.Context;

import com.example.bingwallpaper.baen.WallPaperBean;
import com.example.bingwallpaper.base.App;
import com.example.bingwallpaper.cache.CacheInterceptor;
import com.example.bingwallpaper.cache.NovateCookieManger;
import com.example.bingwallpaper.model.WallPaperModel;
import com.example.bingwallpaper.presenter.WallPaperPresenter;
import com.example.bingwallpaper.protocol.WallPaperProtocol;
import com.example.bingwallpaper.util.AppUtil;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * M层->P层交互
 * 获取数据功能
 * 2019-11-14
 *
 * @author
 */
public class WallpaperModelImpl implements WallPaperModel {

    private WallPaperPresenter wallPaperPresenter;

    public WallpaperModelImpl(WallPaperPresenter wallPaperPresenter) {
        this.wallPaperPresenter = wallPaperPresenter;
    }

    /**
     * 设置参数监听数据状态
     *
     * @param context
     * @param pageSize
     * @param pageNum
     * @param onRetrofit
     */
    @Override
    public void getWallPaper(Context context, int pageSize, int pageNum, onRetrofit onRetrofit) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(App.dataUrl)
                .client(new OkHttpClient.Builder()
                        .cookieJar(new NovateCookieManger(context))
                        .cache(new Cache(new File(context.getExternalCacheDir(),
                                "wallpaper_cache"), 10 * 1024 * 1024))
                        .addInterceptor(new CacheInterceptor(context))
                        .addNetworkInterceptor(new CacheInterceptor(context))
                        .connectTimeout(5, TimeUnit.SECONDS)
                        .build())
                .build();
        WallPaperProtocol wallPaperProtocol = retrofit.create(WallPaperProtocol.class);
        Call<WallPaperBean> wallPaperBeanCall = wallPaperProtocol.getWallPaperData(pageSize, pageNum);
        wallPaperBeanCall.enqueue(new Callback<WallPaperBean>() {
            @Override
            public void onResponse(Call<WallPaperBean> call, Response<WallPaperBean> response) {
                if (AppUtil.isObject(response.body())) {
                    wallPaperPresenter.getData(response.body().getData().getItem());
                    onRetrofit.onSuccess();
                } else {
                    onRetrofit.onFailure();
                }
            }

            @Override
            public void onFailure(Call<WallPaperBean> call, Throwable t) {
                t.printStackTrace();
                onRetrofit.onFailure();
            }
        });
    }
}

package com.example.bingwallpaper.impl;

import com.example.bingwallpaper.baen.WallPaperBean;
import com.example.bingwallpaper.base.App;
import com.example.bingwallpaper.model.WallPaperModel;
import com.example.bingwallpaper.presenter.WallPaperPresenter;
import com.example.bingwallpaper.protocol.WallPaperProtocol;
import com.example.bingwallpaper.util.AppUtil;

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

    @Override
    public void getWallPaper(onRetrofit onRetrofit) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(App.dataUrl)
                .build();
        WallPaperProtocol wallPaperProtocol = retrofit.create(WallPaperProtocol.class);
        Call<WallPaperBean> wallPaperBeanCall = wallPaperProtocol.getWallPaperData(10, 1);
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

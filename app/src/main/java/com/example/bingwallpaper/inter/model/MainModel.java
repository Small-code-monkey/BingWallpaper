package com.example.bingwallpaper.inter.model;

import android.util.Log;

import com.example.bingwallpaper.WallPaperBean;
import com.example.bingwallpaper.inter.OnRetrofits;
import com.example.bingwallpaper.inter.contract.MainContract;
import com.example.bingwallpaper.util.AppUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * MainActivity M层
 * 2020-02-10
 *
 * @author
 */
public class MainModel implements MainContract.Model {

    private MainContract.Presenter presenter;

    public MainModel(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * 设置参数监听数据状态
     *
     * @param pageSize
     * @param pageNum
     * @param onRetrofit
     */
    @Override
    public void getWallPaper(int pageSize, int pageNum, OnRetrofits onRetrofit) {
        AppUtil.getBasisProtocol().getWallPaperData(pageSize, pageNum).enqueue(new Callback<WallPaperBean>() {
            @Override
            public void onResponse(Call<WallPaperBean> call, Response<WallPaperBean> response) {
                Log.d("TAG", "----->" + response.raw());
                if (AppUtil.isObject(response.body())) {
                    Log.d("TAG", "----->" + "返回数据：" + response.body());
                    presenter.getData(response.body().getData().getItem());
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

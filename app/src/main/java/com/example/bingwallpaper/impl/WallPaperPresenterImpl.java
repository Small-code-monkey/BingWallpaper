package com.example.bingwallpaper.impl;

import com.example.bingwallpaper.baen.WallPaperBean;
import com.example.bingwallpaper.contracts.WallPaperView;
import com.example.bingwallpaper.model.WallPaperModel;
import com.example.bingwallpaper.presenter.WallPaperPresenter;

import java.util.List;

/**
 * V层->(P层)<->M层
 * 2019-11-14
 *
 * @author
 */
public class WallPaperPresenterImpl implements WallPaperPresenter, WallPaperModel.onRetrofit {

    private WallPaperView wallPaperView;
    private WallPaperModel wallPaperModel;

    public WallPaperPresenterImpl(WallPaperView wallPaperView) {
        this.wallPaperView = wallPaperView;
        wallPaperModel = new WallpaperModelImpl(this);
    }

    @Override
    public void onSuccess() {
        wallPaperView.endLoading();
        wallPaperView.getSuccess();
    }

    @Override
    public void onFailure() {
        wallPaperView.endLoading();
        wallPaperView.getFailure();
    }

    @Override
    public void methodData() {
        wallPaperView.startLoading();
        wallPaperModel.getWallPaper(this);
    }

    @Override
    public void getData(List<WallPaperBean.DataBean.ItemBean> dataBeans) {
        wallPaperView.getWallPaper(dataBeans);
    }
}

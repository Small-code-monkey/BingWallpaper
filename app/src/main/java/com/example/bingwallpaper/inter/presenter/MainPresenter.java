package com.example.bingwallpaper.inter.presenter;

import com.example.bingwallpaper.WallPaperBean;
import com.example.bingwallpaper.inter.OnRetrofits;
import com.example.bingwallpaper.inter.contract.MainContract;
import com.example.bingwallpaper.inter.model.MainModel;

import java.util.List;

/**
 * MainActivity P层
 * 2020-02-10
 *
 * @author
 */
public class MainPresenter implements MainContract.Presenter, OnRetrofits {

    private MainContract.View view;
    private MainContract.Model model;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        model = new MainModel(this);
    }

    /**
     * 方法获取数据
     */
    @Override
    public void methodData() {
        view.startLoading();
        model.getWallPaper(view.setPageSize(), view.setPageNum(), this);
    }

    /**
     * 传递返回数据
     *
     * @param dataBeans
     */
    @Override
    public void getData(List<WallPaperBean.DataBean.ItemBean> dataBeans) {
        view.getWallPaper(dataBeans);
    }

    /**
     * 成功
     */
    @Override
    public void onSuccess() {
        view.endLoading();
    }

    /**
     * 失败
     */
    @Override
    public void onFailure() {
        view.endLoading();
    }
}

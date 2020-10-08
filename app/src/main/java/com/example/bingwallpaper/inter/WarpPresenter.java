package com.example.bingwallpaper.inter;

import com.example.bingwallpaper.WallPaperBean;
import com.example.bingwallpaper.inter.contract.WarpContract;

import java.util.List;

/**
 * MainActivity P层
 * 2020-02-10
 *
 * @author
 */
public class WarpPresenter implements WarpContract.Presenter, OnRetrofits {

    private WarpContract.View view;
    private WarpContract.Model model;

    public WarpPresenter(WarpContract.View view) {
        this.view = view;
        model = new WarpModel(this);
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

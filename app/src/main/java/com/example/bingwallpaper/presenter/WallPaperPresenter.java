package com.example.bingwallpaper.presenter;

import com.example.bingwallpaper.baen.WallPaperBean;

import java.util.List;

/**
 * P层
 * 2019-11-14
 *
 * @author
 */
public interface WallPaperPresenter {

    /**
     * 方法获取数据
     */
    void methodData();

    /**
     * 得到返回数据
     *
     * @param dataBeans
     */
    void getData(List<WallPaperBean.DataBean.ItemBean> dataBeans);
}

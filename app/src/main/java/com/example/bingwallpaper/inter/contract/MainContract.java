package com.example.bingwallpaper.inter.contract;

import com.example.bingwallpaper.WallPaperBean;
import com.example.bingwallpaper.inter.OnRetrofits;

import java.util.List;

/**
 * Mvp
 * 2020-02-10
 *
 * @author
 */
public interface MainContract {
    interface Model {
        /**
         * 实体请求数据
         *
         * @param pageSize
         * @param pageNum
         * @param onRetrofits
         */
        void getWallPaper(int pageSize, int pageNum, OnRetrofits onRetrofits);
    }

    interface View {
        /**
         * 设置页面壁纸数量
         *
         * @return
         */
        int setPageSize();

        /**
         * 设置页面页数
         *
         * @return
         */
        int setPageNum();

        /**
         * 获取结果数据
         *
         * @param dataBeans
         */
        void getWallPaper(List<WallPaperBean.DataBean.ItemBean> dataBeans);

        /**
         * 运行加载ing...
         */
        void startLoading();

        /**
         * 结束加载ing...
         */
        void endLoading();
    }

    interface Presenter {
        /**
         * 方法获取数据
         */
        void methodData();

        /**
         * 传递返回数据
         *
         * @param dataBeans
         */
        void getData(List<WallPaperBean.DataBean.ItemBean> dataBeans);
    }
}
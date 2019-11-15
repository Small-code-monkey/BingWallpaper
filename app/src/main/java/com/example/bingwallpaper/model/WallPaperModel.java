package com.example.bingwallpaper.model;

/**
 * M层
 * 2019-11-14
 *
 * @author
 */
public interface WallPaperModel {

    /**
     * 监听数据状态
     *
     * @param onRetrofit
     */
    void getWallPaper(onRetrofit onRetrofit);

    /**
     * 获取数据返回状态
     */
    interface onRetrofit {

        /**
         * 成功
         */
        void onSuccess();

        /**
         * 失败
         */
        void onFailure();

    }
}

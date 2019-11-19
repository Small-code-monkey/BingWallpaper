package com.example.bingwallpaper.model;

import android.content.Context;

/**
 * M层
 * 2019-11-14
 *
 * @author
 */
public interface WallPaperModel {

    /**
     * 设置参数监听数据状态
     *
     * @param context
     * @param pageSize
     * @param pageNum
     * @param onRetrofit
     */
    void getWallPaper(Context context, int pageSize, int pageNum, onRetrofit onRetrofit);

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

package com.example.bingwallpaper.base;

import android.app.Application;

import com.hjq.toast.ToastUtils;

/**
 * Application
 * 2019-11-14
 *
 * @author
 */
public class BaseApplication extends Application {
    public static String dataUrl = "https://bing.open.apith.cn/";
    public static String httpUrl = "http:";

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化ToastUtils
        ToastUtils.init(this);
    }
}

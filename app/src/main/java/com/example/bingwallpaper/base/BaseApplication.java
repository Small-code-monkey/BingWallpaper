package com.example.bingwallpaper.base;

import android.app.Application;

import com.hjq.toast.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * Application
 * 2019-11-14
 *
 * @author
 */
public class BaseApplication extends Application {
    public static String dataUrl = "https://bing.open.apith.cn/";

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化ToastUtils
        ToastUtils.init(this);
        //初始化刷新
        // 设置全局的 Header 构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> new ClassicsHeader(context).setEnableLastTime(false));
        // 设置全局的 Footer 构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> new ClassicsFooter(context).setDrawableSize(20));
    }
}

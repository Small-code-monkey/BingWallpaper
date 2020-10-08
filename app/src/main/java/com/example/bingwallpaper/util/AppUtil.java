package com.example.bingwallpaper.util;

import com.example.bingwallpaper.base.BaseApplication;
import com.example.bingwallpaper.protocol.BaseProtocol;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 工具类
 * 2019-10-16
 *
 * @author
 */
public class AppUtil {

    /**
     * 获取Protocol
     *
     * @return
     */
    public static BaseProtocol getBasisProtocol() {
        return new Retrofit.Builder()
                .baseUrl(BaseApplication.dataUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(BaseProtocol.class);
    }

    /**
     * 判断对象是否为空
     *
     * @param object
     * @return
     */
    public static boolean isObject(Object object) {
        return null != object;
    }

}

package com.example.bingwallpaper.cache;

import android.content.Context;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * 2019-11-19
 *
 * @author
 */
public class NovateCookieManger implements CookieJar {

    private static PersistentCookieStore cookieStore;

    /**
     * Mandatory constructor for the NovateCookieManger
     */
    public NovateCookieManger(Context context) {
        if (cookieStore == null) {
            cookieStore = new PersistentCookieStore(context);
        }
    }

    /**
     * 方法会在服务端给客户端发送Cookie时调用。此时需要我们自己实现保存Cookie的方式。
     * 这里使用了最简单的Map来保存域名与Cookie的关系
     *
     * @param url
     * @param cookies
     */
    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (cookies.size() > 0) {
            for (Cookie item : cookies) {
                cookieStore.add(url, item);
            }
        }
    }

    /**
     * 每当这个client访问到某一个域名时，就会通过此方法获取保存的Cookie，并且发送给服务器
     *
     * @param url
     * @return
     */
    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return cookieStore.get(url);
    }
}
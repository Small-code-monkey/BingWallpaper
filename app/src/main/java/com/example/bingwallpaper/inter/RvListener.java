package com.example.bingwallpaper.inter;

import android.view.View;

/**
 * 监听RecyclerView事件
 * 2019-09-16
 *
 * @author
 */
public interface RvListener {

    /**
     * 点击事件
     *
     * @param view
     * @param position
     */
    void reViewOnClickListener(View view, int position);

    /**
     * 长按事件
     *
     * @param view
     * @param position
     */
    void reViewOnLongListener(View view, int position);
}

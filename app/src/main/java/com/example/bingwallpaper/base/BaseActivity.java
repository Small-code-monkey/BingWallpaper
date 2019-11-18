package com.example.bingwallpaper.base;

import android.content.Context;
import android.os.Bundle;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * 基类Activity
 * 2019-11-14
 *
 * @author
 */
public class BaseActivity extends SwipeBackActivity {
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }
}

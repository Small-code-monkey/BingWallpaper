package com.example.bingwallpaper.base;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 基类Activity
 * 2019-11-14
 *
 * @author
 */
public abstract class BaseActivity extends AppCompatActivity {
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        ButterKnife.bind(this);
        initActivity();
    }

    protected void initActivity() {
        setContentView(getLayout());
        initData();
    }

    /**
     * 初始化布局
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 初始化数据
     */
    protected abstract void initData();
}

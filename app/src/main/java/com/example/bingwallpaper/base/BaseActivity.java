package com.example.bingwallpaper.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bingwallpaper.R;
import com.example.bingwallpaper.dialog.WaitDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基类Activity
 * 2019-11-14
 *
 * @author
 */
public abstract class BaseActivity extends AppCompatActivity {
    public Context context;
    private Unbinder unbinder;
    private WaitDialog waitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        initActivity();
    }

    protected void initActivity() {
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
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

    /**
     * 显示加载中(默认)
     */
    public void showLoading() {
        showLoading(R.string.loading);
    }

    /**
     * 显示加载中
     *
     * @param id id资源
     */
    public void showLoading(@StringRes int id) {
        showLoading(getString(id));
    }

    /**
     * 显示加载中
     *
     * @param text 填写
     */
    public void showLoading(String text) {
        if (waitDialog == null) {
            waitDialog = new WaitDialog.Builder(context)
                    .setMessage(text).create();
        }
        if (!waitDialog.isShowing()) {
            waitDialog.show();
        }
    }

    /**
     * 显示加载完成
     */
    public void showComplete() {
        if (waitDialog != null && waitDialog.isShowing()) {
            waitDialog.dismiss();
        }
    }
}

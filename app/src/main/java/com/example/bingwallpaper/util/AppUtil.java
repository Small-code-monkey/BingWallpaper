package com.example.bingwallpaper.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.bingwallpaper.R;


/**
 * 工具类
 * 2019-10-16
 *
 * @author
 */
public class AppUtil {

    private static Toast toast;

    /**
     * Toast工具
     *
     * @param context
     * @param text
     */
    @SuppressLint("ShowToast")
    public static void showToast(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    /**
     * 判断是否有网络连接
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        showToast(context, context.getString(R.string.null_intent));
        return false;
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

    /**
     * 提示弹框
     *
     * @param context
     * @param strings
     */
    public static void showDialog(Context context, String[] strings, DialogInterface anInterface) {
        new AlertDialog.Builder(context)
                .setItems(strings, (dialogInterface, i) -> {
                    anInterface.dialogInter();
                    dialogInterface.dismiss();
                })
                .show();
    }

    public interface DialogInterface {
        /**
         * 响应dialog
         */
        void dialogInter();
    }

}

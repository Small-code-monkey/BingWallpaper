package com.example.bingwallpaper.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.bingwallpaper.R;

/**
 * 加载对话框
 * 2020-01-07
 *
 * @author
 */
public class WaitDialog extends Dialog {

    private WaitDialog(Context context) {
        super(context);
    }

    public static class Builder {
        private Context context;
        private String text;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setMessage(String text) {
            this.text = text;
            return this;
        }

        public WaitDialog create() {
            WaitDialog waitDialog = new WaitDialog(context);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_wait, null);
            AppCompatTextView textView = view.findViewById(R.id.tv_wait_message);
            textView.setText(text);
            textView.setVisibility(text == null ? View.GONE : View.VISIBLE);
            waitDialog.setContentView(view);
            return waitDialog;
        }
    }

}
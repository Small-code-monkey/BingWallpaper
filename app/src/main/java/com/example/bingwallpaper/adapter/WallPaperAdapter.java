package com.example.bingwallpaper.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.bingwallpaper.R;
import com.example.bingwallpaper.baen.WallPaperBean;

import java.util.List;

/**
 * 首页壁纸适配器
 * 2019-11-14
 *
 * @author
 */
public class WallPaperAdapter extends BaseQuickAdapter<WallPaperBean.DataBean.ItemBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public WallPaperAdapter(int layoutResId, @Nullable List<WallPaperBean.DataBean.ItemBean> data) {
        super(layoutResId, data);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, WallPaperBean.DataBean.ItemBean item) {
        Glide.with(mContext).load("http:" + item.getUrl())
                .placeholder(R.mipmap.timg)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.timg)
                .into((ImageView) helper.getView(R.id.imageView));
        helper.setText(R.id.textView, item.getCopyright());
    }
}

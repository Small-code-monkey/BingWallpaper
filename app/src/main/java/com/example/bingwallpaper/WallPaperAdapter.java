package com.example.bingwallpaper;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 首页壁纸适配器
 * 2019-11-14
 *
 * @author
 */
public class WallPaperAdapter extends BaseQuickAdapter<WallPaperBean.DataBean.ItemBean, BaseViewHolder> {

    public WallPaperAdapter(int layoutResId, @Nullable List<WallPaperBean.DataBean.ItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WallPaperBean.DataBean.ItemBean item) {
        Glide.with(mContext).load("http:" + item.getUrl())
                .placeholder(R.mipmap.timg)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .error(R.mipmap.timg)
                .dontAnimate()
                .into((ImageView) helper.getView(R.id.imageView));
        helper.setText(R.id.textView, item.getCopyright());
    }
}

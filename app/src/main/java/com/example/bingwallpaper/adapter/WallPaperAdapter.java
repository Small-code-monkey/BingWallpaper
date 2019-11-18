package com.example.bingwallpaper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.bingwallpaper.R;
import com.example.bingwallpaper.baen.WallPaperBean;
import com.example.bingwallpaper.base.App;
import com.example.bingwallpaper.inter.RvListener;

import java.util.List;

/**
 * 首页壁纸适配器
 * 2019-11-14
 *
 * @author
 */
public class WallPaperAdapter extends RecyclerView.Adapter<WallPaperAdapter.ViewHolder>
        implements View.OnClickListener, View.OnLongClickListener {
    private Context context;
    private List<WallPaperBean.DataBean.ItemBean> wallPaperBeans;
    private RvListener rvListener;

    public WallPaperAdapter(Context context, List<WallPaperBean.DataBean.ItemBean> wallPaperBeans) {
        this.context = context;
        this.wallPaperBeans = wallPaperBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_wallpaper, null);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(App.httpUrl + wallPaperBeans.get(position).getUrl())
                .placeholder(R.mipmap.timg)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.timg)
                .into(holder.imageView);
        holder.textView.setText(wallPaperBeans.get(position).getCopyright());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return wallPaperBeans.size();
    }

    @Override
    public boolean onLongClick(View view) {
        if (rvListener != null) {
            rvListener.reViewOnLongListener(view, (Integer) view.getTag());
        }
        return false;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    @Override
    public void onClick(View view) {
        if (rvListener != null) {
            rvListener.reViewOnClickListener(view, (Integer) view.getTag());
        }
    }

    /**
     * 暴露给调用者，设置一个Listener的方法
     *
     * @param viewListener
     */
    public void setOnclick(RvListener viewListener) {
        this.rvListener = viewListener;
    }

}

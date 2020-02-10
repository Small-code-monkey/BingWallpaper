package com.example.bingwallpaper;

import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.bingwallpaper.adapter.WallPaperAdapter;
import com.example.bingwallpaper.baen.WallPaperBean;
import com.example.bingwallpaper.base.BaseActivity;
import com.example.bingwallpaper.inter.contract.MainContract;
import com.example.bingwallpaper.inter.presenter.MainPresenter;
import com.example.bingwallpaper.util.AppUtil;
import com.hjq.toast.ToastUtils;

import java.util.List;

/**
 * 首页
 * 2019-11-14
 *
 * @author
 */
public class MainActivity extends BaseActivity implements
        SwipeRefreshLayout.OnRefreshListener, MainContract.View {

    private int pageNum = 1;
    private SwipeRefreshLayout swLayout;
    private RecyclerView srView;

    /**
     * 初始化布局
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        swLayout = findViewById(R.id.sw_layout);
        swLayout.setOnRefreshListener(this);
        srView = findViewById(R.id.re_view);

        //默认刷新获取数据
        onRefresh();
    }

    @Override
    public void onRefresh() {
        if (AppUtil.isNetworkConnected(context)) {
            MainContract.Presenter presenter = new MainPresenter(this);
            presenter.methodData();
        } else {
            endLoading();
            ToastUtils.show("检查网络连接");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                if (1 != pageNum) {
                    pageNum--;
                    onRefresh();
                } else {
                    ToastUtils.show("☞当前第一页");
                }
                break;
            case R.id.menu2:
                pageNum++;
                onRefresh();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 设置页面壁纸数量
     *
     * @return
     */
    @Override
    public int setPageSize() {
        return 10;
    }

    /**
     * 设置页面页数
     *
     * @return
     */
    @Override
    public int setPageNum() {
        return pageNum;
    }

    /**
     * 获取结果数据
     *
     * @param dataBeans
     */
    @Override
    public void getWallPaper(List<WallPaperBean.DataBean.ItemBean> dataBeans) {
        srView.setAdapter(new WallPaperAdapter(R.layout.item_wallpaper, dataBeans));
    }

    /**
     * 运行加载ing...
     */
    @Override
    public void startLoading() {
        swLayout.setRefreshing(true);
    }

    /**
     * 结束加载ing...
     */
    @Override
    public void endLoading() {
        swLayout.setRefreshing(false);
    }
}

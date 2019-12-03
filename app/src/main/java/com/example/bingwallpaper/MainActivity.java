package com.example.bingwallpaper;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.bingwallpaper.adapter.WallPaperAdapter;
import com.example.bingwallpaper.baen.WallPaperBean;
import com.example.bingwallpaper.base.BaseActivity;
import com.example.bingwallpaper.view.WallPaperView;
import com.example.bingwallpaper.impl.WallPaperPresenterImpl;
import com.example.bingwallpaper.inter.RvListener;
import com.example.bingwallpaper.presenter.WallPaperPresenter;
import com.example.bingwallpaper.util.AppUtil;

import java.util.List;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

/**
 * 首页
 * 2019-11-14
 *
 * @author
 */
public class MainActivity extends BaseActivity implements
        SwipeRefreshLayout.OnRefreshListener, WallPaperView {

    private ShimmerRecyclerView recyclerViewMain;
    private SwipeRefreshLayout refreshMain;

    private WallPaperPresenter wallPaperPresenter;
    private int pageNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //侧滑返回
        SwipeBackLayout backLayout = getSwipeBackLayout();
        backLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        initView();
        //获取数据
        onRefresh();
    }

    private void initView() {
        recyclerViewMain = (ShimmerRecyclerView) findViewById(R.id.recyclerView_main);
        refreshMain = (SwipeRefreshLayout) findViewById(R.id.refresh_main);
        refreshMain.setOnRefreshListener(this);
        recyclerViewMain.setLayoutManager(new LinearLayoutManager(this));
        wallPaperPresenter = new WallPaperPresenterImpl(this);
    }

    @Override
    public void onRefresh() {
        if (AppUtil.isNetworkConnected(context)) {
            wallPaperPresenter.methodData();
        } else {
            endLoading();
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        onRefresh();
    }

    /**
     * 获取当前Activity
     *
     * @return
     */
    @Override
    public Context setContext() {
        return context;
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

    @Override
    public void getWallPaper(List<WallPaperBean.DataBean.ItemBean> dataBeans) {
        WallPaperAdapter wallPaperAdapter = new WallPaperAdapter(context, dataBeans);
        recyclerViewMain.setAdapter(wallPaperAdapter);
        wallPaperAdapter.setOnclick(new RvListener() {
            @Override
            public void reViewOnClickListener(View view, int position) {

            }

            @Override
            public void reViewOnLongListener(View view, int position) {

            }
        });
    }

    @Override
    public void startLoading() {
        refreshMain.setRefreshing(true);
    }

    @Override
    public void endLoading() {
        refreshMain.setRefreshing(false);
    }

    @Override
    public void getSuccess() {

    }

    @Override
    public void getFailure() {
        AppUtil.showToast(context, context.getString(R.string.null_data));
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
                    AppUtil.showToast(context, "☞当前第一页");
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
}

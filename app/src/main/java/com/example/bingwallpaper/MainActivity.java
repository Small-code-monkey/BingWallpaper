package com.example.bingwallpaper;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.bingwallpaper.adapter.WallPaperAdapter;
import com.example.bingwallpaper.baen.WallPaperBean;
import com.example.bingwallpaper.base.BaseActivity;
import com.example.bingwallpaper.contracts.WallPaperView;
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

    private RecyclerView recyclerViewMain;
    private SwipeRefreshLayout refreshMain;

    private WallPaperAdapter wallPaperAdapter;
    private WallPaperPresenter wallPaperPresenter;
    private DialogInterface dialogInterface;

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
        recyclerViewMain = (RecyclerView) findViewById(R.id.recyclerView_main);
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
    public void getWallPaper(List<WallPaperBean.DataBean.ItemBean> dataBeans) {
        wallPaperAdapter = new WallPaperAdapter(context, dataBeans);
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
}

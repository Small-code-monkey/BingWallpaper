package com.example.bingwallpaper;

import androidx.annotation.NonNull;

import com.example.bingwallpaper.base.BaseActivity;
import com.example.bingwallpaper.inter.contract.WarpContract;
import com.example.bingwallpaper.inter.WarpPresenter;
import com.example.bingwallpaper.view.WrapRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 首页
 * 2019-11-14
 *
 * @author
 */
public class MainActivity extends BaseActivity implements WarpContract.View {

    @BindView(R.id.wr_wrap)
    WrapRecyclerView wrWrap;
    @BindView(R.id.sm_wrap)
    SmartRefreshLayout smWrap;

    private int pageNum = 1;
    private List<WallPaperBean.DataBean.ItemBean> itemBeans;
    private WallPaperAdapter wallPaperAdapter;

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
        itemBeans = new ArrayList<>();
        wallPaperAdapter = new WallPaperAdapter(R.layout.item_wallpaper, itemBeans);
        wrWrap.setAdapter(wallPaperAdapter);

        //获取数据
        WarpContract.Presenter presenter = new WarpPresenter(this);
        presenter.methodData();

        smWrap.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                pageNum++;
                presenter.methodData();
                smWrap.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageNum = 1;
                itemBeans.clear();
                presenter.methodData();
                smWrap.finishRefresh();
            }
        });
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
        itemBeans.addAll(dataBeans);
        wallPaperAdapter.notifyDataSetChanged();
    }

    /**
     * 运行加载ing...
     */
    @Override
    public void startLoading() {
    }

    /**
     * 结束加载ing...
     */
    @Override
    public void endLoading() {
    }
}

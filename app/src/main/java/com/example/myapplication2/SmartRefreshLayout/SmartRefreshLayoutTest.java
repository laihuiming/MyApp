package com.example.myapplication2.SmartRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.myapplication2.Bean.SmartRefreshBean;
import com.example.myapplication2.Data.MainDatas;
import com.example.myapplication2.Data.SmartRefreshDatas;
import com.example.myapplication2.R;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/app/SmartRefreshLayoutTest")
public class SmartRefreshLayoutTest extends AppCompatActivity {

    int curpage=1;
    int total;
    int code;
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private LinearLayout linearLayout;
    private SmartRefreshAadapter adapter;
    private List<SmartRefreshBean> stdList = new ArrayList<SmartRefreshBean>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_refresh);
        initView();
        initData();
        refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setRefreshHeader(new ClassicsHeader(this));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
//                curpage = 0;
                stdList.clear();
                initData();
                refreshlayout.finishRefresh(200/*,false*/);//传入false表示刷新失败

            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                getData();
                refreshlayout.finishLoadMore(200/*,false*/);//传入false表示加载失败

            }
        });

    }

    private void initView() {
        linearLayout = findViewById(R.id.ll_smart_refresh_nodata);
        recyclerView = (RecyclerView) findViewById(R.id.smart_refresh_recyclerView);//查找recyclerview控件
        LinearLayoutManager manager = new LinearLayoutManager(this);//创建线性布局管理器
        manager.setOrientation(LinearLayoutManager.VERTICAL);//添加垂直布局
        recyclerView.setLayoutManager(manager);//将线性布局管理器添加到recyclerview中
        adapter = new SmartRefreshAadapter(getApplicationContext(), stdList);//实例化适配器
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);//添加适配器
    }

    //获取数据
    private void getData() {
        if (stdList == null || stdList.size() == 0) {//列表为空时
            Toast.makeText(this, "数据列表为空，请检查", Toast.LENGTH_SHORT).show();
//            view.findViewById(R.id.ll_smart_refresh_nodata).setVisibility(View.VISIBLE);
//            linearLayout.setVisibility(View.VISIBLE);
//            refreshLayout.setVisibility(View.GONE);

        }
//        if (curpage > 0) {//加载更多
            getMoreData();
//        }
//        if (curpage == 0) {//初始化,刷新
//            initData();
//        }
    }

    //初始化数据,刷新数据
    private void initData() {//目标实现结果：展示1-8
        for (int i = 0; i < 6; i++) {
            SmartRefreshBean data = new SmartRefreshBean();
            data.id = SmartRefreshDatas.id[i]+"";
            data.name = SmartRefreshDatas.name[i];
            data.age = SmartRefreshDatas.age[i]+"";
            stdList.add(data);
        }
        curpage++;
        adapter.notifyDataSetChanged();
    }

    //加载更多数据
    private void getMoreData() {//目标实现结果：每次加载更多时，在原有基础上加8个数据
        total = SmartRefreshDatas.name.length;
        for (int j=stdList.size(); j < total; j++) {
            if (j == total) {//大于数组长度
                Toast.makeText(this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                refreshLayout.finishLoadMoreWithNoMoreData();
                break;
            }
            SmartRefreshBean data = new SmartRefreshBean();
            data.id = SmartRefreshDatas.id[j]+"";
            data.name = SmartRefreshDatas.name[j];
            data.age = SmartRefreshDatas.age[j]+"";
            stdList.add(data);
        }
        adapter.notifyDataSetChanged();
    }
}

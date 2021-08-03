package com.example.myapplication2.SmartRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.myapplication2.Bean.SmartRefreshBean;
import com.example.myapplication2.Data.SmartRefreshDatas;
import com.example.myapplication2.R;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/app/SmartRefreshLayoutTest")
public class SmartRefreshLayoutTest extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SmartRefreshAadapter adapter;
    private List<SmartRefreshBean> pageList = new ArrayList<SmartRefreshBean>();
    int code;
    int datanumb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_refresh);
        initView();
        initData();
        getData();
        RefreshLayout refreshLayout = (RefreshLayout)findViewById(R.id.refreshLayout);
        refreshLayout.setRefreshHeader(new ClassicsHeader(this));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                code = 0;
                getData();
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                code++;
                getData();
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });

    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.smart_refresh_recyclerView);//查找recyclerview控件
        LinearLayoutManager manager = new LinearLayoutManager(this);//创建线性布局管理器
        manager.setOrientation(LinearLayoutManager.VERTICAL);//添加垂直布局
        recyclerView.setLayoutManager(manager);//将线性布局管理器添加到recyclerview中
        adapter = new SmartRefreshAadapter(getApplicationContext(),pageList);//实例化适配器
        recyclerView.setAdapter(adapter);//添加适配器
    }


    //获取数据
    private int getData() {
        if (pageList == null || pageList.size()==0){//列表为空时
            Toast.makeText(this, "数据列表为空，请检查", Toast.LENGTH_SHORT).show();
        }
        if (code == 0){//初始化,刷新
            pageList.clear();
            initData();
            adapter.notifyDataSetChanged();
        }
        if (code > 0){//加载更多
            getMoreData();
            adapter.notifyDataSetChanged();
        }
        return datanumb;
    }

    //初始化数据
    private int initData() {//目标实现结果：展示1-8

        for (datanumb = 0; datanumb < 8; datanumb++) {
            SmartRefreshBean data = new SmartRefreshBean();
            data.title = SmartRefreshDatas.title[datanumb];
            data.page = "这是第"+ datanumb +"页标题";
            pageList.add(data);
        }
        return datanumb;
    }
    //加载更多数据
    private int getMoreData() {//目标实现结果：每次加载更多时，再原有基础上加8个数据
        code = datanumb+8;

        for (datanumb=datanumb; datanumb<code;datanumb++){
            if (datanumb>39){
                Toast.makeText(this, "没有数据了", Toast.LENGTH_SHORT).show();
                return datanumb;
            }
            SmartRefreshBean data = new SmartRefreshBean();
            data.title = SmartRefreshDatas.title[datanumb];
            data.page = "这是第"+ data +"页标题";
            pageList.add(data);
        }
        return datanumb;
    }
}

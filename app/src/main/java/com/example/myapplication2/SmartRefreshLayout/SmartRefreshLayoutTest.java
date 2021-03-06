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
                refreshlayout.finishRefresh(200/*,false*/);//??????false??????????????????

            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                getData();
                refreshlayout.finishLoadMore(200/*,false*/);//??????false??????????????????

            }
        });

    }

    private void initView() {
        linearLayout = findViewById(R.id.ll_smart_refresh_nodata);
        recyclerView = (RecyclerView) findViewById(R.id.smart_refresh_recyclerView);//??????recyclerview??????
        LinearLayoutManager manager = new LinearLayoutManager(this);//???????????????????????????
        manager.setOrientation(LinearLayoutManager.VERTICAL);//??????????????????
        recyclerView.setLayoutManager(manager);//?????????????????????????????????recyclerview???
        adapter = new SmartRefreshAadapter(getApplicationContext(), stdList);//??????????????????
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);//???????????????
    }

    //????????????
    private void getData() {
        if (stdList == null || stdList.size() == 0) {//???????????????
            Toast.makeText(this, "??????????????????????????????", Toast.LENGTH_SHORT).show();
//            view.findViewById(R.id.ll_smart_refresh_nodata).setVisibility(View.VISIBLE);
//            linearLayout.setVisibility(View.VISIBLE);
//            refreshLayout.setVisibility(View.GONE);

        }
//        if (curpage > 0) {//????????????
            getMoreData();
//        }
//        if (curpage == 0) {//?????????,??????
//            initData();
//        }
    }

    //???????????????,????????????
    private void initData() {//???????????????????????????1-8
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

    //??????????????????
    private void getMoreData() {//??????????????????????????????????????????????????????????????????8?????????
        total = SmartRefreshDatas.name.length;
        for (int j=stdList.size(); j < total; j++) {
            if (j == total) {//??????????????????
                Toast.makeText(this, "?????????????????????", Toast.LENGTH_SHORT).show();
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

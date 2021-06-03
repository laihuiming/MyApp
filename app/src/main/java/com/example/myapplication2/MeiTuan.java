package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.myapplication2.Adapter.MeiTuanAdapter;
import com.example.myapplication2.Bean.ItemBean;
import com.example.myapplication2.Data.Datas;

import java.util.ArrayList;
import java.util.List;

public class MeiTuan extends AppCompatActivity {

    private List<ItemBean> mData;
    private RecyclerView meituanview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mei_tuan);
        meituanview = this.findViewById(R.id.rv_meituan);
        meituanview.setLayoutManager(new LinearLayoutManager(MeiTuan.this));
        MeiTuanAdapter adapter = new MeiTuanAdapter(this,mData);
        meituanview.setAdapter(adapter);
        initData();
    }

    /**
     * 这个方法用于模拟数据
     */
    private void initData() {
        //List<DataBean>---->Adapter------->setAdapter--------->显示数据.
        //创建数据集合
        mData = new ArrayList<>();
        //创建模拟数据
        for (int i = 0; i < Datas.icons.length; i++) {
            //创建数据对象
            ItemBean data = new ItemBean();
            data.icon = Datas.icons[i];
            data.title = "我是第 " + i + "个条目";
            //添加到集合里头
            mData.add(data);
        }
    }
}
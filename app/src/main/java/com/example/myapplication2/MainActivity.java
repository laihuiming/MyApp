package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.myapplication2.Adapter.MainAdapter;
import com.example.myapplication2.Bean.ItemBean;
import com.example.myapplication2.Bean.MainBean;
import com.example.myapplication2.Data.Datas;
import com.example.myapplication2.Data.MainDatas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView mList;
    private List<ItemBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        mList = this.findViewById(R.id.recycle_view);

        //RecycleView需要设置样式，其实就是设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器来控制
        mList.setLayoutManager(layoutManager);
        //创建适配器
        MainAdapter adapter = new MainAdapter(mData);
        //设置到RecycleView里头
        mList.setAdapter(adapter);
        //准备数据
        /**
         * 模拟模拟数据
         */
        initData();
    }

    /**
     * 这个方法用于模拟数据
     */
    private void initData() {
        //List<DataBea>---->Adapter------->setAdapter--------->显示数据.
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
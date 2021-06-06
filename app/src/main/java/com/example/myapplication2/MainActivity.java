package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
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
    private RecyclerView mainList;
    private List<MainBean> mainBeans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainList = this.findViewById(R.id.recycle_view);
        mainList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        List<MainBean> mainBeans = this.initmainData();
        MainAdapter adapter = new MainAdapter(MainActivity.this,mainBeans);

        mainList.setAdapter(adapter);
    }
    /**
     * 这个方法用于模拟数据
     */
    private List<MainBean> initmainData() {
        //List<MainBean>---->Adapter------->setAdapter--------->显示数据.
        //创建数据集合
        List<MainBean> mainBeans = new ArrayList<>();
        //创建模拟数据
        for (int i = 0; i < MainDatas.titles.length; i++) {
            //创建数据对象
            MainBean data = new MainBean();
            data.title = MainDatas.titles[i];
            //添加到集合里头
            mainBeans.add(data);

        }
        return  mainBeans;
    }

}
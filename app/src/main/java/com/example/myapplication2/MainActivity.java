package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private List<MainBean> MainBeans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainList = this.findViewById(R.id.recycle_view);
        mainList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        MainAdapter adapter = new MainAdapter(MainBeans);
        mainList.setAdapter(adapter);

    }

}
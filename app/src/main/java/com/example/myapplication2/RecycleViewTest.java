package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.myapplication2.Adapter.RecyclerViewAdapter;
import com.example.myapplication2.Bean.RecycleViewBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Route(path = "/app/RecycleViewTest")
public class RecycleViewTest extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<RecycleViewBean.RecyclerViewDataBean.RecycleViewDatasBean> arrayList
            = new ArrayList<RecycleViewBean.RecyclerViewDataBean.RecycleViewDatasBean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_test);
        initView();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BaseUrl)//获取url
                .addConverterFactory(GsonConverterFactory.create())//Gson转换工具
                .build();
        RecycleViewInterface recycleViewInterface = retrofit.create(RecycleViewInterface.class);//拿到接口
        Call<RecycleViewBean> call = recycleViewInterface.loadArticle();//获取首页文章列表
        call.enqueue(new Callback<RecycleViewBean>() {
            @Override
            public void onResponse(Call<RecycleViewBean> call, Response<RecycleViewBean> response) {
                RecycleViewBean recycleViewBean = response.body();//
                arrayList.addAll(recycleViewBean.getData().getDatas());
                recyclerViewAdapter.refresh(arrayList);
            }

            @Override
            public void onFailure(Call<RecycleViewBean> call, Throwable t) {

            }
        });

    }

    private void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);//查找recyclerview控件
        LinearLayoutManager manager = new LinearLayoutManager(this);//创建线性布局管理器
        manager.setOrientation(LinearLayoutManager.VERTICAL);//添加垂直布局
        recyclerView.setLayoutManager(manager);//将线性布局管理器添加到recyclerview中
        recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(),arrayList);//实例化适配器
        recyclerView.setAdapter(recyclerViewAdapter);//添加适配器
    }
}
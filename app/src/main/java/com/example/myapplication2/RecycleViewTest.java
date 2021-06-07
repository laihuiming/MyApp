package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication2.Adapter.RecyclerViewAdapter;
import com.example.myapplication2.Bean.DataDTO;
import com.example.myapplication2.Bean.RecycleViewBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecycleViewTest extends AppCompatActivity {
    private List<DataDTO> arrayList = new ArrayList<DataDTO>();
    private String url="https://www.wanandroid.com/banner/json";
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_test);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RecycleViewInterface recycleViewInterface = retrofit.create(RecycleViewInterface.class);//拿到接口
        Call<RecycleViewBean> call = RecycleViewInterface.getUrl(url);
        call.enqueue(new Callback<RecycleViewBean>() {
            @Override
            public void onResponse(Call<RecycleViewBean> call, Response<RecycleViewBean> response) {
                RecycleViewBean recycleViewBean = response.body();//
                arrayList.addAll(recycleViewBean.getData());
                recyclerViewAdapter.refresh(arrayList);
            }

            @Override
            public void onFailure(Call<RecycleViewBean> call, Throwable t) {

            }
        });
    }
}
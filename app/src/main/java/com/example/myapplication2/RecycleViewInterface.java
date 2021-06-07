package com.example.myapplication2;

import com.example.myapplication2.Bean.RecycleViewBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RecycleViewInterface {
    @GET
    static Call<RecycleViewBean> getUrl(@Url String url) {
        return null;
    }
}

package com.example.myapplication2;

import com.example.myapplication2.Bean.RecycleViewBean;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RecycleViewInterface {
//    @GET("/article/list/0/json")
//    Call<RecycleViewBean> getCall();

    /**
     * 首页文章
     * @param
     * @return
     */
    @GET("/article/list/0/json")
    Call<RecycleViewBean> loadArticle();
}

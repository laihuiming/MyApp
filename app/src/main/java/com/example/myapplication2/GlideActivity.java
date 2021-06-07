package com.example.myapplication2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GlideActivity extends AppCompatActivity {


    @BindView(R.id.bt_glide)
    Button btGlide;
    @BindView(R.id.iv_glide)
    ImageView ivGlide;
    @BindView(R.id.bt_glide_gif)
    Button btGlideGif;
    @BindView(R.id.iv_glide_gif)
    ImageView ivGlideGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);

    }

    //    @OnClick(R.id.bt_glide)
//    public void onClick() {
//        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
//        Glide.with(this)
//                .load(url)
//                .placeholder(R.mipmap.loading)
//                .error(R.mipmap.loadingerror)
//                .into(ivGlide);
//    }
//
//    @OnClick(R.id.bt_glide_gif)
//    public void onClick2() {
//        String url = "http://p1.pstatp.com/large/166200019850062839d3";
//        Glide.with(this)
//                .load(url)
//                .placeholder(R.mipmap.loading)
//                .error(R.mipmap.loadingerror)
//                .into(ivGlideGif);
//    }
    @OnClick({R.id.bt_glide, R.id.bt_glide_gif})
    public void onClick1(View view) {
        switch (view.getId()) {
            case R.id.bt_glide:
                String url1 = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
                Glide.with(this)
                        .load(url1)
                        .placeholder(R.mipmap.loading)
                        .error(R.mipmap.loadingerror)
                        .into(ivGlide);
                break;
            case R.id.bt_glide_gif:
                String url2 = "http://p1.pstatp.com/large/166200019850062839d3";
                Glide.with(this)
                        .load(url2)
                        .placeholder(R.mipmap.loading)
                        .error(R.mipmap.loadingerror)
                        .into(ivGlideGif);
                break;
        }
    }
}
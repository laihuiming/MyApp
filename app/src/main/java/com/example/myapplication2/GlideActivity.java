package com.example.myapplication2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GlideActivity extends AppCompatActivity {


    @BindView(R.id.bt_glide)
    Button btGlide;
    @BindView(R.id.iv_glide)
    ImageView ivGlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bt_glide)
    public void onClick() {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        Glide.with(this)
                .load(url)
                .placeholder(R.mipmap.loading)
                .error(R.mipmap.loadingerror)
                .into(ivGlide);
    }
}
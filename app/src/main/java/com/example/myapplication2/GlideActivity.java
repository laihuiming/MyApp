package com.example.myapplication2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;

public class GlideActivity extends AppCompatActivity {


    @BindView(R.id.bt_jiazai1)
    Button btJiazai1;
    @BindView(R.id.iv_glide_1)
    ImageView ivGlide1;
    @BindView(R.id.bt_jiazai21)
    Button btJiazai21;
    @BindView(R.id.iv_glide_21)
    ImageView ivGlide21;
    @BindView(R.id.bt_jiazai22)
    Button btJiazai22;
    @BindView(R.id.iv_glide_22)
    ImageView ivGlide22;
    @BindView(R.id.bt_jiazai23)
    Button btJiazai23;
    @BindView(R.id.iv_glide_23)
    ImageView ivGlide23;
    @BindView(R.id.bt_jiazai24)
    Button btJiazai24;
    @BindView(R.id.iv_glide_24)
    ImageView ivGlide24;
    @BindView(R.id.bt_jiazai3)
    Button btJiazai3;
    @BindView(R.id.iv_glide_3)
    ImageView ivGlide3;
    @BindView(R.id.bt_jiazai4)
    Button btJiazai4;
    @BindView(R.id.iv_glide_4)
    ImageView ivGlide4;
    @BindView(R.id.bt_jiazai5)
    Button btJiazai5;
    @BindView(R.id.iv_glide_5)
    ImageView ivGlide5;
    @BindView(R.id.bt_jiazai6)
    Button btJiazai6;
    @BindView(R.id.iv_glide_6)
    ImageView ivGlide6;
    @BindView(R.id.bt_jiazai7)
    Button btJiazai7;
    @BindView(R.id.iv_glide_7)
    ImageView ivGlide7;
    @BindView(R.id.bt_jiazai8)
    Button btJiazai8;
    @BindView(R.id.iv_glide_8)
    ImageView ivGlide8;
    @BindView(R.id.bt_jiazai9)
    Button btJiazai9;
    @BindView(R.id.iv_glide_9)
    ImageView ivGlide9;
    @BindView(R.id.bt_jiazai10)
    Button btJiazai10;
    @BindView(R.id.iv_glide_10)
    ImageView ivGlide10;
    @BindView(R.id.bt_jiazai11_1)
    Button btJiazai111;
    @BindView(R.id.iv_glide_11_1)
    ImageView ivGlide111;
    @BindView(R.id.bt_jiazai11_2)
    Button btJiazai112;
    @BindView(R.id.iv_glide_11_2)
    ImageView ivGlide112;
    @BindView(R.id.bt_jiazai12)
    Button btJiazai12;
    @BindView(R.id.iv_glide_12)
    ImageView ivGlide12;
    @BindView(R.id.bt_jiazai13_1)
    Button btJiazai131;
    @BindView(R.id.iv_glide_13)
    ImageView ivGlide13;
    @BindView(R.id.bt_jiazai13_2)
    Button btJiazai132;
    @BindView(R.id.iv_glide_13_2)
    ImageView ivGlide132;
    @BindView(R.id.bt_jiazai14_1)
    Button btJiazai141;
    @BindView(R.id.iv_glide_14_1)
    ImageView ivGlide141;
    @BindView(R.id.bt_jiazai14_2)
    Button btJiazai142;
    @BindView(R.id.iv_glide_14_2)
    ImageView ivGlide142;
    @BindView(R.id.bt_jiazai14_3)
    Button btJiazai143;
    @BindView(R.id.iv_glide_14_3)
    ImageView ivGlide143;
    @BindView(R.id.bt_jiazai14_4_1)
    Button btJiazai1441;
    @BindView(R.id.iv_glide_14_4_1)
    ImageView ivGlide1441;
    @BindView(R.id.bt_jiazai14_4_2)
    Button btJiazai1442;
    @BindView(R.id.iv_glide_14_4_2)
    ImageView ivGlide1442;
    @BindView(R.id.bt_jiazai14_4_3)
    Button btJiazai1443;
    @BindView(R.id.iv_glide_14_4_3)
    ImageView ivGlide1443;
    private String url2 = "http://p1.pstatp.com/large/166200019850062839d3";
    private String url1 = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bt_jiazai1, R.id.iv_glide_1, R.id.bt_jiazai21, R.id.iv_glide_21, R.id.bt_jiazai22, R.id.iv_glide_22, R.id.bt_jiazai23, R.id.iv_glide_23, R.id.bt_jiazai24, R.id.iv_glide_24, R.id.bt_jiazai3, R.id.iv_glide_3, R.id.bt_jiazai4, R.id.iv_glide_4, R.id.bt_jiazai5, R.id.iv_glide_5, R.id.bt_jiazai6, R.id.iv_glide_6, R.id.bt_jiazai7, R.id.iv_glide_7, R.id.bt_jiazai8, R.id.iv_glide_8, R.id.bt_jiazai9, R.id.iv_glide_9, R.id.bt_jiazai10, R.id.iv_glide_10, R.id.bt_jiazai11_1, R.id.iv_glide_11_1, R.id.bt_jiazai11_2, R.id.iv_glide_11_2, R.id.bt_jiazai12, R.id.iv_glide_12, R.id.bt_jiazai13_1, R.id.iv_glide_13, R.id.bt_jiazai13_2, R.id.iv_glide_13_2, R.id.bt_jiazai14_1, R.id.iv_glide_14_1, R.id.bt_jiazai14_2, R.id.iv_glide_14_2, R.id.bt_jiazai14_3, R.id.iv_glide_14_3, R.id.bt_jiazai14_4_1, R.id.iv_glide_14_4_1, R.id.bt_jiazai14_4_2, R.id.iv_glide_14_4_2, R.id.bt_jiazai14_4_3, R.id.iv_glide_14_4_3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_jiazai1:
                Glide.with(this)
                        .load(url1)
                        .into(ivGlide1);
                break;
            case R.id.bt_jiazai21:
                File file = new File(getExternalCacheDir()+"/cha.png");
                Glide.with(this)
                        .load(file)
                        .into(ivGlide21);
                break;
            case R.id.bt_jiazai22:
                int resource = R.drawable.ic_launcher_background;
                Glide.with(this)
                        .load(resource)
                        .into(ivGlide22);
                break;
            case R.id.bt_jiazai23:
                Toast.makeText(this, "没有二进制流图片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_jiazai24:
//                Uri imageuri = getImageUri();
                Toast.makeText(this, "没有uri对象", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_jiazai3:
                Glide.with(this)
                        .load(url1)
                        .placeholder(R.mipmap.loading)
                        .into(ivGlide3);
                break;
            case R.id.bt_jiazai4:
                Glide.with(this)
                        .load(url1)
                        .placeholder(R.mipmap.loading)
                        .error(R.mipmap.loadingerror)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(ivGlide4);
                break;
            case R.id.bt_jiazai5:
                Glide.with(this)
                        .asBitmap()
                        .load(url2)
                        .placeholder(R.mipmap.loading)
                        .into(ivGlide5);
                break;
            case R.id.bt_jiazai6:
                Glide.with(this)
                        .asGif()
                        .load(url2)
                        .placeholder(R.mipmap.loading)
                        .error(R.mipmap.loadingerror)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(ivGlide6);
                break;
            case R.id.bt_jiazai7:
                Glide.with(this)
                        .load(url1)
                        .placeholder(R.mipmap.loading)
                        .error(R.mipmap.loadingerror)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .override(100,100)
                        .into(ivGlide7);
                break;
            case R.id.bt_jiazai8:
                Glide.with(this)
                        .load(url1)
                        .skipMemoryCache(true)
                        .into(ivGlide8);
                break;
            case R.id.bt_jiazai9:
                Glide.with(this)
                        .load(url1)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(ivGlide9);
                break;
            case R.id.bt_jiazai10:
//                Glide.with(this)
//                        .load(url1)
//                        .
                Toast.makeText(this, "未找到带有token的url", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_jiazai11_1:

                break;
            case R.id.bt_jiazai11_2:
                break;

            case R.id.bt_jiazai12:
                break;

            case R.id.bt_jiazai13_1:
                break;

            case R.id.bt_jiazai13_2:
                break;

                //禁止图形变换功能
            case R.id.bt_jiazai14_1:
                Glide.with(this)
                        .load(url1)
                        .dontTransform()
                        .into(ivGlide141);
                break;

            case R.id.bt_jiazai14_2:

                break;

            case R.id.bt_jiazai14_3:
                break;

                //虚化
            case R.id.bt_jiazai14_4_1:
                Glide.with(this).
                        load(url1).
                        apply(RequestOptions.bitmapTransform(new BlurTransformation()))
                        .into(ivGlide1441);
                break;

                //黑白
            case R.id.bt_jiazai14_4_2:
                Glide.with(this)
                        .load(url1)
                        .apply(RequestOptions.bitmapTransform(new GrayscaleTransformation()))
                        .into(ivGlide1442);
                break;

            case R.id.bt_jiazai14_4_3:
                Glide.with(this)
                        .load(url1)
//                        .apply(RequestOptions.bitmapTransform(new BlurTransformation(),new GrayscaleTransformation()))
                        .into(ivGlide1443);

                break;

        }
    }
}
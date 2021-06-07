package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt_meituan)
    Button btMeituan;
    @BindView(R.id.bt_recycleview)
    Button btRecycleview;
    @BindView(R.id.glide)
    Button glide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_meituan, R.id.bt_recycleview, R.id.glide})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_meituan:
                Intent intent = new Intent(MainActivity.this,MeiTuan.class);
                startActivity(intent);
                break;
            case R.id.bt_recycleview:
                Intent intent2 = new Intent(MainActivity.this, RecyclerView.class);
                startActivity(intent2);
                break;
            case R.id.glide:
                Intent intent3 = new Intent(MainActivity.this,GlideActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
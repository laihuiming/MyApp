package com.example.myapplication2.ARoutDemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.myapplication2.R;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/app/RouteTestTwoActivity")
public class RouteTestTwoActivity extends AppCompatActivity {

    @BindView(R.id.tv_arouter_two1)
    TextView tvArouterTwo1;
    @BindView(R.id.tv_arouter_two2)
    TextView tvArouterTwo2;
    @Autowired(name = "key1")
    public String name1;

    @Autowired(name = "key2")
    public String name2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_test_two);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
        tvArouterTwo1.setText(name1);
        tvArouterTwo2.setText(name2);
    }
}
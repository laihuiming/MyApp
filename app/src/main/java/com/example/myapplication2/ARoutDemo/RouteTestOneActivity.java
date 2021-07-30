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

@Route(path = "/app/RouteTestOneActivity")
public class RouteTestOneActivity extends AppCompatActivity {
    @BindView(R.id.tv_route_one1)
    TextView tvRouteOne1;
    @Autowired(name = "key1")
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_test_one);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
        tvRouteOne1.setText(name);
    }
}
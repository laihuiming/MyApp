package com.example.myapplication2.ARoutDemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.myapplication2.Bean.StudentBean;
import com.example.myapplication2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/app/ARoutDemoActivity")
public class ARoutDemoActivity extends AppCompatActivity {

    @BindView(R.id.bt_goto_a_router_test1)
    Button btGotoARouterTest1;
    @BindView(R.id.bt_goto_a_router_test2)
    Button btGotoARouterTest2;
    @BindView(R.id.bt_goto_a_router_test3)
    Button btGotoARouterTest3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_rout_demo);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.bt_goto_a_router_test1, R.id.bt_goto_a_router_test2,R.id.bt_goto_a_router_test3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_goto_a_router_test1:
                ARouter.getInstance().build("/app/RouteTestOneActivity")
                        .withString("key1", "轻描淡写")
                        .navigation();
                break;
            case R.id.bt_goto_a_router_test2:
                ARouter.getInstance().build("/app/RouteTestTwoActivity")
                        .withString("key1", "小桥流水")
                        .withString("key2", "幼鸟指南")
                        .navigation();
                break;
            case R.id.bt_goto_a_router_test3:
                StudentBean student = new StudentBean(001,"张三",23);
                ARouter.getInstance().build("/app/RouteTestThirdActivity")
                        .withObject("key1",student)
                        .withInt("key2",9999)
                        .navigation();

        }
    }
}
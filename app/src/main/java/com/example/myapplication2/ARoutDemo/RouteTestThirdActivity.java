package com.example.myapplication2.ARoutDemo;

import android.app.Person;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.myapplication2.Bean.StudentBean;
import com.example.myapplication2.R;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/app/RouteTestThirdActivity")
public class RouteTestThirdActivity extends AppCompatActivity {

    private static final String TAG = "RouteTestThirdActivity";
    @BindView(R.id.tv_router_id)
    TextView tvRouterId;
    @BindView(R.id.tv_router_name)
    TextView tvRouterName;
    @BindView(R.id.tv_router_age)
    TextView tvRouterAge;

    @Autowired(name = "key1")
    public StudentBean student;
    @Autowired(name = "key2")
    public int money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_test_third);
        ButterKnife.bind(this);
        initData();
        initView();

    }

    private void initView() {
        Log.d(TAG,""+money);
        tvRouterId.setText(""+student.getId());
        tvRouterName.setText(student.getName());
        tvRouterAge.setText(""+student.getAge());
    }

    private void initData() {
        ARouter.getInstance().inject(this);
        int id = student.getId();
        String name = student.getName();
        int age = student.getAge();
        Log.e(TAG,"id="+id+",name="+name+",age="+age);
    }


}
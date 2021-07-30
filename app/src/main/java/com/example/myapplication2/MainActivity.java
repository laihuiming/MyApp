package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.myapplication2.ARoutDemo.ARoutDemoActivity;
import com.example.myapplication2.ActivityResultTest.ActivityResultTestActivity;
import com.example.myapplication2.DrawerLayout.DrawerLayoutTestActivity;
import com.example.myapplication2.EventBusTest.EBFirstActivity;
import com.example.myapplication2.ViewPager.ViewPagerActivity;
import com.example.myapplication2.VisibilityTest.VisibilityTestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "app/MainActivity")
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt_meituan)
    Button btMeituan;
    @BindView(R.id.bt_recycleview)
    Button btRecycleview;
    @BindView(R.id.glide)
    Button glide;
    @BindView(R.id.activity_result)
    Button activityResult;
    @BindView(R.id.activity_visibility_test)
    Button activityVisibilityTest;
    @BindView(R.id.activity_viewpager_test)
    Button activityViewpagerTest;
    @BindView(R.id.activity_drawerlayout_text)
    Button activityDrawerlayoutText;
    @BindView(R.id.activity_eb_first)
    Button activityEbFirst;
    @BindView(R.id.activity_arouter_test)
    Button activityArouterTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.bt_meituan, R.id.bt_recycleview, R.id.glide, R.id.activity_result,
            R.id.activity_visibility_test, R.id.activity_viewpager_test, R.id.activity_drawerlayout_text,
            R.id.activity_eb_first,R.id.activity_arouter_test})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_meituan:
                Intent intent = new Intent(MainActivity.this, MeiTuan.class);
                startActivity(intent);
                break;
            case R.id.bt_recycleview:
                Intent intent2 = new Intent(MainActivity.this, RecycleViewTest.class);
                startActivity(intent2);
                break;
            case R.id.glide:
                Intent intent3 = new Intent(MainActivity.this, GlideActivity.class);
                startActivity(intent3);
                break;
            case R.id.activity_result:
                Intent intent4 = new Intent(MainActivity.this, ActivityResultTestActivity.class);
                startActivity(intent4);
                break;
            case R.id.activity_visibility_test:
                startActivity(new Intent(MainActivity.this, VisibilityTestActivity.class));
                break;
            case R.id.activity_viewpager_test:
                startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
                break;
            case R.id.activity_drawerlayout_text:
                startActivity(new Intent(MainActivity.this, DrawerLayoutTestActivity.class));
                break;
            case R.id.activity_eb_first:
                startActivity(new Intent(this, EBFirstActivity.class));
            case R.id.activity_arouter_test:
                ARouter.getInstance().build("/app/ARoutDemoActivity").navigation();
//                startActivity(new Intent(this, ARoutDemoActivity.class));
        }
    }

}
package com.example.myapplication2.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.myapplication2.R;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrawerLayoutTestActivity extends AppCompatActivity {
    @BindView(R.id.open_drawerlayout)
    TextView openDrawerlayout;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.left_drawerlayout)
    LinearLayout leftDrawerlayout;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.tv_begin_time)
    TextView tvBeginTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout_test);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.open_drawerlayout,R.id.tv_begin_time, R.id.tv_end_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open_drawerlayout:
                drawerlayout.openDrawer(Gravity.RIGHT);
                break;
            case R.id.tv_begin_time:
                TimePickerView pvTime = new TimePickerBuilder(DrawerLayoutTestActivity.this, new TimePickerView() {
                    public void onTimeSelect(Date date, View v) {

                    }
                });
                break;
            case R.id.tv_end_time:

                break;
        }
    }
}

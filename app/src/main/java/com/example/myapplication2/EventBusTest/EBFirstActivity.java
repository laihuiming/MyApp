package com.example.myapplication2.EventBusTest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//EventBusTest
public class EBFirstActivity extends AppCompatActivity {
    private static final String TAG = "EBFirstActivity";
    @BindView(R.id.bt_ebtest)
    Button btEbtest;
    @BindView(R.id.tv_ebtest)
    TextView tvEbtest;
    @BindView(R.id.bt_goto_third)
    Button btGotoThird;
    @BindView(R.id.tv_eb_nm_test1)
    TextView tvEbNmTest1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus_first);
        ButterKnife.bind(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "FirstActivity开始");

    }

    @OnClick({R.id.bt_ebtest, R.id.tv_ebtest, R.id.bt_goto_third})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_ebtest:
                startActivity(new Intent(this, EBSecondActivity.class));
                break;
            case R.id.bt_goto_third:
                startActivity(new Intent(this, EBThirdActivity.class));
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Event(MessageWrap messageWrap) {
        tvEbtest.setText(messageWrap.getMessage());
        Log.e(TAG, "FirstActivity接收了粘性事件");
    }

    @Subscribe(threadMode = ThreadMode.MAIN,priority = 1)
    public void NMEvent(MessageWrap messageWrap) {
        tvEbNmTest1.setText(messageWrap.getMessage());
        Log.e(TAG, "FirstActivity接收了普通事件");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "FirstActivity停止了");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "FirstActivity销毁了");
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}

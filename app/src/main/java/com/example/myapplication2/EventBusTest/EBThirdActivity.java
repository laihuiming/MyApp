package com.example.myapplication2.EventBusTest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EBThirdActivity extends AppCompatActivity {

    private static final String TAG = "EBThirdActivity";
    @BindView(R.id.bt_eb3)
    Button btEb3;
    @BindView(R.id.tv_eb_test3)
    TextView tvEbTest3;
    @BindView(R.id.tv_eb_nm_test3)
    TextView tvEbNmTest3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_b_third);
        ButterKnife.bind(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);//注册
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @OnClick(R.id.bt_eb3)
    public void onClick(View view) {
        if (view.getId() == R.id.bt_eb3) {
            startActivity(new Intent(this, EBFirstActivity.class));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Event(MessageWrap messageWrap) {
        tvEbTest3.setText(messageWrap.getMessage());
        Log.e(TAG, "ThirdActivity接收到了粘性事件");
    }

    @Subscribe(threadMode = ThreadMode.MAIN,priority = 2)
    public void NMEvent(MessageWrap messageWrap) {
        tvEbNmTest3.setText(messageWrap.getMessage());
        Log.e(TAG,"ThirdActivity接收到了普通事件");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "ThirdActivity停止了");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "ThirdActivity销毁了");
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);//注销
        }
    }
}
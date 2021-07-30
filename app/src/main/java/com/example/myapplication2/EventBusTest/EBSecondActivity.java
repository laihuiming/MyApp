package com.example.myapplication2.EventBusTest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EBSecondActivity extends AppCompatActivity {

    private static final String TAG = "EBSecondActivity";
    @BindView(R.id.bt_eb2)
    Button btEb2;
    @BindView(R.id.bt_eb_nm)
    Button btEbNm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_b_second);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bt_eb2,R.id.bt_eb_nm})
    public void onClick(View view) {
        if (view.getId() == R.id.bt_eb2) {
            EventBus.getDefault().postSticky(new MessageWrap("伱嬞嗰der，纨暨灞鹰佐，艸nm"));
            Log.e(TAG,"执行了粘性事件的发送");
            Toast.makeText(this, "执行了粘性事件的发送", Toast.LENGTH_SHORT).show();
            finish();
        }else
        if (view.getId() == R.id.bt_eb_nm){
            EventBus.getDefault().post(new MessageWrap("这是普通事件cccccccc"));
            Log.e(TAG,"执行了普通事件的发送");
            Toast.makeText(this, "执行了普通事件的发送", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"SecondActivity停止了");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"SecondActivity销毁了");
    }
}
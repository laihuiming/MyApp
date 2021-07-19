package com.example.myapplication2.ActivityResultTest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.myapplication2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends Activity {
    @BindView(R.id.bt_first_activity_finish)
    Button btFirstActivityFinish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
    }

    public static final int code = 0;
    @OnClick(R.id.bt_first_activity_finish)
    public void onClick() {
        setResult(code);
        finish();
    }
}

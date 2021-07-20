package com.example.myapplication2.ActivityResultTest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.myapplication2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThirdActivity extends Activity {
    private static final String TAG = "ThirdActivity";
    @BindView(R.id.bt_third_activity_finish)
    Button btThirdActivityFinish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);
    }

    public static final int code = 2;
    @OnClick(R.id.bt_third_activity_finish)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_third_activity_finish:
                setResult(code);
                finish();
                Log.d(TAG,"Finish ThirdActivity -----------");
        }
    }
}

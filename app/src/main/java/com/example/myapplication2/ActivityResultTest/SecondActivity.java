package com.example.myapplication2.ActivityResultTest;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.myapplication2.R;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}

package com.example.myapplication2;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }

}

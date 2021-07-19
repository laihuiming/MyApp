package com.example.myapplication2.ActivityResultTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityResultTestActivity extends FragmentActivity implements View.OnClickListener {
    @BindView(R.id.fragment)
    FrameLayout fragment;
    @BindView(R.id.fist_fragment)
    ImageView fistFragment;
    @BindView(R.id.fl_1)
    LinearLayout fl1;
    @BindView(R.id.second_fragment)
    ImageView secondFragment;
    @BindView(R.id.fl_2)
    LinearLayout fl2;
    @BindView(R.id.fl_3)
    LinearLayout fl3;
    private  FirstFragment mFirstFragment;
    private SecondFragment mSecondFragment;
    private ThirdFragment mThirdFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_result_test_activity);
        ButterKnife.bind(this);

        initview();
    }

    private void initview() {
        mFirstFragment = new FirstFragment();
        mSecondFragment = new SecondFragment();
        mThirdFragment = new ThirdFragment();
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.fragment,mFirstFragment);
        transaction.add(R.id.fragment,mSecondFragment);
        transaction.add(R.id.fragment,mThirdFragment);
        transaction.show(mFirstFragment).hide(mThirdFragment).hide(mThirdFragment);
        transaction.commit();
        showFragment(0);
    }

    int mcode = 0;
    private void showFragment(int code) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.fragment,mFirstFragment);
        transaction.add(R.id.fragment,mSecondFragment);
        transaction.add(R.id.fragment,mThirdFragment);
        mcode = code;
        switch (code) {
            case 0:
                transaction.show(mFirstFragment).hide(mSecondFragment).hide(mThirdFragment).commit();
                break;
            case 1:
                transaction.show(mSecondFragment).hide(mFirstFragment).hide(mThirdFragment).commit();
                break;
            case 2:
                transaction.show(mThirdFragment).hide(mFirstFragment).hide(mSecondFragment).commit();
                break;
        }
    }

    @OnClick({R.id.fl_1, R.id.fl_2, R.id.fl_3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fl_1:
                showFragment(0);
                break;
            case R.id.fl_2:
                showFragment(1);
                break;
            case R.id.fl_3:
                showFragment(2);
                break;
        }
    }

    //获取返回值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}

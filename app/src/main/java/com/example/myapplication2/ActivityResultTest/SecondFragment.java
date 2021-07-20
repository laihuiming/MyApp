package com.example.myapplication2.ActivityResultTest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondFragment extends Fragment {
    private static final String TAG = "SecondFragment";
    @BindView(R.id.iv_first)
    ImageView ivFirst;
    @BindView(R.id.fg_second)
    Button fgSecond;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.fg_second)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fg_second:
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
                Log.d(TAG, "Go To SecondActivity---------------");
        }
    }
}

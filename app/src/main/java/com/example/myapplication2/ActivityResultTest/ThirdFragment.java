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

public class ThirdFragment extends Fragment {
    private static final String TAG = "ThirdFragment";
    @BindView(R.id.iv_first)
    ImageView ivFirst;
    @BindView(R.id.fg_third)
    Button fgThird;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.fg_third)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fg_third:
                Intent intent = new Intent(getActivity(), ThirdActivity.class);
                startActivity(intent);
                Log.d(TAG,"Go To ThirdActivity------------");
        }
    }
}

package com.example.myapplication2.ActivityResultTest.TableLayoutTest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.myapplication2.ActivityResultTest.SecondFragment;
import com.example.myapplication2.R;

import butterknife.ButterKnife;

public class TableOneFragment extends Fragment {
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tab_one,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    public static TableOneFragment getInstance(String type) {
        TableOneFragment frament = new TableOneFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SecondFragment.FRAMENTTYPE, type);
        frament.setArguments(bundle);
        return frament;
    }
}

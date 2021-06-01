package com.example.myapplication2.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private View view;
    @NonNull
    @Override
    public MainAdapter.MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MainHolder extends RecyclerView.ViewHolder{

        public MainHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

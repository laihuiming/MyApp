package com.example.myapplication2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.Bean.MainBean;
import com.example.myapplication2.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private View view;
    private List<MainBean> MainBeans;
    public MainAdapter(List<MainBean> mainBeans){
        MainBeans = mainBeans;
    }



    public class MainHolder extends RecyclerView.ViewHolder{
        public TextView mtitle;

        public MainHolder(@NonNull View itemView) {
            super(itemView);
            mtitle = itemView.findViewById(R.id.tv_main_title);
        }

        public void setData(MainBean mainBean){
            mtitle.setText(mainBean.title);
        }
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main,parent,false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainHolder holder, int position) {
        holder.mtitle.setText("recycleview");
    }

    @Override
    public int getItemCount() {
        return 10;
    }


}

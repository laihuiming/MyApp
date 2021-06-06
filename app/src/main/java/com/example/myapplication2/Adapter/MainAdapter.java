package com.example.myapplication2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.Bean.MainBean;
import com.example.myapplication2.Data.MainDatas;
import com.example.myapplication2.GlideActivity;
import com.example.myapplication2.MainActivity;
import com.example.myapplication2.MeiTuan;
import com.example.myapplication2.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private View view;
    public List<MainBean> mainBeans;
    private Context context;
    public MainAdapter(Context context,List<MainBean> mainBeanList){
        this.context = context;
        this.mainBeans = mainBeanList;
    }

//    public MainAdapter(List<MainBean> mainBeans) {
//        MainBeans = mainBeans;
//    }

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
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent,false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {
        holder.setData(mainBeans.get(position));
//        holder.mtitle.setText("RecycleViewTest");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(context, MeiTuan.class);
                context.startActivity(intent);
            }
        });
//        holder.mtitle.setText("GlideText");
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent = new Intent(context, GlideActivity.class);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        if (mainBeans != null){
            return mainBeans.size();
        }
        return 5;
    }


}

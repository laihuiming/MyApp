package com.example.myapplication2.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication2.Bean.DataDTO;
import com.example.myapplication2.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder> {

    private List<DataDTO> dataDTOS = new ArrayList<>();
    private Context context;


    private RecyclerViewAdapter(Context context, List<DataDTO> dataDTOS) {
        this.context = context;
        this.dataDTOS = dataDTOS;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_recycleview, null);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        holder.tvTitle.setText(dataDTOS.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return dataDTOS.size();
    }

    public void refresh(List<DataDTO> arrayList) {
        //适配器刷新
        this.dataDTOS.addAll(arrayList);
        notifyDataSetChanged();
    }


    class RecycleViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_recycleview_title);
        }

        public TextView getTvTitle() {
            return tvTitle;
        }
    }
}

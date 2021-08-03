package com.example.myapplication2.SmartRefreshLayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.Bean.SmartRefreshBean;
import com.example.myapplication2.R;

import java.util.List;

public class SmartRefreshAadapter extends RecyclerView.Adapter<SmartRefreshAadapter.InnerHolder> {

    private Context context;
    private List<SmartRefreshBean> pageList;
    private TextView textView;
    private String page;

    public SmartRefreshAadapter(Context context, List<SmartRefreshBean> pageList){
        this.context = context;
        this.pageList = pageList;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        View view = View.inflate(parent.getContext(), R.layout.item_smart_refresh,null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(pageList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page = pageList.get(position).page;
                Toast.makeText(context, ""+page, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pageList.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_smart_title);
        }

        public void setData(SmartRefreshBean smartRefreshBean){
            textView.setText(smartRefreshBean.title);

        }
    }
}

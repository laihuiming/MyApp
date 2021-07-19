package com.example.myapplication2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication2.Bean.RecycleViewBean;
import com.example.myapplication2.R;
import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder> {


    private static final int TYPE_HEADER = 0;

    private static final int TYPE_NORMAL = 1;

    private Context context;

    private List<RecycleViewBean.RecyclerViewDataBean.RecycleViewDatasBean> mArticleList
            = new ArrayList<>();

    private View mHeaderView;
    public RecyclerViewAdapter(Context context,List<RecycleViewBean.RecyclerViewDataBean.RecycleViewDatasBean> datasBeans){
        this.context = context;
        this.mArticleList = datasBeans;
    }

    //绑定recyclerview
    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycleview,parent ,false);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        holder.title.setText(mArticleList.get(position).getTitle());
    }

    //返回条目个数
    @Override
    public int getItemCount() {
        return mArticleList.size();
    }

    public void refresh(List<RecycleViewBean.RecyclerViewDataBean.RecycleViewDatasBean> list){
        //这个方法是我们自己手写的，主要是对适配器的一个刷新
        this.mArticleList.addAll(list);
        notifyDataSetChanged();
    }

    public class RecycleViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_recycleview_title);
        }
    }
}

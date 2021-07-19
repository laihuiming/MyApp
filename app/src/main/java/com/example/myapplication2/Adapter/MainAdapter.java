package com.example.myapplication2.Adapter;


import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication2.Bean.ItemBean;
import com.example.myapplication2.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.InnerHolder>{

    public final List<ItemBean> mData;
    private View view;

    public MainAdapter(List<ItemBean> data){
        this.mData = data;
    }
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = View.inflate(parent.getContext(), R.layout.item_recycleview, null);
        return new InnerHolder(view);
    }
    /**
     * 这个方法是用于绑定holder的，一般用来设置数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //绑定数据
        holder.setData(mData.get(position));
    }

    /**
     * 返回条目的个数
     * @return
     */
    @Override
    public int getItemCount() {
        //返回条目个数
        if (mData != null){
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private ImageView mIcon;


        public InnerHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_main_title);
//            mIcon = itemView.findViewById(R.id.list_view_icon);
        }

        /**
         * 设置数据
         * @param itemBean
         */
        public void setData(ItemBean itemBean) {
            mTitle.setText(itemBean.title);
//            mIcon.setImageResource(itemBean.icon);
        }


    }
}

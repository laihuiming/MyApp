package com.example.myapplication2.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.Bean.ItemBean;
import com.example.myapplication2.R;

import java.util.Date;
import java.util.List;

public class MeiTuanAdapter extends RecyclerView.Adapter<MeiTuanAdapter.MeituanHolder> {
    public final List<ItemBean> mData;
    private View view;

    public MeiTuanAdapter(List<ItemBean> data){
        this.mData = data;
    }
    @NonNull
    @Override
    public MeituanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = View.inflate(parent.getContext(), R.layout.item_mei_tuan, null);
        return new MeituanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeituanHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData != null){
            return mData.size();
        }
        return 0;
    }

    public class MeituanHolder extends RecyclerView.ViewHolder{

        private TextView mTitle;
        private ImageView mIcon;

        public MeituanHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.iv_title);
            mIcon = itemView.findViewById(R.id.tv_icom);
        }

        public void setData(ItemBean itembean){
            mTitle.setText(itembean.title);
            mIcon.setImageResource(itembean.icon);
        }
    }


}

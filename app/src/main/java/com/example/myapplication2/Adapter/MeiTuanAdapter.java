package com.example.myapplication2.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.Bean.ItemBean;
import com.example.myapplication2.R;

import java.util.List;

public class MeiTuanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<ItemBean> mData;
    private View view;
    private Context context;
    public static final int TYPE_ONE = 0;
    public static final int TYPE_TWO = 1;
    public static final int TYPE_TREE = 2;

    @Override
    public int getItemViewType(int position) {
        ItemBean bean = mData.get(position);
        if (bean.icon == TYPE_ONE){
            return TYPE_ONE;
        }else if (bean.icon == TYPE_TWO){
            return TYPE_TWO;
        }else{
            return TYPE_TREE;
        }
    }

    public MeiTuanAdapter(Context context,List<ItemBean> data){
        this.context = context;
        this.mData = data;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            view = View.inflate(parent.getContext(), R.layout.item_meituan_type1, null);
            return new ItemOneViewHolder(view);
        }else return null;
//        }else if (viewType == TYPE_TWO){
//            view = View.inflate(parent.getContext(),R.layout.item_meituan_type2,null);
//            return new ItemTwoViewHolder(view);
//        }else{
//            view = View.inflate(parent.getContext(),R.layout.item_meituan_type3,null);
//            return new ItemTreeViewHolder(view);
//        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemOneViewHolder)holder).setData(mData.get(position));
//        ((ItemTwoViewHolder)holder).setData(mData.get(position));
//        ((ItemTreeViewHolder)holder).setData(mData.get(position));
    }

//    @Override
//    public void onBindViewHolder(@NonNull MeituanHolder holder, int position) {
//        holder.setData(mData.get(position));
//    }

    @Override
    public int getItemCount() {
        if (mData != null){
            return mData.size();
        }
        return 10;
    }

//    public class MeituanHolder extends RecyclerView.ViewHolder{
//
//        private TextView mTitle;
//        private ImageView mIcon;
//
//        public MeituanHolder(@NonNull View itemView) {
//            super(itemView);
//            mTitle = itemView.findViewById(R.id.iv_title);
//            mIcon = itemView.findViewById(R.id.tv_icon);
//        }
//
//        public void setData(ItemBean itembean){
//            mTitle.setText(itembean.title);
//            mIcon.setImageResource(itembean.icon);
//        }
//    }
    public class ItemOneViewHolder extends RecyclerView.ViewHolder{
        private TextView mTitle;
        private ImageView mIcon;
        public ItemOneViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.iv_title);
            mIcon = itemView.findViewById(R.id.tv_icon);
        }

        public void setData(ItemBean itembean){
            mTitle.setText(itembean.title);
            mIcon.setImageResource(itembean.icon);
        }
    }

//    public class ItemTwoViewHolder extends RecyclerView.ViewHolder{
//
//        private TextView mTitle2;
//        private ImageView mIcon2;
//        public ItemTwoViewHolder(@NonNull View itemView) {
//            super(itemView);
////            mTitle2 = itemView.findViewById(R.id.iv_title);
//            mIcon2 = itemView.findViewById(R.id.iv_type2);
//        }
//
//        public void setData(ItemBean itembean){
////            mTitle2.setText(itembean.title);
//            mIcon2.setImageResource(itembean.icon);
//        }
//    }

//    public class ItemTreeViewHolder extends RecyclerView.ViewHolder{
//
//        private TextView mTitle3;
//        private ImageView mIcon3;
//        public ItemTreeViewHolder(@NonNull View itemView) {
//            super(itemView);
//            mTitle3 = itemView.findViewById(R.id.tv_type3);
//            mIcon3 = itemView.findViewById(R.id.iv_type3);
//        }
//
//        public void setData(ItemBean itembean){
//            mTitle3.setText(itembean.title);
//            mIcon3.setImageResource(itembean.icon);
//        }
//    }

}

package com.example.myapplication2.Adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.myapplication2.Bean.MainBean;
import com.example.myapplication2.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.InnerHolder>{

    public final List<MainBean> mData;
    private View view;
    private Context context;
    public String path;
    private TextView mTitle;
    private TextView mPath;
    public MainAdapter(Context context,List<MainBean> data){
        this.context = context;
        this.mData = data;
    }
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = View.inflate(parent.getContext(), R.layout.item_main, null);
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                path = mData.get(position).path;
                ARouter.getInstance().build(path).navigation();
            }
        });
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

//        private ImageView mIcon;


        public InnerHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_main_title);
            mPath = itemView.findViewById(R.id.tv_main_path);
//            mIcon = itemView.findViewById(R.id.list_view_icon);
        }

        /**
         * 设置数据
         * @param mainBean
         * @return
         */
        public void setData(MainBean mainBean) {
            mTitle.setText(mainBean.title);
            mPath.setText(mainBean.path);
//            ARouter.getInstance().build(mPath.toString()).navigation();
//            mIcon.setImageResource(itemBean.icon);
        }


    }
}

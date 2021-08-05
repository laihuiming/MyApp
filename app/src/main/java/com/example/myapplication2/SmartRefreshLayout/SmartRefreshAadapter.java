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

import butterknife.BindView;
import butterknife.ButterKnife;

public class SmartRefreshAadapter extends RecyclerView.Adapter<SmartRefreshAadapter.InnerHolder> {

//    @BindView(R.id.tv_smart_id)
    private TextView tvSmartId;
//    @BindView(R.id.tv_smart_name)
    private TextView tvSmartName;
//    @BindView(R.id.tv_smart_age)
    private TextView tvSmartAge;
    private Context context;
    private List<SmartRefreshBean> studentList;

    public SmartRefreshAadapter(Context context, List<SmartRefreshBean> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        View view = View.inflate(parent.getContext(), R.layout.item_smart_refresh, null);
//        ButterKnife.bind(this,view);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(studentList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "id："+studentList.get(position).id+"，姓名："+studentList.get(position).name+",年龄："+studentList.get(position).age, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (studentList != null) {
            return studentList.size();
        }
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(View itemView) {
            super(itemView);
             tvSmartId = itemView.findViewById(R.id.tv_smart_id);
             tvSmartName = itemView.findViewById(R.id.tv_smart_name);
             tvSmartAge = itemView.findViewById(R.id.tv_smart_age);
        }

        public void setData(SmartRefreshBean smartRefreshBean) {
            tvSmartId.setText(smartRefreshBean.id);
            tvSmartName.setText(smartRefreshBean.name);
            tvSmartAge.setText(smartRefreshBean.age);
        }
    }
}

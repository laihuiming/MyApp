package com.example.myapplication2.DrawerLayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;

import com.example.myapplication2.Bean.CityBean;
import com.example.myapplication2.R;
import com.example.myapplication2.util.GetJsonDataUtil;
import com.example.myapplication2.util.TimeFormat;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.myapplication2.util.TimeFormat.Y_M_D_SHOW;
import static com.example.myapplication2.util.TimeFormat.getCurrTime;
@Route(path = "/app/DrawerLayoutTestActivity")
public class DrawerLayoutTestActivity extends AppCompatActivity {
    @BindView(R.id.open_drawerlayout)
    TextView openDrawerlayout;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.left_drawerlayout)
    LinearLayout leftDrawerlayout;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.tv_begin_time)
    TextView tvBeginTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    //时间显示格式
    String beginTime = getCurrTime(Y_M_D_SHOW);
    String endTime = getCurrTime(Y_M_D_SHOW);
    private ArrayList<CityBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Thread thread;
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;
    private boolean isLoaded = false;
    //    long longbeginTime;
    //    long longendTime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout_test);
        ButterKnife.bind(this);
        initJsonData();
        mHandler.sendEmptyMessage(MSG_LOAD_DATA);
    }

    private void initJsonData() {
        String cityData = new GetJsonDataUtil().getJson(this,"city_code.json");
        ArrayList<CityBean> jsonBean = parse(cityData);
        options1Items = jsonBean;
        for (int i = 0;i < jsonBean.size();i++){//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//省的城市列表
            ArrayList<ArrayList<String>> Province_List = new ArrayList<>();//该省的所有地区列表
            for (int j = 0; j < jsonBean.get(i).getCityList().size();j++){
                String CityName = jsonBean.get(i).getCityList().get(j);
                CityList.add(CityName);
            }
            options2Items.add(CityList);
        }
        mHandler.sendEmptyMessage(MSG_LOAD_SUCCESS);
    }

    private ArrayList<CityBean> parse(String result) {//Gson解析
        ArrayList<CityBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length();i++){
                CityBean entity = gson.fromJson(data.optJSONObject(i).toString(),CityBean.class);
                detail.add(entity);
            }
        }catch (Exception e){
            e.printStackTrace();
            mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }

    //判断地址数据是否获取成功
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread==null){//如果已创建就不再重新创建子线程了
                        Log.i("addr","地址数据开始解析");
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // 写子线程中的操作,解析省市区数据
                                initJsonData();
                            }
                        });
                        thread.start();
                    }
                    break;

                case MSG_LOAD_SUCCESS:
                    Log.i("addr","地址数据获取成功");
                    isLoaded = true;
                    break;

                case MSG_LOAD_FAILED:
                    Log.i("addr","地址数据获取失败");
                    break;

            }
        }
    };

    @OnClick({R.id.open_drawerlayout, R.id.tv_begin_time, R.id.tv_end_time, R.id.tv_address})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open_drawerlayout:
                drawerlayout.openDrawer(Gravity.RIGHT);
                break;
            case R.id.tv_begin_time:
                TimePickerView pvBeginTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
//                        tvBeginTime.setText((int) date.getTime());
//                        longbeginTime = date.getTime();
//                        tvBeginTime.setText(beginTime);
                        tvBeginTime.setText(TimeFormat.dateToTime(date, Y_M_D_SHOW));
                    }
                }).setType(new boolean[]{true, true, true, false, false, false})//分别对应年月日时分秒，默认全部显示
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setSubmitColor(R.color.white)//确定按钮文字颜色
                        .setCancelColor(R.color.white)//取消按钮文字颜色
                        .build();

                pvBeginTime.show();
                break;
            case R.id.tv_end_time:
                TimePickerView pvEndTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
//                        tvEndTime.setText((int) date.getTime());
//                        longendTime = date.getTime();
//                        tvEndTime.setText(endTime);
                        tvEndTime.setText(TimeFormat.dateToTime(date, Y_M_D_SHOW));
                    }
                }).setType(new boolean[]{true, true, true, false, false, false})//分别对应年月日时分秒，默认全部显示
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setSubmitColor(R.color.white)//确定按钮文字颜色
                        .setCancelColor(R.color.white)//取消按钮文字颜色
                        .build();
                pvEndTime.show();
                break;
            case R.id.tv_address:
                OptionsPickerView opAddress = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        String Province = options1Items.get(options1).getProvince();
                        String City = options2Items.get(options1).get(options2);
                        tvAddress.setText(Province+City);
                    }
                })
                        .build();
                opAddress.setPicker(options1Items,options2Items);
                opAddress.show();
        }
    }

}
